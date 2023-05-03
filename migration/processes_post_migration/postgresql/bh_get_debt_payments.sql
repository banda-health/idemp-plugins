DROP FUNCTION IF EXISTS bh_get_debt_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_debt_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id         numeric,
		        c_payment_id        numeric,
		        cashier_id          numeric,
		        cashier_uu          character varying,
		        cashier             character varying,
		        payment_date        timestamp,
		        patient_id          numeric,
		        patient_uu          character varying,
		        patient_name        character varying,
		        payment_mode_letter character varying,
		        payment_mode_name   character varying,
		        totalopenbalance    numeric,
		        payment_amount      numeric,
		        docstatus           character varying,
		        processing          character varying
	        )
	LANGUAGE sql
AS
$$
SELECT
	p.bh_visit_id,
	p.c_payment_id,
	cashier.ad_user_id    AS cashier_id,
	cashier.ad_user_uu    AS cashier_uu,
	cashier.name          AS cashier,
	p.datetrx             AS payment_date,
	bp.c_bpartner_id      AS patient_id,
	bp.c_bpartner_uu      AS patient_uu,
	bp.name               AS patient_name,
	p.tendertype::varchar AS payment_mode_letter,
	rl.name               AS payment_mode_name,
	bp.totalopenbalance   AS totalopenbalance,
	p.payamt              AS payment_amount,
	p.docstatus::varchar,
	p.processing::varchar
FROM
	c_payment p
		JOIN c_bpartner bp
			ON p.c_bpartner_id = bp.c_bpartner_id
		JOIN ad_ref_list rl
			ON p.tendertype = rl.value AND AD_Reference_ID = 214
		JOIN ad_user cashier
			ON p.createdby = cashier.ad_user_id
		LEFT JOIN c_payment p2
			ON p.c_payment_id = p2.reversal_id
WHERE
	p.ad_client_id = $1
	AND p.bh_visit_id IS NULL
	AND date(p.datetrx) BETWEEN date($2) AND date($3)
	AND p.c_payment_id IN (
	SELECT
		p.c_payment_id
	FROM
		c_payment p
			LEFT JOIN c_allocationline al
				ON p.c_payment_id = al.c_payment_id
			LEFT JOIN c_invoice i
				ON al.c_invoice_id = i.c_invoice_id
			LEFT JOIN c_allocationhdr ah
				ON al.c_allocationhdr_id = ah.c_allocationhdr_id
	WHERE
		p.ad_client_id = $1
		AND (
			(
						p.isallocated = 'Y'
					AND (i.docstatus IS NULL OR i.docstatus NOT IN ('RE', 'RA', 'VO'))
					AND (ah.docstatus IS NULL OR ah.docstatus NOT IN ('RE', 'RA', 'VO'))
				)
			OR p.isallocated = 'N'
		)
)
	AND p.reversal_id IS NULL
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p2.c_payment_id IS NULL;
$$;
