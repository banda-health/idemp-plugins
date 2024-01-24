package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_WF_Node_AssetInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_WF_Node_AssetInput;
import org.eevolution.model.X_PP_WF_Node_Asset;

import java.util.List;
import java.util.stream.Collectors;

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

	public X_PP_WF_Node_Asset PP_WF_Node_AssetSave(I_PP_WF_Node_AssetInput entity, DataFetchingEnvironment environment) {
		return (X_PP_WF_Node_Asset) super.save((X_PP_WF_Node_AssetInput) entity, environment);
	}

	public List<X_PP_WF_Node_Asset> PP_WF_Node_AssetSaveMany(List<I_PP_WF_Node_AssetInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PP_WF_Node_AssetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_WF_Node_Asset) entity).collect(Collectors.toList());
	}

	public boolean PP_WF_Node_AssetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
