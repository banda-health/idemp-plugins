package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderInput.Table_Name;
	}

	public MOrder_BH C_OrderSave(I_C_OrderInput entity, DataFetchingEnvironment environment) {
		return (MOrder_BH) super.save((X_C_OrderInput) entity, environment);
	}

	public List<MOrder_BH> C_OrderSaveMany(List<I_C_OrderInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OrderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrder_BH) entity).collect(Collectors.toList());
	}

	public boolean C_OrderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
