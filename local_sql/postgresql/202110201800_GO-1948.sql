-- CREATE BH_Coded_Diagnosis_Mapping table
create table bh_coded_diagnosis_mapping
(
    ad_client_id            numeric(10) not null,
    ad_org_id               numeric(10) not null,
    created                 timestamp    default statement_timestamp(),
    createdby               numeric(10)  default NULL::numeric,
    updated                 timestamp    default statement_timestamp(),
    updatedby               numeric(10)  default NULL::numeric,
    bh_coded_diagnosis_mapping_id   numeric(10) not null
        constraint bh_coded_diagnosis_mapping_key
            primary key,
    bh_coded_diagnosis_mapping_uu   varchar(36)  default NULL::character varying
        constraint bh_coded_diagnosis_mapping_uu_idx
            unique,
    bh_coded_diagnosis_id   numeric(10) not null,
    bh_source                  varchar(100)  default NULL::character varying,
    bh_external_id             varchar(255)  default NULL::character varying,
    bh_map_type                varchar(50) default NULL::character varying,
    bh_owner                   varchar(100) default NULL::character varying,
    bh_concept_code            varchar(255)  default NULL::character varying,
    bh_concept_name_resolved   varchar(255) default NULL::character varying,
    isactive                char         default 'Y'::bpchar
        constraint bh_coded_diagnosis_mapping_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    constraint bhcodeddiagnosis_mapping_key
		foreign key (bh_coded_diagnosis_id) references bh_coded_diagnosis(bh_coded_diagnosis_id)
			deferrable initially deferred        
);

SELECT register_migration_script('202110201800_GO-1948.sql') FROM dual;
