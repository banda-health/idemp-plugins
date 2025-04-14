package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_OrderSource;

/**
 * Data Loader for C_OrderSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderSourceDataLoader extends PODataLoader<X_C_OrderSource> {
	public static String DATALOADER_C_OrderSource_BY_ID = "C_OrderSourceByIdDataLoader";
	public static String DATALOADER_C_OrderSource_BY_UUID = "C_OrderSourceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_OrderSource.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderSource_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderSource_BY_UUID;
	}
}
