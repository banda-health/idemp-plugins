/**********************************************************************************************************/
-- Grant CashierRegistrationBasicPlus read/write access to Suppliers window: 565af89e-8f10-4469-84f5-6cca8d7fae27
/**********************************************************************************************************/
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	                  isreadwrite, ad_window_access_uu, bh_candeactivate)
SELECT
	(
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'
	),
	r.ad_role_id,
	0,
	0,
	'Y',
	NOW(),
	100,
	NOW(),
	100,
	'Y',
	uuid_generate_v4(),
	'Y'
FROM
	ad_role r
WHERE
	r.ad_role_uu = 'c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a'
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Add Stock Reconciliation to bh_update_reason reference list (Manage Inventory)
/**********************************************************************************************************/
INSERT INTO
	ad_ref_list (ad_ref_list_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, value,
	             name, description, ad_reference_id, validfrom, validto, entitytype, ad_ref_list_uu, bh_update_existing,
	             bh_add_all)
VALUES
	((
		 SELECT
			 MAX(ad_ref_list_id) + 1
		 FROM
			 ad_ref_list
	 ), 0, 0, 'Y', NOW(), 100, NOW(), 100, 'p_src', 'Stock Reconciliation', NULL,
	 (
		 SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'dcdc79d7-8e55-428f-a8a5-e7a6f562404f'
	 ),
	 NULL, NULL, 'U', 'a8c3e2f1-5b4d-4e9a-8c7f-2d1e3a4b5c6d', NULL, NULL);

/**********************************************************************************************************/
-- Add new voiding reason: Trial Bill (Visits)
/**********************************************************************************************************/
INSERT INTO
	bh_voided_reason (bh_voided_reason_id, bh_voided_reason_uu, ad_client_id, ad_org_id, created, createdby, name,
	                  description, isactive, updated, updatedby, bh_window_id, lineno)
VALUES
	((
		 SELECT
			 MAX(bh_voided_reason_id) + 1
		 FROM
			 bh_voided_reason
	 ), 'b9d4f3e2-6c5e-5f0b-9d8a-3e2f4b5c6d7e', 0, 0, NOW(), 100, 'Trial Bill', NULL, 'Y',
	 NOW(), 100, (
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77'
	 ), 80);

SELECT
	register_migration_script('202603111519_GO-3526.sql')
FROM
	dual;
