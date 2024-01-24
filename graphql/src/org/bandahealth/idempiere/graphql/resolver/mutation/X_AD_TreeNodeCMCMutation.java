package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeCMCInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeCMCInput;
import org.compiere.model.MTree_NodeCMC;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodeCMC - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMCMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMCInput.Table_Name;
	}

	public MTree_NodeCMC AD_TreeNodeCMCSave(I_AD_TreeNodeCMCInput input, DataFetchingEnvironment environment) {
		return (MTree_NodeCMC) super.save((X_AD_TreeNodeCMCInput) input, environment);
	}

	public boolean AD_TreeNodeCMCDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
