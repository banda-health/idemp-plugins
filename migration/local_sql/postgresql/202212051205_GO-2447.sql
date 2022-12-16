-- Update the reports to point to the c_order table since most reports deal with orders (and iDempiere can better handle access)
UPDATE ad_tab
SET
	ad_table_id = 259
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'
	);

-- Make sure all existing admins can see the Reports window
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	w.ad_window_id,
	r.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_client c
		JOIN ad_role r
			ON c.ad_client_id = r.ad_client_id
		CROSS JOIN ad_window w
WHERE
	r.ismanual = 'N'
	AND r.name = c.name || ' Admin'
	AND w.ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'
	AND r.ad_role_id NOT IN (
	SELECT
		ad_role_id
	FROM
		ad_window_access wa
			JOIN ad_window w
				ON wa.ad_window_id = w.ad_window_id
	WHERE
		w.ad_window_uu = '584a4f57-33c6-460e-9916-9ad0347cac5b'
);

SELECT
	register_migration_script('202212051205_GO-2447.sql')
FROM
	dual;
