package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;

/**
 * Data Loader for BH_Encounter_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Encounter_DiagnosisDataLoader extends PODataLoader<MBHEncounterDiagnosis> {
	public static String BH_Encounter_Diagnosis_BY_ID_DATA_LOADER = "BH_Encounter_DiagnosisByIdDataLoader";
	public static String BH_Encounter_Diagnosis_BY_UUID_DATA_LOADER = "BH_Encounter_DiagnosisByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEncounterDiagnosis.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Encounter_Diagnosis_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Encounter_Diagnosis_BY_UUID_DATA_LOADER;
	}
}
