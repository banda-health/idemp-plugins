package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.model.Invoice;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.InvoiceDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.bandahealth.idempiere.rest.IRestConfigs.AUTHENTICATION_PATH;

@Path(AUTHENTICATION_PATH + "/invoices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceRestService extends DocumentRestService<Invoice, MInvoice_BH, InvoiceDBService> {
	@Autowired
	private InvoiceDBService invoiceDBService;

	@Override
	protected InvoiceDBService getDBService() {
		return invoiceDBService;
	}
}
