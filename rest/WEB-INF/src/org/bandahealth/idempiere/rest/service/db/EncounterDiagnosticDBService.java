package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.model.EncounterDiagnostic;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterDiagnosticDBService extends BaseDBService<EncounterDiagnostic, MBHEncounterDiagnostic> {

	@Autowired
	private ConceptDBService conceptDBService;

	@Override
	public EncounterDiagnostic saveEntity(EncounterDiagnostic entity) {
		MBHEncounterDiagnostic encounterDiagnostic = getEntityByUuidFromDB(entity.getUuid());
		if (encounterDiagnostic == null) {
			encounterDiagnostic = new MBHEncounterDiagnostic(Env.getCtx(), 0, null);
			encounterDiagnostic.setBH_Encounter_Diagnostic_UU(entity.getUuid());
		}

		if (entity.getConcept() != null) {
			MBHConcept concept = conceptDBService.getEntityByUuidFromDB(entity.getConcept().getUuid());
			if (concept != null) {
				encounterDiagnostic.setBH_Concept_ID(concept.get_ID());
			}
		}

		encounterDiagnostic.setBH_Diagnostic_Status(entity.getStatus());
		encounterDiagnostic.setBH_Value(entity.getValue());
		encounterDiagnostic.setBH_Encounter_ID(entity.getEncounterId());
		encounterDiagnostic.setLineNo(entity.getLineNo());

		encounterDiagnostic.saveEx();

		return createInstanceWithAllFields(encounterDiagnostic);
	}

	public void deleteEncounterDiagnosticNotInList(int encounterId, List<EncounterDiagnostic> encounterDiagnostics) {
		// get existing diagnostics
		List<MBHEncounterDiagnostic> mEncounterDiagnostics = new Query(Env.getCtx(), MBHEncounterDiagnostic.Table_Name,
				MBHEncounterDiagnostic.COLUMNNAME_BH_Encounter_ID + " =?", null).setParameters(encounterId)
				.setClient_ID().list();

		mEncounterDiagnostics.stream().filter(existingDiagnostic -> encounterDiagnostics.stream().noneMatch(
						concept -> concept.getUuid().equals(existingDiagnostic.getBH_Encounter_Diagnostic_UU())))
				.forEach(entity -> deleteEntity(entity.getBH_Encounter_Diagnostic_UU()));
	}
	
	@Override
	protected EncounterDiagnostic createInstanceWithDefaultFields(MBHEncounterDiagnostic instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected EncounterDiagnostic createInstanceWithAllFields(MBHEncounterDiagnostic instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MBHEncounterDiagnostic getModelInstance() {
		return new MBHEncounterDiagnostic(Env.getCtx(), 0, null);
	}

	public void deleteEncounterDiagnosticByEncounter(int encounterId, String transactionName) {
		List<MBHEncounterDiagnostic> mEncounterDiagnostics = new Query(Env.getCtx(), MBHEncounterDiagnostic.Table_Name,
				MBHEncounterDiagnostic.COLUMNNAME_BH_Encounter_ID + " =?", transactionName).setParameters(encounterId)
						.setClient_ID().list();

		for (MBHEncounterDiagnostic mEncounterDiagnostic : mEncounterDiagnostics) {
			mEncounterDiagnostic.deleteEx(false);
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHEncounterDiagnostic entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			return entity.delete(true);
		}

		return false;
	}
	
	@Override
	public List<EncounterDiagnostic> transformData(List<MBHEncounterDiagnostic> dbModels) {
		// get concepts
		Map<Integer, Concept> conceptsById = conceptDBService.transformData(new ArrayList<>(
				conceptDBService.getByIds(
								dbModels.stream().map(MBHEncounterDiagnostic::getBH_Concept_ID).collect(Collectors.toSet()))
						.values())).stream().collect(Collectors.toMap(Concept::getId, concept -> concept));

		return dbModels.stream().map(entity -> {
			EncounterDiagnostic result = new EncounterDiagnostic(entity);
			if (conceptsById.containsKey(entity.getBH_Concept_ID())) {
				result.setConcept(conceptsById.get(entity.getBH_Concept_ID()));
			}

			return result;
		}).collect(Collectors.toList());
	}
}
