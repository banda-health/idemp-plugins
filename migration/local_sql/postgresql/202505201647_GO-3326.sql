DELETE
FROM
	ad_treenodemm
WHERE
	node_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);

DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_menu_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);

DELETE
FROM
	ad_menu
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);

DELETE
FROM
	ad_preference
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);

DELETE
FROM
	ad_window_trl
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);

DELETE
FROM
	ad_window_access
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);

DELETE
FROM
	ad_tab
WHERE
	ad_table_id IN (
		SELECT
			ad_table_id
		FROM
			ad_table
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);

DELETE
FROM
	ad_table
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);

DELETE
FROM
	ad_tab_trl
WHERE
	ad_tab_id IN (
		SELECT
			ad_tab_id
		FROM
			ad_tab
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);

DELETE
FROM
	ad_recentitem
WHERE
	ad_tab_id IN (
		SELECT
			ad_tab_id
		FROM
			ad_tab
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);

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
			ad_tab_id IN (
				SELECT
					ad_tab_id
				FROM
					ad_tab
				WHERE
					ad_window_id IN (
						SELECT
							ad_window_id
						FROM
							ad_window
						WHERE
							ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
							                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
					)
			)
	);

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	ad_field
WHERE
	ad_tab_id IN (
		SELECT
			ad_tab_id
		FROM
			ad_tab
		WHERE
			ad_window_id IN (
				SELECT
					ad_window_id
				FROM
					ad_window
				WHERE
					ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
					                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
			)
	);$$, 'ad_field_id');

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	ad_tab
WHERE
	ad_window_id IN (
		SELECT
			ad_window_id
		FROM
			ad_window
		WHERE
			ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
			                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd')
	);$$, 'ad_tab_id');

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	ad_window
WHERE
	ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
	                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd');$$, 'ad_window_id');

SELECT
	register_migration_script('202505201647_GO-3326.sql')
FROM
	dual;
