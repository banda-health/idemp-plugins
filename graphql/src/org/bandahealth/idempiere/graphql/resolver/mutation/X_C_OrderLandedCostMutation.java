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
 * @version Release 12 - $Id$
 */
public class X_C_OrderLandedCostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderLandedCostInput.Table_Name;
	}

	public MOrderLandedCost C_OrderLandedCostSave(I_C_OrderLandedCostInput Entity, DataFetchingEnvironment environment) {
		return (MOrderLandedCost) super.save((X_C_OrderLandedCostInput) Entity, environment);
	}

	public List<MOrderLandedCost> C_OrderLandedCostSaveMany(List<I_C_OrderLandedCostInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_OrderLandedCostInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderLandedCost) entity).collect(Collectors.toList());
	}

	public boolean C_OrderLandedCostDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
