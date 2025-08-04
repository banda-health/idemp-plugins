-- Create a temp table with all our mappings in it of stuff that needs to be updated
SELECT *
INTO TEMP TABLE
	tmp_country_currency_mapping
FROM
	(
		VALUES
			(1000029, 100, 330, 328, 328),
			(1000133, 100, 219, 266, 266),
			(1000138, 100, 219, 266, 266),
			(1000141, 100, 219, 266, 266),
			(1000142, 100, 219, 266, 266),
			(1000147, 100, 219, 266, 266),
			(1000148, 100, 219, 100, 266),
			(1000150, 100, 219, 266, 266),
			(1000151, 100, 219, 266, 266),
			(1000152, 100, 219, 266, 266),
			(1000154, 100, 219, 266, 266),
			(1000157, 100, 219, 266, 266),
			(1000161, 100, 219, 266, 266),
			(1000162, 100, 219, 266, 266),
			(1000163, 100, 219, 266, 266),
			(1000164, 100, 219, 266, 266),
			(1000165, 100, 219, 266, 266),
			(1000167, 100, 219, 266, 266),
			(1000168, 100, 219, 266, 266),
			(1000171, 100, 219, 266, 266),
			(1000172, 100, 219, 266, 266),
			(1000175, 100, 219, 266, 266),
			(1000176, 100, 219, 266, 266),
			(1000177, 100, 219, 266, 266),
			(1000178, 100, 219, 266, 266),
			(1000179, 100, 219, 266, 266),
			(1000180, 100, 219, 266, 266),
			(1000181, 100, 219, 266, 266),
			(1000183, 100, 219, 266, 266),
			(1000184, 100, 219, 266, 266),
			(1000185, 100, 219, 266, 266),
			(1000186, 100, 219, 266, 266),
			(1000187, 100, 219, 266, 266),
			(1000189, 100, 219, 266, 266),
			(1000191, 100, 219, 266, 266),
			(1000192, 100, 219, 266, 266),
			(1000197, 100, 219, 266, 266),
			(1000198, 100, 219, 266, 266),
			(1000199, 100, 219, 266, 266),
			(1000201, 100, 219, 266, 266),
			(1000202, 100, 219, 266, 266),
			(1000203, 100, 219, 266, 266),
			(1000206, 100, 219, 266, 266),
			(1000207, 100, 219, 266, 266),
			(1000208, 100, 219, 266, 266),
			(1000210, 100, 219, 266, 266),
			(1000211, 100, 219, 266, 266),
			(1000212, 100, 219, 266, 266),
			(1000213, 100, 219, 266, 266),
			(1000214, 100, 219, 266, 266),
			(1000215, 100, 219, 266, 266),
			(1000216, 100, 219, 266, 266),
			(1000217, 100, 219, 266, 266),
			(1000218, 100, 219, 266, 266),
			(1000219, 100, 219, 266, 266),
			(1000220, 100, 219, 266, 266),
			(1000221, 100, 219, 266, 266),
			(1000222, 100, 219, 266, 266),
			(1000223, 100, 219, 266, 266),
			(1000224, 100, 219, 266, 266),
			(1000225, 100, 219, 266, 266),
			(1000226, 100, 219, 266, 266),
			(1000227, 100, 219, 266, 266),
			(1000228, 100, 219, 266, 266),
			(1000229, 100, 219, 266, 266),
			(1000230, 100, 219, 266, 266),
			(1000231, 100, 219, 266, 266),
			(1000232, 100, 219, 266, 266),
			(1000233, 100, 219, 266, 266),
			(1000234, 100, 219, 266, 266),
			(1000235, 100, 219, 266, 266),
			(1000236, 100, 219, 266, 266),
			(1000237, 100, 219, 266, 266),
			(1000238, 100, 219, 266, 266),
			(1000239, 100, 219, 266, 266),
			(1000240, 100, 219, 266, 266),
			(1000241, 100, 219, 266, 266),
			(1000242, 100, 219, 266, 266),
			(1000243, 100, 219, 266, 266),
			(1000244, 100, 219, 266, 266),
			(1000245, 100, 200001, 20000, 20000),
			(1000246, 100, 219, 266, 266),
			(1000247, 100, 219, 266, 266),
			(1000248, 100, 219, 266, 266),
			(1000249, 100, 219, 266, 266),
			(1000250, 100, 219, 266, 266),
			(1000251, 100, 219, 266, 266),
			(1000252, 100, 219, 266, 266),
			(1000253, 100, 219, 266, 266),
			(1000254, 100, 219, 266, 266),
			(1000255, 100, 219, 266, 266),
			(1000256, 100, 219, 266, 266),
			(1000257, 100, 219, 266, 266),
			(1000258, 100, 219, 266, 266),
			(1000259, 100, 219, 266, 266),
			(1000260, 100, 219, 266, 266),
			(1000261, 100, 219, 266, 266),
			(1000262, 100, 219, 266, 266),
			(1000263, 100, 219, 266, 266),
			(1000264, 100, 219, 266, 266),
			(1000265, 100, 219, 266, 266),
			(1000266, 100, 219, 266, 266),
			(1000267, 100, 219, 266, 266),
			(1000268, 100, 219, 266, 266),
			(1000269, 100, 219, 266, 266),
			(1000270, 100, 219, 266, 266),
			(1000271, 100, 219, 266, 266),
			(1000272, 100, 219, 266, 266),
			(1000273, 100, 219, 266, 266),
			(1000276, 100, 219, 266, 266),
			(1000277, 100, 219, 266, 266),
			(1000278, 100, 219, 266, 266),
			(1000279, 100, 219, 266, 266),
			(1000280, 100, 219, 266, 266),
			(1000281, 100, 219, 266, 266),
			(1000282, 100, 219, 266, 266),
			(1000283, 100, 219, 266, 266),
			(1000284, 100, 219, 266, 266),
			(1000285, 100, 265, 343, 343),
			(1000286, 100, 219, 266, 266),
			(1000287, 100, 219, 266, 266),
			(1000288, 100, 219, 266, 266),
			(1000289, 100, 219, 266, 266),
			(1000290, 100, 219, 266, 266),
			(1000291, 100, 219, 266, 266),
			(1000292, 100, 219, 266, 266),
			(1000293, 100, 219, 266, 266),
			(1000294, 100, 219, 266, 266),
			(1000298, 100, 219, 100, 266),
			(1000299, 100, 219, 266, 266),
			(1000300, 100, 219, 266, 266),
			(1000301, 100, 219, 266, 266),
			(1000302, 100, 219, 266, 266),
			(1000303, 100, 264, 212, 212),
			(1000304, 100, 219, 266, 266),
			(1000306, 100, 219, 266, 266),
			(1000307, 100, 219, 266, 266),
			(1000308, 100, 219, 266, 266),
			(1000309, 100, 219, 266, 266),
			(1000310, 100, 219, 266, 266),
			(1000311, 100, 219, 266, 266),
			(1000312, 100, 219, 266, 266),
			(1000313, 100, 219, 266, 266),
			(1000314, 100, 219, 266, 266),
			(1000315, 100, 219, 266, 266),
			(1000317, 100, 219, 266, 266)
	) l (ad_client_id, old_country_id, new_country_id, old_currency_id, new_currency_id);

