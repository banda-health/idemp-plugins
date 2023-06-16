/******************************************************************************************/
-- This script cleans up the old roles that are either duplicated, not created correctly
-- (i.e. assigned the "Must Haves" and a default master role), aren't named correctly,
-- are weird on deactivated clients, or are just no longer used.
-- 1. Update role names that didn't get updated when the client's name was changed
-- 2. For all inactive clients, remove all role assignments
-- 3. Delete the master roles that we don't use anymore
-- 4. Work with existing roles, either adding new, updating weird,  or marking old for deletion
-- 5. Update role inclusions to be correct
-- 6. Map old roles to the new
-- 7. Delete old roles
-- 8. Ensure system admins have access to all default roles
-- 9. Rename some roles that didn't get renamed before
-- 10. Wrap up
/******************************************************************************************/

/******************************************************************************************/
-- 1. Update role names that didn't get updated when the client's name was changed
/******************************************************************************************/
UPDATE ad_role r
SET
	name = CASE
		       WHEN r.name LIKE 'AIC Litein Hospital%' THEN REPLACE(r.name, 'AIC Litein Hospital', c.name)
		       WHEN r.name LIKE 'Banda Health%' AND c.ad_client_uu = '71661e42-8a8b-4ec6-b9cf-e83b64aab24d'
			       THEN REPLACE(r.name, 'Banda Health', c.name)
		       WHEN r.name LIKE 'Church Army Medical Center%' AND c.ad_client_uu = 'ea7c2d2d-6e8b-4ea0-814f-59b69aef6cad'
			       THEN REPLACE(r.name, 'Church Army Medical Center', c.name)
		       WHEN r.name LIKE 'Church Army Medical Center%' AND c.ad_client_uu = '925ea941-be79-4c42-be95-6965b922a843'
			       THEN REPLACE(r.name, 'Church Army Medical Center', c.name)
		       WHEN r.name LIKE 'Church Road Medical Center%' THEN REPLACE(r.name, 'Church Road Medical Center', c.name)
		       WHEN r.name LIKE 'Faith Based Medical%' THEN REPLACE(r.name, 'Faith Based Medical', c.name)
		       WHEN r.name LIKE 'JoIynn Dental Services%' THEN REPLACE(r.name, 'JoIynn Dental Services', c.name)
		       WHEN r.name LIKE 'Royal Medical Clinic%' THEN REPLACE(r.name, 'Royal Medical Clinic', c.name)
		       WHEN r.name NOT LIKE c.name || '%' THEN c.name || ' ' || r.name
		       ELSE r.name END
FROM
	ad_client c
WHERE
	r.ad_client_id = c.ad_client_id
	AND r.name NOT LIKE c.name || '%'
	AND c.ad_client_id NOT IN (0, 11);

-- Create a table of default roles
DROP TABLE IF EXISTS tmp_default_roles;
SELECT
	c.ad_client_id,
	c.name || ' ' || r_m.name AS name,
	r.ad_role_id,
	r_m.ad_role_id            AS master_role_id
INTO TEMP TABLE
	tmp_default_roles
FROM
	ad_client c
		JOIN ad_role r_m
		ON r_m.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
		                      '097feff0-3aa6-41fe-bf76-936b03859846', '93365778-a2d9-433b-b962-87fb150db4fa',
		                      '09eb7fc8-9cc5-44b0-9d14-15258a066038', '98617c31-55ff-48f9-bd44-253ef323d960',
		                      'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', 'ae618e24-a47a-40cc-bb5c-8dca64d86daf',
		                      'ee008abc-2c16-4230-b48c-b1f5577ea270', 'c54253cf-c86b-4aaa-b472-ed8880635c62')
		AND c.ad_client_id NOT IN (0, 11)
		LEFT JOIN (
		SELECT ad_client_id, MIN(ad_role_id) AS ad_role_id, name FROM ad_role GROUP BY ad_client_id, name
	) r
		ON c.ad_client_id = r.ad_client_id AND r.name = c.name || ' ' || r_m.name;

/******************************************************************************************/
-- 2. For all inactive clients, remove all role assignments
/******************************************************************************************/
DELETE
FROM
	ad_user_roles
