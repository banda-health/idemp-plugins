package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintGraph;

/**
 * Generated Query Resolver for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintGraphQuery extends POQuery<X_AD_PrintGraph> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintGraph.Table_Name;
	}

	public Connection<X_AD_PrintGraph> AD_PrintGraphGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
