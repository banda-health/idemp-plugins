DROP FUNCTION IF EXISTS bh_get_visit_non_patient_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_non_patient_payments(ad_client_id numeric,
                                                  begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                  end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id         numeric,
		        c_invoice_id        numeric,
		        chargetype_name     character varying,
		        bh_subtype          character varying,
		        charge_subtype_name character varying,
		        linenetamt          numeric,
		        member_id           character varying,
		        membername          character varying,
		        claimno             character varying,
		        relationship        character varying
	        )
	LANGUAGE sql
	STABLE
AS
$$
-- Get insurance and donors
SELECT
	v.bh_visit_id,
	i.c_invoice_id,
	bp.name            AS ChargeType_name,
	bpg.bh_subtype,
	rl.name            AS charge_subtype_name,
	il.linenetamt * -1 AS linenetamt,
	bpspii.name        AS member_id,
	bpspicl.name       AS MemberName,
	bpspibp.name       AS ClaimNo,
	bpspir.name        AS Relationship
FROM
	bh_visit v
		JOIN c_invoice i
		ON v.bh_visit_id = i.bh_visit_id AND i.docstatus NOT IN ('VO', 'RE', 'RA')
		JOIN c_bpartner bp
		ON i.c_bpartner_id = bp.c_bpartner_id
		JOIN c_bp_group bpg
		ON bp.c_bp_group_id = bpg.c_bp_group_id
		JOIN c_invoiceline il
		ON i.c_invoice_id = il.c_invoice_id
		JOIN ad_ref_list rl
		ON rl.value = bpg.bh_subtype
		JOIN ad_reference r
		ON rl.ad_reference_id = r.ad_reference_id AND ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375'
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Member ID', 'NHIF Number', 'SHA Number', 'Patient ID') OR pif.name IS NULL)
	) AS bpspii
		ON bpspii.c_invoiceline_id = il.c_invoiceline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Patient Name', 'Member Name', 'Mother''s Name') OR pif.name IS NULL)
	) bpspicl
		ON bpspicl.c_invoiceline_id = il.c_orderline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Claim Number') OR pif.name IS NULL)
			AND (pif.bh_payerinfofielddatatype = 'T' AND pif.bh_fillfrompatient = 'N')
	) bpspibp
		ON bpspibp.c_invoiceline_id = il.c_invoiceline_id
		LEFT JOIN (
		SELECT
			bpspi.c_invoiceline_id,
			bpspi.name
		FROM
			bh_bp_specific_payer_info bpspi
				JOIN bh_payer_info_fld pif
				ON bpspi.bh_payer_info_fld_id = pif.bh_payer_info_fld_id
		WHERE
			(pif.name IN ('Relationship') OR pif.name IS NULL)
			AND (pif.bh_payerinfofielddatatype = 'L' AND pif.bh_fillfrompatient = 'Y')
	) bpspir
		ON bpspir.c_invoiceline_id = il.c_invoiceline_id
WHERE
	v.ad_client_id = $1
	AND v.bh_visitdate BETWEEN $2 AND $3
	AND bpg.bh_subtype IN ('I', 'D')
UNION ALL
-- Get waivers
SELECT
	v.bh_visit_id,
	i.c_invoice_id,
	c.name  AS ChargeType_name,
	rl.value,
	rl.name AS charge_subtype_name,
	il.linenetamt,
	NULL    AS member_id,
	NULL    AS MemberName,
	NULL    AS ClaimNo,
	NULL    AS Relationship
FROM
	bh_visit v
		JOIN c_invoice i
		ON v.bh_visit_id = i.bh_visit_id AND i.docstatus NOT IN ('VO', 'RA', 'RE')
		JOIN c_invoiceline il
		ON i.c_invoice_id = il.c_invoice_id
		JOIN c_charge c
		ON il.c_charge_id = c.c_charge_id
		JOIN ad_ref_list rl
		ON c.bh_subtype = rl.value AND rl.value = 'W'
		JOIN ad_reference r
		ON r.ad_reference_uu = 'b313a870-0826-4c1d-a9af-f9ec990b4375' AND r.ad_reference_id = rl.ad_reference_id
WHERE
	v.ad_client_id = $1
	AND v.bh_visitdate BETWEEN $2 AND $3;
$$;
