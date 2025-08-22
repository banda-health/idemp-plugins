DROP FUNCTION IF EXISTS add_roles_to_clients(ad_role_to_add_uu uuid, user_type character varying);
CREATE OR REPLACE FUNCTION bh_add_roles_to_clients(_ad_role_to_add_uu uuid, _user_type character varying) RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
	clients_updated integer := 0;
BEGIN
	-- Update sequences first
	PERFORM update_sequences();

	DROP TABLE IF EXISTS tmp_ad_role;
	CREATE TEMP TABLE tmp_ad_role
	(
		ad_role_id               serial                            NOT NULL,
		ad_client_id             numeric(10)                       NOT NULL,
		ad_org_id                numeric(10)                       NOT NULL,
		isactive                 char        DEFAULT 'Y'::bpchar   NOT NULL,
		created                  timestamp   DEFAULT NOW()         NOT NULL,
		createdby                numeric(10)                       NOT NULL,
		updated                  timestamp   DEFAULT NOW()         NOT NULL,
		name                     varchar(255)                      NOT NULL,
		updatedby                numeric(10)                       NOT NULL,
		description              varchar(255),
		userlevel                char(3)     DEFAULT '  O'::bpchar NOT NULL,
		c_currency_id            numeric(10),
		amtapproval              numeric     DEFAULT 0,
		ad_tree_menu_id          numeric(10),
		ismanual                 char        DEFAULT 'Y'::bpchar   NOT NULL,
		isshowacct               char        DEFAULT 'Y'::bpchar   NOT NULL,
		ispersonallock           char        DEFAULT 'N'::bpchar   NOT NULL,
		ispersonalaccess         char        DEFAULT 'N'::bpchar   NOT NULL,
		iscanexport              char        DEFAULT 'Y'::bpchar   NOT NULL,
		iscanreport              char        DEFAULT 'Y'::bpchar   NOT NULL,
		supervisor_id            numeric(10),
		iscanapproveowndoc       char        DEFAULT 'Y'::bpchar   NOT NULL,
		isaccessallorgs          char        DEFAULT 'N'::bpchar   NOT NULL,
		ischangelog              char        DEFAULT 'N'::bpchar   NOT NULL,
		preferencetype           char        DEFAULT 'C'::bpchar   NOT NULL,
		overwritepricelimit      char        DEFAULT 'N'::bpchar   NOT NULL,
		isuseuserorgaccess       char        DEFAULT 'N'::bpchar   NOT NULL,
		ad_tree_org_id           numeric(10),
		confirmqueryrecords      numeric(10) DEFAULT 0             NOT NULL,
		maxqueryrecords          numeric(10) DEFAULT 0             NOT NULL,
		connectionprofile        char,
		allow_info_account       char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_asset         char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_bpartner      char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_cashjournal   char        DEFAULT 'N'::bpchar   NOT NULL,
		allow_info_inout         char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_invoice       char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_order         char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_payment       char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_product       char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_resource      char        DEFAULT 'Y'::bpchar   NOT NULL,
		allow_info_schedule      char        DEFAULT 'Y'::bpchar   NOT NULL,
		userdiscount             numeric(22, 2),
		allow_info_mrp           char        DEFAULT 'N'::bpchar   NOT NULL,
		allow_info_crp           char        DEFAULT 'N'::bpchar   NOT NULL,
		isdiscountuptolimitprice char        DEFAULT 'N'::bpchar   NOT NULL,
		isdiscountallowedontotal char        DEFAULT 'N'::bpchar   NOT NULL,
		amtapprovalaccum         numeric,
		daysapprovalaccum        numeric(10),
		ad_role_uu               uuid                              NOT NULL DEFAULT uuid_generate_v4(),
		ismenuautoexpand         char        DEFAULT 'N'::bpchar   NOT NULL,
		ismasterrole             char        DEFAULT 'N'::bpchar   NOT NULL,
		isaccessadvanced         char        DEFAULT 'N'::bpchar,
		roletype                 varchar(2)  DEFAULT NULL::character varying
	);

	PERFORM SETVAL('tmp_ad_role_ad_role_id_seq', (
		SELECT currentnext FROM adempiere.ad_sequence WHERE name = 'AD_Role' LIMIT 1
	)::INT, FALSE);

	-- Extract into a temp table all non-system clients and create responsibility role for each client in
	-- the format '<Client_Name> Role_Name'
	INSERT INTO
		tmp_ad_role (ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description, userlevel,
		             c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock,
		             ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc,
		             isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess,
		             ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile,
		             allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal,
		             allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment,
		             allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp,
		             allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum,
		             daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)
	SELECT
		c.ad_client_id,
		0,
		'Y',
		100,
		c.name || ' ' || r.name,
		100,
		NULL,
		'  O',
		NULL,
		0,
		NULL,
		'Y',
		'N',
		'N',
		'N',
		'Y',
		'Y',
		NULL,
		'Y',
		'N',
		'N',
		'O',
		'N',
		'N',
		NULL,
		0,
		0,
		NULL,
		'Y',
		'Y',
		'Y',
		'N',
		'Y',
		'Y',
		'Y',
		'Y',
		'Y',
		'Y',
		'Y',
		NULL,
		'N',
		'N',
		'N',
		'N',
		NULL,
		NULL,
		uuid_generate_v4(),
		'N',
		'N',
		'N',
		NULL
	FROM
		adempiere.ad_client c
			JOIN adempiere.ad_role r
				ON r.ad_role_uu = _ad_role_to_add_uu :: TEXT
	WHERE
		c.ad_client_id NOT IN (0, 11);

	SELECT COUNT(*) FROM tmp_ad_role INTO clients_updated;

	-- Add the created role into ad_roles table
	INSERT INTO
		ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description,
		         userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock,
		         ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs,
		         ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id,
		         confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset,
		         allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice,
		         allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule,
		         userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal,
		         amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced,
		         roletype)
	SELECT
		ad_role_id,
		ad_client_id,
		ad_org_id,
		isactive,
		createdby,
		name,
		updatedby,
		description,
		userlevel,
		c_currency_id,
		amtapproval,
		ad_tree_menu_id,
		ismanual,
		isshowacct,
		ispersonallock,
		ispersonalaccess,
		iscanexport,
		iscanreport,
		supervisor_id,
		iscanapproveowndoc,
		isaccessallorgs,
		ischangelog,
		preferencetype,
		overwritepricelimit,
		isuseuserorgaccess,
		ad_tree_org_id,
		confirmqueryrecords,
		maxqueryrecords,
		connectionprofile,
		allow_info_account,
		allow_info_asset,
		allow_info_bpartner,
		allow_info_cashjournal,
		allow_info_inout,
		allow_info_invoice,
		allow_info_order,
		allow_info_payment,
		allow_info_product,
		allow_info_resource,
		allow_info_schedule,
		userdiscount,
		allow_info_mrp,
		allow_info_crp,
		isdiscountuptolimitprice,
		isdiscountallowedontotal,
		amtapprovalaccum,
		daysapprovalaccum,
		ad_role_uu,
		ismenuautoexpand,
		ismasterrole,
		isaccessadvanced,
		roletype
	FROM
		tmp_ad_role
	ON CONFLICT DO NOTHING;

	-- Update the new role to have the same access to org as other responsibility roles have.
	INSERT INTO
		adempiere.ad_role_orgaccess (ad_role_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, isreadonly,
		                             ad_role_orgaccess_uu)
	SELECT
		tar.ad_role_id,
		tar.ad_client_id,
		ao.ad_org_id,
		'Y',
		100,
		100,
		'N',
		uuid_generate_v4()
	FROM
		tmp_ad_role tar
			JOIN adempiere.ad_org ao
				ON ao.ad_client_id = tar.ad_client_id;

	-- Add the "Must Haves" and "New_Master_Role" to the role
	INSERT INTO
		ad_role_included (ad_client_id, ad_org_id, ad_role_id, createdby, included_role_id, seqno, updatedby,
		                  ad_role_included_uu)
	SELECT
		ad_client_id,
		0,
		tar.ad_role_id,
		100,
		ir.ad_role_id,
		ir.seqno,
		100,
		uuid_generate_v4()
	FROM
		tmp_ad_role tar
			CROSS JOIN
			(
				SELECT
					ad_role_id,
					10 AS seqno
				FROM
					adempiere.ad_role
				WHERE
					ad_role_uu = _ad_role_to_add_uu :: TEXT
				UNION
				SELECT
					ad_role_id,
					20 AS seqno
				FROM
					adempiere.ad_role
				WHERE
					ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
			) ir;

	-- Add a user-type ref-list item for the new role to the AD_Role_User_Type table
	INSERT INTO
		adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, createdby, updatedby,
		                       value, name, description, ad_reference_id, validfrom, validto,
		                       entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all)
	VALUES
		((
			 SELECT
				 MAX(ad_ref_list_id) + 1
			 FROM
				 adempiere.ad_ref_list
		 ), 0, 0, 'Y', 100, 100,
		 _user_type,
		 (
			 SELECT name FROM adempiere.ad_role WHERE ad_role_uu = _ad_role_to_add_uu :: TEXT
		 ),
		 (
			 SELECT description FROM adempiere.ad_role WHERE ad_role_uu = _ad_role_to_add_uu :: TEXT
		 ),
		 (
			 SELECT ad_reference_id FROM adempiere.ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'
		 ),
		 NULL, NULL, 'U', uuid_generate_v4(), 'N', 'N');

	-- When new BH clients are set up, they should include a role with this new role, as well as the must haves role
	INSERT INTO
		adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu,
		                                  createdby, db_usertype, description, isactive, name, updatedby, included_role_id)
	VALUES
		(0, 0, (
			SELECT MAX(bh_defaultincludedrole_id) + 1 FROM adempiere.bh_defaultincludedrole
		), uuid_generate_v4(), 100, _user_type, NULL, 'Y', NULL, 100, (
			 SELECT ad_role_id FROM adempiere.ad_role WHERE ad_role_uu = _ad_role_to_add_uu :: TEXT
		 ))
	ON CONFLICT DO NOTHING;
	INSERT INTO
		adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu,
		                                  createdby, db_usertype, description, isactive, name, updatedby, included_role_id)
	VALUES
		(0, 0, (
			SELECT MAX(bh_defaultincludedrole_id) + 1 FROM adempiere.bh_defaultincludedrole
		), uuid_generate_v4(), 100, _user_type, NULL, 'Y', NULL, 100, (
			 SELECT ad_role_id FROM adempiere.ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
		 ))
	ON CONFLICT DO NOTHING;
