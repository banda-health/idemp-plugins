package org.bandahealth.idempiere.rest.utils;

import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MRole;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class AccessUtil {
	private final static CLogger log = CLogger.getCLogger(AccessUtil.class);

	/**
	 * Checks the access rights of the given role/client for the given document actions.
	 * Copied from MRole.java
	 *
	 * @param clientId
	 * @param roleId
	 * @return A map of available document actions by document type for this client and role
	 */
	public static Map<Integer, List<Integer>> getDocumentActionAccess(int clientId, int roleId,
			List<Integer> docTypeIds) {
		final List<Object> optionParams = new ArrayList<>();
		optionParams.add(clientId);

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Get all roles assigned to this user
		MRole usersRole = MRole.get(Env.getCtx(), roleId);
		List<MRole> allUsersRoles = usersRole.getIncludedRoles(true);
		allUsersRoles.add(usersRole);
		List<Integer> roleIds = allUsersRoles.stream().map(MRole::getAD_Role_ID).collect(
				Collectors.toList());

		String docTypeInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(docTypeIds), optionParams);
		String roleInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(roleIds), optionParams);

		String sql = null;
		Map<Integer, List<Integer>> documentActionAccess = new HashMap<>();
		try {
			sql = "SELECT DISTINCT ty.c_doctype_id, rl.ad_ref_list_id"
					+ " FROM AD_Document_Action_Access a"
					+ " INNER JOIN AD_Ref_List rl ON (rl.AD_Reference_ID=135 and rl.AD_Ref_List_ID=a.AD_Ref_List_ID)"
					+ " INNER JOIN C_DocType ty ON (ty.C_DocType_ID=a.C_DocType_ID)"
					+ " WHERE a.AD_Client_ID=? AND a.C_DocType_ID IN (" + docTypeInClause + ")"
					+ " AND a.AD_Role_ID IN (" + roleInClause + ") AND a.IsActive=?";
			optionParams.add("Y");
			pstmt = DB.prepareStatement(sql, null);
			DB.setParameters(pstmt, optionParams);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int docTypeId = rs.getInt(1);
				int documentActionId = rs.getInt(2);
				if (!documentActionAccess.containsKey(docTypeId)) {
					documentActionAccess.put(docTypeId, new ArrayList<>());
				}
				documentActionAccess.get(docTypeId).add(documentActionId);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		return documentActionAccess;
	}
}
