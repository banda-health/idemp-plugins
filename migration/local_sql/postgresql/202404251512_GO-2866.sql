ALTER TABLE
    bh_encounter
ADD
    COLUMN IF NOT EXISTS bh_encounter_date TIMESTAMP DEFAULT NULL;

-- COPY EXISTING RECORDS IN created column
UPDATE
    bh_encounter
SET
    bh_encounter_date = created;


SELECT
	register_migration_script('202404251512_GO-2866.sql')
FROM
	dual;    