package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterDiagnosis;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class EncounterDiagnosisDBService extends BaseDBService<EncounterDiagnosis, MBHEncounterDiagnosis> {

	@Override
	public EncounterDiagnosis saveEntity(EncounterDiagnosis entity) {
		MBHEncounterDiagnosis encounter = new Query(Env.getCtx(), MBHEncounterDiagnosis.Table_Name,
				MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_Diagnosis_UU + " =?", null).setParameters(entity.getUuid()).first();
		if (encounter == null) {
			throw new AdempiereException("Encounter Diagnosis not found.");
		}

		return createInstanceWithAllFields(encounter);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
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
	protected EncounterDiagnosis createInstanceWithSearchFields(MBHEncounterDiagnosis instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHEncounterDiagnosis getModelInstance() {
		return new MBHEncounterDiagnosis(Env.getCtx(), 0, null);
	}
}
