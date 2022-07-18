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

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF National Scheme - Income', 'NHIF National Scheme - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF Fixed FFS - Income', 'NHIF Fixed FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'NHIF FFS - Income', 'NHIF FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'MCH - Income', 'MCH - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Linda Mama - Income', 'Linda Mama - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Liason Insurance - Income', 'Liason Insurance - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'EduAfya FFS - Income', 'EduAfya FFS - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'Donor Fund - Income', 'Donor Fund - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO tmp_c_charge (ad_client_id, name, description, c_chargetype_id, c_elementvalue_id) SELECT c.ad_client_id, 'CCC - Income', 'CCC - Income', (SELECT c_chargetype_id FROM c_chargetype WHERE name='Default Income Category - DO NOT CHANGE' AND ad_client_id = c.ad_client_id), (SELECT c_elementvalue_id FROM c_elementvalue WHERE c_elementvalue_uu='36f9c73f-921b-4f11-9a49-d2d0f9fc5d9c') FROM ad_client c WHERE c.ad_client_id > 999999;

INSERT INTO c_charge (c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo) SELECT c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo FROM tmp_c_charge ON CONFLICT DO NOTHING;

SELECT update_sequences();

SELECT register_migration_script('202207151225_GO-1335.sql') FROM dual;
