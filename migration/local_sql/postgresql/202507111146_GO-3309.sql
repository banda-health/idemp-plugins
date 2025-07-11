-- Add default no supplier cbpartner group
INSERT INTO c_bp_group (c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
                        name, description, isdefault, ad_printcolor_id, isconfidentialinfo, prioritybase,
                        m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id, creditwatchpercent,
                        pricematchtolerance, c_dunning_id, c_bp_group_uu, bh_subtype, bh_locked)
VALUES ((SELECT MAX(c_bp_group_id) + 1 FROM c_bp_group), 2, 0, 'Y', '2025-07-11 11:30:51.283000', 100,
        '2025-07-11 11:39:20.686000', 100,
        'No Supplier Selected', 'No Supplier Selected', 'DO NOT CHANGE', 'N', null, 'N', 'S', null, null, null, null,
        null, null, null, 'ea158eaa-55fe-4d79-a421-a96d39d8caad', null, 'N');

-- Add default cgroup acct
INSERT INTO c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated, updatedby, c_receivable_acct, c_prepayment_acct, v_liability_acct,
                             v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct,
                             writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct,
                             notinvoicedreceivables_acct, processing, c_receivable_services_acct, c_bp_group_acct_uu)
VALUES ((SELECT c_acctschema_id FROM c_acctschema WHERE c_acctschema_uu = '68765320-4a60-4d10-b89b-2899231292b5'),
        (SELECT c_bp_group_id FROM c_bp_group WHERE c_bp_group_uu = 'ea158eaa-55fe-4d79-a421-a96d39d8caad'), 2, 0, 'Y',
        '2025-07-11 11:30:51.304280', 100, '2025-07-11 11:30:51.304280', 100, 190014,
        190013, 190048, 190049, 190050, 190036, 190037, 190052, 190022, 190045, null, null, null, 190015,
        'dd53bb04-1967-4b6d-8d26-a1a17e2c92d3');

-- Add default no supplier bpartner
INSERT INTO c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
                        name, name2, description, issummary, c_bp_group_id, isonetime, isprospect, isvendor, iscustomer,
                        isemployee, issalesrep, referenceno, duns, url, ad_language, taxid, istaxexempt,
                        c_invoiceschedule_id, rating, salesvolume, numberemployees, naics, firstsale, acqusitioncost,
                        potentiallifetimevalue, actuallifetimevalue, shareofcustomer, paymentrule, so_creditlimit,
                        so_creditused, c_paymentterm_id, m_pricelist_id, m_discountschema_id, c_dunning_id,
                        isdiscountprinted, so_description, poreference, paymentrulepo, po_pricelist_id,
                        po_discountschema_id, po_paymentterm_id, documentcopies, c_greeting_id, invoicerule,
                        deliveryrule, freightcostrule, deliveryviarule, salesrep_id, sendemail, bpartner_parent_id,
                        invoice_printformat_id, socreditstatus, shelflifeminpct, ad_orgbp_id, flatdiscount,
                        totalopenbalance, dunninggrace, c_taxgroup_id, logo_id, ispotaxexempt, ismanufacturer,
                        c_bpartner_uu, customerprofileid, default1099box_id, is1099vendor, bh_local_patientid,
                        bh_patientid, bh_birthday, bh_email, bh_phone, nationalid, nextofkin_name, nextofkin_contact,
                        bh_occupation, bh_gender, bh_nextappointmentdate, bh_isapproximatedateofbirth,
                        bh_needadditionalvisitinfo, bh_locked, bh_have_specified_no_known_allergies)
