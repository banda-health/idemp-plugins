package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeCMSInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeCMSInput;
import org.compiere.model.MTree_NodeCMS;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeCMSMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMSInput.Table_Name;
	}

	public MTree_NodeCMS AD_TreeNodeCMSSave(I_AD_TreeNodeCMSInput Entity, DataFetchingEnvironment environment) {
		return (MTree_NodeCMS) super.save((X_AD_TreeNodeCMSInput) Entity, environment);
	}

	public List<MTree_NodeCMS> AD_TreeNodeCMSSaveMany(List<I_AD_TreeNodeCMSInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TreeNodeCMSInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_NodeCMS) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeCMSDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
