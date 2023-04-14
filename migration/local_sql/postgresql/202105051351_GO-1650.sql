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
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:11:58.103000', 100, '2021-05-05 15:11:58.103000', 100, 'I', 'Insurance', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', 'd8547f6d-5ad0-4025-b8f8-0f4796cf9d0f') ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:12:04.235000', 100, '2021-05-05 15:12:04.235000', 100, 'W', 'Waiver', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', '406d22a4-b3ee-48e4-9bba-7031f653aa06') ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:12:10.450000', 100, '2021-05-05 15:12:10.450000', 100, 'D', 'Donation', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'), null, null, 'U', '4782b135-a84e-4eb9-ae3d-88c872a030ce') ON CONFLICT DO NOTHING;

-- Add the charge info data type reference list
INSERT INTO ad_reference (ad_reference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, validationtype, vformat, entitytype, isorderbyvalue, ad_reference_uu, ad_element_id) VALUES ((SELECT MAX(ad_reference_id) + 1 FROM ad_reference), 0, 0, 'Y', '2021-05-05 15:33:16.543000', 100, '2021-05-05 15:33:16.543000', 100, 'Charge Info Data Type', null, null, 'L', null, 'U', 'N', '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:33:46.220000', 100, '2021-05-05 15:33:46.220000', 100, 'T', 'Text', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'), null, null, 'U', '30c39cd3-e132-4b80-811e-74c5e06f8fae') ON CONFLICT DO NOTHING;
INSERT INTO ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value, name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu) VALUES ((SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 0, 0, 'Y', '2021-05-05 15:33:50.594000', 100, '2021-05-05 15:33:50.594000', 100, 'L', 'List', null, (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '15b3f5d7-205a-4d91-84c0-5e38ec36b6c6'), null, null, 'U', '5be1018a-8aa1-4f9a-8ec9-a022fa3675b9') ON CONFLICT DO NOTHING;

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
			deferrable initially deferred,
	constraint bh_orderline_charge_info_isactive_check
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
			deferrable initially deferred,
	constraint bh_bpartner_charge_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

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
			deferrable initially deferred,
	constraint bh_bpartner_charge_info_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Insert the sequences for all the tables
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-31 16:16:25.339000', 100, '2021-05-31 16:16:25.339000', 100, 'BH_OrderLine_Charge_Info', 'Table BH_OrderLine_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'b5f6d583-42a6-4bea-b6fa-3fc1cffa500d', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-21 11:04:32.673000', 100, '2021-05-21 11:04:32.673000', 100, 'BH_BPartner_Charge_Info', 'Table BH_BPartner_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '9f4c3abf-88f5-4a87-abc8-2fc5621f475c', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-18 17:13:17.862000', 100, '2021-05-18 17:13:17.862000', 100, 'BH_BPartner_Charge', 'Table BH_BPartner_Charge', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '41973573-c483-4277-a5b0-e0f91630894b', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-06 13:32:56.799000', 100, '2021-05-06 13:32:56.799000', 100, 'BH_Charge_Info_Values_Suggestion', 'Table BH_Charge_Info_Values_Suggestion', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '5dd2e34d-8e3a-4427-b1af-3a2ad8fa8877', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-06 13:29:45.677000', 100, '2021-05-06 13:29:45.677000', 100, 'BH_Charge_Info_Suggestion', 'Table BH_Charge_Info_Suggestion', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'd5a36df4-beb8-47d5-811a-a3cc681f30be', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 15:44:05.380000', 100, '2021-05-05 15:44:05.380000', 100, 'BH_Charge_Info_Values', 'Table BH_Charge_Info_Values', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'f3f090e5-1d71-4fab-90f2-3f24568ca8f6', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 15:29:50.227000', 100, '2021-05-05 15:29:50.227000', 100, 'BH_Charge_Info', 'Table BH_Charge_Info', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '3e3dd4e6-84ae-41e2-9289-50ec57e44c98', 'N', 'N', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence), 0, 0, 'Y', '2021-05-05 14:00:44.089000', 100, '2021-05-05 14:00:44.089000', 100, 'BH_ChargeTypeDefault', 'Table BH_ChargeTypeDefault', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '70a2d434-dcc3-424d-b158-277ad967e82a', 'N', 'N', null) ON CONFLICT DO NOTHING;

-- Insert the table records so the sequences will update
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 14:00:43.999000', 100, '2021-05-05 14:00:43.999000', 100, 'Charge Type Default', null, null, 'BH_ChargeTypeDefault', 'N', '4', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', 'aa051847-b168-4f08-b1d1-642d632891d4', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 15:29:50.149000', 100, '2021-05-05 15:29:50.149000', 100, 'Charge Info', 'A table to dynamically hold extra information for charges', null, 'BH_Charge_Info', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', '3598e2cf-7065-47cb-8fcc-9cadcca3e0d5', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-21 11:05:26.869000', 100, '2021-05-21 11:05:26.869000', 100, 'BH Business Partner Charge', 'Maps charges for extra info to business partners', null, 'BH_BPartner_Charge', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', '16b50b04-0768-4565-9616-570f74d137e1', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 15:44:05.354000', 100, '2021-05-05 15:44:05.354000', 100, 'Charge Info Values', 'Holds any list values that may be required to limit charge info input', null, 'BH_Charge_Info_Values', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', 'd986ad38-8b33-4b6e-8351-23d8fa4f213b', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 16:06:36.322000', 100, '2021-05-31 16:16:38.446000', 100, 'Order Line Charge Information', null, null, 'BH_OrderLine_Charge_Info', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', 'fab72e5a-0764-40a7-a8fb-42b18ce67a92', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 15:50:45.090000', 100, '2021-05-06 13:29:56.696000', 100, 'Charge Info Suggestion', null, null, 'BH_Charge_Info_Suggestion', 'N', '4', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', 'bccb5656-ce2e-4655-a05e-0f3eb9f49cd5', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 15:55:38.373000', 100, '2021-05-06 13:32:56.790000', 100, 'Charge Info Values Suggestion', 'The suggested values to hold for any list types of charge defaults that will be available to clients', null, 'BH_Charge_Info_Values_Suggestion', 'N', '4', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', '2a26b4bd-3ec5-4b20-808b-4ccf93a495dd', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;
INSERT INTO ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled, isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable, iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview, createwindowfromtable) VALUES ((SELECT MAX(ad_table_id) + 1 FROM ad_table), 0, 0, 'Y', '2021-05-05 16:10:13.341000', 100, '2021-05-21 11:07:09.876000', 100, 'Business Partner Charge Info', null, null, 'BH_BPartner_Charge_Info', 'N', '3', 'U', null, null, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', null, 'N', 'Y', '000eb497-d822-42f0-952f-30d6ad1a5270', 'N', 'N', 'N', 'N') ON CONFLICT DO NOTHING;

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
UPDATE ad_ref_list SET name = 'Credit or Debit Card' WHERE ad_ref_list_uu = 'd3874573-b7bf-4556-9b9c-3644698c959e'; -- Previously Credit Card
UPDATE ad_ref_list SET name = 'Bank Transfer' WHERE ad_ref_list_uu = '487227e8-c88e-45ef-8e6d-c0a480fdd0de'; -- Previously Direct Debit
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'e24511d1-9180-491c-9cc6-354b8a08e1ff'; -- Donor Fund
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'bb077404-71a4-4348-9afa-2b99ae9e1381'; -- CCC
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '55df64a7-1c7f-43f2-846b-f542c9cafa45'; -- MCH
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d'; -- Linda Mama
UPDATE ad_ref_list SET name = 'Cheque' WHERE ad_ref_list_uu = '900adbf9-5069-4f56-9d97-0313c6372af3'; -- Previously Check
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '7449ae78-c7d3-463b-921e-62a82a5e1a59'; -- M-TIBA
UPDATE ad_ref_list SET name = 'Mobile Money' WHERE ad_ref_list_uu = '7a78334e-3494-4d40-a718-c42cb053eea6'; -- Previously M-Pesa
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '28617687-cb93-494a-8f03-bc453da32658'; -- NHIF
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '4caa3109-804f-4773-8115-9bdb116f329b'; -- Outreach
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '64e8ad21-7c9d-442b-9655-f5223d76140c'; -- PesaPal
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = 'bd6f5227-483d-4bcf-b1fe-a840a3142327'; -- Account
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '97e54f17-fbae-40de-8dbd-e8ad7f884732'; -- Jubilee insurance
UPDATE ad_ref_list SET isactive = 'N' WHERE ad_ref_list_uu = '52fc8585-3c61-45b8-a0dd-db10c1e7d79c'; -- Liason insurance

-- Update existing payments to use the new values above
-- Update PesaPal/M-TIBA to be Mobile Money
UPDATE c_payment SET tendertype = 'M' WHERE tendertype = 'P';
UPDATE c_payment SET tendertype = 'M' WHERE tendertype = 'L';
-- Update Direct Debit to be Credit or Debit Card
UPDATE c_payment SET tendertype = 'C' WHERE tendertype = 'D';

-- Migrate the PTR tender types
UPDATE ad_ref_list SET value = 'C', name = 'Credit or Debit Card' WHERE ad_ref_list_uu = '3a9c61f4-0097-42b8-b485-9f79958bf566'; -- Bill Waiver
UPDATE ad_ref_list SET value = 'D', name = 'Bank Transfer' WHERE ad_ref_list_uu = 'a63c8768-3aa1-4a1e-830c-2019d6208116'; -- Donor Fund
UPDATE ad_ref_list SET value = 'I', name = 'Insurance' WHERE ad_ref_list_uu = '3d12c6d9-92f9-495f-b2f0-d35baedc614e'; -- NHIF
UPDATE ad_ref_list SET value = 'K', name = 'Cheque' WHERE ad_ref_list_uu = 'c90e2164-68dd-4996-831d-c7aa02b37177'; -- Linda Mama
UPDATE ad_ref_list SET value = 'M', name = 'Mobile Money' WHERE ad_ref_list_uu = '1eae83ac-e3a7-4e18-afb5-574fd11dd43f'; -- M-Pesa

-- Insert the new window
INSERT INTO ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic) VALUES ((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2021-05-14 13:15:17.874000', 100, '2021-05-14 13:15:17.874000', 100, 'Non-Patient Payments', 'This records has no associated tabs or tables as all that will be handled in GL. It''s only here for access assingnment and it''s UUID.', null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d', null) ON CONFLICT DO NOTHING;
INSERT INTO ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id, readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id, treedisplayedon, maxqueryrecords) VALUES ((SELECT MAX(ad_tab_id) + 1 FROM ad_tab), 0, 0, 'Y', '2021-06-08 15:42:02.974000', 100, '2021-06-08 15:42:02.974000', 100, 'Non-Patient Payments', null, null, 313, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'), 10, 0, 'Y', 'N', 'N', 'N', null, 'N', null, null, null, null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null, '012fd982-4703-4a95-81b0-7f0f2767087d', null, 'B', 0) ON CONFLICT DO NOTHING;

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

/**********************************************************************************************************/
-- Insert charges, information, and values for each client
/**********************************************************************************************************/
-- Add donation accounting information to each client
DROP TABLE IF EXISTS tmp_c_elementvalue;
CREATE TEMP TABLE tmp_c_elementvalue (
	c_elementvalue_id serial NOT NULL,
	ad_client_id numeric(10,0) NOT NULL,
	ad_org_id numeric(10,0) NOT NULL DEFAULT 0,
	createdby numeric(10,0) NOT NULL DEFAULT 100,
	updatedby numeric(10,0) NOT NULL DEFAULT 100,
	value character varying(40) COLLATE pg_catalog."default" NOT NULL,
	name character varying(120) COLLATE pg_catalog."default" NOT NULL,
	description character varying(255) COLLATE pg_catalog."default",
	accounttype character(1) COLLATE pg_catalog."default" NOT NULL,
	accountsign character(1) COLLATE pg_catalog."default" NOT NULL,
	c_element_id numeric(10,0) NOT NULL,
	issummary character(1) COLLATE pg_catalog."default" NOT NULL DEFAULT 'N'::bpchar,
	c_elementvalue_uu uuid NOT NULL DEFAULT uuid_generate_v4()
);
DROP TABLE IF EXISTS tmp_c_validcombination;
CREATE TEMP TABLE tmp_c_validcombination (
	c_validcombination_id serial NOT NULL,
	ad_client_id numeric(10,0) NOT NULL,
	ad_org_id numeric(10,0) NOT NULL DEFAULT 0,
	createdby numeric(10,0) NOT NULL DEFAULT 100,
	updatedby numeric(10,0) NOT NULL DEFAULT 100,
	combination character varying(60) COLLATE pg_catalog."default",
	description character varying(255) COLLATE pg_catalog."default",
	c_acctschema_id numeric(10,0) NOT NULL,
	account_id numeric(10,0) NOT NULL,
	c_validcombination_uu uuid NOT NULL DEFAULT uuid_generate_v4()
);

-- Alter the sequence so the correct IDs will be inserted since iDempiere tracks this manually
SELECT setval(
	'tmp_c_elementvalue_c_elementvalue_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'C_ElementValue'
		LIMIT 1
	)::INT,
	false
);
SELECT setval(
	'tmp_c_validcombination_c_validcombination_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'C_ValidCombination'
		LIMIT 1
	)::INT,
	false
);

