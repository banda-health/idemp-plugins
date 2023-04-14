-- Convert functions to language SQL to allow for inlining
-- See https://dba.stackexchange.com/questions/8119/function-performance/8189#8189 and https://wiki.postgresql.org/wiki/Inlining_of_SQL_functions

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
	c.bh_patienttype::varchar       AS patient_type,
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

CREATE OR REPLACE FUNCTION bh_get_visit_non_patient_payments(ad_client_id numeric,
                                                             begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                             end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id          numeric,
		        c_charge_id         numeric,
		        chargetype_name     character varying,
		        bh_subtype          character varying,
		        charge_subtype_name character varying,
		        c_chargetype_id     numeric,
		        linenetamt          numeric,
		        member_id           character varying,
		        membername          character varying,
		        claimno             character varying,
		        relationship        character varying
	        )
	LANGUAGE sql
AS
$$
SELECT
	ol.c_order_id,
	c.c_charge_id,
	c.name    AS ChargeType_name,
	c.bh_subtype,
	r.name    AS charge_subtype_name,
	c.c_chargetype_id,
	ol.linenetamt,
	olci.name AS member_id,
	bol.name  AS MemberName,
	olc.name  AS ClaimNo,
	bci.name  AS Relationship
FROM
	c_charge c
		LEFT JOIN c_orderline ol
			ON c.c_charge_id = ol.c_charge_id
		LEFT JOIN c_order co
			ON ol.c_order_id = co.c_order_id
		JOIN ad_ref_list r
			ON r.value = c.bh_subtype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
		LEFT JOIN (
		SELECT
			olci.c_orderline_id,
			olci.name
		FROM
			bh_orderline_charge_info olci
				JOIN bh_charge_info ci
					ON olci.bh_charge_info_id = ci.bh_charge_info_id
		WHERE
			(ci.name IN ('Member ID', 'NHIF Number', 'Patient ID') OR ci.name IS NULL)
	) AS olci
			ON olci.c_orderline_id = ol.c_orderline_id
		LEFT JOIN (
		SELECT
			bol.c_orderline_id,
			bol.name
		FROM
			bh_orderline_charge_info bol
				JOIN bh_charge_info ci
					ON bol.bh_charge_info_id = ci.bh_charge_info_id
		WHERE
			(ci.name IN ('Patient Name', 'Member Name', 'Mother''s Name') OR ci.name IS NULL)
	) bol
			ON bol.c_orderline_id = ol.c_orderline_id
		LEFT JOIN (
		SELECT
			olc.c_orderline_id,
			olc.name
		FROM
			bh_orderline_charge_info olc
				JOIN bh_charge_info ci
					ON olc.bh_charge_info_id = ci.bh_charge_info_id
		WHERE
			(ci.name IN ('Claim Number') OR ci.name IS NULL)
			AND (ci.bh_chargeinfodatatype = 'T' AND ci.bh_fillfrompatient = 'N')
	) olc
			ON olc.c_orderline_id = ol.c_orderline_id
		LEFT JOIN (
		SELECT
			bci.c_orderline_id,
			bci.name
		FROM
			bh_orderline_charge_info bci
				JOIN bh_charge_info ci
					ON bci.bh_charge_info_id = ci.bh_charge_info_id
		WHERE
			(ci.name IN ('Relationship') OR ci.name IS NULL)
			AND (ci.bh_chargeinfodatatype = 'L' AND ci.bh_fillfrompatient = 'Y')
	) bci
			ON bci.c_orderline_id = ol.c_orderline_id
WHERE
	ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
	AND ol.c_charge_id IS NOT NULL
	AND c.ad_client_id = $1
	AND co.bh_visitdate BETWEEN $2 AND $3
	AND co.issotrx = 'Y';
$$;

CREATE OR REPLACE FUNCTION bh_get_visit_payments(ad_client_id numeric, begin_date timestamp WITHOUT TIME ZONE,
                                                 end_date timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id        numeric,
		        bh_c_order_id     numeric,
		        ad_org_id         numeric,
		        payamt            numeric,
		        tendertype        character,
		        payment_mode_name character varying,
		        datetrx           timestamp WITHOUT TIME ZONE,
		        patient_name      character varying,
		        isallocated       character,
		        invoice_id        numeric,
		        cashier_id        numeric,
		        cashier           character varying,
		        cashier_uu        character varying,
		        docstatus         character,
		        processing        character,
		        linenetamt        numeric
	        )
	LANGUAGE sql
