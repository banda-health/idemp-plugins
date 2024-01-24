package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankAccountDocInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankAccountDocInput;
import org.compiere.model.X_C_BankAccountDoc;

import java.util.List;

/**
 * Generated Query Resolver for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountDocMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountDocInput.Table_Name;
	}

	public X_C_BankAccountDoc C_BankAccountDocSave(I_C_BankAccountDocInput input, DataFetchingEnvironment environment) {
		return (X_C_BankAccountDoc) super.save((X_C_BankAccountDocInput) input, environment);
	}

	public boolean C_BankAccountDocDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
