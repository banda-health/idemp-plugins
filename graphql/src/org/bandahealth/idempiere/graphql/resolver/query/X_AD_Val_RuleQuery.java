package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MValRule;

/**
 * Generated Query Resolver for AD_Val_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Val_RuleQuery extends POQuery<MValRule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MValRule.Table_Name;
	}

	public Connection<MValRule> AD_Val_RuleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
