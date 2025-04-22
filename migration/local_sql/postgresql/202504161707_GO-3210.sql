-- Try to speed up order line deletes with an index on a new(er) column
CREATE INDEX c_orderline_linkorderline_idx ON c_orderline (link_orderline_id);

SELECT
	register_migration_script('202504161707_GO-3210.sql')
FROM
	dual;
