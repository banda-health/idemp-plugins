package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUOMConversion;

/**
 * Data Loader for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UOM_ConversionDataLoader extends PODataLoader<MUOMConversion> {
	public static String C_UOM_Conversion_BY_ID_DATA_LOADER = "C_UOM_ConversionByIdDataLoader";
	public static String C_UOM_Conversion_BY_UUID_DATA_LOADER = "C_UOM_ConversionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUOMConversion.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_UOM_Conversion_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_UOM_Conversion_BY_UUID_DATA_LOADER;
	}
}
