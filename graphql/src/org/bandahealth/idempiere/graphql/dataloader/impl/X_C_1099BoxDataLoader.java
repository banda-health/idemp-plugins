package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_1099Box;

/**
 * Data Loader for C_1099Box - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_1099BoxDataLoader extends PODataLoader<X_C_1099Box> {
	public static String DATALOADER_C_1099Box_BY_ID = "C_1099BoxByIdDataLoader";
	public static String DATALOADER_C_1099Box_BY_UUID = "C_1099BoxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_1099Box.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_1099Box_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_1099Box_BY_UUID;
	}
}
