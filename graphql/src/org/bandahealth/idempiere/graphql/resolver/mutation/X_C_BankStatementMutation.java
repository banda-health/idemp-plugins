package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementInput;
import org.compiere.model.MBankStatement;

import java.util.List;

/**
 * Generated Query Resolver for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementInput.Table_Name;
	}

	public MBankStatement C_BankStatementSave(I_C_BankStatementInput input, DataFetchingEnvironment environment) {
		return (MBankStatement) super.save((X_C_BankStatementInput) input, environment);
	}

	public boolean C_BankStatementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
