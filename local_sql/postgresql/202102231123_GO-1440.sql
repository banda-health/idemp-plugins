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
UPDATE ad_ref_list SET name = 'Annulé' WHERE ad_ref_list_uu = 'd35dfd1d-1eb2-46ef-ab2f-23973d68a570';
UPDATE ad_ref_list SET name = 'Inconnue' WHERE ad_ref_list_uu = '0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2';
UPDATE ad_ref_list SET name = 'Clos' WHERE ad_ref_list_uu = '50702660-bbfc-422a-8acc-5ed3a2dce204';
UPDATE ad_ref_list SET name = 'Projeté' WHERE ad_ref_list_uu = 'd27f8a6b-e8b5-4fea-a6b2-3e7049c473ec'

-- Product Category Types
UPDATE ad_ref_list SET name = 'Produit' WHERE ad_ref_list_uu = '305558d1-db4a-456f-9c25-057750949060';

-- Patient types
UPDATE ad_ref_list SET name = 'Malade ambulatoire' WHERE ad_ref_list_uu = '0a48b24a-8c67-4067-beb5-4eb3bc7daeb1';
UPDATE ad_ref_list SET name = 'Patient hospitalisé' WHERE ad_ref_list_uu = '46d397b3-103d-4663-86b2-27e395dd158d';

-- Referral - need!

-- Tender Types - need!

/**********************************************************************************************************/
-- Update expense categories
/**********************************************************************************************************/


/**********************************************************************************************************/
-- Finish
/**********************************************************************************************************/
SELECT register_migration_script('202102231123_GO-1440.sql') FROM dual;
