/**********************************************************************************************************/
-- Since there are a lot of function updates, this handles doing them all at once to prevent difficulties
-- This duplicates what's in process_post_migration as of this point
/**********************************************************************************************************/
BEGIN;

DROP FUNCTION IF EXISTS bh_get_debt_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION bh_get_debt_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
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

DROP FUNCTION IF EXISTS bh_get_payment_trail(character varying);
CREATE FUNCTION bh_get_payment_trail(_c_bpartner_uu character varying)
  RETURNS TABLE
          (
            c_bpartner_id        numeric,
            patient_name         character varying,
            transaction_date     timestamp WITHOUT TIME ZONE,
            item                 text,
            debits               numeric,
            credits              numeric,
            patient_open_balance numeric
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
      JOIN bh_get_visit_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gvp
        ON gvp.patient_id = bp.c_bpartner_id
  WHERE
      bp.c_bpartner_uu = _c_bpartner_uu
  GROUP BY c_order_id
),
  transactions AS (
    -- Sum all the payments and group them by date
    SELECT
      transactions.c_bpartner_id,
      transactions.date,
      transactions."type"                                                              AS item,
      COALESCE(SUM(transactions.debits), 0)                                            AS debits,
      COALESCE(SUM(transactions.credits), 0)                                           AS credits,
        COALESCE(SUM(transactions.debits), 0) - COALESCE(SUM(transactions.credits), 0) AS net,
      transactions.sort
    FROM
      (
        -- Bills
        SELECT
          o.c_bpartner_id,
          date(v.bh_visitdate)                                 AS date,
          CASE
            WHEN COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) = 0 THEN 'Visit'
            ELSE 'Visit charges and payments' END              AS "type",
          i.non_charges                                        AS debits,
            COALESCE(SUM(vp.payamt), 0) - COALESCE(i.charges, 0) AS credits,
          10                                                   AS sort
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
        GROUP BY o.c_order_id, o.c_bpartner_id, date, non_charges, charges
        UNION ALL
        -- Outstanding Balance Payments
        SELECT
          bp.c_bpartner_id,
          date(gdp.payment_date)        AS date,
          'Outstanding Balance Payment' AS "type",
          NULL                          AS debits,
          SUM(payment_amount)           AS credits,
          20                            AS sort
        FROM
          c_bpartner bp
            JOIN bh_get_debt_payments(bp.ad_client_id, '-infinity'::timestamp, 'infinity'::timestamp) gdp
              ON gdp.patient_id = bp.c_bpartner_id
        WHERE
            bp.c_bpartner_uu = _c_bpartner_uu
        GROUP BY
          bp.c_bpartner_id,
          date
        UNION ALL
        -- Waived open balance
        SELECT
          i.c_bpartner_id,
          date(i.dateinvoiced)    AS date,
          'Waived Open Balance'   AS "type",
          NULL                    AS debits,
            SUM(il.linenetamt) * -1 AS credits,
          30                      AS sort
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
          i.c_invoice_id,
          bp.c_bpartner_id, dateinvoiced
      ) AS transactions
    GROUP BY
      transactions.c_bpartner_id,
      transactions.date,
      transactions."type",
      transactions.sort
  ),
  orderings AS (
-- This categorizes the payments
    SELECT
      orderings.*,
          ROW_NUMBER() OVER (ORDER BY secondary_sort, date, sort) AS row
    FROM
      (
        SELECT
          transactions.c_bpartner_id,
          transactions.date,
          transactions.item,
          transactions.debits,
          transactions.credits,
          transactions.net,
              SUM(transactions.net)
              OVER (PARTITION BY transactions.c_bpartner_id ORDER BY transactions.date, transactions.sort ROWS UNBOUNDED PRECEDING) AS open_balance,
          transactions.sort,
          2                                                                                                                         AS secondary_sort
        FROM
          transactions
        UNION ALL
        -- Add another row to show the starting balance of zero when the patient was created
        SELECT
          bp.c_bpartner_id,
          CASE WHEN MIN(t.date) < bp.created THEN MIN(t.date) ELSE bp.created END,
          'Starting balance',
          0,
          0,
          0,
          0,
          0,
          1 AS sort
        FROM
          c_bpartner bp
            JOIN transactions t
              ON t.c_bpartner_id = bp.c_bpartner_id
        GROUP BY bp.c_bpartner_id
      ) AS orderings
  )
