package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_T_MRP_CRP;

/**
 * Generated Query Resolver for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_MRP_CRPQuery extends POQuery<X_T_MRP_CRP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_MRP_CRP.Table_Name;
	}

	public Connection<X_T_MRP_CRP> T_MRP_CRPGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
