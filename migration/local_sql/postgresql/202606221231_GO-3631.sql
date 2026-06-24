-- GO-3631: Self-service clinic (client) rename.
-- Registers the RenameClientProcess (Java) with "Clinic" (target) and "New Clinic Name" parameters and
-- grants access only to the System Administrator and Implementer roles (both system-level). The process
-- calls the reusable bh_rename_client() function
-- (see migration/processes_post_migration/postgresql/bh_rename_client.sql). Audit is via AD_PInstance.

-- 1. The process
INSERT INTO
	ad_process (ad_process_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
	            name, description, help, accesslevel, entitytype, procedurename, isreport, isdirectprint,
	            ad_reportview_id, classname, statistic_count, statistic_seconds, ad_printformat_id,
	            workflowvalue, ad_workflow_id, isbetafunctionality, isserverprocess, showhelp, jasperreport,
	            ad_form_id, copyfromprocess, ad_process_uu, ad_ctxhelp_id, executiontype,
	            allowmultipleexecution, filenamepattern)
VALUES
	((
		 SELECT
			 MAX(ad_process_id) + 1
		 FROM
			 ad_process
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'BH_RenameClinic',
	 'Rename Clinic', 'Rename a clinic and update the new name everywhere it is used (org, warehouse, roles, '
		 || 'reports). Implementers and administrators only.', NULL,
	 '3', 'U', NULL, 'N', 'N', NULL, 'org.bandahealth.idempiere.base.process.RenameClientProcess', 0, 0, NULL, NULL,
	 NULL, 'N', 'N', 'Y', NULL, NULL, 'N', '730ece81-bfa9-418c-b73a-fe270507b94f', NULL, 'P', 'N', NULL);

-- 2. The "New Clinic Name" parameter (String, mandatory). The clinic to rename is the current
--    client from context, so no client parameter is needed.
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                 updatedby, name, description, help, ad_process_id, seqno, ad_reference_id,
	                 ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength,
	                 ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax,
	                 ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted,
	                 mandatorylogic, placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
	                 daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT
			 MAX(ad_process_para_id) + 1
		 FROM
			 ad_process_para
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100,
	 'New Clinic Name', 'The new name for this clinic', NULL,
	 (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '730ece81-bfa9-418c-b73a-fe270507b94f'
	 ), 20,
	 10, NULL, NULL, 'BH_NewClinicName', 'N', 60, 'Y', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '37a63b20-4034-46e6-b639-c58aa1fba915', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- 3. Restricted access: grant only to the System Administrator and Implementer roles (both system-level)
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby,
	                   updated, updatedby, isreadwrite, ad_process_access_uu)
SELECT
	p.ad_process_id,
	r.ad_role_id,
	r.ad_client_id,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_process p
		JOIN ad_role r
			ON r.ad_role_uu IN (
			                    '8e8ffdb2-dd04-4473-9dc7-3185874017e6', -- System Administrator
			                    'd162fcdb-22ff-4004-8685-f9ebef1aa273' -- Implementer
		)
WHERE
	p.ad_process_uu = '730ece81-bfa9-418c-b73a-fe270507b94f'
ON CONFLICT DO NOTHING;

SELECT
	update_sequences();

SELECT
	register_migration_script('202606221231_GO-3631.sql')
FROM
	dual;
