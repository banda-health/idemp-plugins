--- Update the parameter type for the report
UPDATE ad_process_para
SET
	ad_client_id          = 0,
	ad_org_id             = 0,
	isactive              = 'Y',
	updated               = '2025-09-12 11:34:46.834000',
	updatedby             = 100,
	ad_process_id         = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c'
	),
	seqno                 = 40,
	ad_reference_id       = 19,
	columnname            = 'C_BPartner_UU',
	iscentrallymaintained = 'N',
	fieldlength           = 36,
	ismandatory           = 'N',
	ad_element_id         = 54699,
	entitytype            = 'U',
	daterangeoption       = 'D',
	isshownegatebutton    = 'N'
WHERE
	ad_process_para_id = (
		SELECT ad_process_para_id FROM ad_process_para WHERE ad_process_para_uu = '59d8caf6-425d-48fc-a54e-26d40f572882'
	);
	
SELECT
	register_migration_script('202509121256_GO-3374.sql')
FROM
	dual;	
	