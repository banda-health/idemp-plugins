package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RecurringDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalBatchDataLoader;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MProject;
import org.compiere.model.MRecurring;
import org.compiere.model.MRecurringRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Recurring_RunResolver extends POResolver<MRecurringRun> implements GraphQLResolver<MRecurringRun> {



	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Recurring.
	 *
	 * @return Recurring Document
	 */
	public CompletableFuture<MRecurring> C_Recurring(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Recurring_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRecurring> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RecurringDataLoader.DATALOADER_C_Recurring_BY_ID);
		return dataLoader.load(entity.getC_Recurring_ID());
	}


	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	public CompletableFuture<MJournalBatch> GL_JournalBatch(MRecurringRun entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalBatch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MJournalBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalBatchDataLoader.DATALOADER_GL_JournalBatch_BY_ID);
		return dataLoader.load(entity.getGL_JournalBatch_ID());
	}

}
