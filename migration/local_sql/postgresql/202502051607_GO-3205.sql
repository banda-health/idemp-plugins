-- update ad_element
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	            columnname, entitytype, name, printname, description, help, po_name, po_printname,
	            po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-02-05 15:41:38.199000', 100, '2025-02-05 15:41:38.199000', 100,
	 'BH_PriceList3_SellPrice', 'U', 'BH_PriceList3_SellPrice', 'Price list three sell  price', NULL, NULL, NULL,
	 NULL, NULL, NULL, '1a6f048e-9109-4da8-a862-b5b3b7dc5b0d', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	            columnname, entitytype, name, printname, description, help, po_name, po_printname,
	            po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-02-05 15:40:57.714000', 100, '2025-02-05 15:40:57.714000', 100,
	 'BH_PriceList3_Name', 'U', 'BH_PriceList3_Name', 'Third price list name', NULL, NULL, NULL, NULL, NULL, NULL,
	 'a188a775-3e4c-43de-9463-9f788ae6ed6d', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	            columnname, entitytype, name, printname, description, help, po_name, po_printname,
	            po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-02-05 15:39:41.374000', 100, '2025-02-05 15:39:41.374000', 100,
	 'BH_PriceList2_SellPrice', 'U', 'BH_PriceList2_SellPrice', 'Second Price List Selling price', NULL, NULL, NULL,
	 NULL, NULL, NULL, '9df98382-3ee0-471d-8910-fd756da38830', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	            columnname, entitytype, name, printname, description, help, po_name, po_printname,
	            po_description, po_help, ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-02-05 15:37:48.715000', 100, '2025-02-05 15:43:57.221000', 100,
	 'BH_PriceList2_Name', 'U', 'BH_PriceList2_Name', 'Second PriceList', NULL, NULL, NULL, NULL, NULL, NULL,
	 'bc9af9ee-dbe8-4195-867e-28507d5313f3', NULL);

-- Update ad_column
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
	           description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
	           ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
	           isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
	           valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
	           partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-02-05 15:58:56.994000', '2025-02-05 15:58:56.994000', 100, 100,
	 'BH_PriceList3_SellPrice', NULL, NULL, 0, 'U', 'BH_PriceList3_SellPrice',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2a525b7-75d6-4bac-9bdc-010d00f8a56c'
	 ), 12, NULL, NULL,
	 14, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1a6f048e-9109-4da8-a862-b5b3b7dc5b0d'
	 ), NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b0ae86bb-72cc-47a8-9b5a-58d4679032ab', 'Y', 0, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
	           description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
	           ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
	           isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
	           valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
	           partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-02-05 15:57:34.806000', '2025-02-05 15:57:34.806000', 100, 100,
	 'BH_PriceList3_Name', NULL, NULL, 0, 'U', 'BH_PriceList3_Name',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2a525b7-75d6-4bac-9bdc-010d00f8a56c'
	 ), 36, NULL, NULL,
	 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a188a775-3e4c-43de-9463-9f788ae6ed6d'
	 ), NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '4809ca7d-3c0b-4bb7-b02a-6117b2a113e7', 'Y', 50, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
	           description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
	           ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
	           isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
	           valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
	           partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-02-05 15:56:13.960000', '2025-02-05 15:56:13.960000', 100, 100,
	 'BH_PriceList2_SellPrice', NULL, NULL, 0, 'U', 'BH_PriceList2_SellPrice',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2a525b7-75d6-4bac-9bdc-010d00f8a56c'
	 ), 12, NULL, NULL,
	 14, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '9df98382-3ee0-471d-8910-fd756da38830'
	 ), NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '18fc56b1-4202-4cc7-b2c7-68235ee6f53f', 'Y', 0, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name,
	           description, help, version, entitytype, columnname, ad_table_id, ad_reference_id,
	           ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory,
	           isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat,
	           valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase,
	           isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging,
	           formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id,
	           fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id,
	           partitioningmethod, ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT
			 MAX(ad_column_id) + 1
		 FROM
			 ad_column
	 ), 0, 0, 'Y', '2025-02-05 15:51:58.520000', '2025-02-05 15:51:58.520000', 100, 100,
	 'BH_PriceList2_Name', NULL, NULL, 0, 'U', 'BH_PriceList2_Name',
	 (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'd2a525b7-75d6-4bac-9bdc-010d00f8a56c'
	 ), 36, NULL, NULL,
	 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'Y',
	 (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'bc9af9ee-dbe8-4195-867e-28507d5313f3'
	 ), NULL, 'N',
	 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '879ce3db-bca9-44fb-90ed-cc574db8a699', 'Y', 40, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);


ALTER TABLE BH_I_Product_Quantity
	ADD COLUMN BH_PriceList2_Name TEXT DEFAULT NULL;

