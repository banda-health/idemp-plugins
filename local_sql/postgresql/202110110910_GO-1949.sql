create or replace view bh_stocktake_v(m_product_id, m_warehouse_id, product, description, expirationdate, location, quantity, shelflifedays, ad_client_id, ad_org_id, isinstanceattribute, created, createdby, updated, updatedby, isactive, id, bh_docaction, processed, m_attributeset_id, m_attributesetinstance_id) as
	WITH quantitysums AS (
    SELECT soh.m_product_id,
           sum(soh.qtyonhand) AS quantity,
           soh.ad_client_id,
           soh.ad_org_id,
           soh.m_locator_id,
           soh.m_attributesetinstance_id,
           asi_1.guaranteedate,
           soh.isactive
    FROM m_storageonhand soh
             LEFT JOIN m_attributesetinstance asi_1 ON soh.m_attributesetinstance_id = asi_1.m_attributesetinstance_id
    WHERE soh.isactive = 'Y'::bpchar
    GROUP BY soh.m_product_id, soh.ad_client_id, soh.ad_org_id, soh.m_locator_id, asi_1.guaranteedate,
             soh.m_attributesetinstance_id, soh.isactive
)
SELECT s.m_product_id,
       l.m_warehouse_id,
       p.name                                                                          AS product,
       asi.description,
       asi.guaranteedate                                                               AS expirationdate,
       l.value                                                                         AS location,
       s.quantity,
       daysbetween(asi.guaranteedate::timestamp with time zone,
                   'now'::text::timestamp without time zone::timestamp with time zone) AS shelflifedays,
       s.ad_client_id,
       s.ad_org_id,
       attset.isinstanceattribute,
       attset.created,
       attset.createdby,
       attset.updated,
       attset.updatedby,
       s.isactive,
       concat(s.m_product_id, l.m_warehouse_id)                                        AS id,
       st.bh_docaction,
       st.processed,
       asi.m_attributeset_id,
       asi.m_attributesetinstance_id
FROM quantitysums s
         JOIN m_locator l ON s.m_locator_id = l.m_locator_id
         JOIN m_product p ON s.m_product_id = p.m_product_id
         LEFT JOIN m_attributesetinstance asi ON s.m_attributesetinstance_id = asi.m_attributesetinstance_id
         LEFT JOIN m_attributeset attset ON asi.m_attributeset_id = attset.m_attributeset_id
         LEFT JOIN bh_stocktake st ON asi.m_attributesetinstance_id = st.m_attributesetinstance_id
WHERE attset.name::text = 'BandaHealthProductAttributeSet'::text
   OR attset.name IS NULL
   OR attset.m_attributeset_id = 0::numeric
ORDER BY p.name;

SELECT register_migration_script('202110110910_GO-1949.sql') FROM dual;
