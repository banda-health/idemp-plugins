package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_OrderInput;
import org.compiere.model.X_I_Order;

import java.util.List;
import java.util.stream.Collectors;

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

	public X_I_Order I_OrderSave(I_I_OrderInput entity, DataFetchingEnvironment environment) {
		return (X_I_Order) super.save((X_I_OrderInput) entity, environment);
	}

	public List<X_I_Order> I_OrderSaveMany(List<I_I_OrderInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_OrderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Order) entity).collect(Collectors.toList());
	}

	public boolean I_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
