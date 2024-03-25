package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Conversion_Rate;

/**
 * Data Loader for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_Conversion_RateDataLoader extends PODataLoader<X_I_Conversion_Rate> {
	public static String DATALOADER_I_Conversion_Rate_BY_ID = "I_Conversion_RateByIdDataLoader";
	public static String DATALOADER_I_Conversion_Rate_BY_UUID = "I_Conversion_RateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Conversion_Rate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Conversion_Rate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Conversion_Rate_BY_UUID;
	}
}
