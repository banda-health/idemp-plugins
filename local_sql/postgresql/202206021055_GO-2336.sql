DELETE FROM m_storageonhand WHERE m_attributesetinstance_id = 0 and qtyonhand > 0;

SELECT register_migration_script('202206021055_GO-2336.sql') FROM dual;
