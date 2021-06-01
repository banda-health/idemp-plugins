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
	ADD IF NOT EXISTS BH_ChargeTypeDefault_ID numeric(10) DEFAULT NULL;
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

create table if not exists bh_orderline_charge_info
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_id numeric(10) not null,
	bh_orderline_charge_info_id numeric(10) not null,
	bh_orderline_charge_info_uu varchar(36) default NULL::character varying,
	c_orderline_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60),
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint bh_orderline_charge_info_key
		primary key (bh_orderline_charge_info_id),
	constraint bh_orderline_charge_info_uuidx
		unique (bh_orderline_charge_info_uu),
	constraint adclient_bhorderlinechargeinfo
		foreign key (ad_client_id) references ad_client
			deferrable initially deferred,
	constraint adorg_bhorderlinechargeinfo
		foreign key (ad_org_id) references ad_org
			deferrable initially deferred,
	constraint bhchargeinfo_bhorderlinecharge
		foreign key (bh_charge_info_id) references bh_charge_info
			deferrable initially deferred,
	constraint corderline_bhorderlinechargein
		foreign key (c_orderline_id) references c_orderline
			deferrable initially deferred
);

alter table bh_orderline_charge_info
	add constraint bh_orderline_charge_info_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

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

-- Insert the sequences for all the tables
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-31 16:16:25.339000', 100, '2021-05-31 16:16:25.339000', 100, 'BH_OrderLine_Charge_Info', 'Table BH_OrderLine_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'b5f6d583-42a6-4bea-b6fa-3fc1cffa500d', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-21 11:04:32.673000', 100, '2021-05-21 11:04:32.673000', 100, 'BH_BPartner_Charge_Info', 'Table BH_BPartner_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '9f4c3abf-88f5-4a87-abc8-2fc5621f475c', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-18 17:13:17.862000', 100, '2021-05-18 17:13:17.862000', 100, 'BH_BPartner_Charge', 'Table BH_BPartner_Charge', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '41973573-c483-4277-a5b0-e0f91630894b', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-06 13:32:56.799000', 100, '2021-05-06 13:32:56.799000', 100, 'BH_Charge_Info_Values_Suggestion', 'Table BH_Charge_Info_Values_Suggestion', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '5dd2e34d-8e3a-4427-b1af-3a2ad8fa8877', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-06 13:29:45.677000', 100, '2021-05-06 13:29:45.677000', 100, 'BH_Charge_Info_Suggestion', 'Table BH_Charge_Info_Suggestion', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'd5a36df4-beb8-47d5-811a-a3cc681f30be', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 15:44:05.380000', 100, '2021-05-05 15:44:05.380000', 100, 'BH_Charge_Info_Values', 'Table BH_Charge_Info_Values', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'f3f090e5-1d71-4fab-90f2-3f24568ca8f6', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 15:29:50.227000', 100, '2021-05-05 15:29:50.227000', 100, 'BH_Charge_Info', 'Table BH_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '3e3dd4e6-84ae-41e2-9289-50ec57e44c98', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 14:00:44.089000', 100, '2021-05-05 14:00:44.089000', 100, 'BH_ChargeTypeDefault', 'Table BH_ChargeTypeDefault', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '70a2d434-dcc3-424d-b158-277ad967e82a', 'N', 'N', null) ON CONFLICT DO NOTHING;

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

-- Migrate the payment types to deactivate some and rename others
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'ade64e84-cd1b-43bc-a85c-c17a14963305'; -- Bill Waiver
UPDATE ad_ref_list SET name = 'Credit or Debit Card' WHERE ad_ref_list_uu = 'd3874573-b7bf-4556-9b9c-3644698c959e';
UPDATE ad_ref_list SET name = 'Bank Transfer' WHERE ad_ref_list_uu = '487227e8-c88e-45ef-8e6d-c0a480fdd0de';
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'e24511d1-9180-491c-9cc6-354b8a08e1ff'; -- Donor Fund
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'bb077404-71a4-4348-9afa-2b99ae9e1381'; -- CCC
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '55df64a7-1c7f-43f2-846b-f542c9cafa45'; -- MCH
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d'; -- Linda Mama
UPDATE ad_ref_list SET name = 'Cheque' WHERE ad_ref_list_uu = '900adbf9-5069-4f56-9d97-0313c6372af3';
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '7449ae78-c7d3-463b-921e-62a82a5e1a59'; -- M-TIBA
UPDATE ad_ref_list SET name = 'Mobile Money' WHERE ad_ref_list_uu = '7a78334e-3494-4d40-a718-c42cb053eea6';
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '28617687-cb93-494a-8f03-bc453da32658'; -- NHIF
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '4caa3109-804f-4773-8115-9bdb116f329b'; -- Outreach
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '64e8ad21-7c9d-442b-9655-f5223d76140c'; -- PesaPal
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'bd6f5227-483d-4bcf-b1fe-a840a3142327'; -- Account
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '97e54f17-fbae-40de-8dbd-e8ad7f884732'; -- Jubilee insurance
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '52fc8585-3c61-45b8-a0dd-db10c1e7d79c'; -- Liason insurance