-- Create the dontions summary account
INSERT INTO tmp_c_elementvalue (
	ad_client_id,
	value,
	name,
	accounttype,
	accountsign,
	c_element_id,
	issummary
)
SELECT
	c.ad_client_id,
	'127',--value
	'Accounts Receivable - Donations',--name
	'A',--accounttype
	'N',--accountsign
	e.c_element_id,
	'Y'--issummary
FROM ad_client c
JOIN c_element e
	ON e.ad_client_id = c.ad_client_id
WHERE c.ad_client_id > 999999 AND c.ad_client_id NOT IN (SELECT ad_client_id FROM c_elementvalue WHERE value = '127');

-- Create the dontions account
INSERT INTO tmp_c_elementvalue (
	ad_client_id,
	value,
	name,
	accounttype,
	accountsign,
	c_element_id,
	issummary
)
SELECT
	c.ad_client_id,
	'12710',--value
	'Donor Fund',--name
	'A',--accounttype
	'N',--accountsign
	e.c_element_id,
    'N'
FROM ad_client c
JOIN c_element e
	ON e.ad_client_id = c.ad_client_id
WHERE c.ad_client_id > 999999 AND c.ad_client_id NOT IN (SELECT ad_client_id FROM c_elementvalue WHERE value = '12710');

-- Create the NHIF National Scheme account
INSERT INTO tmp_c_elementvalue (
	ad_client_id,
	value,
	name,
	accounttype,
	accountsign,
	c_element_id,
	issummary
)
SELECT
	c.ad_client_id,
	'12310',--value
	'A/R - NHIF National Scheme',--name
	'A',--accounttype
	'N',--accountsign
	e.c_element_id,
  'N'
