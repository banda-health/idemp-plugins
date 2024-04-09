package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_NodeNext;

/**
 * Generated Query Resolver for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_NodeNextQuery extends POQuery<X_AD_WF_NodeNext> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NodeNext.Table_Name;
	}

	public Connection<X_AD_WF_NodeNext> AD_WF_NodeNextGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
