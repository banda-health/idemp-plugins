package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_User_RolesInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_User_RolesInput;
import org.compiere.model.MUserRoles;

import java.util.List;

/**
 * Generated Query Resolver for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_User_RolesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_RolesInput.Table_Name;
	}

	public MUserRoles AD_User_RolesSave(I_AD_User_RolesInput input, DataFetchingEnvironment environment) {
		return (MUserRoles) super.save((X_AD_User_RolesInput) input, environment);
	}

	public boolean AD_User_RolesDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
