-- GO-3682: Scope visit payment helpers by optional bh_visit_ids so single-visit reports
-- (bill invoice, thermal receipt) and payment trail do not scan the whole client.
-- NULL bh_visit_ids keeps existing client+date behavior; empty array matches no visits.

DROP FUNCTION IF EXISTS bh_get_visit_payments(NUMERIC, TIMESTAMP WITHOUT TIME ZONE, TIMESTAMP WITHOUT TIME ZONE);
DROP FUNCTION IF EXISTS bh_get_visit_payments(NUMERIC, TIMESTAMP WITHOUT TIME ZONE, TIMESTAMP WITHOUT TIME ZONE, NUMERIC[]);
CREATE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE,
                                      bh_visit_ids numeric[] DEFAULT NULL)
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
		LEFT JOIN UNNEST($4) AS vid(bh_visit_id)
			ON vid.bh_visit_id = p.bh_visit_id
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
	AND ($4 IS NULL OR vid.bh_visit_id IS NOT NULL)
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

DROP FUNCTION IF EXISTS bh_get_visit_non_patient_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
DROP FUNCTION IF EXISTS bh_get_visit_non_patient_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE, numeric[]);
CREATE FUNCTION bh_get_visit_non_patient_payments(ad_client_id numeric,
                                                  begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                  end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE,
                                                  bh_visit_ids numeric[] DEFAULT NULL)
	RETURNS TABLE
	        (
		        bh_visit_id         numeric,
		        c_invoice_id        numeric,
		        chargetype_name     character varying,
		        bh_subtype          character varying,
		        charge_subtype_name character varying,
		        linenetamt          numeric,
		        member_id           character varying,
		        membername          character varying,
		        claimno             character varying,
		        relationship        character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
-- Get insurance and donors
SELECT
	v.bh_visit_id,
	i.c_invoice_id,
	bp.name            AS ChargeType_name,
	bpg.bh_subtype,
	rl.name            AS charge_subtype_name,
	il.linenetamt * -1 AS linenetamt,
	bpspii.name        AS member_id,
	bpspicl.name       AS MemberName,
	bpspibp.name       AS ClaimNo,
	bpspir.name        AS Relationship
FROM
	bh_visit v
		LEFT JOIN UNNEST($4) AS vid(bh_visit_id)
		ON vid.bh_visit_id = v.bh_visit_id
		JOIN c_invoice i
		ON v.bh_visit_id = i.bh_visit_id AND i.docstatus NOT IN ('VO', 'RE', 'RA')
		JOIN c_bpartner bp
		ON i.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN c_invoiceline il
		ON i.c_invoice_id = il.c_invoice_id
		JOIN ad_ref_list rl
		ON rl.value = bpg.bh_subtype
		JOIN ad_reference r
		ON rl.ad_reference_id = r.ad_reference_id AND ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Member ID', 'NHIF Number', 'SHA Number', 'Patient ID') OR pif.name IS NULL)
	) AS bpspii
		ON bpspii.c_invoiceline_id = il.c_invoiceline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Patient Name', 'Member Name', 'Mother''s Name') OR pif.name IS NULL)
	) bpspicl
		ON bpspicl.c_invoiceline_id = il.c_orderline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Claim Number') OR pif.name IS NULL)
			AND (pif.bh_payerinfofielddatatype = 'T' AND pif.bh_fillfrompatient = 'N')
	) bpspibp
		ON bpspibp.c_invoiceline_id = il.c_invoiceline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Relationship') OR pif.name IS NULL)
			AND (pif.bh_payerinfofielddatatype = 'L' AND pif.bh_fillfrompatient = 'Y')
	) bpspir
		ON bpspir.c_invoiceline_id = il.c_invoiceline_id
WHERE
	v.ad_client_id = $1
	AND v.bh_visitdate BETWEEN $2 AND $3
	AND ($4 IS NULL OR vid.bh_visit_id IS NOT NULL)
	AND bpg.bh_subtype IN ('I', 'D')
UNION ALL
-- Get waivers
SELECT
	v.bh_visit_id,
	i.c_invoice_id,
	c.name  AS ChargeType_name,
	rl.value,
	rl.name AS charge_subtype_name,
	il.linenetamt,
	NULL    AS member_id,
	NULL    AS MemberName,
	NULL    AS ClaimNo,
	NULL    AS Relationship