VALUES ((SELECT MAX(c_bpartner_id) + 1 FROM c_bpartner), 2, 0, 'Y', '2025-07-11 11:35:04.477000', 100,
        '2025-07-11 11:41:05.247000', 100,
        'No Supplier Selected', 'No Supplier Selected', null, 'DO NOT CHANGE', 'N',
        (SELECT c_bp_group_id FROM c_bp_group WHERE c_bp_group_uu = 'ea158eaa-55fe-4d79-a421-a96d39d8caad'), 'N', 'N',
        'Y', 'N', 'N',
        'N', null, null, null, 'en_US', null, 'N', null, null, 0, 0, null, null, 0, 0, 0, 0, null, 0, 0,
        (SELECT c_paymentterm_id FROM c_paymentterm WHERE c_paymentterm_uu = '1305e2ca-2397-476b-b103-00ada232e072'),
        null,
        null, null, 'N', null, null, 'T',
        (SELECT m_pricelist_id FROM m_pricelist WHERE m_pricelist_uu = 'a40fe288-3ca5-4fa8-b0f9-03ec406a01b1'),
        null,
        (SELECT c_paymentterm_id FROM c_paymentterm WHERE c_paymentterm_uu = '1305e2ca-2397-476b-b103-00ada232e072'),
        0, null, null, null, null, null, null, 'N', null, null,
        'X', 0, null, 0, 0, null, null, null, 'N', 'N', '00720b75-f3ae-413a-8f72-53efbe3976ce', null, null, 'N', null,
        null, null, null, null, null, null, null, null, null, null, 'N', null, 'N', 'N');

-- ADD vendor accounting
INSERT INTO c_bp_vendor_acct (c_acctschema_id, c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby,
                              updated, updatedby, v_liability_acct, v_liability_services_acct, v_prepayment_acct,
                              c_bp_vendor_acct_uu)
VALUES ((SELECT c_acctschema_id FROM c_acctschema WHERE c_acctschema_uu = '68765320-4a60-4d10-b89b-2899231292b5'),
        (SELECT c_bpartner_id FROM c_bpartner WHERE c_bpartner_uu = '00720b75-f3ae-413a-8f72-53efbe3976ce'),
        2, 0, 'Y', '2025-07-11 11:35:04.527858', 100, '2025-07-11 11:35:04.527858', 100,
        190048, 190049, 190050, 'b466d7a2-2572-452e-ba18-96c36a2be6a1');

-- add customer accounting
INSERT INTO c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, isactive, created, createdby,
                                updated, updatedby, c_receivable_acct, c_prepayment_acct, c_receivable_services_acct,
                                c_bp_customer_acct_uu)
VALUES ((SELECT c_bpartner_id FROM c_bpartner WHERE c_bpartner_uu = '00720b75-f3ae-413a-8f72-53efbe3976ce'),
        (SELECT c_acctschema_id FROM c_acctschema WHERE c_acctschema_uu = '68765320-4a60-4d10-b89b-2899231292b5'),
        2, 0, 'Y', '2025-07-11 11:35:04.525892', 100, '2025-07-11 11:35:04.525892', 100,
        190014, 190013, 190015, '243a6682-c79e-4b3f-9387-3293d6a8ab61');

-- Add location
INSERT INTO c_location (c_location_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                        address1, address2, city, postal, postal_add, c_country_id, c_region_id, c_city_id, regionname,
                        address3, address4, c_location_uu, validateaddress, result, isvalid, c_addressvalidation_id,
                        address5, comments)
VALUES ((SELECT MAX(c_location_id) + 1 FROM c_location),
        2, 0, 'Y', '2025-07-11 11:42:04.383000', 100, '2025-07-11 11:42:04.383000', 100, null, null, null,
        null, null, 219, null, null, null, null, null, '81ce2c44-fb7d-4281-a12f-2b81d7efe8cc', null, null, 'N', null,
        null, null);

-- Add cbpartner location
INSERT INTO c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                                 updatedby, name, isbillto, isshipto, ispayfrom, isremitto, phone, phone2, fax, isdn,
                                 c_salesregion_id, c_bpartner_id, c_location_id, c_bpartner_location_uu,
                                 customeraddressid, ispreservecustomname)
