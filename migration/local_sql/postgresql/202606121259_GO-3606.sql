-- GO-3606: Remap BHGO duplicate diagnosis concepts before OCL retirement
--
-- Twelve BHGO concepts share a display name with another active concept.
-- Visit diagnoses store bh_concept_id FKs; remap to the keeper before retiring
-- duplicates in OCL and running Concept Sync.
--
-- Keeper / retire (by OCL concept id):
--   [audited]  Acne:                              keep 4,     retire 151193
--   [audited]  Allergic rhinitis:                 keep 16,    retire 151197
--   [audited]  Alopecia Areata:                   keep 592,   retire 151196
--   [audited]  Appendicitis:                      keep 529,   retire 151199
--   [audited]  Febrile convulsion:                keep 459,   retire 435
--   [provisional] Periodontitis:                  keep 291,   retire 151198
--   [provisional] Presbyopia:                     keep 625,   retire 636
--   [provisional] Screening… Cervix:              keep 677,   retire 151185
--   [provisional] Tremor:                         keep 686,   retire 687
--   [provisional] Lymphocytosis:                  keep 730,   retire 745
--   [provisional] Seborrheic Dermatitis:          keep 570,   retire 151200
--   [provisional] Subluxation of Joint:           keep 483,   retire 484
--
-- Provisional pairs follow: retire 151xxx duplicate where present, else retire
-- higher numeric OCL id.

SELECT
	m.retire_oclid,
	m.keep_oclid,
	c_retire.bh_concept_id AS retire_bh_concept_id,
	c_keep.bh_concept_id   AS keep_bh_concept_id
INTO TEMP TABLE
	tmp_bhgo_dup_resolved
FROM
	(
		VALUES
			('151193', '4'),
			('151197', '16'),
			('151196', '592'),
			('151199', '529'),
			('435', '459'),
			('151198', '291'),
			('636', '625'),
			('151185', '677'),
			('687', '686'),
			('745', '730'),
			('151200', '570'),
			('484', '483')
	) AS m (retire_oclid, keep_oclid)
		JOIN bh_concept c_retire
		ON c_retire.bh_oclid = m.retire_oclid
			AND c_retire.bh_source = 'BHGO'
		JOIN bh_concept c_keep
		ON c_keep.bh_oclid = m.keep_oclid
			AND c_keep.bh_source = 'BHGO';

UPDATE bh_encounter_diagnosis ed
SET
	bh_concept_id = m.keep_bh_concept_id
FROM
	tmp_bhgo_dup_resolved m
WHERE
	ed.bh_concept_id = m.retire_bh_concept_id;

UPDATE bh_client_concept cc
SET
	bh_concept_id = m.keep_bh_concept_id
FROM
	tmp_bhgo_dup_resolved m
WHERE
	cc.bh_concept_id = m.retire_bh_concept_id;

SELECT
	register_migration_script('202606121259_GO-3606.sql')
FROM
	dual;
