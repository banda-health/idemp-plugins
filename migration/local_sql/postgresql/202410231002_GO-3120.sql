/**********************************************************************************************************************/
-- Basically duplicate but rename the NHIF insurers (which are BPs) and copy over all their payment field information
-- Then deactivate the current three NHIF insurers for each client
/**********************************************************************************************************************/

/**********************************************************************************************************************/
-- Create the SHA business partners
/**********************************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TABLE tmp_c_bpartner
(
	c_bpartner_id               serial                           NOT NULL,
	ad_client_id                numeric(10)                      NOT NULL,
	ad_org_id                   numeric(10)                      NOT NULL,
	isactive                    char         DEFAULT 'Y'::bpchar NOT NULL,
	created                     timestamp    DEFAULT NOW()       NOT NULL,
	createdby                   numeric(10)                      NOT NULL,
	updated                     timestamp    DEFAULT NOW()       NOT NULL,
	updatedby                   numeric(10)                      NOT NULL,
	value                       varchar(40)                      NOT NULL,
	name                        varchar(120)                     NOT NULL,
	name2                       varchar(60),
	description                 varchar(255),
	issummary                   char         DEFAULT 'N'::bpchar NOT NULL,
	c_bp_group_id               numeric(10)                      NOT NULL,
	isonetime                   char         DEFAULT 'N'::bpchar NOT NULL,
	isprospect                  char         DEFAULT 'N'::bpchar NOT NULL,
	isvendor                    char         DEFAULT 'N'::bpchar NOT NULL,
	iscustomer                  char         DEFAULT 'Y'::bpchar NOT NULL,
	isemployee                  char         DEFAULT 'N'::bpchar NOT NULL,
	issalesrep                  char         DEFAULT 'N'::bpchar NOT NULL,
	referenceno                 varchar(40),
	duns                        varchar(11),
	url                         varchar(120),
	ad_language                 varchar(6),
	taxid                       varchar(20),
	istaxexempt                 char         DEFAULT 'N'::bpchar,
	c_invoiceschedule_id        numeric(10),
	rating                      char,
	salesvolume                 numeric(10),
	numberemployees             numeric(10),
	naics                       varchar(6),
	firstsale                   timestamp,
	acqusitioncost              numeric      DEFAULT 0,
	potentiallifetimevalue      numeric      DEFAULT 0,
	actuallifetimevalue         numeric      DEFAULT 0,
	shareofcustomer             numeric(10),
	paymentrule                 char,
	so_creditlimit              numeric      DEFAULT 0,
	so_creditused               numeric      DEFAULT 0,
	c_paymentterm_id            numeric(10),
	m_pricelist_id              numeric(10),
	m_discountschema_id         numeric(10),
	c_dunning_id                numeric(10),
	isdiscountprinted           char         DEFAULT 'Y'::bpchar,
	so_description              varchar(255),
	poreference                 varchar(20),
	paymentrulepo               char,
	po_pricelist_id             numeric(10),
	po_discountschema_id        numeric(10),
	po_paymentterm_id           numeric(10),
	documentcopies              numeric(10),
	c_greeting_id               numeric(10),
	invoicerule                 char,
	deliveryrule                char,
	freightcostrule             char,
	deliveryviarule             char,
	salesrep_id                 numeric(10),
	sendemail                   char         DEFAULT 'N'::bpchar NOT NULL,
	bpartner_parent_id          numeric(10),
	invoice_printformat_id      numeric(10),
	socreditstatus              char         DEFAULT 'O'::bpchar,
	shelflifeminpct             numeric(10),
	ad_orgbp_id                 numeric(10),
	flatdiscount                numeric,
	totalopenbalance            numeric,
	dunninggrace                timestamp,
	c_taxgroup_id               numeric(10),
	logo_id                     numeric(10)  DEFAULT NULL::numeric,
	ispotaxexempt               char         DEFAULT 'N'::bpchar NOT NULL,
	ismanufacturer              char         DEFAULT 'N'::bpchar,
	c_bpartner_uu               varchar(36)  DEFAULT NULL::character varying,
	customerprofileid           varchar(60)  DEFAULT NULL::character varying,
	default1099box_id           numeric(10)  DEFAULT NULL::numeric,
	is1099vendor                char         DEFAULT 'N'::bpchar NOT NULL,
	bh_birthday                 timestamp,
	bh_email                    varchar(60)  DEFAULT NULL::character varying,
	bh_phone                    varchar(40)  DEFAULT NULL::character varying,
	bh_patientid                varchar(100),
	nationalid                  varchar(10),
	nextofkin_name              varchar(100) DEFAULT NULL::character varying,
	nextofkin_contact           varchar(100) DEFAULT NULL::character varying,
	bh_occupation               varchar(100) DEFAULT NULL::character varying,
	bh_gender                   varchar(10)  DEFAULT NULL::character varying,
	bh_nextappointmentdate      timestamp,
	bh_local_patientid          varchar(100),
	bh_isapproximatedateofbirth char         DEFAULT 'N'::bpchar NOT NULL,
	bh_needadditionalvisitinfo  char,
	bh_locked                   char         DEFAULT 'N'::bpchar,
	c_bpartner_id_old           numeric(10)                      NOT NULL
);

SELECT
	SETVAL(
		'tmp_c_bpartner_c_bpartner_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'C_BPartner'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_c_bpartner (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, name2,
	                description, issummary, c_bp_group_id, isonetime, isprospect, isvendor, iscustomer, isemployee,
	                issalesrep, referenceno, duns, url, ad_language, taxid, istaxexempt, c_invoiceschedule_id, rating,
	                salesvolume, numberemployees, naics, firstsale, acqusitioncost, potentiallifetimevalue,
	                actuallifetimevalue, shareofcustomer, paymentrule, so_creditlimit, so_creditused, c_paymentterm_id,
	                m_pricelist_id, m_discountschema_id, c_dunning_id, isdiscountprinted, so_description, poreference,
	                paymentrulepo, po_pricelist_id, po_discountschema_id, po_paymentterm_id, documentcopies,
	                c_greeting_id, invoicerule, deliveryrule, freightcostrule, deliveryviarule, salesrep_id, sendemail,
	                bpartner_parent_id, invoice_printformat_id, socreditstatus, shelflifeminpct, ad_orgbp_id,
	                flatdiscount, totalopenbalance, dunninggrace, c_taxgroup_id, logo_id, ispotaxexempt, ismanufacturer,
	                c_bpartner_uu, customerprofileid, default1099box_id, is1099vendor, bh_birthday, bh_email, bh_phone,
	                bh_patientid, nationalid, nextofkin_name, nextofkin_contact, bh_occupation, bh_gender,
	                bh_nextappointmentdate, bh_local_patientid, bh_isapproximatedateofbirth, bh_needadditionalvisitinfo,
	                bh_locked, c_bpartner_id_old)
SELECT
	ad_client_id,
	ad_org_id,
	isactive,
	NOW(),
	100,
	NOW(),
	100,
	'Social Health Authority',
	'Social Health Authority',
	name2,
	'Social Health Authority',
	issummary,
	c_bp_group_id,
	isonetime,
	isprospect,
	isvendor,
	iscustomer,
	isemployee,
	issalesrep,
	referenceno,
	duns,
	url,
	ad_language,
	taxid,
	istaxexempt,
	c_invoiceschedule_id,
	rating,
	salesvolume,
	numberemployees,
	naics,
	NULL,
	acqusitioncost,
	0,
	0,
	0,
	paymentrule,
	0,
	0,
	c_paymentterm_id,
	m_pricelist_id,
	m_discountschema_id,
	c_dunning_id,
	isdiscountprinted,
	so_description,
	poreference,
	paymentrulepo,
	po_pricelist_id,
	po_discountschema_id,
	po_paymentterm_id,
	documentcopies,
	c_greeting_id,
	invoicerule,
	deliveryrule,
	freightcostrule,
	deliveryviarule,
	salesrep_id,
	sendemail,
	bpartner_parent_id,
	invoice_printformat_id,
	socreditstatus,
	shelflifeminpct,
	ad_orgbp_id,
	flatdiscount,
	0,
	dunninggrace,
	c_taxgroup_id,
	logo_id,
	ispotaxexempt,
	ismanufacturer,
	uuid_generate_v4(),
	customerprofileid,
	default1099box_id,
	is1099vendor,
	bh_birthday,
	bh_email,
	bh_phone,
	bh_patientid,
	nationalid,
	nextofkin_name,
	nextofkin_contact,
	bh_occupation,
	bh_gender,
	bh_nextappointmentdate,
	bh_local_patientid,
	bh_isapproximatedateofbirth,
	bh_needadditionalvisitinfo,
	bh_locked,
	c_bpartner_id
FROM
	c_bpartner
WHERE
	name = 'NHIF National Scheme';

INSERT INTO
	c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name,
	            name2, description, issummary, c_bp_group_id, isonetime, isprospect, isvendor, iscustomer, isemployee,
	            issalesrep, referenceno, duns, url, ad_language, taxid, istaxexempt, c_invoiceschedule_id, rating,
	            salesvolume, numberemployees, naics, firstsale, acqusitioncost, potentiallifetimevalue,
	            actuallifetimevalue, shareofcustomer, paymentrule, so_creditlimit, so_creditused, c_paymentterm_id,
	            m_pricelist_id, m_discountschema_id, c_dunning_id, isdiscountprinted, so_description, poreference,
	            paymentrulepo, po_pricelist_id, po_discountschema_id, po_paymentterm_id, documentcopies, c_greeting_id,
	            invoicerule, deliveryrule, freightcostrule, deliveryviarule, salesrep_id, sendemail, bpartner_parent_id,
	            invoice_printformat_id, socreditstatus, shelflifeminpct, ad_orgbp_id, flatdiscount, totalopenbalance,
	            dunninggrace, c_taxgroup_id, logo_id, ispotaxexempt, ismanufacturer, c_bpartner_uu, customerprofileid,
	            default1099box_id, is1099vendor, bh_birthday, bh_email, bh_phone, bh_patientid, nationalid,
	            nextofkin_name, nextofkin_contact, bh_occupation, bh_gender, bh_nextappointmentdate, bh_local_patientid,
	            bh_isapproximatedateofbirth, bh_needadditionalvisitinfo, bh_locked)
SELECT
	c_bpartner_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	value,
	name,
	name2,
	description,
	issummary,
	c_bp_group_id,
	isonetime,
	isprospect,
	isvendor,
	iscustomer,
	isemployee,
	issalesrep,
	referenceno,
	duns,
	url,
	ad_language,
	taxid,
	istaxexempt,
	c_invoiceschedule_id,
	rating,
	salesvolume,
	numberemployees,
	naics,
	firstsale,
	acqusitioncost,
	potentiallifetimevalue,
	actuallifetimevalue,
	shareofcustomer,
	paymentrule,
	so_creditlimit,
	so_creditused,
	c_paymentterm_id,
	m_pricelist_id,
	m_discountschema_id,
	c_dunning_id,
	isdiscountprinted,
	so_description,
	poreference,
	paymentrulepo,
	po_pricelist_id,
	po_discountschema_id,
	po_paymentterm_id,
	documentcopies,
	c_greeting_id,
	invoicerule,
	deliveryrule,
	freightcostrule,
	deliveryviarule,
	salesrep_id,
	sendemail,
	bpartner_parent_id,
	invoice_printformat_id,
	socreditstatus,
	shelflifeminpct,
	ad_orgbp_id,
	flatdiscount,
	totalopenbalance,
	dunninggrace,
	c_taxgroup_id,
	logo_id,
	ispotaxexempt,
	ismanufacturer,
	c_bpartner_uu,
	customerprofileid,
	default1099box_id,
	is1099vendor,
	bh_birthday,
	bh_email,
	bh_phone,
	bh_patientid,
	nationalid,
	nextofkin_name,
	nextofkin_contact,
	bh_occupation,
	bh_gender,
	bh_nextappointmentdate,
	bh_local_patientid,
	bh_isapproximatedateofbirth,
	bh_needadditionalvisitinfo,
	bh_locked
FROM
	tmp_c_bpartner;

/**********************************************************************************************************************/
-- Create the payer information fields and values
/**********************************************************************************************************************/
DROP TABLE IF EXISTS tmp_bh_payer_info_fld;
CREATE TEMP TABLE tmp_bh_payer_info_fld
(
	ad_client_id              numeric(10)             NOT NULL,
	ad_org_id                 numeric(10)             NOT NULL,
	bh_payerinfofielddatatype varchar(2)              NOT NULL,
	bh_fillfrompatient        char                    NOT NULL,
	bh_payer_id               numeric(10)             NOT NULL,
	bh_payer_info_fld_id      serial                  NOT NULL,
	bh_payer_info_fld_uu      varchar(36) DEFAULT uuid_generate_v4(),
-- 	created                   timestamp    DEFAULT NOW()       NOT NULL,
	createdby                 numeric(10) DEFAULT 100 NOT NULL,
	description               varchar(255),
-- 	isactive                  char        DEFAULT 'Y'::bpchar NOT NULL,
	line                      numeric(10)             NOT NULL,
	name                      varchar(60)             NOT NULL,
-- 	updated                   timestamp   DEFAULT NOW()       NOT NULL,
	updatedby                 numeric(10) DEFAULT 100 NOT NULL,
	bh_payer_info_fld_id_old  numeric(10)             NOT NULL
);
SELECT
	SETVAL(
		'tmp_bh_payer_info_fld_bh_payer_info_fld_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'BH_Payer_Info_Fld'
			LIMIT 1
		)::INT,
		FALSE
	);

