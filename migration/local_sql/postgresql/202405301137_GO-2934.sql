-- Insert 'Banda Health' field group
INSERT INTO
	ad_fieldgroup (ad_fieldgroup_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	               entitytype, fieldgrouptype, iscollapsedbydefault, ad_fieldgroup_uu, bh_abbreviation)
VALUES
	((
		 SELECT MAX(ad_fieldgroup_id) + 1
		 FROM ad_fieldgroup
	 ), 0, 0, 'Y', '2024-05-30 14:30:34.886000', 100, '2024-05-30 14:30:34.886000', 100, 'Banda Health', 'U', 'C', 'Y',
	 '54ab2ded-4ea6-49c1-9f8f-16946555b55c', NULL)
ON CONFLICT DO NOTHING;

-- Add the Gender field
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2024-05-30 14:32:19.215000', 100, '2024-05-30 14:32:19.215000', 100, 'Gender', NULL, NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '19844f09-cdd5-44bf-b004-e998ca578420'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '3b89824b-9b81-4868-baa5-a6a382967405'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '54ab2ded-4ea6-49c1-9f8f-16946555b55c'
	 ), 'Y', NULL, 20, 'N', 630, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'bf6193ca-2064-499d-9436-6f04eb77bd36', NULL, 360, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL)
ON CONFLICT DO NOTHING;
-- Add the Birthday field
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2024-05-30 14:32:19.215000', 100, '2024-05-30 14:32:19.215000', 100, 'Birthday',
	 'Birthday or Anniversary day', 'Birthday or Anniversary day', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '19844f09-cdd5-44bf-b004-e998ca578420'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '1ad15a89-3587-4963-8e21-838d5860e577'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '54ab2ded-4ea6-49c1-9f8f-16946555b55c'
	 ), 'Y', NULL, 20, 'N', 640, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '16d1d6e0-4ac0-429e-a834-1b316d582a2c', NULL, 370, 'Y', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL)
ON CONFLICT DO NOTHING;
-- Add the Local Patient ID field
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2024-05-30 14:32:19.215000', 100, '2024-05-30 14:32:19.215000', 100, 'Local Patient ID',
	 'Local Patient ID', NULL, 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '19844f09-cdd5-44bf-b004-e998ca578420'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = 'cc647f24-9617-4c1b-9698-f78dc75cf9bd'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '54ab2ded-4ea6-49c1-9f8f-16946555b55c'
	 ), 'Y', NULL, 20, 'N', 650, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 'e481bab7-c417-4087-b389-db47922c9d2b', NULL, 380, 'Y', 1, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL)
ON CONFLICT DO NOTHING;
-- Add the Phone field
INSERT INTO
	ad_field (ad_field_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, iscentrallymaintained, ad_tab_id, ad_column_id, ad_fieldgroup_id, isdisplayed, displaylogic,
	          displaylength, isreadonly, seqno, sortno, issameline, isheading, isfieldonly, isencrypted, entitytype,
	          obscuretype, ad_reference_id, ismandatory, included_tab_id, defaultvalue, ad_reference_value_id,
	          ad_val_rule_id, infofactoryclass, ad_field_uu, isallowcopy, seqnogrid, isdisplayedgrid, xposition, numlines,
	          columnspan, isquickentry, isupdateable, isalwaysupdateable, mandatorylogic, readonlylogic, istoolbarbutton,
	          isadvancedfield, isdefaultfocus, vformat, ad_labelstyle_id, ad_fieldstyle_id, placeholder, isquickform,
	          bh_abbreviation)
VALUES
	((
		 SELECT MAX(ad_field_id) + 1
		 FROM ad_field
	 ), 0, 0, 'Y', '2024-05-30 14:32:19.215000', 100, '2024-05-30 14:32:19.215000', 100, 'Phone',
	 'Identifies a telephone number', 'The Phone field identifies a telephone number', 'Y', (
		 SELECT ad_tab_id FROM ad_tab WHERE ad_tab_uu = '19844f09-cdd5-44bf-b004-e998ca578420'
	 ), (
		 SELECT ad_column_id FROM ad_column WHERE ad_column_uu = '56c39b39-4d74-4c6b-a05c-c8c747d0fb76'
	 ), (
		 SELECT ad_fieldgroup_id FROM ad_fieldgroup WHERE ad_fieldgroup_uu = '54ab2ded-4ea6-49c1-9f8f-16946555b55c'
	 ), 'Y', NULL, 20, 'N', 660, NULL, 'N', 'N', 'N', 'N', 'U', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
	 '1309a54f-6d51-41ae-ac9b-36f0ba0a7399', NULL, 390, 'N', 4, 1, 2, 'N', NULL, NULL, NULL, NULL, NULL, 'N', 'N', NULL,
	 NULL, NULL, NULL, 'N', NULL)
ON CONFLICT DO NOTHING;

SELECT
	register_migration_script('202405301137_GO-2934.sql')
FROM
	dual;
