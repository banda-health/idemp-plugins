package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.EncounterDiagnosis;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncounterDiagnosisDBService extends BaseDBService<EncounterDiagnosis, MBHEncounterDiagnosis> {

	@Autowired
	private CodedDiagnosisDBService codedDiagnosisDBService;

	@Override
	public EncounterDiagnosis saveEntity(EncounterDiagnosis entity) {
		MBHEncounterDiagnosis encounterDiagnosis = new Query(Env.getCtx(), MBHEncounterDiagnosis.Table_Name,
				MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_Diagnosis_UU + " =?", null)
						.setParameters(entity.getUuid()).first();
		if (encounterDiagnosis == null) {
			encounterDiagnosis = new MBHEncounterDiagnosis(Env.getCtx(), 0, null);
			encounterDiagnosis.setBH_Encounter_Diagnosis_UU(entity.getUuid());
		}

		if (entity.getCodedDiagnosis() != null) {
			MBHCodedDiagnosis diagnosis = codedDiagnosisDBService
					.getEntityByUuidFromDB(entity.getCodedDiagnosis().getUuid());
			if (diagnosis != null) {
				encounterDiagnosis.setBH_Coded_Diagnosis_ID(diagnosis.get_ID());
			}
		}

		if (entity.getUncodedDiagnosis() != null) {
			encounterDiagnosis.setBH_Uncoded_Diagnosis(entity.getUncodedDiagnosis());
		}
		
		encounterDiagnosis.setBH_Diagnosis_Type(entity.getDiagnosisType());

		encounterDiagnosis.setLineNo(entity.getLineNo());

		encounterDiagnosis.saveEx();

		return createInstanceWithAllFields(encounterDiagnosis);
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
