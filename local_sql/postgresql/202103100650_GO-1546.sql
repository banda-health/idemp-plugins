ALTER TABLE c_order
  ADD IF NOT EXISTS bh_visitdate timestamp default now();

-- This was changed after deploying to PROD to fix future issues
UPDATE c_order SET bh_visitdate = dateordered + interval '12 hours' WHERE bh_visitdate <= now();

SELECT register_migration_script('202103100650_GO-1546.sql') FROM dual;
