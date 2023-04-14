-- Get visits payments function.
-- On this issue I added the bh_c_order_id column to this function

DROP FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp, end_date timestamp);
CREATE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id        numeric,
		        bh_c_order_id     numeric,
		        ad_org_id         numeric,
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
		        linenetamt        numeric
	        )
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN QUERY
		SELECT
			c.c_order_id,
			p.bh_c_order_id,
			c.ad_org_id,
			p.payamt           AS payment_amount,
			p.tendertype       AS payment_mode_letter,
			r.name             AS payment_mode_name,
			p.datetrx          AS payment_date,
			cb.name            AS patient_name,
			p.isallocated,
			p.c_invoice_id     AS invoice_id,
			c.createdby        AS cashier_id,
			ad.name            AS cashier,
			ad.ad_user_uu      AS cashier_uu,
			c.docstatus        AS docstatus,
			c.processing       AS processing,
			SUM(ol.linenetamt) AS lineitemtotals
		FROM
			c_payment p
				LEFT JOIN c_allocationline al
					ON p.c_payment_id = al.c_payment_id
				LEFT JOIN c_invoice i
					ON al.c_invoice_id = i.c_invoice_id
				JOIN c_order c
					ON i.c_order_id = c.c_order_id OR p.bh_c_order_id = c.c_order_id
				JOIN c_orderline ol
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
			c.ad_client_id = $1
			AND ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
			AND ol.c_charge_id IS NULL
			AND c.issotrx = 'Y'
			AND c.bh_visitdate BETWEEN $2 AND $3
		GROUP BY
			c.c_order_id, c.ad_org_id, p.payamt, p.tendertype, r.name, p.datetrx, cb.name, p.isallocated,
			p.c_invoice_id, c.createdby, ad.name, ad.ad_user_uu, c.docstatus, c.processing,p.bh_c_order_id;
END
$$;

SELECT register_migration_script('202207211700_GO-2390.sql') FROM dual;

