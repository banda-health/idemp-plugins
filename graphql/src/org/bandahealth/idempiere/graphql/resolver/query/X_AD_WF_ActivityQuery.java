package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Activity;

/**
 * Generated Query Resolver for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_WF_ActivityQuery extends POQuery<X_AD_WF_Activity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Activity.Table_Name;
	}

	public Connection<X_AD_WF_Activity> AD_WF_ActivityGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
