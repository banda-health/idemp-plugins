-- Insert reference value for the clinician user role
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-03-12 11:45:23.999000', 100, '2021-03-12 11:45:23.999000', 100, 'C', 'Clinician User', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'), null, null, 'U', '2a444310-ac8b-4e40-a0b9-fc6d1e66dc41', 'N', 'N')
ON CONFLICT DO NOTHING;

-- Update the org access tables
INSERT INTO ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, isactive, createdby, updatedby, isreadonly, ad_role_orgaccess_uu)
SELECT r.ad_role_id, r.ad_client_id, ao.ad_org_id, 'Y', 100, 100, 'N', uuid_generate_v4()
FROM ad_role r
JOIN ad_org ao
	ON ao.ad_client_id = r.ad_client_id
JOIN ad_client c
	ON c.ad_client_id = r.ad_client_id
WHERE r.name = c.name || ' Clinician User'
ON CONFLICT DO NOTHING;

-- Grant the same access as the user role
INSERT INTO ad_window_access (
	ad_window_id,
	ad_role_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	isreadwrite,
	ad_window_access_uu
)
SELECT
	u.ad_window_id,
	cr.ad_role_id,
	cr.ad_client_id,
	u.ad_org_id,
	u.isactive,
	now(),
	100,
	now(),
	100,
	u.isreadwrite,
	uuid_generate_v4()
FROM ad_window_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

INSERT INTO ad_process_access (
	ad_process_id,
	ad_role_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	isreadwrite,
	ad_process_access_uu
)
SELECT
	u.ad_process_id,
	cr.ad_role_id,
	cr.ad_client_id,
	u.ad_org_id,
	u.isactive,
	now(),
	100,
	now(),
	100,
	u.isreadwrite,
	uuid_generate_v4()
FROM ad_process_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

INSERT INTO ad_form_access (
	ad_form_id,
	ad_role_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	isreadwrite,
	ad_form_access_uu
)
SELECT
	u.ad_form_id,
	cr.ad_role_id,
	cr.ad_client_id,
	u.ad_org_id,
	u.isactive,
	now(),
	100,
	now(),
	100,
	u.isreadwrite,
	uuid_generate_v4()
FROM ad_form_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

INSERT INTO ad_workflow_access (
	ad_workflow_id,
	ad_role_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	isreadwrite,
	ad_workflow_access_uu
)
SELECT
	u.ad_workflow_id,
	cr.ad_role_id,
	cr.ad_client_id,
	u.ad_org_id,
	u.isactive,
	now(),
	100,
	now(),
	100,
	u.isreadwrite,
	uuid_generate_v4()
FROM ad_workflow_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

INSERT INTO ad_document_action_access (
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	c_doctype_id,
	ad_role_id,
	ad_ref_list_id,
	ad_document_action_access_uu
)
SELECT
	cr.ad_client_id,
	u.ad_org_id,
	u.isactive,
	now(),
	100,
	now(),
	100,
	u.c_doctype_id,
	cr.ad_role_id,
	u.ad_ref_list_id,
	uuid_generate_v4()
FROM ad_document_action_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

INSERT INTO ad_infowindow_access (
	ad_client_id,
	ad_infowindow_access_uu,
	ad_infowindow_id,
	ad_org_id,
	ad_role_id,
	created,
	createdby,
	isactive,
	updated,
	updatedby
)
SELECT
	cr.ad_client_id,
	uuid_generate_v4(),
	u.ad_infowindow_id,
	u.ad_org_id,
	cr.ad_role_id,
	now(),
	100,
	u.isactive,
	now(),
	100
FROM ad_infowindow_access u
JOIN ad_role ur
	ON u.ad_role_id = ur.ad_role_id
JOIN ad_client c
	ON c.ad_client_id = ur.ad_client_id
JOIN ad_role cr
	ON cr.ad_client_id = c.ad_client_id
		AND cr.name = c.name || ' Clinician User'
WHERE ur.name = c.name || ' User'
ON CONFLICT DO NOTHING;

SELECT register_migration_script('202103121142_GO-1562.sql') FROM dual;
