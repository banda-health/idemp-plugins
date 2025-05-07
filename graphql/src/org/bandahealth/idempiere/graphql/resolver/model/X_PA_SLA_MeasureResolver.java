package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_GoalDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.X_PA_SLA_Goal;
import org.compiere.model.X_PA_SLA_Measure;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_MeasureResolver extends POResolver<X_PA_SLA_Measure> implements GraphQLResolver<X_PA_SLA_Measure> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_PA_SLA_Measure entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get SLA Goal.
	 *
	 * @return Service Level Agreement Goal
	 */
	public CompletableFuture<X_PA_SLA_Goal> PA_SLA_Goal(X_PA_SLA_Measure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_SLA_Goal_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PA_SLA_Goal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_SLA_GoalDataLoader.DATALOADER_PA_SLA_Goal_BY_ID);
		return dataLoader.load(entity.getPA_SLA_Goal_ID());
	}

	public Boolean Processed(X_PA_SLA_Measure entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_PA_SLA_Measure entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
