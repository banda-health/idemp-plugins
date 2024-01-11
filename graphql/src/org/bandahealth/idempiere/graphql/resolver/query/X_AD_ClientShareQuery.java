package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MClientShare;

/**
 * Generated Query Resolver for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientShareQuery extends POQuery<MClientShare> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MClientShare.Table_Name;
	}

	public Connection<MClientShare> AD_ClientShareGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
