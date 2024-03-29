DROP FUNCTION IF EXISTS bh_get_visit_details(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_details(ad_client_id numeric,
                                                begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id                   numeric,
		        bh_visitdate                  timestamptz,
		        c_order_id                    numeric,
		        c_order_uu                    character varying,
		        ad_org_id                     numeric,
		        receipt_number                numeric,
		        ad_user_id                    numeric,
		        cashier_name                  character varying,
		        createdby_user_uu             character varying,
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
		        processing                    character,
		        saleslineitemtotals           numeric,
		        salestotals                   numeric
	        )
	LANGUAGE sql
	STABLE
AS
$$
SELECT
	v.bh_visit_id,
	v.bh_visitdate                                   AS visit_date,
	o.c_order_id,
	o.c_order_uu,
	v.ad_org_id,
	o.c_order_id                                     AS receipt_number,
	createdby_user.ad_user_id                        AS cashier_id,
	createdby_user.name                              AS cashier_name,
	createdby_user.ad_user_uu                        AS createdby_user_uu,
	v.patient_id                                     AS patient_id,
	bp.name                                          AS patient_name,
	v.bh_patienttype                                 AS patient_type,
	rl.name                                          AS bh_patienttype_name,
	COALESCE(bp.bh_local_patientid, bp.bh_patientid) AS bh_patientid,
	bp.bh_birthday                                   AS patient_birthday,
	bp.bh_gender                                     AS patient_gender,
	bp.bh_phone                                      AS patient_phoneNumber,
	v.bh_primarycodeddiagnosis_id                    AS primary_coded,
	v.bh_secondarycodeddiagnosis_id                  AS secondary_coded,
	v.bh_primaryuncodeddiagnosis                     AS primary_uncoded,
	v.bh_secondaryuncodeddiagnosis                   AS secondary_uncoded,
	o.docstatus                                      AS docstatus,
	v.bh_clinician_user_id                           AS clinician_id,
	o.processing                                     AS processing,
	saleslineitemtotals,
	salestotals
FROM
	bh_visit v
		JOIN c_order o
			ON v.bh_visit_id = o.bh_visit_id
		JOIN c_bpartner bp
			ON v.patient_id = bp.c_bpartner_id
		JOIN ad_user createdby_user
			ON v.createdby = createdby_user.ad_user_id
		JOIN ad_ref_list rl
			ON rl.value = v.bh_patienttype
		JOIN ad_reference r
			ON rl.ad_reference_id = r.ad_reference_id
		JOIN (
		SELECT
			o.c_order_id,
			COALESCE(SUM(ol.linenetamt) FILTER ( WHERE ol.c_charge_id IS NULL ), 0) AS saleslineitemtotals,
			COALESCE(SUM(ol.linenetamt), 0)                                         AS salestotals
		FROM
			c_order o
				JOIN c_orderline ol
					ON o.c_order_id = ol.c_order_id
				JOIN bh_visit v
					ON o.bh_visit_id = v.bh_visit_id
		WHERE
			o.ad_client_id = $1
			AND v.bh_visitdate BETWEEN $2 AND $3
		GROUP BY o.c_order_id
	) sales_details
			ON o.c_order_id = sales_details.c_order_id
WHERE
	v.bh_visitdate BETWEEN $2 AND $3
	AND v.ad_client_id = $1
	AND ad_reference_uu = '47d32afd-3b94-4caa-8490-f0f1a97494f7';
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
