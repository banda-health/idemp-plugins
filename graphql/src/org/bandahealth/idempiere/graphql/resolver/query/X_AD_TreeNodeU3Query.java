package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TreeNodeU3;

/**
 * Generated Query Resolver for AD_TreeNodeU3 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeU3Query extends POQuery<X_AD_TreeNodeU3> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU3.Table_Name;
	}

	public Connection<X_AD_TreeNodeU3> AD_TreeNodeU3Get(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
