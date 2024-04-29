package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankAccountDocInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankAccountDocInput;
import org.compiere.model.X_C_BankAccountDoc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountDocMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountDocInput.Table_Name;
	}

	public X_C_BankAccountDoc C_BankAccountDocSave(I_C_BankAccountDocInput Entity, DataFetchingEnvironment environment) {
		return (X_C_BankAccountDoc) super.save((X_C_BankAccountDocInput) Entity, environment);
	}

	public List<X_C_BankAccountDoc> C_BankAccountDocSaveMany(List<I_C_BankAccountDocInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankAccountDocInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_BankAccountDoc) entity).collect(Collectors.toList());
	}

	public boolean C_BankAccountDocDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
