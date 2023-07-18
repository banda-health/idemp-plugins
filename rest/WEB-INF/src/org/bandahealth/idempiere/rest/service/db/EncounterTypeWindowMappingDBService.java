package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindowMapping;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterTypeWindowMapping;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class EncounterTypeWindowMappingDBService extends BaseDBService<EncounterTypeWindowMapping, MBHEncounterTypeWindowMapping> {

	@Override
	public EncounterTypeWindowMapping saveEntity(EncounterTypeWindowMapping entity) {
		MBHEncounterTypeWindowMapping encounterTypeWindowMapping = new Query(Env.getCtx(), MBHEncounterTypeWindowMapping.Table_Name,
				MBHEncounterTypeWindowMapping.COLUMNNAME_BH_Encounter_Type_Window_Mapping_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (encounterTypeWindowMapping == null) {
			throw new AdempiereException("Encounter type window mapping not found.");
		}

		return createInstanceWithAllFields(encounterTypeWindowMapping);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected EncounterTypeWindowMapping createInstanceWithDefaultFields(MBHEncounterTypeWindowMapping instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected EncounterTypeWindowMapping createInstanceWithAllFields(MBHEncounterTypeWindowMapping instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected EncounterTypeWindowMapping createInstanceWithSearchFields(MBHEncounterTypeWindowMapping instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHEncounterTypeWindowMapping getModelInstance() {
		return new MBHEncounterTypeWindowMapping(Env.getCtx(), 0, null);
	}
}
