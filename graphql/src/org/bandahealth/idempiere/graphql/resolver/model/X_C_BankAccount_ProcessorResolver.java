package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.compiere.model.MBankAccountProcessor;
import org.compiere.model.MPaymentProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccount_ProcessorResolver extends POResolver<MBankAccountProcessor> implements GraphQLResolver<MBankAccountProcessor> {


	public Boolean AcceptAMEX(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptAMEX();
	}

	public Boolean AcceptATM(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptATM();
	}

	public Boolean AcceptCheck(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptCheck();
	}

	public Boolean AcceptCorporate(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptCorporate();
	}

	public Boolean AcceptDiners(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDiners();
	}

	public Boolean AcceptDirectDebit(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDirectDebit();
	}

	public Boolean AcceptDirectDeposit(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDirectDeposit();
	}

	public Boolean AcceptDiscover(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptDiscover();
	}

	public Boolean AcceptMC(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptMC();
	}

	public Boolean AcceptVisa(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isAcceptVisa();
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentProcessor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentProcessorDataLoader.DATALOADER_C_PaymentProcessor_BY_ID);
		return dataLoader.load(entity.getC_PaymentProcessor_ID());
	}

	public Boolean IsPPAcceptAMEX(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptAMEX();
	}

	public Boolean IsPPAcceptATM(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptATM();
	}

	public Boolean IsPPAcceptCheck(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptCheck();
	}

	public Boolean IsPPAcceptCorporate(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptCorporate();
	}

	public Boolean IsPPAcceptDiners(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptDiners();
	}

	public Boolean IsPPAcceptDirectDebit(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptDirectDebit();
	}

	public Boolean IsPPAcceptDirectDeposit(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptDirectDeposit();
	}

	public Boolean IsPPAcceptDiscover(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptDiscover();
	}

	public Boolean IsPPAcceptMC(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptMC();
	}

	public Boolean IsPPAcceptVisa(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isPPAcceptVisa();
	}

	public Boolean RequireVV(MBankAccountProcessor entity, DataFetchingEnvironment environment) {
		return entity.isRequireVV();
	}

}
