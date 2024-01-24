package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodePR;

/**
 * Generated Query Resolver for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodePRQuery extends POQuery<MTree_NodePR> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodePR.Table_Name;
	}

	public Connection<MTree_NodePR> AD_TreeNodePRGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
