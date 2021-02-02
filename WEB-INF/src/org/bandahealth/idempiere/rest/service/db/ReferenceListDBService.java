package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.AccessUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MRefList;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReferenceListDBService {
	private final CLogger log = CLogger.getCLogger(BaseDBService.class);
	private final Set<String> usedDocumentTypeNames = new HashSet<>();
	private final Map<String, Integer> documentTypeNameToADTableIdMap = new HashMap<>();
	private MRefList modelInstance;

	public ReferenceListDBService() {
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_EXPENSES);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_BILLS);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_RECEIVE_PRODUCT);
		usedDocumentTypeNames.add(DocumentDBService.DOCUMENTNAME_PAYMENTS);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_EXPENSES, MInvoice_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_BILLS, MOrder_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_RECEIVE_PRODUCT, MOrder_BH.Table_ID);
		documentTypeNameToADTableIdMap.put(DocumentDBService.DOCUMENTNAME_PAYMENTS, MPayment_BH.Table_ID);
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
	public Map<MDocType, List<MRefList>> getAccessByDocumentType() {
		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(usedDocumentTypeNames, parameters);
		// Get the doc types for this client matching what the application uses
		List<MDocType> usedDocumentTypes = new Query(Env.getCtx(), MDocType.Table_Name,
				MDocType.COLUMNNAME_Name + " IN (" + whereClause + ")", null).setParameters(parameters)
				.setClient_ID().list();

		// Now get the available document actions for these document types
		Map<Integer, List<Integer>> documentActionAccess = AccessUtil.getDocumentActionAccess(
				Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Role_ID(Env.getCtx()),
				usedDocumentTypes.stream().map(MDocType::getC_DocType_ID).collect(Collectors.toList()));

		parameters = new ArrayList<>();
		whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				new HashSet<>(documentActionAccess.values().stream().flatMap(
						Collection::stream).collect(Collectors.toSet())), parameters);
		// Now get the actual entities for these document actions
		List<MRefList> documentActions = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.COLUMNNAME_AD_Ref_List_ID + " IN (" + whereClause + ")", null)
				.setParameters(parameters).list();

		Map<Integer, MDocType> docTypesById = usedDocumentTypes.stream().collect(
				Collectors.toMap(MDocType::getC_DocType_ID, v -> v));
		Map<Integer, MRefList> refListsById = documentActions.stream().collect(
				Collectors.toMap(MRefList::getAD_Ref_List_ID, v -> v));

		// Return the full entities
		return documentActionAccess.entrySet().stream().collect(Collectors.toMap(k -> docTypesById.get(k.getKey()),
				v -> v.getValue().stream().map(refListsById::get).collect(Collectors.toList())));
	}

	/**
	 * Get a map of the available document actions based on a given document action
	 *
	 * @param accessByDocumentType The access to certain document types that this user has
	 * @return A document map of next actions a user can take based on a given action based on a document type
	 */
	public Map<MDocType, Map<MRefList, List<String>>> getValidActionMapByDocumentTypeAndReferenceList(
			Map<MDocType, List<MRefList>> accessByDocumentType) {
		PO unusedNecessaryEntityForTheDocEngine = createModelInstance();
		return accessByDocumentType.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry ->
				entry.getValue().stream().collect(
						Collectors.toMap(refList -> refList,
								refList -> {
									String[] unusedDocActions = new String[50];
									String[] mappedDocActions = new String[50];
									Integer tableId = 0;
									if (documentTypeNameToADTableIdMap.containsKey(entry.getKey().getName())) {
										tableId = documentTypeNameToADTableIdMap.get(entry.getKey().getName());
									}
									// Get valid nextactions based on a given document action
									// TODO: Determine if we want to find a way to include different actions that come when the period is
									// open
									DocumentEngine.getValidActions(refList.getValue(), null, "", "", tableId, unusedDocActions,
											mappedDocActions, false, unusedNecessaryEntityForTheDocEngine);
									// Return an array list, but first confirm the mapped actions are in what the user has access to
									return Arrays.stream(mappedDocActions).filter(mappedAction -> entry.getValue().stream()
											.anyMatch(docActionAccess -> docActionAccess.getValue().equals(mappedAction)))
											.collect(Collectors.toList());
								}
						)
				)
		));
	}
}
