-- allow the to be visible in report dropdown
INSERT INTO bh_dbrdbtngrp_btn (bh_dbrdbtngrp_btn_id, ad_client_id, ad_infowindow_id, ad_org_id, ad_window_id, bh_dbrdbtngrp_btn_uu, buttonclassname, buttonhelptext, buttontext, created, createdby, description, iconclassname, isactive, lineno, name, updated, updatedby, bh_dbrdbtngrp_id, ad_process_id, ad_form_id, included_role_id) VALUES ((SELECT MAX(bh_dbrdbtngrp_btn_id) + 1 FROM bh_dbrdbtngrp_btn), 0, null, 0, null, 'f26a13ab-2aef-454a-ad55-7108f94f1d3a', 'button app big', 'shows all my products grouped together', 'Inventory Quantity Report', '2021-11-24 06:45:40.855333', 100, 'BH Inventory Quantity Report', 'fas fa-warehouse', 'Y', 90, 'Inventory Quantity Report', '2021-11-24 06:45:40.855333', 100, (SELECT bh_dbrdbtngrp_id FROM bh_dbrdbtngrp WHERE bh_dbrdbtngrp_uu = '9b44ce0e-3113-4690-ad0b-92b95b34c741'), (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'), null, null) ON CONFLICT DO NOTHING;

-- give access to `inventory quantity report`
UPDATE ad_process_access
SET isreadwrite = 'Y'
WHERE ad_process_id = (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f')
-- [ clinical admin, Inventory/Pharmacy, Lab/Radiology, Accounting ]
AND ad_role_id IN (
    (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'),
    (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'),
    (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'),
    (SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa')
);

-- Include begin and end date params

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2021-11-24 12:36:13.304925', 100, '2021-11-24 12:36:13.304925', 100, 'Begin Date', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'), 10, (SELECT ad_reference_id FROM ad_reference WHERE name = 'Date'), null, null, 'Begin Date', 'N', 36, 'Y', 'N', null, null, null, null, null, null, 'U', null, null, '9788edef-8eab-4a03-afc8-2a5f5ed8fc0d', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

INSERT INTO ad_process_para (ad_process_para_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description, help, ad_process_id, seqno, ad_reference_id, ad_reference_value_id, ad_val_rule_id, columnname, iscentrallymaintained, fieldlength, ismandatory, isrange, defaultvalue, defaultvalue2, vformat, valuemin, valuemax, ad_element_id, entitytype, readonlylogic, displaylogic, ad_process_para_uu, isencrypted, mandatorylogic, placeholder, placeholder2, isautocomplete) VALUES ((SELECT MAX(ad_process_para_id) + 1 FROM ad_process_para), 0, 0, 'Y', '2021-11-24 13:18:58.897483', 100, '2021-11-24 13:18:58.897483', 100, 'End Date', null, null, (SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '93d7c1bc-2885-43f4-985f-90f57a414e5f'), 20, (SELECT ad_reference_id FROM ad_reference WHERE name = 'Date'), null, null, 'End Date', 'N', 36, 'Y', 'N', null, null, null, null, null, null, 'U', null, null, '2955a2c9-94a6-4b5f-88ed-e209c5569c40', 'N', null, null, null, 'N') ON CONFLICT DO NOTHING;

SELECT register_migration_script('202111241703_GO-1850.sql') FROM dual;
