-- Add OTC patient to existing clients.
DROP TABLE IF EXISTS tmp_c_bpartner;

CREATE TEMP TABLE tmp_c_bpartner
(
    c_bpartner_id          serial              			not null,        
    ad_client_id           numeric(10)                       	not null,
    ad_org_id              numeric(10)   default 0           	not null,
    isactive               char          default 'Y'::bpchar 	not null,
    created                timestamp     default now()       	not null,
    createdby              numeric(10)   default 100         	not null,
    updated                timestamp     default now()       	not null,
    updatedby              numeric(10)   default 100         	not null,
    invoicerule	    char	  default 'I'			not null,
    paymentrule	    char	  default 'B'			not null,
    c_paymentterm_id	    numeric(10)  				not null,
    m_pricelist_id	    numeric(10)				not null,
    bh_patientid	    varchar(22),
    bh_ispatient	    char	  default 'Y'::bpchar,
    value                  varchar(40)                       	not null,
    name                   varchar(120)                      	not null,
    description	    varchar(100) default 'DO NOT CHANGE',
    c_bp_group_id          numeric(10),
    c_bpartner_uu	    uuid         default uuid_generate_v4()	not null
);

-- SET sequence
SELECT setval(
	'tmp_c_bpartner_c_bpartner_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_BPartner' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_c_bpartner (ad_client_id, name, value, c_bp_group_id, c_paymentterm_id, m_pricelist_id, bh_patientid) SELECT c.ad_client_id, CONCAT('OTC - ', c.name), (SELECT max(cast(c_bpartner.value as numeric)) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.value)), (SELECT c_bp_group.c_bp_group_id FROM c_bp_group WHERE c_bp_group.ad_client_id = c.ad_client_id), (SELECT c_paymentterm_id FROM c_paymentterm WHERE c_paymentterm.ad_client_id = c.ad_client_id AND c_paymentterm.name = 'Immediate'), (SELECT COALESCE((SELECT g.m_pricelist_id from C_BP_Group g
WHERE g.ad_client_id = c.ad_client_id and g.isdefault = 'Y'), (SELECT l.m_pricelist_id FROM m_pricelist l WHERE l.ad_client_id = c.ad_client_id and isdefault = 'Y' and issopricelist = 'Y'))), (SELECT COALESCE((SELECT MAX(CAST(c_bpartner.bh_patientid as NUMERIC)) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.bh_patientid) and c_bpartner.bh_ispatient = 'Y' ), (SELECT CAST(c_bpartner.bh_patientid as NUMERIC) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.bh_patientid) ORDER BY c_bpartner.created desc LIMIT 1))) FROM ad_client c WHERE c.ad_client_id > 999999 AND c.isactive = 'Y';

INSERT INTO c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, invoicerule, paymentrule, c_paymentterm_id, m_pricelist_id, bh_patientid, bh_ispatient, value, name, description, c_bp_group_id, c_bpartner_uu) SELECT c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, invoicerule, paymentrule, c_paymentterm_id, m_pricelist_id, bh_patientid, bh_ispatient, value, name, description, c_bp_group_id, c_bpartner_uu FROM tmp_c_bpartner ON CONFLICT DO NOTHING;

DROP TABLE tmp_c_bpartner;

-- Add OTC window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-09-21 15:16:36.986000', 100, '2022-09-21 15:16:36.986000', 100, 'Pharmacy Sales (OTC)', 'Pharmacy Sales (OTC)', null, 'T', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f', null) ON CONFLICT DO NOTHING;

-- Add OTC menu
INSERT INTO adempiere.ad_menu (ad_menu_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, issummary, issotrx, isreadonly, action, ad_window_id, ad_workflow_id, ad_task_id, ad_process_id, ad_form_id, ad_workbench_id, entitytype, iscentrallymaintained, ad_menu_uu, ad_infowindow_id, iconclassname) VALUES ((SELECT MAX(ad_menu_id)+1 FROM AD_Menu), 0, 0, 'Y', '2022-09-22 17:48:26.964000', 100, '2022-09-22 17:48:26.964000', 'Pharmacy Sales (OTC)', 100, 'Pharmacy Sales (OTC)', 'N', 'Y', 'N', 'W', (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), null, null, null, null, null, 'U', 'Y', '8af1f64d-7409-447a-b9b3-86050bff9d38', null, 'money-bill-alt') ON CONFLICT DO NOTHING;

-- Add menus in Greenlight Menu Tree
INSERT INTO adempiere.ad_treenodemm (ad_tree_id, node_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, parent_id, seqno, ad_treenodemm_uu) VALUES (10, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '8af1f64d-7409-447a-b9b3-86050bff9d38'), 0, 0, 'Y', '2022-09-22 17:48:26.964000', 100, '2022-09-22 17:48:26.964000', 100, (SELECT ad_menu_id FROM ad_menu WHERE ad_menu_uu = '58e80a91-030d-4679-9c9a-356cffd30a40'), 2, '77f2962d-304d-42f5-b956-b710a7d8b390') ON CONFLICT DO NOTHING;

-- Add OTC window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-09-22 19:34:51.661000', 100, '2022-09-22 19:34:51.661000', 100, 'Y', '618ce836-f23f-40fd-9b5d-6b2745463212', 'Y') ON CONFLICT DO NOTHING;

-- Add OTC window access to Pharmacy Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2022-09-22 19:37:40.684000', 100, '2022-09-22 19:37:40.684000', 100, 'Y', '0980d9a1-c55b-48be-bc20-13aaec0147fe', 'Y') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202209211525_GO-2039') FROM dual;
