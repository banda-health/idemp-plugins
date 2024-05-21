package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementLoaderInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementLoaderInput;
import org.compiere.model.MBankStatementLoader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankStatementLoader - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankStatementLoaderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementLoaderInput.Table_Name;
	}

	public MBankStatementLoader C_BankStatementLoaderSave(I_C_BankStatementLoaderInput Entity, DataFetchingEnvironment environment) {
		return (MBankStatementLoader) super.save((X_C_BankStatementLoaderInput) Entity, environment);
	}

	public List<MBankStatementLoader> C_BankStatementLoaderSaveMany(List<I_C_BankStatementLoaderInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankStatementLoaderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankStatementLoader) entity).collect(Collectors.toList());
	}

	public boolean C_BankStatementLoaderDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