-- Insert the new window
INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2021-05-14 13:15:17.874000', 100, '2021-05-14 13:15:17.874000', 100, 'Non-Patient Payments', 'This records has no associated tabs or tables as all that will be handled in GL. It''s only here for access assingnment and it''s UUID.', null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d', null) ON CONFLICT DO NOTHING;

-- Insert a new row for the menu item
INSERT INTO bh_dbrdbtngrp_btn (bh_dbrdbtngrp_btn_id, ad_client_id, ad_infowindow_id, ad_org_id, ad_window_id, bh_dbrdbtngrp_btn_uu, buttonclassname, buttonhelptext, buttontext, created, createdby, description, iconclassname, isactive, lineno, name, updated, updatedby, bh_dbrdbtngrp_id, ad_process_id, ad_form_id, included_role_id) VALUES ((SELECT MAX(bh_dbrdbtngrp_btn_id) + 1 FROM bh_dbrdbtngrp_btn), 0, null, 0, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'), '6a79762d-b480-4fa0-9e2e-67278fa8ee94', 'button app big', 'Non-Patient Payments', 'Non-Patient Payments', '2021-05-14 13:19:25.102000', 100, '/nonpatientpayments', 'fas fa-hand-holding-usd', 'Y', 110, 'Non-Patient Payments', '2021-05-14 13:22:16.230000', 100, (SELECT bh_dbrdbtngrp_id FROM bh_dbrdbtngrp WHERE bh_dbrdbtngrp_uu = 'bdd761f1-7979-4d87-9c5e-137c6210e9a1'), null, null, null) ON CONFLICT DO NOTHING;

-- Add in initial suggestions
INSERT INTO bh_charge_info_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_suggestion_uu, bh_chargeinfodatatype, bh_fillfrompatient, bh_subtype, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000000, 'ffef8118-1ee4-46cd-8d22-71d96e12f885', 'T', 'N', 'I', '2021-05-06 15:49:16.944000', 100, null, 'Y', 30, 'Claim Number', '2021-05-12 09:53:45.640000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_charge_info_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_suggestion_uu, bh_chargeinfodatatype, bh_fillfrompatient, bh_subtype, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000001, 'ffa9b6d7-5e31-480b-91f8-97c7c3242a98', 'T', 'Y', 'I', '2021-05-06 15:49:32.261000', 100, null, 'Y', 0, 'Member ID', '2021-05-12 09:53:56.824000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_charge_info_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_suggestion_uu, bh_chargeinfodatatype, bh_fillfrompatient, bh_subtype, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000002, '40af0824-d93f-4d0f-8137-c6c57f126c69', 'T', 'Y', 'I', '2021-05-06 15:49:41.936000', 100, null, 'Y', 10, 'Member Name', '2021-05-12 09:54:10.522000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_charge_info_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_suggestion_uu, bh_chargeinfodatatype, bh_fillfrompatient, bh_subtype, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000003, '4c280097-e943-46d7-b96a-907c35c64686', 'L', 'Y', 'I', '2021-05-06 15:50:00.918000', 100, null, 'Y', 20, 'Relationship', '2021-05-12 09:54:21.358000', 100) ON CONFLICT DO NOTHING;

INSERT INTO bh_charge_info_values_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_values_suggestion_id, bh_charge_info_values_suggestion_uu, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000003, 1000001, 'a3e9163b-4e87-43c0-94f7-31ebe299a56e', '2021-05-06 15:56:44.047000', 100, null, 'Y', 0, 'Principle Member', '2021-05-06 15:56:44.047000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_charge_info_values_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_values_suggestion_id, bh_charge_info_values_suggestion_uu, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000003, 1000002, '218f012c-cb6c-49bd-956f-5a78d256630f', '2021-05-06 15:56:49.735000', 100, null, 'Y', 10, 'Spouse', '2021-05-06 15:56:49.735000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_charge_info_values_suggestion (ad_client_id, ad_org_id, bh_charge_info_suggestion_id, bh_charge_info_values_suggestion_id, bh_charge_info_values_suggestion_uu, created, createdby, description, isactive, line, name, updated, updatedby) VALUES (0, 0, 1000003, 1000003, '669fac83-9d83-43de-86a5-dd96a2514be4', '2021-05-06 15:56:56.637000', 100, null, 'Y', 20, 'Child', '2021-05-06 15:56:56.637000', 100) ON CONFLICT DO NOTHING;

-- Update the sequences
SELECT update_sequences();

SELECT register_migration_script('202105051351_GO-1650.sql') FROM dual;
