DROP FUNCTION IF EXISTS bh_get_visit_payments(NUMERIC, TIMESTAMP WITHOUT TIME ZONE, TIMESTAMP WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id        numeric,
		        bh_c_order_id     numeric,
		        ad_org_id         numeric,
		        c_payment_id      numeric,
		        payamt            numeric,
		        tendertype        character,
		        payment_mode_name character varying,
		        datetrx           timestamp WITHOUT TIME ZONE,
		        patient_id        numeric,
		        patient_name      character varying,
		        isallocated       character,
		        invoice_id        numeric,
		        cashier_id        numeric,
		        cashier           character varying,
		        cashier_uu        character varying,
		        docstatus         character,
		        processing        character,
		        linenetamt        numeric,
		        tender_amt        numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	c.c_order_id,
	p.bh_c_order_id,
	c.ad_org_id,
	p.c_payment_id,
	p.payamt        AS payment_amount,
	p.tendertype    AS payment_mode_letter,
	r.name          AS payment_mode_name,
	p.datetrx       AS payment_date,
	p.c_bpartner_id AS patient_id,
	cb.name         AS patient_name,
	p.isallocated,
	p.c_invoice_id  AS invoice_id,
	c.createdby     AS cashier_id,
	ad.name         AS cashier,
	ad.ad_user_uu   AS cashier_uu,
	c.docstatus     AS docstatus,
	c.processing    AS processing,
	ol.linenetamt   AS lineitemtotals,
	p.bh_tender_amount
FROM
	c_payment p
		JOIN c_order c
			ON p.bh_c_order_id = c.c_order_id AND c.issotrx = 'Y' AND c.bh_visitdate BETWEEN begin_date AND end_date
		JOIN (
		SELECT
			c_order_id,
			SUM(linenetamt) AS linenetamt
		FROM
			c_orderline
		WHERE
			c_charge_id IS NULL
			AND c_orderline.ad_client_id = $1
		GROUP BY c_order_id
	) ol
			ON c.c_order_id = ol.c_order_id
		JOIN c_bpartner cb
			ON c.c_bpartner_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON c.createdby = ad.ad_user_id
		JOIN ad_ref_list r
			ON r.value = p.tendertype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
WHERE
	p.ad_client_id = $1
	AND ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p.c_payment_id NOT IN (
	SELECT
		reversal_id
	FROM
		c_payment
	WHERE
		c_payment.ad_client_id = $1
		AND reversal_id IS NOT NULL
);
$$;
