package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MClientInfo;

/**
 * Generated Query Resolver for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ClientInfoQuery extends POQuery<MClientInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MClientInfo.Table_Name;
	}

	public Connection<MClientInfo> AD_ClientInfoGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
