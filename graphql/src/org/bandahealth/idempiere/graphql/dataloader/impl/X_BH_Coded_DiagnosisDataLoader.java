package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;

/**
 * Data Loader for BH_Coded_Diagnosis - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Coded_DiagnosisDataLoader extends PODataLoader<MBHCodedDiagnosis> {
	public static String DATALOADER_BH_Coded_Diagnosis_BY_ID = "BH_Coded_DiagnosisByIdDataLoader";
	public static String DATALOADER_BH_Coded_Diagnosis_BY_UUID = "BH_Coded_DiagnosisByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHCodedDiagnosis.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Coded_Diagnosis_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Coded_Diagnosis_BY_UUID;
	}
}
