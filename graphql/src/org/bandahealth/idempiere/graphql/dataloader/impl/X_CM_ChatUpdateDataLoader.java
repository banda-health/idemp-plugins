package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_CM_ChatUpdate;

/**
 * Data Loader for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatUpdateDataLoader extends PODataLoader<X_CM_ChatUpdate> {
	public static String DATALOADER_CM_ChatUpdate_BY_ID = "CM_ChatUpdateByIdDataLoader";
	public static String DATALOADER_CM_ChatUpdate_BY_UUID = "CM_ChatUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_CM_ChatUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_CM_ChatUpdate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_CM_ChatUpdate_BY_UUID;
	}
}