FROM ad_client c
JOIN c_element e
	ON e.ad_client_id = c.ad_client_id
WHERE c.ad_client_id > 999999 AND c.ad_client_id NOT IN (SELECT ad_client_id FROM c_elementvalue WHERE value = '12310');

-- Add these accounts officially to iDempiere
INSERT INTO c_elementvalue (
	c_elementvalue_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	accounttype,
	accountsign,
	c_element_id,
	issummary,
	c_elementvalue_uu
)
SELECT
	c_elementvalue_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	value,
	name,
	description,
	accounttype,
	accountsign,
	c_element_id,
	issummary,
	c_elementvalue_uu
FROM tmp_c_elementvalue;

-- Add the new account to the Element Value tree so it shows up in the UI
INSERT INTO ad_treenode (
	ad_tree_id,
	node_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	parent_id,
	seqno,
	ad_treenode_uu
)
SELECT
	tr.ad_tree_id,
	ev.c_elementvalue_id,
	ev.ad_client_id,
	0,
	100,
	100,
	CASE
		WHEN ev.value = '127' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '12')
		WHEN ev.value = '12710' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '127')
		WHEN ev.value = '12310' THEN (SELECT c_elementvalue_id FROM c_elementvalue WHERE ad_client_id = ev.ad_client_id AND value = '123')
		ELSE 0
	END,
	999,
	uuid_generate_v4()
