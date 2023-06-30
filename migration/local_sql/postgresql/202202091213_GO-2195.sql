ALTER TABLE c_currency ADD IF NOT EXISTS currencyname varchar(100);

INSERT INTO ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname, entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help, ad_element_uu, placeholder) VALUES ((SELECT MAX(ad_element_id) + 1 FROM ad_element), 0, 0, 'Y', '2022-02-09 12:12:16.014000', 100, '2022-02-09 12:12:16.014000', 100, 'CurrencyName', 'U', 'Currency Name', 'Currency Name', 'The name of the currency', 'Added to aid in writing out the currency as words', null, null, null, null, 'ad8b38e2-8a8a-45cc-b503-cfcfab4f48a0', null) ON CONFLICT DO NOTHING;

INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder) VALUES ((SELECT MAX(ad_column_id) + 1 FROM ad_column), 0, 0, 'Y', '2022-02-09 12:12:44.625000', '2022-02-09 12:12:44.625000', 100, 100, 'Currency Name', 'The name of the currency', 'Added to aid in writing out the currency as words', 0, 'U', 'CurrencyName', 141, 10, null, null, 100, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'Y', (SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'ad8b38e2-8a8a-45cc-b503-cfcfab4f48a0'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '959ea7f1-f00e-4e06-a57b-e28df74403d7', 'Y', 10, 'N', 'N', null, null, 'N', null, null) ON CONFLICT DO NOTHING;

-- Now insert the currency names
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='5d31dd2b-eb1b-485d-a59d-250841805247';
UPDATE c_currency SET currencyname='Ringgit' WHERE c_currency_uu='df16a3ed-677f-4a9c-9cb5-7a2ba1653918';
UPDATE c_currency SET currencyname='Rupiah' WHERE c_currency_uu='f6ded46d-05df-4d6c-b6e7-2cc05f5358b3';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='c6d89f68-cb2f-43ca-80a1-64aa163c6b7d';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='88ee60f0-dd79-436a-9d57-7679306e6ca3';
UPDATE c_currency SET currencyname='Nuevo Sol' WHERE c_currency_uu='63016e26-0eb4-471a-ab92-7072a5b565ff';
UPDATE c_currency SET currencyname='Guilder' WHERE c_currency_uu='8151ef2a-830e-4ab2-ae13-23949158b308';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='e68b121a-f7f1-4c6e-aed0-c024abb65619';
UPDATE c_currency SET currencyname='Krona' WHERE c_currency_uu='80fe0a02-9e60-42ea-a1e3-f66f1da82f12';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='c3036811-9d23-424f-ae8c-dc19d2ac4004';
UPDATE c_currency SET currencyname='Shilling' WHERE c_currency_uu='9dbebf8b-b326-42f2-9d78-75f6b39002c5';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='97b2827a-7809-45fb-b5f0-cccf98b74ba8';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='46251a23-65f0-4f13-8b0f-72531ebdc022';
UPDATE c_currency SET currencyname='Pa’anga' WHERE c_currency_uu='9c4df391-d4a1-4a0a-98f1-0e15f9135e94';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='f66533d8-6d22-48cf-a973-79f47f630845';
UPDATE c_currency SET currencyname='Lira' WHERE c_currency_uu='0e99465a-6ffd-449b-9af3-a580ec3d2171';
UPDATE c_currency SET currencyname='Shilling' WHERE c_currency_uu='73898e28-7eef-4636-9d09-63f8e96bec0f';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='298a4648-6c01-4f33-9752-6572cced2e29';
UPDATE c_currency SET currencyname='Ouguiya' WHERE c_currency_uu='1b32566a-ce7a-4124-a407-4beb0943761e';
UPDATE c_currency SET currencyname='Shilling' WHERE c_currency_uu='5dfad140-f7e5-45e7-a838-d33706b41cb2';
UPDATE c_currency SET currencyname='Vatu' WHERE c_currency_uu='5f5d026d-322b-405f-ad1d-c1bf3a8acc76';
UPDATE c_currency SET currencyname='Tala' WHERE c_currency_uu='3b3cd4bb-0865-43da-93d9-f7648fc94b17';
UPDATE c_currency SET currencyname='Yuan' WHERE c_currency_uu='979d0818-d020-4c86-a23f-4e8ad93d80ed';
UPDATE c_currency SET currencyname='Rial' WHERE c_currency_uu='1d355a83-42e2-49f0-bb04-c9247df7dcbd';
UPDATE c_currency SET currencyname='Kwacha' WHERE c_currency_uu='183ae47f-d40a-4996-9ef2-6f129da1ee86';
UPDATE c_currency SET currencyname='Colon' WHERE c_currency_uu='45512261-6a18-4e28-8a2e-e123024f1a30';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='438a4a07-3d48-4aae-84c8-ef4dd35061be';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='af0a48b5-e245-4068-b5b1-a56b94330877';
UPDATE c_currency SET currencyname='Won' WHERE c_currency_uu='835fea94-fdb2-4cf7-9223-daaa0a7729ac';
UPDATE c_currency SET currencyname='Tenge' WHERE c_currency_uu='492adfdf-0952-4c33-801d-1af148bad4b5';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='875c90d6-ae67-495c-93ab-2ef557d20e76';
UPDATE c_currency SET currencyname='Guarani' WHERE c_currency_uu='826643fc-c2dc-4079-a96f-3042c1da070c';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='f98037ad-4790-4190-bf80-6c54b863076f';
UPDATE c_currency SET currencyname='Euro' WHERE c_currency_uu='efa3414b-4cb6-4e7e-a235-7376304e67bd';
UPDATE c_currency SET currencyname='Schilling' WHERE c_currency_uu='cc470dbf-45f2-4952-9ad9-b1fbd90ac634';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='4863f28d-f8be-4df2-b4d1-e4f78b5366ea';
UPDATE c_currency SET currencyname='Mark' WHERE c_currency_uu='c0a39c50-36d1-4894-802d-e83aa8e4b96e';
UPDATE c_currency SET currencyname='Lira' WHERE c_currency_uu='66f0c319-66ac-4c22-bcdb-157db64b42c2';
UPDATE c_currency SET currencyname='Gilder' WHERE c_currency_uu='034225bd-e64d-477d-b97f-c1dba7c9a5dd';
UPDATE c_currency SET currencyname='Escudo' WHERE c_currency_uu='06e8faac-06d0-4bfe-936d-c595b717aeef';
UPDATE c_currency SET currencyname='Peseto' WHERE c_currency_uu='302cb057-9e43-44ae-9389-350b75638459';
UPDATE c_currency SET currencyname='Yen' WHERE c_currency_uu='dfcf3cda-47d8-4d6d-96e2-69a0f2c43ff6';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='f97aa521-0a92-4305-a603-b0f8a3fab7ca';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='ee42451d-1ac4-4b6b-aff8-6082bcd53e74';
UPDATE c_currency SET currencyname='Leu' WHERE c_currency_uu='7e22439d-bce9-42f8-ba58-93709fbb4e9b';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='fcf97ebb-7095-479c-b4e9-6e45deaa97ad';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='502afe58-25ed-45cf-85f4-dbba8a73deb1';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='7ccace34-2328-4aa6-b791-283b453678b2';
UPDATE c_currency SET currencyname='Uruguayo' WHERE c_currency_uu='865bd7ac-1026-4d37-a114-c2f30e881c8a';
UPDATE c_currency SET currencyname='Dram' WHERE c_currency_uu='6b43df0f-91de-4b94-8df2-090ddd190e15';
UPDATE c_currency SET currencyname='Kwanza' WHERE c_currency_uu='6fc6a943-480e-4213-adb7-3fcfb31b077c';
UPDATE c_currency SET currencyname='Boliviano' WHERE c_currency_uu='df0282b3-00d2-4c06-b142-abbb1eb36274';
UPDATE c_currency SET currencyname='Congolais' WHERE c_currency_uu='8575e397-4f1c-4e5e-b06d-ef386549a4ca';
UPDATE c_currency SET currencyname='Koruna' WHERE c_currency_uu='2841fce1-cea0-4f39-b599-77a436129b7a';
UPDATE c_currency SET currencyname='Lari' WHERE c_currency_uu='d5eb39bd-220e-41fc-bbe3-23b61b96338f';
UPDATE c_currency SET currencyname='Litus' WHERE c_currency_uu='129dff5e-0278-4b58-a935-42cee40b11a0';
UPDATE c_currency SET currencyname='Leu' WHERE c_currency_uu='f09fa0cc-6b3d-4092-b4ca-27dbe0d8ad7c';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='687dceb8-bee2-404b-8d60-b0b0581acdba';
UPDATE c_currency SET currencyname='Ruble' WHERE c_currency_uu='fc78b0d6-1c4e-41ac-9da4-b250d61bac01';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='1f065f91-7edc-41a7-8150-c3984ff9017c';
UPDATE c_currency SET currencyname='Somoni' WHERE c_currency_uu='6be21f92-871a-499a-aba8-7f01e6f0b5a3';
UPDATE c_currency SET currencyname='Escudo' WHERE c_currency_uu='72a75315-a260-4ebc-87c7-a3fd89ea7b50';
UPDATE c_currency SET currencyname='Hryvnia' WHERE c_currency_uu='abd28c79-058f-4b15-b554-bc5ce12ad850';
UPDATE c_currency SET currencyname='Sum' WHERE c_currency_uu='05427870-44ca-41b3-88d0-bb32af297cef';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='22482570-731d-43ce-bdb5-381fdcd42c94';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='a5991ca8-3c4b-4e89-be08-af31296e45ea';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='fcd5b203-711f-4dec-aef9-0ab53335c2fc';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='01331081-0187-4b96-8287-3381fec62936';
UPDATE c_currency SET currencyname='Cedi' WHERE c_currency_uu='f7e4e177-6498-493f-951f-8430d1d72445';
UPDATE c_currency SET currencyname='Colon' WHERE c_currency_uu='3da4b5ee-ac4f-4580-b76c-e7717305ec18';
UPDATE c_currency SET currencyname='Guilder' WHERE c_currency_uu='73399156-23cb-4af7-9386-f4fb145a67ae';
UPDATE c_currency SET currencyname='Balboa' WHERE c_currency_uu='e517b855-36c8-4f69-a781-e9def9d4cc7f';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='ef8ececf-80a9-41f6-b6dc-961ac30fea2b';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='50bce8fd-0279-4ce8-8c3e-1df0d40e7541';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='7be1eb91-89cb-4377-bd5f-573149694712';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='f9062ecc-611e-4911-9e1c-6ddbdb2583ca';
UPDATE c_currency SET currencyname='Ruble' WHERE c_currency_uu='086e1bad-b450-455c-8be9-0760fd86487d';
UPDATE c_currency SET currencyname='Bolivar' WHERE c_currency_uu='d5d2f9d4-3e03-4327-8a04-632b47108824';
UPDATE c_currency SET currencyname='Baht' WHERE c_currency_uu='34ba985e-3551-47e8-a1ef-7d2758592fc1';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='0d9b4536-b95d-4f3e-be56-4fb0cc0a57c8';
UPDATE c_currency SET currencyname='Cordoba' WHERE c_currency_uu='954cec96-456b-481f-ab0c-3329aa868d7a';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='f3b5edb7-49d8-4203-98d0-ccec6272eaf6';
UPDATE c_currency SET currencyname='CFA Franc' WHERE c_currency_uu='5c36d812-4878-4c2e-a016-0a26ff040f76';
UPDATE c_currency SET currencyname='CFA Franc' WHERE c_currency_uu='e513ee52-1f2c-4347-be7d-829d34b61c15';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='a06c500a-636a-449b-8ee3-66fabd4534f2';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='85c2d144-603e-47ff-9c90-600005b039b6';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='bbbf5ba4-8270-4b31-aa50-ef9a18acce59';
UPDATE c_currency SET currencyname='Riel' WHERE c_currency_uu='121b39c3-401a-4f0e-ac11-8cdfe435005b';
UPDATE c_currency SET currencyname='Dalasi' WHERE c_currency_uu='3734cfbf-fdf4-465d-b3a7-24e4b853f603';
UPDATE c_currency SET currencyname='Rufiyaa' WHERE c_currency_uu='4c92918e-9b58-43ea-a106-f75bfdbcca81';
UPDATE c_currency SET currencyname='Rial' WHERE c_currency_uu='2294c0e7-1ccb-4f49-ba8a-d79d14c53626';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='5dd102d0-d0d2-4b57-a2e1-35216383774c';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='1990f2d3-d17d-4a40-909e-2bf453576eca';
UPDATE c_currency SET currencyname='Dobra' WHERE c_currency_uu='f5316d9f-ee0d-4d33-8efc-2e9fd96958ed';
UPDATE c_currency SET currencyname='Dirham' WHERE c_currency_uu='47cc07bc-5f0c-4124-a1ef-d183cdf9d935';
UPDATE c_currency SET currencyname='Dirham' WHERE c_currency_uu='521916d1-a8a0-4ba3-98b7-db6a0f22c398';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='bac0d758-3924-4f48-b123-54fa7447bfbd';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='ecc6dc06-c969-4a0e-be24-fe3f703853ca';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='f527b62a-09cd-419e-88fa-6e7b363a7d44';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='f1f9451e-6231-445f-8d18-8f2272ef0ef2';
UPDATE c_currency SET currencyname='Forint' WHERE c_currency_uu='3806a73f-d42f-4b8b-9c6e-f8f4373bae65';
UPDATE c_currency SET currencyname='Gourde' WHERE c_currency_uu='7c40e639-d804-4502-a7c9-50f2ff82e466';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='300c8031-4f49-41c2-946c-e03bed0d2d53';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='046374f7-a9f4-4b14-92e4-9fc8c769b5b5';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='5c4d3d7e-cc69-41f4-893c-00227e10e4ea';
UPDATE c_currency SET currencyname='Krona' WHERE c_currency_uu='22a2cb1c-e7af-4ba5-a6ff-7c7707f00741';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='5ac61e70-83b8-4d1f-ab9a-496a6831173d';
UPDATE c_currency SET currencyname='Kyat' WHERE c_currency_uu='d2626c44-bfa1-4f4e-8312-2ec0a939b65e';
UPDATE c_currency SET currencyname='Kina' WHERE c_currency_uu='845cd6da-ce62-499f-b0c0-ad65dbfdd5fe';
UPDATE c_currency SET currencyname='Shilling' WHERE c_currency_uu='7d07080c-d29e-4e2b-840e-ebe0abd6dc66';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='49bec463-c843-408c-8a96-1218c73d74d7';
UPDATE c_currency SET currencyname='Kip' WHERE c_currency_uu='637e5acf-cb0a-4e76-a929-8a8adde17576';
UPDATE c_currency SET currencyname='Nakfa' WHERE c_currency_uu='01631f79-6e50-46c7-994d-d9eeb8a1af90';
UPDATE c_currency SET currencyname='Lek' WHERE c_currency_uu='c185d2ba-313b-4199-be4a-7698bbe5bdc2';
UPDATE c_currency SET currencyname='Leu' WHERE c_currency_uu='4199c289-37e4-408f-a19c-5adf67c3b5bd';
UPDATE c_currency SET currencyname='Lilangeni' WHERE c_currency_uu='b12016bf-28be-42b0-952e-4c16458eb049';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='1661b47a-4fca-4b79-a215-dd0cc7482b8c';
UPDATE c_currency SET currencyname='Lira' WHERE c_currency_uu='ed58f10c-19e2-4233-bea4-902148332e0c';
UPDATE c_currency SET currencyname='Lats' WHERE c_currency_uu='cfbf903f-f8e2-4b1c-bb41-8a2cecd3f6ea';
UPDATE c_currency SET currencyname='Lev' WHERE c_currency_uu='fc7d97ab-6e13-40df-bf85-dc24539eaf1d';
UPDATE c_currency SET currencyname='Kwacha' WHERE c_currency_uu='ff74f67d-45dd-4fe2-9506-8a4640db931f';
UPDATE c_currency SET currencyname='Denar' WHERE c_currency_uu='225692ea-6ac1-4063-a17a-75843f4402f7';
UPDATE c_currency SET currencyname='Metical' WHERE c_currency_uu='2f995dd9-7094-4cc5-bd9c-dcfcb0a6afc5';
UPDATE c_currency SET currencyname='Sheqel' WHERE c_currency_uu='9a128319-9380-4f53-b202-22fba1974b84';
UPDATE c_currency SET currencyname='Krone' WHERE c_currency_uu='4d233fd9-fb29-4bc9-b542-86cbf276dee5';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='688b7319-6227-4aa8-aef3-1dd100b7b027';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='a47bff38-f5f0-4ab0-a6bc-f0f6102de445';
UPDATE c_currency SET currencyname='Pataca' WHERE c_currency_uu='1669e64c-1cda-4989-bfc0-a88997f807fa';
UPDATE c_currency SET currencyname='Quetzal' WHERE c_currency_uu='b492714d-1c4e-4a11-acca-e327072ddc4d';
UPDATE c_currency SET currencyname='Rial' WHERE c_currency_uu='41a89934-7988-4c5f-b01c-d580925e4d0e';
UPDATE c_currency SET currencyname='Real' WHERE c_currency_uu='ca87f708-a028-43db-bea9-79342624c8f9';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='4f2c2cc6-ee74-4096-816f-57b6a7129ec4';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='3b640438-b407-434e-8a48-7d26d9f48d71';
UPDATE c_currency SET currencyname='Tolar' WHERE c_currency_uu='420066df-45b3-4bf9-83e9-c336f87bbf97';
UPDATE c_currency SET currencyname='Koruna' WHERE c_currency_uu='300af3b4-e347-45b5-83fe-1ba5cc599a2e';
UPDATE c_currency SET currencyname='Riyal' WHERE c_currency_uu='08ce79ee-7af5-4cf0-8459-278e135fcf23';
UPDATE c_currency SET currencyname='Taka' WHERE c_currency_uu='ed99208e-f751-40ce-b2cc-6956a6deaebf';
UPDATE c_currency SET currencyname='Tugrik' WHERE c_currency_uu='2a361c66-98df-494c-b3a0-7acf1ae29f77';
UPDATE c_currency SET currencyname='Won' WHERE c_currency_uu='9b1dfb78-a4ae-4fd1-8693-24c4e269db55';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='f92de985-2b95-4567-910c-d3121fca0831';
UPDATE c_currency SET currencyname='Som' WHERE c_currency_uu='dde4f3fd-ac65-4644-b227-4f43068d830a';
UPDATE c_currency SET currencyname='Naira' WHERE c_currency_uu='c7b4251e-fa28-4965-bc4f-a638d0686f61';
UPDATE c_currency SET currencyname='Mark' WHERE c_currency_uu='eb0483c9-2771-48e4-a282-0988206341c7';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='b73cb2f9-d5da-4cb8-88bf-68b301e5cba7';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='c38d8a02-6935-4021-b0a8-1357435192f5';
UPDATE c_currency SET currencyname='Dollar' WHERE c_currency_uu='f239a065-5274-48bf-b86d-002a44c1340b';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='82405c32-ac60-4f04-be66-c8429a7127d1';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='9e8fb8eb-a15e-4cc4-9a2b-6a8f13049fa6';
UPDATE c_currency SET currencyname='Manat' WHERE c_currency_uu='be5ee6d1-195d-413e-bd9a-d760b25475ae';
UPDATE c_currency SET currencyname='Rial' WHERE c_currency_uu='84629a82-236e-459c-a172-173ae831478f';
UPDATE c_currency SET currencyname='Zloty' WHERE c_currency_uu='f301d61b-fe4d-4cab-ab1d-a5287a9b0faa';
UPDATE c_currency SET currencyname='Manat' WHERE c_currency_uu='83245baf-0518-4139-bde5-102464d15d6c';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='4008c829-e66d-4458-b9f6-8df01f60e60d';
UPDATE c_currency SET currencyname='Pound' WHERE c_currency_uu='ab615500-fcef-4438-aa2f-fb1e51c08ad4';
UPDATE c_currency SET currencyname='Afghani' WHERE c_currency_uu='47efd63c-8890-4b0d-897e-f7d8fddfc753';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='bfee0e57-4c22-4589-8fbb-2f1f4c52aff2';
UPDATE c_currency SET currencyname='Birr' WHERE c_currency_uu='939381f6-cdd1-43ba-a42d-a178e7eb1f97';
UPDATE c_currency SET currencyname='Escudo' WHERE c_currency_uu='151618c1-d7dd-436e-baa4-517fb5b0952b';
UPDATE c_currency SET currencyname='CFP Franc' WHERE c_currency_uu='12050faa-8425-470e-909b-2e98f484137e';
UPDATE c_currency SET currencyname='Peso' WHERE c_currency_uu='4bc492d9-0daa-4455-848f-5aca09324317';
UPDATE c_currency SET currencyname='Dong' WHERE c_currency_uu='7290ce34-0780-4541-bcc4-a9b4f03801ae';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='4e1915c7-a669-4068-91e8-da878da61442';
UPDATE c_currency SET currencyname='Krone' WHERE c_currency_uu='7fae8d90-b282-45b2-be5e-da3ee45f75db';
UPDATE c_currency SET currencyname='Franc' WHERE c_currency_uu='c4b0b14c-adbe-46b9-8a71-585a321ad9d9';
UPDATE c_currency SET currencyname='Kuna' WHERE c_currency_uu='dd66073d-b244-4132-b36c-b1457e371a02';
UPDATE c_currency SET currencyname='Dinar' WHERE c_currency_uu='ad722bd9-9fd0-4443-9c0d-f2f4faf5b199';
UPDATE c_currency SET currencyname='Mark' WHERE c_currency_uu='bbb3f092-7ec5-47b9-ab64-2ee7a76ed6ad';
UPDATE c_currency SET currencyname='Lempira' WHERE c_currency_uu='1a722c0c-1b7f-4ed2-adea-6e94cb8cf5b6';
UPDATE c_currency SET currencyname='Leone' WHERE c_currency_uu='34239a86-07ac-44cb-a413-32a56a290489';
UPDATE c_currency SET currencyname='Rupee' WHERE c_currency_uu='5c4f1bc0-7a66-459c-9d60-f0dd056aa340';
UPDATE c_currency SET currencyname='Guilder' WHERE c_currency_uu='853a32b7-cdb0-4381-b86f-3873ae4136dc';
UPDATE c_currency SET currencyname='Pula' WHERE c_currency_uu='fc5b8f7e-e77b-4960-8bb4-fa588eeaaa68';
UPDATE c_currency SET currencyname='Rand' WHERE c_currency_uu='7fc2a997-4c40-4a97-a848-c4f6634986f3';
UPDATE c_currency SET currencyname='Kroon' WHERE c_currency_uu='2c6b4fe0-ee55-46ef-8371-b21ebee7ebd1';

SELECT register_migration_script('202202091213_GO-2195.sql') FROM dual;