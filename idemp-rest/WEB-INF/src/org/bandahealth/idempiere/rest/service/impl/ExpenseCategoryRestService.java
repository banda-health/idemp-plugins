package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ExpenseCategoryDBService;

/**
 * Expose Expenses REST functionality
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.EXPENSE_CATEGORIES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseCategoryRestService extends BaseEntityRestService<ExpenseCategory> {

	private ExpenseCategoryDBService dbService;

	public ExpenseCategoryRestService() {
		this.dbService = new ExpenseCategoryDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<ExpenseCategory> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.EXPENSE_CATEGORY_PATH)
	@Override
	public ExpenseCategory getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public ExpenseCategory saveEntity(ExpenseCategory entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<ExpenseCategory> search(@QueryParam("value") String value, @QueryParam("page") int page,
																									@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
																									@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}
}
