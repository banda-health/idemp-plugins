package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ValidCombinationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ValidCombinationInput;
import org.compiere.model.MAccount;

import java.util.List;

/**
 * Generated Query Resolver for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ValidCombinationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ValidCombinationInput.Table_Name;
	}

	public MAccount C_ValidCombinationSave(I_C_ValidCombinationInput input, DataFetchingEnvironment environment) {
		return (MAccount) super.save((X_C_ValidCombinationInput) input, environment);
	}

	public boolean C_ValidCombinationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
