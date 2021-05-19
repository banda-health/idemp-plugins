/* BH_Products Packout Data Export */

-- Menu Item
INSERT INTO adempiere.bh_dbrdbtngrp_btn (bh_dbrdbtngrp_btn_id, ad_client_id, ad_infowindow_id, ad_org_id, ad_window_id, bh_dbrdbtngrp_btn_uu, buttonclassname, buttonhelptext, buttontext, created, createdby, description, iconclassname, isactive, lineno, name, updated, updatedby, bh_dbrdbtngrp_id, ad_process_id, ad_form_id, included_role_id, ad_window_uu, windowmapping)
VALUES ((SELECT max(bh_dbrdbtngrp_btn_id) + 1 FROM bh_dbrdbtngrp_btn), 0, 200000, 0, (SELECT ad_window_id FROM ad_window WHERE ad_window.ad_window_uu='c63b9972-1b23-4140-8bbb-0ea2b0b81024'), 'beade859-7122-41da-834f-f7a8ac5a81d5', 'button app big', 'View Products', 'My Products', '2018-06-12 11:30:33.639000', 100, '/products', 'fa fa-pills', 'Y', 10, 'Products And Prices', '2021-04-15 15:07:04.795000', 0, (SELECT bh_dbrdbtngrp_id FROM bh_dbrdbtngrp WHERE bh_dbrdbtngrp_uu='bdd761f1-7979-4d87-9c5e-137c6210e9a1'), null, null, (SELECT ad_role_id FROM ad_role WHERE ad_role_uu='2b30c5ae-d1a8-426b-bb68-e3b56e69cd56'), null, '1000010') ON CONFLICT DO NOTHING;

