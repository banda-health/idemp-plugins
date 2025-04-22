package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SubscriptionTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SubscriptionTypeInput;
import org.compiere.model.X_C_SubscriptionType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_SubscriptionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_SubscriptionTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SubscriptionTypeInput.Table_Name;
	}

	public X_C_SubscriptionType C_SubscriptionTypeSave(I_C_SubscriptionTypeInput Entity, DataFetchingEnvironment environment) {
		return (X_C_SubscriptionType) super.save((X_C_SubscriptionTypeInput) Entity, environment);
	}

	public List<X_C_SubscriptionType> C_SubscriptionTypeSaveMany(List<I_C_SubscriptionTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_SubscriptionTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_SubscriptionType) entity).collect(Collectors.toList());
	}

	public boolean C_SubscriptionTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