VALUES ((SELECT MAX(c_bpartner_location_id) + 1 FROM c_bpartner_location),
        2, 0, 'Y', '2025-07-11 11:42:20.732000', 100, '2025-07-11 11:42:20.732000', 100,
        'Default Location', 'Y', 'Y', 'Y', 'Y', null, null, null, null, null,
        (SELECT c_bpartner_id FROM c_bpartner WHERE c_bpartner_uu = '00720b75-f3ae-413a-8f72-53efbe3976ce'),
        (SELECT c_location_id FROM c_location WHERE c_location_uu = '81ce2c44-fb7d-4281-a12f-2b81d7efe8cc'),
        '4fc21f5d-65ea-4cc5-9e35-ae9bb6f2ab5e', null, 'N');


INSERT INTO ad_user (ad_user_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
                     description, password, email, supervisor_id, c_bpartner_id, processing, emailuser, emailuserpw,
                     c_bpartner_location_id, c_greeting_id, title, comments, phone, phone2, fax, lastcontact,
                     lastresult, birthday, ad_orgtrx_id, emailverify, emailverifydate, notificationtype, isfullbpaccess,
                     c_job_id, ldapuser, connectionprofile, value, userpin, isinpayroll, ad_user_uu, ismenuautoexpand,
                     salt, islocked, dateaccountlocked, failedlogincount, datepasswordchanged, datelastlogin,
                     isnopasswordreset, isexpired, securityquestion, answer, issaleslead, c_location_id, leadsource,
                     leadstatus, leadsourcedescription, leadstatusdescription, c_campaign_id, salesrep_id, bpname,
                     bp_location_id, isaddmailtextautomatically, r_defaultmailtext_id, ad_image_id, isnoexpire,
                     issupportuser, bh_tos_date_accepted, bh_hasacceptedtermsofuse, isbillto, isshipto, isvendorlead,
                     authenticationtype)
VALUES ((SELECT MAX(ad_user_id) + 1 FROM ad_user),
        2, 0, 'Y', '2025-07-11 11:35:04.529000', 100, '2025-07-11 11:35:04.529000', 100,
        'No Supplier Selected', null, null, null, null,
        (SELECT c_bpartner_id FROM c_bpartner WHERE c_bpartner_uu = '00720b75-f3ae-413a-8f72-53efbe3976ce'),
        'N', null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, 'X', 'N', null, null, null, 'nselecte', null, 'N',
        '2b9bce81-8cad-48db-96ab-0b005b7b6c0c', null, null, 'N', null, 0, null, null, 'N', 'N', null, null, 'N', null,
        null, null, null, null, null, null, null, null, 'N', null, null, 'N', 'N', null, 'N', 'N', 'N', 'N', null);

-- Add to existing clients
DROP TABLE IF EXISTS tmp_c_bp_group;

CREATE TEMP TABLE tmp_c_bp_group
(
    c_bp_group_id        serial                                      NOT NULL,
    ad_client_id         numeric(10)                                 NOT NULL,
    ad_org_id            numeric(10)  DEFAULT 0                      NOT NULL,
    isactive             char         DEFAULT 'Y'                    NOT NULL,
    createdby            numeric(10)  DEFAULT 100                    NOT NULL,
    updated              timestamp    DEFAULT NOW()                  NOT NULL,
    updatedby            numeric(10)  DEFAULT 100                    NOT NULL,
    value                varchar(40)  DEFAULT 'No Supplier Selected' NOT NULL,
    name                 varchar(60)  DEFAULT 'No Supplier Selected' NOT NULL,
    description          varchar(255) DEFAULT 'No Supplier Selected',
    prioritybase         char,
    m_pricelist_id       numeric(10),
    po_pricelist_id      numeric(10),
    m_discountschema_id  numeric(10),
    po_discountschema_id numeric(10),
    creditwatchpercent   numeric,
    pricematchtolerance  numeric,
    c_dunning_id         numeric(10),
    c_bp_group_uu        uuid         DEFAULT uuid_generate_v4()     NOT NULL
);

