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
 * @version Release 13 - $Id$
 */
public class X_AD_TreeNodeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeInput.Table_Name;
	}

	public MTree_Node AD_TreeNodeSave(I_AD_TreeNodeInput Entity, DataFetchingEnvironment environment) {
		return (MTree_Node) super.save((X_AD_TreeNodeInput) Entity, environment);
	}

	public List<MTree_Node> AD_TreeNodeSaveMany(List<I_AD_TreeNodeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TreeNodeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_Node) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
