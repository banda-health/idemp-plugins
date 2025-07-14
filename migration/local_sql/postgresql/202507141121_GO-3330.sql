DROP FUNCTION IF EXISTS bh_get_bpartner_balance_transactions(_ad_client_id numeric);
CREATE OR REPLACE FUNCTION bh_get_bpartner_balance_transactions(_ad_client_id numeric)
	RETURNS table
	        (
		        ad_client_id  numeric,
		        c_invoice_id  numeric,
		        c_bpartner_id numeric,
		        c_payment_id  numeric,
		        amount        numeric,
		        bh_visit_id   numeric,
		        date          timestamp,
		        createdby     numeric,
		        open_balance  numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT *,
	SUM(amount) OVER ( PARTITION BY c_bpartner_id ORDER BY date ) AS open_balance
FROM
	(
		SELECT
			ad_client_id,
			c_invoice_id,
			c_bpartner_id,
			NULL::numeric                      AS c_payment_id,
			grandtotal                         AS amount,
			bh_visit_id,
			dateinvoiced::date + created::time AS date,
			createdby
		FROM
			c_invoice
		WHERE
			ad_client_id = _ad_client_id
			AND docstatus IN ('CO', 'CL', 'VO', 'RE', 'RA')
		UNION ALL
		SELECT
			ad_client_id,
			NULL,
			c_bpartner_id,
			c_payment_id,
			payamt * -1,
			bh_visit_id,
			datetrx::date + created::time,
			createdby
		FROM
			c_payment
		WHERE
			ad_client_id = _ad_client_id
			AND docstatus IN ('CO', 'CL', 'VO', 'RE', 'RA')
	) b
$$;

SELECT
	register_migration_script('202507141121_GO-3330.sql')
FROM
	dual;
