package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MCountry;
import org.compiere.model.MRegion;

import java.util.Arrays;
import java.util.List;

public class MCountryResolver extends X_C_CountryResolver {

	public List<MRegion> C_Regions(MCountry entity, DataFetchingEnvironment environment) {
		// Since this call caches all regions, we don't need a completable future
		return Arrays.asList(MRegion.getRegions(entity.getC_Country_ID()));
	}
}
