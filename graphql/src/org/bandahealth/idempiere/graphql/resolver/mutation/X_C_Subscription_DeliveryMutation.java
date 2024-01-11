package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Subscription_DeliveryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Subscription_DeliveryInput;
import org.compiere.model.X_C_Subscription_Delivery;

import java.util.List;

/**
 * Generated Query Resolver for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Subscription_DeliveryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Subscription_DeliveryInput.Table_Name;
	}

	public X_C_Subscription_Delivery C_Subscription_DeliverySave(I_C_Subscription_DeliveryInput input, DataFetchingEnvironment environment) {
		return (X_C_Subscription_Delivery) super.save((X_C_Subscription_DeliveryInput) input, environment);
	}

	public boolean C_Subscription_DeliveryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
