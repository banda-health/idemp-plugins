package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_OrderSource;

/**
 * Data Loader for C_OrderSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderSourceDataLoader extends PODataLoader<X_C_OrderSource> {
	public static String C_OrderSource_BY_ID_DATA_LOADER = "C_OrderSourceByIdDataLoader";
	public static String C_OrderSource_BY_UUID_DATA_LOADER = "C_OrderSourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_OrderSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderSource_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderSource_BY_UUID_DATA_LOADER;
	}
}
