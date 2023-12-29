package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_FixedAssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_FixedAssetInput;
import org.compiere.model.MIFixedAsset;

import java.util.List;

/**
 * Generated Query Resolver for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_FixedAssetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_FixedAssetInput.Table_Name;
	}

	public MIFixedAsset I_FixedAssetSave(I_I_FixedAssetInput input, DataFetchingEnvironment environment) {
		return (MIFixedAsset) super.save((X_I_FixedAssetInput) input, environment);
	}

	public boolean I_FixedAssetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
