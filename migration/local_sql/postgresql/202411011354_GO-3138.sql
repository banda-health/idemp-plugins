-- Insert access for the Cashier/Registration Advanced and Clinician/Nurse Advanced roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	0,
	0,
	100,
	100
FROM
	ad_role r
		JOIN ad_process p
		ON p.ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'
WHERE
	ad_role_uu IN ('ee008abc-2c16-4230-b48c-b1f5577ea270', 'c54253cf-c86b-4aaa-b472-ed8880635c62');

SELECT
	register_migration_script('202411011354_GO-3138.sql')
FROM
	dual;
