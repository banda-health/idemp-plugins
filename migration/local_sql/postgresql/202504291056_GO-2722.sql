DELETE
FROM
	ad_schedulerrecipient
WHERE
	ad_scheduler_id IN (
		SELECT
			ad_scheduler_id
		FROM
			ad_scheduler
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
					                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
					                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
			)
	);

DELETE
FROM
	ad_scheduler
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
	);

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
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
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
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
	);

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
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
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
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
	);

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
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
	);

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
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
					                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
					                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
			)
	)
	OR parent_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
					                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
					                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
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
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
					                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
					                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
			)
	);

DELETE
FROM
	ad_menu
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
			                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
			                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5')
	);

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	ad_process
WHERE
	ad_process_uu IN ('ba579d7e-b70d-4787-af62-1a82dfc3651a', 'ac46df9f-1091-4653-b308-b3f2d0484443',
	                  'a4d3210b-6dc8-44d3-bfbc-58e507078c30', 'c5f39620-b2dc-42ad-8626-7713c4f22e0c',
	                  '1d5191dd-4792-464f-94c5-5b4d652e5fe5');
$$, 'ad_process_id');

SELECT
	register_migration_script('202504291056_GO-2722.sql')
FROM
	dual;
