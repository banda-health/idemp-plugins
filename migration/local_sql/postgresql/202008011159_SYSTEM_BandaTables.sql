--table default-included roles
create table if not exists bh_defaultincludedrole
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_defaultincludedrole_id numeric(10) not null,
	bh_defaultincludedrole_uu varchar(36) default NULL::character varying,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	db_usertype char default NULL::bpchar,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) default NULL::character varying,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	included_role_id numeric(10) default NULL::numeric,
	constraint bh_defaultincludedrole_key
		primary key (bh_defaultincludedrole_id),
	constraint bh_defaultincludedrole_uu_idx
		unique (bh_defaultincludedrole_uu),
	constraint bh_defaultincludedrole_unique
		unique (db_usertype, included_role_id),
	constraint adclient_bhdefaultincludedrole
		foreign key (ad_client_id) references adempiere.ad_client
			deferrable initially deferred,
	constraint adorg_bhdefaultincludedrole
		foreign key (ad_org_id) references adempiere.ad_org
			deferrable initially deferred,
	constraint includedrole_bhdefaultincluded
		foreign key (included_role_id) references adempiere.ad_role
			deferrable initially deferred,
	constraint bh_defaultincludedrole_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

--Tab navigation table
create table if not exists bh_tabnavbtn
(
    bh_tabnavbtn_id numeric(10)                                 not null
        constraint bh_tabnavbtn_key
            primary key,
    ad_client_id    numeric(10)                                 not null
        constraint adclient_bhtabnavbtn
            references ad_client
            deferrable initially deferred,
    ad_org_id       numeric(10)                                 not null
        constraint adorg_bhtabnavbtn
            references ad_org
            deferrable initially deferred,
    bh_tabnavbtn_uu varchar(36)   default NULL::character varying
        constraint bh_tabnavbtn_uu_idx
            unique,
    created         timestamp     default statement_timestamp() not null,
    createdby       numeric(10)                                 not null,
    description     varchar(255)  default NULL::character varying,
    isactive        char          default 'Y'::bpchar           not null
        constraint bh_tabnavbtn_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name            varchar(60)                                 not null,
    updated         timestamp     default statement_timestamp() not null,
    updatedby       numeric(10)                                 not null,
    buttontext      varchar(100)  default NULL::character varying,
    buttonhelptext  varchar(100)  default NULL::character varying,
    buttonclassname varchar(100)  default NULL::character varying,
    iconclassname   varchar(100)  default NULL::character varying,
    ad_tab_id       numeric(10)   default NULL::numeric
        constraint adtab_bhtabnavbtn
            references ad_tab
            deferrable initially deferred,
    ad_window_id    numeric(10)   default NULL::numeric
        constraint adwindow_bhtabnavbtn
            references ad_window
            deferrable initially deferred,
    buttonaction    char                                        not null,
    buttonlocation  char          default 'R'::bpchar           not null,
    ad_table_id     numeric(10)   default NULL::numeric
        constraint adtable_bhtabnavbtn
            references ad_table
            deferrable initially deferred,
    ad_column_id    numeric(10)   default NULL::numeric
        constraint adcolumn_bhtabnavbtn
            references ad_column
            deferrable initially deferred,
    displaylogic    varchar(2000) default NULL::character varying
);

alter table bh_tabnavbtn
    owner to adempiere;

create index if not exists bh_tabnavbtn_tabid_index
    on bh_tabnavbtn (ad_tab_id, isactive);

