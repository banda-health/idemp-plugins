UPDATE ad_column
SET
	ad_reference_id = 36,
	fieldlength     = NULL
WHERE
	ad_column_uu IN ('59199e2a-dd50-425e-91f5-e2b7a45d1a07', 'ac4122ed-781e-4e0b-b81f-cee1bf79f360',
	                 '2059d3ad-3d63-4aef-a531-140d7bbe1567');

INSERT INTO
	t_alter_column
VALUES
	('AD_OrgInfo', 'BH_ExtraInfo', 'TEXT', NULL, NULL);
INSERT INTO
	t_alter_column
VALUES
	('AD_OrgInfo', 'BH_Header', 'TEXT', NULL, NULL);
INSERT INTO
	t_alter_column
VALUES
	('AD_OrgInfo', 'BH_PaymentInformation', 'TEXT', NULL, NULL);

SELECT
	register_migration_script('202505092036_GO-3314.sql')
FROM
	dual;
