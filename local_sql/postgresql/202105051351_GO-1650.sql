-- Create the new tables
create table if not exists bh_chargetypedefault
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_chargetypedefault_id numeric(10) not null,
	bh_chargetypedefault_uu varchar(36) default NULL::character varying,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_chargetypedefault_key
		primary key (bh_chargetypedefault_id),
	constraint bh_chargetypedefault_uu_idx
		unique (bh_chargetypedefault_uu),
	constraint adclient_bhchargetypedefault
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhchargetypedefault
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bh_chargetypedefault_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Add a new column to the default charge table to link to this
ALTER TABLE BH_ChargeDefault
	ADD IF NOT EXISTS BH_ChargeTypeDefault_ID NUMBER(10) DEFAULT NULL;
ALTER TABLE BH_ChargeDefault DROP CONSTRAINT IF EXISTS BHChargeTypeDefault_BHChargeDe;
ALTER TABLE BH_ChargeDefault
	ADD CONSTRAINT BHChargeTypeDefault_BHChargeDe FOREIGN KEY (BH_ChargeTypeDefault_ID) REFERENCES bh_chargetypedefault(bh_chargetypedefault_id)
	DEFERRABLE INITIALLY DEFERRED;

-- Add the sequence for this record
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 14:00:44.089000', 100, '2021-05-05 14:00:44.089000', 100, 'BH_ChargeTypeDefault', 'Table BH_ChargeTypeDefault', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '70a2d434-dcc3-424d-b158-277ad967e82a', 'N', 'N', null) ON CONFLICT DO NOTHING;

-- Add the new default charge types
INSERT INTO bh_chargetypedefault (ad_client_id, ad_org_id, bh_chargetypedefault_id, bh_chargetypedefault_uu, created, createdby, description, isactive, name, updated, updatedby) VALUES (0, 0, 1000000, 'e1c256c5-8352-4167-9b68-68fbf992700b', '2021-05-05 14:20:14.052000', 100, 'For an expense category added by default', 'Y', 'Default Expense Category - DO NOT CHANGE', '2021-05-05 14:20:14.052000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_chargetypedefault (ad_client_id, ad_org_id, bh_chargetypedefault_id, bh_chargetypedefault_uu, created, createdby, description, isactive, name, updated, updatedby) VALUES (0, 0, (SELECT MAX(bh_chargetypedefault_id) + 1 FROM bh_chargetypedefault), '478f9619-0aba-49a1-ae75-a4dbac1ac8aa', '2021-05-05 14:28:06.446000', 100, 'Meant to differentiate "payments" that come from a patient (i.e. Insurance, Donations, etc.)', 'Y', 'Non-Patient Payment - DO NOT CHANGE', '2021-05-05 14:28:06.446000', 100) ON CONFLICT DO NOTHING;

-- Update all current default charges to have the default expense category default charge type
UPDATE bh_chargedefault SET bh_chargetypedefault_id = (SELECT bh_chargetypedefault_id FROM bh_chargetypedefault WHERE bh_chargetypedefault_uu = 'e1c256c5-8352-4167-9b68-68fbf992700b');

-- Add new columns to the charge table
ALTER TABLE C_Charge ADD IF NOT EXISTS BH_SubType VARCHAR(2) DEFAULT NULL;
ALTER TABLE C_Charge ADD IF NOT EXISTS BH_NeedAdditionalVisitInfo CHAR(1) DEFAULT 'N'
	CHECK (BH_NeedAdditionalVisitInfo IN ('Y','N')) NOT NULL;

-- Add the non-patient payment reference list
INSERT INTO ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id) VALUES ((SELECT MAX(ad_reference_id) + 1 FROM ad_reference), 0, 0, 'Y', '2021-05-05 15:11:46.386000', 100, '2021-05-05 15:11:46.386000', 100, 'Non-Patient Payment Category', 'A category to help differentiate non-patient payment charges', null, 'L', null, 'U', 'N', 'b313a870-0826-4c1d-a9af-f9ec990b4375', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:11:58.103000', 100, '2021-05-05 15:11:58.103000', 100, 'I', 'Insurance', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', 'd8547f6d-5ad0-4025-b8f8-0f4796cf9d0f', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:12:04.235000', 100, '2021-05-05 15:12:04.235000', 100, 'W', 'Waiver', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', '406d22a4-b3ee-48e4-9bba-7031f653aa06', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:12:10.450000', 100, '2021-05-05 15:12:10.450000', 100, 'D', 'Donation', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', '4782b135-a84e-4eb9-ae3d-88c872a030ce', null, null) ON CONFLICT DO NOTHING;

