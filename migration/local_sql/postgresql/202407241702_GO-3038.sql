-- This file is meant to update the galmi db.
-- 1. Get a list of c_bpartners with no bh_patientid.
-- 2. For every c_bpartner, fetch the preceeding record with a bh_patientid. Use (c_bpartner_id - 1) to fetch the previous record.
-- 3. Increment the bh_patientid by 1 and assign to the current c_bpartner
-- 4. Inactivate the c_bpartner.

DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TEMP TABLE tmp_c_bpartner
(
	c_bpartner_uu  varchar(50)                       NOT NULL,
	bh_patientid   numeric(1000)			   NOT NULL
);

-- Use this query to retrieve patient uuids and the correct bh_patientid.

--INSERT INTO 
--	tmp_c_bpartner(c_bpartner_uu, bh_patientid) 
--SELECT 
--	c.c_bpartner_uu,
--	cast(p.bh_patientid as numeric) + 1 as bh_patientid
--FROM c_bpartner c
--INNER JOIN c_bp_group cg ON c.c_bp_group_id = cg.c_bp_group_id AND cg.value = 'Patients'
--INNER JOIN c_bpartner p ON c.c_bpartner_id - 1 = p.c_bpartner_id
--WHERE c.bh_patientid is null
--AND c.c_bpartner_id > 999999
--AND c.iscustomer = 'Y';

-- Manually populate the tmp_c_bpartner table.
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('491d7754-b555-4246-b3d7-67a9de29bafb', 1002263);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('57881a18-9ddb-4019-bb71-65159f1ee0f5', 1004710);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('251cda03-fa3b-4e96-b6ad-4baa49081160', 1016524);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('0b926689-46b2-4f68-9637-ce019610365a', 1010914);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('e8738404-5280-4f49-b3ec-b98f19c56984', 1008133);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('a2cb9919-c978-4487-a812-71bc325972cb', 1004149);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('26c0dff5-14e9-4592-be4e-854154720b5c', 1013845);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('ada4d27c-894b-42f8-882d-4235a8200f91', 1004161);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('cc9e617c-5a7e-4cc7-a225-5d1ce05c79af', 1115814);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('2abe54f9-e274-489d-99ac-dc188c678af9', 1120589);
INSERT INTO tmp_c_bpartner(c_bpartner_uu, bh_patientid) VALUES ('f5126280-f8b5-4126-924b-b73e110d191e', 1120597);	

-- Update with the correct bh_patientId and deactivate the patient.
UPDATE c_bpartner c
SET bh_patientid = tmp.bh_patientid, isActive = 'N'
FROM tmp_c_bpartner tmp WHERE c.c_bpartner_uu = tmp.c_bpartner_uu;

SELECT
	register_migration_script('202407241702_GO-3038.sql')
FROM
	dual;
