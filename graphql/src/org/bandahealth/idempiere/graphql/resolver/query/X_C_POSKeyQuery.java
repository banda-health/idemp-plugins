package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSKey;

/**
 * Generated Query Resolver for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSKeyQuery extends POQuery<MPOSKey> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSKey.Table_Name;
	}

	public Connection<MPOSKey> C_POSKeyGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
