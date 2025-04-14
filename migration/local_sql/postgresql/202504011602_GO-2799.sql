-- Update the OTC BP names if they don't match
UPDATE c_bpartner bp
SET
	name = 'OTC - ' || c.name
FROM
	c_bp_group bpg
		CROSS JOIN ad_client c
WHERE
	bp.ad_client_id = c.ad_client_id
	AND bp.c_bp_group_id = bpg.c_bp_group_id
	AND bpg.name = 'OTC Patient'
	AND bp.name != 'OTC - ' || c.name;

-- Set any other OTCs that were created to be duplicates
UPDATE c_bpartner bp2
SET
	name = '[DUP] ' || bp2.name
FROM
	c_bpartner bp1
		JOIN ad_client c
		ON bp1.ad_client_id = c.ad_client_id
		JOIN c_bp_group bpg
		ON bp1.c_bp_group_id = bpg.c_bp_group_id AND bpg.name = 'OTC Patient'
WHERE
	bp1.ad_client_id = bp2.ad_client_id
	AND bp1.c_bpartner_id != bp2.c_bpartner_id
	AND UPPER(TRIM(bp1.name)) = UPPER(TRIM(bp2.name));

-- Change the BP Group of patients assigned to the Standard group to be Patients
UPDATE c_bpartner bp
SET
	c_bp_group_id = bpg_p.c_bp_group_id
FROM
	bh_visit v
		JOIN c_bp_group bpg_p
		ON v.ad_client_id = bpg_p.ad_client_id AND bpg_p.name = 'Patients - DO NOT CHANGE'
		JOIN c_bp_group bpg_s
		ON v.ad_client_id = bpg_s.ad_client_id AND bpg_s.name = 'Standard'
WHERE
	v.patient_id = bp.c_bpartner_id
	AND bp.c_bp_group_id = bpg_s.c_bp_group_id;

-- Update product names to remove duplicates
UPDATE m_product p
SET
	name = CASE
		       WHEN LENGTH(REPEAT('[DUP] '::text, p_d.num::integer) || p.name) > 255
			       THEN '[DUP #' || p_d.num || '] ' || p.name
		       ELSE REPEAT('[DUP] '::text, p_d.num::integer) || p.name END
FROM
	(
		SELECT
			p1.m_product_id,
				ROW_NUMBER() OVER (PARTITION BY p1.ad_client_id, UPPER(TRIM(p1.name)) ORDER BY p1.isactive DESC, p1.created) -
				1 AS num
		FROM
			m_product p1
		WHERE
			EXISTS (
				SELECT
					1
				FROM
					m_product p2
				WHERE
					p1.ad_client_id = p2.ad_client_id
					AND UPPER(TRIM(p1.name)) = UPPER(TRIM(p2.name))
					AND p1.m_product_id != p2.m_product_id
			)
	) p_d
WHERE
	p.m_product_id = p_d.m_product_id;

-- Update Business Partner names to remove duplicates
UPDATE c_bpartner bp
SET
	name = REPEAT('[DUP] '::text, bp_d.num::integer) || bp.name
FROM
	(
		SELECT
			bp1.c_bpartner_id,
				ROW_NUMBER()
				OVER (PARTITION BY bp1.ad_client_id, bp1.c_bp_group_id, UPPER(TRIM(bp1.name)) ORDER BY bp1.isactive DESC, bp1.created) -
				1 AS num
		FROM
			c_bpartner bp1
		WHERE
			EXISTS(
				SELECT
					1
				FROM
					c_bpartner bp2
				WHERE
					bp1.ad_client_id = bp2.ad_client_id
					AND UPPER(TRIM(bp1.name)) = UPPER(TRIM(bp2.name))
					AND (UPPER(TRIM(bp1.bh_phone)) = UPPER(TRIM(bp2.bh_phone)) OR
					     UPPER(TRIM(bp1.nationalid)) = UPPER(TRIM(bp2.nationalid)))
					AND bp1.c_bpartner_id != bp2.c_bpartner_id
					AND bp1.c_bp_group_id = bp2.c_bp_group_id
			)
	) bp_d
WHERE
	bp.c_bpartner_id = bp_d.c_bpartner_id;

-- Now that all duplicates should be removed, and unique constraints to handle this
CREATE UNIQUE INDEX mproduct_unique ON m_product (ad_client_id, UPPER(TRIM(name)));
CREATE UNIQUE INDEX cbpartner_unique_phone_bpg ON c_bpartner (ad_client_id, UPPER(TRIM(name)), UPPER(TRIM(bh_phone)),
                                                              c_bp_group_id);
CREATE UNIQUE INDEX cbpartner_unique_national_bpg ON c_bpartner (ad_client_id, UPPER(TRIM(name)),
                                                                 UPPER(TRIM(nationalid)), c_bp_group_id);

-- Wrap up and be done
SELECT
	register_migration_script('202504011602_GO-2799.sql')
FROM
	dual;