FROM
	bh_visit v
		LEFT JOIN UNNEST($4) AS vid(bh_visit_id)
		ON vid.bh_visit_id = v.bh_visit_id
		JOIN c_invoice i
		ON v.bh_visit_id = i.bh_visit_id AND i.docstatus NOT IN ('VO', 'RA', 'RE')
		JOIN c_invoiceline il
		ON i.c_invoice_id = il.c_invoice_id
		JOIN c_charge c
		ON il.c_charge_id = c.c_charge_id
		JOIN ad_ref_list rl
		ON c.bh_subtype = rl.value AND rl.value = 'W'
		JOIN ad_reference r
		ON r.ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375' AND r.ad_reference_id = rl.ad_reference_id
WHERE
	v.ad_client_id = $1
	AND v.bh_visitdate BETWEEN $2 AND $3
	AND ($4 IS NULL OR vid.bh_visit_id IS NOT NULL);
$$;

DROP FUNCTION IF EXISTS bh_get_payment_trail(character varying);
CREATE FUNCTION bh_get_payment_trail(_c_bpartner_uu character varying)
	RETURNS TABLE
	        (
		        c_bpartner_id        numeric,
		        patient_name         character varying,
		        transaction_date     timestamp WITHOUT TIME ZONE,
		        created              timestamp WITHOUT TIME ZONE,
		        updated              timestamp WITHOUT TIME ZONE,
		        item                 text,
		        debits               numeric,
		        credits              numeric,
		        patient_open_balance numeric,
		        bh_visit_id          numeric,
		        c_invoice_id         numeric,
		        c_payment_id         numeric,
		        createdby            numeric
	        )
	STABLE
	LANGUAGE sql
