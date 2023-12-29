package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ActivityDataLoader;
import org.compiere.model.X_AD_WF_Activity;
import org.compiere.model.X_AD_WF_ActivityResult;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_WF_ActivityResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityResultResolver extends POResolver<X_AD_WF_ActivityResult> implements GraphQLResolver<X_AD_WF_ActivityResult> {



	/**
	 * Get Workflow Activity.
	 *
	 * @return Workflow Activity
	 */
	public CompletableFuture<X_AD_WF_Activity> AD_WF_Activity(X_AD_WF_ActivityResult entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Activity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ActivityDataLoader.AD_WF_Activity_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_WF_Activity_ID());
	}

}
