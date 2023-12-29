package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureDataLoader;
import org.compiere.model.MAchievement;
import org.compiere.model.MMeasure;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_AchievementResolver extends POResolver<MAchievement> implements GraphQLResolver<MAchievement> {



	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	public CompletableFuture<MMeasure> PA_Measure(MAchievement entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Measure_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMeasure> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_MeasureDataLoader.PA_Measure_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_Measure_ID());
	}

}
