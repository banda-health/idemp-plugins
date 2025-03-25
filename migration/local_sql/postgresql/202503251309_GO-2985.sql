-- Add new parameters to the OCL sync process
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
	 ), 0, 0, 'Y', '2025-03-24 15:22:25.376497', 100, '2025-03-24 15:22:25.376497', 100, 'Exclude Mappings', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '97542544-da63-4e5f-85e0-ad35da81318c'
	 ), 30, 20, NULL, NULL, 'Shallow', 'N', 0, 'N', 'N', 'N', NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '07a16459-218c-483a-85a8-d1a68d6e99f2', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-03-24 15:22:25.376497', 100, '2025-03-24 15:22:25.376497', 100, 'Skip Fetching Mapping Concepts',
	 NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '97542544-da63-4e5f-85e0-ad35da81318c'
	 ), 40, 20, NULL, NULL, 'SkipMappings', 'N', 0, 'N', 'N', 'N', NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '769feba4-8237-4187-b5f8-5511cc338fa0', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');
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
	 ), 0, 0, 'Y', '2025-03-24 15:22:25.376497', 100, '2025-03-24 15:22:25.376497', 100, 'Concept ID Filter', NULL, NULL,
	 (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '97542544-da63-4e5f-85e0-ad35da81318c'
	 ), 50, 10, NULL, NULL, 'SourceIDFilter', 'N', 0, 'N', 'N', '', NULL, NULL, NULL, NULL, NULL, 'U', NULL, NULL,
	 '006f7d36-6303-4c67-9e56-85d39d091a57', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Update execution parameters
UPDATE ad_process
SET
	allowmultipleexecution = 'NA'
WHERE
	ad_process_uu = '97542544-da63-4e5f-85e0-ad35da81318c';

-- Add the new source
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	             description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', '2025-03-25 09:24:19.022000', 100, '2025-03-25 09:24:19.022000', 100, 'BHDrugs', 'BHDrugs - Drug list',
	 'The drugs we use in Banda', (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	 ), NULL, NULL, 'U', 'be0c7cb3-baf7-47fa-b420-80e99b8e0382', NULL, NULL);

-- Ensure the source selector on the OCL Sync Process is a reference list
UPDATE ad_process_para
SET
	ad_reference_id       = 17,
	ad_reference_value_id = (
		SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6e6a9ace-0369-4ede-937a-8b40c752b80c'
	)
WHERE
	ad_process_para_uu = '6287b949-1088-4e93-a9dc-644be8657918';

SELECT
	update_sequences();

-- Wrap up and be done
SELECT
	register_migration_script('202503251309_GO-2985.sql')
FROM
	dual;
