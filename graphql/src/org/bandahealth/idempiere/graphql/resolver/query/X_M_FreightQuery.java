package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Freight;

/**
 * Generated Query Resolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightQuery extends POQuery<X_M_Freight> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Freight.Table_Name;
	}

	public Connection<X_M_Freight> M_FreightGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