-- Add the charge info data type reference list
INSERT INTO ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id) VALUES ((SELECT MAX(ad_reference_id) + 1 FROM ad_reference), 0, 0, 'Y', '2021-05-05 15:33:16.543000', 100, '2021-05-05 15:33:16.543000', 100, 'Charge Info Data Type', null, null, 'L', null, 'U', 'N', '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:33:46.220000', 100, '2021-05-05 15:33:46.220000', 100, 'T', 'Text', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'), null, null, 'U', '30c39cd3-e132-4b80-811e-74c5e06f8fae', null, null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:33:50.594000', 100, '2021-05-05 15:33:50.594000', 100, 'L', 'List', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'), null, null, 'U', '5be1018a-8aa1-4f9a-8ec9-a022fa3675b9', null, null) ON CONFLICT DO NOTHING;

-- Add tables that hold all the new info
create table if not exists bh_charge_info
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_id numeric(10) not null,
	bh_charge_info_uu varchar(36) default NULL::character varying,
	bh_chargeinfodatatype varchar(2) default 'T'::character varying not null,
	bh_fillfrompatient char default 'N'::bpchar not null,
	c_charge_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_charge_info_key
		primary key (bh_charge_info_id),
	constraint bh_charge_info_uu_idx
		unique (bh_charge_info_uu),
	constraint adclient_bhchargeinfo
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhchargeinfo
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint ccharge_bhchargeinfo
		foreign key (c_charge_id) references c_charge
			deferrable initially deferred,
	constraint bh_charge_info_bh_fillfrompatient_check
		check (bh_fillfrompatient = ANY (ARRAY['Y'::bpchar, 'N'::bpchar])),
	constraint bh_charge_info_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

create table if not exists bh_charge_info_values
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_id numeric(10) not null,
	bh_charge_info_values_id numeric(10) not null,
	bh_charge_info_values_uu varchar(36) default NULL::character varying,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) default NULL::numeric,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_charge_info_values_key
		primary key (bh_charge_info_values_id),
	constraint bh_charge_info_values_uu_idx
		unique (bh_charge_info_values_uu),
	constraint adclient_bhchargeinfovalues
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhchargeinfovalues
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bhchargeinfo_bhchargeinfovalue
		foreign key (bh_charge_info_id) references bh_charge_info
			deferrable initially deferred,
	constraint bh_charge_info_values_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

create table if not exists bh_charge_info_suggestion
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_suggestion_id numeric(10) not null,
	bh_charge_info_suggestion_uu varchar(36) default NULL::character varying,
	bh_chargeinfodatatype varchar(2) default 'T'::character varying not null,
	bh_fillfrompatient char default 'N'::bpchar not null,
	bh_subtype varchar(2) default 'I'::character varying not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_charge_info_suggestion_key
		primary key (bh_charge_info_suggestion_id),
	constraint bh_charge_info_suggestion_uu_idx
		unique (bh_charge_info_suggestion_uu),
	constraint adclient_bhchargeinfodefault
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhchargeinfodefault
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bh_charge_info_suggestion_bh_fillfrompatient_check
		check (bh_fillfrompatient = ANY (ARRAY['Y'::bpchar, 'N'::bpchar])),
	constraint bh_charge_info_suggestion_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

