package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommission;

/**
 * Generated Query Resolver for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionQuery extends POQuery<MCommission> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommission.Table_Name;
	}

	public Connection<MCommission> C_CommissionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
