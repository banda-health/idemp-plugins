package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Observation;
import org.compiere.model.MField;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObservationDBService extends BaseDBService<Observation, MBHObservation> {

	@Autowired
	private FieldDBService fieldDBService;

	@Override
	public Observation saveEntity(Observation entity) {
		MBHObservation observation = new Query(Env.getCtx(), MBHObservation.Table_Name,
				MBHObservation.COLUMNNAME_BH_Observation_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (observation == null) {
			observation = new MBHObservation(Env.getCtx(), 0, null);
			observation.setBH_Observation_UU(entity.getUuid());
		}

		// save encounter
		observation.setBH_Encounter_ID(entity.getEncounterId());

		// get field
		MField field = fieldDBService.getEntityByUuidFromDB(entity.getField().getUuid());
		if (field != null) {
			observation.setAD_Field_ID(field.get_ID());
		}

		// get lineno
		observation.setLineNo(entity.getLineNo());

		// get value
		observation.setValue(entity.getValue());

		observation.saveEx();

		return createInstanceWithAllFields(observation);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
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
	protected Observation createInstanceWithSearchFields(MBHObservation instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHObservation getModelInstance() {
		return new MBHObservation(Env.getCtx(), 0, null);
	}
}
