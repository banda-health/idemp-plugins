package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.bandahealth.idempiere.rest.model.Invoice;
import org.bandahealth.idempiere.rest.model.InvoiceLine;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.X_C_BPartner;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 *
 * @author andrew
 */
public class InvoiceDBService extends DocumentDBService<Invoice, MInvoice_BH> {
	protected final InvoiceLineDBService invoiceLineDBService = new InvoiceLineDBService();
	protected final BusinessPartnerDBService businessPartnerDBService = new BusinessPartnerDBService();
	protected final AttributeSetInstanceDBService attributeSetInstanceDBService = new AttributeSetInstanceDBService();
	protected final OrderDBService orderDBService = new OrderDBService();
	protected final DocumentTypeDBService documentTypeDBService = new DocumentTypeDBService();
	protected final ProductDBService productDBService = new ProductDBService();
	protected final BusinessPartnerSpecificPayerInformationDBService businessPartnerSpecificPayerInformationDBService =
			new BusinessPartnerSpecificPayerInformationDBService();

	private final Map<String, String> dynamicJoins = new HashMap<>() {{
		put(X_C_BPartner.Table_Name, "LEFT JOIN  " + MBPartner_BH.Table_Name + " ON " + MInvoice_BH.Table_Name + "." +
				MInvoice_BH.COLUMNNAME_C_BPartner_ID + " = "
				+ MBPartner_BH.Table_Name + "." + MBPartner_BH.COLUMNNAME_C_BPartner_ID);
	}};

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	protected Invoice createInstanceWithDefaultFields(MInvoice_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Invoice createInstanceWithAllFields(MInvoice_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	public Invoice saveEntity(Invoice entity) {
		return transformData(
				Collections.singletonList(getEntityByUuidFromDB(saveOnlyWithoutChildDataFetch(entity).getUuid()))).get(0);
	}

	/**
	 * This method is implemented to speed up processing by avoiding an unnecessary data fetch.
	 * TODO: Remove this when we have GraphQL
	 *
	 * @param entity The invoice to save
	 * @return A somewhat updated invoice (has the new UUID & ID on it for other use)
	 */
	public Invoice saveOnlyWithoutChildDataFetch(Invoice entity) {
		try {
			MDocType_BH documentTypeTarget;
			if (entity.getDocumentTypeTarget() == null ||
					StringUtil.isNullOrEmpty(entity.getDocumentTypeTarget().getUuid()) || (documentTypeTarget =
					documentTypeDBService.getEntityByUuidFromDB(entity.getDocumentTypeTarget().getUuid())) == null) {
				throw new AdempiereException("Document Type is required");
			}

			MInvoice_BH invoice = getEntityByUuidFromDB(entity.getUuid());
			if (invoice == null) {
				invoice = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					invoice.setC_Invoice_UU(entity.getUuid());
				}
			}

			invoice.setC_DocTypeTarget_ID(documentTypeTarget.get_ID());
			invoice.setIsSOTrx(documentTypeTarget.isSOTrx());

			if (entity.getOrderId() > 0) {
				invoice.setOrder(orderDBService.getEntityByIdFromDB(entity.getOrderId()));
			} else if (entity.getOrder() != null && !StringUtil.isNullOrEmpty(entity.getOrder().getUuid())) {
				invoice.setOrder(orderDBService.getEntityByUuidFromDB(entity.getOrder().getUuid()));
			}

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

			invoice.setBH_Visit_ID(entity.getVisitId());
			invoice.setIsActive(entity.getIsActive());

			invoice.setIsApproved(true);
			invoice.setDocAction(MInvoice_BH.DOCACTION_Complete);
			if (!StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
				invoice.setPaymentRule(entity.getPaymentRule());
			}

			// We're going to log to try and see how long things take to try and identify the cause of deadlocks
			String randomUuid = UUID.randomUUID().toString();
			long startTime = System.currentTimeMillis();
			logger.info("InvoiceInternal_" + randomUuid + " before save");
			invoice.saveEx();
			logger.info(
					"InvoiceInternal_" + randomUuid + " millisecond save time: " + (System.currentTimeMillis() - startTime));
			entity.setId(invoice.get_ID());

			// list of persisted invoice line ids
			String lineIds = "";
			// persist product/service/charge invoice lines
			List<InvoiceLine> invoiceLines = entity.getInvoiceLines();
			if (invoiceLines != null && !invoiceLines.isEmpty()) {
				// Get the ASI batches, if any should be there
				Set<String> attributeSetInstanceUuids =
						invoiceLines.stream().map(InvoiceLine::getAttributeSetInstance).filter(Objects::nonNull)
								.map(AttributeSetInstance::getUuid).filter(StringUtil::isNotNullAndEmpty).collect(Collectors.toSet());
				Map<String, MAttributeSetInstance_BH> attributeSetInstancesByUuid =
						attributeSetInstanceDBService.getByUuids(attributeSetInstanceUuids);
				int count = 0;
				for (InvoiceLine invoiceLine : invoiceLines) {
					invoiceLine.setInvoiceId(invoice.get_ID());

					// Set the ASI ID, if need be
					if (invoiceLine.getAttributeSetInstance() != null &&
							!StringUtil.isNullOrEmpty(invoiceLine.getAttributeSetInstance().getUuid()) &&
							attributeSetInstancesByUuid.containsKey(invoiceLine.getAttributeSetInstance().getUuid())) {
						invoiceLine.setAttributeSetInstanceId(
								attributeSetInstancesByUuid.get(invoiceLine.getAttributeSetInstance().getUuid()).get_ID());
					}

					InvoiceLine response = invoiceLineDBService.saveOnlyWithoutChildDataFetch(invoiceLine);
					lineIds += "'" + response.getUuid() + "'";
					if (++count < invoiceLines.size()) {
						lineIds += ",";
					}
				}
			}

			// delete invoice lines not in request
			invoiceLineDBService.deleteInvoiceLinesByInvoice(invoice.get_ID(), lineIds);

			return new Invoice(invoice);
		} catch (Exception ex) {
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
				// Delete BP payer info
				List<MBHBPSpecificPayerInfo> specificPayerInformationList =
						businessPartnerSpecificPayerInformationDBService.getGroupsByIds(MBHBPSpecificPayerInfo::getC_InvoiceLine_ID,
										MBHBPSpecificPayerInfo.COLUMNNAME_C_InvoiceLine_ID,
										Stream.of(invoice.getLines()).map(MInvoiceLine::getC_InvoiceLine_ID).collect(Collectors.toSet()))
								.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
				specificPayerInformationList.forEach(specificPayerInformation -> specificPayerInformation.deleteEx(true));

				invoice.deleteEx(false);
			}
			return true;
		} catch (Exception ex) {
			log.severe("Delete exception: " + ex.getMessage());
		}

		return false;
	}

