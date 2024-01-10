package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for AD_Window_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Window_AccessQuery extends POQuery<MWindowAccess_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWindowAccess_BH.Table_Name;
	}

	public Connection<MWindowAccess_BH> AD_Window_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
