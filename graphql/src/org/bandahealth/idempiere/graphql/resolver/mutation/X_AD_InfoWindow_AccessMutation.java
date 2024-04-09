package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoWindow_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoWindow_AccessInput;
import org.compiere.model.MInfoWindowAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_InfoWindow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoWindow_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoWindow_AccessInput.Table_Name;
	}

	public MInfoWindowAccess AD_InfoWindow_AccessSave(I_AD_InfoWindow_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MInfoWindowAccess) super.save((X_AD_InfoWindow_AccessInput) Entity, environment);
	}

	public List<MInfoWindowAccess> AD_InfoWindow_AccessSaveMany(List<I_AD_InfoWindow_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_InfoWindow_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInfoWindowAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoWindow_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
