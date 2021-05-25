-- Update the visit date field to have data
UPDATE c_order SET bh_visitdate = dateordered + interval '12 hours' WHERE bh_visitdate IS NULL;

-- Configure the visit date field to have a default of now
alter table c_order alter column bh_visitdate set default now();

SELECT register_migration_script('202105251230_GO-1691.sql') FROM dual;
