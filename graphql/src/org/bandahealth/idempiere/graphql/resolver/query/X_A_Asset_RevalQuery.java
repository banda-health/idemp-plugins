package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetReval;

/**
 * Generated Query Resolver for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_RevalQuery extends POQuery<MAssetReval> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetReval.Table_Name;
	}

	public Connection<MAssetReval> A_Asset_RevalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
