package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_OrderInput;
import org.eevolution.model.X_PP_Order;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_OrderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_OrderInput.Table_Name;
	}

	public X_PP_Order PP_OrderSave(I_PP_OrderInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order) super.save((X_PP_OrderInput) input, environment);
	}

	public boolean PP_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
