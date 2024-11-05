package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MLot;
import org.compiere.model.MLotCtl;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LotResolver extends POResolver<MLot> implements GraphQLResolver<MLot> {



	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	public CompletableFuture<MLotCtl> M_LotCtl(MLot entity, DataFetchingEnvironment environment) {
		if (entity.getM_LotCtl_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLotCtl> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LotCtlDataLoader.DATALOADER_M_LotCtl_BY_ID);
		return dataLoader.load(entity.getM_LotCtl_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MLot entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
