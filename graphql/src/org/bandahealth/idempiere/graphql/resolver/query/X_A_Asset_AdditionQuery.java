package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetAddition;

/**
 * Generated Query Resolver for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AdditionQuery extends POQuery<MAssetAddition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetAddition.Table_Name;
	}

	public Connection<MAssetAddition> A_Asset_AdditionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
