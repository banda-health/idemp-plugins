-- GO-3613: Repair malformed *_uu values before IDEMPIERE-6650 uuid cast.
-- Root cause: 202111251111_GO-1806.sql inserted ad_window_access_uu with a leading tab.
-- Full-schema scan during iD13 upgrade testing found only ad_window_access affected.

UPDATE adempiere.ad_window_access
SET
	ad_window_access_uu = '8411e8e3-029a-5476-7db4-ec17fee0a53a',
	updated = NOW(),
	updatedby = 100
WHERE
	ad_window_id = (
		SELECT ad_window_id
		FROM adempiere.ad_window
		WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'
	)
	AND ad_role_id = (
		SELECT ad_role_id
		FROM adempiere.ad_role
		WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	)
	AND btrim(ad_window_access_uu) = '411e-8e83-029a54767db4';

SELECT
	register_migration_script('202606161447_GO-3613.sql')
FROM
	dual;
