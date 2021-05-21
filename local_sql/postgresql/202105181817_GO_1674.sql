-- ADD NEW DIAGNOSIS COLUMNS
ALTER TABLE c_order 
  ADD IF NOT EXISTS BH_PrimaryCodedDiagnosis_ID DECIMAL(10,0) DEFAULT NULL,
  ADD IF NOT EXISTS BH_SecondaryCodedDiagnosis_ID DECIMAL(10,0) DEFAULT NULL,
  ADD IF NOT EXISTS BH_PrimaryUnCodedDiagnosis text DEFAULT NULL,
  ADD IF NOT EXISTS BH_SecondaryUnCodedDiagnosis text DEFAULT NULL;

-- populate bh_primaryuncodeddiagnosis
UPDATE c_order SET BH_PrimaryUncodedDiagnosis = (SELECT c.description FROM c_order c WHERE c_order.c_order_id = c.c_order_id AND c.description IS NOT NULL);

-- populate bh_secondaryuncodeddiagnosis
UPDATE c_order SET BH_SecondaryUncodedDiagnosis = (SELECT c.bh_seconddiagnosis FROM c_order c WHERE c_order.c_order_id = c.c_order_id AND c.bh_seconddiagnosis IS NOT NULL);

-- we don't delete `c_order.bh_seconddiagnosis` column until all dependencies and reports are updated accordingly.

SELECT register_migration_script('202105181817_GO-1674.sql') FROM dual;
