-- Add the price list parameter to the products and prices report
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
	 ), 0, 0, 'Y', '2025-02-28 13:37:27.067000', 100, '2025-02-28 13:42:30.718000', 100, 'Price List', NULL, NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3edf67b9-ee3d-4b73-a02e-deb1c1811db5'
	 ), 10, 19, NULL, NULL, 'M_PriceList_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, 55013, 'U', NULL, NULL,
	 'e14e5949-970a-4a02-a679-e3b12d64b558', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

-- Register the script and be done
SELECT
	register_migration_script('202502281416_GO-3208.sql')
FROM
	dual;
