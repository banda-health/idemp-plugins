package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepositBatchLine;

/**
 * Generated Query Resolver for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DepositBatchLineQuery extends POQuery<MDepositBatchLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepositBatchLine.Table_Name;
	}

	public Connection<MDepositBatchLine> C_DepositBatchLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
