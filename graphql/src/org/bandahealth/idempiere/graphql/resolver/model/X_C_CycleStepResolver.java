package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CycleDataLoader;
import org.compiere.model.X_C_Cycle;
import org.compiere.model.X_C_CycleStep;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CycleStepResolver extends POResolver<X_C_CycleStep> implements GraphQLResolver<X_C_CycleStep> {



	/**
	 * Get Project Cycle.
	 *
	 * @return Identifier for this Project Reporting Cycle
	 */
	public CompletableFuture<X_C_Cycle> C_Cycle(X_C_CycleStep entity, DataFetchingEnvironment environment) {
		if (entity.getC_Cycle_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Cycle> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CycleDataLoader.DATALOADER_C_Cycle_BY_ID);
		return dataLoader.load(entity.getC_Cycle_ID());
	}

}
