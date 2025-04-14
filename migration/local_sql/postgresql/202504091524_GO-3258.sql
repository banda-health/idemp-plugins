-- Add the new report
INSERT INTO
	ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	            description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint, ad_reportview_id,
	            classname, statistic_count, statistic_seconds, ad_printformat_id, workflowvalue, ad_workflow_id,
	            isbetafunctionality, isserverprocess, showhelp, jasperreport, ad_form_id, copyfromprocess, ad_process_uu,
	            ad_ctxhelp_id, executiontype, allowmultipleexecution, filenamepattern)
VALUES
	((
		 SELECT
			 MAX(ad_process_id) + 1
		 FROM
			 ad_process
	 ), 0, 0, 'Y', '2025-04-09 15:27:31.043000', 100, '2025-04-09 15:27:54.220000', 100, '10000001',
	 'Over-the-Counter (OTC) Sales', 'A list of all OTC sales and totals', NULL, '3', 'U', NULL, 'N', 'N', NULL, NULL, 0,
	 0, NULL, NULL, NULL, 'N', NULL, 'Y', 'otcSales/OTCSales.jasper', NULL, 'N', 'b8508f0a-c66f-4030-a88c-3ae383322ceb',
	 NULL, NULL, 'P', NULL);

-- Add the parameters
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', '2025-04-09 11:47:21.035000', 100, '2025-04-09 11:47:21.035000', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'fb2fda8a-3c8b-4f1b-b598-591fa3e7dd6c', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', '2025-04-06 11:46:52.581000', 100, '2025-04-09 11:46:52.581000', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '79f750e5-3ddf-4119-8120-602c77869575', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Update the report dropdown menu
INSERT INTO
	ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description,
	         issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id,
	         ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname,
	         predefinedcontextvariables)
VALUES
	((
		 SELECT
			 MAX(ad_menu_id) + 1
		 FROM
			 ad_menu
	 ), 0, 0, 'Y', '2025-04-09 15:32:29.583000', 100, '2025-04-09 15:32:29.583000', 'Over-the-Counter (OTC) Sales', 100,
	 NULL, 'N', 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
	 ), NULL, NULL, 'U', 'Y', '196c4606-0610-48a2-a15f-6f560d0d2299', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '196c4606-0610-48a2-a15f-6f560d0d2299'
	), 0, 0, 'Y', '2025-04-09 15:32:29.623104', 100, '2025-04-09 15:32:54.123000', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'
	 ), 24, 'f91e092c-7c04-4dce-8f4e-3591ac90472c');

-- Add correct access
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_role r
		JOIN ad_process p
		ON p.ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb'
WHERE
	r.ad_role_uu IN ('93365778-a2d9-433b-b962-87fb150db4fa', '461b31c5-cae2-449d-8a0c-7385b12f4685',
	                 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e', 'ec17fee0-a53a-4dbb-b946-423ce14880eb',
	                 '09eb7fc8-9cc5-44b0-9d14-15258a066038', 'ee008abc-2c16-4230-b48c-b1f5577ea270',
	                 'a1618fd6-e1ab-4e41-a08d-854229cd5971', 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a');

-- Register the script
SELECT
	register_migration_script('202504091524_GO-3258.sql')
FROM
	dual;
