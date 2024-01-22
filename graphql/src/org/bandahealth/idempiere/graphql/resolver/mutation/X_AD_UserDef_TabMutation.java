package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUserDefTab_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_TabInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserDef_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_TabInput.Table_Name;
	}

	public MUserDefTab_BH AD_UserDef_TabSave(I_AD_UserDef_TabInput input, DataFetchingEnvironment environment) {
		return (MUserDefTab_BH) super.save((X_AD_UserDef_TabInput) input, environment);
	}

	public boolean AD_UserDef_TabDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
