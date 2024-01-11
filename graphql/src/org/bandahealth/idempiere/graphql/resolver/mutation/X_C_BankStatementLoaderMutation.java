package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementLoaderInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementLoaderInput;
import org.compiere.model.MBankStatementLoader;

import java.util.List;

/**
 * Generated Query Resolver for C_BankStatementLoader - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementLoaderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementLoaderInput.Table_Name;
	}

	public MBankStatementLoader C_BankStatementLoaderSave(I_C_BankStatementLoaderInput input, DataFetchingEnvironment environment) {
		return (MBankStatementLoader) super.save((X_C_BankStatementLoaderInput) input, environment);
	}

	public boolean C_BankStatementLoaderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
