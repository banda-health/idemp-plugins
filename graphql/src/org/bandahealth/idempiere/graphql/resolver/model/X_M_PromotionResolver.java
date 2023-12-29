package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.compiere.model.MCampaign;
import org.compiere.model.X_M_Promotion;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_Promotion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionResolver extends POResolver<X_M_Promotion> implements GraphQLResolver<X_M_Promotion> {



	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(X_M_Promotion entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.C_Campaign_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Campaign_ID());
	}

}
