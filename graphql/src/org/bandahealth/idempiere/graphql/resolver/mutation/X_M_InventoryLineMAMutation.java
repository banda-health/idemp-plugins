package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryLineMAInput;
import org.compiere.model.MInventoryLineMA;

import java.util.List;

/**
 * Generated Query Resolver for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryLineMAInput.Table_Name;
	}

	public MInventoryLineMA M_InventoryLineMASave(I_M_InventoryLineMAInput input, DataFetchingEnvironment environment) {
		return (MInventoryLineMA) super.save((X_M_InventoryLineMAInput) input, environment);
	}

	public boolean M_InventoryLineMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
