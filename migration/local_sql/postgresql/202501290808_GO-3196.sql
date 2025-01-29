-- Remove a constraint we don't use anymore
ALTER TABLE bh_concept
	DROP CONSTRAINT bhconcept_ocluuid;

SELECT
	register_migration_script('202501290808_GO-3196.sql')
FROM
	dual;
