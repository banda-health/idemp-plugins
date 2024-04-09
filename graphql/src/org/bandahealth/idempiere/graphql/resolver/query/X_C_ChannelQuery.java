package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Channel;

/**
 * Generated Query Resolver for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChannelQuery extends POQuery<X_C_Channel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Channel.Table_Name;
	}

	public Connection<X_C_Channel> C_ChannelGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
