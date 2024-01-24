package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSKeyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSKeyInput;
import org.compiere.model.MPOSKey;

import java.util.List;

/**
 * Generated Query Resolver for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSKeyInput.Table_Name;
	}

	public MPOSKey C_POSKeySave(I_C_POSKeyInput input, DataFetchingEnvironment environment) {
		return (MPOSKey) super.save((X_C_POSKeyInput) input, environment);
	}

	public boolean C_POSKeyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
