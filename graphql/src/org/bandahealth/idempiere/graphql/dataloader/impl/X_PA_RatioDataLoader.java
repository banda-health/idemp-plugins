package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Ratio;

/**
 * Data Loader for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioDataLoader extends PODataLoader<X_PA_Ratio> {
	public static String PA_Ratio_BY_ID_DATA_LOADER = "PA_RatioByIdDataLoader";
	public static String PA_Ratio_BY_UUID_DATA_LOADER = "PA_RatioByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Ratio.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Ratio_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Ratio_BY_UUID_DATA_LOADER;
	}
}
