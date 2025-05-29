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
	ad_window
WHERE
	ad_window_uu IN ('e1814cba-b1d8-42f4-96dd-ffb4ec6da44f', '464bf9dd-28f0-4be7-97ed-ad6f9f3da83b',
	                 '1ff826b1-47e3-4101-b2a3-75ed84aafbbd');

SELECT
	register_migration_script('202505201648_GO-3326.sql')
FROM
	dual;
