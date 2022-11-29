-- Update all the clinic admin roles and set them to manual
SELECT r.ad_role_id
INTO TEMP TABLE tmp_clinic_admin_roles
FROM ad_role r
	JOIN ad_client c ON r.ad_client_id = c.ad_client_id
WHERE r.name = c.name || ' Clinic Admin';

UPDATE ad_role r
SET ismanual = 'Y'
FROM tmp_clinic_admin_roles car
WHERE r.ad_role_id = car.ad_role_id;

-- Remove all window access
DELETE FROM ad_window_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all process access
DELETE FROM ad_process_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all form access
DELETE FROM ad_form_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all info access
DELETE FROM ad_infowindow_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all workflow access
DELETE FROM ad_workflow_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all task access
DELETE FROM ad_task_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove all document action access
DELETE FROM ad_document_action_access access
USING tmp_clinic_admin_roles car
WHERE access.ad_role_id = car.ad_role_id;

-- Remove existing included roles that aren't "Must Haves" and "Clinic Admin"
DELETE FROM ad_role_included ri
USING tmp_clinic_admin_roles car
WHERE ri.ad_role_id = car.ad_role_id
	AND ri.included_role_id NOT IN (
		SELECT ad_role_id FROM ad_role
		WHERE ad_role_uu IN ('baec9412-d994-4313-815c-31332357863a','461b31c5-cae2-449d-8a0c-7385b12f4685')
	);

-- Add included roles if they aren't already present
-- "Must Haves"
INSERT INTO ad_role_included (
	ad_client_id,
	ad_org_id,
	ad_role_id,
	createdby,
	included_role_id,
	isactive,
	seqno,
	updatedby,
	ad_role_included_uu
)
SELECT
	r.ad_client_id,
	0,
	car.ad_role_id,
	100,
	mh.ad_role_id,
	'Y',
	10,
	100,
	uuid_generate_v4()
FROM tmp_clinic_admin_roles car
	JOIN ad_role r ON car.ad_role_id = r.ad_role_id
	CROSS JOIN (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'
	) mh
ON CONFLICT DO NOTHING;

-- "Clinic Admin"
INSERT INTO ad_role_included (
	ad_client_id,
	ad_org_id,
	ad_role_id,
	createdby,
	included_role_id,
	isactive,
	seqno,
	updatedby,
	ad_role_included_uu
)
SELECT
	r.ad_client_id,
	0,
	car.ad_role_id,
	100,
	mh.ad_role_id,
	'Y',
	20,
	100,
	uuid_generate_v4()
FROM tmp_clinic_admin_roles car
	JOIN ad_role r ON car.ad_role_id = r.ad_role_id
	CROSS JOIN (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	) mh
ON CONFLICT DO NOTHING;

SELECT register_migration_script('202110061731_GO-1884.sql') FROM dual;
