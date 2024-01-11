package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_ListType;

/**
 * Data Loader for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListTypeDataLoader extends PODataLoader<X_HR_ListType> {
	public static String HR_ListType_BY_ID_DATA_LOADER = "HR_ListTypeByIdDataLoader";
	public static String HR_ListType_BY_UUID_DATA_LOADER = "HR_ListTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_ListType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_ListType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_ListType_BY_UUID_DATA_LOADER;
	}
}
