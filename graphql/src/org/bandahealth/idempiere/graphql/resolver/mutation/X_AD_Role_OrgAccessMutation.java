package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Role_OrgAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Role_OrgAccessInput;
import org.compiere.model.MRoleOrgAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Role_OrgAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Role_OrgAccessInput.Table_Name;
	}

	public MRoleOrgAccess AD_Role_OrgAccessSave(I_AD_Role_OrgAccessInput entity, DataFetchingEnvironment environment) {
		return (MRoleOrgAccess) super.save((X_AD_Role_OrgAccessInput) entity, environment);
	}

	public List<MRoleOrgAccess> AD_Role_OrgAccessSaveMany(List<I_AD_Role_OrgAccessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Role_OrgAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRoleOrgAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Role_OrgAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
