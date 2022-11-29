create or replace view bh_stocktake_v
            (m_product_id, m_warehouse_id, product, description, expirationdate, location, quantity, shelflifedays,
             ad_client_id, ad_org_id, isinstanceattribute, created, createdby, updated, updatedby, isactive, id,
             bh_docaction, processed, m_attributeset_id, m_attributesetinstance_id)
as
WITH quantitysums AS (
    SELECT s_1.m_product_id,
           sum(s_1.qtyonhand) AS quantity,
           s_1.ad_client_id,
           s_1.ad_org_id,
           s_1.m_locator_id,
           s_1.m_attributesetinstance_id,
           asi_1.guaranteedate
    FROM adempiere.m_storage s_1
             LEFT JOIN adempiere.m_attributesetinstance asi_1
                       ON s_1.m_attributesetinstance_id = asi_1.m_attributesetinstance_id
    GROUP BY s_1.m_product_id, s_1.ad_client_id, s_1.ad_org_id, s_1.m_locator_id, asi_1.guaranteedate,
             s_1.m_attributesetinstance_id
)
SELECT s.m_product_id,
       l.m_warehouse_id,
       p.name                                                                                    AS product,
       asi.description,
       asi.guaranteedate                                                                         AS expirationdate,
       l.value                                                                                   AS location,
       s.quantity,
       adempiere.daysbetween(asi.guaranteedate::timestamp with time zone,
                             'now'::text::timestamp without time zone::timestamp with time zone) AS shelflifedays,
       s.ad_client_id,
       s.ad_org_id,
       attset.isinstanceattribute,
       attset.created,
       attset.createdby,
       attset.updated,
       attset.updatedby,
       attset.isactive,
       concat(s.m_product_id, l.m_warehouse_id)                                                  AS id,
       st.bh_docaction,
       st.processed,
       asi.m_attributeset_id,
       asi.m_attributesetinstance_id
FROM quantitysums s
         JOIN adempiere.m_locator l ON s.m_locator_id = l.m_locator_id
         JOIN adempiere.m_product p ON s.m_product_id = p.m_product_id
         LEFT JOIN adempiere.m_attributesetinstance asi ON s.m_attributesetinstance_id = asi.m_attributesetinstance_id
         LEFT JOIN adempiere.m_attributeset attset ON asi.m_attributeset_id = attset.m_attributeset_id
    AND attset.name = 'BandaHealthProductAttributeSet'
         LEFT JOIN adempiere.bh_stocktake st ON asi.m_attributesetinstance_id = st.m_attributesetinstance_id
ORDER BY p.name;

SELECT register_migration_script('202110071021_GO-1942.sql') FROM dual;
