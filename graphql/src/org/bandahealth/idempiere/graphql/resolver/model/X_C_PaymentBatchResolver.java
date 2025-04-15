package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.compiere.model.MPaymentBatch;
import org.compiere.model.MPaymentProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentBatchResolver extends POResolver<MPaymentBatch> implements GraphQLResolver<MPaymentBatch> {



	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(MPaymentBatch entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentProcessor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPaymentProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentProcessorDataLoader.DATALOADER_C_PaymentProcessor_BY_ID);
		return dataLoader.load(entity.getC_PaymentProcessor_ID());
	}

	public Boolean Processed(MPaymentBatch entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MPaymentBatch entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
