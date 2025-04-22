package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MConversionType;

/**
 * Data Loader for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ConversionTypeDataLoader extends PODataLoader<MConversionType> {
	public static String DATALOADER_C_ConversionType_BY_ID = "C_ConversionTypeByIdDataLoader";
	public static String DATALOADER_C_ConversionType_BY_UUID = "C_ConversionTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MConversionType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ConversionType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ConversionType_BY_UUID;
	}
}
