-- Some entities have different currencies than their client, so fix that
DROP TABLE IF EXISTS tmp_currencies_to_update;
SELECT DISTINCT
	ah.ad_client_id,
	ah.c_currency_id    AS header_currency,
	i.c_currency_id     AS invoice_currency,
	accts.c_currency_id AS client_currency,
	p.c_currency_id     AS payment_currency
INTO TEMP TABLE
	tmp_currencies_to_update
FROM
	c_allocationhdr ah
		JOIN c_allocationline al
			ON ah.c_allocationhdr_id = al.c_allocationhdr_id
		JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id
		JOIN ad_clientinfo ci
			ON i.ad_client_id = ci.ad_client_id
		JOIN c_acctschema accts
			ON ci.c_acctschema1_id = accts.c_acctschema_id
		LEFT JOIN c_payment p
			ON al.c_payment_id = p.c_payment_id
WHERE
	accts.c_currency_id != ah.c_currency_id
	OR i.c_currency_id != ah.c_currency_id;

-- Correct allocation headers
UPDATE c_allocationhdr ah
SET
	c_currency_id = tctu.client_currency
FROM
	tmp_currencies_to_update tctu
WHERE
	tctu.ad_client_id = ah.ad_client_id
	AND ah.c_currency_id = tctu.header_currency;
-- Correct invoices
UPDATE c_invoice i
SET
	c_currency_id = tctu.client_currency
FROM
	tmp_currencies_to_update tctu
WHERE
	tctu.ad_client_id = i.ad_client_id
	AND i.c_currency_id = tctu.invoice_currency;
-- Correct payments
UPDATE c_payment p
SET
	c_currency_id = tctu.client_currency
FROM
	tmp_currencies_to_update tctu
WHERE
	tctu.ad_client_id = p.ad_client_id
	AND p.c_currency_id = tctu.payment_currency;

-- Now just fix invoices & payments that don't match
UPDATE c_invoice i
SET
	c_currency_id = accts.c_currency_id
FROM
	ad_clientinfo ci
		JOIN c_acctschema accts
			ON ci.c_acctschema1_id = accts.c_acctschema_id
WHERE
	ci.ad_client_id = i.ad_client_id
	AND accts.c_currency_id != i.c_currency_id;
UPDATE c_payment p
SET
	c_currency_id = accts.c_currency_id
FROM
	ad_clientinfo ci
		JOIN c_acctschema accts
			ON ci.c_acctschema1_id = accts.c_acctschema_id
WHERE
	ci.ad_client_id = p.ad_client_id
	AND accts.c_currency_id != p.c_currency_id;

-- Update invoices, allocations, & payments where the client ID doesn't match the org
UPDATE c_invoice i
SET
	ad_client_id = o.ad_client_id
FROM
	ad_org o
WHERE
	o.ad_org_id = i.ad_org_id
	AND i.ad_client_id = 1000000
	AND i.ad_org_id > 1000000
	AND i.ad_client_id != o.ad_client_id;
UPDATE c_allocationline al
SET
	ad_client_id = o.ad_client_id
FROM
	ad_org o
WHERE
	o.ad_org_id = al.ad_org_id
	AND al.ad_client_id = 1000000
	AND al.ad_org_id > 1000000
	AND al.ad_client_id != o.ad_client_id;
UPDATE c_allocationhdr ah
SET
	ad_client_id = o.ad_client_id
FROM
	ad_org o
WHERE
	o.ad_org_id = ah.ad_org_id
	AND ah.ad_client_id = 1000000
	AND ah.ad_org_id > 1000000
	AND ah.ad_client_id != o.ad_client_id;
UPDATE c_payment p
SET
	ad_client_id = o.ad_client_id
FROM
	ad_org o
WHERE
	o.ad_org_id = p.ad_org_id
	AND p.ad_client_id = 1000000
	AND p.ad_org_id > 1000000
	AND p.ad_client_id != o.ad_client_id;

SELECT
	register_migration_script('202210242028_GO-2380.sql')
FROM
	dual;
