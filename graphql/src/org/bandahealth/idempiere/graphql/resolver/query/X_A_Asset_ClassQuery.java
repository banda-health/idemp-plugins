package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetClass;

/**
 * Generated Query Resolver for A_Asset_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_ClassQuery extends POQuery<MAssetClass> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetClass.Table_Name;
	}

	public Connection<MAssetClass> A_Asset_ClassGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
