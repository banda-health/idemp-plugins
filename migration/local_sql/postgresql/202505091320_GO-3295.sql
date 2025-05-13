-- Add the ad element for colour codes
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT
			 MAX(ad_element_id) + 1
		 FROM
			 ad_element
	 ), 0, 0, 'Y', '2025-05-09 12:22:49.077828', 100, '2025-05-09 12:22:49.077828', 100, 'BH_ColourCode', 'U',
	 'Colour Code', 'Colour Code', NULL, NULL, NULL, NULL, NULL, NULL, 'ab262c2a-6c7d-46da-b110-77de84f28573', NULL);

-- Update the column to use it
UPDATE ad_column
SET
	ad_element_id  = (
		SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ab262c2a-6c7d-46da-b110-77de84f28573'
	),
	version        = 1,
	seqno          = NULL,
	seqnoselection = NULL
WHERE
	ad_column_uu = '044cae97-26e1-4a5d-86a7-9defce40bb7d';

SELECT
	register_migration_script('202505091320_GO-3295.sql')
FROM
	dual;
