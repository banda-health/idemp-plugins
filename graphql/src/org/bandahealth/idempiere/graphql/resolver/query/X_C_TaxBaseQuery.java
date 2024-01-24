package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_C_TaxBase;

/**
 * Generated Query Resolver for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxBaseQuery extends POQuery<X_C_TaxBase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxBase.Table_Name;
	}

	public Connection<X_C_TaxBase> C_TaxBaseGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