-- SET sequence
SELECT SETVAL(
               'tmp_c_bp_group_c_bp_group_id_seq',
               (SELECT currentnext
                FROM ad_sequence
                WHERE name = 'C_BP_Group'
                LIMIT 1)::INT,
               FALSE
       );

INSERT INTO tmp_c_bp_group (ad_client_id, ad_org_id, prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id,
                            po_discountschema_id, creditwatchpercent, pricematchtolerance, c_dunning_id)
SELECT c.ad_client_id,
       bp.ad_org_id,
       bp.prioritybase,
       bp.m_pricelist_id,
       bp.po_pricelist_id,
       bp.m_discountschema_id,
       bp.po_discountschema_id,
       bp.creditwatchpercent,
       bp.pricematchtolerance,
       bp.c_dunning_id
FROM ad_client c
         INNER JOIN c_bp_group bp
                    ON c.ad_client_id = bp.ad_client_id
WHERE (c.ad_client_id > 999999 OR c.ad_client_id = 2)
  AND c.isactive = 'Y'
  AND bp.name = 'Standard'
  AND bp.isdefault = 'Y';

INSERT INTO c_bp_group(c_bp_group_id, ad_client_id, ad_org_id, isactive, createdby, updated, updatedby, value, name,
                       description,
                       prioritybase, m_pricelist_id, po_pricelist_id, m_discountschema_id, po_discountschema_id,
                       creditwatchpercent, pricematchtolerance, c_dunning_id, c_bp_group_uu)
SELECT c_bp_group_id,
       ad_client_id,
       ad_org_id,
       isactive,
       createdby,
       updated,
       updatedby,
       value,
       name,
       description,
       prioritybase,
       m_pricelist_id,
       po_pricelist_id,
       m_discountschema_id,
       po_discountschema_id,
       creditwatchpercent,
       pricematchtolerance,
       c_dunning_id,
       c_bp_group_uu
FROM tmp_c_bp_group
ON CONFLICT DO NOTHING;

-- Add bp group a/cs
DROP TABLE IF EXISTS tmp_c_bp_group_acct;
CREATE TEMP TABLE tmp_c_bp_group_acct
(
    c_acctschema_id             serial                    NOT NULL,
    c_bp_group_id               numeric(10)               NOT NULL,
    ad_client_id                numeric(10)               NOT NULL,
    ad_org_id                   numeric(10)               NOT NULL,
    isactive                    char        DEFAULT 'Y'   NOT NULL,
    created                     timestamp   DEFAULT NOW() NOT NULL,
    createdby                   numeric(10) DEFAULT 100   NOT NULL,
    updated                     timestamp   DEFAULT NOW() NOT NULL,
    updatedby                   numeric(10) DEFAULT 100   NOT NULL,
    c_receivable_acct           numeric(10)               NOT NULL,
    c_prepayment_acct           numeric(10)               NOT NULL,
    v_liability_acct            numeric(10)               NOT NULL,
    v_liability_services_acct   numeric(10),
    v_prepayment_acct           numeric(10)               NOT NULL,
    paydiscount_exp_acct        numeric(10)               NOT NULL,
    paydiscount_rev_acct        numeric(10)               NOT NULL,
    writeoff_acct               numeric(10)               NOT NULL,
    notinvoicedreceipts_acct    numeric(10)               NOT NULL,
    unearnedrevenue_acct        numeric(10),
    notinvoicedrevenue_acct     numeric(10),
    notinvoicedreceivables_acct numeric(10),
    processing                  char,
    c_receivable_services_acct  numeric(10),
    c_bp_group_acct_uu          uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO tmp_c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, c_receivable_acct,
                                 c_prepayment_acct,
                                 v_liability_acct, v_liability_services_acct, v_prepayment_acct, paydiscount_exp_acct,
                                 paydiscount_rev_acct, writeoff_acct, notinvoicedreceipts_acct, unearnedrevenue_acct,
                                 notinvoicedrevenue_acct, notinvoicedreceivables_acct, processing,
                                 c_receivable_services_acct)
