package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChat;

/**
 * Data Loader for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatDataLoader extends PODataLoader<MChat> {
	public static String CM_Chat_BY_ID_DATA_LOADER = "CM_ChatByIdDataLoader";
	public static String CM_Chat_BY_UUID_DATA_LOADER = "CM_ChatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return CM_Chat_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return CM_Chat_BY_UUID_DATA_LOADER;
	}
}
