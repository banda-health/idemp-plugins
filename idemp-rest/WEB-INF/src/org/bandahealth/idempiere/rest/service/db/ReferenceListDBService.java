package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MRole;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.model.SystemIDs;
import org.compiere.process.DocumentEngine;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Component
public class ReferenceListDBService extends BaseDBService<ReferenceList, MRefList> {
	private final CLogger log = CLogger.getCLogger(BaseDBService.class);
	private final Set<String> usedDocumentTypeNames = new HashSet<>();
	private final Map<String, Integer> documentTypeNameToADTableIdMap = new HashMap<>();
	private MRefList modelInstance;

	public ReferenceListDBService() {
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_EXPENSES);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_BILLS);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_RECEIVE_PRODUCT);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_PAYMENTS);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_MOVEMENT);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_PHYSICAL_INVENTORY);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_CUSTOMER_INVOICE);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_EXPENSES, MInvoice_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_BILLS, MOrder_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_RECEIVE_PRODUCT, MOrder_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_PAYMENTS, MPayment_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_MOVEMENT, MMovement_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_PHYSICAL_INVENTORY, MInventory_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_CUSTOMER_INVOICE, MInvoice_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_VENDOR_INVOICE, MInvoice_BH.Table_ID);
	}

	@Override
	public ReferenceList saveEntity(ReferenceList entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected ReferenceList createInstanceWithDefaultFields(MRefList instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ReferenceList createInstanceWithAllFields(MRefList instance) {
		return new ReferenceList(instance);
	}

	@Override
	protected ReferenceList createInstanceWithSearchFields(MRefList instance) {
		return createInstanceWithAllFields(instance);
	}

	/**
	 * Get a model instance. If one does not exist, it is created. This should NOT be used to get something to save to
	 * the DB.
	 *
	 * @return A model instance
	 */
	public MRefList getModelInstance() {
		if (modelInstance == null) {
			modelInstance = createModelInstance();
		}
		return modelInstance;
	}

	/**
	 * The method to create a new model instance. This should be used when getting something to save to the DB.
	 *
	 * @return A model instance
	 */
	protected MRefList createModelInstance() {
		return new MRefList(Env.getCtx(), 0, null);
	}

	/**
	 * Gets the reference lists (which are document actions, in this case) that the user can use by document type
	 * based on the access they have.
	 *
	 * @return Returns a lists of document actions by document type to determine what a user has access to do
	 */
	public Map<MDocType, List<MRefList>> getDocumentActionAccessByDocumentType() {
		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(usedDocumentTypeNames, parameters);

		// Previously, all document action access was assigned to a role on the client (so ad_client_id checks on access
		// would work). However, now we use master roles to house the document action, and those are assigned to the
		// system client. So, we need to search both when getting document types associated document types
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(MClient_BH.CLIENTID_SYSTEM);

//		PO.setCrossTenantSafe(); // <- uncomment for iDempiere-8.2+

		// Get the doc types for this user matching what the application uses
		List<MDocType> usedDocumentTypes = new Query(Env.getCtx(), MDocType.Table_Name,
				MDocType.COLUMNNAME_Name + " IN (" + whereClause + ") AND " + MDocType.COLUMNNAME_AD_Client_ID + " IN (?,?)",
				null).setParameters(parameters).list();

//		PO.clearCrossTenantSafe(); // <- uncomment for iDempiere-8.2+

		// Now get the available document actions for these document types
		Map<Integer, List<Integer>> documentActionAccess = getDocumentActionAccess(
				Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Role_ID(Env.getCtx()),
				usedDocumentTypes.stream().map(MDocType::getC_DocType_ID).collect(Collectors.toList()));

		parameters = new ArrayList<>();
		whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				new HashSet<>(documentActionAccess.values().stream().flatMap(
						Collection::stream).collect(Collectors.toSet())), parameters);

		// If there aren't any document actions to work with, something is wrong with the role configuration
		if (StringUtil.isNullOrEmpty(whereClause)) {
			logger.severe(
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
	public Map<MDocType, Map<MRefList, List<String>>> getDocumentStatusActionMap() {
		try {
			Map<MDocType, List<MRefList>> documentActionAccessByDocumentType = getDocumentActionAccessByDocumentType();
			List<MRefList> allClientDocumentStatuses =
					new Query(Env.getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Reference_ID + "=?", null).setParameters(
							SystemIDs.REFERENCE_DOCUMENTSTATUS).list();
			PO unusedNecessaryEntityForTheDocEngine = createModelInstance();
			return documentActionAccessByDocumentType.entrySet().stream()
					.collect(Collectors.toMap(Map.Entry::getKey, documentActionAccessByDocumentTypeEntry ->
							allClientDocumentStatuses.stream().collect(
									Collectors.toMap(docStatus -> docStatus,
											docStatus -> {
												String[] unusedDocActions = new String[50];
												String[] mappedDocActions = new String[50];
												Integer tableId = 0;
												if (documentTypeNameToADTableIdMap
														.containsKey(documentActionAccessByDocumentTypeEntry.getKey().getName())) {
													tableId = documentTypeNameToADTableIdMap
															.get(documentActionAccessByDocumentTypeEntry.getKey().getName());
												}
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

		return new HashMap<MDocType, Map<MRefList, List<String>>>();
	}

	/**
	 * Checks the access rights of the given role/client for the given document actions.
	 * Copied from MRole.java
	 *
	 * @param clientId
	 * @param roleId
	 * @return A map of available document actions by document type for this client and role
	 */
	private Map<Integer, List<Integer>> getDocumentActionAccess(int clientId, int roleId,
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

		String docTypeInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(docTypeIds), optionParams);
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

	@Override
	protected Map<String, Function<MRefList, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {{
			put(MRefList.COLUMNNAME_Name, entity -> entity::setName);
			put(MRefList.COLUMNNAME_Description, entity -> entity::setDescription);
		}};
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}

	/**
	 * Get Reference List from MRefList.Table_Name
	 *
	 * @param referenceUuid   A reference UUID
	 * @param referenceValues A list of values to fetch data for
	 * @return The reference list data
	 */
	public List<MRefList> getTypes(String referenceUuid, Set<String> referenceValues) {
		List<MRefList> values = new ArrayList<>();
		if (StringUtil.isNullOrEmpty(referenceUuid)) {
			return values;
		}
		List<Object> parameters = new ArrayList<>();

		String whereClause = MReference.Table_Name + "." + MReference.COLUMNNAME_AD_Reference_UU + "=? ";
		parameters.add(referenceUuid);

		values = new Query(Env.getCtx(), MRefList.Table_Name, whereClause, null)
				.addJoinClause("JOIN " + MReference.Table_Name + " ON " + MReference.Table_Name + "."
						+ MReference.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
						+ MRefList.COLUMNNAME_AD_Reference_ID)
				.setParameters(parameters).setOnlyActiveRecords(true).setNoVirtualColumn(true)
				.list();

		if (referenceValues == null) {
			return values;
		}
		return values.stream().filter(referenceList -> referenceValues.contains(referenceList.getValue()))
				.collect(Collectors.toList());
	}
}