-- Add role to other non manual roles i.e admin
	INSERT INTO
		ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
		               ad_user_roles_uu)
	SELECT
		u.ad_user_id,
		r_oo.ad_role_id,
		ur.ad_client_id,
		ur.ad_org_id,
		ur.isactive,
		NOW(),
		100,
		NOW(),
		100,
		uuid_generate_v4()
	FROM
		ad_client c
			JOIN ad_role r_ca
				ON r_ca.ad_client_id = c.ad_client_id AND r_ca.name = c.name || ' Clinic Admin'
			JOIN ad_user_roles ur
				ON r_ca.ad_role_id = ur.ad_role_id
			JOIN ad_user u
				ON ur.ad_user_id = u.ad_user_id AND u.ad_client_id = 0
			JOIN ad_role r_oo
				ON r_ca.ad_client_id = c.ad_client_id AND r_oo.name = c.name || ' ' || (
			SELECT
				name
			FROM
				ad_role
			WHERE
				ad_role_uu = _ad_role_to_add_uu
		);

	-- Update all ID sequences after all the inserts we've done
	PERFORM update_sequences();

	RAISE NOTICE 'New user role added to % clients', clients_updated;
END;
$$;

-- Add Registration role
INSERT INTO
	ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby,
	         description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct,
	         ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc,
	         isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess,
	         ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account,
	         allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout,
	         allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource,
	         allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice,
	         isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand,
	         ismasterrole, isaccessadvanced, roletype, isclientadministrator, predefinedcontextvariables)
