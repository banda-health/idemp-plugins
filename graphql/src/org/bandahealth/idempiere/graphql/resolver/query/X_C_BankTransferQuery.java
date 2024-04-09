package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankTransfer;

/**
 * Generated Query Resolver for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankTransferQuery extends POQuery<MBankTransfer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankTransfer.Table_Name;
	}

	public Connection<MBankTransfer> C_BankTransferGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