ALTER TABLE BH_I_Product_Quantity
	ADD COLUMN BH_PriceList2_SellPrice NUMERIC DEFAULT NULL;

ALTER TABLE BH_I_Product_Quantity
	ADD COLUMN BH_PriceList3_Name TEXT DEFAULT NULL;

ALTER TABLE BH_I_Product_Quantity
	ADD COLUMN BH_PriceList3_SellPrice NUMERIC DEFAULT NULL;

--- Update ad_impformat_row
INSERT INTO
	ad_impformat_row (ad_impformat_row_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, ad_impformat_id, seqno, name, ad_column_id, startno, endno, datatype,
	                  dataformat, decimalpoint, divideby100, constantvalue, callout, script,
	                  ad_impformat_row_uu, importprefix)
VALUES
	((
		 SELECT MAX(ad_impformat_row_id) + 1
		 FROM ad_impformat_row
	 ), 0, 0, 'Y', '2025-02-05 17:05:34.367000', 100,
	 '2025-02-05 17:05:34.367000', 100,
	 (
		 SELECT ad_impformat_id FROM ad_impformat WHERE ad_impformat_uu = '0491588f-ece5-4fd4-bfff-2af00e975918'
	 ), 180,
	 'Price List 3 Sell Price',
	 (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'b0ae86bb-72cc-47a8-9b5a-58d4679032ab'
	 ), 18, 0, 'N',
	 NULL, '.', 'N', NULL, NULL, NULL,
	 '5e56ea0c-1872-4f04-8097-d035819222dc', NULL);
INSERT INTO
	ad_impformat_row (ad_impformat_row_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, ad_impformat_id, seqno, name, ad_column_id, startno, endno, datatype,
	                  dataformat, decimalpoint, divideby100, constantvalue, callout, script,
	                  ad_impformat_row_uu, importprefix)
VALUES
	((
		 SELECT MAX(ad_impformat_row_id) + 1
		 FROM ad_impformat_row
	 ), 0, 0, 'Y', '2025-02-05 17:04:51.536000', 100,
	 '2025-02-05 17:04:51.536000', 100,
	 (
		 SELECT ad_impformat_id FROM ad_impformat WHERE ad_impformat_uu = '0491588f-ece5-4fd4-bfff-2af00e975918'
	 ), 170,
	 'Price List 3 Name',
	 (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '4809ca7d-3c0b-4bb7-b02a-6117b2a113e7'
	 ), 17, 0, 'S',
	 NULL, '.', 'N', NULL, NULL, NULL,
	 '511b74d2-1aed-42da-97ed-82f2b28799b9', NULL);
INSERT INTO
	ad_impformat_row (ad_impformat_row_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, ad_impformat_id, seqno, name, ad_column_id, startno, endno, datatype,
	                  dataformat, decimalpoint, divideby100, constantvalue, callout, script,
	                  ad_impformat_row_uu, importprefix)
VALUES
	((
		 SELECT MAX(ad_impformat_row_id) + 1
		 FROM ad_impformat_row
	 ), 0, 0, 'Y', '2025-02-05 17:04:10.465000', 100,
	 '2025-02-05 17:04:10.465000', 100,
	 (
		 SELECT ad_impformat_id FROM ad_impformat WHERE ad_impformat_uu = '0491588f-ece5-4fd4-bfff-2af00e975918'
	 ), 160,
	 'Price List 2 Sell Price',
	 (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '18fc56b1-4202-4cc7-b2c7-68235ee6f53f'
	 ), 16, 0, 'N',
	 NULL, '.', 'N', NULL, NULL, NULL,
	 '8f175922-3693-45b2-846e-c7a3aaf94fe5', NULL);
INSERT INTO
	ad_impformat_row (ad_impformat_row_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                  updatedby, ad_impformat_id, seqno, name, ad_column_id, startno, endno, datatype,
	                  dataformat, decimalpoint, divideby100, constantvalue, callout, script,
	                  ad_impformat_row_uu, importprefix)
VALUES
	((
		 SELECT MAX(ad_impformat_row_id) + 1
		 FROM ad_impformat_row
	 ), 0, 0, 'Y', '2025-02-05 16:58:59.974000', 100,
	 '2025-02-05 17:03:06.915000', 100,
	 (
		 SELECT ad_impformat_id FROM ad_impformat WHERE ad_impformat_uu = '0491588f-ece5-4fd4-bfff-2af00e975918'
	 ), 150,
	 'Price List 2 Name',
	 (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '879ce3db-bca9-44fb-90ed-cc574db8a699'
	 ), 15, 0, 'S',
	 NULL, '.', 'N', NULL, NULL, NULL,
	 '1eb8a930-a2f5-4fbd-bbf5-7a01b6029f41', NULL);


-- Register the script and be done
SELECT
	register_migration_script('202502051607_GO-3205.sql')
FROM
	dual;
