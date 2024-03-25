package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRun;

/**
 * Generated Query Resolver for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunQuery extends POQuery<MDunningRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRun.Table_Name;
	}

	public Connection<MDunningRun> C_DunningRunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
