package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_Ratio;

/**
 * Data Loader for PA_Ratio - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_RatioDataLoader extends PODataLoader<X_PA_Ratio> {
	public static String DATALOADER_PA_Ratio_BY_ID = "PA_RatioByIdDataLoader";
	public static String DATALOADER_PA_Ratio_BY_UUID = "PA_RatioByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_Ratio.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Ratio_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Ratio_BY_UUID;
	}
}
