package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SubscriptionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SubscriptionInput;
import org.compiere.model.X_C_Subscription;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_SubscriptionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SubscriptionInput.Table_Name;
	}

	public X_C_Subscription C_SubscriptionSave(I_C_SubscriptionInput Entity, DataFetchingEnvironment environment) {
		return (X_C_Subscription) super.save((X_C_SubscriptionInput) Entity, environment);
	}

	public List<X_C_Subscription> C_SubscriptionSaveMany(List<I_C_SubscriptionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_SubscriptionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Subscription) entity).collect(Collectors.toList());
	}

	public boolean C_SubscriptionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
