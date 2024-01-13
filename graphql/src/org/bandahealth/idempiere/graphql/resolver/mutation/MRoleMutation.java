package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RoleInput;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.util.Properties;

public class MRoleMutation extends X_AD_RoleMutation {
	@Override
	public X_AD_Role AD_RoleSave(I_AD_RoleInput input, DataFetchingEnvironment environment) {
		X_AD_Role savedRole =  super.AD_RoleSave(input, environment);

		// If the role doesn't have access to the organization, we need to grant it
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		MOrg organizationForClient =
				new Query(idempiereContext, MOrg.Table_Name, MOrg.COLUMNNAME_AD_Client_ID + "=?", null).setParameters(
						Env.getAD_Client_ID(idempiereContext)).setOnlyActiveRecords(true).first();
		//
		MRole role = new MRole(idempiereContext, savedRole.getAD_Role_ID(), null);
		if (!role.isOrgAccess(organizationForClient.getAD_Org_ID(), true)) {
			MRoleOrgAccess roleOrganizationAccess = new Query(idempiereContext, MRoleOrgAccess.Table_Name,
					MRoleOrgAccess.COLUMNNAME_AD_Role_ID + "=? AND " + MRoleOrgAccess.COLUMNNAME_AD_Org_ID + "=?",
					null).setParameters(savedRole.getAD_Role_ID(), organizationForClient.get_ID()).first();
			if (roleOrganizationAccess == null) {
				roleOrganizationAccess = new MRoleOrgAccess(role, organizationForClient.getAD_Org_ID());
			}
			roleOrganizationAccess.setIsReadOnly(false);
			roleOrganizationAccess.setIsActive(true);
			roleOrganizationAccess.saveEx();
		}

		return savedRole;
	}
}
