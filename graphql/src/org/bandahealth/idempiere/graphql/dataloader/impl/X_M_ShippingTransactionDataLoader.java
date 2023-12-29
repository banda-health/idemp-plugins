package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingTransaction;

/**
 * Data Loader for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionDataLoader extends PODataLoader<MShippingTransaction> {
	public static String M_ShippingTransaction_BY_ID_DATA_LOADER = "M_ShippingTransactionByIdDataLoader";
	public static String M_ShippingTransaction_BY_UUID_DATA_LOADER = "M_ShippingTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShippingTransaction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShippingTransaction_BY_UUID_DATA_LOADER;
	}
}
