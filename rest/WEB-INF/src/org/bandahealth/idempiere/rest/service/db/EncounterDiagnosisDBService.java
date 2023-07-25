package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
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

		encounterDiagnosis.setBH_Encounter_ID(entity.getEncounterId());
		encounterDiagnosis.setLineNo(entity.getLineNo());

		encounterDiagnosis.saveEx();

		return createInstanceWithAllFields(encounterDiagnosis);
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
	protected MBHEncounterDiagnosis getModelInstance() {
		return new MBHEncounterDiagnosis(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MBHEncounterDiagnosis entity = getEntityByUuidFromDB(entityUuid);
		if (entity != null) {
			return entity.delete(true);
		}

		return false;
	}

	@Override
	public List<EncounterDiagnosis> transformData(List<MBHEncounterDiagnosis> dbModels) {
		// get coded diagnosis
		Map<Integer, MBHCodedDiagnosis> codedDiagnosisById = codedDiagnosisDBService.getByIds(
				dbModels.stream().map(MBHEncounterDiagnosis::getBH_Coded_Diagnosis_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(entity -> {
			EncounterDiagnosis result = new EncounterDiagnosis(entity);
			if (codedDiagnosisById.containsKey(entity.getBH_Coded_Diagnosis_ID())) {
				result.setCodedDiagnosis(codedDiagnosisDBService
						.transformData(
								Collections.singletonList(codedDiagnosisById.get(entity.getBH_Coded_Diagnosis_ID())))
						.get(0));
			}

			return result;
		}).collect(Collectors.toList());
	}
}
