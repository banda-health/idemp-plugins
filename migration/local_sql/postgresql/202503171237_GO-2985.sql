-- Update the icon for FA 5
UPDATE ad_menu
SET
	iconclassname = 'fas fa-book-medical'
WHERE
	ad_menu_uu = 'b2bc0064-0825-453f-b06a-7f23513f1f8f';

-- Update the OCL originating source names to be longer
ALTER TABLE bh_ocl_originating_source
	ALTER COLUMN bh_ocl_source TYPE VARCHAR(255);
UPDATE ad_column
SET
	fieldlength = 255
WHERE
	ad_column_uu = 'cc06a7c2-3f5b-4c90-934e-295315131314';

-- Wrap up and be done
SELECT
	register_migration_script('202503171237_GO-2985.sql')
FROM
	dual;
