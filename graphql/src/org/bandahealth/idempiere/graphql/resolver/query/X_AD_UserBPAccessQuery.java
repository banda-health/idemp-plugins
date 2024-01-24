package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserBPAccess;

/**
 * Generated Query Resolver for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserBPAccessQuery extends POQuery<MUserBPAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserBPAccess.Table_Name;
	}

	public Connection<MUserBPAccess> AD_UserBPAccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
