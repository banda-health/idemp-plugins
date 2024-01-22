package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChat;

/**
 * Data Loader for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatDataLoader extends PODataLoader<MChat> {
	public static String DATALOADER_CM_Chat_BY_ID = "CM_ChatByIdDataLoader";
	public static String DATALOADER_CM_Chat_BY_UUID = "CM_ChatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_CM_Chat_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_CM_Chat_BY_UUID;
	}
}
