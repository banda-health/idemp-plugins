package org.bandahealth.idempiere.rest.service.db;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.compiere.util.Env;
import org.compiere.util.Trx;
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
		MBHEncounter encounter = getEntityByUuidFromDB(entity.getUuid());

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

		// delete old observations
		observationDBService.deleteObservationsNotInList(encounterId, entity.getObservations());

		// save encounter diagnosis
		entity.getEncounterDiagnosis().stream().forEach(encounterDiagnosis -> {
			encounterDiagnosis.setEncounterId(encounterId);
			encounterDiagnosisDBService.saveEntity(encounterDiagnosis);
		});

		// delete old encounter diagnoses
		encounterDiagnosisDBService.deleteEncounterDiagnosisNotInList(encounterId, entity.getEncounterDiagnosis());

		return createInstanceWithAllFields(encounter);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHEncounter entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			Trx deleteEncounter = Trx.get(Trx.createTrxName("DeleteEncounter"), true);
			try {
				entity.set_TrxName(deleteEncounter.getTrxName());

				encounterDiagnosisDBService.deleteEncounterDiagnosisByEncounter(entity.get_ID(),
						deleteEncounter.getTrxName());

				observationDBService.deleteObservationsByEncounter(entity.get_ID(),
						deleteEncounter.getTrxName());

				boolean didDelete = entity.delete(true);
				if (!deleteEncounter.commit(true)) {
					logger.severe("Could not commit encounter transaction");
					return false;
				}
				
				return didDelete;
			} catch (Exception ex) {
				try {
					if (!deleteEncounter.rollback(true)) {
						logger.severe("Could not roll back encounter transaction");
					}
				} catch (SQLException e) {
					logger.severe("Could not roll back encounter transaction: " + e.getLocalizedMessage());
				}
				throw new AdempiereException(ex.getLocalizedMessage());
			} finally {
				if (!deleteEncounter.close()) {
					logger.severe("Could not close encounter transaction");
					return false;
				}
			}
		}

		return true;
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
