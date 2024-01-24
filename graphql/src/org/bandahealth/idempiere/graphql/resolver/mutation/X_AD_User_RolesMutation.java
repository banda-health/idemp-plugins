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
 * @version Release 7.1 - $Id$
 */
public class X_AD_User_RolesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_RolesInput.Table_Name;
	}

	public MUserRoles AD_User_RolesSave(I_AD_User_RolesInput entity, DataFetchingEnvironment environment) {
		return (MUserRoles) super.save((X_AD_User_RolesInput) entity, environment);
	}

	public List<MUserRoles> AD_User_RolesSaveMany(List<I_AD_User_RolesInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_User_RolesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserRoles) entity).collect(Collectors.toList());
	}

	public boolean AD_User_RolesDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
