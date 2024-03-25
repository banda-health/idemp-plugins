package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_DemandLine;

/**
 * Generated Query Resolver for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DemandLineQuery extends POQuery<X_M_DemandLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandLine.Table_Name;
	}

	public Connection<X_M_DemandLine> M_DemandLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
