package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_RMAType;

/**
 * Data Loader for M_RMAType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMATypeDataLoader extends PODataLoader<X_M_RMAType> {
	public static String M_RMAType_BY_ID_DATA_LOADER = "M_RMATypeByIdDataLoader";
	public static String M_RMAType_BY_UUID_DATA_LOADER = "M_RMATypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_RMAType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RMAType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RMAType_BY_UUID_DATA_LOADER;
	}
}