AS
$$
SELECT
	c.c_order_id,
	p.bh_c_order_id,
	c.ad_org_id,
	p.payamt           AS payment_amount,
	p.tendertype       AS payment_mode_letter,
	r.name             AS payment_mode_name,
	p.datetrx          AS payment_date,
	cb.name            AS patient_name,
	p.isallocated,
	p.c_invoice_id     AS invoice_id,
	c.createdby        AS cashier_id,
	ad.name            AS cashier,
	ad.ad_user_uu      AS cashier_uu,
	c.docstatus        AS docstatus,
	c.processing       AS processing,
	SUM(ol.linenetamt) AS lineitemtotals
FROM
	c_payment p
		LEFT JOIN c_allocationline al
			ON p.c_payment_id = al.c_payment_id
		LEFT JOIN c_invoice i
			ON al.c_invoice_id = i.c_invoice_id
		JOIN c_order c
			ON i.c_order_id = c.c_order_id OR p.bh_c_order_id = c.c_order_id
		JOIN c_orderline ol
			ON c.c_order_id = ol.c_order_id
		JOIN c_bpartner cb
			ON c.c_bpartner_id = cb.c_bpartner_id
		JOIN ad_user ad
			ON c.createdby = ad.ad_user_id
		JOIN ad_ref_list r
			ON r.value = p.tendertype
		JOIN ad_reference a
			ON r.ad_reference_id = a.ad_reference_id
WHERE
	p.ad_client_id = $1
	AND ad_reference_uu = '7eca6283-86b9-4dff-9c40-786162a8be7a'
	AND ol.c_charge_id IS NULL
	AND c.issotrx = 'Y'
	AND c.bh_visitdate BETWEEN begin_date AND end_date
GROUP BY
	c.c_order_id, c.ad_org_id, p.payamt, p.tendertype, r.name, p.datetrx, cb.name, p.isallocated,
	p.c_invoice_id, c.createdby, ad.name, ad.ad_user_uu, c.docstatus, c.processing, p.bh_c_order_id;
$$;

CREATE OR REPLACE FUNCTION bh_get_visit_products(ad_client_id numeric,
                                                 begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                 end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        c_order_id            numeric,
		        m_product_id          numeric,
		        product_name          character varying,
		        m_product_category_id numeric,
		        product_category_name character varying,
		        product_type_value    character varying,
		        product_type_name     character varying,
		        quantity              numeric,
		        price                 numeric,
		        linenetamt            numeric,
		        m_warehouse_id        numeric,
		        warehouse_name        character varying,
		        processed             character
	        )
	LANGUAGE sql
AS
$$
SELECT
	ol.c_order_id,
	p.m_product_id,
	p.name          AS product_name,
	pc.m_product_category_id,
	pc.name         AS product_category_name,
	rl.value        AS product_type_value,
	rl.name         AS product_type_name,
	ol.qtyentered   AS quantity,
	ol.priceentered AS price,
	ol.linenetamt,
	w.m_warehouse_id,
	w.name          AS warehouse_name,
	ol.processed
FROM
	c_orderline ol
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
		JOIN m_product p
			ON ol.m_product_id = p.m_product_id
		JOIN m_product_category pc
			ON p.m_product_category_id = pc.m_product_category_id
		JOIN ad_ref_list rl
			ON p.producttype = rl.value
		JOIN ad_reference r
			ON rl.ad_reference_id = r.ad_reference_id AND r.ad_reference_uu = '668f05be-1e2e-498c-a016-cc5b623ed0cd'
		LEFT JOIN m_inoutline iol
			ON ol.c_orderline_id = iol.c_orderline_id
		LEFT JOIN m_locator l
			ON iol.m_locator_id = l.m_locator_id
		LEFT JOIN m_warehouse w
			ON l.m_warehouse_id = w.m_warehouse_id
WHERE
	o.bh_visitdate BETWEEN $2 AND $3
	AND o.issotrx = 'Y'
	AND ol.ad_client_id = $1;
$$;


SELECT register_migration_script('202208110540_GO-2416.sql') FROM dual;

