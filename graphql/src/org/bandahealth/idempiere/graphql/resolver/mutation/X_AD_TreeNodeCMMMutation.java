package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeCMMInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeCMMInput;
import org.compiere.model.X_AD_TreeNodeCMM;

import java.util.List;

/**
 * Generated Query Resolver for AD_TreeNodeCMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeCMMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeCMMInput.Table_Name;
	}

	public X_AD_TreeNodeCMM AD_TreeNodeCMMSave(I_AD_TreeNodeCMMInput input, DataFetchingEnvironment environment) {
		return (X_AD_TreeNodeCMM) super.save((X_AD_TreeNodeCMMInput) input, environment);
	}

	public boolean AD_TreeNodeCMMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
