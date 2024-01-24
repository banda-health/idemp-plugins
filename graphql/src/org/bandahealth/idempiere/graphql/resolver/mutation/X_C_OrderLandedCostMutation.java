package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderLandedCostInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderLandedCostInput;
import org.compiere.model.MOrderLandedCost;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderLandedCostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderLandedCostInput.Table_Name;
	}

	public MOrderLandedCost C_OrderLandedCostSave(I_C_OrderLandedCostInput entity, DataFetchingEnvironment environment) {
		return (MOrderLandedCost) super.save((X_C_OrderLandedCostInput) entity, environment);
	}

	public List<MOrderLandedCost> C_OrderLandedCostSaveMany(List<I_C_OrderLandedCostInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OrderLandedCostInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderLandedCost) entity).collect(Collectors.toList());
	}

	public boolean C_OrderLandedCostDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
