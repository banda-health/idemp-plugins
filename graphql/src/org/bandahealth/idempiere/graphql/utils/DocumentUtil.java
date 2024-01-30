package org.bandahealth.idempiere.graphql.utils;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.ProcessUtil;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MDocType;
import org.compiere.model.MProcess;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.SystemIDs;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfo;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class DocumentUtil {
	public static CLogger log = CLogger.getCLogger(DocumentUtil.class);

	public static <T extends PO & DocAction> T Process(T entity, String documentAction, int documentTypeId,
			int documentProcessId) {
		if (entity == null) {
			log.severe("No entity supplied");
			return null;
		}
		ModelUtil.getTableAndCheckAccess(entity.getCtx(), entity.get_TableName(), true);

		if (!isDocActionValidForUser(MDocType_BH.get(entity.getCtx(), documentTypeId).getDocBaseType(), documentAction)) {
			return null;
		}

		// Process the document and, if it fails, throw an exception
		try {
			processDocumentOrError(documentProcessId, entity, documentAction);
			entity.saveEx();
			return Repository.getById(entity.getCtx(), entity.get_TableName(), entity.get_TrxName(), entity.get_ID());
		} catch (Exception exception) {
			entity.saveEx();
			throw exception;
		}
	}

	/**
	 * Determine if the user can access the specified document action
	 *
	 * @param documentBaseType The base document type to explore
	 * @param documentAction   The document action to perform
	 * @return Whether the user has access
	 */
	public static boolean isDocActionValidForUser(String documentBaseType, String documentAction) {
		if (StringUtil.isNullOrEmpty(documentAction)) {
			log.severe("Missing DocAction");
			return false;
		}
		if (!doesUserHaveAccessToDocAction(documentBaseType, documentAction)) {
			log.severe("Unauthorized");
			return false;
		}
		return true;
	}

	/**
	 * Determine if the current user has access to the document action they're trying to perform
	 *
	 * @param documentAction The document action to perform (i.e. ACTION_Void, ACTION_Complete)
	 * @return Whether the user has access to process an entity a certain way
	 */
	private static boolean doesUserHaveAccessToDocAction(String documentBaseType, String documentAction) {
		List<MRefList> access = getDocumentActionAccessByDocumentType().entrySet().stream()
				.filter(accessByDocumentType -> accessByDocumentType.getKey().getDocBaseType().equals(documentBaseType))
				.map(Map.Entry::getValue).flatMap(Collection::stream).collect(Collectors.toList());
		return access.stream().anyMatch(referenceList -> referenceList.getValue().equals(documentAction));
	}

	/**
	 * Since processing a document can either fail or throw an error, capture both paths in a single method. An error
	 * will be thrown if the processing is unsuccessful.
	 *
	 * @param documentProcessId The process to run to process the document through a workflow
	 * @param document          The document to process
	 * @param processAction     Which action to take on the document
	 */
	public static <T extends PO & DocAction> void processDocumentOrError(int documentProcessId, T document,
			String processAction) {
		MProcess documentProcess = MProcess.get(Env.getCtx(), documentProcessId);
		ProcessInfo processInformation =
				new ProcessInfo("Process Document", documentProcess.get_ID(), documentProcess.get_Table_ID(),
						document.get_ID());
		processInformation.setTransactionName(document.get_TrxName());
		try {
			document.set_ValueOfColumn("DocAction", processAction);
			document.saveEx();
			ProcessUtil.startWorkFlow(Env.getCtx(), processInformation, documentProcess.getAD_Workflow_ID());
			if (processInformation.isError()) {
				throw new AdempiereException(processInformation.getSummary());
			}
			document.saveEx();
		} catch (AdempiereException exception) {
			document.save();
			throw exception;
		}
	}

	/**
	 * Gets the reference lists (which are document actions, in this case) that the user can use by document type
	 * based on the access they have.
	 *
	 * @return Returns a lists of document actions by document type to determine what a user has access to do
	 */
	public static Map<MDocType, List<MRefList>> getDocumentActionAccessByDocumentType() {
		// Previously, all document action access was assigned to a role on the client (so ad_client_id checks on access
		// would work). However, now we use master roles to house the document action, and those are assigned to the
		// system client. So, we need to search both when getting document types associated document types
		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(MClient_BH.CLIENTID_SYSTEM);
		parameters.add(0);

		// Get the doc types for this user
		List<MDocType> usedDocumentTypes = new Query(Env.getCtx(), MDocType.Table_Name,
				MDocType.COLUMNNAME_AD_Client_ID + " IN (?,?) AND " + MDocType_BH.COLUMNNAME_C_DocType_ID + ">?",
				null).setParameters(parameters).list();

		// Now get the available document actions for these document types
		Map<Integer, List<Integer>> documentActionAccess = getDocumentActionAccess(
				Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Role_ID(Env.getCtx()),
				usedDocumentTypes.stream().map(MDocType::getC_DocType_ID).collect(Collectors.toList()));

		parameters = new ArrayList<>();
		String whereClause = org.bandahealth.idempiere.base.utils.QueryUtil.getWhereClauseAndSetParametersForSet(
				new HashSet<>(documentActionAccess.values().stream().flatMap(
						Collection::stream).collect(Collectors.toSet())), parameters);

		// If there aren't any document actions to work with, something is wrong with the role configuration
		if (StringUtil.isNullOrEmpty(whereClause)) {
			log.severe(
					"Role with ID " + Env.getAD_Role_ID(Env.getCtx()) + " is misconfigured and has no document action access");
			throw new AdempiereException("Cannot perform operation - role is misconfigured");
		}

		// Now get the actual entities for these document actions
		List<MRefList> documentActions = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Ref_List_ID + " IN (" + whereClause + ")", null)
				.setParameters(parameters).list();

		Map<Integer, MDocType> docTypesById = usedDocumentTypes.stream().collect(
				Collectors.toMap(MDocType::getC_DocType_ID, documentType -> documentType));
		Map<Integer, MRefList> refListsById = documentActions.stream().collect(
				Collectors.toMap(MRefList::getAD_Ref_List_ID, referenceList -> referenceList));

		// Return the full entities
		return documentActionAccess.entrySet().stream().collect(Collectors.toMap(k -> docTypesById.get(k.getKey()),
				documentActionAccessEntry -> documentActionAccessEntry.getValue().stream().map(refListsById::get)
						.collect(Collectors.toList())));
	}

	/**
	 * Get a map of the available document actions based on a given document action
	 *
	 * @return A document map of next actions a user can take based on a given action based on a document type
	 */
	public static Map<MDocType, Map<MRefList, List<String>>> getDocumentStatusActionMap() {
		try {
			Map<MDocType, List<MRefList>> documentActionAccessByDocumentType = getDocumentActionAccessByDocumentType();
			List<MRefList> allClientDocumentStatuses =
					new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Reference_ID + "=?", null).setParameters(
							SystemIDs.REFERENCE_DOCUMENTSTATUS).list();
			PO unusedNecessaryEntityForTheDocEngine = new MRefList_BH(Env.getCtx(), 0, null);
			return documentActionAccessByDocumentType.entrySet().stream()
					.collect(Collectors.toMap(Map.Entry::getKey, documentActionAccessByDocumentTypeEntry ->
							allClientDocumentStatuses.stream().collect(
									Collectors.toMap(docStatus -> docStatus,
											docStatus -> {
												String[] unusedDocActions = new String[50];
												String[] mappedDocActions = new String[50];
												Integer tableId = MRefListUtil.tableIdsByDocumentBaseType()
														.getOrDefault(documentActionAccessByDocumentTypeEntry.getKey().getDocBaseType(), 0);
												// Get valid next actions based on a given document action
												// TODO: Determine if we want to find a way to include different actions that come when the
												// period is open
												DocumentEngine.getValidActions(docStatus.getValue(), null, "", "", tableId, unusedDocActions,
														mappedDocActions, false, unusedNecessaryEntityForTheDocEngine);
												// Return an array list, but first confirm the mapped actions are in what the user has
												// access to
												return Arrays.stream(mappedDocActions)
														.filter(mappedAction -> documentActionAccessByDocumentTypeEntry.getValue().stream()
																.anyMatch(docActionAccess -> docActionAccess.getValue().equals(mappedAction)))
														.collect(Collectors.toList());
											}
									)
							)
					));

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return new HashMap<>();
	}

	/**
	 * Checks the access rights of the given role/client for the given document actions.
	 * Copied from MRole.java
	 *
	 * @param clientId
	 * @param roleId
	 * @return A map of available document actions by document type for this client and role
	 */
	private static Map<Integer, List<Integer>> getDocumentActionAccess(int clientId, int roleId,
			List<Integer> docTypeIds) {
		final List<Object> optionParams = new ArrayList<>();

		// Previously, all document action access was assigned to a role on the client (so ad_client_id checks on access
		// would work). However, now we use master roles to house the document action, and those are assigned to the
		// system client. So, we need to search both when getting document action access
		optionParams.add(clientId);
		optionParams.add(MClient_BH.CLIENTID_SYSTEM);

		// Get all roles assigned to this user
		MRole usersRole = MRole.get(Env.getCtx(), roleId);
		List<MRole> allUsersRoles = usersRole.getIncludedRoles(true);
		allUsersRoles.add(usersRole);
		List<Integer> roleIds = allUsersRoles.stream().map(MRole::getAD_Role_ID).collect(
				Collectors.toList());

		String docTypeInClause =
				org.bandahealth.idempiere.base.utils.QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(docTypeIds),
						optionParams);
		String roleInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(roleIds), optionParams);

		// Copied (with some modification) from MRole.java, method checkActionAccess
		String sql = "SELECT DISTINCT ty.c_doctype_id, rl.ad_ref_list_id"
				+ " FROM AD_Document_Action_Access a"
				+ " INNER JOIN AD_Ref_List rl ON (rl.AD_Reference_ID=135 and rl.AD_Ref_List_ID=a.AD_Ref_List_ID)"
				+ " INNER JOIN C_DocType ty ON (ty.C_DocType_ID=a.C_DocType_ID)"
				+ " WHERE a.AD_Client_ID IN (?,?) AND a.C_DocType_ID IN (" + docTypeInClause + ")"
				+ " AND a.AD_Role_ID IN (" + roleInClause + ") AND a.IsActive=?";
		optionParams.add("Y");
		Map<Integer, List<Integer>> documentActionAccess = new HashMap<>();
		SqlUtil.executeQuery(sql, optionParams, null, rs -> {
			try {
				int docTypeId = rs.getInt(1);
				int documentActionId = rs.getInt(2);
				if (!documentActionAccess.containsKey(docTypeId)) {
					documentActionAccess.put(docTypeId, new ArrayList<>());
				}
				documentActionAccess.get(docTypeId).add(documentActionId);
			} catch (SQLException e) {
				log.log(Level.SEVERE, sql, e);
			}
		});

		return documentActionAccess;
	}
}
