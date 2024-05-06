package org.bandahealth.idempiere.rest.service.db;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.sql.Timestamp;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.bandahealth.idempiere.rest.model.EncounterDiagnosis;
import org.bandahealth.idempiere.rest.model.EncounterDiagnostic;
import org.bandahealth.idempiere.rest.model.Observation;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.compiere.util.Trx;

public class EncounterDBService extends BaseDBService<Encounter, MBHEncounter> {

	private final ObservationDBService observationDBService = new ObservationDBService();
	private final EncounterDiagnosisDBService encounterDiagnosisDBService = new EncounterDiagnosisDBService();
	private final ReferenceListDBService referenceListDBService = new ReferenceListDBService();
	private final EncounterDiagnosticDBService encounterDiagnosticDBService = new EncounterDiagnosticDBService();
	
	@Override
	public Encounter saveEntity(Encounter entity) {
		return createInstanceWithAllFields(getEntityByUuidFromDB(saveOnlyWithoutChildDataFetch(entity).getUuid()));
	}

	/**
	 * This method is implemented to speed up processing by avoiding an unnecessary data fetch.
	 * TODO: Remove this when we have GraphQL
	 *
	 * @param entity The encounter to save
	 * @return A somewhat updated encounter (has the new UUID & ID on it for other use)
	 */
	public Encounter saveOnlyWithoutChildDataFetch(Encounter entity) {
		MBHEncounter encounter = getEntityByUuidFromDB(entity.getUuid());

		if (encounter == null) {
			encounter = new MBHEncounter(Env.getCtx(), 0, null);
			encounter.setBH_Encounter_UU(entity.getUuid());
		}

		if (entity.getEncounterType() != null && !StringUtil.isNullOrEmpty(entity.getEncounterType().getUuid())) {
			MRefList encounterType = referenceListDBService.getEntityByUuidFromDB(entity.getEncounterType().getUuid());
			encounter.setBH_Encounter_Type(encounterType.getValue());
		}
		encounter.setBH_Visit_ID(entity.getVisitId());
		encounter.setBH_Encounter_Date(entity.getEncounterDate());
		
		encounter.saveEx();

		// save observations
		int encounterId = encounter.get_ID();
		entity.setObservations(entity.getObservations().stream().map(observation -> {
			observation.setEncounterId(encounterId);
			return observationDBService.saveEntity(observation);
		}).collect(Collectors.toList()));

		// delete old observations
		observationDBService.deleteObservationsNotInList(encounterId, entity.getObservations());

		// save encounter diagnosis
		entity.setEncounterDiagnoses(entity.getEncounterDiagnoses().stream().map(encounterDiagnosis -> {
			encounterDiagnosis.setEncounterId(encounterId);
			return encounterDiagnosisDBService.saveEntity(encounterDiagnosis);
		}).collect(Collectors.toList()));

		// delete old encounter diagnoses
		encounterDiagnosisDBService.deleteEncounterDiagnosisNotInList(encounterId, entity.getEncounterDiagnoses());
		
		// save encounter diagnostic
		entity.setEncounterDiagnostics(entity.getEncounterDiagnostics().stream().map(encounterDiagnostic -> {
			encounterDiagnostic.setEncounterId(encounterId);
			return encounterDiagnosticDBService.saveEntity(encounterDiagnostic);
		}).collect(Collectors.toList()));

		// delete old encounter diagnostics
		encounterDiagnosticDBService.deleteEncounterDiagnosticNotInList(encounterId, entity.getEncounterDiagnostics());

		return new Encounter(encounter);
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

		// get observations
		Map<Integer, List<Observation>> observationsByEncounterId = observationDBService.transformData(
				observationDBService.getGroupsByIds(MBHObservation::getBH_Encounter_ID,
								MBHObservation.COLUMNNAME_BH_Encounter_ID, encounterIds).values().stream().flatMap(Collection::stream)
						.collect(Collectors.toList())).stream().collect(Collectors.groupingBy(Observation::getEncounterId));

		// get encounter diagnosis
		Map<Integer, List<EncounterDiagnosis>> encounterDiagnosesByEncounterId = encounterDiagnosisDBService.transformData(
						encounterDiagnosisDBService.getGroupsByIds(MBHEncounterDiagnosis::getBH_Encounter_ID,
										MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID, encounterIds).values().stream()
								.flatMap(Collection::stream).collect(Collectors.toList())).stream()
				.collect(Collectors.groupingBy(EncounterDiagnosis::getEncounterId));
		
		// get encounter diagnostics
		Map<Integer, List<EncounterDiagnostic>> encounterDiagnosticsByEncounterId = encounterDiagnosticDBService.transformData(
						encounterDiagnosticDBService.getGroupsByIds(MBHEncounterDiagnostic::getBH_Encounter_ID,
								MBHEncounterDiagnostic.COLUMNNAME_BH_Encounter_ID, encounterIds).values().stream()
								.flatMap(Collection::stream).collect(Collectors.toList())).stream()
				.collect(Collectors.groupingBy(EncounterDiagnostic::getEncounterId));

		// get reference list values
		Map<String, ReferenceList> encounterTypesByValue = referenceListDBService.getTypes(MReference_BH.ENCOUNTER_TYPES,
						dbModels.stream().map(MBHEncounter::getBH_Encounter_Type).collect(Collectors.toSet())).stream()
				.collect(Collectors.toMap(MRefList::getValue, ReferenceList::new));
		
		// TODO get encounter diagnostics

		return dbModels.stream().map(encounter -> {
			Encounter result = new Encounter(encounter);

			if (encounterTypesByValue.containsKey(encounter.getBH_Encounter_Type())) {
				result.setEncounterType(encounterTypesByValue.get(encounter.getBH_Encounter_Type()));
			}

			if (observationsByEncounterId.containsKey(encounter.getBH_Encounter_ID())) {
				result.setObservations(observationsByEncounterId.get(encounter.getBH_Encounter_ID()));
			}

			if (encounterDiagnosesByEncounterId.containsKey(encounter.getBH_Encounter_ID())) {
				result.setEncounterDiagnoses(encounterDiagnosesByEncounterId.get(encounter.getBH_Encounter_ID()));
			}
			
			if (encounterDiagnosticsByEncounterId.containsKey(encounter.getBH_Encounter_ID())) {
				result.setEncounterDiagnostics(encounterDiagnosticsByEncounterId.get(encounter.getBH_Encounter_ID()));
			}

			return result;
		}).collect(Collectors.toList());
	}

