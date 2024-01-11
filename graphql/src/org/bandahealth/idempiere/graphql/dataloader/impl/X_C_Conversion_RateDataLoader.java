package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MConversionRate;

/**
 * Data Loader for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Conversion_RateDataLoader extends PODataLoader<MConversionRate> {
	public static String C_Conversion_Rate_BY_ID_DATA_LOADER = "C_Conversion_RateByIdDataLoader";
	public static String C_Conversion_Rate_BY_UUID_DATA_LOADER = "C_Conversion_RateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MConversionRate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Conversion_Rate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Conversion_Rate_BY_UUID_DATA_LOADER;
	}
}
