package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryLineInput;

import java.util.List;

/**
 * Generated Query Resolver for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InventoryLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryLineInput.Table_Name;
	}

	public MInventoryLine_BH M_InventoryLineSave(I_M_InventoryLineInput input, DataFetchingEnvironment environment) {
		return (MInventoryLine_BH) super.save((X_M_InventoryLineInput) input, environment);
	}

	public boolean M_InventoryLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
