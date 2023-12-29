package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCash;
import org.compiere.model.MCashLine;
import org.compiere.model.MCurrency;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashLineResolver extends POResolver<MCashLine> implements GraphQLResolver<MCashLine> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Cash Journal.
	 *
	 * @return Cash Journal
	 */
	public CompletableFuture<MCash> C_Cash(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Cash_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCash> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashDataLoader.C_Cash_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Cash_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.C_Charge_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.C_Invoice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MCashLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.C_Payment_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Payment_ID());
	}

	static Map<String, String> CASHTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "bdc83ab7-2487-4c9c-8f11-642f84ad8a11");
			put("I", "8183e06f-d8e3-4fc5-a3fc-7419c1195e40");
			put("E", "e628fa15-edf5-4eaa-b9db-75993c7f4c06");
			put("R", "b0622456-7b1c-48e4-b314-c2cf674fa650");
			put("C", "f88991f2-5aa4-4b9b-9099-94b05afb28d9");
			put("D", "c4b005a2-2805-400b-a8d4-d9d4b2ab70ec");
		}
	};
	public CompletableFuture<MRefList> CashType_RL(MCashLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCashType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CASHTYPE_UUIDS_BY_VALUE.get(entity.getCashType()));
	}

}
