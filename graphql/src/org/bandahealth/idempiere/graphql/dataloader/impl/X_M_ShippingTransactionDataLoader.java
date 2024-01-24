package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MShippingTransaction;

/**
 * Data Loader for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShippingTransactionDataLoader extends PODataLoader<MShippingTransaction> {
	public static String DATALOADER_M_ShippingTransaction_BY_ID = "M_ShippingTransactionByIdDataLoader";
	public static String DATALOADER_M_ShippingTransaction_BY_UUID = "M_ShippingTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MShippingTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShippingTransaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShippingTransaction_BY_UUID;
	}
}
