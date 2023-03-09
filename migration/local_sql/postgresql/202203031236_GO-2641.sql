-- Duplicate reversal happened, so clear the amount
UPDATE c_payment
SET
	payamt = 0
WHERE
	c_payment_uu = '80090c63-0a1e-4ca1-b0ba-8ea153004219';

SELECT
	register_migration_script('202203031236_GO-2641.sql')
FROM
	dual;
