-- create OTC bpartner groups..
DROP TABLE IF EXISTS tmp_c_bp_group;

CREATE TEMP TABLE tmp_c_bp_group
(
    c_bp_group_id        serial                     			not null,
    ad_client_id         numeric(10)               			not null,
    ad_org_id            numeric(10) default 0     			not null,
    isactive             char        default 'Y'    			not null,
    createdby            numeric(10) default 100    			not null,
    updated              timestamp   default now()  			not null,
    updatedby            numeric(10) default 100    			not null,
    value                varchar(40) default 'OTC Patient'		not null,
    name                 varchar(60) default 'OTC Patient'   	not null,
    description          varchar(255) default 'DO NOT CHANGE',
    prioritybase         char,
    m_pricelist_id       numeric(10),
    po_pricelist_id      numeric(10),
    m_discountschema_id  numeric(10),
    po_discountschema_id numeric(10),
    creditwatchpercent   numeric,
    pricematchtolerance  numeric,
    c_dunning_id         numeric(10),
    c_bp_group_uu        uuid        default uuid_generate_v4()	not null
);

-- SET sequence
SELECT setval(
	'tmp_c_bp_group_c_bp_group_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_BP_Group' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_c_bp_group (ad_client_id, ad_org_id, prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id, creditwatchpercent, pricematchtolerance, c_dunning_id) SELECT c.ad_client_id, bp.ad_org_id, bp.prioritybase, bp.m_pricelist_id, bp.po_pricelist_id, bp.m_discountschema_id, bp.po_discountschema_id, bp.creditwatchpercent, bp.pricematchtolerance, bp.c_dunning_id FROM ad_client c INNER JOIN c_bp_group bp ON c.ad_client_id = bp.ad_client_id WHERE (c.ad_client_id > 999999 OR c.ad_client_id = 2) AND c.isactive = 'Y' AND bp.name = 'Standard' AND bp.isdefault = 'Y';

INSERT INTO c_bp_group(c_bp_group_id, ad_client_id, ad_org_id, isactive, createdby, updated, updatedby, value, name, description, prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id, creditwatchpercent, pricematchtolerance, c_dunning_id, c_bp_group_uu) SELECT c_bp_group_id, ad_client_id, ad_org_id, isactive, createdby, updated, updatedby, value, name, description, prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id, creditwatchpercent, pricematchtolerance, c_dunning_id, c_bp_group_uu FROM tmp_c_bp_group ON CONFLICT DO NOTHING;

-- Add OTC bp group a/cs
DROP TABLE IF EXISTS tmp_c_bp_group_acct;

CREATE TEMP TABLE tmp_c_bp_group_acct
(
    c_acctschema_id             serial                     	  not null,
    c_bp_group_id               numeric(10)                     not null,
    ad_client_id                numeric(10)                     not null,
    ad_org_id                   numeric(10)                     not null,
    isactive                    char        default 'Y'	  not null,
    created                     timestamp   default now()       not null,
    createdby                   numeric(10) default 100         not null,
    updated                     timestamp   default now()       not null,
    updatedby                   numeric(10) default 100         not null,
    c_receivable_acct           numeric(10)                     not null,
    c_prepayment_acct           numeric(10)                     not null,
    v_liability_acct            numeric(10)                     not null,
    v_liability_services_acct   numeric(10),
    v_prepayment_acct           numeric(10)                     not null,
    paydiscount_exp_acct        numeric(10)                     not null,
    paydiscount_rev_acct        numeric(10)                     not null,
    writeoff_acct               numeric(10)                     not null,
    notinvoicedreceipts_acct    numeric(10)                     not null,
    unearnedrevenue_acct        numeric(10),
    notinvoicedrevenue_acct     numeric(10),
    notinvoicedreceivables_acct numeric(10),
    processing                  char,
    c_receivable_services_acct  numeric(10),
    c_bp_group_acct_uu          uuid        default uuid_generate_v4()
);

INSERT INTO tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, c_receivable_acct, c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct, notinvoicedreceivables_acct, processing, c_receivable_services_acct) SELECT bpa.c_acctschema_id, bp2.c_bp_group_id, bpa.ad_client_id, bpa.ad_org_id, bpa.c_receivable_acct, bpa.c_prepayment_acct, bpa.v_liability_acct, bpa.v_liability_services_acct, bpa.v_prepayment_acct, bpa.paydiscount_exp_acct, bpa.paydiscount_rev_acct, bpa.writeoff_acct, bpa.notinvoicedreceipts_acct, bpa.unearnedrevenue_acct, bpa.notinvoicedrevenue_acct, bpa.notinvoicedreceivables_acct, bpa.processing, bpa.c_receivable_services_acct FROM ad_client c INNER JOIN c_bp_group_acct bpa ON c.ad_client_id = bpa.ad_client_id INNER JOIN c_bp_group bp ON bpa.c_bp_group_id = bp.c_bp_group_id AND bp.name = 'Standard' INNER JOIN c_bp_group bp2 ON bp.ad_client_id = bp2.ad_client_id AND bp2.name = 'OTC Patient' WHERE (c.ad_client_id > 999999 OR c.ad_client_id = 2) AND c.isactive = 'Y';

