package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChatType;

/**
 * Data Loader for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeDataLoader extends PODataLoader<MChatType> {
	public static String DATALOADER_CM_ChatType_BY_ID = "CM_ChatTypeByIdDataLoader";
	public static String DATALOADER_CM_ChatType_BY_UUID = "CM_ChatTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChatType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_CM_ChatType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_CM_ChatType_BY_UUID;
	}
}