--Product UoMs --
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (109, 11, 0, 'Y', '2004-07-23 14:03:17.000000', '2004-07-23 14:05:13.000000', 100, 100, '6PK', '6Pk', '6-Pack', null, 0, 4, 'N', null, 'f622fe59-cbbd-4835-96b2-bb8eb5b8bf99') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), 11, 0, 'Y', '2008-09-22 13:58:14.000000', '2008-09-22 13:58:14.000000', 100, 100, 'ml', 'ml', 'Mililiter', null, 4, 4, 'N', null, '3bb47b84-d840-4037-b1c6-dfb15503e590') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), 11, 0, 'Y', '2008-09-22 14:08:18.000000', '2008-09-22 14:08:18.000000', 100, 100, 'Kg', 'Kg', 'kilogram', null, 2, 0, 'N', null, 'c0776c7c-f653-4663-89ed-cb2bf92b6998') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), 11, 0, 'Y', '2008-09-22 14:14:39.000000', '2008-09-22 14:14:39.000000', 100, 100, 'mg', 'mg', 'milligram', null, 6, 6, 'N', null, 'fd31e3a5-714e-41ed-ae67-33c9c075160c') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), 11, 0, 'Y', '2008-09-22 14:37:01.000000', '2008-09-22 14:37:01.000000', 100, 100, 'L', 'L', 'litre', null, 2, 0, 'N', null, 'a9b9be37-5dfe-436e-a0a7-c7c33a66e4c3') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), 0, 0, 'Y', '2018-06-12 11:30:33.537000', '2018-06-12 11:30:33.537000', 100, 100, 'DR', 'DRP', 'Drop', 'Uom for stuff measured om drops', 2, 0, 'N', 'VL', '015f8f25-216b-4bb0-a4f8-3f19f84d27d4') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (102, 0, 0, 'Y', '2001-04-12 16:41:50.000000', '2018-06-12 11:30:33.554000', 0, 100, 'DA', 'd  ', 'Day', null, 2, 2, 'N', 'LE', '68535d3f-596a-4400-9f72-ad032ec9e145') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (100, 0, 0, 'Y', '1999-12-09 09:14:23.000000', '2018-06-12 11:30:33.561000', 0, 100, 'EA', 'Ea ', 'Each', null, 0, 4, 'Y', 'OT', '43e9ced9-60f4-4e15-adaa-2844637f4e1e') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (101, 0, 0, 'Y', '2001-04-12 16:40:36.000000', '2018-06-12 11:30:33.567000', 0, 100, 'HR', 'h  ', 'Hour', null, 2, 2, 'N', 'TM', 'ddba8d0f-26ca-4fe4-8253-a60d0dd22d1b') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (103, 0, 0, 'Y', '2002-06-15 20:54:06.000000', '2018-06-12 11:30:33.574000', 0, 100, 'MJ', 'm  ', 'Minutes', '(lowest unit for resorce assigments)', 0, 0, 'N', 'TM', '06edf453-43b0-41f3-9767-1dcc0dba33de') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (106, 0, 0, 'Y', '2002-06-20 20:35:10.000000', '2018-06-12 11:30:33.605000', 0, 100, 'MO', 'm  ', 'Month', '30 days', 2, 2, 'N', 'TM', 'c2dbbdb4-433e-47d2-91bc-6e2b00c2644b') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (105, 0, 0, 'Y', '2002-06-20 20:32:56.000000', '2018-06-12 11:30:33.614000', 0, 100, 'WK', 'w  ', 'Week', null, 2, 2, 'N', 'TM', 'a409bde4-f5c9-4c07-9752-99602fccd687') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (104, 0, 0, 'Y', '2002-06-20 20:32:01.000000', '2018-06-12 11:30:33.621000', 0, 100, 'WD', 'D  ', 'Work Day', '8 hour', 2, 2, 'N', 'TM', 'e12aed18-09e9-4fd1-ad41-a9d5156b37ee') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (107, 0, 0, 'Y', '2002-06-20 20:35:55.000000', '2018-06-12 11:30:33.628000', 0, 100, 'WM', 'M  ', 'Working Month', '20 days', 2, 2, 'N', 'TM', '828cba55-5a25-47b7-ba18-c86874223324') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES (108, 0, 0, 'Y', '2002-06-20 20:36:33.000000', '2018-06-12 11:30:33.634000', 0, 100, 'YR', 'y  ', 'Year', null, 2, 2, 'N', 'TM', '648f31ee-4630-4ff5-b6e2-6df0946f4ab4') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), (SELECT ad_client_id from ad_client WHERE ad_client_uu='4b5285e7-e4f2-4875-9f89-b598c16b2bef'), 0, 'Y', '2018-06-12 12:10:16.650000', '2018-06-12 12:10:16.650000', 100, 100, 'mg', 'Mg', 'Milligrams', 'Weight in grammage', 2, 0, 'N', 'WE', '8afa898c-1a7e-4b66-b878-694409c720ff') ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.c_uom (c_uom_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, x12de355, uomsymbol, name, description, stdprecision, costingprecision, isdefault, uomtype, c_uom_uu) VALUES ((SELECT max(c_uom_id) + 1 FROM adempiere.c_uom), (SELECT ad_client_id FROM ad_client WHERE ad_client_uu='85326fa9-2ed9-4c43-b821-925a52c66e09'), 0, 'Y', '2018-07-26 10:34:23.402000', '2018-07-26 10:35:32.950000', 100, 100, 'MG', 'Mg', 'Milligrams', 'Measurement in milligrams', 2, 0, 'Y', 'WE', '6678e6da-bed0-4704-acc2-f45a77022130') ON CONFLICT DO NOTHING ;

