package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_InventoryValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_InventoryValueInput;
import org.compiere.model.X_T_InventoryValue;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_InventoryValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_InventoryValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_InventoryValueInput.Table_Name;
	}

	public X_T_InventoryValue T_InventoryValueSave(I_T_InventoryValueInput entity, DataFetchingEnvironment environment) {
		return (X_T_InventoryValue) super.save((X_T_InventoryValueInput) entity, environment);
	}

	public List<X_T_InventoryValue> T_InventoryValueSaveMany(List<I_T_InventoryValueInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_T_InventoryValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_InventoryValue) entity).collect(Collectors.toList());
	}

	public boolean T_InventoryValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
