-- Update payment amounts where the invoice was never completed, thus adjusting the tender and payment amounts
UPDATE c_payment p
SET bh_tender_amount = p.payamt, payamt = o.grandtotal
FROM c_order o
JOIN (
	SELECT
		bh_c_order_id as c_order_id,
		COUNT(c_payment_id) as payment_count
	FROM c_payment
	WHERE bh_c_order_id > 0
	GROUP BY bh_c_order_id
) order_payment_count
	ON o.c_order_id = order_payment_count.c_order_id
WHERE p.bh_c_order_id = o.c_order_id
	AND order_payment_count.payment_count = 1
	AND p.payamt > o.grandtotal
	AND p.c_payment_id NOT IN (
		SELECT c_payment_id
		FROM c_payment
		WHERE docstatus = 'RE'
			AND reversal_id = p.c_payment_id
			AND p.c_bpartner_id = c_bpartner_id
	)
	AND p.docstatus != 'RE'
	AND o.docstatus NOT IN ('VO','DR','IN');

SELECT register_migration_script('202104061734_GO-1614.sql') FROM dual;
