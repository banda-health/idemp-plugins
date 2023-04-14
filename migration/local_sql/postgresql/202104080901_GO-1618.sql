-- Update wrong visit dates
UPDATE c_order SET bh_visitdate = dateordered + interval '12 hours'
WHERE bh_visitdate != dateordered + interval '12 hours' AND bh_visitdate < '2021-04-08 06:30:00';

SELECT register_migration_script('202104080901_GO-1618.sql') FROM dual;
