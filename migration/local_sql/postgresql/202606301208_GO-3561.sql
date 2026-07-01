-- GO-3561: Purchased Stock Report
-- A JasperReport listing stock purchases (PO-linked vendor bills with a goods receipt) over a
-- period, with vendor AP balances. Surfaced through the generic report process pipeline.

-- 1. Create the report process
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
	 ), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 100, '10000003', 'Purchased Stock Report',
	 'Stock purchases over a period with vendor AP balances', NULL, '3', 'U', NULL, 'Y', 'N', NULL, NULL, 0, 0, NULL,
	 NULL, NULL, 'N', NULL, 'Y', 'Purchased Stock Report/Purchased Stock Report.jasper', NULL, 'N',
	 '113867a8-c1b0-4f80-8472-2c3cfc06abf5', NULL, NULL, 'P', NULL);

-- 2. Parameters: Begin Date, End Date (date range) and an optional Supplier
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
	 ), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 100, 'Begin Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '113867a8-c1b0-4f80-8472-2c3cfc06abf5'
	 ), 10, 16, NULL, NULL, 'Begin Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'b0ef27f2-0edd-4586-bc32-ec917bed5ce7', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 100, 'End Date', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '113867a8-c1b0-4f80-8472-2c3cfc06abf5'
	 ), 20, 16, NULL, NULL, 'End Date', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '06f09ee9-0745-43ed-9ab5-a0b6f7ab8dd7', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 100, 'Supplier', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '113867a8-c1b0-4f80-8472-2c3cfc06abf5'
	 ), 30, 19, NULL, NULL, 'C_BPartner_UU', 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 'be84ca81-cad9-4cea-89d2-418e938fe814', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'N', 'N');

-- 3. Add the report to the Financial reports menu group
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
	 ), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 'Purchased Stock Report', 100,
	 'Stock purchases over a period with vendor AP balances', 'N', 'Y', 'N', 'P', NULL, NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '113867a8-c1b0-4f80-8472-2c3cfc06abf5'
	 ), NULL, NULL, 'U', 'Y', '77523c8a-7fe9-4c62-9aac-68330f4f001e', NULL, NULL, NULL);

INSERT INTO
	ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               parent_id, seqno, ad_treenodemm_uu)
VALUES
	(10, (
		SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '77523c8a-7fe9-4c62-9aac-68330f4f001e'
	), 0, 0, 'Y', '2026-06-30 12:08:00', 100, '2026-06-30 12:08:00', 100, (
		 SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '669051b6-195c-420d-9b35-b62b4fc44c32'
	 ), 15, '93479714-a478-4db7-9d10-94d9bbf3c9bd');

-- 4. Report role access. Generated by .cursor/skills/sync-role-access from the standard role matrix;
--    do not hand-edit the role list. Regenerate with:
--      python3 .cursor/skills/sync-role-access/generate.py --report "Purchased Stocks"
-- Report role access for: purchased stocks  (from standard role matrix; regenerate via .cursor/skills/sync-role-access)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
SELECT
	p.ad_process_id, r.ad_role_id, 0, 0, 'Y', NOW(), 100, NOW(), 100, 'Y', uuid_generate_v4()
FROM
	ad_process p
		JOIN ad_role r ON r.ad_role_uu IN (
			'93365778-a2d9-433b-b962-87fb150db4fa', -- Accounting
			'461b31c5-cae2-449d-8a0c-7385b12f4685', -- Clinic Admin
			'c54253cf-c86b-4aaa-b472-ed8880635c62', -- Clinician/ Nurse Advanced
			'ec17fee0-a53a-4dbb-b946-423ce14880eb', -- Inventory/ Pharmacy Advanced
			'a1618fd6-e1ab-4e41-a08d-854229cd5971', -- Inventory/ Pharmacy Basic
			'097feff0-3aa6-41fe-bf76-936b03859846', -- Lab/ Radiology Advanced
			'17ccea57-1131-4d51-83ca-1824182e4493', -- Lab/ Radiology Basic
			'b986f846-09bc-461e-956a-e524fd75aa8a' -- OTC Only
		)
WHERE
	p.ad_process_uu = '113867a8-c1b0-4f80-8472-2c3cfc06abf5'
	AND NOT EXISTS (
		SELECT 1 FROM ad_process_access x WHERE x.ad_process_id = p.ad_process_id AND x.ad_role_id = r.ad_role_id
	);

SELECT update_sequences();

SELECT
	register_migration_script('202606301208_GO-3561.sql')
FROM
	dual;