FROM tmp_c_elementvalue ev
	INNER JOIN ad_tree tr
		ON tr.ad_client_id = ev.ad_client_id
			AND tr.name like '%Element Value';

-- Create combinations for each new element that was added
INSERT INTO tmp_c_validcombination (
	ad_client_id,
	combination,
	description,
	c_acctschema_id,
	account_id
)
SELECT
	ev.ad_client_id,
	'*-'||ev.value||'-_-_',
	'*-'||ev.name||'-_-_',
	accts.c_acctschema_id,
	ev.c_elementvalue_id
FROM tmp_c_elementvalue ev
INNER JOIN ad_client c
	ON c.ad_client_id = ev.ad_client_id
INNER JOIN c_acctschema accts
	ON accts.ad_client_id = c.ad_client_id;

-- Insert the valid combination into the real table
INSERT INTO c_validcombination (
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
)
SELECT
	c_validcombination_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	combination,
	description,
	c_acctschema_id,
	account_id,
	c_validcombination_uu
FROM tmp_c_validcombination;

/**********************************************************************************************************/
-- Insert charges, information, and values for each client
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_c_charge;
CREATE TEMP TABLE tmp_c_charge (
	c_charge_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	isactive char default 'Y'::bpchar not null,
	created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null,
	name varchar(60) not null,
	description varchar(255),
	chargeamt numeric default 0 not null,
	issametax char default 'N'::bpchar not null,
	issamecurrency char default 'N'::bpchar not null,
	c_taxcategory_id numeric(10),
	istaxincluded char default 'N'::bpchar not null,
	c_bpartner_id numeric(10),
	c_chargetype_id numeric(10),
	c_charge_uu varchar(36) default NULL::character varying,
	c_elementvalue_id numeric(10) default NULL::numeric,
	bh_locked char default 'N'::bpchar,
	bh_subtype varchar(2) default NULL::character varying,
	bh_needadditionalvisitinfo char default 'N'::bpchar not null
);
DROP TABLE IF EXISTS tmp_bh_charge_info;
CREATE TEMP TABLE tmp_bh_charge_info (
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	bh_charge_info_id serial not null,
	bh_charge_info_uu varchar(36) default uuid_generate_v4(),
	bh_chargeinfodatatype varchar(2) default 'T'::character varying not null,
	bh_fillfrompatient char default 'N'::bpchar not null,
	c_charge_id numeric(10) not null,
	created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) not null,
	name varchar(60) not null,
	updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null
);
DROP TABLE IF EXISTS tmp_bh_charge_info_values;
CREATE TEMP TABLE tmp_bh_charge_info_values (
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) default 0 not null,
	bh_charge_info_id numeric(10) not null,
	bh_charge_info_values_id serial not null,
	bh_charge_info_values_uu varchar(36) default uuid_generate_v4(),
	created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	line numeric(10) default NULL::numeric,
	name varchar(60) not null,
	updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null
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
SELECT setval(
	'tmp_bh_charge_info_bh_charge_info_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'BH_Charge_Info'
		LIMIT 1
	)::INT,
	false
);
SELECT setval(
	'tmp_bh_charge_info_values_bh_charge_info_values_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'BH_Charge_Info_Values'
		LIMIT 1
	)::INT,
	false
);

INSERT INTO tmp_c_charge (
	ad_client_id,
	ad_org_id,
	isactive,
	name,
	description,
	chargeamt,
	issametax,
	issamecurrency,
	c_taxcategory_id,
	istaxincluded,
	c_bpartner_id,
	c_chargetype_id,
	c_charge_uu,
	c_elementvalue_id,
	bh_locked,
	bh_subtype,
	bh_needadditionalvisitinfo
)
SELECT
	ev.ad_client_id,
	0, -- ad_org_id,
	'Y', --isactive,
	i.name,
	null, --description,
	0,--chargeamt,
	'N',--issametax,
	'N',--issamecurrency,
	null,--c_taxcategory_id,
	'N',--istaxincluded,
	null,--c_bpartner_id,
	ct.c_chargetype_id,
	uuid_generate_v4(),--c_charge_uu,
	ev.c_elementvalue_id,
	'Y',--bh_locked,
	i.bh_subType,
	'Y'--bh_needadditionalvisitinfo
