package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.Invoice;
import org.bandahealth.idempiere.rest.model.InvoiceLine;
import org.compiere.model.MInvoiceLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDBService extends BaseInvoiceDBService<Invoice> {
	@Autowired
	private BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	private InvoiceLineDBService invoiceLineDBService;

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
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
	protected Invoice createInstanceWithSearchFields(MInvoice_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	public List<Invoice> transformData(List<MInvoice_BH> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}

		Set<Integer> businessPartnerIds = dbModels.stream().map(MInvoice_BH::getC_BPartner_ID)
				.collect(Collectors.toSet());
		// Batch call to get business partners
		Map<Integer, MBPartner_BH> businessPartners = businessPartnerDBService.getByIds(businessPartnerIds);

		// invoice lines
		Set<Integer> invoiceIds = dbModels.stream().map(MInvoice_BH::get_ID).collect(Collectors.toSet());

		Map<Integer, List<InvoiceLine>> invoiceLinesByInvoiceId = invoiceLineDBService
				.transformData(invoiceLineDBService
						.getGroupsByIds(MInvoiceLine::getC_Invoice_ID, MInvoiceLine.COLUMNNAME_C_Invoice_ID, invoiceIds)
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(InvoiceLine::getInvoiceId));

		return dbModels.stream().map(invoice -> {
			Invoice result = new Invoice(invoice);

			if (businessPartners.containsKey(invoice.getC_BPartner_ID())) {
				result.setBusinessPartner(new BusinessPartner(businessPartners.get(invoice.getC_BPartner_ID())));
			}

			if (invoiceLinesByInvoiceId.containsKey(result.getId())) {
				result.setInvoiceLines(invoiceLinesByInvoiceId.get(result.getId()));
			}

			return result;

		}).collect(Collectors.toList());
	}

	@Override
	protected void beforeSave(Invoice entity, MInvoice_BH invoice) {
		// Intentionally left blank
	}

	@Override
	protected void afterSave(Invoice entity, MInvoice_BH invoice) {
		// Intentionally left blank
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_CUSTOMER_INVOICE;
	}
}
