package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRunLine;

/**
 * Generated Query Resolver for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunLineQuery extends POQuery<MDunningRunLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRunLine.Table_Name;
	}

	public Connection<MDunningRunLine> C_DunningRunLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
