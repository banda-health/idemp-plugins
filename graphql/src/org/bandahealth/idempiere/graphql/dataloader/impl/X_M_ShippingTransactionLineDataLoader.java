package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingTransactionLine;

/**
 * Data Loader for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionLineDataLoader extends PODataLoader<MShippingTransactionLine> {
	public static String M_ShippingTransactionLine_BY_ID_DATA_LOADER = "M_ShippingTransactionLineByIdDataLoader";
	public static String M_ShippingTransactionLine_BY_UUID_DATA_LOADER = "M_ShippingTransactionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingTransactionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShippingTransactionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShippingTransactionLine_BY_UUID_DATA_LOADER;
	}
}
