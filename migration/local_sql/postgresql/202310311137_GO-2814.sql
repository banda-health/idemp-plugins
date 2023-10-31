UPDATE c_charge_acct ca
SET
	ch_expense_acct = vc.good_validcombination_id
FROM
	(
		SELECT
			vc_b.c_validcombination_id                                                                        AS bad_validcombination_id,
			vc_g.c_validcombination_id                                                                        AS good_validcombination_id,
				ROW_NUMBER() OVER (PARTITION BY vc_b.c_validcombination_id ORDER BY vc_g.c_validcombination_id) AS row_number
		FROM
			c_validcombination vc_b
				JOIN c_validcombination vc_g
				ON vc_b.description = vc_g.description AND vc_g.ad_client_id = 2
		WHERE
				vc_b.c_validcombination_id IN (
				SELECT
					ch_expense_acct
				FROM
					c_charge_acct
				WHERE
					ad_client_id = 2
			)
			AND vc_b.ad_client_id != 2
	) vc
WHERE
	ca.ch_expense_acct = vc.bad_validcombination_id
	AND ca.ad_client_id = 2
	AND vc.row_number = 1;

SELECT
	register_migration_script('202310311137_GO-2814.sql')
FROM
	dual;
