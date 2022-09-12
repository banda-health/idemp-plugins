CREATE OR REPLACE FUNCTION bh_get_visit_details(ad_client_id numeric,
                                                begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visitdate                  timestamp WITHOUT TIME ZONE,
		        c_order_id                    numeric,
		        c_order_uu                    character varying,
		        ad_org_id                     numeric,
		        receipt_number                numeric,
		        ad_user_id                    numeric,
		        cashier_name                  character varying,
		        c_bpartner_id                 numeric,
		        patient_name                  character varying,
		        bh_patienttype                character varying,
		        bh_patienttype_name           character varying,
		        bh_patientid                  character varying,
		        bh_birthday                   timestamp WITHOUT TIME ZONE,
		        bh_gender                     character varying,
		        bh_phone                      character varying,
		        bh_primarycodeddiagnosis_id   numeric,
		        bh_secondarycodeddiagnosis_id numeric,
		        bh_primaryuncodeddiagnosis    character varying,
		        bh_secondaryuncodeddiagnosis  character varying,
		        docstatus                     character,
		        bh_clinician_user_id          numeric,
		        processing                    character
	        )
	LANGUAGE sql
AS
$$
SELECT
	c.bh_visitdate                  AS visit_date,
	c.c_order_id,
	c.c_order_uu,
	c.ad_org_id,
	c.c_order_id                    AS receipt_number,
	ad.ad_user_id                   AS cashier_id,
	ad.name                         AS cashier_name,
	cb.c_bpartner_id                AS patient_id,
	cb.name                         AS patient_name,
	c.bh_patienttype                AS patient_type,
	r.name                          AS bh_patienttype_name,
	cb.bh_patientid                 AS patient_no,
	cb.bh_birthday                  AS patient_birthday,
	cb.bh_gender                    AS patient_gender,
	cb.bh_phone                     AS patient_phoneNumber,
	c.bh_primarycodeddiagnosis_id   AS primary_coded,
	c.bh_secondarycodeddiagnosis_id AS secondary_coded,
	c.bh_primaryuncodeddiagnosis    AS primary_uncoded,
	c.bh_secondaryuncodeddiagnosis  AS secondary_uncoded,
	c.docstatus                     AS docstatus,
	c.bh_clinician_user_id          AS clinician_id,
	c.processing                    AS processing
FROM
	c_order c
		JOIN c_bpartner cb
			ON c.c_bpartner_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON c.createdby = ad.ad_user_id
		JOIN ad_ref_list r
			ON r.value = c.bh_patienttype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
WHERE
	c.bh_visitdate BETWEEN $2 AND $3
	AND c.ad_client_id = $1
	AND ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7'
	AND c.issotrx = 'Y';
$$;

 -- Commented Code below might be needed in the future
 
-- DO
-- $$
-- 	BEGIN
-- 		IF EXISTS(SELECT
-- 			          1
-- 		          FROM
-- 			          information_schema.routines
-- 		          WHERE
-- 			          ROUTINE_SCHEMA = CURRENT_SCHEMA()
-- 			          AND ROUTINE_NAME = 'bh_get_visit_details') THEN
-- 			DROP FUNCTION bh_get_visit_details;
-- 		END IF;
-- 	END;
-- $$ LANGUAGE plpgsql;