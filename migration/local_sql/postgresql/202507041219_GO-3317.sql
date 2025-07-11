-- Add storeroom parameter
INSERT INTO
	ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	                 updatedby, name, description, help, ad_process_id, seqno, ad_reference_id,
	                 ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength,
	                 ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax,
	                 ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted,
	                 mandatorylogic, placeholder, placeholder2, isautocomplete, ad_fieldgroup_id, query,
	                 daterangeoption, isshownegatebutton)
VALUES
	((
		 SELECT MAX(ad_process_para_id) + 1
		 FROM ad_process_para
	 ), 0, 0, 'Y', '2025-07-04 11:39:20.294000', 100,
	 '2025-07-04 12:11:10.752000', 100, 'Storeroom', NULL,
	 NULL, (
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'
	 ), 30,
	 19, NULL, NULL, 'M_Warehouse_UU', 'N', 36, 'N', 'N', NULL, NULL, NULL, NULL, NULL, NULL, 'U',
	 NULL, NULL, 'c557e267-25d1-421e-975c-ebb49ff90cce', 'N', NULL, NULL, NULL, 'N', NULL, NULL, 'D', 'N');

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
		        balanced_stock            numeric,
		        m_locator_id              numeric
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
	p.balancestock                                 AS balanced_stock,
	m_locator_id
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
			(STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric                   AS sell_price,
			m_locator_id
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
						                                              'C-') ) END) AS sell_information,
					t.m_locator_id
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
					p.m_product_id, pc.m_attributesetinstance_id, pc.purchase_price, pc.purchase_date, t.m_locator_id
			) AS p
		GROUP BY
			m_product_id, m_attributesetinstance_id, openingstock, endingstock, receivedstock, balancestock, PurchaseDate,
			PurchasePrice, (STRING_TO_ARRAY(sell_information, ',', 'null'))[2]::numeric, m_locator_id
	) AS p
WHERE
	endingstock > 0
	OR openingstock > 0
	OR receivedstock > 0
	OR soldstock > 0
	OR balancestock > 0
$$;

SELECT
	register_migration_script('202507041219_GO-3317.sql')
FROM
	dual;
