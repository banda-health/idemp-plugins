-- Insert a schedule for use in the old order clean-up
INSERT INTO
	ad_schedule (ad_client_id, ad_org_id, ad_schedule_id, created, createdby, cronpattern, description, frequency,
	             frequencytype, isactive, monthday, runonlyonip, scheduletype, updated, updatedby, weekday, name,
	             ad_schedule_uu, isignoreprocessingtime, issystemschedule)
VALUES
	(0, 0, (
		SELECT MAX(ad_schedule_id) + 1
		FROM ad_schedule
	), '2022-10-25 07:03:03.619000', 100, NULL, NULL, 1, 'M', 'Y', 0, NULL, 'F', '2022-11-10 22:12:43.776000', 100, NULL,
	 '1 Minute', '8a512889-1ba5-4044-8093-572392ac01a3', 'N', 'N');

-- Update the cashier reports to take in a date + time
UPDATE ad_process_para
SET
	ad_reference_id = 16
WHERE
		ad_process_para_uu IN ('c5e7c808-1da5-4280-9db5-bf9c027dd97c', 'bb5f6686-7f22-4894-8151-c0c704e19c3b',
		                       '3c479b5c-dbe5-4c4d-a5e1-9ef283de121f', '9c1c8c6f-516b-4a06-ae2a-4f3d05fa89b5',
		                       '5c0d21f6-522f-451d-922b-9a647ef665dc', 'f8a0c9c8-f11e-4985-ba1a-1a19e4c1b126');

SELECT
	register_migration_script('202211101314_GO-2380.sql')
FROM
	dual;