SELECT bpga.c_acctschema_id,
       tbpg.c_bp_group_id,
       bpga.ad_client_id,
       bpga.ad_org_id,
       bpga.c_receivable_acct,
       bpga.c_prepayment_acct,
       bpga.v_liability_acct,
       bpga.v_liability_services_acct,
       bpga.v_prepayment_acct,
       bpga.paydiscount_exp_acct,
       bpga.paydiscount_rev_acct,
       bpga.writeoff_acct,
       bpga.notinvoicedreceipts_acct,
       bpga.unearnedrevenue_acct,
       bpga.notinvoicedrevenue_acct,
       bpga.notinvoicedreceivables_acct,
       bpga.processing,
       bpga.c_receivable_services_acct
FROM c_bp_group tbpg
         JOIN c_bp_group bpg
              ON tbpg.ad_client_id = bpg.ad_client_id AND bpg.name = 'Standard'
         JOIN c_bp_group_acct bpga
              ON bpg.c_bp_group_id = bpga.c_bp_group_id
         LEFT JOIN c_bp_group_acct bpgaotc
                   ON tbpg.c_bp_group_id = bpgaotc.c_bp_group_id
WHERE tbpg.name = 'No Supplier Selected'
  AND bpgaotc.c_acctschema_id IS NULL;

INSERT INTO c_bp_group_acct (c_acctschema_id, c_bp_group_id, ad_client_id, ad_org_id, isactive, created, createdby,
                             updated,
                             updatedby, c_receivable_acct, c_prepayment_acct, v_liability_acct,
                             v_liability_services_acct,
                             v_prepayment_acct, paydiscount_exp_acct, paydiscount_rev_acct, writeoff_acct,
                             notinvoicedreceipts_acct, unearnedrevenue_acct, notinvoicedrevenue_acct,
                             notinvoicedreceivables_acct,
                             processing, c_receivable_services_acct, c_bp_group_acct_uu)
SELECT c_acctschema_id,
       c_bp_group_id,
       ad_client_id,
       ad_org_id,
       isactive,
       created,
       createdby,
       updated,
       updatedby,
       c_receivable_acct,
       c_prepayment_acct,
       v_liability_acct,
       v_liability_services_acct,
       v_prepayment_acct,
       paydiscount_exp_acct,
       paydiscount_rev_acct,
       writeoff_acct,
       notinvoicedreceipts_acct,
       unearnedrevenue_acct,
       notinvoicedrevenue_acct,
       notinvoicedreceivables_acct,
       processing,
       c_receivable_services_acct,
       c_bp_group_acct_uu
FROM tmp_c_bp_group_acct;

-- Add supplier to existing clients.
DROP TABLE IF EXISTS tmp_c_bpartner;
CREATE TEMP TABLE tmp_c_bpartner
(
    c_bpartner_id    serial                                      NOT NULL,
    ad_client_id     numeric(10)                                 NOT NULL,
    ad_org_id        numeric(10)  DEFAULT 0                      NOT NULL,
    isactive         char         DEFAULT 'Y'::bpchar            NOT NULL,
    created          timestamp    DEFAULT NOW()                  NOT NULL,
    createdby        numeric(10)  DEFAULT 100                    NOT NULL,
    updated          timestamp    DEFAULT NOW()                  NOT NULL,
    updatedby        numeric(10)  DEFAULT 100                    NOT NULL,
    invoicerule      char         DEFAULT 'I'                    NOT NULL,
    paymentrule      char         DEFAULT 'B'                    NOT NULL,
    c_paymentterm_id numeric(10)                                 NOT NULL,
    m_pricelist_id   numeric(10)                                 NOT NULL,
    value            varchar(40)  DEFAULT 'No Supplier Selected' NOT NULL,
    name             varchar(120) DEFAULT 'No Supplier Selected' NOT NULL,
    description      varchar(100) DEFAULT 'DO NOT CHANGE',
    c_bp_group_id    numeric(10),
    c_bpartner_uu    uuid         DEFAULT uuid_generate_v4()     NOT NULL
);

