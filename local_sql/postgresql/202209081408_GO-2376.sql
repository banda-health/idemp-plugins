-- Update all isdisallownegativeinv column to yes
update m_warehouse set isdisallownegativeinv = 'Y';

SELECT register_migration_script('202209081408_GO-2376.sql') FROM dual;