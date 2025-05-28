-- Create tags parameter for inventory sold report
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	                 description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	                 columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2,
	                 vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic,
	                 ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete,
	                 ad_fieldgroup_id, query, daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2025-05-23 09:46:10.141000', 100, '2025-05-23 09:46:10.141000', 100, 'Tags', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1211e173-6f12-4e2f-bfcc-d43d48af51c3'
	 ), 30, 200162, (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b45bfe6-70e4-4327-843f-1ce7bc2bb646'
	 ), NULL, 'BH_Tag_UU', 'Y', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd814e5b4-ec8c-4463-b956-1e493fd39835'
	 ), 'U', NULL, NULL, 'e4d09b67-0da6-4be5-aca8-23ef940e9acf', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

SELECT
	register_migration_script('202505231016_GO-3295.sql')
FROM
	dual;
