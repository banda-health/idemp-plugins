package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetDisposed;

/**
 * Generated Query Resolver for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_DisposedQuery extends POQuery<MAssetDisposed> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetDisposed.Table_Name;
	}

	public Connection<MAssetDisposed> A_Asset_DisposedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
