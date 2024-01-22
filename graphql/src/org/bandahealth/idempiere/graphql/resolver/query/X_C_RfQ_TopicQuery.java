package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQTopic;

/**
 * Generated Query Resolver for C_RfQ_Topic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQ_TopicQuery extends POQuery<MRfQTopic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQTopic.Table_Name;
	}

	public Connection<MRfQTopic> C_RfQ_TopicGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