--Tab Navigation Buttons
INSERT INTO adempiere.bh_tabnavbtn (bh_tabnavbtn_id, ad_client_id, ad_org_id, bh_tabnavbtn_uu, created, createdby, description, isactive, name, updated, updatedby, buttontext, buttonhelptext, buttonclassname, iconclassname, ad_tab_id, ad_window_id, buttonaction, buttonlocation, ad_table_id, ad_column_id, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_id) + 1 FROM bh_tabnavbtn), 0, 0, '724a34d8-e4ee-4be1-bdba-614ef286a770', '2018-06-12 11:30:33.657000', 100, 'Add Price', 'Y', 'Add Another Price', '2018-06-12 11:30:33.657000', 100, 'Add Price', 'Add Price', 'btn btn-confirm', 'fas fa-plus', null, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu='c63b9972-1b23-4140-8bbb-0ea2b0b81024'), 'N', 'R', null, null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.bh_tabnavbtn (bh_tabnavbtn_id, ad_client_id, ad_org_id, bh_tabnavbtn_uu, created, createdby, description, isactive, name, updated, updatedby, buttontext, buttonhelptext, buttonclassname, iconclassname, ad_tab_id, ad_window_id, buttonaction, buttonlocation, ad_table_id, ad_column_id, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_id) + 1 FROM bh_tabnavbtn), 0, 0, 'fd745044-b86a-4c47-9278-92f62aa23ebb', '2018-06-12 11:30:33.668000', 100, 'Navigate to the price line', 'Y', 'Price Line', '2018-06-12 11:30:33.668000', 100, 'Add Price', 'Add Price', 'btn btn-confirm', 'fas fa-chevron-right', 1000080, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu='c63b9972-1b23-4140-8bbb-0ea2b0b81024'), 'G', 'R', null, null, null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.bh_tabnavbtn (bh_tabnavbtn_id, ad_client_id, ad_org_id, bh_tabnavbtn_uu, created, createdby, description, isactive, name, updated, updatedby, buttontext, buttonhelptext, buttonclassname, iconclassname, ad_tab_id, ad_window_id, buttonaction, buttonlocation, ad_table_id, ad_column_id, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_id) + 1 FROM bh_tabnavbtn), 0, 0, '929a4c75-5bf3-4a42-9d78-354624defd78', '2018-06-12 11:30:33.645000', 100, null, 'Y', 'Go back to product', '2018-10-26 09:35:02.964000', 100, 'Back', 'Back', 'btn', 'fas fa-chevron-left', 1000087, (SELECT ad_window_id FROM ad_window WHERE ad_window_uu='c63b9972-1b23-4140-8bbb-0ea2b0b81024'), 'G', 'L', null, null, null) ON CONFLICT DO NOTHING;

