-- Ensure ad_sequence is correct for starters (I think it was missed in a previous script)
UPDATE ad_sequence
SET currentnext = (SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence)
WHERE name = 'AD_Sequence';


/**********************************************************************************************************/
-- Create new UI button tables
/**********************************************************************************************************/
create table if not exists bh_uibutton
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	bh_uibutton_id numeric(10) not null,
	bh_uibutton_uu varchar(36),
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255),
	isactive char default 'Y'::bpchar not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	cssvariablename varchar(100) default NULL::character varying not null,
	constraint bh_uibutton_key
		primary key (bh_uibutton_id),
	constraint bh_uibutton_uu_idx
		unique (bh_uibutton_uu),
	constraint adclient_bhuibutton
		foreign key (ad_client_id) references ad_client,
	constraint adorg_bhuibutton
		foreign key (ad_org_id) references ad_org,
	constraint bh_uibutton_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Insert a record into AD_Sequence
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT currentnext FROM ad_sequence WHERE name = 'AD_Sequence'), 0, 0, 'Y', 1001875, 1001875, 'BH_UIButton', 'Table BH_UIButton', null, 'Y', 1, 1000000, 1000014, 200000, 'N', 'Y', null, null, 'N', null, null, '96263e1e-b946-4eaa-b3f9-aab99db9f6b5', 'N', 'N', null)
ON CONFLICT DO NOTHING;
UPDATE ad_sequence
SET currentnext = (SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence)
WHERE name = 'AD_Sequence';

-- Create the UI Button translation table
create table if not exists bh_uibutton_trl
(
	ad_client_id numeric(10) not null,
	ad_language varchar(6) not null,
	ad_org_id numeric(10) not null,
	bh_uibutton_id numeric(10) not null,
	bh_uibutton_trl_uu varchar(36),
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255),
	help varchar(2000),
	isactive char default 'Y'::bpchar not null,
	istranslated char not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint pk_bh_uibutton_trl
		primary key (bh_uibutton_id, ad_language),
	constraint bh_uibutton_trl_uu_idx
		unique (bh_uibutton_trl_uu),
	constraint adlanguage_bhuibuttontrl
		foreign key (ad_language) references ad_language,
	constraint bhuibutton_bhuibuttontrl
		foreign key (bh_uibutton_id) references bh_uibutton,
	constraint bh_uibutton_trl_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar])),
	constraint bh_uibutton_trl_istranslated_check
		check (istranslated = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Insert a record into AD_Sequence
INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES ((SELECT currentnext FROM ad_sequence WHERE name = 'AD_Sequence'), 0, 0, 'Y', 1001875, 1001875, 'BH_UIButton_Trl', 'Table BH_UIButton_Trl', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'd6bfb9f6-3cb3-4994-a8f1-193b2ac7d864', 'N', 'N', null)
ON CONFLICT DO NOTHING;
UPDATE ad_sequence
SET currentnext = (SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence)
WHERE name = 'AD_Sequence';

-- Insert data into the UI Buttons table
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000000, '99c65ce4-4648-40af-a518-6f06d90c761b', '2019-03-20 15:41:21.057000', 100, null, 'Y', 'More Options', '2019-03-20 15:41:21.057000', 100, '--search-more-options') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000001, 'e161a52a-7d50-4025-8af1-51a7ee6757c9', '2019-03-20 15:41:21.103000', 100, 'Cancel button', 'Y', 'Cancel', '2019-03-20 15:41:21.103000', 100, '--button-text-cancel') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000002, 'a9b436b0-3e5d-4304-9282-153060c16bf9', '2019-03-20 15:41:21.124000', 100, null, 'Y', 'Customize', '2019-03-20 15:41:21.124000', 100, '--button-text-customize') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000003, '84c35135-825f-4fce-ac8f-7c3dd1f82e96', '2019-03-20 15:41:21.143000', 100, null, 'Y', 'Delete', '2019-03-20 15:41:21.143000', 100, '--button-text-delete') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000004, '08b5c514-dc23-48ce-a67d-9850ef54035f', '2019-03-20 15:41:21.171000', 100, null, 'Y', 'History', '2019-03-20 15:41:21.171000', 100, '--button-text-history') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000005, 'b7389485-2f78-49af-89ec-caa22b0b6c22', '2019-03-20 15:41:21.190000', 100, null, 'Y', 'New', '2019-03-20 15:41:21.190000', 100, '--button-text-new') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000006, '071adae4-192b-456f-84cf-ac6ad549768f', '2019-03-20 15:41:21.218000', 100, null, 'Y', 'OK', '2019-03-20 15:41:21.218000', 100, '--button-text-ok') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000007, 'bdd01d6b-e5c8-47be-9f52-30b668e18620', '2019-03-20 15:41:21.237000', 100, null, 'Y', 'Prod. Attr.', '2019-03-20 15:41:21.237000', 100, '--button-text-product-attributes') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000008, '37919a3e-9a92-4034-b9ec-cb0b97c6c0d3', '2019-03-20 15:41:21.258000', 100, null, 'Y', 'Refresh', '2019-03-20 15:41:21.258000', 100, '--button-text-refresh') ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton (ad_client_id, ad_org_id, bh_uibutton_id, bh_uibutton_uu, created, createdby, description, isactive, name, updated, updatedby, cssvariablename) VALUES (0, 0, 1000009, 'a965914d-562a-4a05-822b-e060d3c723be', '2019-03-20 15:41:21.277000', 100, null, 'Y', 'Reset', '2019-03-20 15:41:21.277000', 100, '--button-text-reset') ON CONFLICT DO NOTHING;

