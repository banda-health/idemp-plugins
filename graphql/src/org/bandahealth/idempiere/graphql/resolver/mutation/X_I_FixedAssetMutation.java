package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_FixedAssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_FixedAssetInput;
import org.compiere.model.MIFixedAsset;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_FixedAssetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_FixedAssetInput.Table_Name;
	}

	public MIFixedAsset I_FixedAssetSave(I_I_FixedAssetInput entity, DataFetchingEnvironment environment) {
		return (MIFixedAsset) super.save((X_I_FixedAssetInput) entity, environment);
	}

	public List<MIFixedAsset> I_FixedAssetSaveMany(List<I_I_FixedAssetInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_FixedAssetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIFixedAsset) entity).collect(Collectors.toList());
	}

	public boolean I_FixedAssetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
