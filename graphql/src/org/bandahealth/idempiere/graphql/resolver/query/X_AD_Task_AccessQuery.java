package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaskAccess;

/**
 * Generated Query Resolver for AD_Task_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Task_AccessQuery extends POQuery<MTaskAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaskAccess.Table_Name;
	}

	public Connection<MTaskAccess> AD_Task_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
