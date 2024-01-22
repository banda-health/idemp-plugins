package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StorageProviderInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StorageProviderInput;
import org.compiere.model.MStorageProvider;

import java.util.List;

/**
 * Generated Query Resolver for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StorageProviderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StorageProviderInput.Table_Name;
	}

	public MStorageProvider AD_StorageProviderSave(I_AD_StorageProviderInput input, DataFetchingEnvironment environment) {
		return (MStorageProvider) super.save((X_AD_StorageProviderInput) input, environment);
	}

	public boolean AD_StorageProviderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
