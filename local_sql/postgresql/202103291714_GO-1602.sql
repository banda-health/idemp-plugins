-- Re-assign payments to the right people
UPDATE c_payment p
SET c_bpartner_id = o.c_bpartner_id
FROM c_order o
LEFT JOIN c_invoice i ON o.c_order_id = i.c_order_id
LEFT JOIN c_allocationline al ON i.c_invoice_id = al.c_invoice_id
WHERE o.c_bpartner_id != p.c_bpartner_id
  AND (o.c_order_id = p.bh_c_order_id OR al.c_payment_id = p.c_payment_id);

SELECT register_migration_script('202103291714_GO-1602.sql') FROM dual;
