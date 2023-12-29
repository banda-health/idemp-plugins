package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetReval;

/**
 * Generated Query Resolver for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RevalQuery extends POQuery<MAssetReval> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetReval.Table_Name;
	}

	public Connection<MAssetReval> A_Asset_RevalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
