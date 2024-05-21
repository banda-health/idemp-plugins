package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionGroupDataLoader;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PromotionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionLineResolver extends POResolver<X_M_PromotionLine> implements GraphQLResolver<X_M_PromotionLine> {


	public Boolean IsMandatoryPL(X_M_PromotionLine entity, DataFetchingEnvironment environment) {
		return entity.isMandatoryPL();
	}


	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	public CompletableFuture<X_M_Promotion> M_Promotion(X_M_PromotionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Promotion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_Promotion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDataLoader.DATALOADER_M_Promotion_BY_ID);
		return dataLoader.load(entity.getM_Promotion_ID());
	}


	/**
	 * Get Promotion Group.
	 *
	 * @return Promotion Group
	 */
	public CompletableFuture<X_M_PromotionGroup> M_PromotionGroup(X_M_PromotionLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_PromotionGroup_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PromotionGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionGroupDataLoader.DATALOADER_M_PromotionGroup_BY_ID);
		return dataLoader.load(entity.getM_PromotionGroup_ID());
	}

}
