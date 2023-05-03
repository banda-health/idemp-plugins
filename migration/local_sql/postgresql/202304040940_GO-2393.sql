-- Create the expired-stock-cleaning process
INSERT INTO
	adempiere.ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
	                      name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint,
	                      ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id,
	                      workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport,
	                      ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype,
	                      allowmultipleexecution)
VALUES
	((
		 SELECT
				 MAX(ad_process_id) + 1
		 FROM
			 ad_process
	 ), 0, 0, 'Y', '2023-04-11 12:16:15.553000', 100, '2023-04-11 12:16:15.553000', 100, (
		 SELECT
			 (MAX(CASE WHEN isnumeric(value) THEN value::numeric ELSE 0 END) + 1)::varchar
		 FROM
			 ad_process
	 ), 'BH Update Expired Stock Process', 'Remove lots with zero quantity or lots that are expired', NULL, '3', 'U',
	 NULL, 'N', 'N', NULL, 'org.bandahealth.idempiere.base.process.CleanExpiredStockProcess', 0, 0, NULL, NULL, NULL,
	 'N', 'N', 'Y', NULL, NULL, 'N', 'e79541fb-9b70-4a10-bfef-7401401b8c56', NULL, NULL, 'P')
ON CONFLICT DO NOTHING;

-- Add the process to the correct existing roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	100,
	100
FROM
	ad_process p
		JOIN ad_role r
			ON r.ismanual = 'N' AND r.ismasterrole = 'N'
WHERE
		p.ad_process_uu = 'e79541fb-9b70-4a10-bfef-7401401b8c56'
ON CONFLICT DO NOTHING;

-- Ensure the clean process is available to the correct roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	100,
	100
FROM
	ad_process p
		JOIN ad_role r
			ON r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', -- clinic admin
			                    'ee008abc-2c16-4230-b48c-b1f5577ea270', -- cashier/registration advanced
			                    'ec17fee0-a53a-4dbb-b946-423ce14880eb', -- inventory/pharmacy
			                    'c54253cf-c86b-4aaa-b472-ed8880635c62', -- clinician/nurse advanced
			                    '097feff0-3aa6-41fe-bf76-936b03859846' -- lab/radiology
		)
WHERE
		p.ad_process_uu = 'e79541fb-9b70-4a10-bfef-7401401b8c56';

-- Ensure the base clean process is available to the correct roles
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	100,
	100
FROM
	ad_process p
		JOIN ad_role r
			ON r.ad_role_uu IN ('461b31c5-cae2-449d-8a0c-7385b12f4685', -- clinic admin
			                    'ee008abc-2c16-4230-b48c-b1f5577ea270', -- cashier/registration advanced
			                    'ec17fee0-a53a-4dbb-b946-423ce14880eb', -- inventory/pharmacy
			                    'c54253cf-c86b-4aaa-b472-ed8880635c62', -- clinician/nurse advanced
			                    '097feff0-3aa6-41fe-bf76-936b03859846' -- lab/radiology
		)
WHERE
		p.ad_process_uu = '8e270648-1d54-46d9-9161-2d0300dd80ff';

SELECT
	update_sequences();

SELECT
	register_migration_script('202304040940_GO-2393.sql')
FROM
	dual;
