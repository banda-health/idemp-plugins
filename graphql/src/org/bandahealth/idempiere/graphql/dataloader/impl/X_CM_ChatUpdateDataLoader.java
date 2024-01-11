package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_CM_ChatUpdate;

/**
 * Data Loader for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatUpdateDataLoader extends PODataLoader<X_CM_ChatUpdate> {
	public static String CM_ChatUpdate_BY_ID_DATA_LOADER = "CM_ChatUpdateByIdDataLoader";
	public static String CM_ChatUpdate_BY_UUID_DATA_LOADER = "CM_ChatUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_CM_ChatUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return CM_ChatUpdate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return CM_ChatUpdate_BY_UUID_DATA_LOADER;
	}
}
