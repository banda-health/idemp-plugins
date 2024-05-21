package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ProcessInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ProcessInput.Table_Name;
	}

	public MProcess_BH AD_ProcessSave(I_AD_ProcessInput Entity, DataFetchingEnvironment environment) {
		return (MProcess_BH) super.save((X_AD_ProcessInput) Entity, environment);
	}

	public List<MProcess_BH> AD_ProcessSaveMany(List<I_AD_ProcessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ProcessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProcess_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_ProcessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
