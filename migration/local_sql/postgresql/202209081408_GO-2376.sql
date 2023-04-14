-- Update all isdisallownegativeinv column to yes except Garden World and System
UPDATE m_warehouse SET isdisallownegativeinv = 'Y' WHERE ad_client_id NOT IN (0, 11);

SELECT register_migration_script('202209081408_GO-2376.sql') FROM dual;
