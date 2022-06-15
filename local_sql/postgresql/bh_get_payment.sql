-- get payments function
create function bh_get_payment(ad_client_id numeric, begin_date timestamp without time zone, end_date timestamp without time zone)
    returns TABLE(c_order_id numeric, ad_org_id numeric, payamt numeric, tendertype character, payment_mode_name character varying, datetrx timestamp without time zone, patient_name character varying, isallocated character, invoice_id numeric, cashier_id numeric, cashier character varying, cashieruuid character varying, docstatus character, processing character, linenetamt numeric)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT c.c_order_id,
               c.ad_org_id,
               p.payamt           as payment_amount,
               p.tendertype       as payment_mode_letter,
               r.name             as payment_mode_name,
               p.datetrx          as payment_date,
               cb.name            as patient_name,
               p.isallocated,
               p.c_invoice_id     as invoice_id,
               c.createdby        as cashier_id,
               ad.name            as cashier,
               ad.ad_user_uu      as cashier_uu,
               c.docstatus        as docstatus,
               c.processing       as processing,
               sum(ol.linenetamt) as lineitemtotals
        FROM c_payment p
                 left join c_allocationline al ON p.c_payment_id = al.c_payment_id
                 left join c_invoice i ON al.c_invoice_id = i.c_invoice_id
                 left join c_order c ON i.c_order_id = c.c_order_id OR p.bh_c_order_id = c.c_order_id
                 left join c_orderline ol ON c.c_order_id = ol.c_order_id
                 join c_bpartner cb on c.c_bpartner_id = cb.c_bpartner_id
                 join ad_user ad on c.createdby = ad.ad_user_id
                 join ad_ref_list r on r.value = p.tendertype
                 join ad_reference a on r.ad_reference_id = a.ad_reference_id
        WHERE c.ad_client_id = $1
          and ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
          and ol.c_charge_id IS NULL
          and (c.bh_visitdate BETWEEN $2 AND $3 OR
               (c.bh_visitdate IS NULL AND date(p.datetrx) BETWEEN $2 AND $3))
        group by c.c_order_id, c.ad_org_id, p.payamt, p.tendertype, r.name, p.datetrx, cb.name, p.isallocated,
                 p.c_invoice_id, c.createdby, ad.name, ad.ad_user_uu, c.docstatus, c.processing;
END
$$;

alter function bh_get_payment(numeric, timestamp, timestamp) owner to adempiere;

