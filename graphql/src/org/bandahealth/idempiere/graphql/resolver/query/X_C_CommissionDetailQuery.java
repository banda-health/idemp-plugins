package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionDetail;

/**
 * Generated Query Resolver for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionDetailQuery extends POQuery<MCommissionDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionDetail.Table_Name;
	}

	public Connection<MCommissionDetail> C_CommissionDetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