FROM c_elementvalue ev
JOIN (
	SELECT 'NHIF National Scheme' as name, 'I' as bh_subType, '12310' as c_elementvalue_value UNION
	SELECT 'NHIF Fixed FFS', 'I', '12320' UNION
	SELECT 'NHIF FFS', 'I', '12320' UNION
	SELECT 'EduAfya FFS', 'I', '12330' UNION
	SELECT 'Linda Mama', 'I', '12330' UNION
	SELECT 'Liason Insurance', 'I', '12330' UNION
	SELECT 'Jubilee Insurance', 'I', '12330' UNION
	SELECT 'Bill Waiver', 'W', '49100' UNION
	SELECT 'Donor Fund', 'D', '12710' UNION
	SELECT 'CCC', 'I', '12330' UNION
	SELECT 'MCH', 'I', '12330'
) i ON ev.value = i.c_elementvalue_value
JOIN c_chargetype ct ON ct.ad_client_id = ev.ad_client_id AND ct.name = 'Non-Patient Payment - DO NOT CHANGE'
WHERE ev.ad_client_id > 999999;

-- Insert the charges
INSERT INTO c_charge (
	c_charge_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	name,
	description,
	chargeamt,
	issametax,
	issamecurrency,
	c_taxcategory_id,
	istaxincluded,
	c_bpartner_id,
	c_chargetype_id,
	c_charge_uu,
	c_elementvalue_id,
	bh_locked,
	bh_subtype,
	bh_needadditionalvisitinfo
)
SELECT
	c_charge_id,
	ad_client_id,
	ad_org_id,
	isactive,
	created,
	createdby,
	updated,
	updatedby,
	name,
	description,
	chargeamt,
	issametax,
	issamecurrency,
	c_taxcategory_id,
	istaxincluded,
	c_bpartner_id,
	c_chargetype_id,
	c_charge_uu,
	c_elementvalue_id,
	bh_locked,
	bh_subtype,
	bh_needadditionalvisitinfo
FROM tmp_c_charge;

-- Insert the information for each of these charges
INSERT INTO tmp_bh_charge_info (
	ad_client_id,
	bh_chargeinfodatatype,
	bh_fillfrompatient,
	c_charge_id,
	line,
	name
)
SELECT
	c.ad_client_id,
	i.bh_chargeinfodatatype,
	i.bh_fillfrompatient,
	c.c_charge_id,
	i.charge_info_line,--line,
	i.charge_info_name--name
FROM tmp_c_charge c
JOIN (
	SELECT charge_name, charge_info_name, charge_info_line, bh_fillfrompatient, bh_chargeinfodatatype
	FROM (
		SELECT 'NHIF National Scheme' as charge_name UNION
		SELECT 'NHIF Fixed FFS' UNION
		SELECT 'NHIF FFS'
	) c
	CROSS JOIN (
		SELECT 'NHIF Number' as charge_info_name, 0 as charge_info_line, 'Y' as bh_fillfrompatient, 'T' as bh_chargeinfodatatype UNION
		SELECT 'Member Name', 10, 'Y', 'T' UNION
		SELECT 'Relationship', 20, 'Y', 'L' UNION
		SELECT 'Claim Number', 30, 'N', 'T'
	) v
	UNION
	SELECT charge_name, charge_info_name, charge_info_line, bh_fillfrompatient, bh_chargeinfodatatype
	FROM (
		SELECT 'EduAfya FFS' as charge_name UNION
		SELECT 'Linda Mama' UNION
		SELECT 'Liason Insurance' UNION
		SELECT 'Jubilee Insurance'
	) c
	CROSS JOIN (
		SELECT 'Member ID' as charge_info_name, 0 as charge_info_line, 'Y' as bh_fillfrompatient, 'T' as bh_chargeinfodatatype UNION
		SELECT 'Member Name', 10, 'Y', 'T' UNION
		SELECT 'Relationship', 20, 'Y', 'L' UNION
		SELECT 'Claim Number', 30, 'N', 'T'
	) v
	UNION
	SELECT 'CCC', 'Patient ID', 0, 'Y', 'T'
	UNION
	SELECT 'CCC', 'Patient Name', 10, 'Y', 'T'
	UNION
	SELECT 'MCH', 'Patient ID', 0, 'Y', 'T'
	UNION
	SELECT 'MCH', 'Mother''s Name', 10, 'Y', 'T'
) i ON i.charge_name = c.name;

INSERT INTO bh_charge_info (
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_charge_info_uu,
	bh_chargeinfodatatype,
	bh_fillfrompatient,
	c_charge_id,
	created,
	createdby,
	description,
	isactive,
	line,
	name,
	updated,
	updatedby
)
SELECT
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_charge_info_uu,
	bh_chargeinfodatatype,
	bh_fillfrompatient,
	c_charge_id,
	created,
	createdby,
	description,
	isactive,
	line,
	name,
	updated,
	updatedby
