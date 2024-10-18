-- Add a foreign key from the concept extra to the concept mapping table
ALTER TABLE bh_concept_extra
	ADD CONSTRAINT bhconceptmapping_bhconceptmapp FOREIGN KEY (bh_concept_mapping_id) REFERENCES bh_concept_mapping (bh_concept_mapping_id);

-- We have a duplicate diagnosis, so remove it and make sure the other one gets updated (the external IDs, which
-- we had set to the UU field, was updated)
DELETE
FROM
	bh_coded_diagnosis_mapping
WHERE
	bh_coded_diagnosis_id = (
		SELECT
			bh_coded_diagnosis_id
		FROM
			bh_coded_diagnosis
		WHERE
			bh_coded_diagnosis_uu = 'aea06b82-d5d2-4571-9033-1a52d464c118'
	);
DELETE
FROM
	bh_coded_diagnosis
WHERE
	bh_coded_diagnosis_uu = 'aea06b82-d5d2-4571-9033-1a52d464c118';

UPDATE bh_coded_diagnosis
SET
	bh_coded_diagnosis_uu = 'aea06b82-d5d2-4571-9033-1a52d464c118'
WHERE
	bh_coded_diagnosis_uu = 'aea06b82-d5d2-4571-9033-1a52d464c117';

-- Remove the coded diagnosis concepts from the table to be synced after UUs have been set
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_source = 'BHGO'
			OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_source = 'BHGO'
			OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
	);
DELETE
FROM
	bh_ocl_originating_source
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_source = 'BHGO'
			OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IN (
		SELECT
			bh_concept_mapping.bh_concept_mapping_id
		FROM
			bh_concept_mapping
		WHERE
			bh_concept_id IN (
				SELECT
					bh_concept_id
				FROM
					bh_concept
				WHERE
					bh_source = 'BHGO'
					OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
			)
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_source = 'BHGO'
			OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	to_bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_source = 'BHGO'
			OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL')
	);
DELETE
FROM
	bh_concept
WHERE
	bh_source = 'BHGO'
	OR (bh_concept_class = 'Diagnosis' AND bh_source = 'CIEL');

-- Remove a duplicated concept from the first-ever sync we did
SELECT
	bh_concept_id
INTO TEMP TABLE
	tmp_bh_concept_to_remove
FROM
	(
		SELECT
			bh_concept_id,
			ROW_NUMBER() OVER (ORDER BY created) AS row_num
		FROM
			bh_concept
		WHERE
			bh_oclid = '22568-0'
			AND bh_source = 'LOINC'
	) t
WHERE
	row_num != 1;
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_ocl_originating_source
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_concept
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);

-- There are a few concepts that don't have any mappings, so we'll remove those (and let them be added by a sync,
-- if they should be in there)
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_concept_id NOT IN (
				SELECT
					bh_concept_id
				FROM
					bh_concept_mapping
			)
			AND bh_concept_id NOT IN (
				SELECT to_bh_concept_id FROM bh_concept_mapping WHERE to_bh_concept_id IS NOT NULL
			)
			AND bh_concept_id NOT IN (
				SELECT bh_concept_id FROM bh_encounter_diagnostic WHERE bh_concept_id IS NOT NULL
			)
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_concept_id NOT IN (
				SELECT
					bh_concept_id
				FROM
					bh_concept_mapping
			)
			AND bh_concept_id NOT IN (
				SELECT to_bh_concept_id FROM bh_concept_mapping WHERE to_bh_concept_id IS NOT NULL
			)
			AND bh_concept_id NOT IN (
				SELECT bh_concept_id FROM bh_encounter_diagnostic WHERE bh_concept_id IS NOT NULL
			)
	);
DELETE
FROM
	bh_ocl_originating_source
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept
		WHERE
			bh_concept_id NOT IN (
				SELECT
					bh_concept_id
				FROM
					bh_concept_mapping
			)
			AND bh_concept_id NOT IN (
				SELECT to_bh_concept_id FROM bh_concept_mapping WHERE to_bh_concept_id IS NOT NULL
			)
			AND bh_concept_id NOT IN (
				SELECT bh_concept_id FROM bh_encounter_diagnostic WHERE bh_concept_id IS NOT NULL
			)
	);
DELETE
FROM
	bh_concept
WHERE
	bh_concept_id NOT IN (
		SELECT
			bh_concept_id
		FROM
			bh_concept_mapping
	)
	AND bh_concept_id NOT IN (
		SELECT to_bh_concept_id FROM bh_concept_mapping WHERE to_bh_concept_id IS NOT NULL
	)
	AND bh_concept_id NOT IN (
		SELECT bh_concept_id FROM bh_encounter_diagnostic WHERE bh_concept_id IS NOT NULL
	);