	@Override
	public Invoice saveAndProcessEntity(Invoice entity, String docAction) throws Exception {
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
	int getDocumentTypeId(MInvoice_BH entity) {
		return entity.getC_DocTypeTarget_ID();
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_INVOICE;
	}

	@Override
	public List<Invoice> transformData(List<MInvoice_BH> dbModels) {
		Set<Integer> businessPartnerIds = dbModels.stream().map(MInvoice_BH::getC_BPartner_ID)
				.collect(Collectors.toSet());
		// Batch call to get business partners
		Map<Integer, BusinessPartner> businessPartnersById = businessPartnerDBService.transformData(
						new ArrayList<>(businessPartnerDBService.getByIds(businessPartnerIds).values())).stream()
				.collect(Collectors.toMap(BusinessPartner::getId, businessPartner -> businessPartner));

		// Batch call to get any orders
		Map<Integer, MOrder_BH> ordersById = orderDBService.getByIds(
				dbModels.stream().map(MInvoice_BH::getC_Order_ID).filter(orderId -> orderId > 0).collect(Collectors.toSet()));

		// invoice lines
		Set<Integer> invoiceIds = dbModels.stream().map(MInvoice_BH::get_ID).collect(Collectors.toSet());
		Map<Integer, List<InvoiceLine>> invoiceLinesByInvoiceId = invoiceLineDBService
				.transformData(invoiceLineDBService
						.getGroupsByIds(MInvoiceLine::getC_Invoice_ID, MInvoiceLine.COLUMNNAME_C_Invoice_ID, invoiceIds)
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(InvoiceLine::getInvoiceId));

		// Batch ASIs & Products
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById = attributeSetInstanceDBService.getByIds(
				invoiceLinesByInvoiceId.values().stream().flatMap(Collection::stream)
						.map(InvoiceLine::getAttributeSetInstanceId)
						.filter(attributeSetInstanceId -> attributeSetInstanceId > 0).collect(Collectors.toSet()));
		Map<Integer, Product> productsByIds = productDBService.transformData(new ArrayList<>(productDBService.getByIds(
						invoiceLinesByInvoiceId.values().stream().flatMap(Collection::stream).map(InvoiceLine::getProductId)
								.collect(Collectors.toSet())).values())).stream()
				.collect(Collectors.toMap(Product::getId, product -> product));

		// Batch doc types
		Map<Integer, MDocType_BH> documentTypesById = documentTypeDBService.getByIds(
				dbModels.stream().map(MInvoice_BH::getC_DocTypeTarget_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(invoice -> {
			Invoice result = new Invoice(invoice);

			if (businessPartnersById.containsKey(invoice.getC_BPartner_ID())) {
				result.setBusinessPartner(businessPartnersById.get(invoice.getC_BPartner_ID()));
			}
			if (documentTypesById.containsKey(invoice.getC_DocTypeTarget_ID())) {
				result.setDocumentTypeTarget(new DocumentType(documentTypesById.get(invoice.getC_DocTypeTarget_ID())));
			}
			if (ordersById.containsKey(invoice.getC_Order_ID())) {
				result.setOrder(new Order(ordersById.get(invoice.getC_Order_ID())));
			}

			if (invoiceLinesByInvoiceId.containsKey(result.getId())) {
				result.setInvoiceLines(invoiceLinesByInvoiceId.get(result.getId()));
			}
			result.getInvoiceLines().forEach(invoiceLine -> {
				if (attributeSetInstancesById.containsKey(invoiceLine.getAttributeSetInstanceId())) {
					invoiceLine.setAttributeSetInstance(
							new AttributeSetInstance(attributeSetInstancesById.get(invoiceLine.getAttributeSetInstanceId())));
				}
				if (productsByIds.containsKey(invoiceLine.getProductId())) {
					invoiceLine.setProduct(productsByIds.get(invoiceLine.getProductId()));
				}
			});

			return result;

		}).collect(Collectors.toList());
	}
}
