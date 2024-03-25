package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetType;

/**
 * Generated Query Resolver for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_TypeQuery extends POQuery<MAssetType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetType.Table_Name;
	}

	public Connection<MAssetType> A_Asset_TypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
