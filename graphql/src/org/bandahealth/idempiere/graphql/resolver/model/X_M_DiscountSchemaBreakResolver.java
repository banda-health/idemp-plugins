package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDiscountSchemaBreak;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DiscountSchemaBreakResolver extends POResolver<MDiscountSchemaBreak> implements GraphQLResolver<MDiscountSchemaBreak> {


	public Boolean IsBPartnerFlatDiscount(MDiscountSchemaBreak entity, DataFetchingEnvironment environment) {
		return entity.isBPartnerFlatDiscount();
	}


	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MDiscountSchemaBreak entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public CompletableFuture<MProductCategory_BH> M_Product_Category(MDiscountSchemaBreak entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductCategory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_ID);
		return dataLoader.load(entity.getM_Product_Category_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MDiscountSchemaBreak entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