-- SET sequence
SELECT SETVAL(
               'tmp_c_bpartner_c_bpartner_id_seq',
               (SELECT currentnext
                FROM ad_sequence
                WHERE name = 'C_BPartner'
                LIMIT 1)::INT,
               FALSE
       );

INSERT INTO tmp_c_bpartner (ad_client_id, c_bp_group_id, c_paymentterm_id, m_pricelist_id)
SELECT c.ad_client_id,
       (SELECT c_bp_group.c_bp_group_id
        FROM c_bp_group
        WHERE c_bp_group.ad_client_id = c.ad_client_id
          AND c_bp_group.name = 'No Supplier Selected'),
       (SELECT c_paymentterm_id
        FROM c_paymentterm
        WHERE c_paymentterm.ad_client_id = c.ad_client_id
          AND c_paymentterm.name = 'Immediate'),
       (SELECT COALESCE((SELECT g.m_pricelist_id
                         FROM C_BP_Group g
                         WHERE g.ad_client_id = c.ad_client_id
                           AND g.isdefault = 'Y'
                         LIMIT 1), (SELECT l.m_pricelist_id
                                    FROM m_pricelist l
                                    WHERE l.ad_client_id = c.ad_client_id
                                      AND isdefault = 'Y'
                                      AND issopricelist = 'Y'
                                    LIMIT 1), (SELECT l.m_pricelist_id
                                               FROM m_pricelist l
                                               WHERE l.ad_client_id = c.ad_client_id
                                                 AND isdefault = 'Y'
                                               LIMIT 1), 0))
FROM ad_client c
WHERE (c.ad_client_id > 999999 OR c.ad_client_id = 2)
  AND c.isactive = 'Y';

INSERT INTO c_bpartner (c_bpartner_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
                        invoicerule,
                        paymentrule, c_paymentterm_id, m_pricelist_id, value, name, description,
                        c_bp_group_id, c_bpartner_uu)
SELECT c_bpartner_id,
       ad_client_id,
       ad_org_id,
       isactive,
       created,
       createdby,
       updated,
       updatedby,
       invoicerule,
       paymentrule,
       c_paymentterm_id,
       m_pricelist_id,
       value,
       name,
       description,
       c_bp_group_id,
       c_bpartner_uu
FROM tmp_c_bpartner
ON CONFLICT DO NOTHING;

-- Add user contact
DROP TABLE IF EXISTS tmp_ad_user;
CREATE TEMP TABLE tmp_ad_user
(
    ad_user_id     serial                  NOT NULL,
    ad_client_id   numeric(10)             NOT NULL,
    ad_org_id      numeric(10)             NOT NULL,
    createdby      numeric(10) DEFAULT 100 NOT NULL,
    updatedby      numeric(10) DEFAULT 100 NOT NULL,
    name           varchar(60)             NOT NULL,
    c_bpartner_id  numeric(10),
    isfullbpaccess char        DEFAULT 'N' NOT NULL,
    ad_user_uu     uuid        DEFAULT uuid_generate_v4()
);
-- SET sequence
SELECT SETVAL(
               'tmp_ad_user_ad_user_id_seq',
               (SELECT currentnext
                FROM ad_sequence
                WHERE name = 'AD_User'
                LIMIT 1)::INT,
               FALSE
       );

INSERT INTO tmp_ad_user (ad_client_id, ad_org_id, name, c_bpartner_id)
SELECT ad_client_Id,
       ad_org_id,
       name,
       c_bpartner_id
FROM tmp_c_bpartner;

INSERT INTO ad_user (ad_user_id, ad_client_id, ad_org_id, createdby, updatedby, name, c_bpartner_id, isfullbpaccess,
                     ad_user_uu)
SELECT ad_user_id,
       ad_client_id,
       ad_org_id,
       createdby,
       updatedby,
       name,
       c_bpartner_id,
       isfullbpaccess,
       ad_user_uu