-- Insert the UI Buttons translations
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000000, 'c1301eed-c81c-40b3-b924-942142e6e261', '2019-03-20 15:41:21.057000', 100, null, null, 'Y', 'N', 'More Options', '2019-03-20 15:41:21.057000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000001, '54597735-2724-480d-93ab-f239aa9de761', '2019-03-20 15:41:21.103000', 100, null, null, 'Y', 'N', 'Cancel', '2019-03-20 15:41:21.103000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000002, 'afaa3a69-a0c1-43b1-ac6b-04782dc6f2c7', '2019-03-20 15:41:21.124000', 100, null, null, 'Y', 'N', 'Customize', '2019-03-20 15:41:21.124000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000003, 'cc15a711-d568-42d9-80f4-b998288f0eff', '2019-03-20 15:41:21.143000', 100, null, null, 'Y', 'N', 'Delete', '2019-03-20 15:41:21.143000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000004, 'aef0e1ae-e8c6-488f-a6c0-03a9f3cd3c91', '2019-03-20 15:41:21.171000', 100, null, null, 'Y', 'N', 'History', '2019-03-20 15:41:21.171000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000005, 'd9765edd-0f3f-470d-a4fb-be9ff5981554', '2019-03-20 15:41:21.190000', 100, null, null, 'Y', 'N', 'New', '2019-03-20 15:41:21.190000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000006, '62fe72ca-2712-4c78-96e9-cb55d2aa7d9c', '2019-03-20 15:41:21.218000', 100, null, null, 'Y', 'N', 'OK', '2019-03-20 15:41:21.218000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000007, '8f214822-2d7c-4974-aa26-8b8e15b4a32d', '2019-03-20 15:41:21.237000', 100, null, null, 'Y', 'N', 'Prod. Attr.', '2019-03-20 15:41:21.237000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000008, 'f2e90830-b4e0-445a-aa88-66033ccc17dc', '2019-03-20 15:41:21.258000', 100, null, null, 'Y', 'N', 'Refresh', '2019-03-20 15:41:21.258000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000009, '8fbcbe16-6ab5-4fc9-b80a-97cae66e29da', '2019-03-20 15:41:21.277000', 100, null, null, 'Y', 'N', 'Reset', '2019-03-20 15:41:21.277000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000010, '6d771a28-4f5b-4b2b-af02-515c230dfda8', '2019-03-20 15:41:21.298000', 100, null, null, 'Y', 'N', 'Results', '2019-03-20 15:41:21.298000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000011, '1c801725-4cc4-4232-986c-083b6b42719e', '2019-03-20 15:41:21.317000', 100, null, null, 'Y', 'N', 'Save', '2019-03-20 15:41:21.317000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000012, '10494325-cd7a-48f1-921f-d70b89925247', '2019-03-20 15:41:21.337000', 100, null, null, 'Y', 'N', 'Search', '2019-03-20 15:41:21.337000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'es_CO', 0, 1000013, '89c881b9-f939-4a57-ab01-cea348fdaecf', '2019-03-20 15:41:21.358000', 100, null, null, 'Y', 'N', 'Zoom', '2019-03-20 15:41:21.358000', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000013, 'd53226f2-d7a9-4fd0-a8e9-e9c136caf610', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Zoom', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000012, 'da4664db-4980-4890-b432-3b9b9705c484', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Search', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000011, '6909d7c9-92c0-4583-bd9b-48313eebc5a7', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Save', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000010, 'ff6810ae-72bc-494a-bbd7-a348de1b14b4', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Results', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000009, 'b6526a2f-3295-47cd-804f-5c6d9b4c3212', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Reset', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000008, '01acadad-35fa-4ce6-8a50-3d53eec5810a', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Refresh', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000007, 'e25fca11-5aa4-4a19-994c-ce24ecda2aaa', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Prod. Attr.', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000006, 'a247d352-371c-4741-9b63-6f2bc437afd6', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'OK', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000005, '9d8e5765-3ece-48a9-96fb-75ecf3ce01ee', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'New', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000004, '28b60150-0458-433f-b053-06722309832b', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'History', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000003, 'e371259e-90a5-4240-96ba-e6f6e9eba626', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Delete', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000002, '5fa412b6-6605-4dda-bfbc-6b6bd5d0daa6', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Customize', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000001, '5507ae2b-eef5-4aa7-a3cc-f8ed0f5005b7', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'Cancel', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;
INSERT INTO bh_uibutton_trl (ad_client_id, ad_language, ad_org_id, bh_uibutton_id, bh_uibutton_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby) VALUES (0, 'fr_FR', 0, 1000000, '2d78e508-0897-43b4-a8d8-2c233bc4ce48', '2019-03-20 16:01:10.829702', 100, null, null, 'Y', 'N', 'More Options', '2019-03-20 16:01:10.829702', 100) ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Rename the Home Screen Button Tables
/**********************************************************************************************************/
ALTER TABLE IF EXISTS bh_hmscrn_buttongroup RENAME COLUMN bh_hmscrn_buttongroup_id TO bh_dbrdbtngrp_id;
ALTER TABLE IF EXISTS bh_hmscrn_buttongroup RENAME COLUMN bh_hmscrn_buttongroup_uu TO bh_dbrdbtngrp_uu;
ALTER TABLE IF EXISTS bh_hmscrn_buttongroup RENAME TO bh_dbrdbtngrp;

