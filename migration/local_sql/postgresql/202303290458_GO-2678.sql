CREATE INDEX IF NOT EXISTS bh_orderline_charge_info_c_orderline
	ON bh_orderline_charge_info (c_orderline_id);

SELECT
	register_migration_script('202303290458_GO-2678.sql')
FROM
	dual;
