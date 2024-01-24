package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.model.input.I_BH_TabNavBtn_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_TabNavBtn_TabInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_TabNavBtn_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_TabNavBtn_TabInput.Table_Name;
	}

	public MTabNavBtnTab BH_TabNavBtn_TabSave(I_BH_TabNavBtn_TabInput input, DataFetchingEnvironment environment) {
		return (MTabNavBtnTab) super.save((X_BH_TabNavBtn_TabInput) input, environment);
	}

	public boolean BH_TabNavBtn_TabDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
