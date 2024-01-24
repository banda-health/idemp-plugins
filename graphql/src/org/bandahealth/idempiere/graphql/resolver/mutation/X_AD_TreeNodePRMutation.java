package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodePRInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodePRInput;
import org.compiere.model.MTree_NodePR;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodePR - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodePRMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodePRInput.Table_Name;
	}

	public MTree_NodePR AD_TreeNodePRSave(I_AD_TreeNodePRInput input, DataFetchingEnvironment environment) {
		return (MTree_NodePR) super.save((X_AD_TreeNodePRInput) input, environment);
	}

	public boolean AD_TreeNodePRDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
