package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOS;

/**
 * Generated Query Resolver for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSQuery extends POQuery<MPOS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOS.Table_Name;
	}

	public Connection<MPOS> C_POSGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
