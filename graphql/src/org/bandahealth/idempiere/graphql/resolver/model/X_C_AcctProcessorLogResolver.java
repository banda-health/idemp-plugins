package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctProcessorDataLoader;
import org.compiere.model.MAcctProcessor;
import org.compiere.model.MAcctProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AcctProcessorLogResolver extends POResolver<MAcctProcessorLog> implements GraphQLResolver<MAcctProcessorLog> {



	/**
	 * Get Accounting Processor.
	 *
	 * @return Accounting Processor/Server Parameters
	 */
	public CompletableFuture<MAcctProcessor> C_AcctProcessor(MAcctProcessorLog entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctProcessor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctProcessor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctProcessorDataLoader.DATALOADER_C_AcctProcessor_BY_ID);
		return dataLoader.load(entity.getC_AcctProcessor_ID());
	}

	public Boolean IsError(MAcctProcessorLog entity, DataFetchingEnvironment environment) {
		return entity.isError();
	}

}
