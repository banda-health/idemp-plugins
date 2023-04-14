package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.PaymentDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.PAYMENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentRestService extends DocumentRestService<Payment, MPayment_BH, PaymentDBService> {

	@Autowired
	private PaymentDBService dbService;

	@Override
	protected PaymentDBService getDBService() {
		return dbService;
	}
}
