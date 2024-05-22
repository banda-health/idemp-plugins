-- Add two new voiding reasons
INSERT INTO
	bh_voided_reason (bh_voided_reason_id, bh_voided_reason_uu, ad_client_id, ad_org_id, created, createdby, name,
	                  description, isactive, updated, updatedby, bh_window_id, lineno)
VALUES
	((
		 SELECT
			 MAX(bh_voided_reason_id) + 1
		 FROM
			 bh_voided_reason
	 ), '4f8f7d06-0752-434f-85d2-f12821abfdad', 0, 0, '2024-05-15 14:06:16.050091', 100, 'Service not offered', NULL, 'Y',
	 '2024-05-15 14:06:16.050091', 100, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'
	 ), 60);
INSERT INTO
	bh_voided_reason (bh_voided_reason_id, bh_voided_reason_uu, ad_client_id, ad_org_id, created, createdby, name,
	                  description, isactive, updated, updatedby, bh_window_id, lineno)
VALUES
	((
		 SELECT
			 MAX(bh_voided_reason_id) + 1
		 FROM
			 bh_voided_reason
	 ), 'b563ea81-9c02-4f8f-9a9c-dbe64c5f6c46', 0, 0, '2024-05-15 14:06:16.050091', 100, 'Sample not produced', NULL, 'Y',
	 '2024-05-15 14:06:16.050091', 100, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'
	 ), 70);

SELECT
	register_migration_script('202405151508_GO-2959.sql')
FROM
	dual;
