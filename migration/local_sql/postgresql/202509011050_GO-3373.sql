-- Add BH_SoonToExpireDays column to M_Product table
ALTER TABLE m_product ADD COLUMN IF NOT EXISTS bh_soon_to_expire_days varchar(10);

-- Create reference for BH_SoonToExpireDays
INSERT INTO
	ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	              name, description, validationtype, vformat, ad_reference_uu)
VALUES
	((
		 SELECT MAX(ad_reference_id) + 1
		 FROM ad_reference
	 ), 0, 0, 'Y', '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
	 'BH_SoonToExpireDays', 'Soon To Expire Days Options', 'L', NULL,
	 'c2d3e4f5-a6b7-8901-cdef-123456789012');

-- Create reference list values for BH_SoonToExpireDays
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	             ad_reference_id, value, name, description, ad_ref_list_uu)
VALUES
	((
		 SELECT MAX(ad_ref_list_id) + 1
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'c2d3e4f5-a6b7-8901-cdef-123456789012'
	 ),
	 '30', '30 Days', 'Consider product as soon to expire 30 days before expiration',
	 'd3e4f5a6-b7c8-9012-def3-456789012345'),
	((
		 SELECT MAX(ad_ref_list_id) + 2
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'c2d3e4f5-a6b7-8901-cdef-123456789012'
	 ),
	 '60', '60 Days', 'Consider product as soon to expire 60 days before expiration',
	 'e4f5a6b7-c8d9-0123-ef45-678901234567'),
	((
		 SELECT MAX(ad_ref_list_id) + 3
		 FROM ad_ref_list
	 ), 0, 0, 'Y', '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'c2d3e4f5-a6b7-8901-cdef-123456789012'
	 ),
	 '90', '90 Days', 'Consider product as soon to expire 90 days before expiration',
	 'f5a6b7c8-d9e0-1234-f567-890123456789');

-- Create system element for BH_SoonToExpireDays
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	            columnname, entitytype, name, printname, description, help, ad_element_uu)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
	 'BH_SoonToExpireDays', 'U', 'Soon To Expire Days', 'Soon To Expire Days',
	 'Number of days before expiration to consider product as "soon to expire". Leave blank to exclude from calculations.',
	 'Select the number of days before expiration to consider this product as "soon to expire". Leave blank to exclude from calculations.',
	 'a1b2c3d4-e5f6-7890-abcd-ef1234567890');

-- Create column definition for BH_SoonToExpireDays
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
	 ), 0, 0, 'Y', '2025-09-01 16:00:00.000000', '2025-09-01 16:00:00.000000', 100, 100, 'BH_SoonToExpireDays',
	 'Number of days before expiration to consider product as "soon to expire". Leave blank to exclude from calculations.',
	 'Select the number of days before expiration to consider this product as "soon to expire". Leave blank to exclude from calculations.',
	 0, 'D', 'BH_SoonToExpireDays', 208, 17, (
		 SELECT
			 ad_reference_id
		 FROM
			 ad_reference
		 WHERE
			 ad_reference_uu = 'c2d3e4f5-a6b7-8901-cdef-123456789012'
	 ), NULL, 10, '', 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', ((
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'
	)
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL,
	 'b7c8d9e0-f1a2-3456-b789-012345678901', 'Y', NULL, 'N', 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL, NULL,
	 NULL, NULL, 'N', NULL, NULL);
	 
-- Register the migration script
SELECT register_migration_script('202509011050_GO-3373.sql') FROM dual;