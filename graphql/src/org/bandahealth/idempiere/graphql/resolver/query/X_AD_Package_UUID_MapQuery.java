package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_UUID_Map;

/**
 * Generated Query Resolver for AD_Package_UUID_Map - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_UUID_MapQuery extends POQuery<X_AD_Package_UUID_Map> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_UUID_Map.Table_Name;
	}

	public Connection<X_AD_Package_UUID_Map> AD_Package_UUID_MapGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
