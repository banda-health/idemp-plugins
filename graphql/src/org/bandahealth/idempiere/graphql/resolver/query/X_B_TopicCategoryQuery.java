package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_TopicCategory;

/**
 * Generated Query Resolver for B_TopicCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicCategoryQuery extends POQuery<X_B_TopicCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicCategory.Table_Name;
	}

	public Connection<X_B_TopicCategory> B_TopicCategoryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
