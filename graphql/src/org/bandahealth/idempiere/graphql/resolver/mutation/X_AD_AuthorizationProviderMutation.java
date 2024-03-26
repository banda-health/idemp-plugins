package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AuthorizationProviderInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AuthorizationProviderInput;
import org.compiere.model.MAuthorizationProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationProviderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AuthorizationProviderInput.Table_Name;
	}

	public MAuthorizationProvider AD_AuthorizationProviderSave(I_AD_AuthorizationProviderInput entity, DataFetchingEnvironment environment) {
		return (MAuthorizationProvider) super.save((X_AD_AuthorizationProviderInput) entity, environment);
	}

	public List<MAuthorizationProvider> AD_AuthorizationProviderSaveMany(List<I_AD_AuthorizationProviderInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_AuthorizationProviderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAuthorizationProvider) entity).collect(Collectors.toList());
	}

	public boolean AD_AuthorizationProviderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
