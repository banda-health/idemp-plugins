-----------------------------------------------------------------------------
-- Migration Script: GO-3523 - Remove Unused UOM Records
-- Description: Deletes specific unused C_UOM records by UUID and keeps defaults pointing to Each (100).

WITH target_uom AS (
	SELECT
		c_uom_id
	FROM
		c_uom
	WHERE
		c_uom_uu IN (
		             '015f8f25-216b-4bb0-a4f8-3f19f84d27d4',
		             '8afa898c-1a7e-4b66-b878-694409c720ff',
		             '6678e6da-bed0-4704-acc2-f45a77022130',
		             'a9b9be37-5dfe-436e-a0a7-c7c33a66e4c3',
		             '68535d3f-596a-4400-9f72-ad032ec9e145',
		             'ddba8d0f-26ca-4fe4-8253-a60d0dd22d1b',
		             'c2dbbdb4-433e-47d2-91bc-6e2b00c2644b',
		             'a409bde4-f5c9-4c07-9752-99602fccd687',
		             'e12aed18-09e9-4fd1-ad41-a9d5156b37ee',
		             '648f31ee-4630-4ff5-b6e2-6df0946f4ab4',
		             'f622fe59-cbbd-4835-96b2-bb8eb5b8bf99',
		             'f058dfd3-89f5-46e8-b2b8-11df0505dffa',
		             'c0776c7c-f653-4663-89ed-cb2bf92b6998',
		             '3bb47b84-d840-4037-b1c6-dfb15503e590',
		             'fd31e3a5-714e-41ed-ae67-33c9c075160c',
		             '06edf453-43b0-41f3-9767-1dcc0dba33de'
			)
)
UPDATE ad_clientinfo ci
SET
	c_uom_length_id = CASE
		                  WHEN ci.c_uom_length_id IN (
			                  SELECT
				                  c_uom_id
			                  FROM
				                  target_uom
		                  ) THEN 100
		                  ELSE ci.c_uom_length_id END,
	c_uom_time_id   = CASE
		                  WHEN ci.c_uom_time_id IN (
			                  SELECT
				                  c_uom_id
			                  FROM
				                  target_uom
		                  ) THEN 100
		                  ELSE ci.c_uom_time_id END,
	c_uom_volume_id = CASE
		                  WHEN ci.c_uom_volume_id IN (
			                  SELECT
				                  c_uom_id
			                  FROM
				                  target_uom
		                  ) THEN 100
		                  ELSE ci.c_uom_volume_id END,
	c_uom_weight_id = CASE
		                  WHEN ci.c_uom_weight_id IN (
			                  SELECT
				                  c_uom_id
			                  FROM
				                  target_uom
		                  ) THEN 100
		                  ELSE ci.c_uom_weight_id END
WHERE
	ci.c_uom_length_id IN (
		SELECT
			c_uom_id
		FROM
			target_uom
	)
	OR ci.c_uom_time_id IN (
		SELECT
			c_uom_id
		FROM
			target_uom
	)
	OR ci.c_uom_volume_id IN (
		SELECT
			c_uom_id
		FROM
			target_uom
	)
	OR ci.c_uom_weight_id IN (
		SELECT
			c_uom_id
		FROM
			target_uom
	);

-- Step 1: Remove translations for deletable targeted UOMs
WITH target_uom AS (
	SELECT
		c_uom_id
	FROM
		c_uom
	WHERE
		c_uom_uu IN (
		             '015f8f25-216b-4bb0-a4f8-3f19f84d27d4',
		             '8afa898c-1a7e-4b66-b878-694409c720ff',
		             '6678e6da-bed0-4704-acc2-f45a77022130',
		             'a9b9be37-5dfe-436e-a0a7-c7c33a66e4c3',
		             '68535d3f-596a-4400-9f72-ad032ec9e145',
		             'ddba8d0f-26ca-4fe4-8253-a60d0dd22d1b',
		             'c2dbbdb4-433e-47d2-91bc-6e2b00c2644b',
		             'a409bde4-f5c9-4c07-9752-99602fccd687',
		             'e12aed18-09e9-4fd1-ad41-a9d5156b37ee',
		             '648f31ee-4630-4ff5-b6e2-6df0946f4ab4',
		             'f622fe59-cbbd-4835-96b2-bb8eb5b8bf99',
		             'f058dfd3-89f5-46e8-b2b8-11df0505dffa',
		             'c0776c7c-f653-4663-89ed-cb2bf92b6998',
		             '3bb47b84-d840-4037-b1c6-dfb15503e590',
		             'fd31e3a5-714e-41ed-ae67-33c9c075160c',
		             '06edf453-43b0-41f3-9767-1dcc0dba33de'
			)
)
DELETE
FROM
	c_uom_trl t
