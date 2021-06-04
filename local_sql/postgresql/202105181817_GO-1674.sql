-- CREATE BH_Coded_Diagnosis table
create table bh_coded_diagnosis
(
    ad_client_id            numeric(10) not null,
    ad_org_id               numeric(10) not null,
    bh_ceilname             varchar(100) default NULL::character varying,
    bh_ciel_id              numeric(10),
    bh_coded_diagnosis_id   numeric(10) not null
        constraint bh_coded_diagnosis_key
            primary key,
    bh_coded_diagnosis_uu   varchar(36)  default NULL::character varying
        constraint bh_coded_diagnosis_uu_idx
            unique,
    bh_concept_class        varchar(50)  default NULL::character varying,
    bh_icd10who             varchar(20)  default NULL::character varying,
    bh_searchterms          varchar(255) default NULL::character varying,
    bh_synomed_ct           numeric(10),
    bh_synomed_np           numeric(10),
    bh_synonyms             varchar(255) default NULL::character varying,
    created                 timestamp    default statement_timestamp(),
    createdby               numeric(10)  default NULL::numeric,
    description             text,
    isactive                char         default 'Y'::bpchar
        constraint bh_coded_diagnosis_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    updated                 timestamp    default statement_timestamp(),
    updatedby               numeric(10)  default NULL::numeric,
    bh_shortnames           varchar(50)  default NULL::character varying,
    bh_moh705a_lessthan5    varchar(100) default NULL::character varying,
    bh_moh705b_greaterthan5 varchar(100) default NULL::character varying
);

-- FINAL CODED DIAGNOSIS IMPORT WILL GO HERE

-- ADD NEW DIAGNOSIS COLUMNS TO C_Order
ALTER TABLE c_order 
  ADD IF NOT EXISTS BH_PrimaryCodedDiagnosis_ID DECIMAL(10,0) DEFAULT NULL,
  ADD IF NOT EXISTS BH_SecondaryCodedDiagnosis_ID DECIMAL(10,0) DEFAULT NULL,
  ADD IF NOT EXISTS BH_PrimaryUnCodedDiagnosis text DEFAULT NULL,
  ADD IF NOT EXISTS BH_SecondaryUnCodedDiagnosis text DEFAULT NULL;

-- populate bh_primaryuncodeddiagnosis
UPDATE c_order SET BH_PrimaryUncodedDiagnosis = (SELECT c.description FROM c_order c WHERE c_order.c_order_id = c.c_order_id AND c.description IS NOT NULL);

-- populate bh_secondaryuncodeddiagnosis
UPDATE c_order SET BH_SecondaryUncodedDiagnosis = (SELECT c.bh_seconddiagnosis FROM c_order c WHERE c_order.c_order_id = c.c_order_id AND c.bh_seconddiagnosis IS NOT NULL);

-- we don't delete `c_order.bh_seconddiagnosis` column until all dependencies and reports are updated accordingly.

-- create coded diagnosis window
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES (SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2021-05-31 10:45:34.739000', 100, '2021-05-31 10:45:34.739000', 100, 'Coded Diagnosis', 'Coded Diagnosis', null, 'T', 'N', 'U', 'N', null, null, 'N', 0, 0, 'N', '1f29f7ab-bc9a-427c-b35b-87589e4612b5', null) ON CONFLICT DO NOTHING;

-- home screen configurations
INSERT INTO adempiere.bh_dbrdbtngrp_btn (bh_dbrdbtngrp_btn_id, ad_client_id, ad_infowindow_id, ad_org_id, ad_window_id, bh_dbrdbtngrp_btn_uu, buttonclassname, buttonhelptext, buttontext, created, createdby, description, iconclassname, isactive, lineno, name, updated, updatedby, bh_dbrdbtngrp_id, ad_process_id, ad_form_id, included_role_id) VALUES (SELECT MAX(bh_dbrdbtngrp_btn_id) + 1 FROM bh_dbrdbtngrp_btn), 0, null, 0, (SELECT ad_window_id FROM ad_window where ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'), '2e00840c-9801-418b-a025-4e2f4f51a6b7', 'button app big', 'Coded Diagnosis', 'Coded Diagnosis', '2021-05-12 11:27:38.084000', 100, '/codeddiagnoses', 'fas fa-users', 'Y', 20, 'Coded Diagnosis', '2021-05-31 11:02:28.233000', 100, 1000000, null, null, null) ON CONFLICT DO NOTHING;

-- update roles

-- give Banda Health Management Admin read/write access
INSERT INTO adempiere.ad_window_accesss (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window where ad_window_uu = '58c4ffdb-955a-4097-8bfe-52fd9fcf74da'), (select ad_role_id FROM ad_role where ad_role_uu = '0520b255-2e55-41b7-b95c-4f6660e77625'), 0, 0, 'Y', '2021-05-31 11:00:19.506000', 100, '2021-05-31 11:00:19.506000', 100, 'Y', '6432f60e-72b8-4b3a-99e5-e5ec1bfffe18', 'Y') ON CONFLICT DO NOTHING;

-- give casher/registration readonly access
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window where ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'), (select ad_role_id FROM ad_role where ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'), 0, 0, 'Y', '2021-05-31 10:46:50.796000', 100, '2021-05-31 10:46:59.793000', 100, 'N', '0bb84633-d507-43f3-95d4-3397a438b786', 'N') ON CONFLICT DO NOTHING;

-- give clinician/nurse readonly access
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT ad_window_id FROM ad_window where ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'), (select ad_role_id FROM ad_role where ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'), 0, 0, 'Y', '2021-05-31 10:47:21.220000', 100, '2021-05-31 10:47:21.220000', 100, 'N', 'd382fcc0-3ff7-4138-b866-e026198865e7', 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202105181817_GO-1674.sql') FROM dual;
