package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommission;

/**
 * Generated Query Resolver for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionQuery extends POQuery<MCommission> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommission.Table_Name;
	}

	public Connection<MCommission> C_CommissionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
