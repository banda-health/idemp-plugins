-- Update the duplicate role names to append the warehouse information
UPDATE ad_role r
SET
	name = r_n.name
FROM
	(
		SELECT
			r.ad_role_id,
			r.name || '-' || STRING_AGG(SUBSTR(w.name, 1, 1) || SUBSTR(w.m_warehouse_uu, 1, 2), ',') AS name
		FROM
			ad_role r
				JOIN bh_warehouse_access wa
					ON r.ad_role_id = wa.ad_role_id
				JOIN m_warehouse w
					ON wa.m_warehouse_id = w.m_warehouse_id
		GROUP BY r.ad_role_id
	) r_n
WHERE
	r.ad_role_id = r_n.ad_role_id;

SELECT
	register_migration_script('202509011502_GO-3424.sql')
FROM
	dual;
