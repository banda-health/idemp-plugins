package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SubscriptionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SubscriptionInput;
import org.compiere.model.X_C_Subscription;

import java.util.List;

/**
 * Generated Query Resolver for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubscriptionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SubscriptionInput.Table_Name;
	}

	public X_C_Subscription C_SubscriptionSave(I_C_SubscriptionInput input, DataFetchingEnvironment environment) {
		return (X_C_Subscription) super.save((X_C_SubscriptionInput) input, environment);
	}

	public boolean C_SubscriptionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