-- Then there are some remaining concepts that just need to be dealt with (i.e. removed) because they won't
-- get an OCL UU on sync (meaning they probably shouldn't be in the table to begin with
DROP TABLE IF EXISTS tmp_bh_concept_to_remove;
SELECT
	bh_concept_id
INTO TEMP TABLE
	tmp_bh_concept_to_remove
FROM
	bh_concept
WHERE
	url IN ('/orgs/WHO/sources/ICD-10-WHO/concepts/N94.3/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N46/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/E55.0/', '/orgs/Regenstrief/sources/LOINC/concepts/LP7567-3/',
	        '/orgs/Regenstrief/sources/LOINC/concepts/32018-4/', '/orgs/Regenstrief/sources/LOINC/concepts/22314-9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R82.9/', '/orgs/Regenstrief/sources/LOINC/concepts/10715-1/',
	        '/orgs/Regenstrief/sources/LOINC/concepts/LA19296-5/', '/orgs/Regenstrief/sources/LOINC/concepts/LA19297-3/',
	        '/orgs/Regenstrief/sources/LOINC/concepts/LA6577-6/', '/orgs/Regenstrief/sources/LOINC/concepts/LP7690-3/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/D16.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N05.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/D72.8/', '/orgs/CIEL/sources/CIEL/concepts/162907/',
	        '/orgs/CIEL/sources/CIEL/concepts/161706/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L53.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/E14.1/', '/orgs/CIEL/sources/CIEL/concepts/1289/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N92.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K52.8/',
	        '/orgs/CIEL/sources/CIEL/concepts/6022/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R62.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B45.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N64.5/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B54/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A04.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A02.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N12/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A06.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N92.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K05.6/', '/orgs/WHO/sources/ICD-10-WHO/concepts/H44.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/I09.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A08.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A41.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N39.0/',
	        '/orgs/CIEL/sources/CIEL/concepts/1066/', '/orgs/CIEL/sources/CIEL/concepts/1065/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T14.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/T14.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A23.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/J46/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/J44.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/D64.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/J98.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N34.3/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T78.4/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B37.3/',
	        '/orgs/CIEL/sources/CIEL/concepts/160446/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O23.4/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A09.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/I10/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z39.2/', '/orgs/WHO/sources/ICD-10-WHO/concepts/F44.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/G62.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/I64/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/E86/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R04.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B82.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/G44.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O21.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B53.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/L08.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/H66.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T14.6/', '/orgs/WHO/sources/ICD-10-WHO/concepts/M25.5/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/M79.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/M72.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/H10.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B37.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/M71.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/M79.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T79.3/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R10.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N25.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/M13.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z27.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L03.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/M62.4/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K08.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K04.7/', '/orgs/WHO/sources/ICD-10-WHO/concepts/H92.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/I95.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B96.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R60.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/J98.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K13.7/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K30/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R10.4/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L60.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N30.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A15.0/',
	        '/orgs/CIEL/sources/CIEL/concepts/164413/', '/orgs/Regenstrief/sources/LOINC/concepts/10701-1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T30.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L30.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z34.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B50.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/I83.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/S52.5/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/H10.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/J11.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R58/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B36.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K00.3/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z32.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N93.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O72.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N45.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z01.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z00.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/E66.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/H02.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A53.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/M46.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R57.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K52.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A82.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A20.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z73.6/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/D48.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/H20.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/S05.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R09.0/',
	        '/orgs/CIEL/sources/CIEL/concepts/164971/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A63.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N50.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N94.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R50.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A18.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/G96.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/M89.9/',
	        '/orgs/CIEL/sources/CIEL/concepts/5018/', '/orgs/WHO/sources/ICD-10-WHO/concepts/U07.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/U07.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/G40.3/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B07/', '/orgs/CIEL/sources/CIEL/concepts/78/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A56.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z13.6/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F84.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/J45.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/X59.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N82.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z48.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z41.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Z11.4/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R69/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B88.1/', '/orgs/CIEL/sources/CIEL/concepts/164161/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N47/', '/orgs/CIEL/sources/CIEL/concepts/162595/',
	        '/orgs/CIEL/sources/CIEL/concepts/162194/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z37.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O84.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O67.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R39.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O80.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/E46/', '/orgs/WHO/sources/ICD-10-WHO/concepts/F19.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F09/', '/orgs/WHO/sources/ICD-10-WHO/concepts/F45.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F43.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A80.3/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R16.2/', '/orgs/WHO/sources/ICD-10-WHO/concepts/S30.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/S60.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/S70.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K59.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K31.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B23.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B23.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O98.6/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K03.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F10.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R62.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O99.5/', '/orgs/WHO/sources/ICD-10-WHO/concepts/J18.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T63.4/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K08.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/L02.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K72.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K04.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/C20/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B56.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N48.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N89.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/W55/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R53/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A09.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/L01.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L21.1/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/L60.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R59.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/R21/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N61/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/A03.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R98/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N76.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R11/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/Y09/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K81.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/K73.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L97/',
	        '/orgs/CIEL/sources/CIEL/concepts/5622/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O86.8/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O16/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O91.2/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/N83.2/', '/orgs/WHO/sources/ICD-10-WHO/concepts/B76.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B76.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/G90.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F19.1/', '/orgs/WHO/sources/ICD-10-WHO/concepts/O05.4/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/B65.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N15.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T14.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/G47.0/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/J04.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/A30.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/F79.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/E88.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/I89.8/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K05.3/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O73.0/', '/orgs/WHO/sources/ICD-10-WHO/concepts/I00/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/P36.9/', '/orgs/WHO/sources/ICD-10-WHO/concepts/N20.9/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/L98.0/', '/orgs/CIEL/sources/CIEL/concepts/5483/',
	        '/orgs/CIEL/sources/CIEL/concepts/5011/', '/orgs/WHO/sources/ICD-10-WHO/concepts/K11.2/',
	        '/orgs/CIEL/sources/CIEL/concepts/1429/', '/orgs/WHO/sources/ICD-10-WHO/concepts/I80.2/',
	        '/orgs/CIEL/sources/CIEL/concepts/879/', '/orgs/WHO/sources/ICD-10-WHO/concepts/L29.9/',
	        '/orgs/CIEL/sources/CIEL/concepts/840/', '/orgs/WHO/sources/ICD-10-WHO/concepts/R31/',
	        '/orgs/CIEL/sources/CIEL/concepts/822/', '/orgs/WHO/sources/ICD-10-WHO/concepts/Z20.6/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/T14.8/', '/orgs/CIEL/sources/CIEL/concepts/48/',
	        '/orgs/WHO/sources/ICD-10-WHO/concepts/O03.9/', '/orgs/Regenstrief/sources/LOINC/concepts/LA12901-7/');
DELETE
FROM
	bh_concept_name
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_ocl_originating_source
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);
DELETE
FROM
	bh_concept
