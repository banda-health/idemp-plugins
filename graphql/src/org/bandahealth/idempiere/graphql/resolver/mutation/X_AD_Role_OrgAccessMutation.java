package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Role_OrgAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Role_OrgAccessInput;
import org.compiere.model.MRoleOrgAccess;

import java.util.List;

/**
 * Generated Query Resolver for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Role_OrgAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Role_OrgAccessInput.Table_Name;
	}

	public MRoleOrgAccess AD_Role_OrgAccessSave(I_AD_Role_OrgAccessInput input, DataFetchingEnvironment environment) {
		return (MRoleOrgAccess) super.save((X_AD_Role_OrgAccessInput) input, environment);
	}

	public boolean AD_Role_OrgAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
