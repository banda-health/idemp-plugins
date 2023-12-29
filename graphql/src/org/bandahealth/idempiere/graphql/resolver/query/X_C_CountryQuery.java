package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountry;

/**
 * Generated Query Resolver for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryQuery extends POQuery<MCountry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountry.Table_Name;
	}

	public Connection<MCountry> C_CountryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
