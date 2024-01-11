package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;

/**
 * Data Loader for BH_Coded_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Coded_DiagnosisDataLoader extends PODataLoader<MBHCodedDiagnosis> {
	public static String BH_Coded_Diagnosis_BY_ID_DATA_LOADER = "BH_Coded_DiagnosisByIdDataLoader";
	public static String BH_Coded_Diagnosis_BY_UUID_DATA_LOADER = "BH_Coded_DiagnosisByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHCodedDiagnosis.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Coded_Diagnosis_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Coded_Diagnosis_BY_UUID_DATA_LOADER;
	}
}
