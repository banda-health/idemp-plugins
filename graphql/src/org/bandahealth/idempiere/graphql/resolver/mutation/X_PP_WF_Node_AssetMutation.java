package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_WF_Node_AssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_WF_Node_AssetInput;
import org.eevolution.model.X_PP_WF_Node_Asset;

import java.util.List;

/**
 * Generated Query Resolver for PP_WF_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_WF_Node_AssetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_WF_Node_AssetInput.Table_Name;
	}

	public X_PP_WF_Node_Asset PP_WF_Node_AssetSave(I_PP_WF_Node_AssetInput input, DataFetchingEnvironment environment) {
		return (X_PP_WF_Node_Asset) super.save((X_PP_WF_Node_AssetInput) input, environment);
	}

	public boolean PP_WF_Node_AssetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
