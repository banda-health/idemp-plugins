ALTER TABLE m_movement
 ADD IF NOT EXISTS BH_From_Warehouse_ID numeric(10) DEFAULT NULL;
 
ALTER TABLE m_movement 
 ADD IF NOT EXISTS BH_To_Warehouse_ID numeric(10) DEFAULT NULL;
 
 ALTER TABLE m_warehouse 
 ADD IF NOT EXISTS BH_DefaultWarehouse char default 'N'::bpchar;
 
 -- set default warehouses in existing clients
 UPDATE m_warehouse SET BH_DefaultWarehouse = 'Y' WHERE name != 'Standard' AND isactive = 'Y' AND ad_client_id > 999999;
 
 INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT max(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2021-10-13 16:36:31.093000', 100, '2021-10-13 16:36:31.093000', 100, 'BH_From_Warehouse_ID', 'U', 'BH_From_Warehouse_ID', 'BH_From_Warehouse_ID', 'BH_From_Warehouse_ID', null, null, null, null, null, 'bfe459e4-4fe9-4ffa-ae5d-395379879d51', null) ON CONFLICT DO NOTHING;
 
 INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT max(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2021-10-13 16:36:39.633000', 100, '2021-10-13 16:36:39.633000', 100, 'BH_To_Warehouse_ID', 'U', 'BH_To_Warehouse_ID', 'BH_To_Warehouse_ID', 'BH_To_Warehouse_ID', null, null, null, null, null, '483c2345-05f5-4d08-9927-f3520126fae8', null) ON CONFLICT DO NOTHING;
 
  INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT max(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2021-10-13 16:36:31.093000', 100, '2021-10-13 16:36:31.093000', 100, 'BH_DefaultWarehouse', 'U', 'Default Warehouse', 'Default Warehouse', 'Default Warehouse', null, null, null, null, null, 'a644ce55-ced1-4041-86fe-543adfc85609', null) ON CONFLICT DO NOTHING;
 
 INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT max(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2021-10-13 16:36:57.118000', '2021-10-13 16:36:57.118000', 100, 100, 'BH_From_Warehouse_ID', 'BH_From_Warehouse_ID', null, 0, 'U', 'BH_From_Warehouse_ID', 323, 13, null, null, 50, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = 'bfe459e4-4fe9-4ffa-ae5d-395379879d51'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '1ff928cc-2b78-490d-b8a0-4c246d9ed0e5', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;
 
 INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT max(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2021-10-13 16:42:47.023000', '2021-10-13 16:42:47.023000', 100, 100, 'BH_To_Warehouse_ID', 'BH_To_Warehouse_ID', null, 0, 'U', 'BH_To_Warehouse_ID', 323, 13, null, null, 50, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = '483c2345-05f5-4d08-9927-f3520126fae8'), null, 'N', 'N', null, null, null, 'N', 'Y', null, 'e92cdafc-3691-4bc7-98bb-700ec86bccfb', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;
 

  INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT max(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2021-10-18 18:30:27.701000', '2021-10-18 18:30:27.701000', 100, 100, 'BH_DefaultWarehouse', 'BH_DefaultWarehouse', null, 0, 'U', 'BH_DefaultWarehouse', 190, 20, null, null, 1, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (select ad_element_id from ad_element where ad_element_uu = 'a644ce55-ced1-4041-86fe-543adfc85609'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '0ccc40a4-6b68-4a7a-a28d-224cbfb9a898', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;
  
  INSERT INTO adempiere.ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic, displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype, obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id, ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines, columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton, isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform) VALUES ((SELECT max(ad_field_id) + 1 FROM ad_field), 0, 0, 'Y', '2021-10-18 18:33:44.162000', 100, '2021-10-18 18:38:25.779000', 100, 'Default Warehouse', 'Default Warehouse', null, 'Y', (SELECT AD_TAB_ID FROM AD_Tab WHERE AD_TAB_UU = 'b6ec1b3e-e8d4-44e3-bb34-70062bea155c'), (SELECT AD_Column_ID FROM AD_Column where ad_column_uu = '0ccc40a4-6b68-4a7a-a28d-224cbfb9a898'), null, 'Y', null, 0, 'N', 140, 0, 'N', 'N', 'N', 'N', 'U', null, null, null, null, null, null, null, null, '4e2c2550-e94a-45ef-ab18-bd6bcb659f05', null, 140, 'Y', 2, 1, 1, 'N', null, null, null, null, null, 'N', 'N', null, null, null, null, 'N') ON CONFLICT DO NOTHING;
  
-- create transfer inventory window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2021-10-20 10:35:13.822000', 100, '2021-10-20 10:35:13.822000', 100, 'Transfer Inventory', null, null, 'T', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', 'd3c84cad-7306-464d-85da-7e629846f8c0', null) ON CONFLICT DO NOTHING;  

-- create transfer inventory header tab
INSERT INTO adempiere.ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id, readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id, treedisplayedon, maxqueryrecords) VALUES ((SELECT MAX(ad_tab_id) + 1 FROM ad_tab), 0, 0, 'Y', '2021-10-20 10:35:53.966000', 100, '2021-10-20 10:35:53.966000', 100, 'Transfer Inventory', null, null, (SELECT AD_TABLE_ID FROM AD_TABLE WHERE Ad_table_uu = '89b7adc4-6313-4088-9ed9-c13ae3098b7e'), (SELECT AD_WINDOW_ID FROM AD_Window WHERE AD_WINDOW_UU = 'd3c84cad-7306-464d-85da-7e629846f8c0'), 10, 0, 'Y', 'N', 'N', 'N', null, 'N', null, null, null, null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null, 'a8a1d256-efc4-4674-acce-3415c3a49f39', null, 'B', 0) ON CONFLICT DO NOTHING;

-- home screen configurations
INSERT INTO adempiere.bh_dbrdbtngrp_btn (bh_dbrdbtngrp_btn_id, ad_client_id, ad_infowindow_id, ad_org_id, ad_window_id, bh_dbrdbtngrp_btn_uu, buttonclassname, buttonhelptext, buttontext, created, createdby, description, iconclassname, isactive, lineno, name, updated, updatedby, bh_dbrdbtngrp_id, ad_process_id, ad_form_id, included_role_id) VALUES ((SELECT MAX(bh_dbrdbtngrp_btn_id) + 1 FROM bh_dbrdbtngrp_btn), 0, null, 0, (SELECT ad_window_id FROM ad_window where ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'), '1da38275-67b8-4bb6-b409-db37b2decc9f', 'button app big', 'Transfer Inventory', 'Transfer Inventory', '2021-10-20 10:36:40.358000', 100, '/transferinventory', null, 'Y', 0, 'Transfer Inventory', '2021-10-20 10:36:40.358000', 100, (SELECT bh_dbrdbtngrp_id FROM bh_dbrdbtngrp WHERE bh_dbrdbtngrp_uu = '963fb728-5261-48ea-a462-d74ace913dea'), null, null, null) ON CONFLICT DO NOTHING;

-- give inventory/pharmacy write access
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window where ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'), (select ad_role_id FROM ad_role where ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2021-10-20 10:36:40.358000', 100, '2021-10-20 10:36:40.358000', 100, 'Y', '0bb84633-d507-43f3-95d4-3397a438b786', 'N') ON CONFLICT DO NOTHING;


-- warehouse access window
CREATE TABLE IF NOT EXISTS adempiere.bh_role_warehouseaccess (
    ad_client_id numeric(10,0) NOT NULL,
    ad_org_id numeric(10,0) NOT NULL,
    m_warehouse_id numeric(10,0) NOT NULL,
    bh_role_warehouseaccess_uu character varying(36) DEFAULT NULL::character varying,
    created timestamp without time zone DEFAULT statement_timestamp() NOT NULL,
    createdby numeric(10,0) NOT NULL,
    isactive character(1) DEFAULT 'Y'::bpchar NOT NULL,
    isreadonly character(1) NOT NULL,
    updated timestamp without time zone DEFAULT statement_timestamp() NOT NULL,
    updatedby numeric(10,0) NOT NULL,
    bh_role_warehouseaccess_id numeric(10,0) NOT NULL,
    ad_role_id numeric(10,0) DEFAULT NULL::numeric,
    CONSTRAINT bh_role_warehouseaccess_isactive_check CHECK ((isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))),
    CONSTRAINT bh_role_warehouseaccess_isreadonly_check CHECK ((isreadonly = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))),
    CONSTRAINT bh_role_warehouseaccess_uu_idx UNIQUE (bh_role_warehouseaccess_uu),
    CONSTRAINT ad_functaccess_client FOREIGN KEY (ad_client_id) REFERENCES adempiere.ad_client(ad_client_id) DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT ad_functaccessorg FOREIGN KEY (ad_org_id) REFERENCES adempiere.ad_org(ad_org_id) DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT adrole_bhrolewarehouseaccess FOREIGN KEY (ad_role_id) REFERENCES adempiere.ad_role(ad_role_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT mwarehouse_bhrolewarehouseacce FOREIGN KEY (m_warehouse_id) REFERENCES adempiere.m_warehouse(m_warehouse_id) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED    
);

SELECT register_migration_script('202110131559_GO-1806.sql') FROM dual;
