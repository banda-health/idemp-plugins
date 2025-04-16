-- Delete duplicate concept names
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_name_id IN (
		SELECT
			bh_concept_name_id
		FROM
			(
				SELECT
					bh_concept_name_id,
						ROW_NUMBER() OVER (PARTITION BY bh_concept_id, ocl_uuid ORDER BY isactive DESC, created) AS row_num
				FROM
					bh_concept_name
			) t
		WHERE
			t.row_num != 1
	);

DELETE
FROM
	bh_concept_description
WHERE
	bh_concept_description_id IN (
		SELECT
			bh_concept_description_id
		FROM
			(
				SELECT
					bh_concept_description_id,
						ROW_NUMBER() OVER (PARTITION BY bh_concept_id, ocl_uuid ORDER BY isactive DESC, created) AS row_num
				FROM
					bh_concept_description
			) t
		WHERE
			t.row_num != 1
	);

SELECT
	register_migration_script('202504161509_GO-3276.sql')
FROM
	dual;
