package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_S_Training_Class;

/**
 * Data Loader for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_Training_ClassDataLoader extends PODataLoader<X_S_Training_Class> {
	public static String S_Training_Class_BY_ID_DATA_LOADER = "S_Training_ClassByIdDataLoader";
	public static String S_Training_Class_BY_UUID_DATA_LOADER = "S_Training_ClassByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_S_Training_Class.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return S_Training_Class_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return S_Training_Class_BY_UUID_DATA_LOADER;
	}
}
