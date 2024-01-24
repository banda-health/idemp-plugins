package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetUse;

/**
 * Generated Query Resolver for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_UseQuery extends POQuery<MAssetUse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetUse.Table_Name;
	}

	public Connection<MAssetUse> A_Asset_UseGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
