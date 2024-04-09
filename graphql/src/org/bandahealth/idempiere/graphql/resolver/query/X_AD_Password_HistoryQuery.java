package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPasswordHistory;

/**
 * Generated Query Resolver for AD_Password_History - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Password_HistoryQuery extends POQuery<MPasswordHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPasswordHistory.Table_Name;
	}

	public Connection<MPasswordHistory> AD_Password_HistoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
