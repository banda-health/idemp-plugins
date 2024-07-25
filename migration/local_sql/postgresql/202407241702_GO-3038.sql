-- 1. Get a list of c_bpartners with no bh_patientid.
-- 2. For every c_bpartner, fetch the preceeding record with a bh_patientid. Use (c_bpartner_id - 1) to fetch the previous record.
-- 3. Increment the bh_patientid by 1 and assign to the current c_bpartner
-- 4. Inactivate the c_bpartner.

DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TEMP TABLE tmp_c_bpartner
(
	c_bpartner_id    numeric(10)                             NOT NULL,
	ad_client_id     numeric(10)                             NOT NULL,
	previous_c_bpartner_id numeric(10)			   NOT NULL,
	previous_bh_patientid  numeric(1000)			   NOT NULL,
	current_bh_patientid   numeric(1000)			   NOT NULL
);

-- find the entries and store in a temp table
INSERT INTO 
	tmp_c_bpartner(c_bpartner_id, ad_client_id, previous_c_bpartner_id, previous_bh_patientid, current_bh_patientid) 
SELECT 
	c.c_bpartner_id,
	c.ad_client_id,
	p.c_bpartner_id as previous_c_bpartner_id,
	cast(p.bh_patientid as numeric) as previous_bh_patientid,
	cast(p.bh_patientid as numeric) + 1 as current_bh_patientid
FROM c_bpartner c
INNER JOIN c_bp_group cg ON c.c_bp_group_id = cg.c_bp_group_id AND cg.value = 'Patients'
INNER JOIN c_bpartner p ON c.c_bpartner_id - 1 = p.c_bpartner_id
WHERE c.bh_patientid is null
AND c.c_bpartner_id > 999999
AND c.iscustomer = 'Y';	

-- Update with the correct bh_patientId and deactivate the patient.
UPDATE c_bpartner c
SET bh_patientid = tmp.current_bh_patientid, isActive = 'N'
FROM tmp_c_bpartner tmp WHERE c.c_bpartner_id = tmp.c_bpartner_id

SELECT
	register_migration_script('202407241702_GO-3038.sql')
FROM
	dual;
