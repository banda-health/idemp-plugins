package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_M_RelatedProduct;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RelatedProductResolver extends POResolver<X_M_RelatedProduct> implements GraphQLResolver<X_M_RelatedProduct> {



	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_RelatedProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Related Product.
	 *
	 * @return Related Product
	 */
	public CompletableFuture<MProduct_BH> RelatedProduct(X_M_RelatedProduct entity, DataFetchingEnvironment environment) {
		if (entity.getRelatedProduct_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getRelatedProduct_ID());
	}

	public static Map<String, String> RELATEDPRODUCTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "74f84269-bf01-4300-b855-1768c085a473"); // Web Promotion
			put("A", "f634f40c-28dc-4cdb-9e56-0318a7a65fb2"); // Alternative
			put("S", "c38a308e-5685-4c2e-b3f6-bbad06470705"); // Supplemental
		}
	};
	public CompletableFuture<MRefList_BH> RelatedProductType(X_M_RelatedProduct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRelatedProductType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(RELATEDPRODUCTTYPE_UUIDS_BY_VALUE.get(entity.getRelatedProductType()));
	}

}
