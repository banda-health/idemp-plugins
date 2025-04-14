package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.graphql.model.input.I_BH_DefaultIncludedRoleInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_DefaultIncludedRoleInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_DefaultIncludedRoleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_DefaultIncludedRoleInput.Table_Name;
	}

	public MBHDefaultIncludedRole BH_DefaultIncludedRoleSave(I_BH_DefaultIncludedRoleInput Entity, DataFetchingEnvironment environment) {
		return (MBHDefaultIncludedRole) super.save((X_BH_DefaultIncludedRoleInput) Entity, environment);
	}

	public List<MBHDefaultIncludedRole> BH_DefaultIncludedRoleSaveMany(List<I_BH_DefaultIncludedRoleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_DefaultIncludedRoleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHDefaultIncludedRole) entity).collect(Collectors.toList());
	}

	public boolean BH_DefaultIncludedRoleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
