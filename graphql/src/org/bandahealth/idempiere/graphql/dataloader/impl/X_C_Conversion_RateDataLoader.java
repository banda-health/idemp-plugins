package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MConversionRate;

/**
 * Data Loader for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Conversion_RateDataLoader extends PODataLoader<MConversionRate> {
	public static String DATALOADER_C_Conversion_Rate_BY_ID = "C_Conversion_RateByIdDataLoader";
	public static String DATALOADER_C_Conversion_Rate_BY_UUID = "C_Conversion_RateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MConversionRate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Conversion_Rate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Conversion_Rate_BY_UUID;
	}
}
