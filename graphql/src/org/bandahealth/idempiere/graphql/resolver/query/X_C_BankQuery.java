package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBank;

/**
 * Generated Query Resolver for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankQuery extends POQuery<MBank> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBank.Table_Name;
	}

	public Connection<MBank> C_BankGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
