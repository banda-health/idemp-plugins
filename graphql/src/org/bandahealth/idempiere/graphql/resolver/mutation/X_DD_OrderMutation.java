package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_DD_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_DD_OrderInput;
import org.eevolution.model.MDDOrder;

import java.util.List;
import java.util.stream.Collectors;

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

	public MDDOrder DD_OrderSave(I_DD_OrderInput entity, DataFetchingEnvironment environment) {
		return (MDDOrder) super.save((X_DD_OrderInput) entity, environment);
	}

	public List<MDDOrder> DD_OrderSaveMany(List<I_DD_OrderInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_DD_OrderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDDOrder) entity).collect(Collectors.toList());
	}

	public boolean DD_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
