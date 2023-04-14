--add new columns to hold BP readings
alter table c_order
add column bh_systolic_blood_pressure numeric,
add column bh_diastolic_blood_pressure numeric;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(ad_element.ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2021-10-21 12:47:14.163000', 100, '2021-10-21 12:47:14.163000', 100, 'bh_systolic_blood_pressure', 'U', 'bh_systolic_blood_pressure', 'bh_systolic_blood_pressure', null, null, null, null, null, null, '0713378f-718f-4a56-9e3a-e71ebdaa6ddf', null)  ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(ad_element.ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2021-10-21 12:47:14.256000', 100, '2021-10-21 12:47:14.256000', 100, 'bh_diastolic_blood_pressure', 'U', 'bh_diastolic_blood_pressure', 'bh_diastolic_blood_pressure', null, null, null, null, null, null, 'af9ae820-cb81-424c-a4b5-dd4a935e3085', null) ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2021-10-21 12:47:14.161000', '2021-10-21 12:47:14.161000', 100, 100, 'bh_systolic_blood_pressure', null, null, 0, 'U', 'bh_systolic_blood_pressure', 259, 10, null, null, 3, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = '0713378f-718f-4a56-9e3a-e71ebdaa6ddf'), null, 'N', 'N', null, null, null, 'N', 'Y', null, 'bb1e8ef6-219e-43ba-8469-c10fd5168595', 'Y', null, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2021-10-21 12:47:14.255000', '2021-10-21 12:47:14.255000', 100, 100, 'bh_diastolic_blood_pressure', null, null, 0, 'U', 'bh_diastolic_blood_pressure', 259, 10, null, null, 3, null, 'N', 'N', 'N', 'Y', null, 'N', null, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = 'af9ae820-cb81-424c-a4b5-dd4a935e3085'), null, 'N', 'N', null, null, null, 'N', 'Y', null, 'd68ae1bd-25ca-4dad-bc77-19186050961b', 'Y', null, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;



--migrate existing data over to the new columns
SELECT c_order_id,
       bh_bloodpressure,
       modified_blood_pressure,
       trim(split_part(modified_blood_pressure, '/', 1)) as bp_1,
       trim(split_part(modified_blood_pressure, '/', 2)) as bp_2,
       trim(split_part(modified_blood_pressure, '/', 3)) as bp_3,
       trim(split_part(modified_blood_pressure, '/', 4)) as bp_4,
       trim(split_part(modified_blood_pressure, '/', 5)) as bp_5

-- Create temporary table to hold the blood_pressure values. Remove all occurrences of specified text from the row values.
-- Eg: If a row had 120/34mmHg the final value will be 120/34
INTO TEMP TABLE tmp_blood_pressure
FROM (
         SELECT c_order_id,
                bh_bloodpressure,
                replace(
                        replace(
                                replace(
                                        replace(
                                                replace(
                                                        replace(
                                                                replace(
                                                                        replace(
                                                                                replace(
                                                                                        replace(
                                                                                                replace(
                                                                                                        replace(
                                                                                                                replace(
                                                                                                                        replace(
                                                                                                                                replace(
                                                                                                                                        replace(
                                                                                                                                                replace(
                                                                                                                                                        replace(replace(lower(bh_bloodpressure), 'mmhg', ''), 'mm/hg', ''),
                                                                                                                                                        'mm/ hg',
                                                                                                                                                        ''),
                                                                                                                                                'mmmgh',
                                                                                                                                                ''),
                                                                                                                                        'manual-',
                                                                                                                                        ''),
                                                                                                                                'mmol/l',
                                                                                                                                ''),
                                                                                                                        'kgs',
                                                                                                                        ''),
                                                                                                                'mmhhg',
                                                                                                                ''),
                                                                                                        ' (high)',
                                                                                                        ''), 'mnhg',
                                                                                                ''), 'mhg', ''),
                                                                                'mm/ h g', ''), 'mmgh', ''), 'mm/mg',
                                                                ''), 'mmg', ''),
                                                'mmh', ''), 'hhg', ''), 'm', ''), 'nn/hg',
                        '') as modified_blood_pressure
         FROM c_order
         WHERE bh_bloodpressure is not null
           AND lower(bh_bloodpressure) not in
               ('not done', 'ab', 'nil', 'not applicable', 'declined', 'dfd', 'na', 'm', 'none', 'n/a', 'unrecordable.',
                'declined.')
           AND lower(bh_bloodpressure) not like 'spo2%'
           AND bh_bloodpressure not in
               ('1', '1000', '101', '102', '103', '105', '114', '120', '1212', '123', '125', '127', '128', '133', '134',
                '140', '148', '154', '160', '20', '200', '22', '23', '45', '48', '52', '81', '96', '99', '38.7', '36.1',
                '124.7', '153.9')
     )t;

