DROP FUNCTION IF EXISTS bh_dashboard_get_financial_open_balances(numeric);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_open_balances(_ad_client_id numeric)
	RETURNS table
	        (
		        name             character varying,
		        totalopenbalance numeric,
		        type             character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			bp.name             AS name,
			bp.totalopenbalance AS totalopenbalance,
			'Patient'           AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND bpg.name = 'Patients - DO NOT CHANGE'
		GROUP BY
			bp.name, bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		LIMIT 10
	) AS summary1

UNION ALL

SELECT
	name,
	SUM(totalopenbalance) AS totalopenbalance,
	type
FROM
	(
		SELECT
			'Other'                  AS name,
			SUM(bp.totalopenbalance) AS totalopenbalance,
			'Patient'                AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND bpg.name = 'Patients - DO NOT CHANGE'
		GROUP BY bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		OFFSET 10
	) AS summary2
GROUP BY
	name, type

UNION ALL

SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			bp.name             AS name,
			bp.totalopenbalance AS totalopenbalance,
			'Provider'          AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND
			bpg.name IN ('Capitation Insurance - DO NOT CHANGE', 'Donors - DO NOT CHANGE', 'FFS Insurance - DO NOT CHANGE')
		ORDER BY bp.totalopenbalance DESC
		LIMIT 10
	) AS summary3

UNION ALL

SELECT
	name,
	totalopenbalance,
	type
FROM
	(
		SELECT
			'Other'                  AS name,
			SUM(bp.totalopenbalance) AS totalopenbalance,
			'Provider'               AS type
		FROM
			c_bpartner bp
				LEFT JOIN c_payment p
				ON bp.c_bpartner_id = p.c_bpartner_id
				JOIN c_bp_group bpg
				ON bp.c_bp_group_id = bpg.c_bp_group_id
		WHERE
			bp.ad_client_id = _ad_client_id
			AND bp.totalopenbalance != 0
			AND
			bpg.name IN ('Capitation Insurance - DO NOT CHANGE', 'Donors - DO NOT CHANGE', 'FFS Insurance - DO NOT CHANGE')
		GROUP BY bp.totalopenbalance
		ORDER BY bp.totalopenbalance DESC
		OFFSET 10
	) AS summary2;
$$;
