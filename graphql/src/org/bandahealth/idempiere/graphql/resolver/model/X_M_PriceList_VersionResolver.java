package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceList_VersionDataLoader;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PriceList_VersionResolver extends POResolver<MPriceListVersion> implements GraphQLResolver<MPriceListVersion> {



	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MPriceListVersion entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.M_DiscountSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MPriceListVersion entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get Base Price List.
	 *
	 * @return Source for Price list calculations
	 */
	public CompletableFuture<MPriceListVersion> M_Pricelist_Version_Base(MPriceListVersion entity, DataFetchingEnvironment environment) {
		if (entity.getM_Pricelist_Version_Base_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceListVersion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceList_VersionDataLoader.M_PriceList_Version_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Pricelist_Version_Base_ID());
	}

}
