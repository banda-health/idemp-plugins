package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_AssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_AssetInput;
import org.compiere.model.MAsset;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_AssetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_AssetInput.Table_Name;
	}

	public MAsset A_AssetSave(I_A_AssetInput input, DataFetchingEnvironment environment) {
		return (MAsset) super.save((X_A_AssetInput) input, environment);
	}

	public boolean A_AssetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
