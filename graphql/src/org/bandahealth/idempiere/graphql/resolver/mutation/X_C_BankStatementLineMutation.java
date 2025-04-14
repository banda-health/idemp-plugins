package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankStatementLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankStatementLineInput;
import org.compiere.model.MBankStatementLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankStatementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankStatementLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankStatementLineInput.Table_Name;
	}

	public MBankStatementLine C_BankStatementLineSave(I_C_BankStatementLineInput Entity, DataFetchingEnvironment environment) {
		return (MBankStatementLine) super.save((X_C_BankStatementLineInput) Entity, environment);
	}

	public List<MBankStatementLine> C_BankStatementLineSaveMany(List<I_C_BankStatementLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankStatementLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankStatementLine) entity).collect(Collectors.toList());
	}

	public boolean C_BankStatementLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
