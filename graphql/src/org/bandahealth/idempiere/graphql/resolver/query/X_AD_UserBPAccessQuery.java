package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_UserBPAccess;

/**
 * Generated Query Resolver for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserBPAccessQuery extends POQuery<X_AD_UserBPAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserBPAccess.Table_Name;
	}

	public Connection<X_AD_UserBPAccess> AD_UserBPAccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
