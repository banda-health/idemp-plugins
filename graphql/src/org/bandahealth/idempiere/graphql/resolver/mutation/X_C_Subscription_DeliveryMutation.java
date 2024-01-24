package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Subscription_DeliveryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Subscription_DeliveryInput;
import org.compiere.model.X_C_Subscription_Delivery;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Subscription_DeliveryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription_DeliveryInput.Table_Name;
	}

	public X_C_Subscription_Delivery C_Subscription_DeliverySave(I_C_Subscription_DeliveryInput entity, DataFetchingEnvironment environment) {
		return (X_C_Subscription_Delivery) super.save((X_C_Subscription_DeliveryInput) entity, environment);
	}

	public List<X_C_Subscription_Delivery> C_Subscription_DeliverySaveMany(List<I_C_Subscription_DeliveryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_Subscription_DeliveryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Subscription_Delivery) entity).collect(Collectors.toList());
	}

	public boolean C_Subscription_DeliveryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
