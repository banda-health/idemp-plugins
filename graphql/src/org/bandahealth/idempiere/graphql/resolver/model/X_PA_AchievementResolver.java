package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_MeasureDataLoader;
import org.compiere.model.MAchievement;
import org.compiere.model.MMeasure;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_AchievementResolver extends POResolver<MAchievement> implements GraphQLResolver<MAchievement> {


	public Boolean IsAchieved(MAchievement entity, DataFetchingEnvironment environment) {
		return entity.isAchieved();
	}


	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	public CompletableFuture<MMeasure> PA_Measure(MAchievement entity, DataFetchingEnvironment environment) {
		if (entity.getPA_Measure_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMeasure> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_MeasureDataLoader.DATALOADER_PA_Measure_BY_ID);
		return dataLoader.load(entity.getPA_Measure_ID());
	}

}
