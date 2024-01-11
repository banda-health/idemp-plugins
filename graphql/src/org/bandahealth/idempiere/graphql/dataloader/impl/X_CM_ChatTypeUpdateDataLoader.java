package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_CM_ChatTypeUpdate;

/**
 * Data Loader for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatTypeUpdateDataLoader extends PODataLoader<X_CM_ChatTypeUpdate> {
	public static String CM_ChatTypeUpdate_BY_ID_DATA_LOADER = "CM_ChatTypeUpdateByIdDataLoader";
	public static String CM_ChatTypeUpdate_BY_UUID_DATA_LOADER = "CM_ChatTypeUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_CM_ChatTypeUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return CM_ChatTypeUpdate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return CM_ChatTypeUpdate_BY_UUID_DATA_LOADER;
	}
}
