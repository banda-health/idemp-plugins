package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.graphql.model.input.I_BH_DefaultIncludedRoleInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_DefaultIncludedRoleInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_DefaultIncludedRoleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_DefaultIncludedRoleInput.Table_Name;
	}

	public MBHDefaultIncludedRole BH_DefaultIncludedRoleSave(I_BH_DefaultIncludedRoleInput input, DataFetchingEnvironment environment) {
		return (MBHDefaultIncludedRole) super.save((X_BH_DefaultIncludedRoleInput) input, environment);
	}

	public boolean BH_DefaultIncludedRoleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
