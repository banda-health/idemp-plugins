package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PromotionPreCondition;

/**
 * Generated Query Resolver for M_PromotionPreCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionPreConditionQuery extends POQuery<X_M_PromotionPreCondition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionPreCondition.Table_Name;
	}

	public Connection<X_M_PromotionPreCondition> M_PromotionPreConditionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
