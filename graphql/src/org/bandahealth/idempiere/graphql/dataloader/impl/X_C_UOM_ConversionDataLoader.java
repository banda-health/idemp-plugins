package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUOMConversion;

/**
 * Data Loader for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOM_ConversionDataLoader extends PODataLoader<MUOMConversion> {
	public static String DATALOADER_C_UOM_Conversion_BY_ID = "C_UOM_ConversionByIdDataLoader";
	public static String DATALOADER_C_UOM_Conversion_BY_UUID = "C_UOM_ConversionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUOMConversion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_UOM_Conversion_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_UOM_Conversion_BY_UUID;
	}
}
