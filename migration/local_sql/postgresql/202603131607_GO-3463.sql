-- Set Portuguese (pt_BR) to be a login language
UPDATE ad_language
SET
	isloginlocale    = 'Y',
	IsSystemLanguage = 'Y'
WHERE
	ad_language.ad_language = 'pt_BR';

-- Update any translations that now need to be added
SELECT
	add_missing_translations();

/**********************************************************************************************************/
-- Update all metadata
/**********************************************************************************************************/
-- Document Statuses
UPDATE ad_ref_list_trl
SET
	name = 'Cancelado'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'd35dfd1d-1eb2-46ef-ab2f-23973d68a570'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Desconhecido'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Fechado'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '50702660-bbfc-422a-8acc-5ed3a2dce204'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Rascunho'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'd27f8a6b-e8b5-4fea-a6b2-3e7049c473ec'
	)
	AND ad_language = 'pt_BR';

-- Product Category Types
UPDATE ad_ref_list_trl
SET
	name = 'Produto'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '305558d1-db4a-456f-9c25-057750949060'
	)
	AND ad_language = 'pt_BR';

-- Patient types
UPDATE ad_ref_list_trl
SET
	name = 'Paciente ambulatório'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '0a48b24a-8c67-4067-beb5-4eb3bc7daeb1'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Paciente hospitalizado'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '46d397b3-103d-4663-86b2-27e395dd158d'
	)
	AND ad_language = 'pt_BR';

-- Referrals
UPDATE ad_ref_list_trl
SET
	name = 'Referência da unidade comunitária'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '4274fce2-29b8-4e4f-a58e-dd77ec039f53'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Referência dos estabelecimentos de saúde'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'd8a8e37e-18ff-4445-9469-775eea1408e4'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Referência à unidade comunitária'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'e1d9d266-cefd-4749-94de-20ad020c7d91'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Referência para outro estabelecimento de saúde'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'bffef4a3-34ef-4af3-9cf5-8471bfda5cd7'
	)
	AND ad_language = 'pt_BR';

-- Tender Types
UPDATE ad_ref_list_trl
SET
	name = 'Dinheiro'
WHERE
	ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu IN (
			                   '52c6c5a6-83ce-48c4-b874-721f8cd4e66b',
			                   '917130e3-2144-496c-9344-6cf4f7136293'
				)
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Cheque'
WHERE
	ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu IN (
			                   '900adbf9-5069-4f56-9d97-0313c6372af3',
			                   '056e0d26-2ff4-41c6-bde6-b35d888e555e'
				)
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Cartão de crédito'
WHERE
	ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu IN (
			                   'd3874573-b7bf-4556-9b9c-3644698c959e',
			                   '68dda00d-c015-498e-b91c-811bab809dab'
				)
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Depósito direto'
WHERE
	ad_ref_list_id IN (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu IN (
			                   '220f3864-24b8-42ba-9a91-a247f4697530',
			                   '50bc3b86-6106-44df-88ee-1000243a9fcf'
				)
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Fundos de doadores'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = 'e24511d1-9180-491c-9cc6-354b8a08e1ff'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_ref_list_trl
SET
	name = 'Débito automático'
WHERE
	ad_ref_list_id = (
		SELECT
			ad_ref_list_id
		FROM
			ad_ref_list
		WHERE
			ad_ref_list_uu = '2c5f0a44-1d35-4528-802f-9204e46be31e'
	)
	AND ad_language = 'pt_BR';

/**********************************************************************************************************/
-- From 202206010625_GO-2156: Dashboard window translation
/**********************************************************************************************************/
INSERT INTO
	ad_window_trl (ad_window_id, ad_language, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
	               name, description, help, istranslated, ad_window_trl_uu)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b'
	 ),
	 'pt_BR',
	 0,
	 0,
	 'Y',
	 NOW(),
	 100,
	 NOW(),
	 100,
	 'Painel',
	 'Dashboard for Banda Go Data Visualization',
	 NULL,
	 'Y',
	 'a1b2c3d4-e5f6-4a5b-8c9d-0e1f2a3b4c5d')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- From 202308311144_GO-2747: Vital signs element translations
/**********************************************************************************************************/
UPDATE ad_element_trl
SET
	name      = 'Altura (cm)',
	printname = 'Altura (cm)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = 'a4fc780f-3dc3-4b0c-bb4a-26eea119ff55'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_element_trl
SET
	name      = 'Peso (kg)',
	printname = 'Peso (kg)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '5818719f-2ca4-4204-bb6d-48e27426a30b'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_element_trl
SET
	name      = 'Temperatura (°C)',
	printname = 'Temperatura (°C)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '836e0d1f-b921-4582-8681-a17db1ad19d5'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_element_trl
SET
	name      = 'Pressão arterial (mmHg)',
	printname = 'Pressão arterial (mmHg)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = 'fd932aa2-1856-448c-8d13-e2caa4cc9a18'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_element_trl
SET
	name      = 'Pulso (BPM)',
	printname = 'Pulso (BPM)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '6be46897-4408-4080-afe5-4bdcf199b12e'
	)
	AND ad_language = 'pt_BR';

UPDATE ad_element_trl
SET
	name      = 'Frequência respiratória (RPM)',
	printname = 'Frequência respiratória (RPM)'
WHERE
	ad_element_id = (
		SELECT
			ad_element_id
		FROM
			ad_element
		WHERE
			AD_Element_UU = '46dd8a18-ede7-462d-8f30-85eb56c628f4'
	)
	AND ad_language = 'pt_BR';

/**********************************************************************************************************/
-- Finish
/**********************************************************************************************************/
SELECT
	register_migration_script('202603131607_GO-3463.sql')
FROM
	dual;
