package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TaskInstanceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TaskInstanceInput;
import org.compiere.model.X_AD_TaskInstance;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TaskInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TaskInstanceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TaskInstanceInput.Table_Name;
	}

	public X_AD_TaskInstance AD_TaskInstanceSave(I_AD_TaskInstanceInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_TaskInstance) super.save((X_AD_TaskInstanceInput) Entity, environment);
	}

	public List<X_AD_TaskInstance> AD_TaskInstanceSaveMany(List<I_AD_TaskInstanceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TaskInstanceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_TaskInstance) entity).collect(Collectors.toList());
	}

	public boolean AD_TaskInstanceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
