-- Add reversal access to MMR & PO for inventory/pharmacy
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:23:06.408000', 100, '2023-10-17 23:23:06.408000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = 'beda986d-0bc0-4c58-96ef-b76242046d42'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 184, 'd4ff0180-5282-45f4-bf46-2415f254e884');
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:22:58.276000', 100, '2023-10-17 23:22:58.276000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = 'beda986d-0bc0-4c58-96ef-b76242046d42'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 185, 'ea31538d-ba6a-43fa-8994-5562223d948f');
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:22:47.445000', 100, '2023-10-17 23:22:47.445000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = 'beda986d-0bc0-4c58-96ef-b76242046d42'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 188, '3b37971b-d7db-480c-856e-d10b205b82bf');
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:22:29.605000', 100, '2023-10-17 23:22:29.605000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = '9c729e33-2d30-432a-bda0-741dae05ac69'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 184, '009b0ce7-f223-4887-9cfa-fd8b0e78f341');
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:22:24.036000', 100, '2023-10-17 23:22:24.036000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = '9c729e33-2d30-432a-bda0-741dae05ac69'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 185, '14950e44-c439-44aa-9bc1-bdc97f770691');
INSERT INTO
	ad_document_action_access (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_doctype_id,
	                           ad_role_id, ad_ref_list_id, ad_document_action_access_uu)
VALUES
	(0, 0, 'Y', '2023-10-17 23:22:17.510000', 100, '2023-10-17 23:22:17.510000', 100, (
		SELECT c_doctype_id FROM c_doctype WHERE c_doctype_uu = '9c729e33-2d30-432a-bda0-741dae05ac69'
	), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 188, 'd92934e4-711c-4405-8751-e01626a6ffb2');

SELECT
	register_migration_script('202310172124_GO-2519.sql')
FROM
	dual;
