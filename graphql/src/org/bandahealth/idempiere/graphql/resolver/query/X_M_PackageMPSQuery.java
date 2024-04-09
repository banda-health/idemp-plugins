package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageMPS;

/**
 * Generated Query Resolver for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PackageMPSQuery extends POQuery<MPackageMPS> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageMPS.Table_Name;
	}

	public Connection<MPackageMPS> M_PackageMPSGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
