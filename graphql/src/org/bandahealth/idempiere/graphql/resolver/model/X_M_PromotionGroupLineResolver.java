package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionGroupDataLoader;
import org.compiere.model.X_M_PromotionGroup;
import org.compiere.model.X_M_PromotionGroupLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PromotionGroupLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionGroupLineResolver extends POResolver<X_M_PromotionGroupLine> implements GraphQLResolver<X_M_PromotionGroupLine> {



	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_PromotionGroupLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Promotion Group.
	 *
	 * @return Promotion Group
	 */
	public CompletableFuture<X_M_PromotionGroup> M_PromotionGroup(X_M_PromotionGroupLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_PromotionGroup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_M_PromotionGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionGroupDataLoader.DATALOADER_M_PromotionGroup_BY_ID);
		return dataLoader.load(entity.getM_PromotionGroup_ID());
	}

}
