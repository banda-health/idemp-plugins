package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RevenueRecognitionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MRevenueRecognitionPlan;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognition_PlanResolver extends POResolver<MRevenueRecognitionPlan> implements GraphQLResolver<MRevenueRecognitionPlan> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_ID);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	public CompletableFuture<MRevenueRecognition> C_RevenueRecognition(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getC_RevenueRecognition_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRevenueRecognition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RevenueRecognitionDataLoader.DATALOADER_C_RevenueRecognition_BY_ID);
		return dataLoader.load(entity.getC_RevenueRecognition_ID());
	}


	/**
	 * Get Product Revenue.
	 *
	 * @return Account for Product Revenue (Sales Account)
	 */
	public CompletableFuture<MAccount> P_Revenue_A(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getP_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getP_Revenue_Acct());
	}


	/**
	 * Get Unearned Revenue.
	 *
	 * @return Account for unearned revenue
	 */
	public CompletableFuture<MAccount> UnEarnedRevenue_A(MRevenueRecognitionPlan entity, DataFetchingEnvironment environment) {
		if (entity.getUnEarnedRevenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getUnEarnedRevenue_Acct());
	}

}
