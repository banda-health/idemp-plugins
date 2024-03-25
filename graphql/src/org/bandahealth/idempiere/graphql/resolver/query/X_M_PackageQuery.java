package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackage;

/**
 * Generated Query Resolver for M_Package - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageQuery extends POQuery<MPackage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackage.Table_Name;
	}

	public Connection<MPackage> M_PackageGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
