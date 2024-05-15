package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;

/**
 * Data Loader for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Encounter_DiagnosisDataLoader extends PODataLoader<MBHEncounterDiagnosis> {
	public static String DATALOADER_BH_Encounter_Diagnosis_BY_ID = "BH_Encounter_DiagnosisByIdDataLoader";
	public static String DATALOADER_BH_Encounter_Diagnosis_BY_UUID = "BH_Encounter_DiagnosisByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounterDiagnosis.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Encounter_Diagnosis_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Encounter_Diagnosis_BY_UUID;
	}
}
