-- Add default income type to existing clients.
DROP TABLE IF EXISTS tmp_c_chargetype;

CREATE TEMP TABLE tmp_c_chargetype
(
    ad_client_id    numeric(10) default NULL::numeric         not null,
    ad_org_id       numeric(10) default 0         		not null,
    c_chargetype_id serial 					not null,
    created         timestamp   default now()                 not null,
    createdby       numeric(10) default 100                   not null,
    description     varchar(255),
    help            varchar(2000) default null,
    isactive        char        default 'Y'::bpchar           not null,
    name            varchar(60)                               not null,
    updated 	     timestamp   default now() 		not null,
    updatedby       numeric(10) default 100                   not null,
    value           varchar(40)                               not null,
    c_chargetype_uu uuid NOT NULL DEFAULT uuid_generate_v4()
);

-- SET sequence
SELECT setval(
	'tmp_c_chargetype_c_chargetype_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_ChargeType' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_c_chargetype (ad_client_id, description, name, value) SELECT c.ad_client_id, 'For an income category added by default', 'Default Income Category - DO NOT CHANGE', 'Default Income Category - DO NOT CHANGE' FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO c_chargetype (ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu) SELECT ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu FROM tmp_c_chargetype ON CONFLICT DO NOTHING;

DROP TABLE tmp_c_chargetype;

-- Add default income to configuration client.
DROP TABLE IF EXISTS tmp_c_charge;

CREATE TEMP TABLE tmp_c_charge
(
    c_charge_id  		serial				 not null,
    ad_client_id               numeric(10)                     not null,
    ad_org_id                  numeric(10) default 0 	 not null,
    isactive                   char        default 'Y'::bpchar not null,
    created                    timestamp   default now()       not null,
    createdby                  numeric(10) default 100         not null,
    updated                    timestamp   default now()       not null,
    updatedby                  numeric(10) default 100         not null,
    name                       varchar(60)                     not null,
    description                varchar(255),
    chargeamt                  numeric     default 0           not null,
    issametax                  char        default 'N'::bpchar not null,
    issamecurrency             char        default 'N'::bpchar not null,
    c_taxcategory_id           numeric(10) default null,
    istaxincluded              char        default 'N'::bpchar not null,
    c_bpartner_id              numeric(10) default null,
    c_chargetype_id            numeric(10),
    c_charge_uu                varchar(36) not NULL default uuid_generate_v4(),
    c_elementvalue_id          numeric(10) default NULL,
    bh_locked                  char        default 'Y'::bpchar,
    bh_subtype                 varchar(2)  default NULL,
    bh_needadditionalvisitinfo char        default 'N'::bpchar not null
);

SELECT setval(
	'tmp_c_charge_c_charge_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_Charge' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF National Scheme - Income', 'NHIF National Scheme - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='44100') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF Fixed FFS - Income', 'NHIF Fixed FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12320') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF FFS - Income', 'NHIF FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12320') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'MCH - Income', 'MCH - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Linda Mama - Income', 'Linda Mama - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Liason Insurance - Income', 'Liason Insurance - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'EduAfya FFS - Income', 'EduAfya FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Donor Fund - Income', 'Donor Fund - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12710') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'CCC - Income', 'CCC - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999 OR c.ad_client_id = 2;

INSERT INTO c_charge (c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo) SELECT c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo FROM tmp_c_charge ON CONFLICT DO NOTHING;

DROP TABLE tmp_c_charge;

-- Add Income Category window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-07-18 17:27:54.767000', 100, '2022-07-18 17:27:54.767000', 100, 'Income Categories', 'Maintain Income Categories', 'The Income Categories Window defines the different income that may be received.', 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '20639eca-bd84-4ae3-b890-7b32987fcb5e', null) ON CONFLICT DO NOTHING;

-- Add Income Category Menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-07-18 17:43:26.532000', 100, '2022-07-18 20:19:46.012000', 'Income Categories', 100, 'Income Categories', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), null, null, null, null, null, 'U', 'Y', '4844b8ee-8387-40d8-80c8-5e73479b8b61', null, 'far fa-credit-card') ON CONFLICT DO NOTHING;

-- Add Track Income window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-07-18 20:07:09.040000', 100, '2022-07-18 20:07:09.040000', 100, 'Track Income', 'Track Income', 'Track Income', 'T', 'N', 'U', 'N', null, null, 'N', null, null, 'N', '44c02ddc-ef83-4020-8e4c-709d8cbeadc2', null) ON CONFLICT DO NOTHING;

-- Add Track Income menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-07-18 20:13:04.045000', 100, '2022-07-18 20:21:24.840000', 'Track Income', 100, 'Track Income', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), null, null, null, null, null, 'U', 'Y', '88d5359a-4130-4863-830e-63a507a41cab', null, 'fas fa-wallet') ON CONFLICT DO NOTHING;

