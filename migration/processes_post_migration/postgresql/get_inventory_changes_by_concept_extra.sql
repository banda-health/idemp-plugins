CREATE OR REPLACE function get_inventory_changes_by_concept_extra(_ad_client_id numeric,
                                                                  _start_date timestamp without time zone DEFAULT '-infinity'::timestamp without time zone,
                                                                  _end_date timestamp without time zone DEFAULT 'infinity'::timestamp without time zone)
    RETURNS TABLE
            (
                m_product_id   numeric,
                opening_stock  numeric,
                ending_stock   numeric,
                received_stock numeric,
                balanced_stock numeric,
                value          character varying
            )
    STABLE
    LANGUAGE sql
AS
$$
SELECT p.m_product_id,
       p.openingstock  AS opening_stock,
       p.endingstock   AS ending_stock,
       p.receivedstock AS received_stock,
       p.balancedStock AS balanced_stock,
       p.bhValue       AS value
FROM (SELECT sum(initial.opening_stock)  AS openingStock,
             sum(initial.ending_stock)   AS endingStock,
             sum(initial.balanced_stock) AS balancedStock,
             sum(initial.received_stock) AS receivedStock,
             initial.m_product_id,
             bce.bh_value                AS bhValue
      FROM get_inventory_changes(_ad_client_id, _start_date, _end_date) AS initial
               JOIN m_product p ON initial.m_product_id = p.m_product_id
               JOIN bh_concept bc ON bc.bh_concept_id = p.bh_concept_id
               JOIN bh_concept_extra bce ON bce.bh_concept_id = bc.bh_concept_id AND bce.bh_key = 'moh_747_711_grouping'
      GROUP BY initial.m_product_id, bh_value) AS p
WHERE endingstock > 0
   OR openingstock > 0
   OR receivedstock > 0
   OR balancedstock > 0
$$;