DROP TABLE IF EXISTS tmp_bh_payer_info_fld_val;
CREATE TEMP TABLE tmp_bh_payer_info_fld_val
(
	ad_client_id             numeric(10)             NOT NULL,
	ad_org_id                numeric(10)             NOT NULL,
	bh_payer_info_fld_id     numeric(10)             NOT NULL,
	bh_payer_info_fld_val_id serial                  NOT NULL,
	bh_payer_info_fld_val_uu uuid        DEFAULT uuid_generate_v4(),
-- 	created                  timestamp    DEFAULT NOW()       NOT NULL,
	createdby                numeric(10) DEFAULT 100 NOT NULL,
	description              varchar(255),
-- 	isactive                 char         DEFAULT 'Y'::bpchar NOT NULL,
	line                     numeric(10)             NOT NULL,
	name                     varchar(60)             NOT NULL,
-- 	updated                  timestamp    DEFAULT NOW()       NOT NULL,
	updatedby                numeric(10) DEFAULT 100 NOT NULL
);
SELECT
	SETVAL(
		'tmp_bh_payer_info_fld_val_bh_payer_info_fld_val_id_seq',
		(
			SELECT
				currentnext
			FROM
				ad_sequence
			WHERE
				name = 'BH_Payer_Info_Fld_Val'
			LIMIT 1
		)::INT,
		FALSE
	);

