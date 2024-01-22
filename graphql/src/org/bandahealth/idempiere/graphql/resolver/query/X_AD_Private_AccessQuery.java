package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPrivateAccess;

/**
 * Generated Query Resolver for AD_Private_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Private_AccessQuery extends POQuery<MPrivateAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPrivateAccess.Table_Name;
	}

	public Connection<MPrivateAccess> AD_Private_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