FROM tmp_bh_charge_info;

-- Lastly, insert the list values for all that charge information...
INSERT INTO tmp_bh_charge_info_values (
	ad_client_id,
	bh_charge_info_id,
	line,
	name
)
SELECT
	ci.ad_client_id,
	ci.bh_charge_info_id,
	v.line,
	v.name
FROM tmp_bh_charge_info ci
CROSS JOIN (
	SELECT 'Principle Member' as name, 0 as line UNION
	SELECT 'Spouse', 10 UNION
	SELECT 'Child', 20
) v
WHERE ci.bh_chargeinfodatatype = 'L';

INSERT INTO bh_charge_info_values (
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_charge_info_values_id,
	bh_charge_info_values_uu,
	created,
	createdby,
	description,
	isactive,
	line,
	name,
	updated,
	updatedby
)
SELECT
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_charge_info_values_id,
	bh_charge_info_values_uu,
	created,
	createdby,
	description,
	isactive,
	line,
	name,
	updated,
	updatedby
FROM tmp_bh_charge_info_values;

/**********************************************************************************************************/
-- Copy over values stored in the payment columns to be on the bh_orderline_charge_info table
/**********************************************************************************************************/
DROP TABLE IF EXISTS tmp_bh_orderline_charge_info;
CREATE TEMP TABLE tmp_bh_orderline_charge_info (
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_charge_info_id numeric(10) not null,
	bh_orderline_charge_info_id serial not null,
	bh_orderline_charge_info_uu varchar(36) default uuid_generate_v4(),
	c_orderline_id numeric(10) not null,
	created timestamp default now() not null,
	createdby numeric(10) default 100 not null,
	description varchar(255) default NULL::character varying,
	isactive char default 'Y'::bpchar not null,
	name varchar(60),
	updated timestamp default now() not null,
	updatedby numeric(10) default 100 not null
);
DROP TABLE IF EXISTS tmp_c_orderline;
CREATE TEMP TABLE tmp_c_orderline (
	c_orderline_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	createdby numeric(10) default 100 not null,
	updatedby numeric(10) default 100 not null,
	c_order_id numeric(10) not null,
	line numeric(10) not null,
	c_bpartner_id numeric(10),
	c_bpartner_location_id numeric(10),
	dateordered timestamp not null,
	datepromised timestamp,
	datedelivered timestamp,
	description varchar(255),
	m_warehouse_id numeric(10) not null,
	c_uom_id numeric(10) default 100 not null,
	qtyordered numeric default 1 not null,
	qtydelivered numeric default 1 not null,
	qtyinvoiced numeric default 1 not null,
	c_currency_id numeric(10) not null,
	priceactual numeric default 0 not null,
	linenetamt numeric default 0 not null,
	c_charge_id numeric(10),
	c_tax_id numeric(10) not null,
	processed char default 'N'::bpchar not null,
	qtyentered numeric default 1 not null,
	priceentered numeric not null,
	c_orderline_uu varchar(36) default uuid_generate_v4()
);
DROP TABLE IF EXISTS tmp_payments_to_map;
DROP TABLE IF EXISTS tmp_payments_to_charges;

-- Get the payments we're going to map
SELECT
	c_payment_id,
	tendertype,
	c_currency_id,
	payamt,
	description,
	coalesce(bh_c_order_id, c_order_id) as c_order_id,
	bh_nhif_type,
	bh_nhif_claim_number,
	nhif_number,
	bh_nhif_member_id,
	bh_nhif_member_name,
	bh_nhif_relationship,
	bh_nhif_linda_mama
INTO TEMP TABLE tmp_payments_to_map
FROM c_payment
WHERE (
		coalesce(bh_nhif_claim_number,bh_nhif_linda_mama,bh_nhif_member_id,bh_nhif_member_name,bh_nhif_type) IS NOT NULL OR
			tendertype IN ('V', 'U', 'N', 'i', 'B', 'G', 'H', 'O')
	)
	AND payamt != 0 AND (bh_c_order_id IS NOT NULL OR c_order_id IS NOT NULL) AND tendertype NOT IN ('X', 'M');