--Tab Navigation Button Tabs
INSERT INTO adempiere.bh_tabnavbtn_tab (bh_tabnavbtn_tab_id, ad_client_id, ad_org_id, bh_tabnavbtn_tab_uu, created, createdby, description, isactive, name, updated, updatedby, ad_tab_id, bh_tabnavbtn_id, buttonclassname, buttonhelptext, buttontext, iconclassname, buttonlocation, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_tab_id) + 1 FROM bh_tabnavbtn_tab), 0, 0, '93ed449e-4d88-48b9-be42-f512905a42dc', '2018-06-12 11:30:33.651000', 100, null, 'Y', 'Back', '2018-06-12 11:30:33.651000', 100, (SELECT ad_tab_id from ad_tab where ad_tab_uu='43ae4f82-384d-4e6d-a088-a5342e8ce7b2'), (SELECT * FROM bh_tabnavbtn WHERE bh_tabnavbtn_uu='929a4c75-5bf3-4a42-9d78-354624defd78'), null, null, null, null, null, null) ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.bh_tabnavbtn_tab (bh_tabnavbtn_tab_id, ad_client_id, ad_org_id, bh_tabnavbtn_tab_uu, created, createdby, description, isactive, name, updated, updatedby, ad_tab_id, bh_tabnavbtn_id, buttonclassname, buttonhelptext, buttontext, iconclassname, buttonlocation, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_tab_id) + 1 FROM bh_tabnavbtn_tab), 0, 0, '8f3e70d7-9ad5-4eda-a5c4-0eeb14a7ea85', '2018-06-12 11:30:33.663000', 100, null, 'Y', 'Add Price', '2018-06-12 11:30:33.663000', 100, (SELECT ad_tab_id from ad_tab where ad_tab_uu='43ae4f82-384d-4e6d-a088-a5342e8ce7b2'), (SELECT * FROM bh_tabnavbtn WHERE bh_tabnavbtn_uu='724a34d8-e4ee-4be1-bdba-614ef286a770'), null, null, null, null, null, null) ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.bh_tabnavbtn_tab (bh_tabnavbtn_tab_id, ad_client_id, ad_org_id, bh_tabnavbtn_tab_uu, created, createdby, description, isactive, name, updated, updatedby, ad_tab_id, bh_tabnavbtn_id, buttonclassname, buttonhelptext, buttontext, iconclassname, buttonlocation, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_tab_id) + 1 FROM bh_tabnavbtn_tab), 0, 0, '5b2343ec-60eb-42fc-8a93-827967ba1a1c', '2018-06-12 11:30:33.674000', 100, null, 'Y', 'Add Price', '2018-06-12 11:30:33.674000', 100, (SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu='c074e5b3-cc1f-4040-95f2-3b2a0969d05d'), (SELECT * FROM bh_tabnavbtn WHERE bh_tabnavbtn_uu='fd745044-b86a-4c47-9278-92f62aa23ebb'), null, null, null, null, null, null) ON CONFLICT DO NOTHING ;
INSERT INTO adempiere.bh_tabnavbtn_tab (bh_tabnavbtn_tab_id, ad_client_id, ad_org_id, bh_tabnavbtn_tab_uu, created, createdby, description, isactive, name, updated, updatedby, ad_tab_id, bh_tabnavbtn_id, buttonclassname, buttonhelptext, buttontext, iconclassname, buttonlocation, displaylogic) VALUES ((SELECT max(bh_tabnavbtn_tab_id) + 1 FROM bh_tabnavbtn_tab), 0, 0, '20fa726b-2b5c-4f94-b8a1-067e19a62345', '2018-08-14 15:49:09.236000', 100, null, 'Y', 'Back', '2018-08-14 15:49:09.236000', 100, (SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu='c074e5b3-cc1f-4040-95f2-3b2a0969d05d'), (SELECT * FROM bh_tabnavbtn WHERE bh_tabnavbtn_uu='929a4c75-5bf3-4a42-9d78-354624defd78'), null, null, null, null, null, null) ON CONFLICT DO NOTHING ;

--2-Pack Export
INSERT INTO adempiere.ad_package_exp (ad_package_exp_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_package_type, email, instructions, name, processed, releaseno, version, username, processing, pk_version, file_directory, description, ad_package_exp_uu, datefrom, isexportdictionaryentity) VALUES ((SELECT max(ad_package_exp_id) + 1 FROM ad_package_exp), 0, 0, 'Y', '2018-06-12 11:30:33.480000', 100, '2020-06-26 12:38:10.240000', 100, 'X', null, null, 'BH_Products', 'N', null, null, null, 'N', '10.0.5.0', null, 'My Products window Add price margin field', '75f85f5e-007d-4ecf-8730-18ff6a49002e', null, 'Y') ON CONFLICT DO NOTHING ;

