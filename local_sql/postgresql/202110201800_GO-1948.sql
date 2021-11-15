-- CREATE BH_Coded_Diagnosis_Mapping table
create table if not exists bh_coded_diagnosis_mapping
(
    ad_client_id            numeric(10) not null,
    ad_org_id               numeric(10) not null,
    created                 timestamp    default statement_timestamp(),
    createdby               numeric(10)  default NULL::numeric,
    updated                 timestamp    default statement_timestamp(),
    updatedby               numeric(10)  default NULL::numeric,
    bh_coded_diagnosis_mapping_id   numeric(10) not null
        constraint bh_coded_diagnosis_mapping_key
            primary key,
    bh_coded_diagnosis_mapping_uu   varchar(36)  default NULL::character varying
        constraint bh_coded_diagnosis_mapping_uu_idx
            unique,
    bh_coded_diagnosis_id   numeric(10) not null,
    bh_source                  varchar(100)  default NULL::character varying,
    bh_external_id             varchar(255)  default NULL::character varying,
    bh_map_type                varchar(50) default NULL::character varying,
    bh_owner                   varchar(100) default NULL::character varying,
    bh_concept_code            varchar(255)  default NULL::character varying,
    bh_concept_name_resolved   varchar(255) default NULL::character varying,
    isactive                char         default 'Y'::bpchar
        constraint bh_coded_diagnosis_mapping_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    constraint bhcodeddiagnosis_mapping_key
		foreign key (bh_coded_diagnosis_id) references bh_coded_diagnosis(bh_coded_diagnosis_id)
			deferrable initially deferred        
);


