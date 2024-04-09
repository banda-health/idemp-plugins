package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIFixedAsset;

/**
 * Generated Query Resolver for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_FixedAssetQuery extends POQuery<MIFixedAsset> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIFixedAsset.Table_Name;
	}

	public Connection<MIFixedAsset> I_FixedAssetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
