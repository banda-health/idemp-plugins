-- Update the report name - old name was A5_Insurance, but it is no longer 
-- A5 and is used both for insurance and patient invoice
UPDATE ad_process
SET
	jasperreport = 'Insurances/VisitInvoice.jasper'
WHERE
	ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412';

-- Add a second parameter, indicating if insurance information should be shown
INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) 
VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2023-12-19 11:23:00.000000', 100, '2023-12-19 11:23:00.000000', 100, 'ShowInsuranceInfo', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '477cdda4-82ff-4bac-834f-08de384df412'), 20, 20, null, null, 'ShowInsuranceInfo', 'N', 0, 'N', 'N', null, null, null, null, null, null, 'U', null, null, 'b5f0a5bb-fa16-43fd-bca6-8fe675165c57', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202312191123_GO-1887.sql')
FROM
	dual;