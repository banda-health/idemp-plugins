-- Create the visit information function
create or replace function get_visit_info()
    returns TABLE(ad_client_id numeric, c_order_id numeric, c_bpartner_id numeric, bill_date timestamp without time zone, Cashier character varying, patientname character varying, PatientNo varchar, PatientType character varying,
     member_id varchar,MemberName varchar,Relationship varchar,ClaimNo varchar, lineitemtotals numeric, product_list text, Non_Pay_Mode varchar, Non_Payment_Type varchar,
     cash numeric, mobile numeric, credit_debit numeric, bank numeric, checks numeric, TotalDirectPayments numeric, OtherNewPayments numeric, insurance numeric, waiver numeric, donation numeric, TotalNonPayments numeric)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
    -- Order Info
With OrderInfo as (
    select
       co.ad_client_id as ad_client_id,
       co.c_order_id,
       cb.c_bpartner_id,
--        ol.c_charge_id,
       co.bh_visitdate    as bill_date,
       ad.name       as Cashier,
       cb.name            as patientname,
       cb.bh_patientid         as PatientNo,
       co.bh_patienttype as PatientType,
       sum(ol.linenetamt) as lineitemtotals,
       string_agg(mp.name, ', ') AS product_list
    from c_order co
        inner join c_bpartner cb on co.c_bpartner_id = cb.c_bpartner_id
        inner join ad_user ad on co.createdby = ad.ad_user_id
        join c_orderline ol on co.c_order_id = ol.c_order_id
        left join m_product mp ON ol.m_product_id = mp.m_product_id
    where(
             (co.docstatus <> 'VO' AND co.docstatus <> 'DR')
             AND issotrx = 'Y'
             )
           AND ol.c_charge_id IS NULL
         group by co.c_order_id, cb.c_bpartner_id, ol.c_charge_id, co.bh_visitdate, cb.name, ad.name
         order by 1
),
patient_payments as (
    select p.bh_c_order_id                                 as c_order_id,
           tendertype                                      as cmbc,
           sum(p.payamt) filter ( where tendertype = 'X' ) as cash,
           sum(p.payamt) filter ( where tendertype = 'M' ) as mobile,
           sum(p.payamt) filter ( where tendertype = 'C' ) as credit_debit,
           sum(p.payamt) filter ( where tendertype = 'D' ) as bank,
           sum(p.payamt) filter ( where tendertype = 'K' ) as checks,
           sum(p.payamt) filter ( where tendertype NOT IN ('I', 'D', 'W')) as TotalDirectPayments,
           sum(p.payamt) filter ( where tendertype NOT IN ('X', 'M', 'C', 'D', 'K') ) as OtherNewPayments
    from c_payment p
    group by p.bh_c_order_id, cmbc
),
non_patient_payments as (
         select ol.c_order_id,
                sum(ol.linenetamt) filter ( where c.bh_subtype = 'I' ) * -1 as insurance,
                sum(ol.linenetamt) filter ( where c.bh_subtype = 'W' ) * -1 as waiver,
                sum(ol.linenetamt) filter ( where c.bh_subtype = 'D' ) * -1 as donation,
                sum(ol.linenetamt) filter ( where c.bh_subtype IN ('D','W','I' )) * -1 as TotalNonPayments,
                olci.name                                                   as member_id,
                bol.name                                                    as MemberName,
                olc.name                                                    as ClaimNo,
                bci.name                                                    as Relationship,
                c.name as NonPay_Type,
                c.bh_subtype as NonPay_Mode
         from c_orderline ol
                  join c_order o on ol.c_order_id = o.c_order_id
                  join c_charge c on ol.c_charge_id = c.c_charge_id
                  left join (
             select olci.c_orderline_id, olci.name
             from bh_orderline_charge_info olci
                      join bh_charge_info ci ON olci.bh_charge_info_id = ci.bh_charge_info_id
             where (ci.name IN ('Member ID', 'NHIF Number') OR ci.name IS NULL)
         ) as olci on olci.c_orderline_id = ol.c_orderline_id
         left join (
             select bol.c_orderline_id, bol.name
             from bh_orderline_charge_info bol
                      join bh_charge_info ci ON bol.bh_charge_info_id = ci.bh_charge_info_id
             where (ci.name IN ('Patient Name', 'Member Name') OR ci.name IS NULL)
         ) bol on bol.c_orderline_id = ol.c_orderline_id
                  left join (
             select olc.c_orderline_id, olc.name
             from bh_orderline_charge_info olc
                      join bh_charge_info ci ON olc.bh_charge_info_id = ci.bh_charge_info_id
             where (ci.name IN ('Claim Number') OR ci.name IS NULL)
               and (ci.bh_chargeinfodatatype = 'T' and ci.bh_fillfrompatient = 'N')
         ) olc on olc.c_orderline_id = ol.c_orderline_id
                  left join (
             select bci.c_orderline_id, bci.name
             from bh_orderline_charge_info bci
                      join bh_charge_info ci ON bci.bh_charge_info_id = ci.bh_charge_info_id
             where (ci.name IN ('Relationship') OR ci.name IS NULL)
               and (ci.bh_chargeinfodatatype = 'L' and ci.bh_fillfrompatient = 'Y')
         ) bci on bci.c_orderline_id = ol.c_orderline_id
         group by ol.c_order_id, olci.name, bci.name, olc.name, bol.name, c.bh_subtype, c.name
)
Select OrderInfo.ad_client_id,
       OrderInfo.c_order_id,
       OrderInfo.c_bpartner_id,
       OrderInfo.bill_date,
       OrderInfo.Cashier,
       OrderInfo.patientname,
       OrderInfo.PatientNo,
       OrderInfo.PatientType,
       non_patient_payments.member_id,
       non_patient_payments.MemberName,
       non_patient_payments.Relationship,
       non_patient_payments.ClaimNo,
       OrderInfo.lineitemtotals,
       OrderInfo.product_list,
       NonPay_Mode,
       NonPay_Type,
       coalesce(patient_payments.cash, 0)          as cash,
       coalesce(patient_payments.mobile, 0)        as mobile,
       coalesce(patient_payments.credit_debit, 0)  as credit_debit,
       coalesce(patient_payments.bank, 0)          as bank,
       coalesce(patient_payments.checks, 0)        as checks,
       coalesce(patient_payments.TotalDirectPayments, 0) as TotalDirectPayments,
       coalesce(patient_payments.OtherNewPayments, 0) as OtherNewPayments,
       coalesce(non_patient_payments.insurance, 0) as insurance,
       coalesce(non_patient_payments.waiver, 0)    as waiver,
       coalesce(non_patient_payments.donation, 0)  as donation,
       coalesce(non_patient_payments.TotalNonPayments, 0)  as TotalNonPayments
from OrderInfo
         left join patient_payments on OrderInfo.c_order_id = patient_payments.c_order_id
         left join non_patient_payments on OrderInfo.c_order_id = non_patient_payments.c_order_id
order by date(OrderInfo.bill_date) ASC, OrderInfo.patientname ASC;
END
$$; 

SELECT register_migration_script('202205191202_GO-2207.sql') FROM dual;
