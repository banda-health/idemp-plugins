package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColorSchema;

/**
 * Data Loader for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ColorSchemaDataLoader extends PODataLoader<MColorSchema> {
	public static String PA_ColorSchema_BY_ID_DATA_LOADER = "PA_ColorSchemaByIdDataLoader";
	public static String PA_ColorSchema_BY_UUID_DATA_LOADER = "PA_ColorSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColorSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ColorSchema_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ColorSchema_BY_UUID_DATA_LOADER;
	}
}
