package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class RoleOrganizationAccessDBService extends BaseDBService<BaseMetadata, MRoleOrgAccess> {
	@Override
	public BaseMetadata saveEntity(BaseMetadata entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithDefaultFields(MRoleOrgAccess instance) {
		throw new NotImplementedException();
	}

	@Override
	protected BaseMetadata createInstanceWithAllFields(MRoleOrgAccess instance) {
		throw new NotImplementedException();
	}

	@Override
	protected MRoleOrgAccess getModelInstance() {
		throw new NotImplementedException();
	}

	public void giveRoleAccessToOrganizationOfLoggedInClient(MRole role) {
		// If the role doesn't have access to the organization, we need to grant it
		MOrg organizationForClient =
				new Query(Env.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Client_ID + "=?", null).setParameters(
						Env.getAD_Client_ID(Env.getCtx())).setOnlyActiveRecords(true).first();
		if (!role.isOrgAccess(organizationForClient.getAD_Org_ID(), true)) {
			MRoleOrgAccess roleOrganizationAccess = new Query(Env.getCtx(), MRoleOrgAccess.Table_Name,
					MRoleOrgAccess.COLUMNNAME_AD_Role_ID + "=? AND " + MRoleOrgAccess.COLUMNNAME_AD_Org_ID + "=?",
					null).setParameters(role.getAD_Role_ID(), organizationForClient.get_ID()).first();
			if (roleOrganizationAccess == null) {
				roleOrganizationAccess = new MRoleOrgAccess(role, organizationForClient.getAD_Org_ID());
			}
			roleOrganizationAccess.setIsReadOnly(false);
			roleOrganizationAccess.setIsActive(true);
			roleOrganizationAccess.saveEx();
		}
	}
}
