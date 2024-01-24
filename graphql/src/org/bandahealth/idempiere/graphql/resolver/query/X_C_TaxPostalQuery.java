package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxPostal;

/**
 * Generated Query Resolver for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxPostalQuery extends POQuery<MTaxPostal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxPostal.Table_Name;
	}

	public Connection<MTaxPostal> C_TaxPostalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
