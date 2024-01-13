package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningRunEntryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoicePayScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.compiere.model.MDunningRunEntry;
import org.compiere.model.MDunningRunLine;
import org.compiere.model.MInvoicePaySchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunLineResolver extends POResolver<MDunningRunLine> implements GraphQLResolver<MDunningRunLine> {



	/**
	 * Get Dunning Run Entry.
	 *
	 * @return Dunning Run Entry
	 */
	public CompletableFuture<MDunningRunEntry> C_DunningRunEntry(MDunningRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_DunningRunEntry_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunningRunEntry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningRunEntryDataLoader.DATALOADER_C_DunningRunEntry_BY_ID);
		return dataLoader.load(entity.getC_DunningRunEntry_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MDunningRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Invoice Payment Schedule.
	 *
	 * @return Invoice Payment Schedule
	 */
	public CompletableFuture<MInvoicePaySchedule> C_InvoicePaySchedule(MDunningRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoicePaySchedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoicePaySchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoicePayScheduleDataLoader.DATALOADER_C_InvoicePaySchedule_BY_ID);
		return dataLoader.load(entity.getC_InvoicePaySchedule_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MDunningRunLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}

	public Boolean IsInDispute(MDunningRunLine entity, DataFetchingEnvironment environment) {
		return entity.isInDispute();
	}

	public Boolean Processed(MDunningRunLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
