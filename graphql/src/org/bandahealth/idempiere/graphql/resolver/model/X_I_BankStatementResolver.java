package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.X_I_BankStatement;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_BankStatementResolver extends POResolver<X_I_BankStatement> implements GraphQLResolver<X_I_BankStatement> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Bank Statement.
	 *
	 * @return Bank Statement of account
	 */
	public CompletableFuture<MBankStatement> C_BankStatement(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankStatement_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankStatement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankStatementDataLoader.DATALOADER_C_BankStatement_BY_ID);
		return dataLoader.load(entity.getC_BankStatement_ID());
	}


	/**
	 * Get Bank statement line.
	 *
	 * @return Line on a statement from this Bank
	 */
	public CompletableFuture<MBankStatementLine> C_BankStatementLine(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankStatementLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankStatementLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankStatementLineDataLoader.DATALOADER_C_BankStatementLine_BY_ID);
		return dataLoader.load(entity.getC_BankStatementLine_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}

	public Boolean I_IsImported(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsReversal(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		return entity.isReversal();
	}

	public Boolean Processed(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> TRXTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "62ede000-ce9c-48fd-b805-24dfa336bef6"); // Sales
			put("D", "65ae32d1-fb46-4b5c-8b6e-ca692bc9071f"); // Delayed Capture
			put("C", "3ec6abf2-3776-4bc6-b0ad-e26a805e8fa4"); // Credit (Payment)
			put("F", "fa969983-3f23-444e-bb5b-91e584657242"); // Voice Authorization
			put("A", "d70a8f1d-2bdc-4aee-b07c-831aae57eb30"); // Authorization
			put("V", "0778d779-1c5a-47eb-b68e-c94771517f0f"); // Void
		}
	};
	public CompletableFuture<MRefList_BH> TrxType(X_I_BankStatement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTrxType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TRXTYPE_UUIDS_BY_VALUE.get(entity.getTrxType()));
	}

}
