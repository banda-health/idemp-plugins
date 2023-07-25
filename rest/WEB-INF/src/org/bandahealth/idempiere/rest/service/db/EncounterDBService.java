package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterDBService extends BaseDBService<Encounter, MBHEncounter> {

	@Autowired
	private ObservationDBService observationDBService;

	@Autowired
	private EncounterDiagnosisDBService encounterDiagnosisDBService;

	@Override
	public Encounter saveEntity(Encounter entity) {
		MBHEncounter encounter = new Query(Env.getCtx(), MBHEncounter.Table_Name,
				MBHEncounter.COLUMNNAME_BH_Encounter_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (encounter == null) {
			encounter = new MBHEncounter(Env.getCtx(), 0, null);
			encounter.setBH_Encounter_UU(entity.getUuid());
		}

		encounter.setBH_Encounter_Type(entity.getEncounterType());
		encounter.setBH_Visit_ID(entity.getVisitId());
		encounter.saveEx();

		// save observations
		int encounterId = encounter.get_ID();
		entity.getObservations().stream().forEach(observation -> {
			observation.setEncounterId(encounterId);
			observationDBService.saveEntity(observation);
		});

		// save encounter diagnosis
		entity.getEncounterDiagnosis().stream().forEach(encounterDiagnosis -> {
			encounterDiagnosis.setEncounterId(encounterId);
			encounterDiagnosisDBService.saveEntity(encounterDiagnosis);
		});

		return createInstanceWithAllFields(encounter);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHEncounter entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			return entity.delete(true);
		}

		return false;
	}

	@Override
	protected Encounter createInstanceWithDefaultFields(MBHEncounter instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Encounter createInstanceWithAllFields(MBHEncounter instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected Encounter createInstanceWithSearchFields(MBHEncounter instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHEncounter getModelInstance() {
		return new MBHEncounter(Env.getCtx(), 0, null);
	}

	@Override
	public List<Encounter> transformData(List<MBHEncounter> dbModels) {
		Set<Integer> encounterIds = dbModels.stream().map(MBHEncounter::getBH_Encounter_ID).collect(Collectors.toSet());

		// get obs
		Map<Integer, List<MBHObservation>> obsByEncounter = observationDBService.getGroupsByIds(
				MBHObservation::getBH_Encounter_ID, MBHObservation.COLUMNNAME_BH_Encounter_ID, encounterIds);

		// get encounter diagnosis
		Map<Integer, List<MBHEncounterDiagnosis>> encounterDiagnosisByEncounter = encounterDiagnosisDBService
				.getGroupsByIds(MBHEncounterDiagnosis::getBH_Encounter_ID,
						MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID, encounterIds);

		return dbModels.stream().map(encounter -> {
			Encounter result = new Encounter(encounter);

			if (obsByEncounter.containsKey(encounter.getBH_Encounter_ID())) {
				result.setObservations(
						observationDBService.transformData(obsByEncounter.get(encounter.getBH_Encounter_ID())));
			}

			if (encounterDiagnosisByEncounter.containsKey(encounter.getBH_Encounter_ID())) {
				result.setEncounterDiagnosis(encounterDiagnosisDBService
						.transformData(encounterDiagnosisByEncounter.get(encounter.getBH_Encounter_ID())));
			}

			return result;
		}).collect(Collectors.toList());
	}
}