FROM tmp_ad_user;

-- Add location
DROP TABLE IF EXISTS tmp_c_location;
CREATE TEMP TABLE tmp_c_location
(
    c_location_id serial                  NOT NULL,
    ad_client_id  numeric(10)             NOT NULL,
    ad_org_id     numeric(10)             NOT NULL,
    createdby     numeric(10) DEFAULT 100 NOT NULL,
    updatedby     numeric(10) DEFAULT 100 NOT NULL,
    c_country_id  numeric(10)             NOT NULL,
    c_location_uu uuid        DEFAULT uuid_generate_v4()

);
-- SET sequence
SELECT SETVAL(
               'tmp_c_location_c_location_id_seq',
               (SELECT currentnext
                FROM ad_sequence
                WHERE name = 'C_Location'
                LIMIT 1)::INT,
               FALSE
       );

-- Get the country from the last entered location.
INSERT INTO tmp_c_location (ad_client_id, ad_org_id, c_country_id)
SELECT c.ad_client_id,
       c.ad_org_id,
       (SELECT c_country_id
        FROM c_location
        WHERE c_country_id IS NOT NULL
          AND ad_client_id = c.ad_client_id
        ORDER BY created DESC
        LIMIT 1)
FROM tmp_c_bpartner c;

INSERT INTO c_location (c_location_id, ad_client_id, ad_org_id, createdby, updatedby, c_country_id, c_location_uu)
SELECT c_location_id,
       ad_client_id,
       ad_org_id,
       createdby,
       updatedby,
       c_country_id,
       c_location_uu
FROM tmp_c_location;

-- Add user location
DROP TABLE IF EXISTS tmp_c_bpartner_location;
CREATE TEMP TABLE tmp_c_bpartner_location
(
    c_bpartner_location_id serial                                 NOT NULL,
    ad_client_id           numeric(10)                            NOT NULL,
    ad_org_id              numeric(10)                            NOT NULL,
    createdby              numeric(10) DEFAULT 100                NOT NULL,
    updatedby              numeric(10) DEFAULT 100                NOT NULL,
    name                   varchar(60) DEFAULT 'Default Location' NOT NULL,
    c_bpartner_id          numeric(10)                            NOT NULL,
    c_location_id          numeric(10),
    c_bpartner_location_uu uuid        DEFAULT uuid_generate_v4()
);

-- SET sequence
SELECT SETVAL(
               'tmp_c_bpartner_location_c_bpartner_location_id_seq',
               (SELECT currentnext
                FROM ad_sequence
                WHERE name = 'C_BPartner_Location'
                LIMIT 1)::INT,
               FALSE
       );

INSERT INTO tmp_c_bpartner_location (ad_client_id, ad_org_id, c_bpartner_id, c_location_id)
SELECT c.ad_client_id,
       c.ad_org_id,
       b.c_bpartner_id,
       c.c_location_id
FROM tmp_c_location c
         INNER JOIN tmp_c_bpartner b
                    ON c.ad_client_id = b.ad_client_id;

INSERT INTO c_bpartner_location (c_bpartner_location_id, ad_client_id, ad_org_id, createdby, updatedby, name,
                                 c_bpartner_id,
                                 c_location_id, c_bpartner_location_uu)
SELECT c_bpartner_location_id,
       ad_client_id,
       ad_org_id,
       createdby,
       updatedby,
       name,
       c_bpartner_id,
       c_location_id,
       c_bpartner_location_uu
FROM tmp_c_bpartner_location;

-- Add Customer Account
DROP TABLE IF EXISTS tmp_c_bp_customer_acct;
CREATE TEMP TABLE tmp_c_bp_customer_acct
(
    c_bpartner_id              numeric(10)             NOT NULL,
    c_acctschema_id            numeric(10)             NOT NULL,
    ad_client_id               numeric(10)             NOT NULL,
    ad_org_id                  numeric(10)             NOT NULL,
    createdby                  numeric(10) DEFAULT 100 NOT NULL,
    updatedby                  numeric(10) DEFAULT 100 NOT NULL,
    c_receivable_acct          numeric(10),
    c_prepayment_acct          numeric(10),
    c_receivable_services_acct numeric(10),
    c_bp_customer_acct_uu      uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO tmp_c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, c_receivable_acct,
                                    c_prepayment_acct,
                                    c_receivable_services_acct)