WHERE
		ad_client_id IN (
		SELECT
			ad_client_id
		FROM
			ad_client
		WHERE
			isactive = 'N'
	);

/******************************************************************************************/
-- 3. Delete the master roles that we don't use anymore
/******************************************************************************************/
DELETE
FROM
	ad_role_included
WHERE
		included_role_id IN (
		SELECT
			ad_role_id
		FROM
			ad_role
		WHERE
			ismasterrole = 'Y'
			AND ad_role_uu NOT IN ('baec9412-d994-4313-815c-31332357863a', '461b31c5-cae2-449d-8a0c-7385b12f4685',
			                       'ec17fee0-a53a-4dbb-b946-423ce14880eb', '097feff0-3aa6-41fe-bf76-936b03859846',
			                       '93365778-a2d9-433b-b962-87fb150db4fa', '09eb7fc8-9cc5-44b0-9d14-15258a066038',
			                       '98617c31-55ff-48f9-bd44-253ef323d960', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
			                       'ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
			                       'c54253cf-c86b-4aaa-b472-ed8880635c62')
	);

DELETE
FROM
	ad_role
WHERE
	ismasterrole = 'Y'
	AND ad_role_uu NOT IN ('baec9412-d994-4313-815c-31332357863a', '461b31c5-cae2-449d-8a0c-7385b12f4685',
	                       'ec17fee0-a53a-4dbb-b946-423ce14880eb', '097feff0-3aa6-41fe-bf76-936b03859846',
	                       '93365778-a2d9-433b-b962-87fb150db4fa', '09eb7fc8-9cc5-44b0-9d14-15258a066038',
	                       '98617c31-55ff-48f9-bd44-253ef323d960', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e',
	                       'ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
	                       'c54253cf-c86b-4aaa-b472-ed8880635c62');

/******************************************************************************************/
-- 4. Work with existing roles, either adding new, updating weird,  or marking old for deletion
/******************************************************************************************/
-- Get the roles that don't match our naming convention, aren't assigned the "Must Haves" role (which probably meant
-- the creator was intentionally not following our naming convention), and aren't the defaults created by iDempiere
DROP TABLE IF EXISTS tmp_roles_to_delete;
SELECT
	r.ad_role_id
INTO TEMP TABLE
	tmp_roles_to_delete
FROM
	ad_role r
		JOIN ad_client c
		ON r.ad_client_id = c.ad_client_id
		LEFT JOIN tmp_default_roles tdr
		ON tdr.ad_role_id = r.ad_role_id
WHERE
	r.name NOT IN (c.name || ' Admin', c.name || ' User')
	AND r.ad_client_id NOT IN (0, 11)
	AND r.ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			ad_role_included
		WHERE
				included_role_id = (
				SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
			)
	)
	AND tdr.ad_role_id IS NULL;

-- There are some duplicate roles we need to remove, so add those
INSERT INTO
	tmp_roles_to_delete
SELECT
	r_dup.ad_role_id
FROM
	ad_role r_dup
		JOIN ad_role r
		ON r.ad_client_id = r_dup.ad_client_id AND r.name = r_dup.name AND r_dup.created > r.created;

-- Delete this random GardenWorld Admin not advanced role that's there
INSERT INTO
	tmp_roles_to_delete
SELECT
	ad_role_id
FROM
	ad_role
WHERE
	ad_role_uu = '59cf270b-d74a-4cea-a8f7-ff2fd838a8f9';

