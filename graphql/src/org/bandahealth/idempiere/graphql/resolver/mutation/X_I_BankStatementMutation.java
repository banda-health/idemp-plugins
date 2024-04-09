package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_BankStatementInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_BankStatementInput;
import org.compiere.model.X_I_BankStatement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_BankStatementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_BankStatementInput.Table_Name;
	}

	public X_I_BankStatement I_BankStatementSave(I_I_BankStatementInput Entity, DataFetchingEnvironment environment) {
		return (X_I_BankStatement) super.save((X_I_BankStatementInput) Entity, environment);
	}

	public List<X_I_BankStatement> I_BankStatementSaveMany(List<I_I_BankStatementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_I_BankStatementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_BankStatement) entity).collect(Collectors.toList());
	}

	public boolean I_BankStatementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
