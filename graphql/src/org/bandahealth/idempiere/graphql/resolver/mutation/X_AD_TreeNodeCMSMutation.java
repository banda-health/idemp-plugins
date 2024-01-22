package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeCMSInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeCMSInput;
import org.compiere.model.MTree_NodeCMS;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodeCMS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeCMSMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMSInput.Table_Name;
	}

	public MTree_NodeCMS AD_TreeNodeCMSSave(I_AD_TreeNodeCMSInput input, DataFetchingEnvironment environment) {
		return (MTree_NodeCMS) super.save((X_AD_TreeNodeCMSInput) input, environment);
	}

	public boolean AD_TreeNodeCMSDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