SELECT
  bp.c_bpartner_id,
  bp.name      AS patient_name,
  date         AS transaction_date,
  item         AS item,
  debits,
  credits,
  open_balance AS patient_open_balance
FROM
  orderings o
    JOIN c_bpartner bp
      ON o.c_bpartner_id = bp.c_bpartner_id
ORDER BY
  row;
$$;

DROP FUNCTION IF EXISTS bh_get_visit_details(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION bh_get_visit_details(ad_client_id numeric,
                                                begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id                   numeric,
		        bh_visitdate                  timestamp WITHOUT TIME ZONE,
		        c_order_id                    numeric,
		        c_order_uu                    character varying,
		        ad_org_id                     numeric,
		        receipt_number                numeric,
		        ad_user_id                    numeric,
		        cashier_name                  character varying,
		        createdby_user_uu             character varying,
		        c_bpartner_id                 numeric,
		        patient_name                  character varying,
		        bh_patienttype                character varying,
		        bh_patienttype_name           character varying,
		        bh_patientid                  character varying,
		        bh_birthday                   timestamp WITHOUT TIME ZONE,
		        bh_gender                     character varying,
		        bh_phone                      character varying,
		        bh_primarycodeddiagnosis_id   numeric,
		        bh_secondarycodeddiagnosis_id numeric,
		        bh_primaryuncodeddiagnosis    character varying,
		        bh_secondaryuncodeddiagnosis  character varying,
		        docstatus                     character,
		        bh_clinician_user_id          numeric,
		        processing                    character,
		        saleslineitemtotals           numeric,
		        salestotals                   numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	v.bh_visit_id,
	v.bh_visitdate                                   AS visit_date,
	o.c_order_id,
	o.c_order_uu,
	v.ad_org_id,
	o.c_order_id                                     AS receipt_number,
	createdby_user.ad_user_id                        AS cashier_id,
	createdby_user.name                              AS cashier_name,
	createdby_user.ad_user_uu                        AS createdby_user_uu,
	v.patient_id                                     AS patient_id,
	bp.name                                          AS patient_name,
	v.bh_patienttype                                 AS patient_type,
	rl.name                                          AS bh_patienttype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	v.bh_primarycodeddiagnosis_id                    AS primary_coded,
	v.bh_secondarycodeddiagnosis_id                  AS secondary_coded,
	v.bh_primaryuncodeddiagnosis                     AS primary_uncoded,
	v.bh_secondaryuncodeddiagnosis                   AS secondary_uncoded,
	o.docstatus                                      AS docstatus,
	v.bh_clinician_user_id                           AS clinician_id,
	o.processing                                     AS processing,
	saleslineitemtotals,
	salestotals
FROM
	bh_visit v
		JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user createdby_user
			ON v.createdby = createdby_user.ad_user_id
		JOIN ad_ref_list rl
			ON rl.value = v.bh_patienttype
		JOIN ad_reference r
			ON rl.ad_reference_id = r.ad_reference_id
		JOIN (
		SELECT
			o.c_order_id,
			COALESCE(SUM(ol.linenetamt) FILTER ( WHERE ol.c_charge_id IS NULL ), 0) AS saleslineitemtotals,
			COALESCE(SUM(ol.linenetamt), 0)                                         AS salestotals
		FROM
			c_order o
				JOIN c_orderline ol
					ON o.c_order_id = ol.c_order_id
				JOIN bh_visit v
					ON o.bh_visit_id = v.bh_visit_id
		WHERE
			o.ad_client_id = $1
			AND v.bh_visitdate BETWEEN $2 AND $3
		GROUP BY o.c_order_id
	) sales_details
			ON o.c_order_id = sales_details.c_order_id
WHERE
	v.bh_visitdate BETWEEN $2 AND $3
	AND v.ad_client_id = $1
	AND ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7';
$$;

DROP FUNCTION IF EXISTS bh_get_visit_non_patient_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION bh_get_visit_non_patient_payments(ad_client_id numeric,
                                                             begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                             end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
  RETURNS TABLE
          (
            bh_visit_id         numeric,
            c_order_id          numeric,
            c_charge_id         numeric,
            chargetype_name     character varying,
            bh_subtype          character varying,
            charge_subtype_name character varying,
            c_chargetype_id     numeric,
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
SELECT
  v.bh_visit_id,
  ol.c_order_id,
  c.c_charge_id,
  c.name    AS ChargeType_name,
  c.bh_subtype,
  r.name    AS charge_subtype_name,
  c.c_chargetype_id,
  ol.linenetamt,
  olci.name AS member_id,
  bol.name  AS MemberName,
  olc.name  AS ClaimNo,
  bci.name  AS Relationship
FROM
  c_charge c
    JOIN c_orderline ol
      ON c.c_charge_id = ol.c_charge_id
    JOIN c_order o
      ON ol.c_order_id = o.c_order_id
    JOIN bh_visit v
      ON o.bh_visit_id = v.bh_visit_id
    JOIN ad_ref_list r
      ON r.value = c.bh_subtype
    JOIN ad_reference a
      ON r.ad_reference_id = a.ad_reference_id
    LEFT JOIN (
    SELECT
      olci.c_orderline_id,
      olci.name
    FROM
      bh_orderline_charge_info olci
        JOIN bh_charge_info ci
          ON olci.bh_charge_info_id = ci.bh_charge_info_id
    WHERE
      (ci.name IN ('Member ID', 'NHIF Number', 'Patient ID') OR ci.name IS NULL)
  ) AS olci
      ON olci.c_orderline_id = ol.c_orderline_id
    LEFT JOIN (
    SELECT
      bol.c_orderline_id,
      bol.name
    FROM
      bh_orderline_charge_info bol
        JOIN bh_charge_info ci
          ON bol.bh_charge_info_id = ci.bh_charge_info_id
    WHERE
      (ci.name IN ('Patient Name', 'Member Name', 'Mother''s Name') OR ci.name IS NULL)
  ) bol
      ON bol.c_orderline_id = ol.c_orderline_id
    LEFT JOIN (
    SELECT
      olc.c_orderline_id,
      olc.name
    FROM
      bh_orderline_charge_info olc
        JOIN bh_charge_info ci
          ON olc.bh_charge_info_id = ci.bh_charge_info_id
    WHERE
      (ci.name IN ('Claim Number') OR ci.name IS NULL)
      AND (ci.bh_chargeinfodatatype = 'T' AND ci.bh_fillfrompatient = 'N')
  ) olc
      ON olc.c_orderline_id = ol.c_orderline_id
    LEFT JOIN (
    SELECT
      bci.c_orderline_id,
      bci.name
    FROM
      bh_orderline_charge_info bci
        JOIN bh_charge_info ci
          ON bci.bh_charge_info_id = ci.bh_charge_info_id
    WHERE
      (ci.name IN ('Relationship') OR ci.name IS NULL)
      AND (ci.bh_chargeinfodatatype = 'L' AND ci.bh_fillfrompatient = 'Y')
  ) bci
      ON bci.c_orderline_id = ol.c_orderline_id
WHERE
    ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
  AND ol.c_charge_id IS NOT NULL
  AND c.ad_client_id = $1
  AND v.bh_visitdate BETWEEN $2 AND $3;
$$;

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
	p.payamt       AS payment_amount,
	p.tendertype   AS payment_mode_letter,
	r.name         AS payment_mode_name,
	p.datetrx      AS payment_date,
	cb.name        AS patient_name,
	p.isallocated,
	p.c_invoice_id AS invoice_id,
	v.createdby    AS cashier_id,
	ad.name        AS cashier,
	ad.ad_user_uu  AS cashier_uu,
	p.docstatus    AS docstatus,
	p.processing   AS processing,
	i.linenetamt   AS lineitemtotals,
	p.bh_tender_amount
FROM
	c_payment p
		JOIN bh_visit v
			ON p.bh_visit_id = v.bh_visit_id AND v.bh_visitdate BETWEEN begin_date AND end_date
		JOIN (
		SELECT
			i.c_order_id,
			al.c_payment_id,
			SUM(il.linenetamt) AS linenetamt
		FROM
			c_invoiceline il
				JOIN c_invoice i
					ON il.c_invoice_id = i.c_invoice_id AND i.docstatus NOT IN ('RE', 'RA', 'VO', 'DR')
				JOIN c_allocationline al
					ON i.c_invoice_id = al.c_invoice_id
				JOIN c_allocationhdr ah
					ON al.c_allocationhdr_id = ah.c_allocationhdr_id AND ah.docstatus NOT IN ('RE', 'RA', 'VO')
		WHERE
			il.c_charge_id IS NULL
			AND il.ad_client_id = $1
		GROUP BY i.c_order_id, al.c_payment_id
	) i
			ON p.c_payment_id = i.c_payment_id
		JOIN c_bpartner cb
			ON v.patient_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON v.createdby = ad.ad_user_id
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

DROP FUNCTION IF EXISTS bh_get_visit_products(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_products(ad_client_id numeric,
                                      begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                      end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
  RETURNS TABLE
          (
            bh_visit_id           numeric,
            m_product_id          numeric,
            product_name          character varying,
            m_product_category_id numeric,
            product_category_name character varying,
            product_type_value    character varying,
            product_type_name     character varying,
            quantity              numeric,
            price                 numeric,
            linenetamt            numeric,
            m_warehouse_id        numeric,
            warehouse_name        character varying,
            processed             character
          )
  LANGUAGE sql
  STABLE
AS
$$
SELECT
  v.bh_visit_id,
  p.m_product_id,
  p.name          AS product_name,
  pc.m_product_category_id,
  pc.name         AS product_category_name,
  rl.value        AS product_type_value,
  rl.name         AS product_type_name,
  ol.qtyentered   AS quantity,
  ol.priceentered AS price,
  ol.linenetamt,
  w.m_warehouse_id,
  w.name          AS warehouse_name,
  ol.processed
FROM
  c_orderline ol
    JOIN c_order o
      ON ol.c_order_id = o.c_order_id
    JOIN bh_visit v
      ON o.bh_visit_id = v.bh_visit_id
    JOIN m_product p
      ON ol.m_product_id = p.m_product_id
    JOIN m_product_category pc
      ON p.m_product_category_id = pc.m_product_category_id
    JOIN ad_ref_list rl
      ON p.producttype = rl.value
    JOIN ad_reference r
      ON rl.ad_reference_id = r.ad_reference_id AND r.ad_reference_uu = '668f05be-1e2e-498c-a016-cc5b623ed0cd'
    LEFT JOIN m_inoutline iol
      ON ol.c_orderline_id = iol.c_orderline_id
    LEFT JOIN m_locator l
      ON iol.m_locator_id = l.m_locator_id
    LEFT JOIN m_warehouse w
      ON l.m_warehouse_id = w.m_warehouse_id
WHERE
  v.bh_visitdate BETWEEN $2 AND $3
  AND ol.ad_client_id = $1;
$$;

DROP FUNCTION IF EXISTS get_visit_info(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE OR REPLACE FUNCTION get_visit_info(ad_client_id numeric,
                                          begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                          end_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE)
  RETURNS TABLE
          (
            bh_visit_id         numeric,
            c_bpartner_id       numeric,
            bill_date           timestamp WITHOUT TIME ZONE,
            cashier             character varying,
            patientname         character varying,
            patientno           character varying,
            patienttype         character varying,
            member_id           character varying,
            membername          character varying,
            relationship        character varying,
            claimno             character varying,
            lineitemtotals      numeric,
            product_list        text,
            cash                numeric,
            mobile              numeric,
            credit_debit        numeric,
            bank                numeric,
            checks              numeric,
            totaldirectpayments numeric,
            othernewpayments    numeric,
            insurance           numeric,
            waiver              numeric,
            donation            numeric,
            totalnonpayments    numeric
          )
  LANGUAGE sql
  STABLE
AS
$$
  -- Order Info
WITH OrderInfo AS (
  SELECT
    v.bh_visit_id,
    bp.c_bpartner_id,
    v.bh_visitdate           AS bill_date,
    u.name                   AS Cashier,
    bp.name                  AS patientname,
    bp.bh_patientid          AS PatientNo,
    v.bh_patienttype         AS PatientType,
    SUM(ol.linenetamt)       AS lineitemtotals,
    STRING_AGG(p.name, ', ') AS product_list
  FROM
    bh_visit v
      INNER JOIN c_bpartner bp
        ON v.patient_id = bp.c_bpartner_id
      INNER JOIN ad_user u
        ON v.createdby = u.ad_user_id
      JOIN c_order o
        ON v.bh_visit_id = o.bh_visit_id
      JOIN c_orderline ol
        ON o.c_order_id = ol.c_order_id
      LEFT JOIN m_product p
        ON ol.m_product_id = p.m_product_id
  WHERE
    (
        (v.ad_client_id = $1)
        AND v.bh_visitdate BETWEEN $2 AND $3
        AND (o.docstatus <> 'VO' AND o.docstatus <> 'DR')
      )
    AND ol.c_charge_id IS NULL
  GROUP BY v.bh_visit_id, bp.c_bpartner_id, ol.c_charge_id, v.bh_visitdate, bp.name, u.name, bp.bh_patientid
  ORDER BY 1
),
  patient_payments AS (
    SELECT
      p.bh_visit_id,
          SUM(p.payamt) FILTER ( WHERE tendertype = 'X' )                                AS cash,
          SUM(p.payamt) FILTER ( WHERE tendertype = 'M' )                                AS mobile,
          SUM(p.payamt) FILTER ( WHERE tendertype = 'C' )                                AS credit_debit,
          SUM(p.payamt) FILTER ( WHERE tendertype = 'D' )                                AS bank,
          SUM(p.payamt) FILTER ( WHERE tendertype = 'K' )                                AS checks,
          SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('I', 'D', 'W'))                AS TotalDirectPayments,
          SUM(p.payamt) FILTER ( WHERE tendertype NOT IN ('X', 'M', 'C', 'D', 'K') ) AS OtherNewPayments
    FROM
      c_payment p
    WHERE
        p.ad_client_id = $1
    GROUP BY p.bh_visit_id
  ),
  non_patient_payments AS (
    SELECT
      v.bh_visit_id,
            SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'I' ) * -1                   AS insurance,
            SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'W' ) * -1                   AS waiver,
            SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype = 'D' ) * -1                   AS donation,
            SUM(ol.linenetamt) FILTER ( WHERE c.bh_subtype IN ('D', 'W', 'I')) * -1 AS TotalNonPayments,
      olci.name                                                                     AS member_id,
      bol.name                                                                      AS MemberName,
      olc.name                                                                      AS ClaimNo,
      bci.name                                                                      AS Relationship
    FROM
      c_orderline ol
        JOIN c_order o
          ON ol.c_order_id = o.c_order_id
        JOIN bh_visit v
          ON o.bh_visit_id = v.bh_visit_id
        JOIN c_charge c
          ON ol.c_charge_id = c.c_charge_id
        LEFT JOIN (
        SELECT
          olci.c_orderline_id,
          olci.name
        FROM
          bh_orderline_charge_info olci
            JOIN bh_charge_info ci
              ON olci.bh_charge_info_id = ci.bh_charge_info_id
        WHERE
          (ci.name IN ('Member ID', 'NHIF Number') OR ci.name IS NULL)
      ) AS olci
          ON olci.c_orderline_id = ol.c_orderline_id
        LEFT JOIN (
        SELECT
          bol.c_orderline_id,
          bol.name
        FROM
          bh_orderline_charge_info bol
            JOIN bh_charge_info ci
              ON bol.bh_charge_info_id = ci.bh_charge_info_id
        WHERE
          (ci.name IN ('Patient Name', 'Member Name') OR ci.name IS NULL)
      ) bol
          ON bol.c_orderline_id = ol.c_orderline_id
        LEFT JOIN (
        SELECT
          olc.c_orderline_id,
          olc.name
        FROM
          bh_orderline_charge_info olc
            JOIN bh_charge_info ci
              ON olc.bh_charge_info_id = ci.bh_charge_info_id
        WHERE
          (ci.name IN ('Claim Number') OR ci.name IS NULL)
          AND (ci.bh_chargeinfodatatype = 'T' AND ci.bh_fillfrompatient = 'N')
      ) olc
          ON olc.c_orderline_id = ol.c_orderline_id
        LEFT JOIN (
        SELECT
          bci.c_orderline_id,
          bci.name
        FROM
          bh_orderline_charge_info bci
            JOIN bh_charge_info ci
              ON bci.bh_charge_info_id = ci.bh_charge_info_id
        WHERE
          (ci.name IN ('Relationship') OR ci.name IS NULL)
          AND (ci.bh_chargeinfodatatype = 'L' AND ci.bh_fillfrompatient = 'Y')
      ) bci
          ON bci.c_orderline_id = ol.c_orderline_id
    WHERE
        o.ad_client_id = $1
      AND v.bh_visitdate BETWEEN $2 AND $3
    GROUP BY v.bh_visit_id, olci.name, bol.name, olc.name, bci.name, olci.name, bci.name, olc.name, bol.name
  )
SELECT
  OrderInfo.bh_visit_id,
  OrderInfo.c_bpartner_id,
  OrderInfo.bill_date,
  OrderInfo.Cashier,
  OrderInfo.patientname,
  OrderInfo.PatientNo,
  OrderInfo.PatientType::varchar,
  non_patient_payments.member_id,
  non_patient_payments.MemberName,
  non_patient_payments.Relationship,
  non_patient_payments.ClaimNo,
  OrderInfo.lineitemtotals,
  OrderInfo.product_list,
  COALESCE(patient_payments.cash, 0)                 AS cash,
  COALESCE(patient_payments.mobile, 0)               AS mobile,
  COALESCE(patient_payments.credit_debit, 0)         AS credit_debit,
  COALESCE(patient_payments.bank, 0)                 AS bank,
  COALESCE(patient_payments.checks, 0)               AS checks,
  COALESCE(patient_payments.TotalDirectPayments, 0)  AS TotalDirectPayments,
  COALESCE(patient_payments.OtherNewPayments, 0)     AS OtherNewPayments,
  COALESCE(non_patient_payments.insurance, 0)        AS insurance,
  COALESCE(non_patient_payments.waiver, 0)           AS waiver,
  COALESCE(non_patient_payments.donation, 0)         AS donation,
  COALESCE(non_patient_payments.TotalNonPayments, 0) AS TotalNonPayments
FROM
  OrderInfo
    LEFT JOIN patient_payments
      ON OrderInfo.bh_visit_id = patient_payments.bh_visit_id
    LEFT JOIN non_patient_payments
      ON OrderInfo.bh_visit_id = non_patient_payments.bh_visit_id
ORDER BY
  date(OrderInfo.bill_date), OrderInfo.patientname;
$$;

COMMIT;

/**********************************************************************************************************/
-- Wrap up
/**********************************************************************************************************/
SELECT
	update_sequences();

SELECT
	register_migration_script('202304241108_GO-2532.sql')
FROM
	dual;