-- Update the countries in the correct tables
UPDATE c_location l
SET
	c_country_id = tccm.new_country_id
FROM
	tmp_country_currency_mapping tccm
WHERE
	l.ad_client_id = tccm.ad_client_id
	AND l.c_country_id = tccm.old_country_id;

-- Update the currencies
UPDATE c_acctschema ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_invoice ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_bankaccount ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_cashbook ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_cycle ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_order ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_orderline ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_payment ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_project ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE gl_journalline ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE m_freight ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE m_pricelist ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_payment ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE c_allocationhdr ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE ad_role ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

UPDATE fact_acct ut
SET
	c_currency_id = tccm.new_currency_id
FROM
	ad_client c
		JOIN tmp_country_currency_mapping tccm
			ON c.ad_client_id = tccm.ad_client_id
WHERE
	ut.ad_client_id = c.ad_client_id
	AND ut.c_currency_id = tccm.old_currency_id
	AND tccm.old_currency_id != tccm.new_currency_id;

-- Now update the defaults for the country and currency on client creation
UPDATE ad_process_para
SET
	defaultvalue = '219'
WHERE
	ad_process_para_uu = '36295ea1-0147-46b1-8ac8-ae574f74167a';
UPDATE ad_process_para
SET
	defaultvalue = '266'
WHERE
	ad_process_para_uu = 'b88fcef4-1332-4410-9e57-374ebd5171e9';

-- Be DONE!
SELECT
	register_migration_script('202507251003_GO-3368.sql')
FROM
	dual;
