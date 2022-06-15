--Non_patient_payments function
create function bh_get_non_patient_payments(ad_client_id numeric)
    returns TABLE(c_order_id numeric, c_charge_id numeric, chargetype_name character varying, bh_subtype character varying, charge_subtype_name character varying, c_chargetype_id numeric, linenetamt numeric, member_id character varying, membername character varying, claimno character varying, relationship character varying)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT ol.c_order_id,
               c.c_charge_id,
               c.name    as ChargeType_name,
               c.bh_subtype,
               r.name    as charge_subtype_name,
               c.c_chargetype_id,
               ol.linenetamt,
               olci.name as member_id,
               bol.name  as MemberName,
               olc.name  as ClaimNo,
               bci.name  as Relationship
        from c_charge c
                 left join c_orderline ol on c.c_charge_id = ol.c_charge_id
                 join ad_ref_list r on r.value = c.bh_subtype
                 join ad_reference a on r.ad_reference_id = a.ad_reference_id
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
--             where (ci.bh_chargeinfodatatype = 'T' and ci.bh_fillfrompatient = 'Y')
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
        where ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
          and ol.c_charge_id IS NOT NULL
          and c.ad_client_id = $1;
END
$$;

alter function bh_get_non_patient_payments(numeric) owner to adempiere;

