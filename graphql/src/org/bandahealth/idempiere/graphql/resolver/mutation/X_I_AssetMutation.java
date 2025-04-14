package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_AssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_AssetInput;
import org.compiere.model.X_I_Asset;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_AssetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_AssetInput.Table_Name;
	}

	public X_I_Asset I_AssetSave(I_I_AssetInput Entity, DataFetchingEnvironment environment) {
		return (X_I_Asset) super.save((X_I_AssetInput) Entity, environment);
	}

	public List<X_I_Asset> I_AssetSaveMany(List<I_I_AssetInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_I_AssetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Asset) entity).collect(Collectors.toList());
	}

	public boolean I_AssetDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
