ALTER TABLE
    bh_encounter
ADD
    COLUMN IF NOT EXISTS bh_encounter_date TIMESTAMP DEFAULT NULL;

-- COPY EXISTING RECORDS IN created column
UPDATE
    bh_encounter
SET
	bh_encounter_date = created
WHERE
	bh_encounter_date IS NULL;

ALTER TABLE bh_encounter
	ALTER COLUMN bh_encounter_date SET NOT NULL;

-- Add entry into AD_Element table
INSERT INTO
    ad_element (
        ad_element_id,
        ad_client_id,
        ad_org_id,
        isactive,
        created,
        createdby,
        updated,
        updatedby,
        columnname,
        entitytype,
        name,
        printname,
        description,
        help,
        po_name,
        po_printname,
        po_description,
        po_help,
        ad_element_uu,
        placeholder
    )
VALUES
    (
        (
            SELECT
                MAX(AD_Element_ID) + 1
            FROM
                AD_Element
        ),
        0,
        0,
        'Y',
        '2024-05-03 14:31:14.862',
        100,
        '2024-05-03 14:31:14.862',
        100,
        'BH_Encounter_Date',
        'U',
        'Encounter Date',
        'The time a vital was taken',
        null,
        null,
        null,
        null,
        null,
        null,
        '06f62685-69f4-4fdc-979d-55a1875e5a2a',
        null
    ) ON CONFLICT DO NOTHING;

-- Add entry into AD_Column table
INSERT INTO
    ad_column (
        ad_column_id,
        ad_client_id,
        ad_org_id,
        isactive,
        created,
        updated,
        createdby,
        updatedby,
        name,
        description,
        help,
        version,
        entitytype,
        columnname,
        ad_table_id,
        ad_reference_id,
        ad_reference_value_id,
        ad_val_rule_id,
        fieldlength,
        defaultvalue,
        iskey,
        isparent,
        ismandatory,
        isupdateable,
        readonlylogic,
        isidentifier,
        seqno,
        istranslated,
        isencrypted,
        callout,
        vformat,
        valuemin,
        valuemax,
        isselectioncolumn,
        ad_element_id,
        ad_process_id,
        issyncdatabase,
        isalwaysupdateable,
        columnsql,
        mandatorylogic,
        infofactoryclass,
        isautocomplete,
        isallowlogging,
        formatpattern,
        ad_column_uu,
        isallowcopy,
        seqnoselection,
        istoolbarbutton,
        issecure,
        ad_chart_id,
        fkconstraintname,
        fkconstrainttype,
        pa_dashboardcontent_id,
        placeholder,
        ishtml,
        ad_val_rule_lookup_id,
        ad_infowindow_id,
        alwaysupdatablelogic,
        fkconstraintmsg_id,
        partitioningmethod,
        ispartitionkey,
        seqnopartition,
        rangepartitioninterval
    )
VALUES
    (
        (
            SELECT
                MAX(AD_Column_ID) + 1
            FROM
                AD_Column
        ),
        0,
        0,
        'Y',
        '2024-05-03 14:31:53.295',
        '2024-05-03 14:31:53.295',
        100,
        100,
        'Encounter Date',
        'When an observation was taken',
        'An encounter date is the date an observation was taken i.e weight, height, BMI, Temperature e.t.c',
        0,
        'U',
        'BH_Encounter_Date',
        (
            SELECT
                AD_Table_ID
            From
                AD_Table
            WHERE
                AD_Table_UU = '755aac0f-8697-4520-ba42-08ad092299cd'
        ),
        16,
        null,
        null,
        7,
        null,
        'N',
        'N',
        'Y',
        'Y',
        null,
        'N',
        0,
        'N',
        'N',
        null,
        null,
        null,
        null,
        'N',
        (
            SELECT
                AD_Element_ID
            From
                AD_Element
            WHERE
                AD_Element_UU = '06f62685-69f4-4fdc-979d-55a1875e5a2a'
        ),
        null,
        'N',
        'N',
        null,
        null,
        null,
        'N',
        'Y',
        null,
        '57237cfb-6088-4507-8f38-e10c36d5eaeb',
        'Y',
        0,
        'N',
        'N',
        null,
        null,
        'N',
        null,
        null,
        'N',
        null,
        null,
        null,
        null,
        null,
        'N',
        null,
        null
    ) ON CONFLICT DO NOTHING;

SELECT
    register_migration_script('202405081243_GO-2866.sql')
FROM
    dual;