-- Map the payments to map to the appropriate charges
SELECT charge_name, c_order_id, c_payment_id, needs_information, row_number() over (PARTITION BY c_order_id) as line
INTO TEMP TABLE tmp_payments_to_charges
FROM (
	SELECT 'NHIF National Scheme' as charge_name, c_order_id, c_payment_id, 'Y' as needs_information
	FROM tmp_payments_to_map
	WHERE bh_nhif_type = '10000002' OR (bh_nhif_type IS NULL AND tendertype = 'N')
	UNION
	SELECT 'NHIF Fixed FFS' as charge_name, c_order_id, c_payment_id, 'Y'
	FROM tmp_payments_to_map
	WHERE bh_nhif_type = '10000003'
	UNION
	SELECT 'NHIF FFS' as charge_name, c_order_id, c_payment_id, 'Y'
	FROM tmp_payments_to_map
	WHERE bh_nhif_type = '10000004'
	UNION
	SELECT 'EduAfya FFS' as charge_name, c_order_id, c_payment_id, 'Y'
	FROM tmp_payments_to_map
	WHERE bh_nhif_type = '10000005'
	UNION
	SELECT 'Linda Mama' as charge_name, c_order_id, c_payment_id, 'Y'
	FROM tmp_payments_to_map
	WHERE bh_nhif_linda_mama IS NOT NULL AND bh_nhif_type IS NOT NULL OR tendertype = 'i'
	UNION
	SELECT 'Jubilee insurance' as charge_name, c_order_id, c_payment_id, 'N'
	FROM tmp_payments_to_map
	WHERE tendertype = 'U'
	UNION
	SELECT 'Liason insurance' as charge_name, c_order_id, c_payment_id, 'N'
	FROM tmp_payments_to_map
	WHERE tendertype = 'V'
	UNION
	SELECT 'Bill Waiver' as charge_name, c_order_id, c_payment_id, 'N'
	FROM tmp_payments_to_map
	WHERE tendertype IN ('O', 'B')
	UNION
	SELECT 'CCC' as charge_name, c_order_id, c_payment_id, 'N'
	FROM tmp_payments_to_map
	WHERE tendertype = 'G'
	UNION
	SELECT 'MCH' as charge_name, c_order_id, c_payment_id, 'N'
	FROM tmp_payments_to_map
	WHERE tendertype = 'H'
) c;

SELECT setval(
	'tmp_bh_orderline_charge_info_bh_orderline_charge_info_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'BH_OrderLine_Charge_Info'
		LIMIT 1
	)::INT,
	false
);
SELECT setval(
	'tmp_c_orderline_c_orderline_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'C_OrderLine'
		LIMIT 1
	)::INT,
	false
);

-- Insert new order lines for these entities
;WITH associated_orderline as (
	SELECT
		o.ad_client_id,
		o.ad_org_id,
		o.c_order_id,
		o.c_bpartner_id,
		o.c_bpartner_location_id,
		o.dateordered,
		o.datepromised,
		o.dateordered as datedelivered,
		o.m_warehouse_id,
		t.c_tax_id,
		'N' as processed,
		coalesce(m.line, 0) as line
		FROM c_order o
			LEFT JOIN (
				SELECT ol.c_order_id, MAX(ol.line) as line
				FROM c_orderline ol
					JOIN tmp_payments_to_map ptm ON ol.c_order_id = ptm.c_order_id
				GROUP BY ol.c_order_id
			) m ON m.c_order_id = o.c_order_id
			JOIN (
				SELECT ad_client_id, MAX(c_tax_id) as c_tax_id FROM c_tax
				GROUP BY ad_client_id
			) t ON t.ad_client_id = o.ad_client_id
		WHERE o.c_order_id IN (SELECT c_order_id FROM tmp_payments_to_map)
)
INSERT INTO tmp_c_orderline (
	ad_client_id,
	ad_org_id,
	c_order_id,
	line,
	c_bpartner_id,
	c_bpartner_location_id,
	dateordered,
	datepromised,
	datedelivered,
	description,
	m_warehouse_id,
	c_currency_id,
	priceactual,
	linenetamt,
	c_charge_id,
	c_tax_id,
	processed,
	priceentered
)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ol.c_order_id,
	10 * ptc.line + ol.line, --line
	ol.c_bpartner_id,
	ol.c_bpartner_location_id,
	ol.dateordered,
	ol.datepromised,
	ol.datedelivered,
	ptm.description,
	ol.m_warehouse_id,
	ptm.c_currency_id,
	ptm.payamt*-1,--priceactual
	ptm.payamt*-1,--linenetamt
	c_charge_id,
	ol.c_tax_id,
	ol.processed,
	ptm.payamt*-1--priceentered
FROM tmp_payments_to_map ptm
JOIN tmp_payments_to_charges ptc ON ptm.c_payment_id = ptc.c_payment_id
JOIN associated_orderline ol ON ol.c_order_id = ptm.c_order_id
JOIN tmp_c_charge c ON c.name = ptc.charge_name AND c.ad_client_id = ol.ad_client_id;

-- We'll only map the NHIF stuff, because that's the only stuff that had additional information stored in columns for payments
INSERT INTO tmp_bh_orderline_charge_info (
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	c_orderline_id,
	name
)
SELECT
	ol.ad_client_id,
	ol.ad_org_id,
	ci.bh_charge_info_id,
	ol.c_orderline_id,
	CASE
		WHEN ci.name = 'NHIF Number' THEN ptm.nhif_number
		WHEN c.name = 'Linda Mama' AND ci.name = 'Member ID' THEN ptm.bh_nhif_linda_mama
		WHEN c.name = 'EduAfya FFS' AND ci.name = 'Member ID' THEN ptm.bh_nhif_linda_mama
		WHEN ci.name = 'Claim Number' THEN ptm.bh_nhif_claim_number
		WHEN ci.name = 'Relationship' AND ptm.bh_nhif_relationship = 'P' THEN 'Principle Member'
		WHEN ci.name = 'Relationship' AND ptm.bh_nhif_relationship = 'S' THEN 'Spouse'
		WHEN ci.name = 'Relationship' AND ptm.bh_nhif_relationship = 'C' THEN 'Child'
		WHEN ci.name = 'Member Name' THEN ptm.bh_nhif_member_name
	END -- name
