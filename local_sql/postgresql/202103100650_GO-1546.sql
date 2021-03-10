ALTER TABLE c_order
  ADD IF NOT EXISTS bh_visitdate timestamp;

UPDATE c_order SET bh_visitdate = dateordered + interval '12 hours' WHERE bh_visitdate IS NULL;

SELECT register_migration_script('202103100650_GO-1546.sql') FROM dual;
