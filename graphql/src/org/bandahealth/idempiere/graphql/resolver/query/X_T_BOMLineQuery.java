package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_T_BOMLine;

/**
 * Generated Query Resolver for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_BOMLineQuery extends POQuery<X_T_BOMLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BOMLine.Table_Name;
	}

	public Connection<X_T_BOMLine> T_BOMLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
