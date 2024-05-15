package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAsset;

/**
 * Generated Query Resolver for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_AssetQuery extends POQuery<MAsset> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAsset.Table_Name;
	}

	public Connection<MAsset> A_AssetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
