package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_StorageOnHandInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_StorageOnHandInput;
import org.compiere.model.MStorageOnHand;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_StorageOnHandMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_StorageOnHandInput.Table_Name;
	}

	public MStorageOnHand M_StorageOnHandSave(I_M_StorageOnHandInput entity, DataFetchingEnvironment environment) {
		return (MStorageOnHand) super.save((X_M_StorageOnHandInput) entity, environment);
	}

	public List<MStorageOnHand> M_StorageOnHandSaveMany(List<I_M_StorageOnHandInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_StorageOnHandInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStorageOnHand) entity).collect(Collectors.toList());
	}

	public boolean M_StorageOnHandDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
