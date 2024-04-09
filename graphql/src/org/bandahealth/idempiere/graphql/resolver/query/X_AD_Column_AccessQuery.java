package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColumnAccess;

/**
 * Generated Query Resolver for AD_Column_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Column_AccessQuery extends POQuery<MColumnAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColumnAccess.Table_Name;
	}

	public Connection<MColumnAccess> AD_Column_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