AS
$$
WITH visit_payments AS (
	SELECT
		c_order_id,
		SUM(payamt) AS payamt
	FROM
		c_bpartner bp
			JOIN bh_get_visit_payments(
				bp.ad_client_id,
				'-infinity'::timestamp,
				'infinity'::timestamp,
				COALESCE(
					(SELECT ARRAY_AGG(v.bh_visit_id) FROM bh_visit v WHERE v.patient_id = bp.c_bpartner_id),
					ARRAY []::numeric[]
				)
			) gvp
				ON gvp.patient_id = bp.c_bpartner_id
	WHERE
		bp.c_bpartner_uu = _c_bpartner_uu
	GROUP BY c_order_id
),
	transactions AS (
		-- Sum all the payments and group them by date
		SELECT
			bh_visit_id,
			c_invoice_id,
			c_payment_id,
			c_payment_docstatus,
			createdby,
			c_bpartner_id,
			date,
			created,
			updated,
			"type"                                               AS item,
			COALESCE(SUM(debits), 0)                             AS debits,
			COALESCE(SUM(credits), 0)                            AS credits,
			COALESCE(SUM(debits), 0) - COALESCE(SUM(credits), 0) AS net
		FROM
			(
				-- Bills
				SELECT
					v.bh_visit_id,
					NULL::numeric                                        AS c_invoice_id,
					NULL::numeric                                        AS c_payment_id,
					NULL                                                 AS c_payment_docstatus,
					v.createdby,
					o.c_bpartner_id,
					v.bh_visitdate::date                                 AS date,
					v.created,
					v.updated,
					CASE
						WHEN COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) = 0 THEN 'Visit'
						ELSE 'Visit charges and payments' END              AS "type",
					i.non_charges                                        AS debits,
					COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) AS credits
				FROM
					bh_visit v
						JOIN c_order o
							ON v.bh_visit_id = o.bh_visit_id
						JOIN c_bpartner bp
							ON v.patient_id = bp.c_bpartner_id
						LEFT JOIN visit_payments vp
							ON o.c_order_id = vp.c_order_id
						JOIN (
						SELECT
							i.c_order_id,
							SUM(il.linenetamt) FILTER ( WHERE il.c_charge_id IS NULL )     AS non_charges,
							SUM(il.linenetamt) FILTER ( WHERE il.c_charge_id IS NOT NULL ) AS charges
						FROM
							c_invoice i
								JOIN c_invoiceline il
									ON i.c_invoice_id = il.c_invoice_id
								JOIN c_bpartner bp
									ON i.c_bpartner_id = bp.c_bpartner_id
						WHERE
							bp.c_bpartner_uu = _c_bpartner_uu
							AND i.docstatus = 'CO'
						GROUP BY i.c_order_id
					) i
							ON i.c_order_id = o.c_order_id
				WHERE
					o.docstatus = 'CO'
					AND bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY
					o.c_order_id, o.c_bpartner_id, date, non_charges, charges, v.bh_visit_id, v.createdby, v.created, v.updated
				UNION ALL
				-- Outstanding Balance Payments
				SELECT
					NULL                                     AS bh_visit_id,
					NULL                                     AS c_invoice_id,
					gdp.c_payment_id                         AS c_payment_id,
					p.docstatus                              AS c_payment_docstatus,
					p.createdby,
					bp.c_bpartner_id,
					gdp.payment_date                         AS date,
					p.created,
					p.updated,
					CASE
						WHEN p.scheduled = 'Y' AND p.docstatus NOT IN ('CO', 'CL') THEN 'Scheduled Payment'
						ELSE 'Outstanding Balance Payment' END AS "type",
					NULL                                     AS debits,
					SUM(payment_amount)                      AS credits
				FROM
					c_bpartner bp
						JOIN bh_get_debt_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gdp
							ON gdp.patient_id = bp.c_bpartner_id
						JOIN c_payment p
							ON p.c_payment_id = gdp.c_payment_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY
					bp.c_bpartner_id, date, gdp.c_payment_id, p.createdby, p.scheduled, p.docstatus, p.created, p.updated
				UNION ALL
				-- Waived open balance
				SELECT
					NULL                    AS bh_visit_id,
					i.c_invoice_id,
					NULL                    AS c_payment_id,
					NULL                    AS c_payment_docstatus,
					i.createdby,
					i.c_bpartner_id,
					i.dateinvoiced          AS date,
					i.created,
					i.updated,
					'Waived Open Balance'   AS "type",
					NULL                    AS debits,
					SUM(il.linenetamt) * -1 AS credits
				FROM
					c_invoice i
						JOIN c_bpartner bp
							ON i.c_bpartner_id = bp.c_bpartner_id
						JOIN c_invoiceline il
							ON i.c_invoice_id = il.c_invoice_id
						JOIN c_charge c
							ON il.c_charge_id = c.c_charge_id
						JOIN c_chargetype ct
							ON c.c_chargetype_id = ct.c_chargetype_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
					AND c.name = 'Bad debt write-off - DO NOT CHANGE'
					AND ct.name = 'One-offs - DO NOT CHANGE'
				GROUP BY
					i.c_invoice_id, bp.c_bpartner_id, i.dateinvoiced::date, i.createdby, i.created, i.updated
			) AS transactions
		GROUP BY
			bh_visit_id, c_payment_id, createdby, c_bpartner_id, date, "type", created, updated, c_invoice_id,
			c_payment_docstatus
	),
	orderings AS (
-- This categorizes the payments
		SELECT
			orderings.*,
			ROW_NUMBER() OVER (ORDER BY secondary_sort, date, updated) AS row
		FROM
			(
				SELECT
					bh_visit_id,
					c_invoice_id,
					c_payment_id,
					createdby,
					c_bpartner_id,
					date,
					created,
					updated,
					item,
					debits,
					credits,
					net,
							SUM(net) FILTER ( WHERE c_payment_docstatus IS NULL OR c_payment_docstatus IN ('CO', 'CL') )
						OVER (PARTITION BY c_bpartner_id ORDER BY CASE
							                                          WHEN c_payment_docstatus NOT IN ('CO', 'CL') THEN '-infinity'::timestamp
							                                          ELSE date END, updated ROWS UNBOUNDED PRECEDING) AS open_balance,
					2                                                                                              AS secondary_sort
				FROM
					transactions
				UNION ALL
				-- Add another row to show the starting balance of zero when the patient was created
				SELECT
					NULL,
					NULL,
					NULL,
					bp.createdby,
					bp.c_bpartner_id,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
					'Starting balance',
					0,
					0,
					0,
					0,
					1 AS sort
				FROM
					c_bpartner bp
						LEFT JOIN transactions t
							ON t.c_bpartner_id = bp.c_bpartner_id
				WHERE
					bp.c_bpartner_uu = _c_bpartner_uu
				GROUP BY bp.c_bpartner_id
			) AS orderings
	)
SELECT
	bp.c_bpartner_id,
	bp.name      AS patient_name,
	date         AS transaction_date,
	o.created,
	o.updated,
	item         AS item,
	debits,
	credits,
	open_balance AS patient_open_balance,
	bh_visit_id,
	c_invoice_id,
	c_payment_id,
	o.createdby
FROM
	orderings o
		JOIN c_bpartner bp
			ON o.c_bpartner_id = bp.c_bpartner_id
ORDER BY
	row;
$$;

SELECT register_migration_script('202607211149_GO-3682.sql') FROM dual;
