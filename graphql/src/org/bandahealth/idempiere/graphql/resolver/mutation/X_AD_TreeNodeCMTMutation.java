package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeCMTInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeCMTInput;
import org.compiere.model.X_AD_TreeNodeCMT;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodeCMT - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeCMTMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMTInput.Table_Name;
	}

	public X_AD_TreeNodeCMT AD_TreeNodeCMTSave(I_AD_TreeNodeCMTInput input, DataFetchingEnvironment environment) {
		return (X_AD_TreeNodeCMT) super.save((X_AD_TreeNodeCMTInput) input, environment);
	}

	public boolean AD_TreeNodeCMTDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
