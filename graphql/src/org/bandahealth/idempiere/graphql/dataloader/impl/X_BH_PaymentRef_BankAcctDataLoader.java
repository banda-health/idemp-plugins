package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;

/**
 * Data Loader for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_PaymentRef_BankAcctDataLoader extends PODataLoader<MBHPaymentRefBankAccount> {
	public static String BH_PaymentRef_BankAcct_BY_ID_DATA_LOADER = "BH_PaymentRef_BankAcctByIdDataLoader";
	public static String BH_PaymentRef_BankAcct_BY_UUID_DATA_LOADER = "BH_PaymentRef_BankAcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPaymentRefBankAccount.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_PaymentRef_BankAcct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_PaymentRef_BankAcct_BY_UUID_DATA_LOADER;
	}
}
