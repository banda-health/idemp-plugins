package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_CostInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_CostInput;
import org.eevolution.model.X_PP_Order_Cost;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_CostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_CostInput.Table_Name;
	}

	public X_PP_Order_Cost PP_Order_CostSave(I_PP_Order_CostInput Entity, DataFetchingEnvironment environment) {
		return (X_PP_Order_Cost) super.save((X_PP_Order_CostInput) Entity, environment);
	}

	public List<X_PP_Order_Cost> PP_Order_CostSaveMany(List<I_PP_Order_CostInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Order_CostInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Order_Cost) entity).collect(Collectors.toList());
	}

	public boolean PP_Order_CostDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
