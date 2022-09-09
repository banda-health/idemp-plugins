-- Update all isdisallownegativeinv column to yes except Garden World and System
update m_warehouse set isdisallownegativeinv = 'Y' where ad_client_id not in (0, 11);

SELECT register_migration_script('202209081408_GO-2376.sql') FROM dual;