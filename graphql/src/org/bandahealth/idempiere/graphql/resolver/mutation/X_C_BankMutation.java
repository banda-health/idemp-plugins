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
 * @version Release 8.2 - $Id$
 */
public class X_C_BankMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankInput.Table_Name;
	}

	public MBank C_BankSave(I_C_BankInput entity, DataFetchingEnvironment environment) {
		return (MBank) super.save((X_C_BankInput) entity, environment);
	}

	public List<MBank> C_BankSaveMany(List<I_C_BankInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_BankInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBank) entity).collect(Collectors.toList());
	}

	public boolean C_BankDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
