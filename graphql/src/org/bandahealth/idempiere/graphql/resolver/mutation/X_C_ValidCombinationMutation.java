package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ValidCombinationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ValidCombinationInput;
import org.compiere.model.MAccount;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ValidCombinationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ValidCombinationInput.Table_Name;
	}

	public MAccount C_ValidCombinationSave(I_C_ValidCombinationInput Entity, DataFetchingEnvironment environment) {
		return (MAccount) super.save((X_C_ValidCombinationInput) Entity, environment);
	}

	public List<MAccount> C_ValidCombinationSaveMany(List<I_C_ValidCombinationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ValidCombinationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAccount) entity).collect(Collectors.toList());
	}

	public boolean C_ValidCombinationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
