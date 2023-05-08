-- Deleting from ad_process_para table
DELETE
FROM
	ad_process_para
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
	);

-- Deleting from ad_process_access table
DELETE
FROM
	ad_process_access
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
	);

-- Deleting from ad_process_trl table
DELETE
FROM
	ad_process_trl
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
	);

-- Deleting from ad_pinstance and ad_pinstance_para table
DELETE
FROM
	ad_pinstance ap
	USING ad_pinstance_para app
WHERE
	ap.ad_pinstance_id = app.ad_pinstance_id
	AND ap.ad_process_id = (
	SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
);

-- Deleting from ad_package_exp_detail table
DELETE
FROM
	ad_package_exp_detail ad
	USING ad_menu am
WHERE
	am.ad_menu_id = ad.ad_menu_id
	AND am.ad_process_id = (
	SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
);


-- Deleting from ad_menu
DELETE
FROM
	ad_menu
WHERE
		ad_process_id = (
		SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0'
	);

-- Deleting from ad_process table
DELETE
FROM
	ad_process
WHERE
	ad_process_uu = 'ad3da529-459a-4804-8020-5f192360fed0';

-- Finishing Up
SELECT
	register_migration_script('202305041300_GO-2694.sql')
FROM
	dual;
