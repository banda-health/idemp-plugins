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
-- 8. Wrap up
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
	ad_role_id
INTO TEMP TABLE
	tmp_roles_to_delete
FROM
	ad_role r
		JOIN
		ad_client c
			ON r.ad_client_id = c.ad_client_id
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
	AND r.ad_role_id NOT IN (
		SELECT
			ad_role_id
		FROM
			tmp_default_roles
	);

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
	tr.ad_client_id,
	tr.ad_org_id,
	tr.ad_role_id,
	NOW(),
	tr.createdby,
	r.ad_role_id,
	'Y',
	10,
	NOW(),
	tr.updatedby,
	uuid_generate_v4()
FROM
	tmp_ad_role tr
		JOIN ad_role r
		ON r.ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
UNION
SELECT
	ad_client_id,
	ad_org_id,
	ad_role_id,
	NOW(),
	createdby,
	master_role_id,
	'Y',
	20,
	NOW(),
	updatedby,
	uuid_generate_v4()
FROM
	tmp_ad_role
ON CONFLICT DO NOTHING;

/******************************************************************************************/
-- 6. Map old roles to the new
/******************************************************************************************/
-- Some roles will need their users to be manually mapped - so update those users (other's will just have their roles
-- removed)
UPDATE ad_user_roles ur
SET
	ad_role_id = (
		SELECT
			ad_role_id
		FROM
			ad_role
		WHERE
			ad_client_id = ur.ad_client_id
			AND ad_role_id = (
				SELECT
					ad_role_id
				FROM
					ad_role_included
				WHERE
						included_role_id = (
						SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
					)
			)
	)
WHERE
		ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e4d0c2cc-134c-40d6-b119-b46ad223abee'
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
DELETE
FROM
	AD_UserDef_Info
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
-- 8. Wrap up
/******************************************************************************************/
SELECT
	register_migration_script('202306151049_GO-1957.sql')
FROM
	dual;
