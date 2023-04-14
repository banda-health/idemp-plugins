-- Add clinician roles for existing clients
DROP TABLE IF EXISTS tmp_ad_user_ids;
CREATE TEMP TABLE tmp_ad_user_ids(
	ad_user_id numeric(10,0) NOT NULL
);

-- add clinician role into bh_defaultincludedrole
INSERT INTO bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, createdby, db_usertype, description, isactive, name, updatedby, included_role_id) VALUES (0, 0, (SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 'b50146e2-c05a-48cb-b053-14c9197b6a62', 100, 'C', null, 'Y', null, 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e0a36cce-cf9f-456b-a431-71bc41285983')) ON CONFLICT DO NOTHING;
INSERT INTO bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, createdby, db_usertype, description, isactive, name, updatedby, included_role_id) VALUES (0, 0, (SELECT MAX(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole), 'd90353f7-d29c-4cdc-b859-5c3a9916b654', 100, 'C', null, 'Y', null, 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '6c608685-6874-47e1-9c55-06a62f67f340')) ON CONFLICT DO NOTHING;

DROP TABLE IF EXISTS tmp_ad_role;
CREATE TEMP TABLE tmp_ad_role
(
	ad_role_id serial not null,
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	isactive char default 'Y'::bpchar not null,
	created timestamp default now() not null,
	createdby numeric(10) not null,
	updated timestamp default now() not null,
	name varchar(60) not null,
	updatedby numeric(10) not null,
	description varchar(255),
	userlevel char(3) default '  O'::bpchar not null,
	c_currency_id numeric(10),
	amtapproval numeric default 0,
	ad_tree_menu_id numeric(10),
	ismanual char default 'Y'::bpchar not null,
	isshowacct char default 'Y'::bpchar not null,
	ispersonallock char default 'N'::bpchar not null,
	ispersonalaccess char default 'N'::bpchar not null,
	iscanexport char default 'Y'::bpchar not null,
	iscanreport char default 'Y'::bpchar not null,
	supervisor_id numeric(10),
	iscanapproveowndoc char default 'Y'::bpchar not null,
	isaccessallorgs char default 'N'::bpchar not null,
	ischangelog char default 'N'::bpchar not null,
	preferencetype char default 'C'::bpchar not null,
	overwritepricelimit char default 'N'::bpchar not null,
	isuseuserorgaccess char default 'N'::bpchar not null,
	ad_tree_org_id numeric(10),
	confirmqueryrecords numeric(10) default 0 not null,
	maxqueryrecords numeric(10) default 0 not null,
	connectionprofile char,
	allow_info_account char default 'Y'::bpchar not null,
	allow_info_asset char default 'Y'::bpchar not null,
	allow_info_bpartner char default 'Y'::bpchar not null,
	allow_info_cashjournal char default 'N'::bpchar not null,
	allow_info_inout char default 'Y'::bpchar not null,
	allow_info_invoice char default 'Y'::bpchar not null,
	allow_info_order char default 'Y'::bpchar not null,
	allow_info_payment char default 'Y'::bpchar not null,
	allow_info_product char default 'Y'::bpchar not null,
	allow_info_resource char default 'Y'::bpchar not null,
	allow_info_schedule char default 'Y'::bpchar not null,
	userdiscount numeric(22,2),
	allow_info_mrp char default 'N'::bpchar not null,
	allow_info_crp char default 'N'::bpchar not null,
	isdiscountuptolimitprice char default 'N'::bpchar not null,
	isdiscountallowedontotal char default 'N'::bpchar not null,
	amtapprovalaccum numeric,
	daysapprovalaccum numeric(10),
	ad_role_uu uuid NOT NULL DEFAULT uuid_generate_v4(),
	ismenuautoexpand char default 'N'::bpchar not null,
	ismasterrole char default 'N'::bpchar not null,
	isaccessadvanced char default 'N'::bpchar,
	roletype varchar(2) default NULL::character varying
);

SELECT setval(
	'tmp_ad_role_ad_role_id_seq',
	(
		SELECT currentnext
		FROM ad_sequence
		WHERE name = 'AD_Role'
		LIMIT 1
	)::INT,
	false
);

-- Set user with new role (Jeremy User)
INSERT INTO tmp_ad_user_ids
SELECT ad_user_id
FROM ad_user
WHERE name = 'Jeremy Ogembo'
ORDER BY ad_user_id
LIMIT 1;

-- Insert the new AD roles into a temporary table for all clients but System
INSERT INTO tmp_ad_role (
ad_client_id, ad_org_id, createdby, name, updatedby, description, c_currency_id, ad_tree_menu_id, supervisor_id, ad_tree_org_id, connectionprofile, userdiscount, amtapprovalaccum, daysapprovalaccum,ad_role_uu)
SELECT ad_client_id, 0, 100, name || ' Clinician User', 100, null, null, null, null, null, null, null,  null, null, uuid_generate_v4()
FROM ad_client
WHERE ad_client_id IN (SELECT ad_client_id FROM ad_client where isactive = 'Y' and ad_client_id > 999999);

-- Insert into the AD_Role from tmp
INSERT INTO ad_role (ad_role_id, ad_client_id, ad_org_id, createdby, name, updatedby, description, c_currency_id, ad_tree_menu_id, supervisor_id, ad_tree_org_id, connectionprofile, userdiscount, amtapprovalaccum, daysapprovalaccum,ad_role_uu)
SELECT ad_role_id, ad_client_id, ad_org_id, createdby, name, updatedby, description, c_currency_id, ad_tree_menu_id, supervisor_id, ad_tree_org_id, connectionprofile, userdiscount, amtapprovalaccum, daysapprovalaccum,ad_role_uu
FROM tmp_ad_role;

UPDATE ad_sequence
SET currentnext = nextval('tmp_ad_role_ad_role_id_seq')
WHERE name = 'AD_Role';

-- Next, update ad_role_orgaccess
INSERT INTO ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, createdby, updatedby, ad_role_orgaccess_uu)
SELECT tmpAdRole.ad_role_id, ao.ad_org_id, tmpAdRole.ad_client_id, 100, 100, uuid_generate_v4()
FROM tmp_ad_role tmpAdRole
JOIN ad_org ao
	ON ao.ad_client_id = tmpAdRole.ad_client_id;

DROP TABLE tmp_ad_role;
DROP TABLE tmp_ad_user_ids;

SELECT register_migration_script('202101211542_GO-1506.sql') FROM dual;
