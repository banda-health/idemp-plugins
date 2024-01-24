package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_TabInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_TabInput;
import org.compiere.model.MUserDefTab;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_TabMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_TabInput.Table_Name;
	}

	public MUserDefTab AD_UserDef_TabSave(I_AD_UserDef_TabInput entity, DataFetchingEnvironment environment) {
		return (MUserDefTab) super.save((X_AD_UserDef_TabInput) entity, environment);
	}

	public List<MUserDefTab> AD_UserDef_TabSaveMany(List<I_AD_UserDef_TabInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserDef_TabInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefTab) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_TabDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
