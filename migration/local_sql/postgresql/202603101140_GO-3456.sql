/**********************************************************************************************************/
-- GO-3456: Correct decimal OTC payments and round allocations/invoice totals
/**********************************************************************************************************/

-- Purpose: Some OTC payments include decimal fractions which cause false over/underpayment
-- detection. This migration finds such payments, prefers rounding to the nearest whole
-- payment (business rule used by existing logic), caps at invoice totals when needed,
-- updates allocation lines (rounded to 2 decimals), and ensures invoice grandtotal and
-- ispaid flags are consistent with rounded allocation sums.

-- Be careful: run this in a controlled environment and review changes before applying
-- to production data.

-- Step 0: cleanup if previous temp left behind
DROP TABLE IF EXISTS tmp_decimal_otc_payments;

-- Step 1a: Find OTC visits where invoice totals and summed payments only differ by precision
DROP TABLE IF EXISTS tmp_otc_visits_precision_issues;
CREATE TEMP TABLE tmp_otc_visits_precision_issues AS
SELECT
    v.bh_visit_id,
    ROUND(SUM(i.grandtotal), 2) AS total_invoiced,
    p.calc_paid
FROM
    bh_visit v
    JOIN c_bpartner bp ON v.patient_id = bp.c_bpartner_id
    JOIN c_bp_group bpg ON bp.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
    JOIN c_invoice i ON v.bh_visit_id = i.bh_visit_id AND i.docstatus IN ('CO','CL')
    JOIN LATERAL (
        SELECT v.bh_visit_id, COALESCE(SUM(payamt), 0) AS calc_paid
        FROM c_payment p
        WHERE p.bh_visit_id = v.bh_visit_id AND p.docstatus IN ('CO','CL')
        GROUP BY v.bh_visit_id
    ) p ON v.bh_visit_id = p.bh_visit_id
WHERE
    v.ad_client_id IS NOT NULL
GROUP BY
    v.bh_visit_id, p.calc_paid
HAVING
    -- precision-only mismatches: rounded totals equal but raw sums differ
    ROUND(SUM(i.grandtotal), 2) = ROUND(p.calc_paid, 2)
    AND SUM(i.grandtotal) != p.calc_paid;

-- Step 1b: Collect payments for those visits and compute invoice-level totals for correction logic
DROP TABLE IF EXISTS tmp_decimal_otc_payments;
CREATE TEMP TABLE tmp_decimal_otc_payments AS
SELECT
    p.c_payment_id,
    p.ad_client_id,
    p.ad_org_id,
    p.bh_visit_id,
    p.c_invoice_id,
    p.payamt               AS original_payamt,
    p.bh_tender_amount     AS original_tender_amount,
    inv_totals.total_invoiced,
    inv_totals.total_paid,
    -- Prefer rounding to nearest integer for individual payment; if that would exceed
    -- the invoice total when considered in isolation, cap at invoice total
    CASE
        WHEN ROUND(p.payamt, 0) <= inv_totals.total_invoiced THEN ROUND(p.payamt, 0)
        ELSE inv_totals.total_invoiced
    END                    AS corrected_payamt
FROM
    c_payment p
    JOIN tmp_otc_visits_precision_issues tv
        ON p.bh_visit_id = tv.bh_visit_id
    -- compute per-invoice totals for payments linked to the same invoice (if any)
    LEFT JOIN LATERAL (
        SELECT
            ROUND(i.grandtotal, 2) AS total_invoiced,
            ROUND(COALESCE(SUM(p2.payamt), 0), 2) AS total_paid
        FROM c_invoice i
        LEFT JOIN c_payment p2
            ON p2.c_invoice_id = i.c_invoice_id
            AND p2.docstatus IN ('CO', 'CL')
        WHERE
            i.c_invoice_id = p.c_invoice_id
            AND i.docstatus IN ('CO', 'CL')
        GROUP BY i.c_invoice_id, i.grandtotal
    ) inv_totals ON TRUE
WHERE
    p.docstatus IN ('CO', 'CL')
    AND p.payamt != FLOOR(p.payamt); -- select payments that have decimal component

-- Step 1c: Build per-invoice targets and preliminary rounded payment sums
DROP TABLE IF EXISTS tmp_invoice_targets;
CREATE TEMP TABLE tmp_invoice_targets AS
SELECT
    i.c_invoice_id,
    ROUND(i.grandtotal, 2) AS invoice_total
FROM c_invoice i
WHERE i.c_invoice_id IN (
    SELECT DISTINCT c_invoice_id FROM tmp_decimal_otc_payments WHERE c_invoice_id IS NOT NULL
) AND i.docstatus IN ('CO','CL');

DROP TABLE IF EXISTS tmp_payment_prelim;
CREATE TEMP TABLE tmp_payment_prelim AS
SELECT
    p.c_payment_id,
    p.c_invoice_id,
    p.payamt,
    ROUND(p.payamt, 0) AS prelim_amt
FROM c_payment p
WHERE p.c_payment_id IN (
    SELECT c_payment_id FROM tmp_decimal_otc_payments
)
ORDER BY p.c_invoice_id, p.c_payment_id;

