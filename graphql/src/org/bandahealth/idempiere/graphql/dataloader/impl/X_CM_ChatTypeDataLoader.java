package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChatType;

/**
 * Data Loader for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatTypeDataLoader extends PODataLoader<MChatType> {
	public static String CM_ChatType_BY_ID_DATA_LOADER = "CM_ChatTypeByIdDataLoader";
	public static String CM_ChatType_BY_UUID_DATA_LOADER = "CM_ChatTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChatType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return CM_ChatType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return CM_ChatType_BY_UUID_DATA_LOADER;
	}
}
