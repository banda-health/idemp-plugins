package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegion;

/**
 * Generated Query Resolver for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RegionQuery extends POQuery<MRegion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegion.Table_Name;
	}

	public Connection<MRegion> C_RegionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
