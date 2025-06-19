-- Update Menu Icon
UPDATE ad_menu
SET iconclassname = 'fa fa-book-open'
WHERE ad_menu_uu IN ('ab100eab-d2ed-4708-a8cc-aa952ab78529', '6744541c-801d-4009-bc2a-96cfd3454b0d');
-- Add conceptId column to M_Product
ALTER TABLE M_Product
    ADD COLUMN BH_Concept_ID NUMERIC(10) DEFAULT NULL;
ALTER TABLE M_Product
    ADD CONSTRAINT BHConcept_MProduct FOREIGN KEY (BH_Concept_ID) REFERENCES bh_concept (bh_concept_id) DEFERRABLE INITIALLY DEFERRED

SELECT register_migration_script('202506191016_GO-3305.sql')
FROM dual;
