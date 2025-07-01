DROP FUNCTION IF EXISTS bh_get_insurer_donor_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_insurer_donor_payments(_ad_client_id numeric, _begin_date timestamp WITHOUT TIME ZONE,
                                              _end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_payment_id        numeric,
		        cashier_id          numeric,
		        cashier_uu          character varying,
		        cashier             character varying,
		        payment_date        timestamp,
		        c_bpartner_id       numeric,
		        c_bpartner_uu       character varying,
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
	p.c_payment_id,
	cashier.ad_user_id    AS cashier_id,
	cashier.ad_user_uu    AS cashier_uu,
	cashier.name          AS cashier,
	p.datetrx             AS payment_date,
	bp.c_bpartner_id      AS c_bpartner_id,
	bp.c_bpartner_uu      AS c_bpartner_uu,
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
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN ad_ref_list rl
		ON p.tendertype = rl.value AND AD_Reference_ID = 214
		JOIN ad_user cashier
		ON p.createdby = cashier.ad_user_id
		LEFT JOIN c_payment p2
		ON p.c_payment_id = p2.reversal_id
WHERE
	p.ad_client_id = _ad_client_id
	AND p.bh_visit_id IS NULL
	AND bpg.bh_subtype IN ('I', 'D')
	AND p.datetrx::date + p.updated::time BETWEEN _begin_date AND _end_date
	AND p.bh_visit_id IS NULL
	AND p.reversal_id IS NULL
	AND p.docstatus NOT IN ('RE', 'VO')
	AND p2.c_payment_id IS NULL;
$$;
