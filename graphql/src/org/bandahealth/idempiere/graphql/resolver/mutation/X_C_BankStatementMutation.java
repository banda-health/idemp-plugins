package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementInput;
import org.compiere.model.MBankStatement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankStatementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementInput.Table_Name;
	}

	public MBankStatement C_BankStatementSave(I_C_BankStatementInput Entity, DataFetchingEnvironment environment) {
		return (MBankStatement) super.save((X_C_BankStatementInput) Entity, environment);
	}

	public List<MBankStatement> C_BankStatementSaveMany(List<I_C_BankStatementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankStatementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankStatement) entity).collect(Collectors.toList());
	}

	public boolean C_BankStatementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
