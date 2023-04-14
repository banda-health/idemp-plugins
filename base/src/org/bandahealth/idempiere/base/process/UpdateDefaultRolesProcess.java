package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * This is responsible for updating existing clients with changes made to the default roles
 */
public class UpdateDefaultRolesProcess extends SvrProcess {
	public static final String PARAMETERNAME_AD_REF_LIST_ID = "ad_ref_list_id";
	public static final String PARAMETERNAME_UPDATE_EXISTING = "updateexisting";

	private int referenceListId;
	private boolean updateExistingClients;
	private int usersClientId;

	@Override
	protected void prepare() {
		usersClientId = getAD_Client_ID();

		ProcessInfoParameter[] parameters = getParameter();
		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase(PARAMETERNAME_AD_REF_LIST_ID)) {
				referenceListId = parameter.getParameterAsInt();
			} else if (parameterName.equalsIgnoreCase(PARAMETERNAME_UPDATE_EXISTING)) {
				updateExistingClients = parameter.getParameterAsBoolean();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}

	}

	@Override
	protected String doIt() throws Exception {
		// Get all clients in the system with IDs greater than 999999
		List<MClient> clients =
				new Query(getCtx(), MClient.Table_Name, MClient.COLUMNNAME_AD_Client_ID + ">?", get_TrxName()).setParameters(
						MClient_BH.CLIENTID_LAST_SYSTEM).setOnlyActiveRecords(true).list();
		MRefList defaultRoleReferenceList =
				new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_ID + "=?", get_TrxName())
						.setParameters(referenceListId).first();

		// Get the admin users because we'll need to add any new roles to those users
		Map<Integer, List<MUser_BH>> adminUsersByClientId = getAdminUsersForClients(clients);

		// Get the associated roles for this client; if the roles don't exist, add them; if they do exist and we're
		// supposed to update them, do so
		List<MRole> rolesToUpdate = getClientRolesBySuffix(clients, MBandaSetup.getRoleName("",
				defaultRoleReferenceList.getName()));

		// Get all the organizations for these clients
		List<MOrg> organizations = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Client_ID + " IN (" +
				clients.stream().map(client -> Integer.toString(client.getAD_Client_ID())).collect(Collectors.joining(",")) +
				")", get_TrxName()).list();
		Map<Integer, List<MOrg>> organizationsByClient =
				organizations.stream().collect(Collectors.groupingBy(MOrg::getAD_Client_ID));

		// There should only be one of these roles per client, but maybe not
		Map<Integer, List<MRole>> rolesToUpdateByClientId =
				rolesToUpdate.stream().collect(Collectors.groupingBy(MRole::getAD_Client_ID));
		clients.forEach(client -> {
			setClientId(client.getAD_Client_ID());
			MBandaSetup bandaSetup = new MBandaSetup(getCtx(), client, null);
			try {
				bandaSetup.start();
				Map<MRefList, MRole> rolesToConfigure = new HashMap<>();
				boolean wasNewRoleCreated = false;
				// If the client doesn't have any roles, we need to create them
				if (!rolesToUpdateByClientId.containsKey(client.getAD_Client_ID())) {
					// Get the organization for this client, which will never be null
					List<MOrg> clientsOrganizations = organizationsByClient.get(client.getAD_Client_ID());
					List<MUser_BH> usersNeedingRoles = adminUsersByClientId.containsKey(client.getAD_Client_ID()) ?
							adminUsersByClientId.get(client.getAD_Client_ID()) : new ArrayList<>();
					// We need to add this role to the client
					String roleName = MBandaSetup.getRoleName(client.getName(), defaultRoleReferenceList.getName());
					if (!bandaSetup.createRole(roleName, usersNeedingRoles, clientsOrganizations)) {
						rollback(bandaSetup);
						throw new AdempiereException(Msg.getMsg(getCtx(), "Adding roles failed"));
					}

					// Now that the role has been created, we need to set them so they can be updated
					// NOTE: We have to use the Banda setup transaction since the role was created within it's transaction
					MRole newRoleForClient =
							new Query(getCtx(), MRole.Table_Name,
									MRole.COLUMNNAME_AD_Client_ID + "=? AND " + MRole.COLUMNNAME_Name + "= ?",
									bandaSetup.getTransactionName())
									.setParameters(client.getAD_Client_ID(), roleName)
									.setOrderBy(MRole.COLUMNNAME_Created + " ASC").first();
					rolesToConfigure.put(defaultRoleReferenceList, newRoleForClient);

					wasNewRoleCreated = true;
				} else {
					rolesToConfigure.put(defaultRoleReferenceList, rolesToUpdateByClientId.get(client.getAD_Client_ID()).get(0));
				}

				// Now update the roles
				if ((wasNewRoleCreated || updateExistingClients) && !bandaSetup.updateRoles(rolesToConfigure)) {
					rollback(bandaSetup);
					throw new AdempiereException(Msg.getMsg(getCtx(), "Updating roles failed"));
				}
				if (!bandaSetup.finish()) {
					rollback(bandaSetup);
					throw new AdempiereException(Msg.getMsg(getCtx(), "Failed to save role updates"));
				}
			} catch (Exception e) {
				rollback(bandaSetup);
				throw e;
			}
		});

		resetClientId();
		return null;
	}

	private void rollback(MBandaSetup bandaSetup) {
		resetClientId();
		bandaSetup.rollback();
	}

	private void setClientId(int clientId) {
		getProcessInfo().setAD_Client_ID(clientId);
		Env.setContext(getCtx(), Env.AD_CLIENT_ID, clientId);
	}

	private void resetClientId() {
		getProcessInfo().setAD_Client_ID(usersClientId);
		Env.setContext(getCtx(), Env.AD_CLIENT_ID, usersClientId);
	}

	/**
	 * Get the admin users for the clients
	 *
	 * @param clients A list of clients to get the admin users for
	 * @return A map of the admin user by the client ID the user is for
	 */
	private Map<Integer, List<MUser_BH>> getAdminUsersForClients(List<MClient> clients) {
		// Get the admin reference list to help in fetching the admin roles
		MRefList adminReferenceList =
				new Query(getCtx(), MRefList.Table_Name, MRefList.Table_Name + "." + MRefList.COLUMNNAME_Value + "=? AND" +
						" " + MReference_BH.Table_Name + "." + MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
						.addJoinClause(" JOIN " + MReference_BH.Table_Name + " ON " + MReference_BH.Table_Name + "." +
								MReference_BH.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "." +
								MRefList.COLUMNNAME_AD_Reference_ID)
						.setParameters(MBandaSetup.DB_USERTYPE_Admin, MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();

		// If the admin reference list doesn't exist, there's a big problem...
		if (adminReferenceList == null) {
			throw new AdempiereException("Admin role suffix (a reference list) not found in system");
		}

		// Now get the admin roles
		List<MRole> adminRoles = getClientRolesBySuffix(clients, MBandaSetup.getRoleName("",
				adminReferenceList.getName()));

		// There may be multiple roles for a client that are suffixed with the adminReferenceList value, so get the one
		// that was created first
		Map<Integer, MRole> adminRolesByClientId =
				adminRoles.stream().collect(Collectors.groupingBy(MRole::getAD_Client_ID)).entrySet().stream().collect(
						Collectors.toMap(Map.Entry::getKey, adminRolesForClient -> adminRolesForClient.getValue().get(0)));

		// Get all users assigned the admin role
		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil
				.getWhereClauseAndSetParametersForSet(adminRolesByClientId.values().stream().map(MRole::getAD_Role_ID).collect(
						Collectors.toSet()), parameters);
		List<MUser_BH> usersAssignedAdminRoles = new Query(getCtx(), MUser_BH.Table_Name,
				MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_Role_ID + " IN (" + whereClause + ")", get_TrxName())
				.addJoinClause(
						" JOIN " + MUserRoles.Table_Name + " ON " + MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID +
								"=" + MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID).setParameters(parameters).list();

		// The first user created for each client is the admin user we need
		return usersAssignedAdminRoles.stream().collect(Collectors.groupingBy(MUser_BH::getAD_Client_ID));
	}

	/**
	 * Gets roles for all clients by checking client name and the role name together
	 *
	 * @param roleSuffix The role name to check for after a client's name
	 * @return All roles that are assigned to the client matching that role suffix
	 */
	private List<MRole> getClientRolesBySuffix(List<MClient> clients, String roleSuffix) {
		return new Query(getCtx(), MRole.Table_Name,
				MRole.Table_Name + "." + MRole.COLUMNNAME_Name + "=" + MClient.Table_Name + "." + MClient.COLUMNNAME_Name +
						" || ? AND " + MClient.Table_Name + "." + MClient.COLUMNNAME_AD_Client_ID + " IN (" +
						clients.stream().map(client -> Integer.toString(client.getAD_Client_ID())).collect(
								Collectors.joining(",")) + ")", get_TrxName())
				.addJoinClause(
						" JOIN " + MClient.Table_Name + " ON " + MClient.Table_Name + "." + MClient.COLUMNNAME_AD_Client_ID +
								"=" + MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Client_ID)
				.setParameters(roleSuffix).setOrderBy(MRole.Table_Name + "." + MRole.COLUMNNAME_Created + " ASC").list();
	}
}