VALUES
	((
		 SELECT MAX(ad_role_id) + 1
		 FROM ad_role
	 ), 0, 0, 'Y', '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 'Registration', 100,
	 'Registration role for patient registration and management', 'S  ', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y',
	 NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL,
	 0, 0, NULL, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'N', 'N', 'N', 'N', 0, 0,
	 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'N', 'Y', 'Y', NULL, 'N', NULL);

-- Add window access for Patient page with deactivate permission
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ba697729-5ec8-44f7-b534-446310bb5782'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'Y',
	 'b2c3d4e5-f6a7-8901-bcde-f23456789012', 'Y');

-- Add window access for Products & Prices with readonly permission
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
	 'c3d4e5f6-a7b8-9012-cdef-345678901234', 'N');

-- Add window access for Services & Prices with readonly permission
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
	 'd4e5f6a7-b8c9-0123-defa-456789012345', 'N');

-- Add window access for Patient Tags with readonly permission
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '3c865615-4f7e-4b19-a64b-740485d99e83'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
	 'd5e6f7a8-b9c0-1234-efab-567890123456', 'N');

-- Add window access for Visits/Bills with create/edit permission
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'Y',
	 'e5f6a7b8-c9d0-1234-efab-567890123456', 'N');

-- Add process access for Receipt
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
	 'a9b0c1d2-e3f4-5678-abcd-901234567890');

-- Add process access for Visit Invoice
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'
	 ),
	 (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	 ), 0, 0, 'Y',
	 '2025-08-20 15:11:00.000000', 100, '2025-08-20 15:11:00.000000', 100, 'N',
	 'b0c1d2e3-f4a5-6789-bcde-012345678901');

-- Add it to existing clients
SELECT
	bh_add_roles_to_clients('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'W');

SELECT
	register_migration_script('202508201511_GO-3392.sql')
FROM
	dual;
