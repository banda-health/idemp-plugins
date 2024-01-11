package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRunEntry;

/**
 * Generated Query Resolver for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunEntryQuery extends POQuery<MDunningRunEntry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRunEntry.Table_Name;
	}

	public Connection<MDunningRunEntry> C_DunningRunEntryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
