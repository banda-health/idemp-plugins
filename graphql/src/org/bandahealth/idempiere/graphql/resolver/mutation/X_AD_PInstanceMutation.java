package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PInstanceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PInstanceInput;
import org.compiere.model.MPInstance;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PInstanceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PInstanceInput.Table_Name;
	}

	public MPInstance AD_PInstanceSave(I_AD_PInstanceInput entity, DataFetchingEnvironment environment) {
		return (MPInstance) super.save((X_AD_PInstanceInput) entity, environment);
	}

	public List<MPInstance> AD_PInstanceSaveMany(List<I_AD_PInstanceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PInstanceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPInstance) entity).collect(Collectors.toList());
	}

	public boolean AD_PInstanceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
