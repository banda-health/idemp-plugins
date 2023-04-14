package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ExpenseCategoryDBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose Expenses REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.EXPENSE_CATEGORIES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseCategoryRestService extends BaseRestService<ExpenseCategory, MCharge_BH, ExpenseCategoryDBService> {

	@Autowired
	private ExpenseCategoryDBService dbService;

	@Override
	protected ExpenseCategoryDBService getDBService() {
		return dbService;
	}
}
