package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopicSubscriberOnly;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriberOnly - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicSubscriberOnlyQuery extends POQuery<MRfQTopicSubscriberOnly> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopicSubscriberOnly.Table_Name;
	}

	public Connection<MRfQTopicSubscriberOnly> C_RfQ_TopicSubscriberOnlyGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