FROM tmp_c_orderline ol
	JOIN tmp_c_charge c ON ol.c_charge_id = c.c_charge_id
	JOIN tmp_bh_charge_info ci ON ci.c_charge_id = c.c_charge_id
	JOIN tmp_payments_to_charges ptc ON ptc.charge_name = c.name AND ptc.c_order_id = ol.c_order_id
	JOIN tmp_payments_to_map ptm ON ptm.c_payment_id = ptc.c_payment_id
WHERE ptc.needs_information = 'Y';

INSERT INTO c_orderline (
	c_orderline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_order_id,
	line,
	c_bpartner_id,
	c_bpartner_location_id,
	dateordered,
	datepromised,
	datedelivered,
	description,
	m_warehouse_id,
	c_uom_id,
	qtyordered,
	qtydelivered,
	qtyinvoiced,
	c_currency_id,
	priceactual,
	linenetamt,
	c_charge_id,
	c_tax_id,
	processed,
	qtyentered,
	priceentered,
	c_orderline_uu
)
SELECT
	c_orderline_id,
	ad_client_id,
	ad_org_id,
	createdby,
	updatedby,
	c_order_id,
	line,
	c_bpartner_id,
	c_bpartner_location_id,
	dateordered,
	datepromised,
	datedelivered,
	description,
	m_warehouse_id,
	c_uom_id,
	qtyordered,
	qtydelivered,
	qtyinvoiced,
	c_currency_id,
	priceactual,
	linenetamt,
	c_charge_id,
	c_tax_id,
	processed,
	qtyentered,
	priceentered,
	c_orderline_uu
FROM tmp_c_orderline;

INSERT INTO bh_orderline_charge_info (
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_orderline_charge_info_id,
	bh_orderline_charge_info_uu,
	c_orderline_id,
	created,
	createdby,
	description,
	isactive,
	name,
	updated,
	updatedby
)
SELECT
	ad_client_id,
	ad_org_id,
	bh_charge_info_id,
	bh_orderline_charge_info_id,
	bh_orderline_charge_info_uu,
	c_orderline_id,
	created,
	createdby,
	description,
	isactive,
	name,
	updated,
	updatedby
FROM tmp_bh_orderline_charge_info;

-- Update the grand total lines on the orders we added information to
DROP TABLE IF EXISTS tmp_c_order;
SELECT
	c_order_id,
	SUM(linenetamt) as linenetamt
INTO TEMP TABLE tmp_c_order
FROM c_orderline
WHERE c_order_id IN (SELECT c_order_id FROM tmp_payments_to_map)
GROUP BY c_order_id;

UPDATE c_order o
SET totallines = tmp_o.linenetamt, grandtotal = tmp_o.linenetamt
FROM tmp_c_order tmp_o
WHERE tmp_o.c_order_id = o.c_order_id;

-- Update the sequences
SELECT update_sequences();

-- Since the sequence updates also need the columns (which we didn't insert here), we're just going to update the sequences manually
UPDATE ad_sequence
SET currentnext = (SELECT MAX(BH_ChargeTypeDefault_id) + 1 FROM BH_ChargeTypeDefault)
WHERE name = 'BH_ChargeTypeDefault';
UPDATE ad_sequence
SET currentnext = (SELECT MAX(BH_Charge_Info_Suggestion_id) + 1 FROM BH_Charge_Info_Suggestion)
WHERE name = 'BH_Charge_Info_Suggestion';
UPDATE ad_sequence
SET currentnext = (SELECT MAX(BH_Charge_Info_Values_Suggestion_id) + 1 FROM BH_Charge_Info_Values_Suggestion)
WHERE name = 'BH_Charge_Info_Values_Suggestion';

-- Delete the current c_payments that were mapped so we don't have douple the number of charges
DELETE FROM c_allocationline al
USING c_payment p
WHERE al.c_payment_id = p.c_payment_id
  AND p.tendertype IN ('V', 'U', 'N', 'i', 'B', 'G', 'H', 'O')
	AND p.ad_client_id > 999999;

UPDATE c_order o
SET c_payment_id = NULL
FROM c_payment p
WHERE p.c_payment_id = o.c_payment_id
    AND tendertype IN ('V', 'U', 'N', 'i', 'B', 'G', 'H', 'O')
	AND p.ad_client_id > 999999;

UPDATE c_invoice i
SET c_payment_id = NULL
FROM c_payment p
WHERE p.c_payment_id = i.c_payment_id
    AND tendertype IN ('V', 'U', 'N', 'i', 'B', 'G', 'H', 'O')
	AND p.ad_client_id > 999999;

DELETE FROM c_payment
WHERE tendertype IN ('V', 'U', 'N', 'i', 'B', 'G', 'H', 'O')
	AND ad_client_id > 999999;

SELECT register_migration_script('202105051351_GO-1650.sql') FROM dual;