-- Update the data in the new columns if there are only two values and their both numeric
UPDATE c_order o
SET bh_systolic_blood_pressure  = CAST(bp.bp_1 AS numeric),
    bh_diastolic_blood_pressure = CAST(bp.bp_2 AS numeric)
FROM tmp_blood_pressure bp
WHERE o.c_order_id = bp.c_order_id
  AND isnumeric(bp.bp_1)
  AND isnumeric(bp.bp_2)
  AND bp_3 IS NULL
  AND bp_4 IS NULL
  AND bp_5 IS NULL;

-- Update the known mistypings manually
UPDATE c_order SET bh_systolic_blood_pressure = 105, bh_diastolic_blood_pressure = 60 WHERE c_order_id = 1198825;
UPDATE c_order SET bh_systolic_blood_pressure = 106, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1203500;
UPDATE c_order SET bh_systolic_blood_pressure = 130, bh_diastolic_blood_pressure = 96 WHERE c_order_id = 1185912;
UPDATE c_order SET bh_systolic_blood_pressure = 152, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1185973;
UPDATE c_order SET bh_systolic_blood_pressure = 167, bh_diastolic_blood_pressure = 114 WHERE c_order_id = 1203511;
UPDATE c_order SET bh_systolic_blood_pressure = 98, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1199253;
UPDATE c_order SET bh_systolic_blood_pressure = 104, bh_diastolic_blood_pressure = 63 WHERE c_order_id = 1186522;
UPDATE c_order SET bh_systolic_blood_pressure = 96, bh_diastolic_blood_pressure = 72 WHERE c_order_id = 1186719;
UPDATE c_order SET bh_systolic_blood_pressure = 174, bh_diastolic_blood_pressure = 108 WHERE c_order_id = 1186846;
UPDATE c_order SET bh_systolic_blood_pressure = 141, bh_diastolic_blood_pressure = 88 WHERE c_order_id = 1186986;
UPDATE c_order SET bh_systolic_blood_pressure = 115, bh_diastolic_blood_pressure = 70 WHERE c_order_id = 1186997;
UPDATE c_order SET bh_systolic_blood_pressure = 110, bh_diastolic_blood_pressure = 70 WHERE c_order_id = 1187043;
UPDATE c_order SET bh_systolic_blood_pressure = 155, bh_diastolic_blood_pressure = 83 WHERE c_order_id = 1199599;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 81 WHERE c_order_id = 1187583;
UPDATE c_order SET bh_systolic_blood_pressure = 159, bh_diastolic_blood_pressure = 120 WHERE c_order_id = 1188118;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 97 WHERE c_order_id = 1188171;
UPDATE c_order SET bh_systolic_blood_pressure = 155, bh_diastolic_blood_pressure = 88 WHERE c_order_id = 1188161;
UPDATE c_order SET bh_systolic_blood_pressure = 165, bh_diastolic_blood_pressure = 79 WHERE c_order_id = 1188188;
UPDATE c_order SET bh_systolic_blood_pressure = 162, bh_diastolic_blood_pressure = 107 WHERE c_order_id = 1188299;
UPDATE c_order SET bh_systolic_blood_pressure = 221, bh_diastolic_blood_pressure = 117 WHERE c_order_id = 1199925;
UPDATE c_order SET bh_systolic_blood_pressure = 134, bh_diastolic_blood_pressure = 95 WHERE c_order_id = 1188767;
UPDATE c_order SET bh_systolic_blood_pressure = 174, bh_diastolic_blood_pressure = 124 WHERE c_order_id = 1203782;
UPDATE c_order SET bh_systolic_blood_pressure = 157, bh_diastolic_blood_pressure = 97 WHERE c_order_id = 1200259;
UPDATE c_order SET bh_systolic_blood_pressure = 118, bh_diastolic_blood_pressure = 81 WHERE c_order_id = 1189913;
UPDATE c_order SET bh_systolic_blood_pressure = 120, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1190060;
UPDATE c_order SET bh_systolic_blood_pressure = 102, bh_diastolic_blood_pressure = 67 WHERE c_order_id = 1189741;
UPDATE c_order SET bh_systolic_blood_pressure = 129, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1205360;
UPDATE c_order SET bh_systolic_blood_pressure = 91, bh_diastolic_blood_pressure = 57 WHERE c_order_id = 1190690;
UPDATE c_order SET bh_systolic_blood_pressure = 135, bh_diastolic_blood_pressure = 102 WHERE c_order_id = 1203828;
UPDATE c_order SET bh_systolic_blood_pressure = 113, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1191831;
UPDATE c_order SET bh_systolic_blood_pressure = 160, bh_diastolic_blood_pressure = 115 WHERE c_order_id = 1191776;
UPDATE c_order SET bh_systolic_blood_pressure = 18, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1201082;
UPDATE c_order SET bh_systolic_blood_pressure = 106, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1191966;
UPDATE c_order SET bh_systolic_blood_pressure = 120, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1192091;
UPDATE c_order SET bh_systolic_blood_pressure = 177, bh_diastolic_blood_pressure = 125 WHERE c_order_id = 1192101;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 75 WHERE c_order_id = 1206121;
UPDATE c_order SET bh_systolic_blood_pressure = 146, bh_diastolic_blood_pressure = 86 WHERE c_order_id = 1192506;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 73 WHERE c_order_id = 1192547;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1192849;
UPDATE c_order SET bh_systolic_blood_pressure = 100, bh_diastolic_blood_pressure = 63 WHERE c_order_id = 1192946;
UPDATE c_order SET bh_systolic_blood_pressure = 183, bh_diastolic_blood_pressure = 125 WHERE c_order_id = 1193111;
UPDATE c_order SET bh_systolic_blood_pressure = 150, bh_diastolic_blood_pressure = 97 WHERE c_order_id = 1193125;
UPDATE c_order SET bh_systolic_blood_pressure = 140, bh_diastolic_blood_pressure = 126 WHERE c_order_id = 1193432;
UPDATE c_order SET bh_systolic_blood_pressure = 136, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1193671;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1193697;
UPDATE c_order SET bh_systolic_blood_pressure = 150, bh_diastolic_blood_pressure = 92 WHERE c_order_id = 1205433;
UPDATE c_order SET bh_systolic_blood_pressure = 101, bh_diastolic_blood_pressure = 53 WHERE c_order_id = 1193990;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 88 WHERE c_order_id = 1194088;
UPDATE c_order SET bh_systolic_blood_pressure = 83, bh_diastolic_blood_pressure = 53 WHERE c_order_id = 1194145;
UPDATE c_order SET bh_systolic_blood_pressure = 123, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1194180;
UPDATE c_order SET bh_systolic_blood_pressure = 125, bh_diastolic_blood_pressure = 62 WHERE c_order_id = 1194435;
UPDATE c_order SET bh_systolic_blood_pressure = 132, bh_diastolic_blood_pressure = 69 WHERE c_order_id = 1194908;
UPDATE c_order SET bh_systolic_blood_pressure = 160, bh_diastolic_blood_pressure = 96 WHERE c_order_id = 1194568;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 62 WHERE c_order_id = 1195238;
UPDATE c_order SET bh_systolic_blood_pressure = 150, bh_diastolic_blood_pressure = 96 WHERE c_order_id = 1195504;
UPDATE c_order SET bh_systolic_blood_pressure = 84, bh_diastolic_blood_pressure = 66 WHERE c_order_id = 1202282;
UPDATE c_order SET bh_systolic_blood_pressure = 125, bh_diastolic_blood_pressure = 78 WHERE c_order_id = 1202321;
UPDATE c_order SET bh_systolic_blood_pressure = 135, bh_diastolic_blood_pressure = 88 WHERE c_order_id = 1195815;
UPDATE c_order SET bh_systolic_blood_pressure = 96, bh_diastolic_blood_pressure = 68 WHERE c_order_id = 1195832;
UPDATE c_order SET bh_systolic_blood_pressure = 95, bh_diastolic_blood_pressure = 65 WHERE c_order_id = 1202414;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 71 WHERE c_order_id = 1195980;
UPDATE c_order SET bh_systolic_blood_pressure = 124, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1202429;
UPDATE c_order SET bh_systolic_blood_pressure = 98, bh_diastolic_blood_pressure = 60 WHERE c_order_id = 1201947;
UPDATE c_order SET bh_systolic_blood_pressure = 130, bh_diastolic_blood_pressure = 89 WHERE c_order_id = 1197054;
UPDATE c_order SET bh_systolic_blood_pressure = 163, bh_diastolic_blood_pressure = 114 WHERE c_order_id = 1203054;
UPDATE c_order SET bh_systolic_blood_pressure = 135, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1206078;
UPDATE c_order SET bh_systolic_blood_pressure = 155, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1206608;
UPDATE c_order SET bh_systolic_blood_pressure = 178, bh_diastolic_blood_pressure = 110 WHERE c_order_id = 1206622;
UPDATE c_order SET bh_systolic_blood_pressure = 158, bh_diastolic_blood_pressure = 103 WHERE c_order_id = 1207021;
UPDATE c_order SET bh_systolic_blood_pressure = 122, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1207333;
UPDATE c_order SET bh_systolic_blood_pressure = 120, bh_diastolic_blood_pressure = 65 WHERE c_order_id = 1207646;
UPDATE c_order SET bh_systolic_blood_pressure = 178, bh_diastolic_blood_pressure = 130 WHERE c_order_id = 1208123;
UPDATE c_order SET bh_systolic_blood_pressure = 164, bh_diastolic_blood_pressure = 129 WHERE c_order_id = 1208131;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 85 WHERE c_order_id = 1209256;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 82 WHERE c_order_id = 1209288;
UPDATE c_order SET bh_systolic_blood_pressure = 115, bh_diastolic_blood_pressure = 79 WHERE c_order_id = 1209934;
UPDATE c_order SET bh_systolic_blood_pressure = 92, bh_diastolic_blood_pressure = 53 WHERE c_order_id = 1210080;
UPDATE c_order SET bh_systolic_blood_pressure = 155, bh_diastolic_blood_pressure = 109 WHERE c_order_id = 1210785;
UPDATE c_order SET bh_systolic_blood_pressure = 114, bh_diastolic_blood_pressure = 69 WHERE c_order_id = 1211613;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 73 WHERE c_order_id = 1211804;
UPDATE c_order SET bh_systolic_blood_pressure = 115, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1211824;
UPDATE c_order SET bh_systolic_blood_pressure = 146, bh_diastolic_blood_pressure = 103 WHERE c_order_id = 1211862;
UPDATE c_order SET bh_systolic_blood_pressure = 127, bh_diastolic_blood_pressure = 89 WHERE c_order_id = 1211828;
UPDATE c_order SET bh_systolic_blood_pressure = 164, bh_diastolic_blood_pressure = 106 WHERE c_order_id = 1211985;
UPDATE c_order SET bh_systolic_blood_pressure = 101, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1212002;
UPDATE c_order SET bh_systolic_blood_pressure = 123, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1212273;
UPDATE c_order SET bh_systolic_blood_pressure = 129, bh_diastolic_blood_pressure = 72 WHERE c_order_id = 1181345;
UPDATE c_order SET bh_systolic_blood_pressure = 122, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1181694;
UPDATE c_order SET bh_systolic_blood_pressure = 139, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1153802;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1153962;
UPDATE c_order SET bh_systolic_blood_pressure = 136, bh_diastolic_blood_pressure = 72 WHERE c_order_id = 1154283;
UPDATE c_order SET bh_systolic_blood_pressure = 124, bh_diastolic_blood_pressure = 63 WHERE c_order_id = 1154761;
UPDATE c_order SET bh_systolic_blood_pressure = 140, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1156242;
UPDATE c_order SET bh_systolic_blood_pressure = 138, bh_diastolic_blood_pressure = 82 WHERE c_order_id = 1156312;
UPDATE c_order SET bh_systolic_blood_pressure = 103, bh_diastolic_blood_pressure = 67 WHERE c_order_id = 1158048;
UPDATE c_order SET bh_systolic_blood_pressure = 92, bh_diastolic_blood_pressure = 58 WHERE c_order_id = 1158793;
UPDATE c_order SET bh_systolic_blood_pressure = 125, bh_diastolic_blood_pressure = 72 WHERE c_order_id = 1159213;
UPDATE c_order SET bh_systolic_blood_pressure = 85, bh_diastolic_blood_pressure = 55 WHERE c_order_id = 1212539;
UPDATE c_order SET bh_systolic_blood_pressure = 142, bh_diastolic_blood_pressure = 98 WHERE c_order_id = 1212643;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 95 WHERE c_order_id = 1212699;
UPDATE c_order SET bh_systolic_blood_pressure = 85, bh_diastolic_blood_pressure = 50 WHERE c_order_id = 1213071;
UPDATE c_order SET bh_systolic_blood_pressure = 139, bh_diastolic_blood_pressure = 101 WHERE c_order_id = 1213506;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1213532;
UPDATE c_order SET bh_systolic_blood_pressure = 134, bh_diastolic_blood_pressure = 90 WHERE c_order_id = 1100783;
UPDATE c_order SET bh_systolic_blood_pressure = 100, bh_diastolic_blood_pressure = 60 WHERE c_order_id = 1114563;
UPDATE c_order SET bh_systolic_blood_pressure = 183, bh_diastolic_blood_pressure = 119 WHERE c_order_id = 1114885;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 79 WHERE c_order_id = 1120864;
UPDATE c_order SET bh_systolic_blood_pressure = 138, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1110801;
UPDATE c_order SET bh_systolic_blood_pressure = 118, bh_diastolic_blood_pressure = 79 WHERE c_order_id = 1115457;
UPDATE c_order SET bh_systolic_blood_pressure = 117, bh_diastolic_blood_pressure = 65 WHERE c_order_id = 1121645;
UPDATE c_order SET bh_systolic_blood_pressure = 139, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1121679;
UPDATE c_order SET bh_systolic_blood_pressure = 130, bh_diastolic_blood_pressure = 83 WHERE c_order_id = 1124000;
UPDATE c_order SET bh_systolic_blood_pressure = 123, bh_diastolic_blood_pressure = 75 WHERE c_order_id = 1118187;
UPDATE c_order SET bh_systolic_blood_pressure = 147, bh_diastolic_blood_pressure = 87 WHERE c_order_id = 1136270;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 98 WHERE c_order_id = 1119252;
UPDATE c_order SET bh_systolic_blood_pressure = 131, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1124267;
UPDATE c_order SET bh_systolic_blood_pressure = 121, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1130880;
UPDATE c_order SET bh_systolic_blood_pressure = 180, bh_diastolic_blood_pressure = 120 WHERE c_order_id = 1134636;
UPDATE c_order SET bh_systolic_blood_pressure = 136, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1127816;
UPDATE c_order SET bh_systolic_blood_pressure = 116, bh_diastolic_blood_pressure = 85 WHERE c_order_id = 1128754;
UPDATE c_order SET bh_systolic_blood_pressure = 178, bh_diastolic_blood_pressure = 115 WHERE c_order_id = 1137751;
UPDATE c_order SET bh_systolic_blood_pressure = 131, bh_diastolic_blood_pressure = 68 WHERE c_order_id = 1149375;
UPDATE c_order SET bh_systolic_blood_pressure = 131, bh_diastolic_blood_pressure = 66 WHERE c_order_id = 1149130;
UPDATE c_order SET bh_systolic_blood_pressure = 140, bh_diastolic_blood_pressure = 83 WHERE c_order_id = 1149475;
UPDATE c_order SET bh_systolic_blood_pressure = 153, bh_diastolic_blood_pressure = 111 WHERE c_order_id = 1140016;
UPDATE c_order SET bh_systolic_blood_pressure = 158, bh_diastolic_blood_pressure = 103 WHERE c_order_id = 1140616;
UPDATE c_order SET bh_systolic_blood_pressure = 138, bh_diastolic_blood_pressure = 82 WHERE c_order_id = 1140750;
UPDATE c_order SET bh_systolic_blood_pressure = 174, bh_diastolic_blood_pressure = 104 WHERE c_order_id = 1150323;
UPDATE c_order SET bh_systolic_blood_pressure = 129, bh_diastolic_blood_pressure = 78 WHERE c_order_id = 1150650;
UPDATE c_order SET bh_systolic_blood_pressure = 132, bh_diastolic_blood_pressure = 92 WHERE c_order_id = 1143054;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1143652;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1151312;
UPDATE c_order SET bh_systolic_blood_pressure = 170, bh_diastolic_blood_pressure = 96 WHERE c_order_id = 1151396;
UPDATE c_order SET bh_systolic_blood_pressure = 150, bh_diastolic_blood_pressure = 68 WHERE c_order_id = 1151486;
UPDATE c_order SET bh_systolic_blood_pressure = 140, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1151289;
UPDATE c_order SET bh_systolic_blood_pressure = 172, bh_diastolic_blood_pressure = 107 WHERE c_order_id = 1152626;
UPDATE c_order SET bh_systolic_blood_pressure = 161, bh_diastolic_blood_pressure = 92 WHERE c_order_id = 1160059;
UPDATE c_order SET bh_systolic_blood_pressure = 137, bh_diastolic_blood_pressure = 85 WHERE c_order_id = 1161743;
UPDATE c_order SET bh_systolic_blood_pressure = 201, bh_diastolic_blood_pressure = 117 WHERE c_order_id = 1162886;
UPDATE c_order SET bh_systolic_blood_pressure = 148, bh_diastolic_blood_pressure = 91 WHERE c_order_id = 1163869;
UPDATE c_order SET bh_systolic_blood_pressure = 150, bh_diastolic_blood_pressure = 97 WHERE c_order_id = 1164809;
UPDATE c_order SET bh_systolic_blood_pressure = 159, bh_diastolic_blood_pressure = 113 WHERE c_order_id = 1164871;
UPDATE c_order SET bh_systolic_blood_pressure = 137, bh_diastolic_blood_pressure = 82 WHERE c_order_id = 1165166;
UPDATE c_order SET bh_systolic_blood_pressure = 100, bh_diastolic_blood_pressure = 55 WHERE c_order_id = 1167714;
UPDATE c_order SET bh_systolic_blood_pressure = 100, bh_diastolic_blood_pressure = 70 WHERE c_order_id = 1168768;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1168967;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 77 WHERE c_order_id = 1173238;
UPDATE c_order SET bh_systolic_blood_pressure = 153, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1173942;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 86 WHERE c_order_id = 1174267;
UPDATE c_order SET bh_systolic_blood_pressure = 120, bh_diastolic_blood_pressure = 66 WHERE c_order_id = 1174836;
UPDATE c_order SET bh_systolic_blood_pressure = 102, bh_diastolic_blood_pressure = 62 WHERE c_order_id = 1174750;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1173764;
UPDATE c_order SET bh_systolic_blood_pressure = 142, bh_diastolic_blood_pressure = 81 WHERE c_order_id = 1175940;
UPDATE c_order SET bh_systolic_blood_pressure = 167, bh_diastolic_blood_pressure = 98 WHERE c_order_id = 1175996;
UPDATE c_order SET bh_systolic_blood_pressure = 168, bh_diastolic_blood_pressure = 102 WHERE c_order_id = 1176803;
UPDATE c_order SET bh_systolic_blood_pressure = 117, bh_diastolic_blood_pressure = 91 WHERE c_order_id = 1177579;
UPDATE c_order SET bh_systolic_blood_pressure = 132, bh_diastolic_blood_pressure = 92 WHERE c_order_id = 1178316;
UPDATE c_order SET bh_systolic_blood_pressure = 116, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1178187;
UPDATE c_order SET bh_systolic_blood_pressure = 109, bh_diastolic_blood_pressure = 60 WHERE c_order_id = 1179448;
UPDATE c_order SET bh_systolic_blood_pressure = 99, bh_diastolic_blood_pressure = 56 WHERE c_order_id = 1197760;
UPDATE c_order SET bh_systolic_blood_pressure = 131, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1180915;
UPDATE c_order SET bh_systolic_blood_pressure = 125, bh_diastolic_blood_pressure = 91 WHERE c_order_id = 1180649;
UPDATE c_order SET bh_systolic_blood_pressure = 134, bh_diastolic_blood_pressure = 64 WHERE c_order_id = 1174088;
UPDATE c_order SET bh_systolic_blood_pressure = 130, bh_diastolic_blood_pressure = 80 WHERE c_order_id = 1155164;
UPDATE c_order SET bh_systolic_blood_pressure = 93, bh_diastolic_blood_pressure = 53 WHERE c_order_id = 1159552;
UPDATE c_order SET bh_systolic_blood_pressure = 131, bh_diastolic_blood_pressure = 85 WHERE c_order_id = 1131083;
UPDATE c_order SET bh_systolic_blood_pressure = 161, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1127571;
UPDATE c_order SET bh_systolic_blood_pressure = 149, bh_diastolic_blood_pressure = 98 WHERE c_order_id = 1127314;
UPDATE c_order SET bh_systolic_blood_pressure = 164, bh_diastolic_blood_pressure = 108 WHERE c_order_id = 1151348;
UPDATE c_order SET bh_systolic_blood_pressure = 152, bh_diastolic_blood_pressure = 79 WHERE c_order_id = 1152278;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1168948;
UPDATE c_order SET bh_systolic_blood_pressure = 122, bh_diastolic_blood_pressure = 55 WHERE c_order_id = 1173045;
UPDATE c_order SET bh_systolic_blood_pressure = 102, bh_diastolic_blood_pressure = 59 WHERE c_order_id = 1173355;
UPDATE c_order SET bh_systolic_blood_pressure = 136, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1174141;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1174137;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 57 WHERE c_order_id = 1175959;
UPDATE c_order SET bh_systolic_blood_pressure = 165, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1175379;
UPDATE c_order SET bh_systolic_blood_pressure = 121, bh_diastolic_blood_pressure = 81 WHERE c_order_id = 1176442;
UPDATE c_order SET bh_systolic_blood_pressure = 128, bh_diastolic_blood_pressure = 75 WHERE c_order_id = 1178660;
UPDATE c_order SET bh_systolic_blood_pressure = 85, bh_diastolic_blood_pressure = 67 WHERE c_order_id = 1179986;
UPDATE c_order SET bh_systolic_blood_pressure = 151, bh_diastolic_blood_pressure = 89 WHERE c_order_id = 1180108;
UPDATE c_order SET bh_systolic_blood_pressure = 133, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1180563;
UPDATE c_order SET bh_systolic_blood_pressure = 153, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1180704;
UPDATE c_order SET bh_systolic_blood_pressure = 161, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1180718;
UPDATE c_order SET bh_systolic_blood_pressure = 116, bh_diastolic_blood_pressure = 102 WHERE c_order_id = 1181155;
UPDATE c_order SET bh_systolic_blood_pressure = 147, bh_diastolic_blood_pressure = 81 WHERE c_order_id = 1182234;
UPDATE c_order SET bh_systolic_blood_pressure = 111, bh_diastolic_blood_pressure = 74 WHERE c_order_id = 1197841;
UPDATE c_order SET bh_systolic_blood_pressure = 152, bh_diastolic_blood_pressure = 76 WHERE c_order_id = 1182287;
UPDATE c_order SET bh_systolic_blood_pressure = 125, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1182274;
UPDATE c_order SET bh_systolic_blood_pressure = 190, bh_diastolic_blood_pressure = 93 WHERE c_order_id = 1182717;
UPDATE c_order SET bh_systolic_blood_pressure = 111, bh_diastolic_blood_pressure = 65 WHERE c_order_id = 1182729;
UPDATE c_order SET bh_systolic_blood_pressure = 138, bh_diastolic_blood_pressure = 59 WHERE c_order_id = 1183007;
UPDATE c_order SET bh_systolic_blood_pressure = 139, bh_diastolic_blood_pressure = 60 WHERE c_order_id = 1183295;
UPDATE c_order SET bh_systolic_blood_pressure = 119, bh_diastolic_blood_pressure = 69 WHERE c_order_id = 1183790;
UPDATE c_order SET bh_systolic_blood_pressure = 142, bh_diastolic_blood_pressure = 83 WHERE c_order_id = 1204963;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 98 WHERE c_order_id = 1198414;
UPDATE c_order SET bh_systolic_blood_pressure = 140, bh_diastolic_blood_pressure = 90 WHERE c_order_id = 1184234;
UPDATE c_order SET bh_systolic_blood_pressure = 145, bh_diastolic_blood_pressure = 90 WHERE c_order_id = 1184289;
UPDATE c_order SET bh_systolic_blood_pressure = 152, bh_diastolic_blood_pressure = 107 WHERE c_order_id = 1198546;
UPDATE c_order SET bh_systolic_blood_pressure = 148, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1184355;
UPDATE c_order SET bh_systolic_blood_pressure = 94, bh_diastolic_blood_pressure = 61 WHERE c_order_id = 1195747;
UPDATE c_order SET bh_systolic_blood_pressure = 135, bh_diastolic_blood_pressure = 84 WHERE c_order_id = 1184342;
UPDATE c_order SET bh_systolic_blood_pressure = 135, bh_diastolic_blood_pressure = 88 WHERE c_order_id = 1198610;
UPDATE c_order SET bh_systolic_blood_pressure = 153, bh_diastolic_blood_pressure = 99 WHERE c_order_id = 1184693;
UPDATE c_order SET bh_systolic_blood_pressure = 138, bh_diastolic_blood_pressure = 85 WHERE c_order_id = 1184725;

SELECT register_migration_script('202109191644_GO-1856.sql') FROM dual;

