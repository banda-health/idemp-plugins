package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxDeclarationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxDeclarationInput;
import org.compiere.model.MTaxDeclaration;

import java.util.List;

/**
 * Generated Query Resolver for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDeclarationInput.Table_Name;
	}

	public MTaxDeclaration C_TaxDeclarationSave(I_C_TaxDeclarationInput input, DataFetchingEnvironment environment) {
		return (MTaxDeclaration) super.save((X_C_TaxDeclarationInput) input, environment);
	}

	public boolean C_TaxDeclarationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
