-- Add BH_SoonToExpireDays column to M_Product table
-- This field allows users to specify how many days before expiration a product should be considered "soon to expire"
-- Users can select 30, 60, or 90 days, or leave it blank to exclude from calculations

-- Add the column to the M_Product table
ALTER TABLE m_product
ADD COLUMN IF NOT EXISTS bh_soontoexpiredays numeric(10);

-- Create the system element for the new field
INSERT INTO ad_element (
    ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, 
    columnname, entitytype, name, printname, description, help, 
    po_name, po_printname, po_description, po_help, ad_element_uu, placeholder
) VALUES (
    (SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', 
    '2025-08-20 16:00:00.000000', 100, '2025-08-20 16:00:00.000000', 100,
    'BH_SoonToExpireDays', 'U', 'Soon To Expire Days', 'Soon To Expire Days',
    'Number of days before expiration to consider product as "soon to expire". Leave blank to exclude from calculations.',
    'Specify how many days before expiration a product should be flagged as "soon to expire". Common values are 30, 60, or 90 days.',
    null, null, null, null, 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', null
);

-- Create the column definition in ad_column
INSERT INTO ad_column (
    ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby,
    name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, 
    ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, 
    isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, 
    valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, 
    isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, 
    formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, 
    fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml
) VALUES (
    (SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y',
    '2025-08-20 16:00:00.000000', '2025-08-20 16:00:00.000000', 100, 100,
    'BH_SoonToExpireDays', 'Number of days before expiration to consider product as "soon to expire"',
    'Specify how many days before expiration a product should be flagged as "soon to expire". Common values are 30, 60, or 90 days.',
    0, 'U', 'BH_SoonToExpireDays', 208, 11, null, null, 3, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', 
    null, null, 1, 365, 'N', 
    (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'), 
    null, 'N', 'N', null, null, null, 'N', 'Y', null, 'b2c3d4e5-f6g7-8901-bcde-f23456789012', 'Y', null, 'N', 'N', 
    null, null, 'N', null, null, 'N'
) ON CONFLICT DO NOTHING;

-- Register the migration script
SELECT register_migration_script('202509011050_GO-3373.sql') FROM dual;