-- Add menus in Greenlight Menu Tree
INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '88d5359a-4130-4863-830e-63a507a41cab'), 0, 0, 'Y', '2022-07-18 20:13:04.093665', 100, '2022-07-18 20:14:13.528488', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 2, 'fb7b43cb-fd96-4732-8c6f-f36adfb7e7d5') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '4844b8ee-8387-40d8-80c8-5e73479b8b61'), 0, 0, 'Y', '2022-07-18 17:43:26.608449', 100, '2022-07-18 20:14:13.538705', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = 'eba1cdd4-5475-4529-beed-0e63d9a88357'), 5, 'deb2ce60-fef2-465b-ac37-67d173f3bf6d') ON CONFLICT DO NOTHING;

-- Add Track Income window access to Cashier/Registration Advanced Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='ee008abc-2c16-4230-b48c-b1f5577ea270'), 0, 0, 'Y', '2022-07-18 21:43:28.659000', 100, '2022-07-18 21:43:28.659000', 100, 'Y', '506bc371-a975-43db-a7f8-6ec2b191ef87', 'N') ON CONFLICT DO NOTHING;

-- Add Track Income window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'Y', 'debd8a8c-69bb-4ebf-9769-1f96d5d0e432', 'Y') ON CONFLICT DO NOTHING;

-- Add Track Income window access to Clinic User Role
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'Y', '3f567147-4bcc-4989-8956-2eed488d10d3', 'N') ON CONFLICT DO NOTHING;

-- Add Track Income window access to Cashier/Registration Basic role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='09eb7fc8-9cc5-44b0-9d14-15258a066038'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'Y', '006a5bdd-ae86-498a-afad-a29ac41a2598', 'N') ON CONFLICT DO NOTHING;

-- Add Track Income window access to Accounting role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='93365778-a2d9-433b-b962-87fb150db4fa'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'Y', '0eb6fc09-56e2-48e0-89ce-4a6ee39a10ec', 'Y') ON CONFLICT DO NOTHING;

-- Add Income Categories window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-07-18 21:47:32.782000', 100, '2022-07-18 21:47:32.782000', 100, 'N', 'b87d6df9-658e-4baf-ace6-f02847c27139', 'N') ON CONFLICT DO NOTHING;

-- Add Income Categories window access to Clinic User Role
INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'N', '8328728f-0cae-42e6-aac7-260e2e888083', 'N') ON CONFLICT DO NOTHING;

-- Add Income Categories window access to Accounting Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='93365778-a2d9-433b-b962-87fb150db4fa'), 0, 0, 'Y', '2022-07-18 21:47:32.782000', 100, '2022-07-18 21:47:32.782000', 100, 'N', 'd747f05b-8f79-437d-be73-1e6a7bd0640b', 'N') ON CONFLICT DO NOTHING;

-- Add window acess to non-manual roles.
DROP TABLE IF EXISTS tmp_ad_window_access;

CREATE TEMP TABLE tmp_ad_window_access
(
    ad_window_id               numeric(10)                     not null,
    ad_role_id                 numeric(10) 		 	 not null,
    ad_client_id               numeric(10)			 not null,
    ad_org_id			numeric(10)			 not null,
    isactive                   char        default 'Y'::bpchar not null,
    created                    timestamp   default now()       not null,
    createdby                  numeric(10) default 100         not null,
    updated                    timestamp   default now()       not null,
    updatedby                  numeric(10) default 100         not null,
    isreadwrite		char	    default 'Y'	 not null,
    ad_window_access_uu	varchar(36) not NULL default uuid_generate_v4(),
    bh_candeactivate		char	    default 'N'	 not null
);

-- Track Income
INSERT INTO tmp_ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id) SELECT (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), ad_role_id, ad_client_id, ad_org_id FROM ad_role WHERE ad_client_id > 999999 and ismanual = 'N' ON CONFLICT DO NOTHING;

-- Income Categories
INSERT INTO tmp_ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id) SELECT (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), ad_role_id, ad_client_id, ad_org_id FROM ad_role WHERE ad_client_id > 999999 and ismanual = 'N' ON CONFLICT DO NOTHING;

INSERT INTO ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) SELECT ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate FROM tmp_ad_window_access ON CONFLICT DO NOTHING;

DROP TABLE tmp_ad_window_access; -- no longer required

-- Add bh_invoicetype element
INSERT INTO adempiere.ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(ad_element_id)+1 FROM ad_element), 0, 0, 'Y', '2022-08-01 11:37:32.491000', 100, '2022-08-01 11:37:32.491000', 100, 'bh_invoicetype', 'U', 'bh_invoicetype', 'Invoice Type', 'Invoice Type', null, null, null, null, null, '086d36a0-7755-4c77-9148-6cd971d24b0b', null) ON CONFLICT DO NOTHING;

-- add ad_column entry
INSERT INTO adempiere.ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(ad_column_id)+1 FROM ad_column), 0, 0, 'Y', '2022-08-01 11:40:00.469000', '2022-08-01 11:40:00.469000', 100, 100, 'bh_invoicetype', 'Invoice Type', null, 0, 'U', 'bh_invoicetype', 318, 10, null, null, 5, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '086d36a0-7755-4c77-9148-6cd971d24b0b'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '1e9b69bb-aa25-4eba-9a33-130143637063', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

-- Add BH_InvoiceType column
ALTER TABLE adempiere.c_invoice ADD COLUMN bh_invoicetype char default NULL::bpchar;

SELECT update_sequences();

SELECT register_migration_script('202207151225_GO-1335.sql') FROM dual;
