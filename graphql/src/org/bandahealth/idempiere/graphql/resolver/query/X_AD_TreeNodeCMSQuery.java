package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeCMS;

/**
 * Generated Query Resolver for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeCMSQuery extends POQuery<MTree_NodeCMS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeCMS.Table_Name;
	}

	public Connection<MTree_NodeCMS> AD_TreeNodeCMSGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
