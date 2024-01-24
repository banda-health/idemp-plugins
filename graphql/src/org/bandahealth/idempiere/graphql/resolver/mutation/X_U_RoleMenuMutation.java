package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_RoleMenuInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_RoleMenuInput;
import org.compiere.model.MRoleMenu;

import java.util.List;

/**
 * Generated Query Resolver for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_RoleMenuMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_RoleMenuInput.Table_Name;
	}

	public MRoleMenu U_RoleMenuSave(I_U_RoleMenuInput input, DataFetchingEnvironment environment) {
		return (MRoleMenu) super.save((X_U_RoleMenuInput) input, environment);
	}

	public boolean U_RoleMenuDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
