package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTree_NodeMM;

/**
 * Generated Query Resolver for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeMMQuery extends POQuery<MTree_NodeMM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTree_NodeMM.Table_Name;
	}

	public Connection<MTree_NodeMM> AD_TreeNodeMMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
