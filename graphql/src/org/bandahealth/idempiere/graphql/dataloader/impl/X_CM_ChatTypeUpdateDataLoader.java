package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_CM_ChatTypeUpdate;

/**
 * Data Loader for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_CM_ChatTypeUpdateDataLoader extends PODataLoader<X_CM_ChatTypeUpdate> {
	public static String DATALOADER_CM_ChatTypeUpdate_BY_ID = "CM_ChatTypeUpdateByIdDataLoader";
	public static String DATALOADER_CM_ChatTypeUpdate_BY_UUID = "CM_ChatTypeUpdateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_CM_ChatTypeUpdate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_CM_ChatTypeUpdate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_CM_ChatTypeUpdate_BY_UUID;
	}
}
