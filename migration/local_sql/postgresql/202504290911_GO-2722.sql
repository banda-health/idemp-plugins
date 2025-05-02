DELETE
FROM
	ad_schedulerrecipient
WHERE
	ad_scheduler_id IN (
		SELECT
			ad_scheduler_id
		FROM
			ad_scheduler
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
					                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
					                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
					                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
					                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
					                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
					                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
					                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
					                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
					                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
			)
	);

DELETE
FROM
	ad_scheduler
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_process_trl
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_process_para
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_process_access
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_pinstance
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

DELETE
FROM
	ad_treenodemm
WHERE
	node_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
					                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
					                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
					                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
					                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
					                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
					                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
					                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
					                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
					                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
			)
	)
	OR parent_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
					                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
					                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
					                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
					                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
					                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
					                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
					                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
					                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
					                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
			)
	);

DELETE
FROM
	ad_package_exp_detail
WHERE
	ad_menu_id IN (
		SELECT
			ad_menu_id
		FROM
			ad_menu
		WHERE
			ad_process_id IN (
				SELECT
					ad_process_id
				FROM
					ad_process
				WHERE
					ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
					                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
					                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
					                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
					                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
					                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
					                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
					                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
					                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
					                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
			)
	);

DELETE
FROM
	ad_menu
WHERE
	ad_process_id IN (
		SELECT
			ad_process_id
		FROM
			ad_process
		WHERE
			ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
			                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
			                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
			                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
			                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
			                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
			                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
			                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
			                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
			                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac')
	);

SELECT
	bh_execute_statement_without_indexes($$
DELETE
FROM
	ad_process
WHERE
	ad_process_uu IN ('db969c7f-36f8-4f35-b9cb-d26528d95034', '6a758dc6-ae90-4175-ad1e-a09b18f58d3c',
	                  'd48c66ff-c448-40fd-ab26-8fceb64f250c', '4e17e285-d44b-4e64-8be9-f6148d48b9b4',
	                  'bf4fcabd-5392-4def-b94b-c3312b99fff4', '51c8e533-d6e6-4851-9018-0aadb0cf9573',
	                  'cfdf35e1-4610-4dbd-a15e-cdbe844c44de', '3e926b47-f4a9-4f49-bdfb-3eaeed9f9a49',
	                  'b2e3cbd1-1f23-449c-beb1-ed898fa77097', 'c5addb0c-b04a-491c-9c41-4ba57a0291f1',
	                  '742dcfb2-4a7f-4bf6-bebf-fca26d309c2b', 'f44e4e3d-6a89-4d92-860b-11089c776031',
	                  '2432a765-acd3-4ba8-9269-4ddfa0b6870a', '27dbc237-256c-4b96-a164-dc9bcd4ad3a7',
	                  '061ed4a0-5670-4764-909e-fb4592f51aaa', 'd42deea6-c650-42b4-a21c-90b3ef0fa99f',
	                  '4416e6ec-4225-4768-95cc-c0c6f399798c', 'a81b8d41-38f9-46ce-8c36-37693be4f6f0',
	                  '7b5e2916-5d4f-4fff-826f-2f3e540aedac');
$$, 'ad_process_id');

-- Now change the report structure for our remaining reports
UPDATE ad_process
SET
	jasperreport = 'Debt Payment Receipt/Debt Payment.jasper'
WHERE
	ad_process_uu = '173a691b-ba89-4987-9216-9b3f0a60c864';
UPDATE ad_process
SET
	jasperreport = 'Bill Invoice/VisitInvoice.jasper'
WHERE
	ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412';
UPDATE ad_process
SET
	jasperreport = 'Income and Expenses/IncomeStatement.jasper'
WHERE
	ad_process_uu = 'f777f042-3907-4293-94c4-49fe6eb58780';
UPDATE ad_process
SET
	jasperreport = 'Open Balance List/OpeningBalanceReport.jasper'
WHERE
	ad_process_uu = 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773';
UPDATE ad_process
SET
	jasperreport = 'Expired Products/Expired Products List.jasper'
WHERE
	ad_process_uu = '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6';
UPDATE ad_process
SET
	jasperreport = 'Inventory Sold/InventorySoldReport.jasper'
WHERE
	ad_process_uu = '1211e173-6f12-4e2f-bfcc-d43d48af51c3';
UPDATE ad_process
SET
	jasperreport = 'Inventory Quantity Report/Inventory Quantity Report.jasper'
WHERE
	ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f';
UPDATE ad_process
SET
	jasperreport = 'Products and Prices/productsAndPrices.jasper'
