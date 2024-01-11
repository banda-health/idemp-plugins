-- Currently, visits should have one clinical details & chief complaint encounter
-- However, they can have multiple vitals encounters
-- For each visit with a chief complaint or clinical details observation on the wrong encounter:
--    * Create a new encounter if one doesn't exist on those visits
--    * Move the observation to that encounter
-- For each visit with a vitals observation on the wrong encounter:
--    * Create a new encounter with the same created/updated timestamp as the currently-assigned encounter
--    * Move the observations to the newly-created encounters

/**********************************************************************************************************************/
-- Get the list of visits that have an observation of a type assigned to the wrong encounter of a type
/**********************************************************************************************************************/
SELECT
	bh_visit_id
INTO TEMP TABLE
	tmp_visit_ids_to_fix
FROM
	bh_visit v
WHERE
	EXISTS(
		SELECT
			1
		FROM
			bh_encounter e
				JOIN bh_observation o
				ON e.bh_encounter_id = o.bh_encounter_id
				JOIN ad_field f
				ON o.ad_field_id = f.ad_field_id
				JOIN ad_tab t
				ON f.ad_tab_id = t.ad_tab_id
				JOIN ad_window w
				ON t.ad_window_id = w.ad_window_id
				JOIN bh_encounter_type_window etw
				ON w.ad_window_id = etw.ad_window_id
		WHERE
			e.bh_visit_id = v.bh_visit_id
			AND e.bh_encounter_type != etw.bh_encounter_type
	);

-- Get the encounters table ready for any that we need to create
DROP TABLE IF EXISTS tmp_bh_encounter;
CREATE TEMP TABLE tmp_bh_encounter
(
	ad_client_id        numeric(10) NOT NULL,
	ad_org_id           numeric(10) NOT NULL,
	bh_encounter_id     serial      NOT NULL,
	bh_encounter_type   varchar(22) NOT NULL,
	bh_encounter_uu     uuid DEFAULT uuid_generate_v4(),
	bh_visit_id         numeric(10) NOT NULL,
	created             timestamp   NOT NULL,
	createdby           numeric(10) NOT NULL,
-- 	isactive          char DEFAULT 'Y'::bpchar NOT NULL,
	updated             timestamp   NOT NULL,
	updatedby           numeric(10) NOT NULL,
	old_bh_encounter_id numeric(10) NULL
);

SELECT
	SETVAL(
		'tmp_bh_encounter_bh_encounter_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'BH_Encounter'
			LIMIT 1
		)::INT,
		FALSE
	);

/**********************************************************************************************************************/
-- Visits can (currently) only have one chief-complaint and one clinical-details encounter
-- For visits that have either clinical-details observations, but no clinical-details encounter, or chief-complaint
-- observations, but no chief-complaint encounter, add the appropriate encounters
/**********************************************************************************************************************/
-- Get visits that don't have a chief-complaint encounter, but have chief-complaint observations
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id, created, createdby, updated, updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	'C',
	bh_visit_id,
	created,
	createdby,
	updated,
	updatedby
FROM
	(
		SELECT
			e.ad_client_id,
			e.ad_org_id,
			e.bh_visit_id,
			e.created,
			e.createdby,
			e.updated,
			e.updatedby
		FROM
			bh_visit v
				JOIN bh_encounter e
				ON e.bh_visit_id = v.bh_visit_id
				JOIN (
				SELECT
					e.bh_visit_id,
					MAX(bh_encounter_id) AS bh_encounter_id
				FROM
					bh_encounter e
						JOIN tmp_visit_ids_to_fix vitf
						ON e.bh_visit_id = vitf.bh_visit_id
				GROUP BY e.bh_visit_id
			) max_e
				ON e.bh_encounter_id = max_e.bh_encounter_id
		WHERE
			NOT EXISTS(
				SELECT 1 FROM bh_encounter e2 WHERE e2.bh_encounter_type = 'C' AND e2.bh_visit_id = v.bh_visit_id
			)
	) e
WHERE
	EXISTS(
		SELECT
			1
		FROM
			bh_encounter e2
				JOIN bh_observation o
				ON e2.bh_encounter_id = o.bh_encounter_id
				JOIN ad_field f
				ON o.ad_field_id = f.ad_field_id
				JOIN ad_tab t
				ON f.ad_tab_id = t.ad_tab_id
				JOIN ad_window w
				ON t.ad_window_id = w.ad_window_id
				JOIN bh_encounter_type_window etw
				ON w.ad_window_id = etw.ad_window_id
		WHERE
			e.bh_visit_id = e2.bh_visit_id
			AND etw.bh_encounter_type = 'C'
	);

-- Get visits that don't have a clinical-details encounter, but have clinical-details observations
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id, created, createdby, updated, updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	'D',
	bh_visit_id,
	created,
	createdby,
	updated,
	updatedby
FROM
	(
		SELECT
			e.ad_client_id,
			e.ad_org_id,
			e.bh_visit_id,
			e.created,
			e.createdby,
			e.updated,
			e.updatedby
		FROM
			bh_visit v
				JOIN bh_encounter e
				ON e.bh_visit_id = v.bh_visit_id
				JOIN (
				SELECT
					e.bh_visit_id,
					MAX(bh_encounter_id) AS bh_encounter_id
				FROM
					bh_encounter e
						JOIN tmp_visit_ids_to_fix vitf
						ON e.bh_visit_id = vitf.bh_visit_id
				GROUP BY e.bh_visit_id
			) max_e
				ON e.bh_encounter_id = max_e.bh_encounter_id
		WHERE
			NOT EXISTS(
				SELECT 1 FROM bh_encounter e2 WHERE e2.bh_encounter_type = 'D' AND e2.bh_visit_id = v.bh_visit_id
			)
	) e
