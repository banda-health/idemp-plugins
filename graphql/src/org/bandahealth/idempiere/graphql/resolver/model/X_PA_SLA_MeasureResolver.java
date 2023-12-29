package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_GoalDataLoader;
import org.compiere.model.MSLAGoal;
import org.compiere.model.MSLAMeasure;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_MeasureResolver extends POResolver<MSLAMeasure> implements GraphQLResolver<MSLAMeasure> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MSLAMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get SLA Goal.
	 *
	 * @return Service Level Agreement Goal
	 */
	public CompletableFuture<MSLAGoal> PA_SLA_Goal(MSLAMeasure entity, DataFetchingEnvironment environment) {
		if (entity.getPA_SLA_Goal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSLAGoal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_SLA_GoalDataLoader.PA_SLA_Goal_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_SLA_Goal_ID());
	}

}