WHERE
	bh_concept_id IN (
		SELECT
			bh_concept_id
		FROM
			tmp_bh_concept_to_remove
	);

-- Delete concept mappings that will never have their UUIDs updated
SELECT
	bh_concept_mapping_id
INTO TEMP TABLE
	tmp_bh_concept_mapping
FROM
	bh_concept_mapping
WHERE
	(bh_oclid = '106' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '107' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '108' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '109' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '111' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2955877' AND bh_owner = 'CIEL')
	OR (bh_oclid = '98' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '99' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '97' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '101' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '103' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '80' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '82' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '288905' AND bh_owner = 'CIEL')
	OR (bh_oclid = '74' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '75' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '76' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '77' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '78' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '104' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '105' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '79' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '84' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '85' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '1694535' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '86' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '1694034' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '87' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '1694726' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '90' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '92' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '93' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '94' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '332721' AND bh_owner = 'CIEL')
	OR (bh_oclid = '6722' AND bh_owner = 'CIEL')
	OR (bh_oclid = '96' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '73' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '67' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '69' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '70' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '72' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '47' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '51' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '52' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '53' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '54' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '55' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '326355' AND bh_owner = 'CIEL')
	OR (bh_oclid = '295780' AND bh_owner = 'CIEL')
	OR (bh_oclid = '57' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '58' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '59' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '60' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '61' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '62' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '63' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '64' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '41' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '42' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '43' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '44' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '45' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '31' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '32' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '28' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '29' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '30' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '33' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '34' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '36' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '37' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '38' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '12' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510344' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510346' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510348' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510336' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510326' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956343' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956346' AND bh_owner = 'CIEL')
	OR (bh_oclid = '8' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '20' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510337' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '9' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '11' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '10' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '6' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '322740' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956340' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '1922592' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '1923027' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '1923021' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '1922947' AND bh_owner = 'Regenstrief')
	OR (bh_oclid = '13' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '14' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510327' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510340' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7428998' AND bh_owner = 'CIEL')
	OR (bh_oclid = '318074' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7429004' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7428742' AND bh_owner = 'CIEL')
	OR (bh_oclid = '315383' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7428982' AND bh_owner = 'CIEL')
	OR (bh_oclid = '15' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '21' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '24' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '25' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '110' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '26' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '16' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '17' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '18' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956107' AND bh_owner = 'CIEL')
	OR (bh_oclid = '3' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '19' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956051' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956054' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956060' AND bh_owner = 'CIEL')
	OR (bh_oclid = '91' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956014' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956005' AND bh_owner = 'CIEL')
	OR (bh_oclid = '1294' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956008' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2955990' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956317' AND bh_owner = 'CIEL')
	OR (bh_oclid = '4' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '334969' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2652' AND bh_owner = 'CIEL')
	OR (bh_oclid = '304380' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2117' AND bh_owner = 'CIEL')
	OR (bh_oclid = '8873' AND bh_owner = 'CIEL')
	OR (bh_oclid = '8576' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2722205' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7379' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2722211' AND bh_owner = 'CIEL')
	OR (bh_oclid = '8286' AND bh_owner = 'CIEL')
	OR (bh_oclid = '6783' AND bh_owner = 'CIEL')
	OR (bh_oclid = '321128' AND bh_owner = 'CIEL')
	OR (bh_oclid = '6774' AND bh_owner = 'CIEL')
	OR (bh_oclid = '6274' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7510334' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956029' AND bh_owner = 'CIEL')
	OR (bh_oclid = '4912458' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7510330' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2023' AND bh_owner = 'CIEL')
	OR (bh_oclid = '6777' AND bh_owner = 'CIEL')
	OR (bh_oclid = '280335' AND bh_owner = 'CIEL')
	OR (bh_oclid = '107318' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2955984' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750076' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '3699' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750078' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2955982' AND bh_owner = 'CIEL')
	OR (bh_oclid = '320242' AND bh_owner = 'CIEL')
	OR (bh_oclid = '315151' AND bh_owner = 'CIEL')
	OR (bh_oclid = '307209' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750070' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '4428904' AND bh_owner = 'CIEL')
	OR (bh_oclid = '310407' AND bh_owner = 'CIEL')
	OR (bh_oclid = '328095' AND bh_owner = 'CIEL')
	OR (bh_oclid = '290654' AND bh_owner = 'CIEL')
	OR (bh_oclid = '310351' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7510332' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510342' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956323' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7510363' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7510365' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '100' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2722225' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7749452' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956098' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956032' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2722218' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2722232' AND bh_owner = 'CIEL')
	OR (bh_oclid = '294899' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750080' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '289193' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956101' AND bh_owner = 'CIEL')
	OR (bh_oclid = '323044' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750084' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2956037' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750092' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '286419' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750089' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7750074' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7750085' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7750082' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7986133' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '7986132' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '318075' AND bh_owner = 'CIEL')
	OR (bh_oclid = '325820' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2328993' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750071' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '2136' AND bh_owner = 'CIEL')
	OR (bh_oclid = '2956320' AND bh_owner = 'CIEL')
	OR (bh_oclid = '7750088' AND bh_owner = 'bandahealth')
	OR (bh_oclid = '314923' AND bh_owner = 'CIEL')
	OR (bh_oclid = '299412' AND bh_owner = 'CIEL')
	OR (bh_oclid = '318497' AND bh_owner = 'CIEL');
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IN (
		SELECT bh_concept_mapping_id
		FROM tmp_bh_concept_mapping
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	bh_concept_mapping_id IN (
		SELECT bh_concept_mapping_id
		FROM tmp_bh_concept_mapping
	);

-- Delete some concept mappings that don't come over
DROP TABLE tmp_bh_concept_mapping;
SELECT
	bh_concept_mapping_id
INTO TEMP TABLE
	tmp_bh_concept_mapping
FROM
	bh_concept_mapping
WHERE
	(bh_externalid IS NULL AND bh_from_concept_code = '10701-1')
	OR (bh_externalid = 'c3a40e0b-a85f-4b00-88ac-c99fc6e34fa5' AND bh_from_concept_code = '305')
	OR (bh_externalid = '8ba27d64-63b4-4767-97ec-b82560fdcf25' AND bh_from_concept_code = '9')
	OR (bh_externalid = '91632ABBBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '5011')
	OR (bh_externalid = '1098CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '1429')
	OR (bh_externalid = '1096CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '1429')
	OR (bh_externalid = '1097CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '1429')
	OR (bh_externalid = '291423ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '879')
	OR (bh_externalid = '285699ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '879')
	OR (bh_externalid = '144150ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '879')
	OR (bh_externalid = '144049ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '840')
	OR (bh_externalid = '285734ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '840')
	OR (bh_externalid = '275814ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '822')
	OR (bh_externalid = '27AEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE' AND bh_from_concept_code = '78')
	OR (bh_externalid = '29AEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE' AND bh_from_concept_code = '78')
	OR (bh_externalid = '3400CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '48')
	OR (bh_externalid = '145917ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '48')
	OR (bh_externalid = '3401CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '48')
	OR (bh_externalid = '3402CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' AND bh_from_concept_code = '48')
	OR (bh_externalid = '146055ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '6022')
	OR (bh_externalid = '51d98f71-18e7-400e-9c42-189052f5b3a0' AND bh_from_concept_code = '729')
	OR (bh_externalid = 'd984a239-ab2f-4efb-83f8-77d272830ab3' AND bh_from_concept_code = '12')
	OR (bh_externalid = '4020c3e4-b421-417b-ba64-44f2bc050978' AND bh_from_concept_code = '21')
	OR (bh_externalid = '3fadc735-79e0-47f8-8710-6e8f03321e7b' AND bh_from_concept_code = '10')
	OR (bh_externalid = 'ebd24732-6b44-4e12-944c-f2457dad08e2' AND bh_from_concept_code = '4')
	OR (bh_externalid = 'ee14e73f-cad1-4f4a-a4cc-8fda8b215919' AND bh_from_concept_code = '8')
	OR (bh_externalid = '0de65df3-d0a5-4892-a581-5225d36ff11a' AND bh_from_concept_code = '1')
	OR (bh_externalid = '3c1cf91b-08a2-4f15-9c8b-7154f76c987a' AND bh_from_concept_code = '45')
	OR (bh_externalid = 'ac91725c-e8ca-496c-9d6d-89358685a21c' AND bh_from_concept_code = '307')
	OR (bh_externalid = '092d6465-8e7b-4c0f-8997-9d45e7f20a75' AND bh_from_concept_code = '299')
	OR (bh_externalid = '275365ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '5018')
	OR (bh_externalid = 'a1c15e30-9f96-4a0e-ade1-8e92d85fb3d5' AND bh_from_concept_code = '5018')
	OR (bh_externalid = 'bdd1a2b7-3e6a-4953-a1e8-0311a3551429' AND bh_from_concept_code = '78')
	OR (bh_externalid = 'c46c481c-39a3-4072-9ba6-27650d4f8c58' AND bh_from_concept_code = '48')
	OR (bh_externalid = '9008b739-8fa0-4805-a359-9064e9323b3b' AND bh_from_concept_code = '3')
	OR (bh_externalid = '7f1a5cb7-ac47-4097-bbff-92c76134ca5f' AND bh_from_concept_code = '5')
	OR (bh_externalid = '274836ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '162194')
	OR (bh_externalid = '274835ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '162194')
	OR (bh_externalid = '8b38906f-4a83-44c8-a835-11da06969201' AND bh_from_concept_code = '306')
	OR (bh_externalid = '296bb76a-f298-4b8c-9553-40a4ee4ab6e0' AND bh_from_concept_code = '7')
	OR (bh_externalid = 'ab68b201-689c-43ca-89ec-40611e62cab8' AND bh_from_concept_code = '2')
	OR (bh_externalid = '17faccd0-a5f7-4f63-a690-6e99fc143834' AND bh_from_concept_code = '6')
	OR (bh_externalid = '52b8f4c9-05a7-43a5-b047-784e499e1c2b' AND bh_from_concept_code = '13')
	OR (bh_externalid = '0a1e3867-4b63-4353-b51f-9ae88c16db98' AND bh_from_concept_code = '32')
	OR (bh_externalid = '137766ABBBBBBBBBBBBBBBBBBBBBBBBBBBBB' AND bh_from_concept_code = '5622')
	OR (bh_externalid = '515751ae-ae0f-4378-8174-49bdb0d992b3' AND bh_from_concept_code = '11');
DELETE
FROM
	bh_concept_extra
WHERE
	bh_concept_mapping_id IN (
		SELECT bh_concept_mapping_id
		FROM tmp_bh_concept_mapping
	);
DELETE
FROM
	bh_concept_mapping
WHERE
	bh_concept_mapping_id IN (
		SELECT bh_concept_mapping_id
		FROM tmp_bh_concept_mapping
	);

-- Delete all the concept names because we're going to re-fetch them
DELETE
FROM
	bh_concept_name
WHERE
	ocl_uuid IS NULL;

SELECT
	register_migration_script('202410161333_GO-2923.sql')
FROM
	dual;