--tab navigation translations table
create table if not exists bh_tabnavbtn_trl
(
    ad_client_id        numeric(10)                             not null,
    ad_language         varchar(6)                              not null
        constraint adlanguage_bhtabnavbtntrl
            references ad_language,
    ad_org_id           numeric(10)                             not null,
    bh_tabnavbtn_id     numeric(10)                             not null
        constraint bhtabnavbtn_bhtabnavbtntrl
            references bh_tabnavbtn,
    bh_tabnavbtn_trl_uu varchar(36)
        constraint bh_tabnavbtn_trl_uu_idx
            unique,
    buttonhelptext      varchar(100),
    buttontext          varchar(100),
    created             timestamp default statement_timestamp() not null,
    createdby           numeric(10)                             not null,
    description         varchar(255),
    help                varchar(2000),
    isactive            char      default 'Y'::bpchar           not null
        constraint bh_tabnavbtn_trl_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    istranslated        char                                    not null
        constraint bh_tabnavbtn_trl_istranslated_check
            check (istranslated = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name                varchar(60)                             not null,
    updated             timestamp default statement_timestamp() not null,
    updatedby           numeric(10)                             not null,
    constraint pk_bh_tabnavbtn_trl
        primary key (bh_tabnavbtn_id, ad_language)
);

alter table bh_tabnavbtn_trl
    owner to adempiere;

--tab navigation tabs table
create table if not exists bh_tabnavbtn_tab
(
    bh_tabnavbtn_tab_id numeric(10)                                 not null
        constraint bh_tabnavbtn_tab_key
            primary key,
    ad_client_id        numeric(10)                                 not null
        constraint adclient_bhtabnavbtntab
            references ad_client
            deferrable initially deferred,
    ad_org_id           numeric(10)                                 not null
        constraint adorg_bhtabnavbtntab
            references ad_org
            deferrable initially deferred,
    bh_tabnavbtn_tab_uu varchar(36)   default NULL::character varying
        constraint bh_tabnavbtn_tab_uu_idx
            unique,
    created             timestamp     default statement_timestamp() not null,
    createdby           numeric(10)                                 not null,
    description         varchar(255)  default NULL::character varying,
    isactive            char          default 'Y'::bpchar           not null
        constraint bh_tabnavbtn_tab_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name                varchar(60)                                 not null,
    updated             timestamp     default statement_timestamp() not null,
    updatedby           numeric(10)                                 not null,
    ad_tab_id           numeric(10)                                 not null
        constraint adtab_bhtabnavbtntab
            references ad_tab
            deferrable initially deferred,
    bh_tabnavbtn_id     numeric(10)                                 not null
        constraint bhtabnavbtn_bhtabnavbtntab
            references bh_tabnavbtn
            deferrable initially deferred,
    buttonclassname     varchar(100)  default NULL::character varying,
    buttonhelptext      varchar(100)  default NULL::character varying,
    buttontext          varchar(100)  default NULL::character varying,
    iconclassname       varchar(100)  default NULL::character varying,
    buttonlocation      char          default NULL::bpchar,
    displaylogic        varchar(2000) default NULL::character varying
);

alter table bh_tabnavbtn_tab
    owner to adempiere;

--tab navigation tabs translations table
create table if not exists bh_tabnavbtn_tab_trl
(
    ad_client_id            numeric(10)                             not null,
    ad_language             varchar(6)                              not null
        constraint adlanguage_bhtabnavbtntabtrl
            references ad_language,
    ad_org_id               numeric(10)                             not null,
    bh_tabnavbtn_tab_id     numeric(10)                             not null
        constraint bhtabnavbtntab_bhtabnavbtntabt
            references bh_tabnavbtn_tab,
    bh_tabnavbtn_tab_trl_uu varchar(36)
        constraint bh_tabnavbtn_tab_trl_uu_idx
            unique,
    buttonhelptext          varchar(100),
    buttontext              varchar(100),
    created                 timestamp default statement_timestamp() not null,
    createdby               numeric(10)                             not null,
    description             varchar(255),
    help                    varchar(2000),
    isactive                char      default 'Y'::bpchar           not null
        constraint bh_tabnavbtn_tab_trl_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    istranslated            char                                    not null
        constraint bh_tabnavbtn_tab_trl_istranslated_check
            check (istranslated = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name                    varchar(60)                             not null,
    updated                 timestamp default statement_timestamp() not null,
    updatedby               numeric(10)                             not null,
    constraint pk_bh_tabnavbtn_tab_trl
        primary key (bh_tabnavbtn_tab_id, ad_language)
);

alter table bh_tabnavbtn_tab_trl
    owner to adempiere;


--dashboard button groups table
create table if not exists bh_dbrdbtngrp
(
    bh_dbrdbtngrp_id numeric(10)                                not null
        constraint bh_hmscrn_buttongroup_key
            primary key,
    ad_client_id     numeric(10)                                not null
        constraint adclient_bhhmscrnbuttongroup
            references ad_client
            deferrable initially deferred,
    ad_org_id        numeric(10)                                not null
        constraint adorg_bhhmscrnbuttongroup
            references ad_org
            deferrable initially deferred,
    bh_dbrdbtngrp_uu varchar(36)  default NULL::character varying
        constraint bh_hmscrn_buttongroup_uu_idx
            unique,
    created          timestamp    default statement_timestamp() not null,
    createdby        numeric(10)                                not null,
    description      varchar(255) default NULL::character varying,
    isactive         char         default 'Y'::bpchar           not null
        constraint bh_hmscrn_buttongroup_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name             varchar(60)                                not null,
    updated          timestamp    default statement_timestamp() not null,
    updatedby        numeric(10)                                not null,
    lineno           numeric(10)  default NULL::numeric
);

alter table bh_dbrdbtngrp
    owner to adempiere;

--dashboard button group translations table
create table if not exists bh_dbrdbtngrp_trl
(
    ad_client_id         numeric(10)                             not null,
    ad_language          varchar(6)                              not null
        constraint adlanguage_bhdbrdbtngrptrl
            references ad_language,
    ad_org_id            numeric(10)                             not null,
    bh_dbrdbtngrp_id     numeric(10)                             not null
        constraint bhdbrdbtngrp_bhdbrdbtngrptrl
            references bh_dbrdbtngrp,
    bh_dbrdbtngrp_trl_uu varchar(36)
        constraint bh_dbrdbtngrp_trl_uu_idx
            unique,
    created              timestamp default statement_timestamp() not null,
    createdby            numeric(10)                             not null,
    description          varchar(255),
    help                 varchar(2000),
    isactive             char      default 'Y'::bpchar           not null
        constraint bh_dbrdbtngrp_trl_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    istranslated         char                                    not null
        constraint bh_dbrdbtngrp_trl_istranslated_check
            check (istranslated = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name                 varchar(60)                             not null,
    updated              timestamp default statement_timestamp() not null,
    updatedby            numeric(10)                             not null,
    bh_dbrdbtngrp_trl_id numeric(10),
    constraint pk_bh_dbrdbtngrp_trl
        primary key (bh_dbrdbtngrp_id, ad_language)
);

alter table bh_dbrdbtngrp_trl
    owner to adempiere;

--dashboard group buttons table
create table if not exists bh_dbrdbtngrp_btn
(
    bh_dbrdbtngrp_btn_id numeric(10)                                not null
        constraint bh_hmscrn_buttongroupline_key
            primary key,
    ad_client_id         numeric(10)                                not null
        constraint adclient_bhhmscrnbuttongroupli
            references ad_client
            deferrable initially deferred,
    ad_infowindow_id     numeric(10)  default NULL::numeric
        constraint adinfowindow_bhhmscrnbuttongro
            references ad_infowindow
            deferrable initially deferred,
    ad_org_id            numeric(10)                                not null
        constraint adorg_bhhmscrnbuttongroupline
            references ad_org
            deferrable initially deferred,
    ad_window_id         numeric(10)  default NULL::numeric
        constraint adwindow_bhhmscrnbuttongroupli
            references ad_window
            deferrable initially deferred,
    bh_dbrdbtngrp_btn_uu varchar(36)  default NULL::character varying
        constraint bh_hmscrn_buttongrouplineuuidx
            unique,
    buttonclassname      varchar(100) default NULL::character varying,
    buttonhelptext       varchar(100) default NULL::character varying,
    buttontext           varchar(100) default NULL::character varying,
    created              timestamp    default statement_timestamp() not null,
    createdby            numeric(10)                                not null,
    description          varchar(255) default NULL::character varying,
    iconclassname        varchar(100) default NULL::character varying,
    isactive             char         default 'Y'::bpchar           not null
        constraint bh_hmscrn_buttongroupline_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    lineno               numeric(10)  default NULL::numeric,
    name                 varchar(60)                                not null,
    updated              timestamp    default statement_timestamp() not null,
    updatedby            numeric(10)                                not null,
    bh_dbrdbtngrp_id     numeric(10)                                not null
        constraint bhhmscrnbuttongroup_bhhmscrnbu
            references bh_dbrdbtngrp
            deferrable initially deferred,
    ad_process_id        numeric(10)  default NULL::numeric
        constraint adprocess_bhhmscrnbuttongroupl
            references ad_process
            deferrable initially deferred,
    ad_form_id           numeric(10)
        constraint adform_bhhmscrnbuttongroupline
            references ad_form
            deferrable initially deferred,
    included_role_id     numeric(10)  default NULL::numeric
        constraint includedrole_bhhmscrnbuttongro
            references ad_role
            deferrable initially deferred
);

alter table bh_dbrdbtngrp_btn
    owner to adempiere;

--dashboard group buttons translations table
create table if not exists bh_dbrdbtngrp_btn_trl
(
    ad_client_id             numeric(10)                             not null,
    ad_language              varchar(6)                              not null
        constraint adlanguage_bhdbrdbtngrpbtntrl
            references ad_language,
    ad_org_id                numeric(10)                             not null,
    bh_dbrdbtngrp_btn_trl_uu varchar(36)
        constraint bh_dbrdbtngrp_btn_trl_uu_idx
            unique,
    created                  timestamp default statement_timestamp() not null,
    createdby                numeric(10)                             not null,
    description              varchar(255),
    help                     varchar(2000),
    isactive                 char      default 'Y'::bpchar           not null
        constraint bh_dbrdbtngrp_btn_trl_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    istranslated             char                                    not null
        constraint bh_dbrdbtngrp_btn_trl_istranslated_check
            check (istranslated = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name                     varchar(60)                             not null,
    updated                  timestamp default statement_timestamp() not null,
    updatedby                numeric(10)                             not null,
    bh_dbrdbtngrp_btn_id     numeric(10)                             not null
        constraint bhdbrdbtngr_bhdbrdbtngrpbtntrl
            references bh_dbrdbtngrp_btn,
    buttonhelptext           varchar(100),
    buttontext               varchar(100),
    bh_dbrdbtngrp_btn_trl_id numeric(10),
    constraint pk_bh_dbrdbtngrp_btn_trl
        primary key (bh_dbrdbtngrp_btn_id, ad_language)
);

alter table bh_dbrdbtngrp_btn_trl
    owner to adempiere;


-- update C_Payment table with banda-specific columns

alter table c_payment
    drop constraint if exists c_payment_bh_nhif_valid_check,
    drop constraint if exists c_payment_bh_processing_check,
    drop constraint if exists c_payment_bh_isservicedebt_check;

alter table c_payment
    add column if not exists bh_c_order_id        numeric(10),
    add column if not exists bh_mpesaphntrx_num   varchar(36)  default NULL::character varying,
    add column if not exists bh_navbuttons        varchar(36)  default NULL::character varying,
    add column if not exists bh_nhif_valid        char         default NULL::bpchar
        constraint c_payment_bh_nhif_valid_check
            check (bh_nhif_valid = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    add column if not exists bh_nhif_claim_number varchar(100) default NULL::character varying,
    add column if not exists nhif_number          varchar(10)  default NULL::character varying,
    add column if not exists bh_nhif_member_id    varchar(10)  default NULL::character varying,
    add column if not exists bh_nhif_member_name  varchar(100) default NULL::character varying,
    add column if not exists bh_nhif_relationship varchar(100) default 'P'::character varying,
    add column if not exists bh_nhif_linda_mama   varchar(100) default NULL::character varying,
    add column if not exists bh_processing        char         default 'N'::bpchar
        constraint c_payment_bh_processing_check
            check (bh_processing = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    add column if not exists bh_nhif_type         varchar(100) default NULL::character varying,
    add column if not exists bh_tender_amount     numeric,
    add column if not exists bh_isservicedebt     char         default NULL::bpchar
        constraint c_payment_bh_isservicedebt_check
            check (bh_isservicedebt = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));


alter table c_payment
    owner to adempiere;

create index if not exists c_payment_bankaccount
    on c_payment (c_bankaccount_id);

create index if not exists c_payment_bh_corder_id_index
    on c_payment (bh_c_order_id);

create index if not exists c_payment_bpartner
    on c_payment (c_bpartner_id);

create index if not exists c_payment_cinvoiceid_index
    on c_payment (c_invoice_id);

create index if not exists c_payment_docstatus_index
    on c_payment (docstatus);

create unique index if not exists c_payment_uu_idx
    on c_payment (c_payment_uu);

create index if not exists idxc_payment_proc_on
    on c_payment (posted, processed, processedon, ad_client_id);

-- Create table bh-stocktake
create table if not exists bh_stocktake
(
    ad_client_id              numeric(10)                                 not null,
    ad_org_id                 numeric(10)                                 not null
        constraint adorg_bhstocktake
            references ad_org
            deferrable initially deferred,
    bh_docaction              char(2)     default NULL::bpchar,
    created                   timestamp   default statement_timestamp()   not null,
    createdby                 numeric(10)                                 not null,
    docaction                 char(2)     default 'CO'::bpchar            not null,
    docstatus                 varchar(2)  default 'DR'::character varying not null,
    processed                 char                                        not null
        constraint bh_stocktake_processed_check
            check (processed = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    processedon               numeric,
    processing                char        default NULL::bpchar,
    updated                   timestamp   default statement_timestamp()   not null,
    updatedby                 numeric(10)                                 not null,
    m_attributesetinstance_id numeric(10) default NULL::numeric
        constraint mattributesetinstance_bhstockt
            references m_attributesetinstance
            deferrable initially deferred
);

alter table bh_stocktake
    owner to adempiere;                                                          

alter table ad_ref_list
add column if not exists bh_update_existing char        default NULL::bpchar,
add column  if not exists bh_add_all        char        default NULL::bpchar;


-- Table bh_uibutton
create table if not exists bh_uibutton
(
    ad_client_id    numeric(10)                                  not null
        constraint adclient_bhuibutton
            references ad_client,
    ad_org_id       numeric(10)                                  not null
        constraint adorg_bhuibutton
            references ad_org,
    bh_uibutton_id  numeric(10)                                  not null
        constraint bh_uibutton_key
            primary key,
    bh_uibutton_uu  varchar(36)
        constraint bh_uibutton_uu_idx
            unique,
    created         timestamp    default statement_timestamp()   not null,
    createdby       numeric(10)                                  not null,
    description     varchar(255),
    isactive        char         default 'Y'::bpchar             not null
        constraint bh_uibutton_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name            varchar(60)                                  not null,
    updated         timestamp    default statement_timestamp()   not null,
    updatedby       numeric(10)                                  not null,
    cssvariablename varchar(100) default NULL::character varying not null
);

alter table bh_uibutton
    owner to adempiere;

--table bh_uibutton_trl
create table if not exists bh_uibutton_trl
(
    ad_client_id       numeric(10)                             not null,
    ad_language        varchar(6)                              not null
        constraint adlanguage_bhuibuttontrl
            references ad_language,
    ad_org_id          numeric(10)                             not null,
    bh_uibutton_id     numeric(10)                             not null
        constraint bhuibutton_bhuibuttontrl
            references bh_uibutton,
    bh_uibutton_trl_uu varchar(36)
        constraint bh_uibutton_trl_uu_idx
            unique,
    created            timestamp default statement_timestamp() not null,
    createdby          numeric(10)                             not null,
    description        varchar(255),
    help               varchar(2000),
    isactive           char      default 'Y'::bpchar           not null
        constraint bh_uibutton_trl_isactive_check
            check (isactive = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    istranslated       char                                    not null
        constraint bh_uibutton_trl_istranslated_check
            check (istranslated = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar])),
    name               varchar(60)                             not null,
    updated            timestamp default statement_timestamp() not null,
    updatedby          numeric(10)                             not null,
    constraint pk_bh_uibutton_trl
        primary key (bh_uibutton_id, ad_language)
);

alter table bh_uibutton_trl
    owner to adempiere;

alter table ad_user
	add IF NOT EXISTS bh_tos_date_accepted timestamp,
	add IF NOT EXISTS eve_bpartners varchar(36) default NULL::character varying,
	add IF NOT EXISTS bandahealth_bpartners varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_hasacceptedtermsofuse char default 'N'::bpchar not null;

ALTER TABLE c_bpartner
    ADD IF NOT EXISTS bh_local_patientid character varying(100),
    ADD IF NOT EXISTS bh_patientid character varying(100),
    ADD IF NOT EXISTS bh_ispatient char default NULL::bpchar,
    add IF NOT EXISTS bh_c_location_id numeric(10) default NULL::numeric,
    add IF NOT EXISTS bh_birthday timestamp,
    add IF NOT EXISTS bh_approximateyears numeric,
    add IF NOT EXISTS bh_email varchar(60) default NULL::character varying,
    add IF NOT EXISTS bh_phone varchar(40) default NULL::character varying,
    add IF NOT EXISTS nationalid varchar(10),
    add IF NOT EXISTS nhif_number varchar(10),
    add IF NOT EXISTS nextofkin_name varchar(100) default NULL::character varying,
    add IF NOT EXISTS nextofkin_contact varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_occupation varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_gender varchar(10) default NULL::character varying,
    add IF NOT EXISTS bh_patient_notes varchar(2000) default NULL::character varying,
    add IF NOT EXISTS bh_nextappointmentdate timestamp,
    add IF NOT EXISTS bh_nhif_member_name varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_nhif_relationship varchar(100) default 'P'::character varying,
    add IF NOT EXISTS isnewpatient char default 'Y'::bpchar,
    add IF NOT EXISTS bh_nhif_type varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_lastpatientid varchar(100) default NULL::character varying;

ALTER TABLE m_product
    ADD IF NOT EXISTS bh_reorder_level numeric(10),
	add IF NOT EXISTS bh_reorder_quantity numeric(10) default NULL::numeric,
	add IF NOT EXISTS eve_bpartners varchar(36) default NULL::character varying,
	add IF NOT EXISTS bandahealth_bpartners varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_hasacceptedtermsofuse char default 'N'::bpchar not null,
	add IF NOT EXISTS bh_hasexpiration char default 'Y'::bpchar not null,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_buyprice numeric,
	add IF NOT EXISTS bh_sellprice numeric,
	add IF NOT EXISTS bh_pricemargin numeric,
	add IF NOT EXISTS bh_product_category_type char default NULL::bpchar;

ALTER TABLE m_product_category
	add IF NOT EXISTS bh_product_category_type char default NULL::bpchar;

alter table m_productprice
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying;

alter table m_inventory
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying;

alter table m_inventoryline
	add IF NOT EXISTS bh_expiration timestamp,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying;

alter table c_order
    add IF NOT EXISTS bh_payments varchar(36),
    add IF NOT EXISTS bh_docaction char(2) default NULL::bpchar,
    add IF NOT EXISTS bh_navbuttons varchar(36),
    add IF NOT EXISTS bh_printaction char(100),
    add IF NOT EXISTS bh_isexpense char default NULL::bpchar,
    add IF NOT EXISTS bh_printnhifreportaction char(100) default NULL::bpchar,
    add IF NOT EXISTS bh_printnhifffsreportaction char(100) default NULL::bpchar,
    add IF NOT EXISTS bh_referral varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_newvisit char default 'N'::bpchar,
    add IF NOT EXISTS bh_patienttype char default 'O'::bpchar,
    add IF NOT EXISTS bh_lab_notes text,
    add IF NOT EXISTS bh_bloodpressure varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_chiefcomplaint varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_height varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_pulse varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_respiratoryrate varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_temperature varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_weight varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_seconddiagnosis text,
    add IF NOT EXISTS bh_clinician_user_id numeric(10) default NULL::numeric,
    add IF NOT EXISTS bh_visitdate timestamp,
    add IF NOT EXISTS bh_process_stage varchar(100) default NULL::character varying,
    add IF NOT EXISTS bh_referredfromto varchar(100) default NULL::character varying;

alter table c_orderline
    add IF NOT EXISTS bh_expiration timestamp,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying,
	add IF NOT EXISTS qtyavailable numeric,
	add IF NOT EXISTS bh_instructions varchar(255) default NULL::character varying;

alter table c_invoice
	add IF NOT EXISTS bh_docaction char(2) default NULL::bpchar,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_isexpense char default 'N'::bpchar,
	add IF NOT EXISTS bh_processing char default 'N'::bpchar,
	add IF NOT EXISTS bh_docaction_2 char(2) default NULL::bpchar,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying;

alter table c_payment
	add IF NOT EXISTS bh_c_order_id numeric(10),
	add IF NOT EXISTS bh_mpesaphntrx_num varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_navbuttons varchar(36) default NULL::character varying,
	add IF NOT EXISTS bh_nhif_valid char default NULL::bpchar,
	add IF NOT EXISTS bh_nhif_claim_number varchar(100) default NULL::character varying,
	add IF NOT EXISTS nhif_number varchar(10) default NULL::character varying,
	add IF NOT EXISTS bh_nhif_member_id varchar(10) default NULL::character varying,
	add IF NOT EXISTS bh_nhif_member_name varchar(100) default NULL::character varying,
	add IF NOT EXISTS bh_nhif_relationship varchar(100) default 'P'::character varying,
	add IF NOT EXISTS bh_nhif_linda_mama varchar(100) default NULL::character varying,
	add IF NOT EXISTS bh_processing char default 'N'::bpchar,
	add IF NOT EXISTS bh_nhif_type varchar(100) default NULL::character varying,
	add IF NOT EXISTS bh_tender_amount numeric,
	add IF NOT EXISTS bh_isservicedebt char default NULL::bpchar;

alter table ad_orginfo
    add if not exists bh_extrainfo  varchar(1000) default NULL::character varying;

CREATE OR REPLACE VIEW bh_c_order_v AS
WITH payments AS (
         SELECT COALESCE(sum(p_1.payamt), 0::numeric) AS paytotal,
            p_1.bh_c_order_id AS c_order_id
           FROM c_payment p_1
          GROUP BY p_1.bh_c_order_id
        )
 SELECT c.c_order_id,
    c.c_bpartner_id,
    COALESCE(c.grandtotal, 0::numeric) AS grandtotal,
    COALESCE(p.paytotal, 0::numeric) AS paytotal,
    COALESCE(c.grandtotal, 0::numeric) - COALESCE(p.paytotal, 0::numeric) AS amtleft
   FROM c_order c
     LEFT JOIN payments p ON c.c_order_id = p.c_order_id;

SELECT register_migration_script('202008011159_SYSTEM_BandaTables.sql') FROM dual;
