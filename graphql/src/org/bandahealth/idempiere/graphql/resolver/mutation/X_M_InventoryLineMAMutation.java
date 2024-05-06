package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryLineMAInput;
import org.compiere.model.MInventoryLineMA;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryLineMAInput.Table_Name;
	}

	public MInventoryLineMA M_InventoryLineMASave(I_M_InventoryLineMAInput Entity, DataFetchingEnvironment environment) {
		return (MInventoryLineMA) super.save((X_M_InventoryLineMAInput) Entity, environment);
	}

	public List<MInventoryLineMA> M_InventoryLineMASaveMany(List<I_M_InventoryLineMAInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_InventoryLineMAInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInventoryLineMA) entity).collect(Collectors.toList());
	}

	public boolean M_InventoryLineMADelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
