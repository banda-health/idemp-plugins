package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AuthorizationCredentialInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AuthorizationCredentialInput;
import org.compiere.model.MAuthorizationCredential;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AuthorizationCredentialMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AuthorizationCredentialInput.Table_Name;
	}

	public MAuthorizationCredential AD_AuthorizationCredentialSave(I_AD_AuthorizationCredentialInput Entity, DataFetchingEnvironment environment) {
		return (MAuthorizationCredential) super.save((X_AD_AuthorizationCredentialInput) Entity, environment);
	}

	public List<MAuthorizationCredential> AD_AuthorizationCredentialSaveMany(List<I_AD_AuthorizationCredentialInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AuthorizationCredentialInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAuthorizationCredential) entity).collect(Collectors.toList());
	}

	public boolean AD_AuthorizationCredentialDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
