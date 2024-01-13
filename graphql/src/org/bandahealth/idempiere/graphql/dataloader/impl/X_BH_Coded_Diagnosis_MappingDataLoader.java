package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHCodedDiagnosisMapping;

/**
 * Data Loader for BH_Coded_Diagnosis_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Coded_Diagnosis_MappingDataLoader extends PODataLoader<MBHCodedDiagnosisMapping> {
	public static String DATALOADER_BH_Coded_Diagnosis_Mapping_BY_ID = "BH_Coded_Diagnosis_MappingByIdDataLoader";
	public static String DATALOADER_BH_Coded_Diagnosis_Mapping_BY_UUID = "BH_Coded_Diagnosis_MappingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHCodedDiagnosisMapping.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Coded_Diagnosis_Mapping_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Coded_Diagnosis_Mapping_BY_UUID;
	}
}