INSERT INTO c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_receivable_acct, c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct, notinvoicedreceivables_acct, processing, c_receivable_services_acct, c_bp_group_acct_uu) SELECT c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_receivable_acct, c_prepayment_acct, v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct, notinvoicedreceivables_acct, processing, c_receivable_services_acct, c_bp_group_acct_uu FROM tmp_c_bp_group_acct;

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

INSERT INTO tmp_c_bpartner (ad_client_id, name, value, c_bp_group_id, c_paymentterm_id, m_pricelist_id, bh_patientid) SELECT c.ad_client_id, CONCAT('OTC - ', c.name), COALESCE((SELECT max(cast(c_bpartner.value as numeric)) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.value)), '0'), (SELECT c_bp_group.c_bp_group_id FROM c_bp_group WHERE c_bp_group.ad_client_id = c.ad_client_id AND c_bp_group.name = 'OTC Patient'), (SELECT c_paymentterm_id FROM c_paymentterm WHERE c_paymentterm.ad_client_id = c.ad_client_id AND c_paymentterm.name = 'Immediate'), (SELECT COALESCE((SELECT g.m_pricelist_id from C_BP_Group g
WHERE g.ad_client_id = c.ad_client_id and g.isdefault = 'Y'), (SELECT l.m_pricelist_id FROM m_pricelist l WHERE l.ad_client_id = c.ad_client_id and isdefault = 'Y' and issopricelist = 'Y'), 0)), (SELECT COALESCE((SELECT MAX(CAST(c_bpartner.bh_patientid as NUMERIC)) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.bh_patientid) and c_bpartner.bh_ispatient = 'Y' ), (SELECT CAST(c_bpartner.bh_patientid as NUMERIC) + 1 FROM c_bpartner WHERE c_bpartner.ad_client_id = c.ad_client_id and isnumeric(c_bpartner.bh_patientid) ORDER BY c_bpartner.created desc LIMIT 1))) FROM ad_client c WHERE (c.ad_client_id > 999999 OR c.ad_client_id = 2) AND c.isactive = 'Y';

INSERT INTO c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, invoicerule, paymentrule, c_paymentterm_id, m_pricelist_id, bh_patientid, bh_ispatient, value, name, description, c_bp_group_id, c_bpartner_uu) SELECT c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, invoicerule, paymentrule, c_paymentterm_id, m_pricelist_id, bh_patientid, bh_ispatient, value, name, description, c_bp_group_id, c_bpartner_uu FROM tmp_c_bpartner ON CONFLICT DO NOTHING;

-- Add user contact
DROP TABLE IF EXISTS tmp_ad_user;
CREATE TEMP TABLE tmp_ad_user
(
    ad_user_id                 serial	                            not null,
    ad_client_id               numeric(10)                        not null,
    ad_org_id                  numeric(10)                        not null,
    createdby                  numeric(10)   default 100          not null,
    updatedby                  numeric(10)   default 100          not null,
    name                       varchar(60)                        not null,
    c_bpartner_id              numeric(10),
    isfullbpaccess             char          default 'N'  not null,
    ad_user_uu                 uuid          default uuid_generate_v4()
);
-- SET sequence
SELECT setval(
	'tmp_ad_user_ad_user_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'AD_User' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_ad_user (ad_client_id, ad_org_id, name, c_bpartner_id) SELECT ad_client_Id, ad_org_id, name, c_bpartner_id FROM tmp_c_bpartner;

INSERT INTO ad_user (ad_user_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, isfullbpaccess, ad_user_uu) SELECT ad_user_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, isfullbpaccess, ad_user_uu FROM tmp_ad_user;

-- Add location
DROP TABLE IF EXISTS tmp_c_location;
CREATE TEMP TABLE tmp_c_location
(
    c_location_id          serial                            not null,
    ad_client_id           numeric(10)                       not null,
    ad_org_id              numeric(10)                       not null,
    createdby              numeric(10)   default 100         not null,
    updatedby              numeric(10)   default 100         not null,
    c_country_id           numeric(10)                       not null,
    c_location_uu          uuid          default uuid_generate_v4()

);
-- SET sequence
SELECT setval(
	'tmp_c_location_c_location_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_Location' 
		LIMIT 1
	)::INT, 
	false
);

