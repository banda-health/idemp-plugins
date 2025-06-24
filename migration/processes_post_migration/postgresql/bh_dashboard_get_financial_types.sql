DROP FUNCTION IF EXISTS bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp);
CREATE OR REPLACE FUNCTION bh_dashboard_get_financial_types(_ad_client_id numeric, _begin_date timestamp, _end_date timestamp)
	RETURNS table
	        (
		        name      character varying,
		        frequency numeric,
		        type      character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	chargetype_name      AS name,
	SUM(linenetamt) * -1 AS frequency,
	'Income'             AS type
FROM
	bh_get_visit_non_patient_payments(_ad_client_id, _begin_date, _end_date)
GROUP BY
	chargetype_name
UNION ALL
SELECT
	payment_mode_name AS name,
	SUM(payamt)       AS frequency,
	'Income'          AS type
FROM
	bh_get_visit_payments(_ad_client_id, _begin_date, _end_date)
GROUP BY
	payment_mode_name
UNION ALL
SELECT
	c.Name              AS name,
	SUM(cil.linenetamt) AS frequency,
	'Expense'
FROM
	c_invoice i
		JOIN c_invoiceline cil
		ON cil.c_invoice_id = i.c_invoice_id
		JOIN c_charge c
		ON c.c_charge_id = cil.c_charge_id
WHERE
	i.ad_client_id = _ad_client_id
	AND i.docstatus = 'CO'
	AND i.issotrx = 'N'
	AND i.bh_visit_id IS NULL
	AND i.dateinvoiced BETWEEN _begin_date AND _end_date
GROUP BY
	c.Name
$$;
