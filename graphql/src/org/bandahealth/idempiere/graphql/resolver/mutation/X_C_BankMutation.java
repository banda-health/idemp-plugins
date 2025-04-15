package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankInput;
import org.compiere.model.MBank;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankInput.Table_Name;
	}

	public MBank C_BankSave(I_C_BankInput Entity, DataFetchingEnvironment environment) {
		return (MBank) super.save((X_C_BankInput) Entity, environment);
	}

	public List<MBank> C_BankSaveMany(List<I_C_BankInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBank) entity).collect(Collectors.toList());
	}

	public boolean C_BankDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
