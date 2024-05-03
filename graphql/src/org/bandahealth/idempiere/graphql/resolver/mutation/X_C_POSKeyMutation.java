package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSKeyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSKeyInput;
import org.compiere.model.MPOSKey;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSKeyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSKeyInput.Table_Name;
	}

	public MPOSKey C_POSKeySave(I_C_POSKeyInput Entity, DataFetchingEnvironment environment) {
		return (MPOSKey) super.save((X_C_POSKeyInput) Entity, environment);
	}

	public List<MPOSKey> C_POSKeySaveMany(List<I_C_POSKeyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_POSKeyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPOSKey) entity).collect(Collectors.toList());
	}

	public boolean C_POSKeyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
