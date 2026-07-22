-- GO-3624 payroll vocabularies: BH_Category, BH_CalcMethod, and BH_FilingType become
-- dictionary-owned reference lists (same treatment as the audit actions in
-- 202607151300): single source of truth for backend constants (PayrollComponent) and the
-- frontend's retiring payrollComponentCategory/payrollCalcMethod consts + i18n labels.

INSERT INTO ad_reference (ad_reference_id, ad_reference_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name, validationtype, entitytype, isorderbyvalue,
	showinactive)
SELECT (SELECT MAX(ad_reference_id) + 1 FROM ad_reference), 'b62a2c6e-514d-4dfd-acb1-70ed757c5734',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BH_Payroll Component Category', 'L', 'U', 'N', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '352babfb-4207-45c7-8d4d-28cbb9ff7715',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EARNING', 'Earning', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '352babfb-4207-45c7-8d4d-28cbb9ff7715');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '407ec2f9-1b1d-4954-960a-32604f89b642',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYER_CONTRIB', 'Employer contribution', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '407ec2f9-1b1d-4954-960a-32604f89b642');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'da9479e1-7516-45af-becc-824fe11cbde6',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'RELIEF', 'Relief', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'da9479e1-7516-45af-becc-824fe11cbde6');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '8677a447-7376-447a-bb8b-49f1166ce18d',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'STAT_DED', 'Statutory deduction', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '8677a447-7376-447a-bb8b-49f1166ce18d');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'bf58c2a3-dc36-403f-a672-4ee1c3aad8ab',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'VOL_DED', 'Voluntary deduction', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'bf58c2a3-dc36-403f-a672-4ee1c3aad8ab');

INSERT INTO ad_reference (ad_reference_id, ad_reference_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name, validationtype, entitytype, isorderbyvalue,
	showinactive)
SELECT (SELECT MAX(ad_reference_id) + 1 FROM ad_reference), 'ba29e492-f654-4359-80b0-b6c788607fdb',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BH_Payroll Calculation Method', 'L', 'U', 'N', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '881c7c89-224e-4434-ac01-2f8bf77e48f2',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BANDS', 'Tax bands', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '881c7c89-224e-4434-ac01-2f8bf77e48f2');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'd5d50c37-f484-40b9-84c0-79cf451f52e6',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'EMPLOYEE_AMOUNT', 'Employee-set amount', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'd5d50c37-f484-40b9-84c0-79cf451f52e6');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '8ce6d3df-8066-4ebe-a762-5afabb6b7c7c',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'FIXED', 'Fixed amount', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '8ce6d3df-8066-4ebe-a762-5afabb6b7c7c');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'ed7c2160-fd41-4696-934c-fbd396017604',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'PERCENT_OF_GROSS', 'Percent of gross', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'ed7c2160-fd41-4696-934c-fbd396017604');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'f8aba323-fb69-4d2e-a6ee-b3906786ddda',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'TIERED', 'Tiered table', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'f8aba323-fb69-4d2e-a6ee-b3906786ddda');

INSERT INTO ad_reference (ad_reference_id, ad_reference_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, name, validationtype, entitytype, isorderbyvalue,
	showinactive)
SELECT (SELECT MAX(ad_reference_id) + 1 FROM ad_reference), '6267a085-e83d-499f-b3a1-d0eea93c35a4',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'BH_Payroll Filing Type', 'L', 'U', 'N', 'N'
WHERE NOT EXISTS (SELECT 1 FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'fb4557a8-75a8-4dcd-9bb8-7645320ea424',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'PAYE', 'PAYE', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'fb4557a8-75a8-4dcd-9bb8-7645320ea424');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '03d58984-e15b-41f9-a2b3-905bca542fae',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'NSSF', 'NSSF', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '03d58984-e15b-41f9-a2b3-905bca542fae');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '7088b5eb-8432-4a7c-bae5-069ceffa4d39',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'SHIF', 'SHIF', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '7088b5eb-8432-4a7c-bae5-069ceffa4d39');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), '1c50b604-d02c-43d7-91e3-49604edff8ba',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'HLEVY', 'Housing Levy', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = '1c50b604-d02c-43d7-91e3-49604edff8ba');

INSERT INTO ad_ref_list (ad_ref_list_id, ad_ref_list_uu, ad_client_id, ad_org_id, isactive,
	created, createdby, updated, updatedby, value, name, entitytype, ad_reference_id)
SELECT (SELECT MAX(ad_ref_list_id) + 1 FROM ad_ref_list), 'c3606182-dd5e-4d5f-8b35-0ce7eeeee912',
	0, 0, 'Y', getDate(), 100, getDate(), 100, 'NITA', 'NITA', 'U',
	(SELECT ad_reference_id FROM ad_reference WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4')
WHERE NOT EXISTS (SELECT 1 FROM ad_ref_list WHERE ad_ref_list_uu = 'c3606182-dd5e-4d5f-8b35-0ce7eeeee912');

-- Point the columns at their lists (17 = List). Plain UPDATEs are idempotent.
-- BH_Payroll_Component.BH_Category
UPDATE ad_column
SET ad_reference_id = 17,
	ad_reference_value_id = (SELECT ad_reference_id FROM ad_reference
		WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734'),
	updated = getDate()
WHERE ad_column_uu = '2ef71ba8-a79a-4e92-9716-c4c6724b5d17';

-- BH_Payroll_Component.BH_CalcMethod
UPDATE ad_column
SET ad_reference_id = 17,
	ad_reference_value_id = (SELECT ad_reference_id FROM ad_reference
		WHERE ad_reference_uu = 'ba29e492-f654-4359-80b0-b6c788607fdb'),
	updated = getDate()
WHERE ad_column_uu = '82c80165-d73e-4f26-a335-e43bde135f57';

-- BH_Payroll_Run_Line_Item.BH_Category
UPDATE ad_column
SET ad_reference_id = 17,
	ad_reference_value_id = (SELECT ad_reference_id FROM ad_reference
		WHERE ad_reference_uu = 'b62a2c6e-514d-4dfd-acb1-70ed757c5734'),
	updated = getDate()
WHERE ad_column_uu = 'b38b39f1-2694-4350-8143-6efa62f168a0';

-- BH_Payroll_Filing.BH_FilingType
UPDATE ad_column
SET ad_reference_id = 17,
	ad_reference_value_id = (SELECT ad_reference_id FROM ad_reference
		WHERE ad_reference_uu = '6267a085-e83d-499f-b3a1-d0eea93c35a4'),
	updated = getDate()
WHERE ad_column_uu = '9cd4081d-2b7c-4fe8-855e-9aa49359b4d6';

SELECT register_migration_script('202607151900_GO-3624.sql') FROM dual;
