/**********************************************************************************************************************/
-- This query needs to get the most-recent (in case of duplicates) deleted observations from ad_changelog and
-- reconstruct them. Also, we need any associated encounters, then to re-add everything to the appropriate visits.
-- This will be done in the following steps:
--
-- Re-construct the deleted observation and any associated deleted encounter
-- Remove observations and encounters we don't need to work with
-- Determine if an existing encounter for the visit can be used
-- For all visits that didn't have a new encounter, create the encounters as-is (no need for even new IDs)
-- Now add the former observations
/**********************************************************************************************************************/

CREATE EXTENSION IF NOT EXISTS tablefunc;

/**********************************************************************************************************************/
-- Re-construct the deleted observation and any associated deleted encounter
/**********************************************************************************************************************/
DROP TABLE IF EXISTS tmp_bh_observation;
CREATE TEMP TABLE tmp_bh_observation
(
	ad_client_id      numeric(10)                     NOT NULL,
	ad_field_id       numeric(10)                     NOT NULL,
	ad_org_id         numeric(10)                     NOT NULL,
	bh_encounter_id   numeric(10)                     NOT NULL,
	bh_observation_id numeric(10)                     NOT NULL,
	bh_observation_uu varchar(36) DEFAULT NULL::character varying,
	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10)                     NOT NULL,
	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10)                     NOT NULL,
	bh_value          text                            NOT NULL
);

DROP TABLE IF EXISTS tmp_bh_encounter;
CREATE TEMP TABLE tmp_bh_encounter
(
	ad_client_id      numeric(10)                     NOT NULL,
	ad_org_id         numeric(10)                     NOT NULL,
	bh_encounter_id   numeric(10)                     NOT NULL,
	bh_encounter_type varchar(22)                     NOT NULL,
	bh_encounter_uu   varchar(36) DEFAULT NULL::character varying,
	bh_visit_id       numeric(10)                     NOT NULL,
	created           timestamp   DEFAULT NOW()       NOT NULL,
	createdby         numeric(10)                     NOT NULL,
	isactive          char        DEFAULT 'Y'::bpchar NOT NULL,
	updated           timestamp   DEFAULT NOW()       NOT NULL,
	updatedby         numeric(10)                     NOT NULL,
	bh_encounter_date timestamp                       NOT NULL
);

INSERT INTO
	tmp_bh_observation (ad_client_id, ad_field_id, ad_org_id, bh_encounter_id, bh_observation_id, bh_observation_uu,
	                    created, createdby, isactive, updated, updatedby, bh_value)
SELECT
	ad_client_id::numeric,
	ad_field_id::numeric,
	ad_org_id::numeric,
	bh_encounter_id::numeric,
	bh_observation_id::numeric,
	bh_observation_uu::varchar,
	created::timestamp,
	createdby::numeric,
	CASE WHEN IsActive = 'true' THEN 'Y' ELSE 'N' END,
	updated::timestamp,
	updatedby::numeric,
	bh_value::text
FROM
	crosstab($$
SELECT
	cl.record_id,
	c.columnname,
	cl.oldvalue
FROM
	ad_changelog cl
		JOIN ad_column c
		ON cl.ad_column_id = c.ad_column_id AND c.columnname != 'BH_Observation_ID'
WHERE
	cl.ad_table_id = (
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'a9673172-25a0-496f-a40f-e53550e2de24'
	)
	AND cl.record_id IN (
		SELECT
			record_id
		FROM
			ad_changelog
		WHERE
			ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '8ebdaf96-dd00-454c-b5d0-37b58280ca76'
			)
			AND newvalue = 'NULL'
			AND oldvalue != E'History: \n\nPhysical Exam: \n\nTreatment: '
	)
	AND newvalue = 'NULL'
	AND cl.updated > '2024-10-09'
ORDER BY
	1, 2$$) AS (BH_Observation_ID numeric, AD_Client_ID varchar, AD_Field_ID varchar, AD_Org_ID varchar,
	            BH_Encounter_ID varchar, BH_Observation_UU varchar, BH_Value varchar, Created varchar, CreatedBy varchar,
	            IsActive varchar, Updated varchar, UpdatedBy varchar);

-- Based on the encounter IDs, see if those were deleted, too
INSERT INTO
	tmp_bh_encounter (ad_client_id, ad_org_id, bh_encounter_id, bh_encounter_type, bh_encounter_uu, bh_visit_id, created,
	                  createdby, isactive, updated, updatedby, bh_encounter_date)
SELECT
	ad_client_id::numeric,
	ad_org_id::numeric,
	bh_encounter_id::numeric,
	bh_encounter_type::varchar,
	bh_encounter_uu::varchar,
	bh_visit_id::numeric,
	created::timestamp,
	createdby::numeric,
	CASE WHEN IsActive = 'true' THEN 'Y' ELSE 'N' END,
	updated::timestamp,
	updatedby::numeric,
	bh_encounter_date::timestamp