create table if not exists bh_charge_info_values_suggestion
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_suggestion_id numeric(10) not null,
	bh_charge_info_values_suggestion_id numeric(10) not null,
	bh_charge_info_values_suggestion_uu varchar(36) default NULL::character varying,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_charge_info_values_defa_key
		primary key (bh_charge_info_values_suggestion_id),
	constraint adclient_bhchargeinfovaluesdef
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhchargeinfovaluesdefaul
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bhchargeinfodefault_bhchargein
		foreign key (bh_charge_info_suggestion_id) references bh_charge_info_suggestion
			deferrable initially deferred,
	constraint bh_charge_info_values_suggestion_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

create table if not exists bh_orderline_info
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_id numeric(10) not null,
	bh_orderline_info_id numeric(10) not null,
	bh_orderline_info_uu varchar(36) default NULL::character varying,
	c_orderline_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_orderline_info_key
		primary key (bh_orderline_info_id),
	constraint bh_orderline_info_uu_idx
		unique (bh_orderline_info_uu),
	constraint adclient_bhorderlineinfo
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhorderlineinfo
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bhchargeinfo_bhorderlineinfo
		foreign key (bh_charge_info_id) references bh_charge_info
			deferrable initially deferred,
	constraint corderline_bhorderlineinfo
		foreign key (c_orderline_id) references c_orderline
			deferrable initially deferred,
	constraint bh_orderline_info_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

create table if not exists bh_bpartner_charge
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_bpartner_charge_id numeric(10) not null,
	bh_bpartner_charge_uu varchar(36) default NULL::character varying,
	c_bpartner_id numeric(10) not null,
	c_charge_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_bpartner_charge_key
		primary key (bh_bpartner_charge_id),
	constraint bh_bpartner_charge_uu_idx
		unique (bh_bpartner_charge_uu),
	constraint adclient_bhbpartnercharge
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhbpartnercharge
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint cbpartner_bhbpartnercharge
		foreign key (c_bpartner_id) references c_bpartner
			deferrable initially deferred,
	constraint ccharge_bhbpartnercharge
		foreign key (c_charge_id) references c_charge
			deferrable initially deferred
);

alter table bh_bpartner_charge
	add constraint bh_bpartner_charge_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

create table if not exists bh_bpartner_charge_info
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_bpartner_charge_id numeric(10) not null,
	bh_bpartner_charge_info_id numeric(10) not null,
	bh_bpartner_charge_info_uu varchar(36) default NULL::character varying,
	bh_charge_info_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_bpartner_charge_info_key
		primary key (bh_bpartner_charge_info_id),
	constraint bh_bpartner_charge_info_uu_idx
		unique (bh_bpartner_charge_info_uu),
	constraint adclient_bhbpartnerchargeinfo
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhbpartnerchargeinfo
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bhbpartnercharge_bhbpartnercha
		foreign key (bh_bpartner_charge_id) references bh_bpartner_charge
			deferrable initially deferred,
	constraint bhchargeinfo_bhbpartnerchargei
		foreign key (bh_charge_info_id) references bh_charge_info
			deferrable initially deferred
);

alter table bh_bpartner_charge_info
	add constraint bh_bpartner_charge_info_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- Go add default charges for all clients, and update all clients to have the renamed expense category charge type
UPDATE c_chargetype SET name = 'Default Expense Category - DO NOT CHANGE' WHERE name = 'Default Category';
INSERT INTO c_chargetype (
	ad_client_id,
	ad_org_id,
	c_chargetype_id,
	createdby,
	isactive,
	name,
	updatedby,
	value,
	c_chargetype_uu
)
SELECT
	ad_client_id,
	ad_org_id,
	(SELECT MAX(c_chargetype_id) + 1 FROM c_chargetype) + c_chargetype_id - (SELECT MIN(c_chargetype_id) FROM c_chargetype),
	100,
	'Y',
	'Non-Patient Payment - DO NOT CHANGE',
	100,
	CAST((SELECT MAX(c_chargetype_id) + 1 FROM c_chargetype) AS varchar(40)),
	uuid_generate_v4()
FROM c_chargetype
WHERE name = 'Default Expense Category - DO NOT CHANGE';

SELECT register_migration_script('202105051351_GO-1650.sql') FROM dual;
