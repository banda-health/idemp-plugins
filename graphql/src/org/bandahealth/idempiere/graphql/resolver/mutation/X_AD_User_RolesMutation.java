package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_User_RolesInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_User_RolesInput;
import org.compiere.model.MUserRoles;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_User_RolesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_RolesInput.Table_Name;
	}

	public MUserRoles AD_User_RolesSave(I_AD_User_RolesInput Entity, DataFetchingEnvironment environment) {
		return (MUserRoles) super.save((X_AD_User_RolesInput) Entity, environment);
	}

	public List<MUserRoles> AD_User_RolesSaveMany(List<I_AD_User_RolesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_User_RolesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserRoles) entity).collect(Collectors.toList());
	}

	public boolean AD_User_RolesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
