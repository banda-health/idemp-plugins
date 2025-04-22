package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_S_TimeType;

/**
 * Data Loader for S_TimeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TimeTypeDataLoader extends PODataLoader<X_S_TimeType> {
	public static String DATALOADER_S_TimeType_BY_ID = "S_TimeTypeByIdDataLoader";
	public static String DATALOADER_S_TimeType_BY_UUID = "S_TimeTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_S_TimeType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_S_TimeType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_S_TimeType_BY_UUID;
	}
}
