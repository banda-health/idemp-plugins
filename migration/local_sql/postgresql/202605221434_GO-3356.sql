-- Issue: GO-3356 - Seed family planning feature flags and system-administrator targeting rules
-- Solution: Insert catalog entries and rules that enable each flag only for system administrators

INSERT INTO
	bh_feature_flag (ad_client_id, ad_org_id, bh_defaultenabled, bh_feature_flag_id, bh_feature_flag_uu, bh_flagtype,
	                 created, createdby, description, isactive, name, updated, updatedby)
VALUES
	(0, 0, 'N', (
		 SELECT COALESCE(MAX(bh_feature_flag_id), 0) + 1 FROM bh_feature_flag
	 ), '01f69501-0d6f-4532-96eb-7e12d0f9f7bc', 'release', '2026-05-21 16:45:16.999', 100, NULL, 'Y',
	 'familyPlanningA', '2026-05-21 16:45:16.999', 100);

INSERT INTO
	bh_feature_flag (ad_client_id, ad_org_id, bh_defaultenabled, bh_feature_flag_id, bh_feature_flag_uu, bh_flagtype,
	                 created, createdby, description, isactive, name, updated, updatedby)
VALUES
	(0, 0, 'N', (
		 SELECT COALESCE(MAX(bh_feature_flag_id), 0) + 1 FROM bh_feature_flag
	 ), 'cc79c4e6-66af-4868-b063-ac040f693762', 'release', '2026-05-22 14:03:43.046', 100, NULL, 'Y',
	 'familyPlanningB', '2026-05-22 14:03:43.046', 100);

INSERT INTO
	bh_feature_flag_rule (ad_client_id, ad_org_id, bh_environment, bh_feature_flag_id, bh_feature_flag_rule_id,
	                      bh_feature_flag_rule_uu, bh_isenabled, bh_rule_client_id, bh_rule_org_id, bh_rule_role_id,
	                      bh_rule_user_id, created, createdby, description, isactive, name, seqno, updated, updatedby,
	                      validfrom, validto, bh_systemadmin)
VALUES
	(0, 0, NULL, (
		 SELECT bh_feature_flag_id FROM bh_feature_flag WHERE name = 'familyPlanningA'
	 ), (
		 SELECT COALESCE(MAX(bh_feature_flag_rule_id), 0) + 1 FROM bh_feature_flag_rule
	 ), '3d1b6c0e-3325-4583-a9f3-0e742567d62a', 'Y', NULL, NULL, NULL, NULL, '2026-05-22 14:03:35.561', 100, NULL,
	 'Y', NULL, 0, '2026-05-22 14:03:35.561', 100, NULL, NULL, 'Y');

INSERT INTO
	bh_feature_flag_rule (ad_client_id, ad_org_id, bh_environment, bh_feature_flag_id, bh_feature_flag_rule_id,
	                      bh_feature_flag_rule_uu, bh_isenabled, bh_rule_client_id, bh_rule_org_id, bh_rule_role_id,
	                      bh_rule_user_id, created, createdby, description, isactive, name, seqno, updated, updatedby,
	                      validfrom, validto, bh_systemadmin)
VALUES
	(0, 0, NULL, (
		 SELECT bh_feature_flag_id FROM bh_feature_flag WHERE name = 'familyPlanningB'
	 ), (
		 SELECT COALESCE(MAX(bh_feature_flag_rule_id), 0) + 1 FROM bh_feature_flag_rule
	 ), '2d2c30ba-20c0-44f1-8734-84ac2821d8b8', 'Y', NULL, NULL, NULL, NULL, '2026-05-22 14:03:49.017', 100, NULL,
	 'Y', NULL, 0, '2026-05-22 14:03:49.017', 100, NULL, NULL, 'Y');

-- Finishing Up
SELECT
	register_migration_script('202605221434_GO-3356.sql')
FROM
	dual;
