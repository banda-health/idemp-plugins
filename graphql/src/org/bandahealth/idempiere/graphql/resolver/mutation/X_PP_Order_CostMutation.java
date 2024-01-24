package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_CostInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_CostInput;
import org.eevolution.model.X_PP_Order_Cost;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_CostMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_CostInput.Table_Name;
	}

	public X_PP_Order_Cost PP_Order_CostSave(I_PP_Order_CostInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order_Cost) super.save((X_PP_Order_CostInput) input, environment);
	}

	public boolean PP_Order_CostDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
