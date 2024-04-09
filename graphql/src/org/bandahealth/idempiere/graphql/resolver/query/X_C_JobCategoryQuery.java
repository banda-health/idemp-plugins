package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_JobCategory;

/**
 * Generated Query Resolver for C_JobCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_JobCategoryQuery extends POQuery<X_C_JobCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_JobCategory.Table_Name;
	}

	public Connection<X_C_JobCategory> C_JobCategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
