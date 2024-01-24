package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPaymentProcessor;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentProcessorResolver extends POResolver<MPaymentProcessor> implements GraphQLResolver<MPaymentProcessor> {


	public Boolean AcceptAMEX(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptAMEX();
	}

	public Boolean AcceptATM(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptATM();
	}

	public Boolean AcceptCheck(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptCheck();
	}

	public Boolean AcceptCorporate(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptCorporate();
	}

	public Boolean AcceptDiners(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDiners();
	}

	public Boolean AcceptDirectDebit(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDirectDebit();
	}

	public Boolean AcceptDirectDeposit(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDirectDeposit();
	}

	public Boolean AcceptDiscover(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDiscover();
	}

	public Boolean AcceptMC(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptMC();
	}

	public Boolean AcceptVisa(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptVisa();
	}


	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	public CompletableFuture<MSequence_BH> AD_Sequence(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Sequence_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getAD_Sequence_ID());
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	public Boolean RequireVV(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		return entity.isRequireVV();
	}

	static Map<String, String> TRXTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "62ede000-ce9c-48fd-b805-24dfa336bef6");
			put("D", "65ae32d1-fb46-4b5c-8b6e-ca692bc9071f");
			put("C", "3ec6abf2-3776-4bc6-b0ad-e26a805e8fa4");
			put("F", "fa969983-3f23-444e-bb5b-91e584657242");
			put("A", "d70a8f1d-2bdc-4aee-b07c-831aae57eb30");
			put("V", "0778d779-1c5a-47eb-b68e-c94771517f0f");
		}
	};
	public CompletableFuture<MRefList_BH> TrxType(MPaymentProcessor entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTrxType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TRXTYPE_UUIDS_BY_VALUE.get(entity.getTrxType()));
	}

}
