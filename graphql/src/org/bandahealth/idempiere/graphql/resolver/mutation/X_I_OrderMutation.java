package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_OrderInput;
import org.compiere.model.X_I_Order;

import java.util.List;

/**
 * Generated Query Resolver for I_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_OrderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_OrderInput.Table_Name;
	}

	public X_I_Order I_OrderSave(I_I_OrderInput input, DataFetchingEnvironment environment) {
		return (X_I_Order) super.save((X_I_OrderInput) input, environment);
	}

	public boolean I_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
