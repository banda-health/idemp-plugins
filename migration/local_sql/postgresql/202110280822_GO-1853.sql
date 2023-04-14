/*--Export triage master role*/
INSERT INTO adempiere.ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype)VALUES ((SELECT MAX(ad_role_id) + 1 FROM ad_role), 0, 0, 'Y', '2021-10-27 20:12:08.602000', 100, '2021-10-27 20:14:07.501000', 'Triage', 100, 'A master role for triage users', 'S  ', null, 0, null, 'Y', 'N', 'N', 'N', 'Y', 'Y', null, 'N', 'N', 'N', 'O', 'N', 'N', null, 0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', 0, 0, 'ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'N', 'Y', 'Y', null)ON CONFLICT DO NOTHING;

--Create vitals details access window/tab for role
INSERT INTO adempiere.ad_window (ad_window_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, windowtype, issotrx, entitytype, processing, ad_image_id, ad_color_id, isdefault, winheight, winwidth, isbetafunctionality, ad_window_uu, titlelogic)VALUES ((SELECT MAX(ad_window_id) + 1 FROM ad_window), 0, 0, 'Y', '2021-10-28 09:39:07.474000', 100, '2021-10-28 09:39:20.623000', 100, 'Clinical Vitals', 'Access window for the triage role', null, 'M', 'Y', 'U', 'N', null, null, 'N', 0, 0, 'N', '53b4d743-c311-40e5-aa8e-c0880c42c1b1', null)ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_tab (ad_tab_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_table_id, ad_window_id, seqno, tablevel, issinglerow, isinfotab, istranslationtab, isreadonly, ad_column_id, hastree, whereclause, orderbyclause, commitwarning, ad_process_id, processing, ad_image_id, importfields, ad_columnsortorder_id, ad_columnsortyesno_id, issorttab, entitytype, included_tab_id, readonlylogic, displaylogic, isinsertrecord, isadvancedtab, parent_column_id, ad_tab_uu, ad_ctxhelp_id, treedisplayedon, maxqueryrecords)VALUES ((SELECT MAX(ad_tab_id) + 1 FROM ad_tab), 0, 0, 'Y', '2021-10-28 09:40:09.222000', 100, '2021-10-28 09:40:09.222000', 100, 'Vitals Details', null, null, 259, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '53b4d743-c311-40e5-aa8e-c0880c42c1b1'), 10, 0, 'Y', 'N', 'N', 'N', null, 'N', null, null, null, null, 'N', null, 'N', null, null, 'N', 'U', null, null, null, 'Y', 'N', null, '789a08af-2015-4469-b2ef-d4ca55e6f2e7', null, 'B', 0)ON CONFLICT DO NOTHING;

--provide window access for triage role
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate)VALUES ((SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'), (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf'), 0, 0, 'Y', '2021-10-27 20:17:44.316000', 100, '2021-10-27 20:17:44.316000', 100, 'Y', '80c4d35a-34cd-4107-a357-37abd5f8c9f5', 'N')ON CONFLICT DO NOTHING;

-- Util function that adds the new role to all existing clients and includes it as a default role for
-- new clients.
-- Params: ad_role_to_add_uu : Role uuid of the new master role.
--         db_user_type: user_type key to be used in ad_reflist for association with the role
CREATE OR REPLACE FUNCTION add_roles_to_clients(ad_role_to_add_uu UUID, user_type VARCHAR(1)) RETURNS VOID
	LANGUAGE plpgsql
AS $$
    DECLARE
        clients_updated integer := 0;
BEGIN
    DROP TABLE IF EXISTS tmp_ad_role;
    CREATE TEMP TABLE tmp_ad_role(ad_role_id serial not null,ad_client_id numeric(10) not null,ad_org_id numeric(10) not null,
    isactive char default 'Y'::bpchar not null,created timestamp default now() not null,createdby numeric(10) not null,
    updated timestamp default now() not null,name varchar(255) not null,updatedby numeric(10) not null,description varchar(255),
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
           roletype FROM tmp_ad_role ON CONFLICT DO NOTHING;

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

    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole),'83c3e42d-e1bb-47cb-b948-e985b2d5d943', '2021-11-17 13:34:25.505000', 100, user_type, null, 'Y', null, '2021-11-17 13:34:25.505000', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf')) ON CONFLICT DO NOTHING;
    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, created, createdby, db_usertype, description, isactive, name, updated, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM bh_defaultincludedrole),'0bb7f075-cb07-45aa-b488-bb8046369b78', '2021-11-17 13:34:08.893000', 100, user_type, null, 'Y', null, '2021-11-17 13:34:08.893000', 100, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a')) ON CONFLICT DO NOTHING;

    RAISE NOTICE 'New user role added to % clients', clients_updated;
END;
$$;

--call procedure to add triage role to clients
select add_roles_to_clients('ae618e24-a47a-40cc-bb5c-8dca64d86daf', 'T');

SELECT register_migration_script('202110280822_GO-1853.sql') FROM dual;
