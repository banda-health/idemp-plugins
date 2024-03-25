package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_C_TaxGroup;

/**
 * Generated Query Resolver for C_TaxGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxGroupQuery extends POQuery<X_C_TaxGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxGroup.Table_Name;
	}

	public Connection<X_C_TaxGroup> C_TaxGroupGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