-- Don't forget to update ad_sequence
UPDATE ad_sequence
SET name = 'BH_DbrdBtnGrp', description = 'Table BH_DbrdBtnGrp'
WHERE name = 'BH_HmScrn_ButtonGroup';

-- Also, ad_table and ad_column need to be fixed as well
UPDATE ad_table
SET name = 'BH_DbrdBtnGrp', tablename = 'BH_DbrdBtnGrp'
WHERE ad_table_uu = 'ae04c83f-2010-4037-bd42-e6f15a857823';

UPDATE ad_column
SET columnname = 'BH_DbrdBtnGrp_ID'
WHERE columnname = 'BH_HmScrn_ButtonGroup_ID';
UPDATE ad_column
SET columnname = 'BH_DbrdBtnGrp_UU'
WHERE columnname = 'BH_HmScrn_ButtonGroup_UU';

ALTER TABLE IF EXISTS bh_hmscrn_buttongroupline RENAME COLUMN bh_hmscrn_buttongroupline_id TO bh_dbrdbtngrp_btn_id;
ALTER TABLE IF EXISTS bh_hmscrn_buttongroupline RENAME COLUMN bh_hmscrn_buttongroupline_uu TO bh_dbrdbtngrp_btn_uu;
ALTER TABLE IF EXISTS bh_hmscrn_buttongroupline RENAME COLUMN bh_hmscrn_buttongroup_id TO bh_dbrdbtngrp_id;
ALTER TABLE IF EXISTS bh_hmscrn_buttongroupline RENAME TO bh_dbrdbtngrp_btn;

