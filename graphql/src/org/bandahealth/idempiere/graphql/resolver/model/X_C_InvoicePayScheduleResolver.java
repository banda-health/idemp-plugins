package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PayScheduleDataLoader;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MPaySchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoicePayScheduleResolver extends POResolver<MInvoicePaySchedule> implements GraphQLResolver<MInvoicePaySchedule> {



	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MInvoicePaySchedule entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment Schedule.
	 *
	 * @return Payment Schedule Template
	 */
	public CompletableFuture<MPaySchedule> C_PaySchedule(MInvoicePaySchedule entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySchedule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPaySchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PayScheduleDataLoader.DATALOADER_C_PaySchedule_BY_ID);
		return dataLoader.load(entity.getC_PaySchedule_ID());
	}

	public Boolean IsValid(MInvoicePaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

	public Boolean Processed(MInvoicePaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MInvoicePaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