WHERE
	ad_process_uu = '3edf67b9-ee3d-4b73-a02e-deb1c1811db5';
UPDATE ad_process
SET
	jasperreport = 'Services Charged/ServicesChargedReport.jasper'
WHERE
	ad_process_uu = '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2';
UPDATE ad_process
SET
	jasperreport = 'Diagnosis Report/Diagnosis Report.jasper'
WHERE
	ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f';
UPDATE ad_process
SET
	jasperreport = 'moh-705/705A Main Report.jasper'
WHERE
	ad_process_uu = 'c9f91d23-48ea-4990-af5d-f3e7f0db77de';
UPDATE ad_process
SET
	jasperreport = 'moh-705/705B Main Report.jasper'
WHERE
	ad_process_uu = '432eeb61-1a87-4880-bded-91927139341c';
UPDATE ad_process
SET
	jasperreport = 'moh-717/MoH717.jasper'
WHERE
	ad_process_uu = '742f515a-81c7-4690-8d35-2c6f1252ad5b';
UPDATE ad_process
SET
	jasperreport = 'Prescription Form/PrescriptionForm.jasper'
WHERE
	ad_process_uu = '9fdbe1af-a79c-49ca-8081-0d32de89e053';
UPDATE ad_process
SET
	jasperreport = 'Cashier Transaction Differences/Cashier Difference.jasper'
WHERE
	ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2';
UPDATE ad_process
SET
	jasperreport = 'Cashier Patient Transactions/Cashier Transactions.jasper'
WHERE
	ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1';
UPDATE ad_process
SET
	jasperreport = 'Daily Cashier Collections/Daily Cashier Collections.jasper'
WHERE
	ad_process_uu = 'fb90406f-1ba4-43df-9cec-6844e10c13d9';
UPDATE ad_process
SET
	jasperreport = 'Donor Fund/donorFund1.jasper'
WHERE
	ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607';
UPDATE ad_process
SET
	jasperreport = 'Patient Transactions/Patient Transactions.jasper'
WHERE
	ad_process_uu = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269';
UPDATE ad_process
SET
	jasperreport = 'Non-Patient Payments/Non-Patient-Payments.jasper'
WHERE
	ad_process_uu = '19464274-e2bc-4dbe-ad69-ae48b9f7778c';
UPDATE ad_process
SET
	jasperreport = 'Visit Receipt/Outpatient Thermal Receipt.jasper'
WHERE
	ad_process_uu = '30dd7243-11c1-4584-af26-5d977d117c84';
UPDATE ad_process
SET
	jasperreport = 'Payment Trail/Payment Trail.jasper'
WHERE
	ad_process_uu = 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a';
UPDATE ad_process
SET
	jasperreport = 'Open Balance Invoice/OpenBalanceInvoice.jasper'
WHERE
	ad_process_uu = '199f56a6-8e1f-47b4-8f22-e2bdb8da7505';
UPDATE ad_process
SET
	jasperreport = 'Voided Transactions/voided transactions.jasper'
WHERE
	ad_process_uu = '20a623fb-e127-4c26-98d5-3604a6d100b2';
UPDATE ad_process
SET
	jasperreport = 'Expense Report/Expenses.jasper'
WHERE
	ad_process_uu = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d';
UPDATE ad_process
SET
	jasperreport = 'Lab Report/LabReport.jasper'
WHERE
	ad_process_uu = '1a7175fe-2afe-4404-9c56-58d2fda9bc57';
UPDATE ad_process
SET
	jasperreport = 'OTC Sales/OTCSales.jasper'
WHERE
	ad_process_uu = 'b8508f0a-c66f-4030-a88c-3ae383322ceb';
UPDATE ad_process
SET
	jasperreport = 'Patients Report/PatientReport.jasper'
WHERE
	ad_process_uu = 'feaa97fb-b424-4dce-8790-035ba80ca023';
UPDATE ad_process
SET
	jasperreport = 'Stock Reorder/reorderStock.jasper'
WHERE
	ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545';
UPDATE ad_process
SET
	jasperreport = 'Stock Reorder/reorderStock.jasper'
WHERE
	ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2';
UPDATE ad_process
SET
	jasperreport = 'Changes to Inventory/Stock Reconciliation.jasper'
WHERE
	ad_process_uu = '58ae2bdf-0e80-46f2-860f-2ae070fc82d2';
UPDATE ad_process
SET
	jasperreport = 'Value of Opening Closing Stock/Opening Closing Stock.jasper'
WHERE
	ad_process_uu = '630fc1ab-0b64-459b-b10f-68549d21f507';

SELECT
	register_migration_script('202504290911_GO-2722.sql')
FROM
	dual;
