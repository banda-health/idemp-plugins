-- GO-3624 payroll audit: BH_ActionType becomes a dictionary-owned reference list.
-- The audit vocabulary was split between backend literals (PERIOD_LOCK/PERIOD_UNLOCK in
-- MBHPayrollRun) and frontend-submitted events (greenlight payrollActionType); this list is the
-- single source of truth both sides read. MBHPayrollAudit.beforeSave enforces membership (core PO
-- does not validate list values on save).
INSERT INTO ad_reference (ad_reference_id, ad_reference_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name, validationtype, entitytype, isorderbyvalue,
	showinactive)
SELECT (SELECT MAX(ad_reference_id) + 1 FROM ad_reference), '585d06a8-a4b5-4fd6-8991-55a11653c15d',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BH_Payroll Audit Action', 'L', 'U', 'N', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'eae528e0-0848-43bf-92eb-0cf452865877',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'PERIOD_LOCK', 'Period locked', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'eae528e0-0848-43bf-92eb-0cf452865877');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '541fa9d9-5bb0-402b-9364-7196b6c9ef9c',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'PERIOD_UNLOCK', 'Period unlocked', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '541fa9d9-5bb0-402b-9364-7196b6c9ef9c');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '91a02eec-0df1-436b-b080-b7c5811eca29',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'COMPONENT_CHANGE', 'Component changed', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '91a02eec-0df1-436b-b080-b7c5811eca29');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '68aea2ae-9fce-434c-9a76-124dccd51b7c',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYEE_ADD', 'Employee added', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '68aea2ae-9fce-434c-9a76-124dccd51b7c');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '8e160eb1-e2ad-40ab-8677-ccb227522931',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYEE_EDIT', 'Employee edited', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '8e160eb1-e2ad-40ab-8677-ccb227522931');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '9c3b07a9-e5ce-42de-89a0-dc260ca52a98',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYEE_DEACTIVATE', 'Employee deactivated', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '9c3b07a9-e5ce-42de-89a0-dc260ca52a98');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '1cd1726d-28cc-4320-920b-1e6de1d48cb4',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYEE_REACTIVATE', 'Employee reactivated', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '1cd1726d-28cc-4320-920b-1e6de1d48cb4');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '60484350-7c2e-45f7-b087-67f510ab7e3d',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'FILING_PAID', 'Filing paid', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '60484350-7c2e-45f7-b087-67f510ab7e3d');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '0d28ac84-9cc5-41a8-85a4-e30cbee5740b',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'FILING_REVERSED', 'Filing payment reversed', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '0d28ac84-9cc5-41a8-85a4-e30cbee5740b');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '296c4b6f-10cf-47b1-8379-ccda9b2a448e',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'SETTINGS_CHANGE', 'Settings changed', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '296c4b6f-10cf-47b1-8379-ccda9b2a448e');

-- Point the audit column at the list (17 = List). Plain UPDATE is idempotent.
UPDATE ad_column
SET ad_reference_id = 17,
	ad_reference_value_id = (SELECT ad_reference_id FROM ad_reference
		WHERE ad_reference_uu = '585d06a8-a4b5-4fd6-8991-55a11653c15d'),
	updated = getDate()
WHERE ad_column_uu = 'd8b4e7e2-67a1-48bc-ad5c-24be8f794c6c';

SELECT register_migration_script('202607151300_GO-3624.sql') FROM dual;
