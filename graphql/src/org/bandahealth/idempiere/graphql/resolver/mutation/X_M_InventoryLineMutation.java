package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryLineInput;
import org.compiere.model.MInventoryLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryLineInput.Table_Name;
	}

	public MInventoryLine M_InventoryLineSave(I_M_InventoryLineInput Entity, DataFetchingEnvironment environment) {
		return (MInventoryLine) super.save((X_M_InventoryLineInput) Entity, environment);
	}

	public List<MInventoryLine> M_InventoryLineSaveMany(List<I_M_InventoryLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_InventoryLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInventoryLine) entity).collect(Collectors.toList());
	}

	public boolean M_InventoryLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
