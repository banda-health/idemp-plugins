package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeInput;
import org.compiere.model.MTree_Node;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNode - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeInput.Table_Name;
	}

	public MTree_Node AD_TreeNodeSave(I_AD_TreeNodeInput entity, DataFetchingEnvironment environment) {
		return (MTree_Node) super.save((X_AD_TreeNodeInput) entity, environment);
	}

	public List<MTree_Node> AD_TreeNodeSaveMany(List<I_AD_TreeNodeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_TreeNodeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_Node) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
