package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MRegion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CityResolver extends POResolver<MCity> implements GraphQLResolver<MCity> {



	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MCity entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MCity entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getC_Region_ID());
	}

}
