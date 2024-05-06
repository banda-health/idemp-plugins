package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunningRunEntry;

/**
 * Generated Query Resolver for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunEntryQuery extends POQuery<MDunningRunEntry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunningRunEntry.Table_Name;
	}

	public Connection<MDunningRunEntry> C_DunningRunEntryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
