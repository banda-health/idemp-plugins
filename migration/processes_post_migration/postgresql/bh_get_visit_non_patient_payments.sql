DROP FUNCTION IF EXISTS bh_get_visit_non_patient_payments(numeric, timestamp WITHOUT TIME ZONE, timestamp WITHOUT TIME ZONE);
CREATE FUNCTION bh_get_visit_non_patient_payments(ad_client_id numeric,
                                                             begin_date timestamp WITHOUT TIME ZONE DEFAULT '-infinity'::timestamp WITHOUT TIME ZONE,
                                                             end_date timestamp WITHOUT TIME ZONE DEFAULT 'infinity'::timestamp WITHOUT TIME ZONE)
	RETURNS TABLE
	        (
		        bh_visit_id         numeric,
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
	STABLE
AS
$$
SELECT
	v.bh_visit_id,
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
		JOIN c_orderline ol
			ON c.c_charge_id = ol.c_charge_id
		JOIN c_order o
			ON ol.c_order_id = o.c_order_id
		JOIN bh_visit v
			ON o.bh_visit_id = v.bh_visit_id
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
	AND v.bh_visitdate BETWEEN $2 AND $3;
$$;
