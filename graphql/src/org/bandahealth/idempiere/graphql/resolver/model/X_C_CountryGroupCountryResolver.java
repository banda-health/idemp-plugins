package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryGroupDataLoader;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MCountryGroupCountry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CountryGroupCountryResolver extends POResolver<MCountryGroupCountry> implements GraphQLResolver<MCountryGroupCountry> {



	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MCountryGroupCountry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Country Group.
	 *
	 * @return Country Group
	 */
	public CompletableFuture<MCountryGroup> C_CountryGroup(MCountryGroupCountry entity, DataFetchingEnvironment environment) {
		if (entity.getC_CountryGroup_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCountryGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryGroupDataLoader.DATALOADER_C_CountryGroup_BY_ID);
		return dataLoader.load(entity.getC_CountryGroup_ID());
	}

}
