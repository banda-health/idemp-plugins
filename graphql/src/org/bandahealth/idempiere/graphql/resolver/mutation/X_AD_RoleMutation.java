package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RoleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RoleInput;
import org.compiere.model.X_AD_Role;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RoleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RoleInput.Table_Name;
	}

	public X_AD_Role AD_RoleSave(I_AD_RoleInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Role) super.save((X_AD_RoleInput) entity, environment);
	}

	public List<X_AD_Role> AD_RoleSaveMany(List<I_AD_RoleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_RoleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Role) entity).collect(Collectors.toList());
	}

	public boolean AD_RoleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
