-- get the list of observations that are assigned to the wrong encounter
SELECT
	o.bh_observation_id,
	etw.bh_encounter_type AS correct_encounter_type,
	e.bh_encounter_type   AS wrong_encounter_type
INTO TEMP TABLE
	tmp_bh_observations
FROM
	bh_observation o
		JOIN bh_encounter e
		ON o.bh_encounter_id = e.bh_encounter_id
		JOIN ad_field f
		ON o.ad_field_id = f.ad_field_id
		JOIN ad_tab t
		ON f.ad_tab_id = t.ad_tab_id
		JOIN ad_window w
		ON t.ad_window_id = w.ad_window_id
		JOIN bh_encounter_type_window etw
		ON w.ad_window_id = etw.ad_window_id
WHERE
	e.bh_encounter_type != etw.bh_encounter_type;

-- Create encounters for visits that don't already have those and make everything the same as the current
CREATE TEMP TABLE tmp_bh_encounter
(
	ad_client_id      numeric(10) NOT NULL,
	ad_org_id         numeric(10) NOT NULL,
	bh_encounter_id   serial      NOT NULL,
	bh_encounter_type varchar(22) NOT NULL,
	bh_encounter_uu   varchar(36) DEFAULT uuid_generate_v4(),
	bh_visit_id       numeric(10) NOT NULL,
	created           timestamp   NOT NULL,
	createdby         numeric(10) NOT NULL,
	isactive          char        NOT NULL,
	updated           timestamp   NOT NULL,
	updatedby         numeric(10) NOT NULL,
	bh_encounter_date timestamp   NOT NULL
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

INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_type, bh_visit_id, created, createdby, isactive, updated,
	                  updatedby, bh_encounter_date)
SELECT
	e_b.ad_client_id,
	e_b.ad_org_id,
	otu.correct_encounter_type,
	e_b.bh_visit_id,
	e_b.created,
	e_b.createdby,
	e_b.isactive,
	e_b.updated,
	e_b.updatedby,
	e_b.bh_encounter_date
FROM
	tmp_bh_observations otu
		JOIN bh_observation o
		ON otu.bh_observation_id = o.bh_observation_id
		JOIN bh_encounter e_b
		ON o.bh_encounter_id = e_b.bh_encounter_id
		LEFT JOIN bh_encounter e_g
		ON e_b.bh_visit_id = e_g.bh_visit_id AND e_g.bh_encounter_type = otu.correct_encounter_type
WHERE
	e_g.bh_encounter_id IS NULL;

INSERT INTO
	bh_encounter (ad_client_id, ad_org_id, bh_encounter_id, bh_encounter_type, bh_encounter_uu, bh_visit_id, created,
	              createdby, isactive, updated, updatedby, bh_encounter_date)
SELECT
	ad_client_id,
	ad_org_id,
	bh_encounter_id,
	bh_encounter_type,
	bh_encounter_uu,
	bh_visit_id,
	created,
	createdby,
	isactive,
	updated,
	updatedby,
	bh_encounter_date
FROM
	tmp_bh_encounter;

-- Change the encounter ID for visits that already have the correct encounter
UPDATE bh_observation o
SET
	bh_encounter_id = e_g.bh_encounter_id
FROM
	tmp_bh_observations otu
		CROSS JOIN bh_encounter e_b
		JOIN bh_encounter e_g
		ON e_b.bh_visit_id = e_g.bh_visit_id AND e_g.bh_encounter_type = otu.correct_encounter_type
WHERE
	o.bh_observation_id = otu.bh_observation_id
	AND o.bh_encounter_id = e_b.bh_encounter_id;

SELECT
	register_migration_script('202411011221_GO-3096.sql')
FROM
	dual;
