package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionLine;

/**
 * Generated Query Resolver for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CommissionLineQuery extends POQuery<MCommissionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionLine.Table_Name;
	}

	public Connection<MCommissionLine> C_CommissionLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