DROP TABLE IF EXISTS tmp_invoice_prelim_sums;
CREATE TEMP TABLE tmp_invoice_prelim_sums AS
SELECT c_invoice_id, SUM(prelim_amt) AS prelim_sum
FROM tmp_payment_prelim
GROUP BY c_invoice_id;

-- Step 1d: Compute final per-payment corrections: give the rounding remainder to the last payment per invoice
DROP TABLE IF EXISTS tmp_payment_corrections;
CREATE TEMP TABLE tmp_payment_corrections AS
SELECT pp.c_payment_id,
       pp.c_invoice_id,
       pp.payamt,
       pp.prelim_amt,
       CASE
           WHEN pp.c_payment_id = (
               SELECT MAX(c_payment_id) FROM tmp_payment_prelim WHERE c_invoice_id = pp.c_invoice_id
           ) THEN ROUND(GREATEST(0, it.invoice_total - (ips.prelim_sum - pp.prelim_amt)), 2)
           ELSE pp.prelim_amt
       END AS corrected_payamt
FROM tmp_payment_prelim pp
JOIN tmp_invoice_targets it ON it.c_invoice_id = pp.c_invoice_id
JOIN tmp_invoice_prelim_sums ips ON ips.c_invoice_id = pp.c_invoice_id;


-- Step 2: Update payment amounts
UPDATE c_payment
SET
    payamt           = pc.corrected_payamt,
    bh_tender_amount = pc.corrected_payamt,
    updated          = NOW(),
    updatedby        = 100
FROM
    tmp_payment_corrections pc
WHERE
    c_payment.c_payment_id = pc.c_payment_id;

-- Step 3: Update allocation line amounts tied to these payments (round to 2 decimals)
UPDATE c_allocationline al
SET
    amount    = ROUND(LEAST(pc.corrected_payamt, al.amount), 2),
    updated   = NOW(),
    updatedby = 100
FROM
    tmp_payment_corrections pc
    JOIN c_allocationhdr ah
        ON al.c_allocationhdr_id = ah.c_allocationhdr_id
WHERE
    al.c_payment_id = pc.c_payment_id
    AND ah.docstatus IN ('CO', 'CL');

-- Step 4a: Update invoice grandtotal to the rounded sum of allocation amounts affected
UPDATE c_invoice
SET
    grandtotal = ROUND(
        (
            SELECT COALESCE(SUM(al.amount), 0)
            FROM c_allocationline al
            JOIN c_allocationhdr ah ON al.c_allocationhdr_id = ah.c_allocationhdr_id
            WHERE al.c_invoice_id = c_invoice.c_invoice_id
              AND ah.docstatus IN ('CO', 'CL')
        ), 2
    ),
    updated    = NOW(),
    updatedby  = 100
WHERE
    c_invoice_id IN (
        SELECT DISTINCT al.c_invoice_id
        FROM c_allocationline al
        JOIN c_allocationhdr ah ON al.c_allocationhdr_id = ah.c_allocationhdr_id
        JOIN tmp_payment_corrections pc ON al.c_payment_id = pc.c_payment_id
        WHERE ah.docstatus IN ('CO', 'CL')
    )
    OR c_invoice_id IN (
        SELECT DISTINCT c_invoice_id FROM tmp_payment_corrections WHERE c_invoice_id IS NOT NULL
    );

-- Step 4b: Update invoice IsPaid status for invoices touched by corrected payments (use rounded sums)
UPDATE c_invoice
SET
    ispaid    = CASE
                   WHEN (
                       SELECT ROUND(COALESCE(SUM(al.amount), 0), 2)
                       FROM c_allocationline al
                       JOIN c_allocationhdr ah ON al.c_allocationhdr_id = ah.c_allocationhdr_id
                       WHERE al.c_invoice_id = c_invoice.c_invoice_id
                         AND ah.docstatus IN ('CO', 'CL')
                   ) >= ROUND(c_invoice.grandtotal, 2) THEN 'Y'
                   ELSE 'N'
               END,
    updated   = NOW(),
    updatedby = 100
WHERE
    c_invoice_id IN (
        SELECT DISTINCT al.c_invoice_id
        FROM c_allocationline al
        JOIN c_allocationhdr ah ON al.c_allocationhdr_id = ah.c_allocationhdr_id
        JOIN tmp_payment_corrections pc ON al.c_payment_id = pc.c_payment_id
        WHERE ah.docstatus IN ('CO', 'CL')
    )
    OR c_invoice_id IN (
        SELECT DISTINCT c_invoice_id FROM tmp_payment_corrections WHERE c_invoice_id IS NOT NULL
    );

-- Step 5: Cleanup
DROP TABLE IF EXISTS tmp_decimal_otc_payments;
DROP TABLE IF EXISTS tmp_payment_prelim;
DROP TABLE IF EXISTS tmp_invoice_targets;
DROP TABLE IF EXISTS tmp_invoice_prelim_sums;
DROP TABLE IF EXISTS tmp_payment_corrections;
DROP TABLE IF EXISTS tmp_otc_visits_precision_issues;

-- Register migration (project uses register_migration_script pattern)
SELECT register_migration_script('202603101140_GO-3456.sql') FROM dual;