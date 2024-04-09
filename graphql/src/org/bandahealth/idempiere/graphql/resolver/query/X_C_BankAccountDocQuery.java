package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BankAccountDoc;

/**
 * Generated Query Resolver for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountDocQuery extends POQuery<X_C_BankAccountDoc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountDoc.Table_Name;
	}

	public Connection<X_C_BankAccountDoc> C_BankAccountDocGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
