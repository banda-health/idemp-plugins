-- Get Visit Details Function
create function bh_get_visit_details(ad_client_id numeric, begin_date timestamp without time zone DEFAULT '-infinity'::timestamp without time zone, end_date timestamp without time zone DEFAULT 'infinity'::timestamp without time zone)
    returns TABLE(bh_visitdate timestamp without time zone, c_order_id numeric, c_order_uu character varying, ad_org_id numeric, receipt_number numeric, ad_user_id numeric, cashier_name character varying, c_bpartner_id numeric, patient_name character varying, bh_patienttype character varying, bh_patientid character varying, bh_birthday timestamp without time zone, bh_gender character varying, bh_phone character varying, bh_primarycodeddiagnosis_id numeric, bh_secondarycodeddiagnosis_id numeric, bh_primaryuncodeddiagnosis character varying, bh_secondaryuncodeddiagnosis character varying, docstatus character, bh_clinician_user_id numeric, processing character)
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
        SELECT c.bh_visitdate                  as visit_date,
               c.c_order_id,
               c.c_order_uu,
               c.ad_org_id,
               c.c_order_id                    as receipt_number,
               ad.ad_user_id                   as cashier_id,
               ad.name                         as cashier_name,
               cb.c_bpartner_id                as patient_id,
               cb.name                         as patient_name,
               c.bh_patienttype                as patient_type,
               cb.bh_patientid                 as patient_no,
               cb.bh_birthday                  as patient_birthday,
               cb.bh_gender                    as patient_gender,
               cb.bh_phone                     as patient_phoneNumber,
               c.bh_primarycodeddiagnosis_id   as primary_coded,
               c.bh_secondarycodeddiagnosis_id as secondary_coded,
               c.bh_primaryuncodeddiagnosis    as primary_uncoded,
               c.bh_secondaryuncodeddiagnosis  as secondary_uncoded,
               c.docstatus                     as docstatus,
               c.bh_clinician_user_id          as clinician_id,
               c.processing                    as processing
        FROM c_order c
                 join c_bpartner cb on c.c_bpartner_id = cb.c_bpartner_id
                 join ad_user ad on c.createdby = ad.ad_user_id
        WHERE c.bh_visitdate BETWEEN $2 AND $3
          AND c.ad_client_id = $1
          AND c.issotrx = 'Y';
END
$$;

alter function bh_get_visit_details(numeric, timestamp, timestamp) owner to adempiere;

