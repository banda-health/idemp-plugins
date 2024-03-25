package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_BroadcastMessage;

/**
 * Generated Query Resolver for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_BroadcastMessageQuery extends POQuery<X_AD_BroadcastMessage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_BroadcastMessage.Table_Name;
	}

	public Connection<X_AD_BroadcastMessage> AD_BroadcastMessageGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
