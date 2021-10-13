ALTER TABLE m_movement
 ADD IF NOT EXISTS BH_From_Warehouse_ID numeric(10) DEFAULT NULL;
 
ALTER TABLE m_movement 
 ADD IF NOT EXISTS BH_To_Warehouse_ID numeric(10) DEFAULT NULL;


SELECT register_migration_script('202110131559_GO-1806.sql') FROM dual;
