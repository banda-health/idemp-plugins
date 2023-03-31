package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.rest.model.*;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 *
 * @param <T>
 * @author andrew
 */
public abstract class BaseInvoiceDBService<T extends Invoice> extends DocumentDBService<T, MInvoice_BH> {

	@Autowired
	protected InvoiceLineDBService invoiceLineDBService;
	@Autowired
	protected BusinessPartnerDBService businessPartnerDBService;

	protected abstract void beforeSave(T entity, MInvoice_BH invoice);

	protected abstract void afterSave(T entity, MInvoice_BH invoice);

	/**
	 * Search an invoice by patient/vendor name
	 *
	 * @param value
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @return
	 */
	@Override
	public BaseListResponse<T> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		return this.search(value, pagingInfo, sortColumn, sortOrder, null, null);
	}

	/**
	 * Search an invoice by patient/vendor name
	 *
	 * @param value
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param initialWhereClause an optional where clause to filter results
	 * @param parameters         an optional parameters list for use in the where
	 *                           clause
	 * @return
	 */
	public BaseListResponse<T> search(String value, Paging pagingInfo, String sortColumn, String sortOrder,
			String initialWhereClause, List<Object> parameters) {
		if (parameters == null) {
			parameters = new ArrayList<>();
		}

		// Do this first because parameters would've already been added to the array if
		// so
		StringBuilder whereClause = new StringBuilder();
		if (initialWhereClause != null && !initialWhereClause.isEmpty()) {
			whereClause.append(initialWhereClause).append(AND_OPERATOR);
		}

		// search patient
		whereClause.append("(").append(MBPartner_BH.Table_Name).append(".").append(MBPartner_BH.COLUMNNAME_BH_PatientID)
				.append("=?").append(OR_OPERATOR).append("LOWER(").append(MBPartner_BH.Table_Name).append(".")
				.append(MBPartner_BH.COLUMNNAME_Name).append(") ").append(LIKE_COMPARATOR).append(" ?)");
		parameters.add(value);
		parameters.add(constructSearchValue(value));

		Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause.toString(), null)
				.addJoinClause("JOIN " + MBPartner_BH.Table_Name + " ON " + MInvoice_BH.Table_Name + "."
						+ MInvoice_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "."
						+ MBPartner_BH.COLUMNNAME_C_BPartner_ID)
				.setClient_ID();

		String orderBy = getOrderBy(sortColumn, sortOrder);
		if (orderBy != null) {
			query = query.setOrderBy(orderBy);
		}

		if (parameters != null) {
			query = query.setParameters(parameters);
		}

		// get total count without pagination parameters
		pagingInfo.setTotalRecordCount(query.count());

		// set pagination params
		query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());

		List<T> results = new ArrayList<>();
		List<MInvoice_BH> entities = query.list();

		if (!entities.isEmpty()) {
			for (MInvoice_BH entity : entities) {
				if (entity != null) {
					results.add(createInstanceWithSearchFields(entity));
				}
			}
		}

		return new BaseListResponse<T>(results, pagingInfo);
	}

	@Override
	public T saveEntity(T entity) {
		try {
			MInvoice_BH invoice = getEntityByUuidFromDB(entity.getUuid());
			if (invoice == null) {
				invoice = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					invoice.setC_Invoice_UU(entity.getUuid());
				}
			}

			invoice.setIsSOTrx(entity.isSalesOrderTransaction());

			if (entity.getDateInvoiced() != null) {
				invoice.setDateInvoiced(DateUtil.getTimestamp(entity.getDateInvoiced()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				invoice.setDescription(entity.getDescription());
			}

			if (entity.getBusinessPartner() != null && entity.getBusinessPartner().getUuid() != null) {
				MBPartner_BH businessPartner = businessPartnerDBService
						.getEntityByUuidFromDB(entity.getBusinessPartner().getUuid());
				invoice.setC_BPartner_ID(businessPartner.get_ID());
			}

			invoice.setIsActive(entity.getIsActive());

			invoice.setIsApproved(true);
			invoice.setDocAction(MInvoice_BH.DOCACTION_Complete);
			if (!StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
				invoice.setPaymentRule(entity.getPaymentRule());
			}
			invoice.setBH_InvoiceType(entity.getInvoiceType());

			beforeSave(entity, invoice);

			// set target document type
			int docTypeId;
			if (!invoice.isSOTrx()) {
				docTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_APInvoice);
			} else {
				docTypeId = MDocType.getDocType(MDocType.DOCBASETYPE_ARInvoice);
			}

			invoice.setC_DocTypeTarget_ID(docTypeId);

			invoice.saveEx();

			// list of persisted invoice line ids
			String lineIds = "";
			// persist product/service/charge invoice lines
			List<InvoiceLine> invoiceLines = entity.getInvoiceLines();
			if (invoiceLines != null) {
				int count = 0;
				for (InvoiceLine invoiceLine : invoiceLines) {
					invoiceLine.setInvoiceId(invoice.get_ID());
					InvoiceLine response = invoiceLineDBService.saveEntity(invoiceLine);
					lineIds += "'" + response.getUuid() + "'";
					if (++count < invoiceLines.size()) {
						lineIds += ",";
					}
				}
			}

			// delete invoice lines not in request
			invoiceLineDBService.deleteInvoiceLinesByInvoice(invoice.get_ID(), lineIds);

			// any post save operation
			afterSave(entity, invoice);

			return createInstanceWithAllFields(getEntityByUuidFromDB(invoice.getC_Invoice_UU()));

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());

			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected MInvoice_BH getModelInstance() {
		return new MInvoice_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MInvoice_BH invoice = getEntityByUuidFromDB(entityUuid);
		if (invoice == null) {
			log.severe("No invoice with uuid = " + entityUuid);
			return false;
		}

		try {
			if (invoice.isComplete()) {
				invoice.setDocAction(DocAction.ACTION_Reverse_Accrual);
				invoice.processIt(DocAction.ACTION_None);
				invoice.saveEx();
			} else {
				invoice.deleteEx(false);
			}
			return true;
		} catch (Exception ex) {
			log.severe("Delete exception: " + ex.getMessage());
		}

		return false;
	}

	@Override
	public T saveAndProcessEntity(T entity, String docAction) throws Exception {
		// Invoices that have already been processed can't be saved again
		MInvoice_BH invoice = getEntityByUuidFromDB(entity.getUuid());
		if (invoice != null) {
			if (docAction.equals(MInvoice_BH.DOCACTION_Void)) {
				VoidedReason voidedReason = entity.getVoidedReason();
				if (voidedReason != null && StringUtil.isNotNullAndEmpty(voidedReason.getUuid())) {
					invoice.saveEx();
				}
			}

			if (invoice.isComplete()) {
				return processEntity(entity.getUuid(), docAction);
			}
		}

		return super.saveAndProcessEntity(entity, docAction);
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_INVOICE;
	}
}
