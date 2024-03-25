package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTransaction;

/**
 * Generated Query Resolver for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_TransactionQuery extends POQuery<MTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTransaction.Table_Name;
	}

	public Connection<MTransaction> M_TransactionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
