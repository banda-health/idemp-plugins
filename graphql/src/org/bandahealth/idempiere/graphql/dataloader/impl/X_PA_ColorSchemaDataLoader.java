package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColorSchema;

/**
 * Data Loader for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ColorSchemaDataLoader extends PODataLoader<MColorSchema> {
	public static String DATALOADER_PA_ColorSchema_BY_ID = "PA_ColorSchemaByIdDataLoader";
	public static String DATALOADER_PA_ColorSchema_BY_UUID = "PA_ColorSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColorSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ColorSchema_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ColorSchema_BY_UUID;
	}
}