INSERT INTO adempiere.ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(AD_Table_ID) + 1 FROM AD_Table), 0, 0, 'Y', '2021-10-20 20:36:28.877000', 100, '2021-10-20 20:36:28.877000', 100, 'Coded Diagnosis Mapping', 'Coded Diagnosis Mapping', null, 'BH_Coded_Diagnosis_Mapping', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', '13c3386a-e158-4d48-a74e-6a765a50bc0c', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id)+1 FROM AD_Sequence), 0, 0, 'Y', '2021-10-20 20:36:28.977000', 100, '2021-10-20 20:36:28.977000', 100, 'BH_Coded_Diagnosis_Mapping', 'Table BH_Coded_Diagnosis_Mapping', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'a423da92-2446-435f-bf16-3b77eea00a9d', 'N', 'N', null) ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:45:03.791000', 100, '2021-10-20 20:45:03.791000', 100, 'BH_Coded_Diagnosis_Mapping_ID', 'U', 'Coded Diagnosis Mapping ID', 'Coded Diagnosis Mapping ID', 'Coded Diagnosis Mapping ID', null, null, null, null, null, 'e7565fc4-4947-4743-a994-f45082f88e0e', null) ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:47:15.602000', 100, '2021-10-20 20:47:15.602000', 100, 'BH_Coded_Diagnosis_Mapping_UU', 'U', 'BH_Coded_Diagnosis_Mapping_UU', 'BH_Coded_Diagnosis_Mapping_UU', null, null, null, null, null, null, '181d2178-9b28-4285-985e-d4df59c0abdd', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:48:13.881000', 100, '2021-10-20 20:48:52.148000', 100, 'BH_Source', 'U', 'Source', 'Source', 'Source', null, null, null, null, null, 'd1129432-18a1-4638-aec8-aa78c2e8f973', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:50:07.080000', 100, '2021-10-20 20:50:07.080000', 100, 'BH_External_ID', 'U', 'BH_External_ID', 'BH_External_ID', 'BH_External_ID', null, null, null, null, null, 'cb3cad36-8f33-4220-9b85-ed38ef139799', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:50:51.119000', 100, '2021-10-20 20:50:51.119000', 100, 'BH_Map_Type', 'U', 'BH_Map_Type', 'BH_Map_Type', 'BH_Map_Type', null, null, null, null, null, '9637adbd-4cac-4cd5-ba1e-54d852ccc29d', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:51:27.115000', 100, '2021-10-20 20:51:27.115000', 100, 'BH_Owner', 'U', 'BH_Owner', 'BH_Owner', 'BH_Owner', null, null, null, null, null, '06d4e57d-425a-41b4-b869-77c6aaa0e32c', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:52:10.710000', 100, '2021-10-20 20:52:10.710000', 100, 'BH_Concept_Code', 'U', 'BH_Concept_Code', 'BH_Concept_Code', 'BH_Concept_Code', null, null, null, null, null, '01268652-7a4e-4cdf-b07d-3c2230fa8c89', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(AD_Element_ID) + 1 FROM AD_Element), 0, 0, 'Y', '2021-10-20 20:52:57.376000', 100, '2021-10-20 20:52:57.376000', 100, 'BH_Concept_Name_Resolved', 'U', 'BH_Concept_Name_Resolved', 'BH_Concept_Name_Resolved', 'BH_Concept_Name_Resolved', null, null, null, null, null, '3a1d8d00-779b-44e2-90b1-9334be0cc476', null)  ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:38:22.464000', '2021-11-03 22:22:40.154000', 100, 100, 'Updated', 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 0, 'U', 'Updated', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='ef178cde-f302-4224-ad8f-49e6f319b7b6'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '12497762-92ca-4df7-8b62-c89d68e63038', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:38:45.350000', '2021-11-03 22:22:40.241000', 100, 100, 'Updated By', 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 0, 'U', 'UpdatedBy', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 30, 110, null, 22, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='46db21da-0463-4b85-8eae-b6c223dd402f'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '9ac9d0cd-388d-45f2-bda3-7757755b6c30', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:45:24.228000', '2021-11-03 22:22:39.633000', 100, 100, 'Coded Diagnosis Mapping ID', 'Coded Diagnosis Mapping ID', null, 0, 'U', 'BH_Coded_Diagnosis_Mapping_ID', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 13, null, null, 100, null, 'Y', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='e7565fc4-4947-4743-a994-f45082f88e0e'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '1796e232-d4b6-44e1-b454-847cab9283d4', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:47:33.299000', '2021-11-03 22:22:40.341000', 100, 100, 'BH_Coded_Diagnosis_Mapping_UU', null, null, 0, 'U', 'BH_Coded_Diagnosis_Mapping_UU', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 36, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='181d2178-9b28-4285-985e-d4df59c0abdd'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '7bbc8a69-56dd-44aa-bfe0-c34924f8799c', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:48:37.801000', '2021-11-03 22:22:40.445000', 100, 100, 'Source', 'Source', null, 0, 'U', 'BH_Source', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 100, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='d1129432-18a1-4638-aec8-aa78c2e8f973'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '31d1f07b-ef0c-4e74-a748-ef42e2713ecd', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:50:24.955000', '2021-11-03 22:22:40.545000', 100, 100, 'BH_External_ID', 'BH_External_ID', null, 0, 'U', 'BH_External_ID', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 100, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='cb3cad36-8f33-4220-9b85-ed38ef139799'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '0816e2b4-b9e2-4ac5-84d1-bb6168109f7c', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:36:47.351000', '2021-11-03 22:22:39.719000', 100, 100, 'Client', 'Client/Tenant for this installation.', 'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.', 0, 'U', 'AD_Client_ID', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 19, null, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='c46491d1-7547-4374-88fd-cbc701d47d7f'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '4546c77f-c118-4034-b5e3-300c4522a9e5', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:37:05.608000', '2021-11-03 22:22:39.784000', 100, 100, 'Organization', 'Organizational entity within client', 'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.', 0, 'U', 'AD_Org_ID', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 19, null, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='d8103f72-3282-4298-9ed4-360b12abc9d2'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '0f9d6485-3269-41f7-aa20-e872ba66ef1e', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:37:46.956000', '2021-11-03 22:22:39.939000', 100, 100, 'Created', 'Date this record was created', 'The Created field indicates the date that this record was created.', 0, 'U', 'Created', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 16, null, null, 7, 'SYSDATE', 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='bcfaa0fc-0857-4d34-8aaf-ca62953ec9ea'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '165940d4-389d-4b94-9df3-5ef3ec53ffa3', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:37:53.765000', '2021-11-03 22:22:40.018000', 100, 100, 'Created By', 'User who created this records', 'The Created By field indicates the user who created this record.', 0, 'U', 'CreatedBy', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 30, 110, null, 22, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='7d1537a0-5d13-4a79-a578-1ceb55dd59a2'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '9650c65b-13e7-45a5-9428-7acf294eff13', 'N', 0, 'N', 'N', null, null, 'D', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:38:10.187000', '2021-11-03 22:22:40.096000', 100, 100, 'Active', 'The record is active in the system', 'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.', 0, 'U', 'IsActive', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 20, null, null, 1, 'Y', 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='b31f7d52-846f-40ac-b1d2-33bae38a247e'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '5cf6d750-e870-4bdc-b6d1-b96a99e12880', 'N', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:51:07.960000', '2021-11-03 22:22:40.647000', 100, 100, 'BH_Map_Type', 'BH_Map_Type', null, 0, 'U', 'BH_Map_Type', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 50, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='9637adbd-4cac-4cd5-ba1e-54d852ccc29d'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, 'a0b69cf2-be62-43fc-a340-306c70138ce9', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:51:42.494000', '2021-11-03 22:22:40.732000', 100, 100, 'BH_Owner', 'BH_Owner', null, 0, 'U', 'BH_Owner', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 100, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='06d4e57d-425a-41b4-b869-77c6aaa0e32c'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '2d19e4c3-f59f-41d1-90ab-bb1e7a0d0a1d', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:52:32.503000', '2021-11-03 22:22:40.828000', 100, 100, 'BH_Concept_Code', 'BH_Concept_Code', null, 0, 'U', 'BH_Concept_Code', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 50, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='01268652-7a4e-4cdf-b07d-3c2230fa8c89'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '67109b34-44f0-4a03-9382-bd48249aeb38', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:53:14.036000', '2021-11-03 22:22:40.929000', 100, 100, 'BH_Concept_Name_Resolved', 'BH_Concept_Name_Resolved', null, 0, 'U', 'BH_Concept_Name_Resolved', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 10, null, null, 255, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'Y', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='3a1d8d00-779b-44e2-90b1-9334be0cc476'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '5e3ad7b2-07b9-486d-a4fc-9d4b83297040', 'Y', 10, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2021-10-20 20:37:23.144000', '2021-11-03 22:30:02.423000', 100, 100, 'Coded Diagnosis', null, null, 0, 'U', 'BH_Coded_Diagnosis_ID', (SELECT AD_Table_ID FROM AD_Table where AD_Table_UU='13c3386a-e158-4d48-a74e-6a765a50bc0c'), 30, null, null, 22, null, 'N', 'Y', 'Y', 'N', null, 'Y', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM Ad_Element where ad_element_uu='56eea80e-d85d-41b3-8121-55ad5f62bad4'), null, 'Y', 'N', null, null, null, 'N', 'Y', null, '1f9171f6-eedc-4aff-8991-8786bcf08b32', 'Y', 0, 'N', 'N', null, 'bhcodeddiagnosis_mapping_key', 'M', null, null, 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202110201800_GO-1948.sql') FROM dual;
