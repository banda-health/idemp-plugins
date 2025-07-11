-- Remove an old table from the GraphQL generator template table list
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = REPLACE(tablename, 'BH_Role_WarehouseAccess', '')
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03';

-- Drop function we don't need anymore
DROP FUNCTION IF EXISTS get_inventory_changes_by_concept_extra(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);

-- Rename stored function
DROP FUNCTION IF EXISTS bh_get_inventory_changes(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_inventory_changes(_ad_client_id numeric,
                                         _start_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                         _end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        m_product_id              numeric,
		        m_attributesetinstance_id numeric,
		        purchase_price            numeric,
		        purchase_date             timestamp WITHOUT TIME ZONE,
		        sell_price                numeric,
		        cost_of_goods_sold        numeric,
		        gross_profit              numeric,
		        gain_loss                 numeric,
		        opening_stock             numeric,
		        ending_stock              numeric,
		        received_stock            numeric,
		        sold_stock                numeric,
		        balanced_stock            numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
WITH product_costs AS (
	SELECT
		pc.m_product_id,
		pc.m_attributesetinstance_id,
		pc.purchase_price,
		pc.purchase_date
	FROM
		get_product_costs(_ad_client_id) pc
)
SELECT
	p.m_product_id,
	p.m_attributesetinstance_id,
	p.PurchasePrice                                AS purchase_price,
	p.PurchaseDate                                 AS purchase_date,
	p.sell_price,
	p.soldstock * p.PurchasePrice                  AS cost_of_goods_sold,
	p.soldstock * (p.sell_price - p.PurchasePrice) AS gross_profit,
	p.balancestock * p.PurchasePrice               AS gain_loss,
	p.openingstock                                 AS opening_stock,
	p.endingstock                                  AS ending_stock,
	p.receivedstock                                AS received_stock,
	p.soldstock                                    AS sold_stock,
	p.balancestock                                 AS balanced_stock
FROM
	(
		SELECT
			m_product_id,
			m_attributesetinstance_id,
			openingstock,
			endingstock,
			receivedstock,
			balancestock,
			PurchaseDate,
			PurchasePrice,
			COALESCE(SUM((STRING_TO_ARRAY(sell_information, ',', 'null'))[1]::numeric), 0) AS soldstock,
			(STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric                   AS sell_price
		FROM
			(
				SELECT
					p.m_product_id,
					pc.m_attributesetinstance_id,
					COALESCE(SUM(t.movementqty) FILTER ( WHERE t.movementdate::date + t.updated::time < _start_date ),
					         0)                                                  AS openingstock,
					COALESCE(SUM(t.movementqty) FILTER ( WHERE t.movementdate::date + t.updated::time <= _end_date ),
					         0)                                                  AS endingstock,
					COALESCE(
							SUM(t.movementqty)
							FILTER ( WHERE t.movementdate::date + t.updated::time BETWEEN _start_date AND _end_date AND
							               t.movementtype IN ('V+', 'V-') ),
							0)                                                       AS receivedstock,
					COALESCE(
							SUM(t.movementqty)
							FILTER ( WHERE t.movementdate::date + t.updated::time BETWEEN _start_date AND _end_date AND
							               t.movementtype IN ('I+', 'I-') ),
							0)                                                       AS balancestock,
					pc.purchase_price                                            AS PurchasePrice,
					pc.purchase_date                                             AS PurchaseDate,
					UNNEST(CASE
						       WHEN ARRAY_AGG(t.movementqty * -1 || ',' || COALESCE(ol.priceactual, 0))
						            FILTER ( WHERE t.movementdate::date + t.updated::time BETWEEN _start_date AND _end_date AND
						                           t.movementtype IN ('C+', 'C-') ) IS NULL THEN '{null}'
						       ELSE ARRAY_AGG(t.movementqty * -1 || ',' || COALESCE(ol.priceactual, 0))
						            FILTER ( WHERE t.movementdate::date + t.updated::time BETWEEN _start_date AND _end_date AND
						                           t.movementtype IN ('C+',
						                                              'C-') ) END) AS sell_information
				FROM
					m_product p
						LEFT JOIN product_costs pc
						ON pc.m_product_id = p.m_product_id
						LEFT JOIN m_transaction t
						ON p.m_product_id = t.m_product_id AND t.m_attributesetinstance_id = pc.m_attributesetinstance_id
						LEFT JOIN m_inoutline iol
						ON iol.m_inoutline_id = t.m_inoutline_id AND t.movementtype IN ('C+', 'C-')
						LEFT JOIN c_orderline ol
						ON iol.c_orderline_id = ol.c_orderline_id
				WHERE
					p.ad_client_id = _ad_client_id
				GROUP BY
					p.m_product_id, pc.m_attributesetinstance_id, pc.purchase_price, pc.purchase_date
			) AS p
		GROUP BY
			m_product_id, m_attributesetinstance_id, openingstock, endingstock, receivedstock, balancestock, PurchaseDate,
			PurchasePrice, (STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric
	) AS p
WHERE
	endingstock > 0
	OR openingstock > 0
	OR receivedstock > 0
	OR soldstock > 0
	OR balancestock > 0
$$;

-- Add access to the report for the right users
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                   updatedby, isreadwrite, ad_process_access_uu)
SELECT
	ad_process_id,
	ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4()
FROM
	ad_process p
		JOIN ad_role r
		ON r.ismasterrole = 'Y' AND r.ad_role_uu IN
		                            ('461b31c5-cae2-449d-8a0c-7385b12f4685', '98617c31-55ff-48f9-bd44-253ef323d960',
		                             'c54253cf-c86b-4aaa-b472-ed8880635c62', 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e')
WHERE
	p.ad_process_uu = 'd5d7582e-8364-429c-a7e8-a11f2fcd3401';

SELECT
	register_migration_script('202507071235_GO-2521.sql')
FROM
	dual;