	@Override
	public Boolean delete(List<String> uuids) {
		Map<String, MBHEncounter> encounters = getByUuids(new HashSet<>(uuids));
		if (encounters.isEmpty()) {
			return true;
		}

		Set<Integer> encounterIds = encounters.values().stream().map(MBHEncounter::getBH_Encounter_ID)
				.collect(Collectors.toSet());

		// retrieve and delete list of observations
		Map<Integer, List<MBHObservation>> observations = observationDBService.getGroupsByIds(
				MBHObservation::getBH_Encounter_ID, MBHObservation.COLUMNNAME_BH_Encounter_ID, encounterIds);

		observations.values().stream().flatMap(List::stream).collect(Collectors.toList()).stream()
				.forEach(observation -> observation.deleteEx(true));

		// retrieve and delete list of encounter diagnoses
		Map<Integer, List<MBHEncounterDiagnosis>> encounterDiagnoses = encounterDiagnosisDBService.getGroupsByIds(
				MBHEncounterDiagnosis::getBH_Encounter_ID, MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID,
				encounterIds);

		encounterDiagnoses.values().stream().flatMap(List::stream).collect(Collectors.toList()).stream()
				.forEach(encounterDiagnosis -> encounterDiagnosis.deleteEx(true));

		encounters.values().stream().forEach(encounter -> encounter.deleteEx(true));

		return true;
	}
}
