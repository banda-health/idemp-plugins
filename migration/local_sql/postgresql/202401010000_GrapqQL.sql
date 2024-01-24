-- Make casing correct on this column for code-generation purposes
UPDATE ad_column
SET
    columnname = 'BH_Voided_Reason_UU'
WHERE
    ad_column_uu = '376e96e5-0b52-4daa-87f9-4d3a4dcd86d4';

-- Not sure where this column came from, but it should be on the product category itself, so remove it
ALTER TABLE m_product
    DROP COLUMN bh_product_category_type;
-- These are old fields that were meant for testing that shouldn't be in PROD
ALTER TABLE ad_user
    DROP COLUMN bandahealth_bpartners;
ALTER TABLE ad_user
    DROP COLUMN eve_bpartners;

-- Delete the columns that were removed above
DELETE
FROM
    ad_column
WHERE
    ad_column_uu IN ('14faefde-8b98-4e8a-b703-b0f36091656d', '6709aa10-f347-451e-9824-c09f29082bb3',
                     '80ed368a-7b59-44d3-b977-9583e60e4528');

SELECT
    register_migration_script('202401010000_GrapqQL.sql')
FROM
    dual;