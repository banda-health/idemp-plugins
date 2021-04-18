-- Update the languages so Chinese isn't a system language anymore
UPDATE ad_language SET isloginlocale = 'N' WHERE ad_language.ad_language = 'zh_CN';

-- Set French to be a login language
UPDATE ad_language SET isloginlocale = 'Y', IsSystemLanguage = 'Y' WHERE ad_language.ad_language = 'fr_FR';

-- Update any translations that now need to be added
select add_missing_translations();

-- Insert translated text for menus
-- Menu text not needing translation: Patients, Services
-- Suppliers
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Fournisseurs'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = '64746aed-41f0-4cef-a7d8-3c574d12639f');
-- Products
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Produits'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = 'beade859-7122-41da-834f-f7a8ac5a81d5');
-- Expense Categories
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Catégories de dépenses'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = '8f5d51d4-e64e-4784-bcfa-cf96330f6422');
-- Visits/Bills
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Consultations/Factures'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = '35e36aad-3667-4212-80b1-7693725db473');
-- Pay Open Balance
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Solde d''ouverture à payer'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = 'f0a2ba7a-765c-4239-bb91-910ee85e6017');
-- Expenses
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Suivre les dépenses'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = '2bd2f18b-7fe9-4079-b074-8dc113b98714');
-- Manage Inventory
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Gérer l''inventaire'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = 'a3ce69ef-8577-4458-a0c2-94f7606088da');
-- Receive Products
UPDATE BH_DbrdBtnGrp_Btn_Trl
SET Name = 'Réception des produits'
WHERE ad_language = 'fr_FR'
  AND BH_DbrdBtnGrp_Btn_ID = (SELECT BH_DbrdBtnGrp_Btn_ID FROM BH_DbrdBtnGrp_Btn WHERE BH_DbrdBtnGrp_Btn_UU = '674a0a2b-2eda-4502-984e-2ee4b63dcc7a');

/**********************************************************************************************************/
-- Update all metadata
-- Not needed: Payment rules, NHIF-related data
/**********************************************************************************************************/
-- Document Statuses
UPDATE ad_ref_list_trl SET name = 'Annulé' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'd35dfd1d-1eb2-46ef-ab2f-23973d68a570') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Inconnue' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Clos' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '50702660-bbfc-422a-8acc-5ed3a2dce204') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Projeté' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'd27f8a6b-e8b5-4fea-a6b2-3e7049c473ec') AND ad_language = 'fr_FR';

-- Product Category Types
UPDATE ad_ref_list_trl SET name = 'Produit' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '305558d1-db4a-456f-9c25-057750949060') AND ad_language = 'fr_FR';

-- Patient types
UPDATE ad_ref_list_trl SET name = 'Malade ambulatoire' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '0a48b24a-8c67-4067-beb5-4eb3bc7daeb1') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Patient hospitalisé' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '46d397b3-103d-4663-86b2-27e395dd158d') AND ad_language = 'fr_FR';

-- Referrals
UPDATE ad_ref_list_trl SET name = 'Référence de l''unité communautaire' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '4274fce2-29b8-4e4f-a58e-dd77ec039f53') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Référence des établissements de santé' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'd8a8e37e-18ff-4445-9469-775eea1408e4') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Référence à l''unité communautaire' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'e1d9d266-cefd-4749-94de-20ad020c7d91') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Référence vers un autre établissement de santé' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'bffef4a3-34ef-4af3-9cf5-8471bfda5cd7') AND ad_language = 'fr_FR';

-- Tender Types (Bill Waiver still needed)
UPDATE ad_ref_list_trl SET name = 'Espèces' WHERE ad_ref_list_id IN (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu IN ('52c6c5a6-83ce-48c4-b874-721f8cd4e66b','917130e3-2144-496c-9344-6cf4f7136293')) AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'chèque' WHERE ad_ref_list_id IN (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu IN ('900adbf9-5069-4f56-9d97-0313c6372af3','056e0d26-2ff4-41c6-bde6-b35d888e555e')) AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Carte de crédit' WHERE ad_ref_list_id IN (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu IN ('d3874573-b7bf-4556-9b9c-3644698c959e','68dda00d-c015-498e-b91c-811bab809dab')) AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Dépôt direct' WHERE ad_ref_list_id IN (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu IN ('220f3864-24b8-42ba-9a91-a247f4697530','50bc3b86-6106-44df-88ee-1000243a9fcf')) AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Fonds des donateurs' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = 'e24511d1-9180-491c-9cc6-354b8a08e1ff') AND ad_language = 'fr_FR';
UPDATE ad_ref_list_trl SET name = 'Prélèvement automatique' WHERE ad_ref_list_id = (SELECT ad_ref_list_id FROM ad_ref_list WHERE ad_ref_list_uu = '2c5f0a44-1d35-4528-802f-9204e46be31e') AND ad_language = 'fr_FR';

/**********************************************************************************************************/
-- Finish
/**********************************************************************************************************/
SELECT register_migration_script('202103261123_GO-1440.sql') FROM dual;