-- Don't forget to update ad_sequence
UPDATE ad_sequence
SET name = 'BH_DbrdBtnGrp_Btn', description = 'Table BH_DbrdBtnGrp_Btn'
WHERE name = 'BH_HmScrn_ButtonGroupLine';

-- Also, ad_table and ad_column need to be fixed as well
UPDATE ad_table
SET name = 'BH_DbrdBtnGrp_Btn', tablename = 'BH_DbrdBtnGrp_Btn'
WHERE ad_table_uu = 'bdfcbd0c-4810-4d63-a5b6-3c6ca2119b11';

UPDATE ad_column
SET columnname = 'BH_DbrdBtnGrp_Btn_ID'
WHERE columnname = 'BH_HmScrn_ButtonGroupLine_ID';
UPDATE ad_column
SET columnname = 'BH_DbrdBtnGrp_Btn_UU'
WHERE columnname = 'BH_HmScrn_ButtonGroupLine_UU';

/**********************************************************************************************************/
-- Add translation tables for the (former) home screen buttons
/**********************************************************************************************************/
create table if not exists bh_dbrdbtngrp_trl
(
	ad_client_id numeric(10) not null,
	ad_language varchar(6) not null,
	ad_org_id numeric(10) not null,
	bh_dbrdbtngrp_id numeric(10) not null,
	bh_dbrdbtngrp_trl_uu varchar(36),
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255),
	help varchar(2000),
	isactive char default 'Y'::bpchar not null,
	istranslated char not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	bh_dbrdbtngrp_trl_id numeric(10),
	constraint pk_bh_dbrdbtngrp_trl
		primary key (bh_dbrdbtngrp_id, ad_language),
	constraint bh_dbrdbtngrp_trl_uu_idx
		unique (bh_dbrdbtngrp_trl_uu),
	constraint adlanguage_bhdbrdbtngrptrl
		foreign key (ad_language) references ad_language,
	constraint bhdbrdbtngrp_bhdbrdbtngrptrl
		foreign key (bh_dbrdbtngrp_id) references bh_dbrdbtngrp,
	constraint bh_dbrdbtngrp_trl_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar])),
	constraint bh_dbrdbtngrp_trl_istranslated_check
		check (istranslated = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES (1000214, 0, 0, 'Y', '2019-03-20 15:39:51.091000', 100, '2019-03-20 15:39:51.091000', 100, 'BH_DbrdBtnGrp_Trl', 'Table BH_DbrdBtnGrp_Trl', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, '955ed774-aa59-46f5-95ae-69cb9a039a0c', 'N', 'N', null)
ON CONFLICT DO NOTHING;
UPDATE ad_sequence
SET currentnext = (SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence)
WHERE name = 'AD_Sequence';

create table if not exists bh_dbrdbtngrp_btn_trl
(
	ad_client_id numeric(10) not null,
	ad_language varchar(6) not null,
	ad_org_id numeric(10) not null,
	bh_dbrdbtngrp_btn_trl_uu varchar(36),
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	description varchar(255),
	help varchar(2000),
	isactive char default 'Y'::bpchar not null,
	istranslated char not null,
	name varchar(60) not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	bh_dbrdbtngrp_btn_id numeric(10) not null,
	buttonhelptext varchar(100),
	buttontext varchar(100),
	bh_dbrdbtngrp_btn_trl_id numeric(10),
	constraint pk_bh_dbrdbtngrp_btn_trl
		primary key (bh_dbrdbtngrp_btn_id, ad_language),
	constraint bh_dbrdbtngrp_btn_trl_uu_idx
		unique (bh_dbrdbtngrp_btn_trl_uu),
	constraint adlanguage_bhdbrdbtngrpbtntrl
		foreign key (ad_language) references ad_language,
	constraint bhdbrdbtngr_bhdbrdbtngrpbtntrl
		foreign key (bh_dbrdbtngrp_btn_id) references bh_dbrdbtngrp_btn,
	constraint bh_dbrdbtngrp_btn_trl_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar])),
	constraint bh_dbrdbtngrp_btn_trl_istranslated_check
		check (istranslated = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

INSERT INTO ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited, istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth, isorglevelsequence, orgcolumn) VALUES (1000215, 0, 0, 'Y', '2019-03-20 15:39:52.570000', 100, '2019-03-20 15:39:52.570000', 100, 'BH_DbrdBtnGrp_Btn_Trl', 'Table BH_DbrdBtnGrp_Btn_Trl', null, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', null, null, 'N', null, null, 'de74978e-0085-4f29-bd55-359902ce1e45', 'N', 'N', null)
ON CONFLICT DO NOTHING;
UPDATE ad_sequence
SET currentnext = (SELECT MAX(ad_sequence_id) + 1 FROM ad_sequence)
WHERE name = 'AD_Sequence';

/**********************************************************************************************************/
-- Insert translation data for the (former) home screen buttons
/**********************************************************************************************************/
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000005, '40c4629e-60b7-4335-b3bf-e1824bd8917d', '2019-03-20 16:01:10.749312', 100, null, null, 'Y', 'N', 'Metrics', '2019-03-20 16:01:10.749312', 100, null) ON CONFLICT DO NOTHING;
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000006, '9066ca4f-c143-4ec4-81a0-4e79eaebeafe', '2019-03-20 16:01:10.749312', 100, null, null, 'Y', 'N', 'Pharmacy and Stores', '2019-03-20 16:01:10.749312', 100, null) ON CONFLICT DO NOTHING;
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000002, '63c7afc3-ec2c-4ca6-9728-54f8a1186f30', '2019-03-20 16:01:10.749312', 100, null, null, 'Y', 'N', 'Cashier and Accounts', '2019-03-20 16:01:10.749312', 100, null) ON CONFLICT DO NOTHING;
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000001, 'f0d2579f-0336-4cb4-b20a-ecb9ce3a060a', '2019-03-20 16:01:10.749312', 100, null, null, 'Y', 'N', 'My Products Services and Expenses', '2019-03-20 16:01:10.749312', 100, null) ON CONFLICT DO NOTHING;
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000000, '4c2b7882-34e6-485c-967c-3a0e25339985', '2019-03-20 16:01:10.749312', 100, null, null, 'Y', 'N', 'Patients and Suppliers', '2019-03-20 16:01:10.749312', 100, null) ON CONFLICT DO NOTHING;
INSERT INTO bh_dbrdbtngrp_trl (ad_client_id, ad_language, ad_org_id, bh_dbrdbtngrp_id, bh_dbrdbtngrp_trl_uu, created, createdby, description, help, isactive, istranslated, name, updated, updatedby, bh_dbrdbtngrp_trl_id) VALUES (0, 'fr_FR', 0, 1000003, '36a25654-393d-4199-b7cc-c1223798a455', '2019-07-16 13:29:23.369000', 0, null, null, 'Y', 'N', 'Reports', '2019-07-16 13:29:23.369000', 0, null) ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update btn descriptions so that the URLs work in GL on all DBs
/**********************************************************************************************************/

/**********************************************************************************************************/
-- Finish
/**********************************************************************************************************/
SELECT register_migration_script('202011191559_GO-1446.sql') FROM dual;