-- Create the new roles that should exist
DROP TABLE IF EXISTS tmp_ad_role;
CREATE TEMP TABLE tmp_ad_role
(
	ad_role_id     serial                          NOT NULL,
	ad_client_id   numeric(10)                     NOT NULL,
	ad_org_id      numeric(10) DEFAULT 0           NOT NULL,
-- 	isactive                 char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	created                  timestamp   DEFAULT NOW()         NOT NULL,
	createdby      numeric(10) DEFAULT 100         NOT NULL,
-- 	updated                  timestamp   DEFAULT NOW()         NOT NULL,
	name           varchar(200)                    NOT NULL,
	updatedby      numeric(10) DEFAULT 100         NOT NULL,
-- 	description       varchar(255),
-- 	userlevel                char(3)     DEFAULT '  O'::bpchar NOT NULL,
-- 	c_currency_id     numeric(10),
-- 	amtapproval              numeric     DEFAULT 0,
-- 	ad_tree_menu_id   numeric(10),
-- 	ismanual                 char        DEFAULT 'Y'::bpchar   NOT NULL,
	isshowacct     char        DEFAULT 'N'::bpchar NOT NULL,
-- 	ispersonallock           char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	ispersonalaccess         char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	iscanexport              char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	iscanreport              char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	supervisor_id     numeric(10),
-- 	iscanapproveowndoc       char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	isaccessallorgs          char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	ischangelog              char        DEFAULT 'N'::bpchar   NOT NULL,
	preferencetype char        DEFAULT 'O'::bpchar NOT NULL,
-- 	overwritepricelimit      char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	isuseuserorgaccess       char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	ad_tree_org_id    numeric(10),
-- 	confirmqueryrecords      numeric(10) DEFAULT 0             NOT NULL,
-- 	maxqueryrecords          numeric(10) DEFAULT 0             NOT NULL,
-- 	connectionprofile char,
-- 	allow_info_account       char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_asset         char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_bpartner      char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_cashjournal   char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	allow_info_inout         char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_invoice       char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_order         char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_payment       char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_product       char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_resource      char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	allow_info_schedule      char        DEFAULT 'Y'::bpchar   NOT NULL,
-- 	userdiscount   numeric(22, 2),
-- 	allow_info_mrp           char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	allow_info_crp           char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	isdiscountuptolimitprice char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	isdiscountallowedontotal char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	amtapprovalaccum  numeric,
-- 	daysapprovalaccum numeric(10),
	ad_role_uu     uuid        DEFAULT uuid_generate_v4(),
-- 	ismenuautoexpand         char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	ismasterrole             char        DEFAULT 'N'::bpchar   NOT NULL,
-- 	isaccessadvanced         char        DEFAULT 'N'::bpchar,
-- 	roletype          varchar(2)  DEFAULT NULL::character varying
	master_role_id numeric
);

SELECT
	SETVAL(
		'tmp_ad_role_ad_role_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'AD_Role'
			LIMIT 1
		)::INT,
		FALSE
		);

INSERT
INTO
	tmp_ad_role (ad_client_id, name, master_role_id)
SELECT
	ad_client_id,
	name,
	master_role_id
FROM
	tmp_default_roles
WHERE
	ad_role_id IS NULL;

-- Now insert the new ones
INSERT INTO
	ad_role (ad_role_id, ad_client_id, ad_org_id, createdby, name, updatedby, isshowacct, preferencetype, ad_role_uu)
SELECT
	ad_role_id,
	ad_client_id,
	ad_org_id,
	createdby,
	name,
	updatedby,
	isshowacct,
	preferencetype,
	ad_role_uu
FROM
	tmp_ad_role;

UPDATE tmp_default_roles tdr
SET
	ad_role_id = r.ad_role_id
FROM
	ad_role r
WHERE
	tdr.ad_client_id = r.ad_client_id
	AND tdr.ad_role_id IS NULL
	AND tdr.name = r.name;

/******************************************************************************************/
-- 5. Update role inclusions to be correct
/******************************************************************************************/
-- Update all default roles that match our naming convention to only have "Must Haves" and the master role assigned
DELETE
FROM
	ad_role_included ri
	USING tmp_default_roles tdr
WHERE
	ri.ad_role_id = tdr.ad_role_id
	AND ri.included_role_id NOT IN (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a' UNION SELECT master_role_id
	);

-- Add the included roles to the roles we just created
INSERT INTO
	ad_role_included (ad_client_id, ad_org_id, ad_role_id, created, createdby, included_role_id, isactive, seqno, updated,
	                  updatedby, ad_role_included_uu)
SELECT
	tdr.ad_client_id,
	0,
	tdr.ad_role_id,
	NOW(),
	100,
	r.ad_role_id,
	'Y',
	10,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	tmp_default_roles tdr
		JOIN ad_role r
		ON r.ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
