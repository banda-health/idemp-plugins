-- This is running 202302240607_GO-2633.sql for new clients
-- Delete the duplicate records that aren't the most recent
DELETE
FROM
	m_storageonhand soh
	USING (
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id,
			MAX(datematerialpolicy) AS datematerialpolicy
		FROM
			m_storageonhand
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
		HAVING
			COUNT(*) > 1
	) dups
WHERE
	soh.datematerialpolicy != dups.datematerialpolicy
	AND soh.m_product_id = dups.m_product_id
	AND soh.m_locator_id = dups.m_locator_id
	AND soh.m_attributesetinstance_id = dups.m_attributesetinstance_id;

-- Re-calculate inventory based on what's in m_transaction for certain clients (duplicating 202302091301_GO-2589.sql)
UPDATE m_storageonhand soh
SET
	qtyonhand = sums.qtyonhand
FROM
	(
		SELECT
			m_product_id,
			m_locator_id,
			m_attributesetinstance_id,
			SUM(movementqty) AS qtyonhand
		FROM
			m_transaction
		WHERE
				ad_client_id IN (
				SELECT
					ad_client_id
				FROM
					ad_client
				WHERE
						ad_client_uu IN ('4b87f641-a084-4acd-a9dc-770a9074b304', 'd0e4ad55-f37b-4dc3-a31a-2dfb0aed6ac1',
						                 '9c1438d5-84bf-4673-947f-e047da2bf78d', '39e16b5f-1f5d-4a2d-b639-b8babaf7ade1',
						                 '10f8cc08-42ce-49c4-bd4b-51a41100eedc', 'fdca9edb-619a-4979-92f3-6998a094ef41',
						                 'a3ad8674-4a4c-45c6-a215-d9ad7c7c26a1', 'e2d5b452-f1b4-46d8-a198-742c5788b1a1',
						                 'b6167c32-491d-4e9f-80fa-6a8e22bbee96', 'e4143b15-daa2-4d48-9138-6dd1514eba51',
						                 'd1b21277-8b17-4c6e-b10e-e2e308bf8ee0', '925ea941-be79-4c42-be95-6965b922a843',
						                 'e2b9928d-6b3b-4a71-ae5f-ef612b73cd42', 'd0c96146-348f-49d6-a4a4-97bccaa0afd2',
						                 'bdd35ee1-6c72-4567-b845-0b9f62ae4d5a', 'ad631325-0acc-4ada-8fc4-f82593fc3d03',
						                 '13a55dcb-48b8-4613-b8fd-50bf8bd35add', '495dbedd-338b-4110-aa8c-8fc7641843cd',
						                 'b89bdd6f-4f36-4b11-9004-5264d80a9de3', '7e20a0ab-9b21-4d10-9567-a62241f0bb31',
						                 '197e5110-2319-4248-8a96-288c075a11c7', 'd9e7338c-c375-47e9-89b6-833bb457281c',
						                 '0ab03a84-874d-426f-9c20-24f0840476b0', 'bdfcc85a-05f6-4b70-aa1f-c40228c65a36',
						                 '5da980a6-ff35-4ede-bd69-5c000da605b9', '32fedf51-a4b8-4042-9454-f0176486d366',
						                 '9391e7f3-f8c5-4e42-9b61-907b9a727a6f', 'd17695e3-57f5-4af6-be41-cf0528725c40',
						                 'b3a6863b-e422-4a53-9ee3-197950e991b8', '4334212e-5d70-4852-9823-9ad1e19d5ff8',
						                 'c7cd7604-4566-4d11-ace5-09e9c5957305', '8b389cc5-53a8-47dd-a793-d8e21f5e7b41',
						                 'd9924727-c521-4acb-b9a3-5464f092ba73', '85d903f0-30f4-40a6-903f-4616a1a47bb4',
						                 '3c1030b4-a0b6-48c6-8dcd-809edb424f90', 'd4d31152-5a60-4b39-8038-e3bf3347fbe7',
						                 '5be0a9f8-735e-499b-bf5a-66593b0ea489', '031e9e3e-0833-4080-abf6-ed166e087c0c',
						                 '895d0f5e-6b67-4f4f-8ac0-c3a180c58539', 'a6c14a45-b3c4-48cf-8a11-c89623f324e6',
						                 '4bfbba7f-d386-4f0c-8eac-ad508c192046', '5ac818fb-4264-4ef6-aeee-953ccbfd7898',
						                 '7ce0c92b-7aaa-4e0c-9813-985c7e8a28bc', '631ad056-2961-4c0a-bb1f-9695ca2535d4',
						                 'ada4df74-c27d-43ca-9d8f-b0b4e131cb79', '75983ae6-2ca1-4569-984f-06bbecfe44ec',
						                 '337917bb-6ecf-4ae3-baf1-c01517e38c73', '994e74ec-2f82-4bb7-b881-938b62ae135b',
						                 '47348503-2513-4ea6-ad5e-3f59212f8dfd', '7da262d8-5c80-4749-833f-07ed65677e20',
						                 'a2cd94ae-ca5f-41a5-8523-dd17c2ae54ae', 'cb964986-59bc-4a2e-824e-e25f1341b407',
						                 '887d2fef-b071-4d1d-bee7-95047507c133', '5a7b8349-4338-4e7d-b0ed-9598f9288901',
						                 'b60d2e85-7a13-4564-830c-f349d4c03721', '289444de-1eba-4f28-b7d9-1c3a701815b0')
			)
		GROUP BY m_product_id, m_locator_id, m_attributesetinstance_id
	) sums
WHERE
	soh.m_product_id = sums.m_product_id
	AND soh.m_attributesetinstance_id = sums.m_attributesetinstance_id
	AND soh.qtyonhand != sums.qtyonhand
	AND soh.m_locator_id = sums.m_locator_id;

SELECT
	register_migration_script('202303090831_GO-2633.sql')
FROM
	dual;
