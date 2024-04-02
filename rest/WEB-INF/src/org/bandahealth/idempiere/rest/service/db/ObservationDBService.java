package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.rest.model.Field;
import org.bandahealth.idempiere.rest.model.Observation;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MField;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObservationDBService extends BaseDBService<Observation, MBHObservation> {

	private final FieldDBService fieldDBService = new FieldDBService();

	public void deleteObservationsNotInList(int encounterId, List<Observation> observations) {
		// get existing observations
		List<MBHObservation> mObservations = new Query(Env.getCtx(), MBHObservation.Table_Name,
				MBHObservation.COLUMNNAME_BH_Encounter_ID + " =?", null).setParameters(encounterId).setClient_ID()
				.list();

		mObservations.stream()
				.filter(existingObservation -> observations.stream().noneMatch(
						newObservation -> newObservation.getUuid().equals(existingObservation.getBH_Observation_UU())))
				.forEach(entity -> deleteEntity(entity.getBH_Observation_UU()));
	}

	@Override
	public Observation saveEntity(Observation entity) {
		MBHObservation observation = getEntityByUuidFromDB(entity.getUuid());
		if (observation == null) {
			observation = new MBHObservation(Env.getCtx(), 0, null);
			observation.setBH_Observation_UU(entity.getUuid());
		}

		// save encounter
		if (entity.getEncounterId() > 0) {
			observation.setBH_Encounter_ID(entity.getEncounterId());
		} else {
			throw new AdempiereException("Encounter missing!");
		}

		if (entity.getField() != null) {
			// get field
			MField field = fieldDBService.getEntityByUuidFromDB(entity.getField().getUuid());
			if (field != null) {
				observation.setAD_Field_ID(field.get_ID());
			} else {
				throw new AdempiereException("Field missig!");
			}
		} else {
			throw new AdempiereException("Field missing!");
		}

		// no need to save an empty/null observation
		if (StringUtil.isNullOrEmpty(entity.getValue())) {
			return entity;
		}

		observation.setBH_Value(entity.getValue());

		observation.saveEx();

		return createInstanceWithAllFields(observation);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHObservation entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			return entity.delete(true);
		}

		return false;
	}

	public void deleteObservationsByEncounter(int encounterId, String transactionName) {
		List<MBHObservation> mObservations = new Query(Env.getCtx(), MBHObservation.Table_Name,
				MBHObservation.COLUMNNAME_BH_Encounter_ID + " =?", transactionName).setParameters(encounterId)
				.setClient_ID().list();

		for (MBHObservation mObservation : mObservations) {
			mObservation.deleteEx(false);
		}
	}

	@Override
	protected Observation createInstanceWithDefaultFields(MBHObservation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Observation createInstanceWithAllFields(MBHObservation instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MBHObservation getModelInstance() {
		return new MBHObservation(Env.getCtx(), 0, null);
	}

	@Override
	public List<Observation> transformData(List<MBHObservation> dbModels) {
		// get fields
		Map<Integer, Field> fieldsById = fieldDBService.transformData(new ArrayList<>(
				fieldDBService.getByIds(dbModels.stream().map(MBHObservation::getAD_Field_ID).collect(Collectors.toSet()))
						.values())).stream().collect(Collectors.toMap(Field::getId, field -> field));

		return dbModels.stream().map(observation -> {
			Observation result = new Observation(observation);
			if (fieldsById.containsKey(observation.getAD_Field_ID())) {
				result.setField(fieldsById.get(observation.getAD_Field_ID()));
			}

			return result;

		}).collect(Collectors.toList());
	}
}
