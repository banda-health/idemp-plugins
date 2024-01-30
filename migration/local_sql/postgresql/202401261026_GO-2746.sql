-- rename inventory/pharmacy role to inventory/pharmacy advanced
UPDATE adempiere.ad_role SET name = 'Inventory/Pharmacy Advanced', description = 'Inventory and pharmacy advanced role' WHERE AD_Role_UU='ec17fee0-a53a-4dbb-b946-423ce14880eb';

-- remove triage access from advanced role
DELETE FROM adempiere.ad_window_access
WHERE ad_window_id IN (SELECT ad_window_id FROM adempiere.ad_window
        WHERE ad_window_uu IN ( '53b4d743-c311-40e5-aa8e-c0880c42c1b1',  --clinical vitals
                                'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed',  --chief complaint
                                '2e37e97b-aeb5-47d7-add3-0d602233c2aa')) --clinical details
AND ad_role_id = (SELECT ad_role_id FROM adempiere.ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb');

-- update inventory/pharmacy advanced BH_DefaultRole
UPDATE adempiere.AD_Ref_List SET Name = 'Inventory/Pharmacy Advanced' WHERE AD_Ref_List_UU='97001a3c-26e0-46b3-b0d7-b718f7c1a775';

-- update inventory/pharmacy role name across all clients to now include 'Advanced'
UPDATE adempiere.ad_role upd
SET name = a.new_name,
    updatedby = 100,
    updated = CURRENT_TIMESTAMP
FROM (
    SELECT
        r.ad_role_id,
        r.name AS old_name,
        c.name || ' ' || STRING_AGG(master.name, ', ' ORDER BY ri.seqno) AS new_name,
        c.name || ' ' || STRING_AGG(CASE WHEN master.name = 'Inventory/Pharmacy Advanced' THEN 'Inventory/Pharmacy' ELSE master.name END, ', ' ORDER BY ri.seqno) AS expected_old_name
    FROM adempiere.ad_role r
        JOIN adempiere.ad_client c
        ON r.ad_client_id = c.ad_client_id
        JOIN adempiere.ad_role_included ri
        ON ri.ad_role_id = r.ad_role_id
        JOIN adempiere.ad_role master
        ON master.ad_role_id = ri.included_role_id
    WHERE r.ad_client_id NOT IN (0, 11)
      -- Exclude 'Must Haves' from the name
      AND master.ad_role_uu != 'baec9412-d994-4313-815c-31332357863a'
      -- Only update ones where the role includes the modified Inventory/Pharmacy Advanced
      AND r.ad_role_id IN
            (SELECT check_ri.ad_role_id
             FROM adempiere.ad_role_included check_ri
                JOIN adempiere.ad_role check_r
                ON check_ri.included_role_id = check_r.ad_role_id
             WHERE check_r.ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb')
    GROUP BY r.ad_role_id, r.name, c.name
    ORDER BY ad_role_id) a
WHERE upd.ad_role_id = a.ad_role_id
-- If the old role name doesn't match what was expected, maybe it has been customized by
-- someone, so don't updated it
AND a.old_name = a.expected_old_name

-- create inventory/pharmacy basic role
INSERT INTO adempiere.ad_role (ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, name, updatedby, description, userlevel, c_currency_id, amtapproval, ad_tree_menu_id, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport, supervisor_id, iscanapproveowndoc, isaccessallorgs, ischangelog, preferencetype, overwritepricelimit, isuseuserorgaccess, ad_tree_org_id, confirmqueryrecords, maxqueryrecords, connectionprofile, allow_info_account, allow_info_asset, allow_info_bpartner, allow_info_cashjournal, allow_info_inout, allow_info_invoice, allow_info_order, allow_info_payment, allow_info_product, allow_info_resource, allow_info_schedule, userdiscount, allow_info_mrp, allow_info_crp, isdiscountuptolimitprice, isdiscountallowedontotal, amtapprovalaccum, daysapprovalaccum, ad_role_uu, ismenuautoexpand, ismasterrole, isaccessadvanced, roletype) VALUES ((SELECT MAX(AD_Role_ID)+1 FROM AD_Role), 0, 0, 'Y', '2024-01-26 13:42:05.094000', 100, '2024-01-26 13:42:05.094000', 'Inventory/Pharmacy Basic', 100, 'Inventory and pharmacy basic role', 'S  ', null, 0, null, 'Y', 'N', 'N', 'N', 'Y', 'Y', null, 'N', 'N', 'N', 'O', 'N', 'N', null, 0, 0, null, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', null, 'N', 'N', 'N', 'N', 0, 0, 'a1618fd6-e1ab-4e41-a08d-854229cd5971', 'N', 'Y', 'Y', null) ON CONFLICT DO NOTHING;

-- create window access
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='ba697729-5ec8-44f7-b534-446310bb5782'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'N', '21dd9fd7-73cd-428a-8863-943ba306bf3d', 'N') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='565af89e-8f10-4469-84f5-6cca8d7fae27'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', '4659ff54-ccd8-4c0a-b841-9d8a94520ef3', 'Y') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='c63b9972-1b23-4140-8bbb-0ea2b0b81024'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', '5f5b9b8a-0d0d-4136-a8be-079500455107', 'Y') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='fd93da00-871d-4996-a3f7-4528bed8b758'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'N', '196aa1c2-a376-4fa0-a7c1-41a026e1db5b', 'N') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', 'a4eee3c6-9746-48e0-afb2-86f82de5514f', 'N') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', 'f14c25f5-7842-4a49-b1b0-d46864326d43', 'N') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='78dd6f39-84f9-4e19-b08e-7a3441af15e5'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', 'ca1f4e1c-5134-4574-8eba-f90f640a3d00', 'Y') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='d3c84cad-7306-464d-85da-7e629846f8c0'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', '77f4e893-5b3e-4f38-b023-a528ff9e26dc', 'Y') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_window_access_uu, bh_candeactivate) VALUES ((SELECT AD_Window_ID FROM AD_Window WHERE AD_Window_UU='584a4f57-33c6-460e-9916-9ad0347cac5b'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 13:47:10.331000', 100, '2024-01-26 13:47:10.331000', 100, 'Y', 'a5aebd89-a7a0-4415-9a8d-7fddadd3c933', 'Y') ON CONFLICT DO NOTHING;

-- create report/process access
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='30dd7243-11c1-4584-af26-5d977d117c84'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '4c21e882-1375-4cde-8ade-89a09a574bf2') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='1211e173-6f12-4e2f-bfcc-d43d48af51c3'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'ff68f087-ffd0-4302-bb8c-f1af500569b3') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='3edf67b9-ee3d-4b73-a02e-deb1c1811db5'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'c1c447fb-2f16-43fc-b090-4fcf24720e55') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='630fc1ab-0b64-459b-b10f-68549d21f507'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'd90c7224-5521-4a4e-aed8-55aa9fb510be') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='58ae2bdf-0e80-46f2-860f-2ae070fc82d2'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '26d61820-8498-4d8c-83f6-04dd31534358') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='173a691b-ba89-4987-9216-9b3f0a60c864'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '86030f3b-c845-43e6-adc7-967183501682') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='a7ac9f65-45d7-4ae0-80f3-72019de35a4a'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '45193041-021f-40fd-869f-f5020c231a41') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '2c98fa4f-c278-46e6-b634-4eb891da2529') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='d42deea6-c650-42b4-a21c-90b3ef0fa99f'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'eb095ff0-1011-4403-94d3-ba5848b7710b') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='477cdda4-82ff-4bac-834f-08de384df412'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', '97e7622b-4acb-431f-b48a-7c5d808b1516') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='93d7c1bc-2885-43f4-985f-90f57a414e5f'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'd974aac9-51b2-4b50-84a6-3f2345b35e6b') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='03ba009a-68bb-4b12-a5bc-e58a9bce1545'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'fe078d93-8669-4b8b-9d75-ae1225a547f2') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'e0c6a157-595a-4f4c-818c-60695991d0f6') ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, isreadwrite, ad_process_access_uu) VALUES ((SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_UU='199f56a6-8e1f-47b4-8f22-e2bdb8da7505'), (SELECT ad_role_id FROM AD_Role WHERE AD_Role_UU='a1618fd6-e1ab-4e41-a08d-854229cd5971'), 0, 0, 'Y', '2024-01-26 14:15:14.525000', 100, '2024-01-26 14:15:14.525000', 100, 'Y', 'fd6fb0ba-cc36-493d-870e-b17a46656c9d') ON CONFLICT DO NOTHING;

