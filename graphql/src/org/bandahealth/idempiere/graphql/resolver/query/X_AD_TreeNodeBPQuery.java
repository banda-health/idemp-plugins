package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeBP;

/**
 * Generated Query Resolver for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeBPQuery extends POQuery<MTree_NodeBP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeBP.Table_Name;
	}

	public Connection<MTree_NodeBP> AD_TreeNodeBPGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
