package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeCMC;

/**
 * Generated Query Resolver for AD_TreeNodeCMC - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMCQuery extends POQuery<MTree_NodeCMC> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeCMC.Table_Name;
	}

	public Connection<MTree_NodeCMC> AD_TreeNodeCMCGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
