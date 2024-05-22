package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableAccess;

/**
 * Generated Query Resolver for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Table_AccessQuery extends POQuery<MTableAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableAccess.Table_Name;
	}

	public Connection<MTableAccess> AD_Table_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
