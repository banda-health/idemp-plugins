package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Topic;

/**
 * Generated Query Resolver for B_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_TopicQuery extends POQuery<X_B_Topic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Topic.Table_Name;
	}

	public Connection<X_B_Topic> B_TopicGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
