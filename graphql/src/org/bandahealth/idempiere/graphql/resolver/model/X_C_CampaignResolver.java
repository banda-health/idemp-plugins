package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChannelDataLoader;
import org.compiere.model.MCampaign;
import org.compiere.model.X_C_Channel;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignResolver extends POResolver<MCampaign> implements GraphQLResolver<MCampaign> {



	/**
	 * Get Channel.
	 *
	 * @return Sales Channel
	 */
	public CompletableFuture<X_C_Channel> C_Channel(MCampaign entity, DataFetchingEnvironment environment) {
		if (entity.getC_Channel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Channel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChannelDataLoader.C_Channel_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Channel_ID());
	}

}
