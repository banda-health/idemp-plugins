package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_BankStatementInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_BankStatementInput;
import org.compiere.model.X_I_BankStatement;

import java.util.List;

/**
 * Generated Query Resolver for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_BankStatementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_BankStatementInput.Table_Name;
	}

	public X_I_BankStatement I_BankStatementSave(I_I_BankStatementInput input, DataFetchingEnvironment environment) {
		return (X_I_BankStatement) super.save((X_I_BankStatementInput) input, environment);
	}

	public boolean I_BankStatementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
