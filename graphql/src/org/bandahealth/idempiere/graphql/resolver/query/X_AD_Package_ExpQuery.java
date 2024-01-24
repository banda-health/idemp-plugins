package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageExp;

/**
 * Generated Query Resolver for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_ExpQuery extends POQuery<MPackageExp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageExp.Table_Name;
	}

	public Connection<MPackageExp> AD_Package_ExpGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
