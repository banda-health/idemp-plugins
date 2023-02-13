package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.ExpenseDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expose TrackExpense REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.EXPENSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseRestService extends DocumentRestService<Expense, MInvoice_BH, ExpenseDBService> {

	@Autowired
	private ExpenseDBService dbService;

	@Override
	protected ExpenseDBService getDBService() {
		return dbService;
	}
}