UNION
SELECT
	ad_client_id,
	0,
	ad_role_id,
	NOW(),
	100,
	master_role_id,
	'Y',
	20,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	tmp_default_roles
ON CONFLICT DO NOTHING;

/******************************************************************************************/
-- 6. Map old roles to the new
/******************************************************************************************/
-- For the duplicate roles, map any users assigned to the ones we're keeping
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e4d0c2cc-134c-40d6-b119-b46ad223abee'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'bdbfa095-d795-4df7-9280-f2cc874b10ce'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd1a8b41f-f5f0-4f88-97d5-d357013c6ddd'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'bdcefe33-4b1c-4f2a-a51f-d62639679b51'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c455906c-09ca-4b88-9436-ea5281e90167'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b517c87e-18f5-4c32-b0df-bd5f071c7a2c'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '846e6956-5ede-4d48-a92a-224e55a34b42'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '9c6d6ad3-8f16-4a76-a355-f999e2044edc'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '1d21df24-9a48-4865-91fe-3f2ec3fa985f'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '6f027364-2ff1-4001-86b6-6ccca0bdafa1'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '983b932d-a41d-4f65-883f-06e0678f1d24'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '1196e6bb-77f6-470c-bd18-6dbacc7c4064'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '718c1878-b7c3-40f6-a0a7-7ca48d4b3a73'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e06cf923-cd32-4866-b4da-10f169428bf4'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'b5c6e977-e76d-456f-994a-ba577fbcbffa'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'fd5e1efb-ccc5-4ca6-b811-3a0800591084'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'd796be28-d40d-4e19-b176-56e2fdd96378'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '1a6ef816-1f87-4088-9ef7-d3d0695987d1'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '21fa5a29-7505-491e-93e7-6fb90b17f133'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f79f78c0-6f5f-4442-9c10-05a8ee107360'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '07e47a75-fc4c-47cb-be86-d568781879cf'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '6f00eb97-aa12-4999-9b9d-41dda106d1ef'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a0b07590-0ec1-4bc9-a076-3beb614c2509'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '6dadc658-bd43-428e-85f2-96de9dfe23fd'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'f0d939d4-043b-4150-a9f1-1123129088f3'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ecb0248a-cd35-4395-a85a-8b334957487f'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '609e2d17-a6a0-4b11-aae2-67cdef01ad68'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '7e4b06be-06cd-452b-9985-b0b2f509e2f2'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '02c4c3df-dfac-4925-9ecf-f6245e0b355c'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '797797c0-c48b-4f43-b583-a9e10a39de8e'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '34916db6-667f-49fb-83f4-41de85ff4f06'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'dbc41236-b088-4637-8ddc-e3194d7d909e'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '4666039c-4d7b-4018-b634-b7b0073d19fd'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '8105c4fe-57dd-4261-95a1-dbd77387f6a1'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '836e50b5-f1a5-4cf6-b648-a4a69053d1c6'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e392127c-41fd-4698-8947-ad715bebb61f'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '8642ebb0-7665-4860-a2ed-a74a474b6d10'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '88ef7532-e166-4ed5-8633-ed1aa3e5bb24'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c2d61b91-4579-4ba0-8f9f-29cc447a25be'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '690191f0-0fc9-4cb8-8213-a9db34068a63'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '2ba3d6bb-277d-4a7c-ae91-02f258e175a0'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);
UPDATE ad_user_roles ur
SET
	ad_role_id = tdr.master_role_id
FROM
	tmp_default_roles tdr
WHERE
	tdr.ad_client_id = ur.ad_client_id
	AND tdr.master_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	)
	AND ur.ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e3e562ca-ea23-4c00-84fe-1571d25868d0'
	)
	AND NOT EXISTS (
		SELECT 1 FROM ad_user_roles WHERE ad_user_id = ur.ad_user_id AND ad_role_id = tdr.master_role_id
	);

/******************************************************************************************/
-- 7. Delete old roles
/******************************************************************************************/
-- Now remove the roles that are no longer needed
DELETE
FROM
	AD_Table_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Record_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Column_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	CM_AccessListRole
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_User_Roles
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Process_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Window_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Workflow_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Role_Included
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);

