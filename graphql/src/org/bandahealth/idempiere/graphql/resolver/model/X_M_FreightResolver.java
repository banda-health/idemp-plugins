package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_FreightCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.compiere.model.MCountry;
import org.compiere.model.MFreight;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MRegion;
import org.compiere.model.MShipper;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_FreightResolver extends POResolver<MFreight> implements GraphQLResolver<MFreight> {



	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getC_Region_ID());
	}


	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	public CompletableFuture<MFreightCategory> M_FreightCategory(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getM_FreightCategory_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFreightCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_FreightCategoryDataLoader.DATALOADER_M_FreightCategory_BY_ID);
		return dataLoader.load(entity.getM_FreightCategory_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	public CompletableFuture<MRegion> To_Region(MFreight entity, DataFetchingEnvironment environment) {
		if (entity.getTo_Region_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getTo_Region_ID());
	}

}
