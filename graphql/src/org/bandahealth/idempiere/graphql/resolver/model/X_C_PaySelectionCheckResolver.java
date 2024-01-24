package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MPaySelection;
import org.compiere.model.MPaySelectionCheck;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaySelectionCheckResolver extends POResolver<MPaySelectionCheck> implements GraphQLResolver<MPaySelectionCheck> {



	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	public CompletableFuture<MBPBankAccount> C_BP_BankAccount(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPBankAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_BankAccountDataLoader.DATALOADER_C_BP_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BP_BankAccount_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	public CompletableFuture<MPaySelection> C_PaySelection(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySelection_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaySelection> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaySelectionDataLoader.DATALOADER_C_PaySelection_BY_ID);
		return dataLoader.load(entity.getC_PaySelection_ID());
	}

	public Boolean IsGeneratedDraft(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		return entity.isGeneratedDraft();
	}

	public Boolean IsPrinted(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsReceipt(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		return entity.isReceipt();
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Processed(MPaySelectionCheck entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
