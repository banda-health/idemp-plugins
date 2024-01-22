package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TabInput;
import org.compiere.model.MTab;

import java.util.List;

/**
 * Generated Query Resolver for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TabInput.Table_Name;
	}

	public MTab AD_TabSave(I_AD_TabInput input, DataFetchingEnvironment environment) {
		return (MTab) super.save((X_AD_TabInput) input, environment);
	}

	public boolean AD_TabDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
