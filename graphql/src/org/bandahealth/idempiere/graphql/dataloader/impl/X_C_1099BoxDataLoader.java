package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_1099Box;

/**
 * Data Loader for C_1099Box - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_1099BoxDataLoader extends PODataLoader<X_C_1099Box> {
	public static String C_1099Box_BY_ID_DATA_LOADER = "C_1099BoxByIdDataLoader";
	public static String C_1099Box_BY_UUID_DATA_LOADER = "C_1099BoxByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_1099Box.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_1099Box_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_1099Box_BY_UUID_DATA_LOADER;
	}
}
