package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionDataLoader;
import org.compiere.model.MCommission;
import org.compiere.model.MCommissionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionRunResolver extends POResolver<MCommissionRun> implements GraphQLResolver<MCommissionRun> {



	/**
	 * Get Commission.
	 *
	 * @return Commission
	 */
	public CompletableFuture<MCommission> C_Commission(MCommissionRun entity, DataFetchingEnvironment environment) {
		if (entity.getC_Commission_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCommission> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CommissionDataLoader.DATALOADER_C_Commission_BY_ID);
		return dataLoader.load(entity.getC_Commission_ID());
	}

	public Boolean Processed(MCommissionRun entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MCommissionRun entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
