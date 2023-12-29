package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.compiere.model.MCountry;
import org.compiere.model.MRegion;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RegionResolver extends POResolver<MRegion> implements GraphQLResolver<MRegion> {



	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MRegion entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.C_Country_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Country_ID());
	}

}
