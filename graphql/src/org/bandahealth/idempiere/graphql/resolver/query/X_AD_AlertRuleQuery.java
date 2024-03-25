package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertRule;

/**
 * Generated Query Resolver for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertRuleQuery extends POQuery<MAlertRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertRule.Table_Name;
	}

	public Connection<MAlertRule> AD_AlertRuleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
