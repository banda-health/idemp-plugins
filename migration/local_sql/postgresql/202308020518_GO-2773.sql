DROP FUNCTION IF EXISTS bh_get_visit_payments(NUMERIC, TIMESTAMP WITHOUT TIME ZONE, TIMESTAMP WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id       numeric,
		        patient_id        numeric,
		        ad_org_id         numeric,
		        c_payment_id      numeric,
		        c_order_id        numeric,
		        payamt            numeric,
		        tendertype        character,
		        payment_mode_name character varying,
		        datetrx           timestamp WITHOUT TIME ZONE,
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
	p.bh_visit_id,
	v.patient_id,
	v.ad_org_id,
	p.c_payment_id,
	i.c_order_id,
	p.payamt           AS payment_amount,
	p.tendertype       AS payment_mode_letter,
	rl.name             AS payment_mode_name,
	p.datetrx          AS payment_date,
	bp.name            AS patient_name,
	p.isallocated,
	p.c_invoice_id     AS invoice_id,
	v.createdby        AS cashier_id,
	u.name            AS cashier,
	u.ad_user_uu      AS cashier_uu,
	p.docstatus        AS docstatus,
	p.processing       AS processing,
	SUM(il.linenetamt) AS lineitemtotals,
	p.bh_tender_amount
FROM
	c_payment p
		JOIN bh_visit v
			ON p.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN begin_date AND end_date
		JOIN c_allocationline al
			ON p.c_payment_id = al.c_payment_id
		JOIN c_allocationhdr ah
			ON al.c_allocationhdr_id = ah.c_allocationhdr_id AND ah.docstatus NOT IN ('RE', 'RA', 'VO')
		JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id AND i.docstatus NOT IN ('RE', 'RA', 'VO', 'DR')
		JOIN c_invoiceline il
			ON i.c_invoice_id = il.c_invoice_id
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user u
			ON v.createdby = u.ad_user_id
		JOIN ad_ref_list rl
			ON rl.value = p.tendertype and rl.ad_reference_id = 214
WHERE
	p.ad_client_id = $1
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p.c_payment_id NOT IN (
		SELECT
			reversal_id
		FROM
			c_payment
		WHERE
			c_payment.ad_client_id = $1
			AND reversal_id IS NOT NULL
	)
GROUP BY
	p.bh_visit_id, v.patient_id, v.ad_org_id, p.c_payment_id, i.c_order_id, p.payamt, p.tendertype, rl.name, p.datetrx,
	bp.name, p.isallocated, p.c_invoice_id, v.createdby, u.name, u.ad_user_uu, p.docstatus, p.processing,
	p.bh_tender_amount;
$$;

SELECT
	register_migration_script('202308020518_GO-2773.sql')
FROM
	dual;
