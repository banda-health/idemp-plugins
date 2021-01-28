package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.AccessUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReferenceListDBService {
	private final CLogger log = CLogger.getCLogger(BaseDBService.class);
	private final Set<String> usedDocumentTypeNames = new HashSet<>();
	private final String DOCNAME_EXPENSES = "AP Invoice";
	private final String DOCNAME_BILLS = "POS Order";
	private final String DOCNAME_RECEIVE_PRODUCT = "Purchase Order";
	private final String DOCNAME_PAYMENTS = "AR Receipt";

	public ReferenceListDBService() {
		usedDocumentTypeNames.add(DOCNAME_EXPENSES);
		usedDocumentTypeNames.add(DOCNAME_BILLS);
		usedDocumentTypeNames.add(DOCNAME_RECEIVE_PRODUCT);
		usedDocumentTypeNames.add(DOCNAME_PAYMENTS);
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
}
