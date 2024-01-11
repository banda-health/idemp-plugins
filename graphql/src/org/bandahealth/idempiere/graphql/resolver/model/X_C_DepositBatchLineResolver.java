package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DepositBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MDepositBatchLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DepositBatchLineResolver extends POResolver<MDepositBatchLine> implements GraphQLResolver<MDepositBatchLine> {



	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	public CompletableFuture<MDepositBatch> C_DepositBatch(MDepositBatchLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_DepositBatch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDepositBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DepositBatchDataLoader.C_DepositBatch_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_DepositBatch_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MDepositBatchLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.C_Payment_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Payment_ID());
	}

	public Boolean Processed(MDepositBatchLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MDepositBatchLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
