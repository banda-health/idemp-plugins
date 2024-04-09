package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopicSubscriber;

/**
 * Generated Query Resolver for C_RfQ_TopicSubscriber - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQ_TopicSubscriberQuery extends POQuery<MRfQTopicSubscriber> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopicSubscriber.Table_Name;
	}

	public Connection<MRfQTopicSubscriber> C_RfQ_TopicSubscriberGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
