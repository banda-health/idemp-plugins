package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocatorType;

/**
 * Data Loader for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LocatorTypeDataLoader extends PODataLoader<MLocatorType> {
	public static String M_LocatorType_BY_ID_DATA_LOADER = "M_LocatorTypeByIdDataLoader";
	public static String M_LocatorType_BY_UUID_DATA_LOADER = "M_LocatorTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocatorType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_LocatorType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_LocatorType_BY_UUID_DATA_LOADER;
	}
}