-- Remove constraints from these two tables since they take a while
ALTER TABLE ad_changelog
	DROP CONSTRAINT ad_changelog_ad_session_id_fkey;
ALTER TABLE k_comment
	DROP CONSTRAINT adsession_kcomment;
ALTER TABLE k_entry
	DROP CONSTRAINT adsession_kentry;

DELETE
FROM
	ad_changelog
WHERE
		ad_session_id IN (
		SELECT
			ad_session_id
		FROM
			ad_session
		WHERE
				ad_role_id IN (
				SELECT
					ad_role_id
				FROM
					tmp_roles_to_delete
			)
	);
DELETE
FROM
	AD_Session
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);

-- Re-add the constraints
ALTER TABLE k_entry
	ADD CONSTRAINT adsession_kentry FOREIGN KEY (ad_session_id) REFERENCES ad_session (ad_session_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE k_comment
	ADD CONSTRAINT adsession_kcomment FOREIGN KEY (ad_session_id) REFERENCES ad_session (ad_session_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE ad_changelog
	ADD CONSTRAINT ad_changelog_ad_session_id_fkey FOREIGN KEY (ad_session_id) REFERENCES ad_session (ad_session_id) DEFERRABLE INITIALLY DEFERRED;

-- Continue with the deletes
DELETE
FROM
	AD_Form_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Role_OrgAccess
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Task_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Document_Action_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_RecentItem
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_ToolBarButtonRestrict
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	WS_WebServiceTypeAccess
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_InfoWindow_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	R_RequestAction
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	PA_Goal
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_SchedulerRecipient
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_UserDef_Win
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	U_RoleMenu
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	PA_DashboardContent
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_WF_Responsible
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_AlertRecipient
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	R_Request
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	PA_DashboardPreference
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_UserQuery
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	PA_DashboardContent_Access
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_BroadcastMessage
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_ImportTemplateAccess
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	PA_DocumentStatus
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Package_Exp_Detail
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_Package_Exp_Common
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	AD_UserDef_Proc
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);
DELETE
FROM
	BH_Role_WarehouseAccess
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);

-- Delete the appropriate roles
DELETE
FROM
	ad_role
WHERE
		ad_role_id IN (
		SELECT
			ad_role_id
		FROM
			tmp_roles_to_delete
	);

/******************************************************************************************/
-- 8. Ensure system admins have access to all default roles
/******************************************************************************************/
INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               ad_user_roles_uu)
SELECT
	u.ad_user_id,
	tdr.ad_role_id,
	tdr.ad_client_id,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	ad_user u
		CROSS JOIN tmp_default_roles tdr
WHERE
		u.ad_user_id IN (
		SELECT
			ad_user_id
		FROM
			ad_user_roles
		WHERE
			ad_role_id = 0
	)
	AND ad_user_id != 0
ON CONFLICT DO NOTHING;

/******************************************************************************************/
-- 9. Rename some roles that didn't get renamed before
/******************************************************************************************/
UPDATE ad_role r
SET
	name = tdr.name
FROM
	ad_client c
		CROSS JOIN (
		SELECT
			ad_role_id
		FROM
			ad_role_included
		WHERE
				included_role_id != (
				SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
			)
		GROUP BY ad_role_id
		HAVING
			COUNT(*) = 1
	) updatable_role
		JOIN (
		SELECT
			ad_role_id,
			included_role_id
		FROM
			ad_role_included
		WHERE
				included_role_id != (
				SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
			)
	) master_role
		ON updatable_role.ad_role_id = master_role.ad_role_id
		JOIN tmp_default_roles tdr
		ON c.ad_client_id = tdr.ad_client_id AND tdr.master_role_id = master_role.included_role_id
WHERE
	r.ad_client_id = c.ad_client_id
	AND r.name IN (c.name || ' Clinician/Nurse', c.name || ' Cashier/Registration')
	AND r.ad_role_id = updatable_role.ad_role_id;

/******************************************************************************************/
-- 10. Wrap up
/******************************************************************************************/
SELECT
	register_migration_script('202306151049_GO-1957.sql')
FROM
	dual;
