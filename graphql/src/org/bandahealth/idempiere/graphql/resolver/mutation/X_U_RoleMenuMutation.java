package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_RoleMenuInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_RoleMenuInput;
import org.compiere.model.X_U_RoleMenu;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_RoleMenuMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_RoleMenuInput.Table_Name;
	}

	public X_U_RoleMenu U_RoleMenuSave(I_U_RoleMenuInput Entity, DataFetchingEnvironment environment) {
		return (X_U_RoleMenu) super.save((X_U_RoleMenuInput) Entity, environment);
	}

	public List<X_U_RoleMenu> U_RoleMenuSaveMany(List<I_U_RoleMenuInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_U_RoleMenuInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_U_RoleMenu) entity).collect(Collectors.toList());
	}

	public boolean U_RoleMenuDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
