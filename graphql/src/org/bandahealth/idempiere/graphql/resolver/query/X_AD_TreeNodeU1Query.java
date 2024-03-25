package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TreeNodeU1;

/**
 * Generated Query Resolver for AD_TreeNodeU1 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeU1Query extends POQuery<X_AD_TreeNodeU1> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU1.Table_Name;
	}

	public Connection<X_AD_TreeNodeU1> AD_TreeNodeU1Get(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
