package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountryGroupCountry;

/**
 * Generated Query Resolver for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryGroupCountryQuery extends POQuery<MCountryGroupCountry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountryGroupCountry.Table_Name;
	}

	public Connection<MCountryGroupCountry> C_CountryGroupCountryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
