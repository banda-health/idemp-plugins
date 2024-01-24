package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ProductOperation;

/**
 * Data Loader for M_ProductOperation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductOperationDataLoader extends PODataLoader<X_M_ProductOperation> {
	public static String DATALOADER_M_ProductOperation_BY_ID = "M_ProductOperationByIdDataLoader";
	public static String DATALOADER_M_ProductOperation_BY_UUID = "M_ProductOperationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ProductOperation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductOperation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductOperation_BY_UUID;
	}
}
