package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetChange;

/**
 * Generated Query Resolver for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_ChangeQuery extends POQuery<MAssetChange> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetChange.Table_Name;
	}

	public Connection<MAssetChange> A_Asset_ChangeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
