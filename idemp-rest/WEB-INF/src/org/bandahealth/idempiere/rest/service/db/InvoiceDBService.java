package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDBService extends BaseInvoiceDBService<Invoice> {
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
		return new Invoice(instance);
	}

	@Override
	protected Invoice createInstanceWithSearchFields(MInvoice_BH instance) {
		return createInstanceWithAllFields(instance);
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
