package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageLine;

/**
 * Generated Query Resolver for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PackageLineQuery extends POQuery<MPackageLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageLine.Table_Name;
	}

	public Connection<MPackageLine> M_PackageLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
