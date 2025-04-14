/**********************************************************************************************************************/
-- Add a new role for use in the system.
-- 1. Rename the existing master role from "Lab/Radiology" to "Lab/Radiology Advanced" (and associated reference).
-- 2. Update all clients to have a new name in their role title(s) (i.e. replace "Lab/Radiology" with
-- "Lab/Radiology Advanced" in ad_role.name.
-- 3. Remove Read/Write for clinical vitals & details windows from "Lab/Radiology Advanced" role.
-- 4. Create the new master role, "Lab/Radiology Basic".
-- 5. Assign all process & window access from "Lab/Radiology Advanced" to "Lab/Radiology Basic" aside from clinical
-- vitals & details windows.
-- 6. Call the function to add "Lab/Radiology Basic" to all clients.
-- 7. Grant access from everyone who had access to "Lab/Radiology Advanced" also access to "Lab/Radiology Basic" who is
-- a system user.
-- 8. Wrap up and be done.
/**********************************************************************************************************************/

/**********************************************************************************************************************/
-- 1. Rename the existing master role from "Lab/Radiology" to "Lab/Radiology Advanced" (and associated reference).
/**********************************************************************************************************************/
UPDATE ad_role
SET
	name        = 'Lab/Radiology Advanced',
	description = 'Lab and radiology advanced role'
WHERE
	ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846';
UPDATE ad_ref_list
SET
	name = 'Lab/Radiology Advanced'
WHERE
	ad_ref_list_uu = 'bc7e156d-ddf2-4377-b915-d78b7222f942';

/**********************************************************************************************************************/
-- 2. Update all clients to have a new name in their role title(s) (i.e. replace "Lab/Radiology" with
-- "Lab/Radiology Advanced" in ad_role.name.
/**********************************************************************************************************************/
UPDATE ad_role
SET
	name = REPLACE(name, 'Lab/Radiology', 'Lab/Radiology Advanced')
WHERE
	name ILIKE '%Lab/Radiology%'
	AND ismasterrole = 'N'
	AND ad_client_id NOT IN (0, 11);

/**********************************************************************************************************************/
-- 3. Remove Read/Write for clinical vitals & details windows from "Lab/Radiology Advanced" role.
/**********************************************************************************************************************/
UPDATE ad_window_access
SET
	isreadwrite = 'N'
WHERE
	ad_role_id = (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	)
	AND ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('53b4d743-c311-40e5-aa8e-c0880c42c1b1', '2e37e97b-aeb5-47d7-add3-0d602233c2aa')
	);

/**********************************************************************************************************************/
-- 4. Create the new master role, "Lab/Radiology Basic".
/**********************************************************************************************************************/
-- Create the new role
INSERT INTO
	ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock,
	         ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog,
	         preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords,
	         maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner,
	         allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment,
	         allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp,
	         isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu,
	         ismenuautoexpand, ismasterrole, isaccessadvanced, roletype, isclientadministrator,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_role_id) + 1
		 FROM
			 ad_role
	 ), 0, 0, 'Y', '2025-04-10 10:34:29.593000', 100, '2025-04-10 10:34:29.593000', 'Lab/Radiology Basic', 100,
	 'Lab and radiology basic role', 'S  ', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N',
	 'N', NULL, 0, 0, NULL, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'N', 'N', 'N', 'N', 0, 0,
	 '17ccea57-1131-4d51-83ca-1824182e4493', 'N', 'Y', 'Y', NULL, 'N', NULL);
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-04-10 09:36:55.867238', 100, '2025-04-10 09:36:55.867238', 100, 'K',
	 'Lab/Radiology Basic', NULL, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'
	 ), NULL, NULL, 'U', 'a21e1ce0-6a4f-4ac4-b175-1d1ef0ffda44', 'N', 'N');

/**********************************************************************************************************************/
-- 5. Assign all process & window access from "Lab/Radiology Advanced" to "Lab/Radiology Basic" aside from clinical
-- vitals & details windows.
/**********************************************************************************************************************/
-- Give it the same access as the Lab/Radiology Advanced (aside from vitals & clinical details)
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	wa.ad_window_id,
	r_lrb.ad_role_id,
	wa.ad_client_id,
	wa.ad_org_id,
	wa.isactive,
	NOW(),
	wa.createdby,
	NOW(),
	wa.updatedby,
	wa.isreadwrite,
	uuid_generate_v4(),
	wa.bh_candeactivate
FROM
	ad_window_access wa
		JOIN ad_role r_lra
		ON wa.ad_role_id = r_lra.ad_role_id AND r_lra.ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
		JOIN ad_role r_lrb
		ON r_lrb.ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493'
WHERE
	wa.ad_window_id NOT IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('53b4d743-c311-40e5-aa8e-c0880c42c1b1', '2e37e97b-aeb5-47d7-add3-0d602233c2aa')
	);
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	pa.ad_process_id,
	r_lrb.ad_role_id,
	pa.ad_client_id,
	pa.ad_org_id,
	pa.isactive,
	NOW(),
	pa.createdby,
	NOW(),
	pa.updatedby,
	pa.isreadwrite,
	uuid_generate_v4()
FROM
	ad_process_access pa
		JOIN ad_role r_lra
		ON pa.ad_role_id = r_lra.ad_role_id AND r_lra.ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
		JOIN ad_role r_lrb
		ON r_lrb.ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493';

/**********************************************************************************************************************/
-- 6. Call the function to add "Lab/Radiology Basic" to all clients.
/**********************************************************************************************************************/
-- Add it to existing clients
SELECT
	add_roles_to_clients('17ccea57-1131-4d51-83ca-1824182e4493', 'K');

/**********************************************************************************************************************/
-- 7. Grant access from everyone who had access to "Lab/Radiology Advanced" also access to "Lab/Radiology Basic" who is
-- a system user.
/**********************************************************************************************************************/
INSERT INTO
	ad_user_roles (ad_user_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               ad_user_roles_uu)
SELECT
	u.ad_user_id,
	r_c_lrb.ad_role_id,
	ur.ad_client_id,
	ur.ad_org_id,
	ur.isactive,
	NOW(),
	100,
	NOW(),
	100,
	uuid_generate_v4()
FROM
	ad_user_roles ur
		JOIN ad_user u
		ON ur.ad_user_id = u.ad_user_id AND u.ad_client_id = 0
		JOIN ad_role r_lra
		ON r_lra.ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
		JOIN ad_role r_lrb
		ON r_lrb.ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493'
		JOIN ad_role r_c_lra
		ON ur.ad_role_id = r_c_lra.ad_role_id
		JOIN ad_client c
		ON r_c_lra.ad_client_id = c.ad_client_id AND r_c_lra.name = c.name || ' ' || r_lra.name
		JOIN ad_role r_c_lrb
		ON r_c_lrb.name = c.name || ' ' || r_lrb.name;

/**********************************************************************************************************************/
-- 8. Wrap up and be done.
/**********************************************************************************************************************/
SELECT
	register_migration_script('202504101046_GO-3260.sql')
FROM
	dual;
