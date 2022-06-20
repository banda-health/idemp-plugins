--

INSERT INTO adempiere.c_chargetype (ad_client_id, ad_org_id, c_chargetype_id, created, createdby, description, help, isactive, name, updated, updatedby, value, c_chargetype_uu) VALUES (2, 0, 190002, '2022-06-14 18:23:12.912000', 100, 'For special charges that have unique use cases', null, 'Y', 'One-offs - DO NOT CHANGE', '2022-06-14 18:23:12.912000', 100, '1000002', '4dc5426e-79cd-4c40-9b1e-b4bcd58f2c85');

INSERT INTO adempiere.c_charge (c_charge_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, chargeamt, issametax, issamecurrency, c_taxcategory_id, istaxincluded, c_bpartner_id, c_chargetype_id, c_charge_uu, c_elementvalue_id, bh_locked, bh_subtype, bh_needadditionalvisitinfo) VALUES (190043, 2, 0, 'Y', '2022-06-14 18:25:37.738000', 100, '2022-06-14 18:25:37.820000', 100, 'Bad debt write-off', 'Debt that may never get paid', 0, 'N', 'N', 190000, 'N', null, 190002, '02d2c04a-c4ed-45ea-9e96-e6a8a99d2c76', 190000, 'N', null, 'N');

INSERT INTO c_validcombination (c_validcombination_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, alias, combination, description, isfullyqualified, c_acctschema_id, account_id, m_product_id, c_bpartner_id, ad_orgtrx_id, c_locfrom_id, c_locto_id, c_salesregion_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, c_subacct_id, userelement1_id, userelement2_id, c_validcombination_uu) VALUES ((select max(c_validcombination_id) + 1 from c_validcombination where ad_client_id = 2), 2, 0, 'Y', '2021-07-09 15:40:54.259000', 100, '2021-07-09 15:41:05.723000', 100, null, '*-78100-_-_', '*-Bad Debts Write-off-_-_', 'Y', 190000, 190083, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '101d427e-006b-420f-aca2-29c1be81498d');



SELECT register_migration_script('202205231547_GO-2207.sql') FROM dual;