-- Get the country from the last entered location.
INSERT INTO tmp_c_location (ad_client_id, ad_org_id, c_country_id) SELECT c.ad_client_id, c.ad_org_id, (SELECT c_country_id FROM c_location WHERE c_country_id IS NOT NULL AND ad_client_id = c.ad_client_id ORDER BY created DESC limit 1) FROM tmp_c_bpartner c;

INSERT INTO c_location (c_location_id, ad_client_id, ad_org_id, createdby, updatedby, c_country_id, c_location_uu) SELECT c_location_id, ad_client_id, ad_org_id, createdby, updatedby, c_country_id, c_location_uu FROM tmp_c_location;

-- Add user location
DROP TABLE IF EXISTS tmp_c_bpartner_location;
CREATE TEMP TABLE tmp_c_bpartner_location
(
    c_bpartner_location_id serial                          		not null,
    ad_client_id           numeric(10)                     		not null,
    ad_org_id              numeric(10)                     		not null,
    createdby              numeric(10) default 100         		not null,
    updatedby              numeric(10) default 100         		not null,
    name                   varchar(60) default 'Default Location'   	not null,
    c_bpartner_id          numeric(10)                     		not null,
    c_location_id          numeric(10),
    c_bpartner_location_uu uuid	default uuid_generate_v4()
);

-- SET sequence
SELECT setval(
	'tmp_c_bpartner_location_c_bpartner_location_id_seq', 
	(
		SELECT currentnext 
		FROM ad_sequence 
		WHERE name = 'C_BPartner_Location' 
		LIMIT 1
	)::INT, 
	false
);

INSERT INTO tmp_c_bpartner_location (ad_client_id, ad_org_id, c_bpartner_id, c_location_id) SELECT c.ad_client_id, c.ad_org_id, b.c_bpartner_id, c.c_location_id FROM tmp_c_location c INNER JOIN tmp_c_bpartner b ON c.ad_client_id = b.ad_client_id;

INSERT INTO c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, c_location_id, c_bpartner_location_uu) SELECT c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, c_location_id, c_bpartner_location_uu FROM tmp_c_bpartner_location;

-- Add Customer Account
DROP TABLE IF EXISTS tmp_c_bp_customer_acct;
CREATE TEMP TABLE tmp_c_bp_customer_acct 
(
    c_bpartner_id              numeric(10)                     not null,
    c_acctschema_id            numeric(10)                     not null,
    ad_client_id               numeric(10)                     not null,
    ad_org_id                  numeric(10)                     not null,
    createdby                  numeric(10) default 100         not null,
    updatedby                  numeric(10) default 100         not null,
    c_receivable_acct          numeric(10),
    c_prepayment_acct          numeric(10),
    c_receivable_services_acct numeric(10),
    c_bp_customer_acct_uu      uuid default uuid_generate_v4()
);

INSERT INTO tmp_c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, c_receivable_acct, c_prepayment_acct, c_receivable_services_acct) SELECT p.c_bpartner_id, a.c_acctschema_id, c.ad_client_id, c.ad_org_id, a.c_receivable_acct, a.c_prepayment_acct, a.c_receivable_services_acct FROM tmp_c_bp_group c INNER JOIN tmp_c_bpartner p ON c.ad_client_id = p.ad_client_id INNER JOIN tmp_c_bp_group_acct a ON c.ad_client_id = a.ad_client_id;

INSERT INTO c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct, c_prepayment_acct, c_receivable_services_acct, c_bp_customer_acct_uu) SELECT c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, c_receivable_acct, c_prepayment_acct, c_receivable_services_acct, c_bp_customer_acct_uu FROM tmp_c_bp_customer_acct;

