drop view bh_drug_profit_loss_v;

create view bh_drug_profit_loss_v(ad_client_id, ad_org_id, bh_visitdate, name, qtyordered, quantityreceived, pricesold, pricebought, client_name, guaranteedate) as
	WITH rg AS (
    SELECT c_1.ad_client_id,
           c_1.ad_org_id,
           ln_1.m_product_id,
           sum(ln_1.qtyordered) AS quantityreceived,
           ln_1.priceactual     AS pricebought,
           ln_1.m_warehouse_id,
           t_1.m_attributesetinstance_id
    FROM adempiere.c_order c_1
             JOIN adempiere.c_orderline ln_1 ON c_1.c_order_id = ln_1.c_order_id
             JOIN adempiere.m_inoutline min_1 ON ln_1.c_orderline_id = min_1.c_orderline_id
             JOIN adempiere.m_transaction t_1 ON min_1.m_inoutline_id = t_1.m_inoutline_id AND t_1.movementtype = 'V+'::bpchar
    WHERE c_1.issotrx = 'N'::bpchar
    GROUP BY ln_1.m_product_id, ln_1.priceactual, ln_1.m_warehouse_id, c_1.ad_client_id, c_1.ad_org_id,
             t_1.m_attributesetinstance_id
)
SELECT c.ad_client_id,
       c.ad_org_id,
       c.bh_visitdate,
       p.name,
       ln.qtyordered,
       rg.quantityreceived,
       ln.priceactual AS pricesold,
       rg.pricebought,
       client.name    AS client_name,
       m.guaranteedate
FROM adempiere.c_order c
         JOIN adempiere.c_orderline ln
              ON c.c_order_id = ln.c_order_id AND c.ad_client_id = ln.ad_client_id AND c.ad_org_id = ln.ad_org_id
         JOIN adempiere.m_inoutline min ON ln.c_orderline_id = min.c_orderline_id
         JOIN adempiere.m_transaction t ON min.m_inoutline_id = t.m_inoutline_id AND t.movementtype = 'C-'::bpchar
         JOIN rg ON t.m_attributesetinstance_id = rg.m_attributesetinstance_id AND ln.m_product_id = rg.m_product_id AND
                    rg.m_warehouse_id = ln.m_warehouse_id
         JOIN adempiere.m_attributesetinstance m ON t.m_attributesetinstance_id = m.m_attributesetinstance_id
         JOIN adempiere.m_product p ON ln.m_product_id = p.m_product_id
         JOIN adempiere.ad_client client ON c.ad_client_id = client.ad_client_id
WHERE c.issotrx = 'Y'::bpchar
ORDER BY c.bh_visitdate DESC;

SELECT register_migration_script('202105261051_GO-1677.sql') FROM dual;
