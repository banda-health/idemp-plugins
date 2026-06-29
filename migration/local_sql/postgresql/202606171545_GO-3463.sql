-- GO-3463: Remap BH_Client_Concept_Extra directly to BH_Concept / BH_Concept_Mapping.
-- Removes the BH_Client_Concept_Extra -> BH_Concept_Extra link and makes the per-clinic
-- override a client-scoped mirror of BH_Concept_Extra (BH_Concept_ID, BH_Concept_Mapping_ID,
-- BH_Key, BH_Value), so a clinic can override (or add) a keyed value for a concept or a
-- concept mapping without a matching global Concept Extra having to exist first.

-- 1. Add the new columns (types mirror BH_Concept_Extra)
ALTER TABLE bh_client_concept_extra
	ADD COLUMN IF NOT EXISTS bh_concept_id numeric(10) DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS bh_concept_mapping_id numeric(10) DEFAULT NULL,
	ADD COLUMN IF NOT EXISTS bh_key text DEFAULT NULL;

-- 2. Foreign keys to concept / concept mapping
ALTER TABLE bh_client_concept_extra
	ADD CONSTRAINT BHConcept_BHClientConceptExtra FOREIGN KEY (bh_concept_id)
		REFERENCES bh_concept (bh_concept_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE bh_client_concept_extra
	ADD CONSTRAINT BHCptMapping_BHClientCptExtra FOREIGN KEY (bh_concept_mapping_id)
		REFERENCES bh_concept_mapping (bh_concept_mapping_id) DEFERRABLE INITIALLY DEFERRED;

-- 3. Backfill existing overrides from the concept extra they pointed at
UPDATE bh_client_concept_extra cce
SET
	bh_concept_id = ce.bh_concept_id,
	bh_concept_mapping_id = ce.bh_concept_mapping_id,
	bh_key = ce.bh_key
FROM bh_concept_extra ce
WHERE cce.bh_concept_extra_id = ce.bh_concept_extra_id;

-- 4. Drop the old link to BH_Concept_Extra (and its uniqueness index)
DROP INDEX IF EXISTS bhclientconceptextra_unique;
ALTER TABLE bh_client_concept_extra
	DROP CONSTRAINT IF EXISTS BHConceptExtra_BHClientConcept;
ALTER TABLE bh_client_concept_extra
	DROP COLUMN IF EXISTS bh_concept_extra_id;

-- Each (concept/mapping, key) can only have one override per client. Concept and
-- mapping are mutually exclusive (one is NULL), so use partial indexes per type.
CREATE UNIQUE INDEX IF NOT EXISTS bhclientconceptextra_concept_unique
	ON bh_client_concept_extra (ad_client_id, bh_concept_id, bh_key)
	WHERE bh_concept_id IS NOT NULL;
CREATE UNIQUE INDEX IF NOT EXISTS bhclientconceptextra_mapping_unique
	ON bh_client_concept_extra (ad_client_id, bh_concept_mapping_id, bh_key)
	WHERE bh_concept_mapping_id IS NOT NULL;

-- 5. Application dictionary
-- Remove the old BH_Concept_Extra_ID column definition
DELETE FROM ad_column WHERE ad_column_uu = '6cc15487-3e23-4644-adf6-6cc9edde076d';

-- BH_Concept_ID (reuses the global "Concept" element)
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2026-06-17 15:45:00', '2026-06-17 15:45:00', 100, 100, 'Concept', null, null, 0, 'U', 'BH_Concept_ID', (SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU='e0672b9e-8490-4234-9648-ca62d370491e'), 19, null, null, 10, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU='f5d356cd-fdb8-4fdd-aea5-2e11726c0141'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '9fb15643-5c29-4eb8-8d0f-c0e7e995ab8c', 'Y', 0, 'N', 'N', null, 'BHConcept_BHClientConceptExtra', 'N', null, null, 'N') ON CONFLICT DO NOTHING;

-- BH_Concept_Mapping_ID (reuses the global "Concept Mapping" element)
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2026-06-17 15:45:00', '2026-06-17 15:45:00', 100, 100, 'Concept Mapping', null, null, 0, 'U', 'BH_Concept_Mapping_ID', (SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU='e0672b9e-8490-4234-9648-ca62d370491e'), 19, null, null, 100, null, 'N', 'N', 'N', 'N', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU='c4cac7f4-c555-4c34-aaaf-1c3557d7aef1'), null, 'N', 'N', null, null, null, 'N', 'Y', null, '48a7cc1d-1167-478e-885f-12f9d27765be', 'Y', 0, 'N', 'N', null, 'BHCptMapping_BHClientCptExtra', 'N', null, null, 'N') ON CONFLICT DO NOTHING;

-- BH_Key (reuses the global "Key" element)
INSERT INTO ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description, help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id, fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno, istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id, ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass, isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton, issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml) VALUES ((SELECT MAX(AD_Column_ID)+1 FROM AD_Column), 0, 0, 'Y', '2026-06-17 15:45:00', '2026-06-17 15:45:00', 100, 100, 'Key', null, null, 0, 'U', 'BH_Key', (SELECT AD_Table_ID FROM AD_Table WHERE AD_Table_UU='e0672b9e-8490-4234-9648-ca62d370491e'), 10, null, null, 0, null, 'N', 'N', 'N', 'Y', null, 'N', 0, 'N', 'N', null, null, null, null, 'N', (SELECT AD_Element_ID FROM AD_Element WHERE AD_Element_UU='54940763-649d-47b6-a79f-2a1883a49948'), null, 'N', 'N', null, null, null, 'N', 'Y', null, 'bc83c37f-9bc9-419f-96e1-2274bfbae175', 'Y', 0, 'N', 'N', null, null, 'N', null, null, 'N') ON CONFLICT DO NOTHING;

-- Register the script
SELECT register_migration_script('202606171545_GO-3463.sql') FROM dual;
