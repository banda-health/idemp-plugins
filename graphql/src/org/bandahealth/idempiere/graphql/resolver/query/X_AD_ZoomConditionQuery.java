package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MZoomCondition;

/**
 * Generated Query Resolver for AD_ZoomCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ZoomConditionQuery extends POQuery<MZoomCondition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MZoomCondition.Table_Name;
	}

	public Connection<MZoomCondition> AD_ZoomConditionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
