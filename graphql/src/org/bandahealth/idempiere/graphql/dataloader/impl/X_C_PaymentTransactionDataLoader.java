package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentTransaction;

/**
 * Data Loader for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTransactionDataLoader extends PODataLoader<MPaymentTransaction> {
	public static String C_PaymentTransaction_BY_ID_DATA_LOADER = "C_PaymentTransactionByIdDataLoader";
	public static String C_PaymentTransaction_BY_UUID_DATA_LOADER = "C_PaymentTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaymentTransaction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaymentTransaction_BY_UUID_DATA_LOADER;
	}
}
