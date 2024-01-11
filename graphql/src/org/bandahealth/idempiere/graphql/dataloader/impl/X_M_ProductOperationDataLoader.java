package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ProductOperation;

/**
 * Data Loader for M_ProductOperation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductOperationDataLoader extends PODataLoader<X_M_ProductOperation> {
	public static String M_ProductOperation_BY_ID_DATA_LOADER = "M_ProductOperationByIdDataLoader";
	public static String M_ProductOperation_BY_UUID_DATA_LOADER = "M_ProductOperationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ProductOperation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductOperation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductOperation_BY_UUID_DATA_LOADER;
	}
}
