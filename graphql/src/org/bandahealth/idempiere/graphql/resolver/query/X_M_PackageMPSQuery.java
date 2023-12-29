package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageMPS;

/**
 * Generated Query Resolver for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PackageMPSQuery extends POQuery<MPackageMPS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageMPS.Table_Name;
	}

	public Connection<MPackageMPS> M_PackageMPSGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
