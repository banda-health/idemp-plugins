package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankAccountProcessor;

/**
 * Generated Query Resolver for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BankAccount_ProcessorQuery extends POQuery<MBankAccountProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankAccountProcessor.Table_Name;
	}

	public Connection<MBankAccountProcessor> C_BankAccount_ProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
