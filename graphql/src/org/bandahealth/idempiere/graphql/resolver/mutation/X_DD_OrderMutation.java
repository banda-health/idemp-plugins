package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_OrderInput;
import org.eevolution.model.MDDOrder;

import java.util.List;

/**
 * Generated Query Resolver for DD_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_DD_OrderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_DD_OrderInput.Table_Name;
	}

	public MDDOrder DD_OrderSave(I_DD_OrderInput input, DataFetchingEnvironment environment) {
		return (MDDOrder) super.save((X_DD_OrderInput) input, environment);
	}

	public boolean DD_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
