package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOnlineTrxHistory;

/**
 * Generated Query Resolver for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OnlineTrxHistoryQuery extends POQuery<MOnlineTrxHistory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOnlineTrxHistory.Table_Name;
	}

	public Connection<MOnlineTrxHistory> C_OnlineTrxHistoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
