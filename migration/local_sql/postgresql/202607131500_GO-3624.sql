-- GO-3624 payroll engine: BH_Payroll_Run document type + doc-action access.
-- DocBaseType 'BPR' — new value in the standard Document BaseType list (AD_Reference_ID 183).
INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'b7a3f4e2-1c8d-4f5a-9e6b-2d7c8a9f0e1b',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BPR', 'Banda Payroll Run', 183
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'b7a3f4e2-1c8d-4f5a-9e6b-2d7c8a9f0e1b');

-- One C_DocType per client (client 0 row = template copied to future clients by initial client
-- setup; existing clients seeded here). GL_Category: reuse each client's default (payroll posts
-- no GL in v1 but the column is mandatory).
INSERT INTO c_doctype (c_doctype_id, c_doctype_uu, ad_client_id, ad_org_id, isactive, created,
	createdby, updated, updatedby, name, printname, docbasetype, docsubtypeso, isdocnocontrolled,
	docnosequence_id, gl_category_id, isindexed, documentcopies)
SELECT (SELECT MAX(c_doctype_id) FROM c_doctype) + ROW_NUMBER() OVER (ORDER BY c.ad_client_id),
	uuid_generate_v4(), c.ad_client_id, 0, 'Y', getDate(), 100, getDate(), 100,
	'Payroll Run', 'Payroll Run', 'BPR', NULL, 'N', NULL,
	(SELECT MIN(gl_category_id) FROM gl_category g WHERE g.ad_client_id = c.ad_client_id), 'N', 0
FROM ad_client c
WHERE c.isactive = 'Y' AND c.ad_client_id >= 0
	AND NOT EXISTS (SELECT 1 FROM c_doctype d
		WHERE d.ad_client_id = c.ad_client_id AND d.docbasetype = 'BPR');

-- Default doc-action access template rows, consumed by MBandaSetup.handleDocumentActionAccess
-- when new clients are provisioned. NOTE: this DB's BH_Default_DocAction_Access has no
-- AD_Role_ID column — it is keyed by DB_UserType (a value of the "AD_Role User Type" ref-list,
-- unique key: db_usertype, c_doctype_id, ad_ref_list_id), cross-tenant by design (single
-- client-0 template row per user type / doctype / action, regardless of how many real clients
-- exist). 'Clinic Admin' and 'Accounting' are the AD_Role User Type list's own names (looked up
-- below), not the client-0 master roles' literal DB names ('Clinical Admin' / 'Accounting' —
-- see the AD_Document_Action_Access insert below for why that distinction matters).
INSERT INTO bh_default_docaction_access (bh_default_docaction_access_id, bh_default_docaction_access_uu,
	ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	db_usertype, c_doctype_id, ad_ref_list_id)
SELECT (SELECT COALESCE(MAX(bh_default_docaction_access_id), 1000000) FROM bh_default_docaction_access)
		+ ROW_NUMBER() OVER (ORDER BY u.value, a.value),
	uuid_generate_v4(), 0, 0, 'Y', getDate(), 100, getDate(), 100,
	u.value,
	(SELECT c_doctype_id FROM c_doctype WHERE ad_client_id = 0 AND docbasetype = 'BPR'),
	a.ad_ref_list_id
FROM (SELECT value FROM ad_ref_list
	WHERE ad_reference_id = (SELECT ad_reference_id FROM ad_reference WHERE name = 'AD_Role User Type')
		AND name IN ('Clinic Admin', 'Accounting')) u
CROSS JOIN (SELECT ad_ref_list_id, value FROM ad_ref_list
	WHERE ad_reference_id = 135 AND value IN ('CO', 'RE')) a
WHERE NOT EXISTS (SELECT 1 FROM bh_default_docaction_access x
	WHERE x.db_usertype = u.value AND x.ad_ref_list_id = a.ad_ref_list_id
	AND x.c_doctype_id = (SELECT c_doctype_id FROM c_doctype WHERE ad_client_id = 0 AND docbasetype = 'BPR'));

-- Per-client AD_Document_Action_Access for every client role cloned from the two master roles
-- (Clinic Admin master role UU 461b31c5-cae2-449d-8a0c-7385b12f4685, DB name 'Clinical Admin';
-- Accounting master role UU 93365778-a2d9-433b-b962-87fb150db4fa — same pair the foundations
-- migration's window-access grant used). Per-client roles are named '<Client Name> <User Type
-- Name>' (MBandaSetup.getRoleName), e.g. 'GardenWorld Clinic Admin' — that suffix is the AD_Role
-- User Type list's name ('Clinic Admin'/'Accounting'), NOT the client-0 master roles' own DB
-- names, so matching must go through the ref-list name rather than the master roles' literal
-- name. Client 0 (System) is excluded — it holds only the template roles/doctype, not a live
-- transactional client (also no PK column on this table in this schema version — UU-keyed).
INSERT INTO ad_document_action_access (ad_document_action_access_uu, ad_client_id, ad_org_id,
	isactive, created, createdby, updated, updatedby, ad_role_id, c_doctype_id, ad_ref_list_id)
SELECT uuid_generate_v4(), r.ad_client_id, 0, 'Y', getDate(), 100, getDate(), 100,
	r.ad_role_id, d.c_doctype_id, a.ad_ref_list_id
FROM ad_role r
JOIN c_doctype d ON d.ad_client_id = r.ad_client_id AND d.docbasetype = 'BPR'
CROSS JOIN (SELECT ad_ref_list_id FROM ad_ref_list
	WHERE ad_reference_id = 135 AND value IN ('CO', 'RE')) a
WHERE r.isactive = 'Y'
	AND r.ad_client_id > 0
	AND EXISTS (SELECT 1 FROM ad_ref_list u
		WHERE u.ad_reference_id = (SELECT ad_reference_id FROM ad_reference WHERE name = 'AD_Role User Type')
			AND u.name IN ('Clinic Admin', 'Accounting')
			AND r.name LIKE '%' || u.name)
	AND NOT EXISTS (SELECT 1 FROM ad_document_action_access x
		WHERE x.ad_role_id = r.ad_role_id AND x.c_doctype_id = d.c_doctype_id
		AND x.ad_ref_list_id = a.ad_ref_list_id);

SELECT register_migration_script('202607131500_GO-3624.sql') FROM dual;
