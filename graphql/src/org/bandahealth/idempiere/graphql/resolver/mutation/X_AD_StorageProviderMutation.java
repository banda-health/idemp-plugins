package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StorageProviderInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StorageProviderInput;
import org.compiere.model.MStorageProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_StorageProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_StorageProviderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StorageProviderInput.Table_Name;
	}

	public MStorageProvider AD_StorageProviderSave(I_AD_StorageProviderInput Entity, DataFetchingEnvironment environment) {
		return (MStorageProvider) super.save((X_AD_StorageProviderInput) Entity, environment);
	}

	public List<MStorageProvider> AD_StorageProviderSaveMany(List<I_AD_StorageProviderInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_StorageProviderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStorageProvider) entity).collect(Collectors.toList());
	}

	public boolean AD_StorageProviderDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
