package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_StorageOnHandInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_StorageOnHandInput;
import org.compiere.model.MStorageOnHand;

import java.util.List;

/**
 * Generated Query Resolver for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_StorageOnHandMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_StorageOnHandInput.Table_Name;
	}

	public MStorageOnHand M_StorageOnHandSave(I_M_StorageOnHandInput input, DataFetchingEnvironment environment) {
		return (MStorageOnHand) super.save((X_M_StorageOnHandInput) input, environment);
	}

	public boolean M_StorageOnHandDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
