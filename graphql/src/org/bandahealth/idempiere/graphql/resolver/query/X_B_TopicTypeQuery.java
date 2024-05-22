package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_TopicType;

/**
 * Generated Query Resolver for B_TopicType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicTypeQuery extends POQuery<X_B_TopicType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_TopicType.Table_Name;
	}

	public Connection<X_B_TopicType> B_TopicTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
