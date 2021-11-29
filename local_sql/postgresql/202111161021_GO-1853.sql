-- Util function that adds the new role to all existing clients and includes it as a default role for
-- new clients.
-- Params: ad_role_to_add_uu : Role uuid of the new master role.
--         db_user_type: user_type key to be used in ad_reflist for association with the role
CREATE OR REPLACE FUNCTION add_roles_to_clients(ad_role_to_add_uu UUID, user_type VARCHAR(60)) RETURNS VOID
	LANGUAGE plpgsql
AS $$
    DECLARE
        clients_updated integer := 0;
BEGIN
    DROP TABLE IF EXISTS tmp_ad_role;
    CREATE TEMP TABLE tmp_ad_role(ad_role_id serial not null,ad_client_id numeric(10) not null,ad_org_id numeric(10) not null,
    isactive char default 'Y'::bpchar not null,created timestamp default now() not null,createdby numeric(10) not null,
    updated timestamp default now() not null,name varchar(60) not null,updatedby numeric(10) not null,description varchar(255),
    userlevel char(3) default '  O'::bpchar not null,c_currency_id numeric(10),amtapproval numeric default 0,ad_tree_menu_id numeric(10),
    ismanual char default 'Y'::bpchar not null,isshowacct char default 'Y'::bpchar not null,ispersonallock char default 'N'::bpchar not null,
    ispersonalaccess char default 'N'::bpchar not null,iscanexport char default 'Y'::bpchar not null,
    iscanreport char default 'Y'::bpchar not null,supervisor_id numeric(10),iscanapproveowndoc char default 'Y'::bpchar not null,
    isaccessallorgs char default 'N'::bpchar not null,ischangelog char default 'N'::bpchar not null,preferencetype char default 'C'::bpchar not null,
    overwritepricelimit char default 'N'::bpchar not null,isuseuserorgaccess char default 'N'::bpchar not null,ad_tree_org_id numeric(10),
    confirmqueryrecords numeric(10) default 0 not null,maxqueryrecords numeric(10) default 0 not null,connectionprofile char,
    allow_info_account char default 'Y'::bpchar not null,allow_info_asset char default 'Y'::bpchar not null,
    allow_info_bpartner char default 'Y'::bpchar not null,allow_info_cashjournal char default 'N'::bpchar not null,
    allow_info_inout char default 'Y'::bpchar not null,allow_info_invoice char default 'Y'::bpchar not null,
    allow_info_order char default 'Y'::bpchar not null,allow_info_payment char default 'Y'::bpchar not null,
    allow_info_product char default 'Y'::bpchar not null,allow_info_resource char default 'Y'::bpchar not null,
    allow_info_schedule char default 'Y'::bpchar not null,userdiscount numeric(22,2),allow_info_mrp char default 'N'::bpchar not null,
    allow_info_crp char default 'N'::bpchar not null,isdiscountuptolimitprice char default 'N'::bpchar not null,
    isdiscountallowedontotal char default 'N'::bpchar not null,amtapprovalaccum numeric,daysapprovalaccum numeric(10),
    ad_role_uu uuid NOT NULL DEFAULT uuid_generate_v4(),ismenuautoexpand char default 'N'::bpchar not null,
    ismasterrole char default 'N'::bpchar not null,isaccessadvanced char default 'N'::bpchar,roletype varchar(2) default NULL::character varying);

    PERFORM setval('tmp_ad_role_ad_role_id_seq', (SELECT currentnext FROM ad_sequence WHERE name = 'AD_Role' LIMIT 1)::INT, false);

    -- Extract into a temp table all non-system clients and create responsibility role for each client in
    -- the format '<Client_Name> Role_Name'
    INSERT INTO tmp_ad_role (ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description, userlevel,
                             c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock,
                             ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc,
                             isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess,
                             ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile,
                             allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal,
                             allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment,
                             allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp,
                             allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum,
                             daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)
    SELECT c.ad_client_id,0,'Y',100,c.name || ' ' || r.name,100,null,'  O',null,0,null,'N','N','N','N','Y','Y',null,'Y',
           'N','N','O','N','N',null,0,0,null,'Y','Y','Y','N','Y','Y','Y','Y','Y','Y','Y',null,'N','N','N','N',null,null,
           uuid_generate_v4(),'N','N','N',null FROM ad_client c JOIN ad_role r ON r.ad_role_uu = ad_role_to_add_uu :: TEXT
    WHERE c.ad_client_id > 999999;

    SELECT COUNT(*) FROM tmp_ad_role INTO clients_updated;

    -- Add the created role into ad_roles table
    INSERT INTO ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, createdby, name, updatedby, description,
                         userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock,
                         ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs,
                         ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id,
                         confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset,
                         allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice,
                         allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule,
                         userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal,
                         amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)
    SELECT ad_role_id,ad_client_id,ad_org_id,isactive,createdby,name,updatedby,description,userlevel,c_currency_id,
           amtapproval,ad_tree_menu_id,ismanual,isshowacct,ispersonallock,ispersonalaccess,iscanexport,iscanreport,supervisor_id,
           iscanapproveowndoc,isaccessallorgs,ischangelog,preferencetype,overwritepricelimit,isuseuserorgaccess,ad_tree_org_id,
           confirmqueryrecords,maxqueryrecords,connectionprofile,allow_info_account,allow_info_asset,allow_info_bpartner,
           allow_info_cashjournal,allow_info_inout,allow_info_invoice,allow_info_order,allow_info_payment,allow_info_product,
           allow_info_resource,allow_info_schedule,userdiscount,allow_info_mrp,allow_info_crp,isdiscountuptolimitprice,
           isdiscountallowedontotal,amtapprovalaccum,daysapprovalaccum,ad_role_uu,ismenuautoexpand,ismasterrole,isaccessadvanced,
           roletype FROM tmp_ad_role;

    UPDATE ad_sequence SET currentnext = nextval('tmp_ad_role_ad_role_id_seq') WHERE name = 'AD_Role';

    -- Update the new role to have the same access to org as other responsibility roles have.
    INSERT INTO ad_role_orgaccess (ad_role_id, ad_org_id, ad_client_id, isactive, createdby, updatedby, isreadonly, ad_role_orgaccess_uu)
    SELECT tar.ad_role_id,tar.ad_client_id,ao.ad_org_id,'Y',100,100,'N',uuid_generate_v4() FROM tmp_ad_role tar
        JOIN ad_org ao ON ao.ad_client_id = tar.ad_client_id;

    -- Add the "Must Haves" and "New_Master_Role" to the role
    INSERT INTO ad_role_included (ad_client_id, ad_org_id, ad_role_id, createdby, included_role_id, seqno, updatedby)
    SELECT ad_client_id, 0, tar.ad_role_id, 100, ir.ad_role_id, ir.seqno, 100 FROM tmp_ad_role tar
        CROSS JOIN ( SELECT ad_role_id, 10 as seqno FROM ad_role
        WHERE ad_role_uu = ad_role_to_add_uu :: TEXT UNION SELECT ad_role_id, 20 as seqno
        FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a' ) ir;

    -- Add a user-type ref-list item for the new role to the AD_Role_User_Type table
    INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
                                       updatedby, value, name, description, ad_reference_id, validfrom, validto,
                                       entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all)
    VALUES ((SELECT MAX(ad_ref_list_id) + 1 from ad_ref_list), 0, 0, 'Y', '2021-11-16 20:23:34.401000', 100,
            '2021-11-16 20:24:34.615000', 100, user_type,
            (SELECT name FROM ad_role WHERE ad_role_uu = ad_role_to_add_uu :: TEXT), '',
            (SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'),
            null, null, 'U', 'c12fae5c-0307-41ae-9555-8d283333a11d', null, null)
    ON CONFLICT DO NOTHING;

    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole),'83c3e42d-e1bb-47cb-b948-e985b2d5d943', '2021-11-17 13:34:25.505000', 100, user_type, null, 'Y', null, '2021-11-17 13:34:25.505000', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf'));
    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole),'0bb7f075-cb07-45aa-b488-bb8046369b78', '2021-11-17 13:34:08.893000', 100, user_type, null, 'Y', null, '2021-11-17 13:34:08.893000', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a'));

    RAISE NOTICE 'New user role added to % clients', clients_updated;
END;
$$;

SELECT register_migration_script('202111161021_GO-1853.sql') FROM dual;
