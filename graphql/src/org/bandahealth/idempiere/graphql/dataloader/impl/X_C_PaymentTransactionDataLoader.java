package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentTransaction;

/**
 * Data Loader for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTransactionDataLoader extends PODataLoader<MPaymentTransaction> {
	public static String DATALOADER_C_PaymentTransaction_BY_ID = "C_PaymentTransactionByIdDataLoader";
	public static String DATALOADER_C_PaymentTransaction_BY_UUID = "C_PaymentTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaymentTransaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaymentTransaction_BY_UUID;
	}
}
