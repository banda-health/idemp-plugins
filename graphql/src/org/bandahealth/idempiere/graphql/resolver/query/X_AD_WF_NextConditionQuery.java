package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_NextCondition;

/**
 * Generated Query Resolver for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_NextConditionQuery extends POQuery<X_AD_WF_NextCondition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NextCondition.Table_Name;
	}

	public Connection<X_AD_WF_NextCondition> AD_WF_NextConditionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
