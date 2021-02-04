package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MRefList;
import org.compiere.model.PO;
import org.compiere.process.DocAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class DocumentDBService<T extends BaseMetadata, S extends PO & DocAction> extends BaseDBService<T, S> {
	public final static String DOCUMENTNAME_EXPENSES = "AP Invoice";
	public final static String DOCUMENTNAME_BILLS = "POS Order";
	public final static String DOCUMENTNAME_RECEIVE_PRODUCT = "Purchase Order";
	public final static String DOCUMENTNAME_PAYMENTS = "AR Receipt";
	protected final ReferenceListDBService referenceListDBService;
	private final Map<String, String> docActionToStatusMap = new HashMap<>() {{
		put(DocAction.ACTION_Complete, DocAction.STATUS_Completed);
		put(DocAction.ACTION_Void, DocAction.STATUS_Voided);
		put(DocAction.ACTION_Approve, DocAction.STATUS_Approved);
	}};

	public DocumentDBService() {
		referenceListDBService = new ReferenceListDBService();
	}

	protected abstract void handleEntityAsyncProcess(String uuid);

	protected abstract String getDocumentTypeName();

	/**
	 * Synchronously process order
	 *
	 * @param uuid
	 * @return
	 */
	public T processEntity(String uuid, String docAction) throws Exception {
		if (StringUtil.isNullOrEmpty(docAction)) {
			log.severe("Missing DocAction");
			return null;
		}
		if (!doesUserHaveAccessToDocAction(docAction)) {
			log.severe("Unauthorized");
			return null;
		}

		S documentEntity = getEntityByUuidFromDB(uuid);
		if (documentEntity == null) {
			log.severe("No entity with uuid = " + uuid);
			return null;
		}

		if (documentEntity.processIt(docAction) && docActionToStatusMap.containsKey(docAction)) {
			documentEntity.setDocStatus(docActionToStatusMap.get(docAction));
			documentEntity.saveEx();
		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(uuid));
	}

	/**
	 * Synchronously save and process an entity
	 *
	 * @param entity The entity to process
	 * @return The entity if the processing is allowed, or null if it's not allowed
	 */
	public T saveAndProcessEntity(T entity, String docAction) throws Exception {
		T saveEntity = saveEntity(entity);
		if (saveEntity != null) {
			return processEntity(saveEntity.getUuid(), docAction);
		}

		return null;
	}

	/**
	 * Asynchronously process order
	 *
	 * @param uuid
	 * @return
	 */
	public T asyncCompleteEntity(String uuid) {
		S entity = getEntityByUuidFromDB(uuid);
		if (entity == null) {
			log.severe("No entity with uuid = " + uuid);
			return null;
		}

		handleEntityAsyncProcess(uuid);

		return createInstanceWithAllFields(getEntityByUuidFromDB(uuid));
	}

	/**
	 * Save and asynchronously process order
	 *
	 * @param entity
	 * @return
	 */
	public T asyncSaveAndCompleteEntity(T entity) throws Exception {
		S dbEntity = getEntityByUuidFromDB(entity.getUuid());
		// check void docstatus (completed orders can't be saved/updated)
		if (dbEntity.getDocStatus() != null && dbEntity.getDocStatus().equals(DocAction.STATUS_Voided)) {
			return processEntity(entity.getUuid(), DocAction.ACTION_Void);
		}

		T saveEntity = saveEntity(entity);
		if (saveEntity != null) {
			asyncCompleteEntity(saveEntity.getUuid());
			return saveEntity;
		}

		return null;
	}

	/**
	 * Determine if the current user has access to the document action they're trying to perform
	 *
	 * @param docAction The document action to perform (i.e. ACTION_Void, ACTION_Complete
	 * @return Whether the user has access to process an entity a certain way
	 */
	private boolean doesUserHaveAccessToDocAction(String docAction) {
		Optional<Map.Entry<MDocType, List<MRefList>>> access =
				referenceListDBService.getDocumentActionAccessByDocumentType().entrySet().stream().filter(
						accessByDocumentType -> accessByDocumentType.getKey().getName().equals(getDocumentTypeName())).findFirst();
		if (access.isEmpty()) {
			return false;
		}
		return access.get().getValue().stream().anyMatch(refList -> refList.getValue().equals(docAction));
	}
}
