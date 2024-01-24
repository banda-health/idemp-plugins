package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementMatcherInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementMatcherInput;
import org.compiere.model.MBankStatementMatcher;

import java.util.List;

/**
 * Generated Query Resolver for C_BankStatementMatcher - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementMatcherMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementMatcherInput.Table_Name;
	}

	public MBankStatementMatcher C_BankStatementMatcherSave(I_C_BankStatementMatcherInput input, DataFetchingEnvironment environment) {
		return (MBankStatementMatcher) super.save((X_C_BankStatementMatcherInput) input, environment);
	}

	public boolean C_BankStatementMatcherDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
