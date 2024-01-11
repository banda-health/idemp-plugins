package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_C_TaxType;

/**
 * Generated Query Resolver for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxTypeQuery extends POQuery<X_C_TaxType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxType.Table_Name;
	}

	public Connection<X_C_TaxType> C_TaxTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
