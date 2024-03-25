package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPasswordRule;

/**
 * Generated Query Resolver for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PasswordRuleQuery extends POQuery<MPasswordRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPasswordRule.Table_Name;
	}

	public Connection<MPasswordRule> AD_PasswordRuleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
