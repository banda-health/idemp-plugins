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

INSERT INTO tmp_c_chargetype (ad_client_id, description, name, value) SELECT c.ad_client_id, 'For an income category added by default', 'Default Income Category - DO NOT CHANGE', 'Default Income Category - DO NOT CHANGE' FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO c_chargetype (ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu) SELECT ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu FROM tmp_c_chargetype ON CONFLICT DO NOTHING;


-- Add default incomes to configuration client.
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

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF National Scheme - Income', 'NHIF National Scheme - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='44100') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF Fixed FFS - Income', 'NHIF Fixed FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12320') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF FFS - Income', 'NHIF FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12320') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'MCH - Income', 'MCH - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Linda Mama - Income', 'Linda Mama - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Liason Insurance - Income', 'Liason Insurance - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'EduAfya FFS - Income', 'EduAfya FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Donor Fund - Income', 'Donor Fund - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12710') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'CCC - Income', 'CCC - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = c.ad_client_id and value='12330') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO c_charge (c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo) SELECT c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo FROM tmp_c_charge ON CONFLICT DO NOTHING;


-- Add Income Category window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-07-18 17:27:54.767000', 100, '2022-07-18 17:27:54.767000', 100, 'Income Categories', 'Maintain Income Categories', 'The Income Categories Window defines the different incomes that may be received.', 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '20639eca-bd84-4ae3-b890-7b32987fcb5e', null) ON CONFLICT DO NOTHING;

-- Add Income Category Menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, showonuimenu, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-07-18 17:43:26.532000', 100, '2022-07-18 20:19:46.012000', 'Income Categories', 100, 'Income Categories', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), null, null, null, null, null, 'U', 'Y', '4844b8ee-8387-40d8-80c8-5e73479b8b61', null, 'Y', 'far fa-credit-card') ON CONFLICT DO NOTHING;

-- Add Track Incomes window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-07-18 20:07:09.040000', 100, '2022-07-18 20:07:09.040000', 100, 'Track Incomes', 'Track Incomes', 'Track Incomes', 'T', 'N', 'U', 'N', null, null, 'N', null, null, 'N', '44c02ddc-ef83-4020-8e4c-709d8cbeadc2', null) ON CONFLICT DO NOTHING;

-- Add Track Incomes menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, showonuimenu, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-07-18 20:13:04.045000', 100, '2022-07-18 20:21:24.840000', 'Track Incomes', 100, 'Track Incomes', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), null, null, null, null, null, 'U', 'Y', '88d5359a-4130-4863-830e-63a507a41cab', null, 'Y', 'fas fa-wallet') ON CONFLICT DO NOTHING;

-- Add menus in Greenlight Menu Tree
INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '88d5359a-4130-4863-830e-63a507a41cab'), 0, 0, 'Y', '2022-07-18 20:13:04.093665', 100, '2022-07-18 20:14:13.528488', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 2, 'fb7b43cb-fd96-4732-8c6f-f36adfb7e7d5') ON CONFLICT DO NOTHING;

INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '4844b8ee-8387-40d8-80c8-5e73479b8b61'), 0, 0, 'Y', '2022-07-18 17:43:26.608449', 100, '2022-07-18 20:14:13.538705', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '35ce7d6a-cf7d-4962-a748-75e27d0121bf'), 5, 'deb2ce60-fef2-465b-ac37-67d173f3bf6d') ON CONFLICT DO NOTHING;

-- Add Track Incomes window access to Cashier/Registration Advanced Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='ee008abc-2c16-4230-b48c-b1f5577ea270'), 0, 0, 'Y', '2022-07-18 21:43:28.659000', 100, '2022-07-18 21:43:28.659000', 100, 'Y', '506bc371-a975-43db-a7f8-6ec2b191ef87', 'N') ON CONFLICT DO NOTHING;

-- Add Track Incomes window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='44c02ddc-ef83-4020-8e4c-709d8cbeadc2'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-07-18 21:45:58.222000', 100, '2022-07-18 21:45:58.222000', 100, 'Y', 'debd8a8c-69bb-4ebf-9769-1f96d5d0e432', 'Y') ON CONFLICT DO NOTHING;

-- Add Income Categories window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='20639eca-bd84-4ae3-b890-7b32987fcb5e'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-07-18 21:47:32.782000', 100, '2022-07-18 21:47:32.782000', 100, 'N', 'b87d6df9-658e-4baf-ace6-f02847c27139', 'N') ON CONFLICT DO NOTHING;

SELECT update_sequences();

SELECT register_migration_script('202207151225_GO-1335.sql') FROM dual;
