DELETE FROM bh_observation WHERE REGEXP_REPLACE(bh_value, E'[\n]+', '', 'g') LIKE 'History: Physical Exam: Treatment: ';

SELECT
	register_migration_script('202409131030_GO-3071.sql')
FROM
	dual;
