package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSKeyLayout;

/**
 * Generated Query Resolver for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyLayoutQuery extends POQuery<MPOSKeyLayout> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSKeyLayout.Table_Name;
	}

	public Connection<MPOSKeyLayout> C_POSKeyLayoutGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
