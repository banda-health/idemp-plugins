package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_BankRegister;

/**
 * Generated Query Resolver for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BankRegisterQuery extends POQuery<X_T_BankRegister> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BankRegister.Table_Name;
	}

	public Connection<X_T_BankRegister> T_BankRegisterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
