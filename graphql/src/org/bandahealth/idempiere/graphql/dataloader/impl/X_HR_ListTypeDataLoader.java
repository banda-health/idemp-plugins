package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListType;

/**
 * Data Loader for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_ListTypeDataLoader extends PODataLoader<X_HR_ListType> {
	public static String DATALOADER_HR_ListType_BY_ID = "HR_ListTypeByIdDataLoader";
	public static String DATALOADER_HR_ListType_BY_UUID = "HR_ListTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_ListType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_ListType_BY_UUID;
	}
}
