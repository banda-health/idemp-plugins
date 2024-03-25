package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.model.Transaction;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.TransactionDBService;
import org.compiere.model.MTransaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.bandahealth.idempiere.rest.IRestConfigs.AUTHENTICATION_PATH;

@Path(AUTHENTICATION_PATH + "/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransacationRestService extends BaseRestService<Transaction, MTransaction, TransactionDBService> {
	private final TransactionDBService dbService = new TransactionDBService();

	@Override
	protected TransactionDBService getDBService() {
		return dbService;
	}
}
