package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MConversionType;

/**
 * Data Loader for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ConversionTypeDataLoader extends PODataLoader<MConversionType> {
	public static String C_ConversionType_BY_ID_DATA_LOADER = "C_ConversionTypeByIdDataLoader";
	public static String C_ConversionType_BY_UUID_DATA_LOADER = "C_ConversionTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MConversionType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ConversionType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ConversionType_BY_UUID_DATA_LOADER;
	}
}
