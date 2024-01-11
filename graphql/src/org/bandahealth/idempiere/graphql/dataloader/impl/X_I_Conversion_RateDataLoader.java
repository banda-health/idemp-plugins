package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Conversion_Rate;

/**
 * Data Loader for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_Conversion_RateDataLoader extends PODataLoader<X_I_Conversion_Rate> {
	public static String I_Conversion_Rate_BY_ID_DATA_LOADER = "I_Conversion_RateByIdDataLoader";
	public static String I_Conversion_Rate_BY_UUID_DATA_LOADER = "I_Conversion_RateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Conversion_Rate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Conversion_Rate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Conversion_Rate_BY_UUID_DATA_LOADER;
	}
}
