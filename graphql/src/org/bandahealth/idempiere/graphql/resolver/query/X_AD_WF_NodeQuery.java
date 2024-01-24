package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Node;

/**
 * Generated Query Resolver for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NodeQuery extends POQuery<X_AD_WF_Node> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Node.Table_Name;
	}

	public Connection<X_AD_WF_Node> AD_WF_NodeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