-- Add Vendor Account
DROP TABLE IF EXISTS tmp_c_bp_vendor_acct;
CREATE TEMP TABLE tmp_c_bp_vendor_acct 
(
    c_bpartner_id              numeric(10)                     not null,
    c_acctschema_id            numeric(10)                     not null,
    ad_client_id               numeric(10)                     not null,
    ad_org_id                  numeric(10)                     not null,
    createdby                  numeric(10) default 100         not null,
    updatedby                  numeric(10) default 100         not null,
    v_liability_acct           numeric(10),
    v_liability_services_acct  numeric(10),
    v_prepayment_acct 		numeric(10),
    c_bp_vendor_acct_uu      uuid default uuid_generate_v4()
);

INSERT INTO tmp_c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, v_liability_acct, v_liability_services_acct, v_prepayment_acct) SELECT p.c_bpartner_id, a.c_acctschema_id, c.ad_client_id, c.ad_org_id, a.v_liability_acct, a.v_liability_services_acct, a.v_prepayment_acct FROM tmp_c_bp_group c INNER JOIN tmp_c_bpartner p ON c.ad_client_id = p.ad_client_id INNER JOIN tmp_c_bp_group_acct a ON c.ad_client_id = a.ad_client_id;

INSERT INTO c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, v_liability_acct, v_liability_services_acct, v_prepayment_acct, c_bp_vendor_acct_uu) SELECT c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby, v_liability_acct, v_liability_services_acct, v_prepayment_acct, c_bp_vendor_acct_uu FROM tmp_c_bp_vendor_acct;

-- DROP TEMP Tables
DROP TABLE tmp_c_bp_group_acct;
DROP TABLE tmp_c_bp_group;
DROP TABLE tmp_c_bpartner;
DROP TABLE tmp_ad_user;
DROP TABLE tmp_c_location;
DROP TABLE tmp_c_bpartner_location;
DROP TABLE tmp_c_bp_customer_acct;
DROP TABLE tmp_c_bp_vendor_acct;

-- Add OTC Type
INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id)+1 FROM ad_ref_list), 0, 0, 'Y', '2022-10-06 10:48:58.570000', 100, '2022-10-06 10:48:58.570000', 100, 'ot', 'Over The Counter (OTC)', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'), null, null, 'U', '6ba8938f-3337-4224-be0b-0cbcd3c606ad', null, null) ON CONFLICT DO NOTHING;

-- Add OTC window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id)+1 FROM AD_Window), 0, 0, 'Y', '2022-09-21 15:16:36.986000', 100, '2022-09-21 15:16:36.986000', 100, 'Pharmacy Sales (OTC)', 'Pharmacy Sales (OTC)', null, 'T', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f', null) ON CONFLICT DO NOTHING;

-- Update OTC menu
UPDATE adempiere.ad_menu SET isactive = 'Y', action = 'W', ad_window_id = (SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f') WHERE ad_menu_uu = 'd89d5558-2af5-4922-843d-dfc0e8588b54';

-- Add OTC window access to Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='0520b255-2e55-41b7-b95c-4f6660e77625'), 0, 0, 'Y', '2022-09-27 15:20:35.929000', 100, '2022-09-27 15:20:35.929000', 100, 'Y', 'f960fe3a-0f6b-4a23-b2eb-9716e4723b11', 'Y') ON CONFLICT DO NOTHING;

-- Add OTC window access to Clinic Admin Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='461b31c5-cae2-449d-8a0c-7385b12f4685'), 0, 0, 'Y', '2022-09-22 19:34:51.661000', 100, '2022-09-22 19:34:51.661000', 100, 'Y', '618ce836-f23f-40fd-9b5d-6b2745463212', 'Y') ON CONFLICT DO NOTHING;

-- Add OTC window access to Pharmacy Role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM AD_Window WHERE ad_window_uu='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE ad_role_uu='ec17fee0-a53a-4dbb-b946-423ce14880eb'), 0, 0, 'Y', '2022-09-22 19:37:40.684000', 100, '2022-09-22 19:37:40.684000', 100, 'Y', '0980d9a1-c55b-48be-bc20-13aaec0147fe', 'Y') ON CONFLICT DO NOTHING;

SELECT update_sequences();

SELECT register_migration_script('202209211525_GO-2039.sql') FROM dual;