WHERE
	EXISTS(
		SELECT
			1
		FROM
			bh_encounter e2
				JOIN bh_observation o
				ON e2.bh_encounter_id = o.bh_encounter_id
				JOIN ad_field f
				ON o.ad_field_id = f.ad_field_id
				JOIN ad_tab t
				ON f.ad_tab_id = t.ad_tab_id
				JOIN ad_window w
				ON t.ad_window_id = w.ad_window_id
				JOIN bh_encounter_type_window etw
				ON w.ad_window_id = etw.ad_window_id
		WHERE
			e.bh_visit_id = e2.bh_visit_id
			AND etw.bh_encounter_type = 'D'
	);

/**********************************************************************************************************************/
-- For all visits with incorrectly assigned vitals observations, just duplicate the encounter currently assigned
-- and change it's encounter type
/**********************************************************************************************************************/
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id, created, createdby, updated, updatedby,
	                  old_bh_encounter_id)
SELECT
	e.ad_client_id,
	e.ad_org_id,
	'V',
	e.bh_visit_id,
	e.created,
	e.createdby,
	e.updated,
	e.updatedby,
	e.bh_encounter_id
FROM
	bh_encounter e
		JOIN tmp_visit_ids_to_fix vitf
		ON e.bh_visit_id = vitf.bh_visit_id
WHERE
	bh_encounter_type != 'V'
	AND EXISTS(
		SELECT
			1
		FROM
			bh_observation o
				JOIN ad_field f
				ON o.ad_field_id = f.ad_field_id
				JOIN ad_tab t
				ON f.ad_tab_id = t.ad_tab_id
				JOIN ad_window w
				ON t.ad_window_id = w.ad_window_id
				JOIN bh_encounter_type_window etw
				ON w.ad_window_id = etw.ad_window_id
		WHERE
			o.bh_encounter_id = e.bh_encounter_id
			AND etw.bh_encounter_type = 'V'
	);

/**********************************************************************************************************************/
-- Insert the encounters
/**********************************************************************************************************************/
INSERT INTO
	bh_encounter (ad_client_id, ad_org_id, bh_encounter_id, bh_encounter_type, bh_encounter_uu, bh_visit_id, created,
	              createdby, updated, updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	bh_encounter_id,
	bh_encounter_type,
	bh_encounter_uu,
	bh_visit_id,
	created,
	createdby,
	updated,
	updatedby
FROM
	tmp_bh_encounter;

/**********************************************************************************************************************/
-- Re-map the wrongly-assigned observations to the encounters with matching types
/**********************************************************************************************************************/
-- Re-map the clinical-detail observations
UPDATE bh_observation o
SET
	bh_encounter_id = e_r.bh_encounter_id
FROM
	bh_encounter e_w
		CROSS JOIN ad_field f
		JOIN ad_tab t
		ON f.ad_tab_id = t.ad_tab_id
		JOIN ad_window w
		ON t.ad_window_id = w.ad_window_id
		JOIN bh_encounter_type_window etw
		ON w.ad_window_id = etw.ad_window_id
		JOIN tmp_visit_ids_to_fix vitf
		ON e_w.bh_visit_id = vitf.bh_visit_id
		JOIN bh_encounter e_r
		ON e_r.bh_visit_id = e_w.bh_visit_id AND e_r.bh_encounter_type = 'D'
WHERE
	o.bh_encounter_id = e_w.bh_encounter_id
	AND o.ad_field_id = f.ad_field_id
	AND etw.bh_encounter_type = 'D'
	AND e_w.bh_encounter_type != 'D';

-- Re-map the chief-complaint observations
UPDATE bh_observation o
SET
	bh_encounter_id = e_r.bh_encounter_id
FROM
	bh_encounter e_w
		CROSS JOIN ad_field f
		JOIN ad_tab t
		ON f.ad_tab_id = t.ad_tab_id
		JOIN ad_window w
		ON t.ad_window_id = w.ad_window_id
		JOIN bh_encounter_type_window etw
		ON w.ad_window_id = etw.ad_window_id
		JOIN tmp_visit_ids_to_fix vitf
		ON e_w.bh_visit_id = vitf.bh_visit_id
		JOIN bh_encounter e_r
		ON e_r.bh_visit_id = e_w.bh_visit_id AND e_r.bh_encounter_type = 'C'
WHERE
	o.bh_encounter_id = e_w.bh_encounter_id
	AND o.ad_field_id = f.ad_field_id
	AND etw.bh_encounter_type = 'C'
	AND e_w.bh_encounter_type != 'C';

--Re-map the vitals observations
UPDATE bh_observation o
SET
	bh_encounter_id = te.bh_encounter_id
FROM
	bh_encounter e
		CROSS JOIN ad_field f
		JOIN ad_tab t
		ON f.ad_tab_id = t.ad_tab_id
		JOIN ad_window w
		ON t.ad_window_id = w.ad_window_id
		JOIN bh_encounter_type_window etw
		ON w.ad_window_id = etw.ad_window_id AND etw.bh_encounter_type = 'V'
		JOIN tmp_bh_encounter te
		ON e.bh_encounter_id = te.old_bh_encounter_id
WHERE
	o.bh_encounter_id = e.bh_encounter_id
	AND o.ad_field_id = f.ad_field_id
	AND e.bh_encounter_type != 'V';

/**********************************************************************************************************************/
-- All done!
/**********************************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202312141058_GO-2864.sql')
FROM
	dual;
