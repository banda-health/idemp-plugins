-- Disable the scheduler
UPDATE ad_scheduler
SET
	isactive = 'N'
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '1d5191dd-4792-464f-94c5-5b4d652e5fe5'
	);

/**********************************************************************************************************/
-- Remove System Configurator value that was for synchronous order completion
/**********************************************************************************************************/
DELETE
FROM
	ad_sysconfig
WHERE
	name = 'CLIENT_IDS_FOR_SYNCHRONOUS_SALES_ORDER_PROCESSING';
ALTER TABLE ad_sysconfig
	ALTER COLUMN value TYPE varchar;

/**********************************************************************************************************/
-- Remove the expense deletion process
/**********************************************************************************************************/
-- Delete process parameter relations
DELETE
FROM
	ad_process_para_trl
WHERE
		ad_process_para_id IN (
		SELECT
			ad_process_para_id
		FROM
			ad_process_para
		WHERE
				ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
						ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
			)
	);
DELETE
FROM
	ad_process_para
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Delete process translations
DELETE
FROM
	ad_process_trl
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Handle ad_column associations
DELETE
FROM
	ad_field_trl
WHERE
		ad_field_id IN (
		SELECT
			ad_field_id
		FROM
			ad_field
		WHERE
				ad_column_id IN (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
						ad_process_id IN (
						SELECT
							ad_process_id
						FROM
							ad_process
						WHERE
								ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
					)
			)
	);
DELETE
FROM
	ad_Field
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
						ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
			)
	);
DELETE
FROM
	ad_column_trl
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
						ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
			)
	);
DELETE
FROM
	bh_tabnavbtn_tab_trl
WHERE
		bh_tabnavbtn_tab_id IN (
		SELECT
			bh_tabnavbtn_tab_id
		FROM
			bh_tabnavbtn_tab
		WHERE
				bh_tabnavbtn_id IN (
				SELECT
					bh_tabnavbtn_id
				FROM
					bh_tabnavbtn
				WHERE
						ad_column_id IN (
						SELECT
							ad_column_id
						FROM
							ad_column
						WHERE
								ad_process_id IN (
								SELECT
									ad_process_id
								FROM
									ad_process
								WHERE
										ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
							)
					)
			)
	);
DELETE
FROM
	bh_tabnavbtn_tab
WHERE
		bh_tabnavbtn_id IN (
		SELECT
			bh_tabnavbtn_id
		FROM
			bh_tabnavbtn
		WHERE
				ad_column_id IN (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
						ad_process_id IN (
						SELECT
							ad_process_id
						FROM
							ad_process
						WHERE
								ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
					)
			)
	);
DELETE
FROM
	bh_tabnavbtn_trl
WHERE
		bh_tabnavbtn_id IN (
		SELECT
			bh_tabnavbtn_id
		FROM
			bh_tabnavbtn
		WHERE
				ad_column_id IN (
				SELECT
					ad_column_id
				FROM
					ad_column
				WHERE
						ad_process_id IN (
						SELECT
							ad_process_id
						FROM
							ad_process
						WHERE
								ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
					)
			)
	);
DELETE
FROM
	bh_tabnavbtn
WHERE
		ad_column_id IN (
		SELECT
			ad_column_id
		FROM
			ad_column
		WHERE
				ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
						ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
			)
	);
DELETE
FROM
	ad_column
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Handle package export associations
DELETE
FROM
	ad_package_exp_detail
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Handle process instances
DELETE
FROM
	ad_pinstance_para
WHERE
		ad_pinstance_id IN (
		SELECT
			ad_pinstance_id
		FROM
			ad_pinstance
		WHERE
				ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
						ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
			)
	);
DELETE
FROM
	ad_pinstance
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN (
				                  'a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Handle process access removal
DELETE
FROM
	ad_process_access
WHERE
		ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
				ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4')
	);

-- Finally, delete the process...
DELETE
FROM
	ad_process
WHERE
		ad_process_uu IN ('a144d5d3-0a3f-42a7-820a-23585c767f8b', '06780c3f-8482-439d-a878-2f61878535e4');

SELECT
	register_migration_script('202301131045_GO-2530.sql')
FROM
	dual;
