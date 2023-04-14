DROP FUNCTION IF EXISTS bh_execute_statement_without_indexes(varchar, varchar);
CREATE OR REPLACE FUNCTION bh_execute_statement_without_indexes(_sql_to_execute varchar, _column_to_remove_indexes_from varchar)
	RETURNS void
AS
$$
DECLARE
	statement varchar;
BEGIN
	DROP TABLE IF EXISTS tmp_constraint_deletions;
	DROP TABLE IF EXISTS tmp_constraint_additions;

	CREATE TEMP TABLE tmp_constraint_deletions
	(
		statement varchar
	);
	CREATE TEMP TABLE tmp_constraint_additions
	(
		statement varchar
	);

	-- Fetch the constraints
	INSERT INTO tmp_constraint_deletions
	SELECT
								'ALTER TABLE ' || nspname || '."' || relname || '" DROP CONSTRAINT "' || conname || '";'
	FROM
		pg_constraint
			INNER JOIN pg_class
				ON conrelid = pg_class.oid
			INNER JOIN pg_namespace
				ON pg_namespace.oid = pg_class.relnamespace
	WHERE
			LOWER(PG_GET_CONSTRAINTDEF(pg_constraint.oid)) LIKE '%' || LOWER('c_elementvalue_id') || '%'
		AND contype != 'p'
	ORDER BY CASE WHEN contype = 'f' THEN 0 ELSE 1 END, contype, nspname, relname, conname;

	INSERT INTO tmp_constraint_additions
	SELECT
										'ALTER TABLE ' || nspname || '."' || relname || '" ADD CONSTRAINT "' || conname || '" ' ||
										PG_GET_CONSTRAINTDEF(pg_constraint.oid) || ';'
	FROM
		pg_constraint
			INNER JOIN pg_class
				ON conrelid = pg_class.oid
			INNER JOIN pg_namespace
				ON pg_namespace.oid = pg_class.relnamespace
	WHERE
			LOWER(PG_GET_CONSTRAINTDEF(pg_constraint.oid)) LIKE '%' || LOWER(_column_to_remove_indexes_from) || '%'
		AND contype != 'p'
	ORDER BY CASE WHEN contype = 'f' THEN 0 ELSE 1 END DESC, contype DESC, nspname DESC, relname DESC, conname DESC;

	-- Drop the constraints
	FOR statement IN SELECT * FROM tmp_constraint_deletions
		LOOP
			EXECUTE statement;
		END LOOP;

	-- Execute the SQL passed in
	EXECUTE _sql_to_execute;

	-- Re-add the constraints
	FOR statement IN SELECT * FROM tmp_constraint_additions
		LOOP
			EXECUTE statement;
		END LOOP;

	-- Clean up
	DROP TABLE IF EXISTS tmp_constraint_deletions;
	DROP TABLE IF EXISTS tmp_constraint_additions;
END
$$
	LANGUAGE plpgsql;
	