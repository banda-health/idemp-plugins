package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFactReconciliation;

/**
 * Generated Query Resolver for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_ReconciliationQuery extends POQuery<MFactReconciliation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFactReconciliation.Table_Name;
	}

	public Connection<MFactReconciliation> Fact_ReconciliationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