INSERT INTO
	tmp_bh_payer_info_fld (ad_client_id, ad_org_id, bh_payerinfofielddatatype, bh_fillfrompatient, bh_payer_id,
	                       description, line, name, bh_payer_info_fld_id_old)
SELECT
	pif.ad_client_id,
	pif.ad_org_id,
	pif.bh_payerinfofielddatatype,
	pif.bh_fillfrompatient,
	bp.c_bpartner_id,
	pif.description,
	pif.line,
	pif.name,
	pif.bh_payer_info_fld_id
FROM
	bh_payer_info_fld pif
		JOIN tmp_c_bpartner bp
		ON bp.ad_client_id = pif.ad_client_id AND pif.bh_payer_id = bp.c_bpartner_id_old;

INSERT INTO
	bh_payer_info_fld (ad_client_id, ad_org_id, bh_payerinfofielddatatype, bh_fillfrompatient, bh_payer_id,
	                   bh_payer_info_fld_id, bh_payer_info_fld_uu, createdby, description, line, name, updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	bh_payerinfofielddatatype,
	bh_fillfrompatient,
	bh_payer_id,
	bh_payer_info_fld_id,
	bh_payer_info_fld_uu,
	createdby,
	description,
	line,
	name,
	updatedby
FROM
	tmp_bh_payer_info_fld;

INSERT INTO
	tmp_bh_payer_info_fld_val (ad_client_id, ad_org_id, bh_payer_info_fld_id, description, line, name)
SELECT
	pifv.ad_client_id,
	pifv.ad_org_id,
	pif.bh_payer_info_fld_id,
	pifv.description,
	pifv.line,
	pifv.name
FROM
	bh_payer_info_fld_val pifv
		JOIN tmp_bh_payer_info_fld pif
		ON pifv.bh_payer_info_fld_id = pif.bh_payer_info_fld_id_old;

INSERT INTO
	bh_payer_info_fld_val (ad_client_id, ad_org_id, bh_payer_info_fld_id, bh_payer_info_fld_val_id,
	                       bh_payer_info_fld_val_uu, createdby, description, line, name, updatedby)
SELECT
	ad_client_id,
	ad_org_id,
	bh_payer_info_fld_id,
	bh_payer_info_fld_val_id,
	bh_payer_info_fld_val_uu,
	createdby,
	description,
	line,
	name,
	updatedby
FROM
	tmp_bh_payer_info_fld_val;

SELECT
	update_sequences();

/**********************************************************************************************************************/
-- Disable the NHIF insurers
/**********************************************************************************************************************/
UPDATE c_bpartner
SET
	isactive = 'N'
WHERE
	name IN ('NHIF FFS', 'NHIF Fixed FFS', 'NHIF National Scheme')
	AND bh_locked = 'Y';

SELECT
	register_migration_script('202410231002_GO-3120.sql')
FROM
	dual;
