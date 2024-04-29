package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceList_VersionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductPriceResolver extends POResolver<MProductPrice_BH> implements GraphQLResolver<MProductPrice_BH> {



	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	public CompletableFuture<MPriceListVersion> M_PriceList_Version(MProductPrice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_Version_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceListVersion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceList_VersionDataLoader.DATALOADER_M_PriceList_Version_BY_ID);
		return dataLoader.load(entity.getM_PriceList_Version_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProductPrice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
