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

SELECT
	register_migration_script('202211101314_GO-2380.sql')
FROM
	dual;