--2-Pack Export Tabs
-- (Commented out the 4 sql data export lines now since they get the data in the lines above)
-- INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2018-06-12 00:00:00.000000', 100, null, null, null, null, 0, null, null, null, null, null, null, null, 'ALL', 'D', null, 'SELECT * FROM AD_Package_Exp WHERE AD_Package_Exp_UU=''75f85f5e-007d-4ecf-8730-18ff6a49002e'';AD_Package_Exp_Detail ', null, 'N', 'N', null, 20, null, 50005, null, 1000010, null, null, null, null, null, null, null, null, 'fe421c36-e5bb-4c50-ae40-d2326cca6a51', null) ON CONFLICT DO NOTHING;
-- INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2018-06-12 00:00:00.000000', 100, null, null, null, null, 0, null, null, null, null, null, null, 'Get all UOMs', 'ALL', 'D', null, 'SELECT * FROM c_uom', null, 'N', 'N', null, 40, null, 146, null, 1000010, null, null, null, null, null, null, null, null, 'ab17ca92-e607-49ba-940b-180569f8a4e2', null) ON CONFLICT DO NOTHING;
-- INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2018-06-12 00:00:00.000000', 100, null, null, null, null, 0, null, null, null, null, null, null, 'Exports the dashboard icon data for the product icon.', 'ALL', 'D', null, 'SELECT * FROM BH_HmScrn_ButtonGroupLine WHERE BH_HmScrn_ButtonGroupLine_UU=''beade859-7122-41da-834f-f7a8ac5a81d5''', null, 'N', 'N', null, 50, null, 1000003, null, 1000010, null, null, null, null, null, null, null, null, '4b54d315-d476-42ee-aa29-0cdae8c2e2cb', null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2018-06-12 00:00:00.000000', 100, null, null, null, null, 0, null, null, null, null, null, null, null, 'ALL', 'D', null, 'SELECT * FROM BH_TabNavBtn WHERE AD_Window_ID = (SELECT AD_Window.AD_Window_ID FROM AD_Window WHERE AD_Window.AD_Window_UU=''c63b9972-1b23-4140-8bbb-0ea2b0b81024'');BH_TabNavBtn_Tab', null, 'N', 'N', null, 60, null, 1000000, null, 1000010, null, null, null, null, null, null, null, null, 'd3650d34-deef-4e0a-a2fe-fbcd6c8fc3e1', null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2018-06-12 00:00:00.000000', 100, null, null, null, null, 0, null, null, null, null, null, null, 'This validation rule filters the dropdown  options for product uom based on the selected product type.', 'ALL', 'V', null, '(''@ProductType@''=''I'' AND c_uom.uomtype IN ( ''WE'', ''VL'', ''LE'')  OR ''@ProductType@''=''S'' AND c_uom.uomtype IN ( ''TM'' )  OR c_uom.uomtype IN ( ''OT'' ) )', null, 'N', 'N', null, 30, null, null, null, 1000010, null, null, 1000005, null, null, null, null, null, '398ff97c-bffb-49d7-9d6c-b20c4157be93', null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2018-06-12 00:00:00.000000', 100, '2019-06-20 17:43:22.636000', 100, null, null, 1000009, null, 0, null, null, null, null, null, null, 'Changed order of columns in grid view', 'ALL', 'M', null, null, null, 'N', 'N', null, 10, null, null, null, 1000010, null, null, null, null, null, null, null, null, '32dfced0-ef65-43e8-be38-26e428c8ee77', null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2019-11-27 00:00:00.000000', 100, '2019-11-27 00:00:00.000000', 100, null, null, 1000041, null, 0, null, null, null, null, null, null, null, 'ALL', 'M', null, null, null, 'N', 'N', null, 70, null, null, null, 1000010, null, null, null, null, null, null, null, null, '29f68f54-3fc9-4480-90ab-b8b07efa1d3c', null) ON CONFLICT DO NOTHING;
INSERT INTO adempiere.ad_package_exp_detail (ad_package_exp_detail_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_form_id, ad_impformat_id, ad_menu_id, ad_process_id, ad_role_id, ad_window_id, ad_workflow_id, file_directory, filename, destination_filename, destination_directory, description, dbtype, type, target_directory, sqlstatement, releaseno, processing, processed, name2, line, ad_workbench_id, ad_table_id, ad_reportview_id, ad_package_exp_id, ad_package_code_new, ad_package_code_old, ad_val_rule_id, ad_message_id, ad_printformat_id, ad_reference_id, ad_modelvalidator_id, ad_entitytype_id, ad_package_exp_detail_uu, ad_infowindow_id) VALUES ((SELECT max(ad_package_exp_detail_id) + 1 FROM ad_package_exp_detail), 0, 0, 'Y', '2020-02-07 00:00:00.000000', 100, '2020-02-07 00:00:00.000000', 100, null, null, 1000042, null, 0, null, null, null, null, null, null, null, 'ALL', 'M', null, null, null, 'N', 'N', null, 80, null, null, null, 1000010, null, null, null, null, null, null, null, null, '2c43f8ec-713b-41b9-8dc7-39f286051ce3', null) ON CONFLICT DO NOTHING;


