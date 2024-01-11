package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionRun;

/**
 * Generated Query Resolver for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionRunQuery extends POQuery<MCommissionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionRun.Table_Name;
	}

	public Connection<MCommissionRun> C_CommissionRunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