SELECT p.c_bpartner_id,
       a.c_acctschema_id,
       c.ad_client_id,
       c.ad_org_id,
       a.c_receivable_acct,
       a.c_prepayment_acct,
       a.c_receivable_services_acct
FROM tmp_c_bp_group c
         INNER JOIN tmp_c_bpartner p
                    ON c.ad_client_id = p.ad_client_id
         INNER JOIN tmp_c_bp_group_acct a
                    ON c.ad_client_id = a.ad_client_id;

INSERT INTO c_bp_customer_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby,
                                c_receivable_acct,
                                c_prepayment_acct, c_receivable_services_acct, c_bp_customer_acct_uu)
SELECT c_bpartner_id,
       c_acctschema_id,
       ad_client_id,
       ad_org_id,
       createdby,
       updatedby,
       c_receivable_acct,
       c_prepayment_acct,
       c_receivable_services_acct,
       c_bp_customer_acct_uu
FROM tmp_c_bp_customer_acct;

-- Add Vendor Account
DROP TABLE IF EXISTS tmp_c_bp_vendor_acct;
CREATE TEMP TABLE tmp_c_bp_vendor_acct
(
    c_bpartner_id             numeric(10)             NOT NULL,
    c_acctschema_id           numeric(10)             NOT NULL,
    ad_client_id              numeric(10)             NOT NULL,
    ad_org_id                 numeric(10)             NOT NULL,
    createdby                 numeric(10) DEFAULT 100 NOT NULL,
    updatedby                 numeric(10) DEFAULT 100 NOT NULL,
    v_liability_acct          numeric(10),
    v_liability_services_acct numeric(10),
    v_prepayment_acct         numeric(10),
    c_bp_vendor_acct_uu       uuid        DEFAULT uuid_generate_v4()
);

INSERT INTO tmp_c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, v_liability_acct,
                                  v_liability_services_acct, v_prepayment_acct)
SELECT p.c_bpartner_id,
       a.c_acctschema_id,
       c.ad_client_id,
       c.ad_org_id,
       a.v_liability_acct,
       a.v_liability_services_acct,
       a.v_prepayment_acct
FROM tmp_c_bp_group c
         INNER JOIN tmp_c_bpartner p
                    ON c.ad_client_id = p.ad_client_id
         INNER JOIN tmp_c_bp_group_acct a
                    ON c.ad_client_id = a.ad_client_id;

INSERT INTO c_bp_vendor_acct (c_bpartner_id, c_acctschema_id, ad_client_id, ad_org_id, createdby, updatedby,
                              v_liability_acct,
                              v_liability_services_acct, v_prepayment_acct, c_bp_vendor_acct_uu)
SELECT c_bpartner_id,
       c_acctschema_id,
       ad_client_id,
       ad_org_id,
       createdby,
       updatedby,
       v_liability_acct,
       v_liability_services_acct,
       v_prepayment_acct,
       c_bp_vendor_acct_uu
FROM tmp_c_bp_vendor_acct;

-- DROP TEMP Tables
DROP TABLE tmp_c_bp_group_acct;
DROP TABLE tmp_c_bp_group;
DROP TABLE tmp_c_bpartner;
DROP TABLE tmp_ad_user;
DROP TABLE tmp_c_location;
DROP TABLE tmp_c_bpartner_location;
DROP TABLE tmp_c_bp_customer_acct;
DROP TABLE tmp_c_bp_vendor_acct;

SELECT update_sequences();

 SELECT
	register_migration_script('202507111146_GO-3309.sql')
FROM
	dual;