FROM
	crosstab($$
SELECT
	cl.record_id,
	c.columnname,
	cl.oldvalue
FROM
	ad_changelog cl
		JOIN ad_column c
		ON cl.ad_column_id = c.ad_column_id AND c.columnname != 'BH_Encounter_ID'
WHERE
	cl.ad_table_id = (
		-- The BH_Encounter table
		SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '755aac0f-8697-4520-ba42-08ad092299cd'
	)
	AND cl.record_id IN (
		SELECT
			record_id
		FROM
			ad_changelog
		WHERE
			newvalue = 'NULL'
			-- BH_Encounter_ID on BH_Encounter
			AND ad_column_id = (
				SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '789d31ed-4461-4500-86c1-5fcad6eb7bb2'
			)
	)
	AND cl.record_id IN (
		SELECT
			bh_encounter_id
		FROM
			tmp_bh_observation
	)
	AND newvalue = 'NULL'
	AND cl.updated > '2024-10-09'
ORDER BY
	1, 2;$$) AS (BH_Encounter_ID numeric, AD_Client_ID varchar, AD_Org_ID varchar, BH_Encounter_Date varchar,
	             BH_Encounter_Type varchar, BH_Encounter_UU varchar, BH_Visit_ID varchar, Created varchar,
	             CreatedBy varchar, IsActive varchar, Updated varchar, UpdatedBy varchar);

/**********************************************************************************************************************/
-- Remove observations and encounters we don't need to work with
/**********************************************************************************************************************/
-- Remove duplicated observations and encounters and take the most-recent observations and the encounters they were assigned to
DELETE
FROM
	tmp_bh_observation to_old
	USING tmp_bh_observation to_new
WHERE
	to_old.bh_observation_uu = to_new.bh_observation_uu
	AND to_old.created < to_new.created;
-- Remove observations that still exist
DELETE
FROM
	tmp_bh_observation tbo
	USING bh_observation o
WHERE
	tbo.bh_observation_uu = o.bh_observation_uu;
DELETE
FROM
	tmp_bh_encounter
WHERE
	bh_encounter_id NOT IN (
		SELECT
			bh_encounter_id
		FROM
			tmp_bh_observation
	);

-- Remove observations and encounters for visits that don't exist anymore (i.e. were deleted)
DELETE
FROM
	tmp_bh_observation
WHERE
	bh_encounter_id IN (
		SELECT
			te.bh_encounter_id
		FROM
			tmp_bh_encounter te
				LEFT JOIN bh_visit v
				ON te.bh_visit_id = v.bh_visit_id
		WHERE
			v.bh_visit_id IS NULL
	);
DELETE
FROM
	tmp_bh_encounter
WHERE
	bh_encounter_id IN (
		SELECT
			te.bh_encounter_id
		FROM
			tmp_bh_encounter te
				LEFT JOIN bh_visit v
				ON te.bh_visit_id = v.bh_visit_id
		WHERE
			v.bh_visit_id IS NULL
	);

/**********************************************************************************************************************/
-- Determine if an existing encounter for the visit can be used
/**********************************************************************************************************************/
DROP TABLE IF EXISTS tmp_map_temp_encounter_to_existing;
SELECT
	te.bh_encounter_id                              AS temp_encounter_id,
	COALESCE(e.bh_encounter_id, te.bh_encounter_id) AS encounter_id_to_use
INTO TEMP TABLE
	tmp_map_temp_encounter_to_existing
FROM
	tmp_bh_encounter te
		LEFT JOIN bh_encounter e
		ON te.bh_visit_id = e.bh_visit_id AND te.bh_encounter_type = e.bh_encounter_type;

-- Update the temp observations to use their new encounters
UPDATE tmp_bh_observation tbo
SET
	bh_encounter_id = mtete.encounter_id_to_use
FROM
	tmp_map_temp_encounter_to_existing mtete
WHERE
	tbo.bh_encounter_id = mtete.temp_encounter_id;

/**********************************************************************************************************************/
-- For all visits that didn't have a new encounter, create the encounters as-is (no need for even new IDs)
/**********************************************************************************************************************/
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
	tmp_bh_encounter
WHERE
	bh_encounter_id NOT IN (
		SELECT temp_encounter_id FROM tmp_map_temp_encounter_to_existing WHERE encounter_id_to_use != temp_encounter_id
	);

-- Remove observations that already exist for these encounters and fields
DELETE
FROM
	tmp_bh_observation tbo
	USING bh_observation o
WHERE
	tbo.bh_encounter_id = o.bh_encounter_id
	AND tbo.ad_field_id = o.ad_field_id;

/**********************************************************************************************************************/
-- Now add the former observations
/**********************************************************************************************************************/
INSERT INTO
	bh_observation (ad_client_id, ad_field_id, ad_org_id, bh_encounter_id, bh_observation_id, bh_observation_uu, created,
	                createdby, isactive, updated, updatedby, bh_value)
SELECT
	ad_client_id,
	ad_field_id,
	ad_org_id,
	bh_encounter_id,
	bh_observation_id,
	bh_observation_uu,
	created,
	createdby,
	isactive,
	updated,
	updatedby,
	bh_value
FROM
	tmp_bh_observation;

SELECT
	register_migration_script('202410172114_GO-3119.sql')
FROM
	dual;
