package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_User_OrgAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_User_OrgAccessInput;
import org.compiere.model.MUserOrgAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_User_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_User_OrgAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_OrgAccessInput.Table_Name;
	}

	public MUserOrgAccess AD_User_OrgAccessSave(I_AD_User_OrgAccessInput Entity, DataFetchingEnvironment environment) {
		return (MUserOrgAccess) super.save((X_AD_User_OrgAccessInput) Entity, environment);
	}

	public List<MUserOrgAccess> AD_User_OrgAccessSaveMany(List<I_AD_User_OrgAccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_User_OrgAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserOrgAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_User_OrgAccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
