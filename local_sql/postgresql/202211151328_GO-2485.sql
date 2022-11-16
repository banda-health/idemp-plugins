-- Fix tender types and payment amounts where the payment total is greater than the order total
UPDATE c_payment p
SET
	bh_tender_amount = p.payamt,
	payamt           = s.total_charges
FROM
	(
		SELECT *
		FROM
			(
				SELECT
					bh_c_order_id,
					SUM(payamt)         AS total_payment,
					COUNT(c_payment_id) AS num_payments
				FROM
					c_payment
				WHERE
					bh_c_order_id IS NOT NULL
				GROUP BY bh_c_order_id
			) payments
				JOIN (
				SELECT
					c_order_id,
					SUM(linenetamt) AS total_charges
				FROM
					c_orderline
				WHERE
					created > '2022-11-11'
					AND isactive = 'Y'
				GROUP BY c_order_id
			) charges
					ON payments.bh_c_order_id = charges.c_order_id
		WHERE
			payments.total_payment > charges.total_charges
			AND num_payments = 1
			AND total_charges > 0
	) s
WHERE
	s.bh_c_order_id = p.bh_c_order_id;

SELECT
	register_migration_script('202211151328_GO-2485.sql')
FROM
	dual;
