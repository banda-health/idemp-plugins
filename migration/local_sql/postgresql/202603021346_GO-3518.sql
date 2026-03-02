-- Remove the two inventory processes from Lab/Radiology Basic
DELETE
FROM
	ad_process_access
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('8e270648-1d54-46d9-9161-2d0300dd80ff', -- Storage Cleanup
			                  'e79541fb-9b70-4a10-bfef-7401401b8c56') -- BH Update Expired Stock Process
	)
	AND ad_role_id IN (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493'
	);

-- Remove window access from manage inventory
DELETE
FROM
	ad_window_access
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu = '8f744d1c-427a-4b85-ab98-38e50258e86d' -- Manage Inventory
	)
	AND ad_role_id IN (
		SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '17ccea57-1131-4d51-83ca-1824182e4493'
	);

SELECT
	register_migration_script('202603021346_GO-3518.sql')
FROM
	dual;