WHERE
	t.c_uom_id IN (
		SELECT
			tu.c_uom_id
		FROM
			target_uom tu
		WHERE
			tu.c_uom_id != 100
			AND NOT EXISTS (
				SELECT
					1
				FROM
					m_product p
				WHERE
					p.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					c_orderline ol
				WHERE
					ol.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					c_invoiceline il
				WHERE
					il.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					m_inoutline iol
				WHERE
					iol.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT 1 FROM c_uom_conversion c WHERE c.c_uom_id = tu.c_uom_id OR c.c_uom_to_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					ad_clientinfo ci
				WHERE
					ci.c_uom_length_id = tu.c_uom_id
					OR ci.c_uom_time_id = tu.c_uom_id
					OR ci.c_uom_volume_id = tu.c_uom_id
					OR ci.c_uom_weight_id = tu.c_uom_id
			)
	);

-- Step 2: Remove targeted UOM records that are not referenced anywhere
WITH target_uom AS (
	SELECT
		c_uom_id
	FROM
		c_uom
	WHERE
		c_uom_uu IN (
		             '015f8f25-216b-4bb0-a4f8-3f19f84d27d4',
		             '8afa898c-1a7e-4b66-b878-694409c720ff',
		             '6678e6da-bed0-4704-acc2-f45a77022130',
		             'a9b9be37-5dfe-436e-a0a7-c7c33a66e4c3',
		             '68535d3f-596a-4400-9f72-ad032ec9e145',
		             'ddba8d0f-26ca-4fe4-8253-a60d0dd22d1b',
		             'c2dbbdb4-433e-47d2-91bc-6e2b00c2644b',
		             'a409bde4-f5c9-4c07-9752-99602fccd687',
		             'e12aed18-09e9-4fd1-ad41-a9d5156b37ee',
		             '648f31ee-4630-4ff5-b6e2-6df0946f4ab4',
		             'f622fe59-cbbd-4835-96b2-bb8eb5b8bf99',
		             'f058dfd3-89f5-46e8-b2b8-11df0505dffa',
		             'c0776c7c-f653-4663-89ed-cb2bf92b6998',
		             '3bb47b84-d840-4037-b1c6-dfb15503e590',
		             'fd31e3a5-714e-41ed-ae67-33c9c075160c',
		             '06edf453-43b0-41f3-9767-1dcc0dba33de'
			)
)
DELETE
FROM
	c_uom u
WHERE
	u.c_uom_id IN (
		SELECT
			tu.c_uom_id
		FROM
			target_uom tu
		WHERE
			tu.c_uom_id != 100
			AND NOT EXISTS (
				SELECT
					1
				FROM
					m_product p
				WHERE
					p.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					c_orderline ol
				WHERE
					ol.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					c_invoiceline il
				WHERE
					il.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					m_inoutline iol
				WHERE
					iol.c_uom_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT 1 FROM c_uom_conversion c WHERE c.c_uom_id = tu.c_uom_id OR c.c_uom_to_id = tu.c_uom_id
			)
			AND NOT EXISTS (
				SELECT
					1
				FROM
					ad_clientinfo ci
				WHERE
					ci.c_uom_length_id = tu.c_uom_id
					OR ci.c_uom_time_id = tu.c_uom_id
					OR ci.c_uom_volume_id = tu.c_uom_id
					OR ci.c_uom_weight_id = tu.c_uom_id
			)
	);

SELECT
	register_migration('202603111517_GO-3523.sql')
FROM
	dual;
  