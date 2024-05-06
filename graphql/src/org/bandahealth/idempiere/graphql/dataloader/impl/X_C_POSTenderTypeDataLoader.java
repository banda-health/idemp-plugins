package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_POSTenderType;

/**
 * Data Loader for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSTenderTypeDataLoader extends PODataLoader<X_C_POSTenderType> {
	public static String DATALOADER_C_POSTenderType_BY_ID = "C_POSTenderTypeByIdDataLoader";
	public static String DATALOADER_C_POSTenderType_BY_UUID = "C_POSTenderTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_POSTenderType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_POSTenderType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_POSTenderType_BY_UUID;
	}
}
