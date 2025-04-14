package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_I_Product_Quantity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_I_Product_QuantityResolver extends POResolver<X_BH_I_Product_Quantity> implements GraphQLResolver<X_BH_I_Product_Quantity> {


	public Boolean BH_HasExpiration(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isBH_HasExpiration();
	}

	public Boolean BH_HasLot1(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isBH_HasLot1();
	}

	public Boolean BH_HasLot2(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isBH_HasLot2();
	}

	public Boolean BH_HasLot3(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isBH_HasLot3();
	}

	public int bh_reorder_level(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.getbh_reorder_level();
	}

	public Boolean I_IsImported(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_BH_I_Product_Quantity entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