-- Update sequences before calling the next function, as it will rely on those sequence numbers
SELECT update_sequences();

-- Util function that adds the new role to all existing clients and includes it as a default role for
-- new clients. The function already existed, but had a few bugs, so has been corrected here
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

    PERFORM setval('tmp_ad_role_ad_role_id_seq', (SELECT currentnext FROM adempiere.ad_sequence WHERE name = 'AD_Role' LIMIT 1)::INT, false);

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
           uuid_generate_v4(),'N','N','N',null 
    FROM adempiere.ad_client c 
        JOIN adempiere.ad_role r 
        ON r.ad_role_uu = ad_role_to_add_uu :: TEXT
    WHERE c.ad_client_id NOT IN (0, 11);

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
           roletype 
    FROM tmp_ad_role ON CONFLICT DO NOTHING;

    -- Update the new role to have the same access to org as other responsibility roles have.
    INSERT INTO adempiere.ad_role_orgaccess (ad_role_id, ad_client_id, ad_org_id, isactive, createdby, updatedby, isreadonly, ad_role_orgaccess_uu)
    SELECT tar.ad_role_id,tar.ad_client_id,ao.ad_org_id,'Y',100,100,'N',uuid_generate_v4() 
    FROM tmp_ad_role tar
        JOIN adempiere.ad_org ao 
        ON ao.ad_client_id = tar.ad_client_id;

    -- Add the "Must Haves" and "New_Master_Role" to the role
    INSERT INTO ad_role_included (ad_client_id, ad_org_id, ad_role_id, createdby, included_role_id, seqno, updatedby, ad_role_included_uu)
    SELECT ad_client_id, 0, tar.ad_role_id, 100, ir.ad_role_id, ir.seqno, 100, uuid_generate_v4() 
    FROM tmp_ad_role tar
        CROSS JOIN 
                (SELECT ad_role_id, 10 as seqno 
                FROM adempiere.ad_role
                WHERE ad_role_uu = ad_role_to_add_uu :: TEXT 
                UNION SELECT ad_role_id, 20 as seqno
                FROM adempiere.ad_role 
                WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a' ) ir;

    -- Add a user-type ref-list item for the new role to the AD_Role_User_Type table
    INSERT INTO adempiere.ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, createdby, updatedby,
                                       value, name, description, ad_reference_id, validfrom, validto,
                                       entitytype, ad_ref_list_uu, bh_update_existing, bh_add_all)
    VALUES ((SELECT MAX(ad_ref_list_id) + 1 from adempiere.ad_ref_list), 0, 0, 'Y', 100, 100,
            user_type,
            (SELECT name FROM adempiere.ad_role WHERE ad_role_uu = ad_role_to_add_uu :: TEXT),
            (SELECT description FROM adempiere.ad_role WHERE ad_role_uu = ad_role_to_add_uu :: TEXT),
            (SELECT ad_reference_id FROM adempiere.ad_reference WHERE ad_reference_uu = '5b41f508-5ce5-4b42-80de-713e10580d51'),
            null, null, 'U', uuid_generate_v4(), 'N', 'N')
    ON CONFLICT DO NOTHING;

    -- When new BH clients are set up, they should include a role with this new role, as well as the must haves role
    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, createdby, db_usertype, description, isactive, name, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM adempiere.bh_defaultincludedrole), uuid_generate_v4(), 100, user_type, null, 'Y', null, 100, (SELECT ad_role_id FROM adempiere.ad_role WHERE ad_role_uu = ad_role_to_add_uu :: TEXT)) ON CONFLICT DO NOTHING;
    INSERT INTO adempiere.bh_defaultincludedrole (ad_client_id, ad_org_id, bh_defaultincludedrole_id, bh_defaultincludedrole_uu, createdby, db_usertype, description, isactive, name, updatedby, included_role_id) VALUES (0, 0, (SELECT max(bh_defaultincludedrole_id) + 1 FROM adempiere.bh_defaultincludedrole), uuid_generate_v4(), 100, user_type, null, 'Y', null, 100, (SELECT ad_role_id FROM adempiere.ad_role WHERE ad_role_uu = 'baec9412-d994-4313-815c-31332357863a')) ON CONFLICT DO NOTHING;

    -- Update all ID sequences after all the inserts we've done
    PERFORM update_sequences();

    RAISE NOTICE 'New user role added to % clients', clients_updated;
END;
$$;

--call function to add inventory/pharmacy basic role to clients
select add_roles_to_clients('a1618fd6-e1ab-4e41-a08d-854229cd5971', 'J');

SELECT register_migration_script('202401261026_GO-2746.sql') FROM dual;
