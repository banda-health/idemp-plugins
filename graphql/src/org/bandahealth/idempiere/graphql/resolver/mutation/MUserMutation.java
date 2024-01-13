package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.compiere.model.PO;
import org.compiere.util.Env;

import java.util.List;
import java.util.Properties;

public class MUserMutation extends X_AD_UserMutation {
	private static final String WINDOWUUID_Manage_Users = "6b934ec2-7f45-4104-ba10-08e3ce54de7e";

	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		MUser_BH loggedInUser = new MUser_BH(idempiereProperties, Env.getAD_User_ID(idempiereProperties), null);
		MRole loggedInUserRole = new MRole(idempiereProperties, Env.getAD_Role_ID(idempiereProperties), null);
		MUser_BH castEntity = (MUser_BH) entity;
		// If they're not a system admin, the user must be themselves
		if (castEntity.getAD_User_ID() != loggedInUser.getAD_User_ID() && (!loggedInUser.isAdministrator() ||
				!loggedInUserRole.getWindowAccess(((MWindow) Repository.getByUuid(idempiereProperties, MWindow.Table_Name,
						null, WINDOWUUID_Manage_Users)).getAD_Window_ID()))) {
			return entity;
		}
		return super.save(entity, environment);
	}

	@Override
	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		MUser_BH loggedInUser = new MUser_BH(idempiereProperties, Env.getAD_User_ID(idempiereProperties), null);
		MRole loggedInUserRole = new MRole(idempiereProperties, Env.getAD_Role_ID(idempiereProperties), null);
		// This is only available to admins
		if ((!loggedInUser.isAdministrator() || !loggedInUserRole.getWindowAccess(
				((MWindow) Repository.getByUuid(idempiereProperties, MWindow.Table_Name, null,
						WINDOWUUID_Manage_Users)).getAD_Window_ID()))) {
			return true;
		}
		return super.delete(uuids, environment);
	}
}
