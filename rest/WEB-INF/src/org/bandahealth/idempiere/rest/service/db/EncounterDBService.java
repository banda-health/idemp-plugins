package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Encounter;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterDBService extends BaseDBService<Encounter, MBHEncounter> {

	@Autowired
	private ObservationDBService observationDBService;

	@Override
	public Encounter saveEntity(Encounter entity) {
		MBHEncounter encounter = new Query(Env.getCtx(), MBHEncounter.Table_Name,
				MBHEncounter.COLUMNNAME_BH_Encounter_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (encounter == null) {
			encounter = new MBHEncounter(Env.getCtx(), 0, null);
			encounter.setBH_Encounter_UU(entity.getUuid());
		}

		encounter.setBH_EncounterType(entity.getEncounterType());

		// save observations
		int encounterId = encounter.get_ID();
		entity.getObservations().stream().forEach(observation -> {
			observation.setEncounterId(encounterId);
			observationDBService.saveEntity(observation);
		});

		encounter.saveEx();

		return createInstanceWithAllFields(encounter);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
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
}
