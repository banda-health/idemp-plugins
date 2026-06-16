-- GO-3613: Repair malformed *_uu values (leading tabs/whitespace, truncated UUIDs)
-- before IDEMPIERE-6650 attempts to cast them to native uuid.

DO
$$
	DECLARE
		r       RECORD;
		v_sql   text;
		uuid_re text := '^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$';
	BEGIN
		-- Only touch string-typed *_uu columns; iD13 uuid columns will be excluded.
		FOR r IN
			SELECT
				c.table_schema,
				c.table_name,
				c.column_name
			FROM
				information_schema.columns c
					JOIN information_schema.tables t
						ON t.table_schema = c.table_schema
					AND t.table_name = c.table_name
			WHERE
				c.table_schema = 'adempiere'
				AND t.table_type = 'BASE TABLE'
				AND c.column_name LIKE '%\_uu' ESCAPE '\'
					AND c.data_type IN ('character varying', 'text', 'character')
			LOOP
				v_sql := FORMAT($FMT$
            UPDATE %I.%I
            SET %I =
                CASE
                    WHEN btrim(%I::text) ~ %L THEN btrim(%I::text)
                    ELSE uuid_generate_v4()::text
                END
            WHERE %I IS NOT NULL
              AND (
                    btrim(%I::text) = '' OR
                    btrim(%I::text) !~ %L
                  );
        $FMT$,
				                r.table_schema, r.table_name, r.column_name,
				                r.column_name, uuid_re, r.column_name,
				                r.column_name,
				                r.column_name, r.column_name, uuid_re
				         );

				EXECUTE v_sql;
			END LOOP;
	END;
$$;

SELECT
	register_migration_script('202606161447_GO-3613.sql')
FROM
	dual;
