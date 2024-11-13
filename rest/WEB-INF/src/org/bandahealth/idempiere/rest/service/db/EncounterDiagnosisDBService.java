package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.model.EncounterDiagnosis;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EncounterDiagnosisDBService extends BaseDBService<EncounterDiagnosis, MBHEncounterDiagnosis> {

	private final ConceptDBService conceptDBService = new ConceptDBService();

	public void deleteEncounterDiagnosisNotInList(int encounterId, List<EncounterDiagnosis> encounterDiagnoses) {
		// get existing diagnoses
		List<MBHEncounterDiagnosis> mEncounterDiagnoses = new Query(Env.getCtx(), MBHEncounterDiagnosis.Table_Name,
				MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID + " =?", null).setParameters(encounterId)
				.setClient_ID().list();

		mEncounterDiagnoses.stream().filter(existingDiagnosis -> encounterDiagnoses.stream().noneMatch(
						newDiagnosis -> newDiagnosis.getUuid().equals(existingDiagnosis.getBH_Encounter_Diagnosis_UU())))
				.forEach(entity -> deleteEntity(entity.getBH_Encounter_Diagnosis_UU()));
	}

	@Override
	public EncounterDiagnosis saveEntity(EncounterDiagnosis entity) {
		MBHEncounterDiagnosis encounterDiagnosis = getEntityByUuidFromDB(entity.getUuid());
		if (encounterDiagnosis == null) {
			encounterDiagnosis = new MBHEncounterDiagnosis(Env.getCtx(), 0, null);
			encounterDiagnosis.setBH_Encounter_Diagnosis_UU(entity.getUuid());
		}

		if (entity.getConcept() != null) {
			MBHConcept concept = conceptDBService
					.getEntityByUuidFromDB(entity.getConcept().getUuid());
			if (concept != null) {
				encounterDiagnosis.setBH_Concept_ID(concept.get_ID());
			}
		}

		if (entity.getUncodedDiagnosis() != null) {
			encounterDiagnosis.setBH_Uncoded_Diagnosis(entity.getUncodedDiagnosis());
		}

		encounterDiagnosis.setBH_Encounter_ID(entity.getEncounterId());
		encounterDiagnosis.setLineNo(entity.getLineNo());

		encounterDiagnosis.saveEx();

		return createInstanceWithAllFields(encounterDiagnosis);
	}

	@Override
	protected EncounterDiagnosis createInstanceWithDefaultFields(MBHEncounterDiagnosis instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected EncounterDiagnosis createInstanceWithAllFields(MBHEncounterDiagnosis instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MBHEncounterDiagnosis getModelInstance() {
		return new MBHEncounterDiagnosis(Env.getCtx(), 0, null);
	}

	public void deleteEncounterDiagnosisByEncounter(int encounterId, String transactionName) {
		List<MBHEncounterDiagnosis> mEncounterDiagnoses = new Query(Env.getCtx(), MBHEncounterDiagnosis.Table_Name,
				MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID + " =?", transactionName).setParameters(encounterId)
				.setClient_ID().list();

		for (MBHEncounterDiagnosis mEncounterDiagnosis : mEncounterDiagnoses) {
			mEncounterDiagnosis.deleteEx(false);
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHEncounterDiagnosis entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			return entity.delete(true);
		}

		return false;
	}

	@Override
	public List<EncounterDiagnosis> transformData(List<MBHEncounterDiagnosis> dbModels) {
		// get concept
		Map<Integer, Concept> codedDiagnosisById = conceptDBService.transformData(new ArrayList<>(
				conceptDBService.getByIds(
								dbModels.stream().map(MBHEncounterDiagnosis::getBH_Concept_ID).collect(Collectors.toSet()))
						.values())).stream().collect(Collectors.toMap(Concept::getId, codedDiagnosis -> codedDiagnosis));

		return dbModels.stream().map(entity -> {
			EncounterDiagnosis result = new EncounterDiagnosis(entity);
			if (codedDiagnosisById.containsKey(entity.getBH_Concept_ID())) {
				result.setConcept(codedDiagnosisById.get(entity.getBH_Concept_ID()));
			}

			return result;
		}).collect(Collectors.toList());
	}
}
