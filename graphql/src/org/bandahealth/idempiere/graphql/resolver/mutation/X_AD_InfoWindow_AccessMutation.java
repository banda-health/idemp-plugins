package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoWindow_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoWindow_AccessInput;
import org.compiere.model.MInfoWindowAccess;

import java.util.List;

/**
 * Generated Query Resolver for AD_InfoWindow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoWindow_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoWindow_AccessInput.Table_Name;
	}

	public MInfoWindowAccess AD_InfoWindow_AccessSave(I_AD_InfoWindow_AccessInput input, DataFetchingEnvironment environment) {
		return (MInfoWindowAccess) super.save((X_AD_InfoWindow_AccessInput) input, environment);
	}

	public boolean AD_InfoWindow_AccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
