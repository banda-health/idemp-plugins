package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCountryGroup;

/**
 * Generated Query Resolver for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryGroupQuery extends POQuery<MCountryGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCountryGroup.Table_Name;
	}

	public Connection<MCountryGroup> C_CountryGroupGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
