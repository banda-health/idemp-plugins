package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MRefList;
import org.compiere.model.PO;
import org.compiere.process.DocAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class DocumentDBService<T extends BaseMetadata, S extends PO & DocAction> extends BaseDBService<T, S> {
	public final static String DOCUMENTNAME_EXPENSES = "AP Invoice";
	public final static String DOCUMENTNAME_BILLS = "POS Order";
	public final static String DOCUMENTNAME_RECEIVE_PRODUCT = "Purchase Order";
	public final static String DOCUMENTNAME_PAYMENTS = "AR Receipt";
	public final static String DOCUMENTNAME_MOVEMENT = "Material Movement";
	public final static String DOCUMENTNAME_PHYSICAL_INVENTORY = "Physical Inventory";
	public final static String DOCUMENTNAME_CUSTOMER_INVOICE = "AR Invoice";
	public final static String DOCUMENTNAME_VENDOR_INVOICE = "AP Invoice";
	private final Map<String, String> docActionToStatusMap = new HashMap<>() {{
		put(DocAction.ACTION_Complete, DocAction.STATUS_Completed);
		put(DocAction.ACTION_Void, DocAction.STATUS_Voided);
		put(DocAction.ACTION_Approve, DocAction.STATUS_Approved);
	}};
	@Autowired
	protected ReferenceListDBService referenceListDBService;

	protected abstract String getDocumentTypeName();

	/**
	 * Synchronously process order
	 *
	 * @param uuid
	 * @return
	 */
	public T processEntity(String uuid, String docAction) throws Exception {
		if (!isDocActionValidForUser(docAction)) {
			return null;
		}

		S documentEntity = getEntityByUuidFromDB(uuid);
		if (documentEntity == null) {
			log.severe("No entity with uuid = " + uuid);
			return null;
		}

		// Process the document and, if it fails, throw an exception
		if (documentEntity.processIt(docAction)) {
			if (docActionToStatusMap.containsKey(docAction)) {
				documentEntity.setDocStatus(docActionToStatusMap.get(docAction));
			}
		} else {
			// When visits can receive a failure and not freak the user out, return an error here
//			throw new AdempiereException(documentEntity.getProcessMsg());
			logger.severe("Could not process document " + getDocumentTypeName() + ", UUID: " + uuid);
		}
		documentEntity.saveEx();

		return createInstanceWithAllFields(getEntityByUuidFromDB(uuid));
	}

	/**
	 * Determine if the user can access the specified document action
	 *
	 * @param docAction The document action to perform
	 * @return Whether the user has access
	 */
	protected boolean isDocActionValidForUser(String docAction) {
		if (StringUtil.isNullOrEmpty(docAction)) {
			log.severe("Missing DocAction");
			return false;
		}
		if (!doesUserHaveAccessToDocAction(docAction)) {
			log.severe("Unauthorized");
			return false;
		}
		return true;
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
	 * Determine if the current user has access to the document action they're trying to perform
	 *
	 * @param docAction The document action to perform (i.e. ACTION_Void, ACTION_Complete)
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
