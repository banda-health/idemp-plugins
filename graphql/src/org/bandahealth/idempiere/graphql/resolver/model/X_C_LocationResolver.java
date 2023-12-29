package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AddressValidationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MRegion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LocationResolver extends POResolver<MLocation> implements GraphQLResolver<MLocation> {



	/**
	 * Get Address Validation.
	 *
	 * @return Address Validation
	 */
	public CompletableFuture<MAddressValidation> C_AddressValidation(MLocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_AddressValidation_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAddressValidation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AddressValidationDataLoader.C_AddressValidation_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AddressValidation_ID());
	}


	/**
	 * Get City.
	 *
	 * @return City
	 */
	public CompletableFuture<MCity> C_City(MLocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_City_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CityDataLoader.C_City_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_City_ID());
	}


	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MLocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.C_Country_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MLocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.C_Region_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Region_ID());
	}

}
