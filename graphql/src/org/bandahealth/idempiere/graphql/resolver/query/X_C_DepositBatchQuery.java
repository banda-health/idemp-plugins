package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepositBatch;

/**
 * Generated Query Resolver for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DepositBatchQuery extends POQuery<MDepositBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepositBatch.Table_Name;
	}

	public Connection<MDepositBatch> C_DepositBatchGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
