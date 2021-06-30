-- CREATE BH_Voided_Reason table
create table bh_voided_reason
(
    ad_client_id            numeric(10) not null,
    ad_org_id               numeric(10) not null,
    created                 timestamp    default statement_timestamp(),
    createdby               numeric(10)  default NULL::numeric,
    name		     varchar(200) not null,
    description             text,
    isactive                char         default 'Y'::bpchar
        constraint bh_voided_reason_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    updated                 timestamp    default statement_timestamp(),
    updatedby               numeric(10)  default NULL::numeric,
    bh_window_id	     numeric(10) default null,
    bh_voided_reason_id   numeric(10) not null
        constraint bh_voided_reason_key
            primary key,
    bh_voided_reason_uu   varchar(36)  default NULL::character varying
        constraint bh_voided_reason_uu_idx
            unique,
    lineno           numeric(10)  default NULL::numeric,
);

-- ADD bh_voided_reason TO C_Order
ALTER TABLE c_order 
  ADD IF NOT EXISTS bh_voided_reason_id numeric(10) DEFAULT NULL;

-- insert bh_voided_reason table
INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong payment type or amount paid entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Patient Bill' AND isActive = 'Y'), 1, '2de54da3-25f8-4f51-abe8-bccbd8171bcf', 10);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Prescribed drug is sold out', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Patient Bill' AND isActive = 'Y'), 2, 'e49a626f-7f64-4ec3-82d8-824a39e491d5', 20);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Patient could not pay for the bill', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Patient Bill' AND isActive = 'Y'), 3, '04ae1937-a98b-4813-9fc2-2e8f944aaeb3', 30);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Duplicated transaction', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Patient Bill' AND isActive = 'Y'), 4, 'ee791d50-450a-406c-b70a-18342bab95e9', 40);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Add or Edit clinical information', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Patient Bill' AND isActive = 'Y'), 5, 'd1796d94-083e-4dd5-9bb9-c79a434067a3', 50);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong supplier entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Receive Products' AND isActive = 'Y'), 6, '84a44c0e-0e6c-4b15-a69e-bedd4a539248', 60);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong date entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Receive Products' AND isActive = 'Y'), 7, '745a4b6e-3ff1-433d-b31b-10052b67dccd', 70);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong product/drug entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Receive Products' AND isActive = 'Y'), 8, '83bbcca2-9769-4421-b071-15fe1015a8c9', 80);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong expiration date entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Receive Products' AND isActive = 'Y'), 9, 'd3adb9d8-4811-419d-b1f5-a2ece7ab10b0', 90);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong supplier entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Track Expenses' AND isActive = 'Y'), 10, '243c1b1e-da7c-48fc-902e-bc631d67561e', 100);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong date entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Track Expenses' AND isActive = 'Y'), 11, 'fa6e4e5a-23a9-4767-9aae-dda3a4bc1b30', 110);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong payment method entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Track Expenses' AND isActive = 'Y'), 12, '05629ac4-e7fc-4438-b0a4-f8f5e38756b5', 120);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong expense category entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Track Expenses' AND isActive = 'Y'), 13, '3bfd9e13-53d6-47ea-b955-d7820c41fb17', 130);

INSERT INTO adempiere.bh_voided_reason (ad_client_id, ad_org_id, created, createdby, name, description, isactive, updated, updatedby, bh_window_id, bh_voided_reason_id, bh_voided_reason_uu, lineno) VALUES (0, 0, 0, '2021-06-30 14:35:25.982661', 100, 'Wrong Amount entered', null, 'Y', '2021-06-30 14:35:25.982661', 100, (SELECT ad_window_id FROM ad_window WHERE name = 'Track Expenses' AND isActive = 'Y'), 14, '07d34285-e72c-4a1e-ac00-c3f2cc1a3f92', 140);


SELECT register_migration_script('202106301435_GO-1739.sql') FROM dual;
