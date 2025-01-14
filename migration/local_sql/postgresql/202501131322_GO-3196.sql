-- Since we have duplicates, get the concept ID to use and map everything to it while deleting the old stuff
WITH ocl_counts AS (
	SELECT
		bh_concept_id,
		url,
		ROW_NUMBER() OVER (PARTITION BY url ORDER BY created DESC) AS counter
	FROM
		bh_concept
)
SELECT
	c_old.bh_concept_id old_bh_concept_id,
	c_new.bh_concept_id new_bh_concept_id
INTO TEMP TABLE
	tmp_bh_concept_updates
FROM
	ocl_counts AS c_new
		JOIN ocl_counts c_old
		ON c_old.counter != 1 AND c_new.url = c_old.url
WHERE
	c_new.counter = 1;

UPDATE bh_encounter_diagnosis ed
SET
	bh_concept_id = tcu.new_bh_concept_id
FROM
	tmp_bh_concept_updates tcu
WHERE
	ed.bh_concept_id = tcu.old_bh_concept_id;
UPDATE bh_encounter_diagnostic ed
SET
	bh_concept_id = tcu.new_bh_concept_id
FROM
	tmp_bh_concept_updates tcu
WHERE
	ed.bh_concept_id = tcu.old_bh_concept_id;
UPDATE bh_client_concept cc
SET
	bh_concept_id = tcu.new_bh_concept_id
FROM
	tmp_bh_concept_updates tcu
WHERE
	cc.bh_concept_id = tcu.old_bh_concept_id;

DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IN (
		SELECT
			bh_concept_mapping_id
		FROM
			bh_concept_mapping
		WHERE
			from_bh_concept_id IN (
				SELECT
					old_bh_concept_id
				FROM
					tmp_bh_concept_updates
			)
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	from_bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IN (
		SELECT
			bh_concept_mapping_id
		FROM
			bh_concept_mapping
		WHERE
			to_bh_concept_id IN (
				SELECT
					old_bh_concept_id
				FROM
					tmp_bh_concept_updates
			)
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	to_bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
DELETE
FROM
	bh_concept_description
WHERE
	bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
DELETE
FROM
	bh_ocl_originating_source
WHERE
	bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	bh_concept
WHERE
	bh_concept_id IN (
		SELECT
			old_bh_concept_id
		FROM
			tmp_bh_concept_updates
	);
$$, 'bh_concept_id');

SELECT
	register_migration_script('202501131322_GO-3196.sql')
FROM
	dual;
