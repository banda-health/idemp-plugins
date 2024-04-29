package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodePRInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodePRInput;
import org.compiere.model.MTree_NodePR;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodePRMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodePRInput.Table_Name;
	}

	public MTree_NodePR AD_TreeNodePRSave(I_AD_TreeNodePRInput Entity, DataFetchingEnvironment environment) {
		return (MTree_NodePR) super.save((X_AD_TreeNodePRInput) Entity, environment);
	}

	public List<MTree_NodePR> AD_TreeNodePRSaveMany(List<I_AD_TreeNodePRInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TreeNodePRInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_NodePR) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodePRDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
