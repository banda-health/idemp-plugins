package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetGroup;

/**
 * Generated Query Resolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_GroupQuery extends POQuery<MAssetGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetGroup.Table_Name;
	}

	public Connection<MAssetGroup> A_Asset_GroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
