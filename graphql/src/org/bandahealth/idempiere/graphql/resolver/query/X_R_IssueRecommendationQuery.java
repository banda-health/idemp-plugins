package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_IssueRecommendation;

/**
 * Generated Query Resolver for R_IssueRecommendation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueRecommendationQuery extends POQuery<X_R_IssueRecommendation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueRecommendation.Table_Name;
	}

	public Connection<X_R_IssueRecommendation> R_IssueRecommendationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
