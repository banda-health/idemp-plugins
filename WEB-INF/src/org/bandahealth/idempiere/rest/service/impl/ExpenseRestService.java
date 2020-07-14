package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ExpenseDBService;

/**
 * Expose TrackExpense REST functionality
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.EXPENSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseRestService extends BaseEntityRestService<Expense> {

	private ExpenseDBService dbService;

	public ExpenseRestService() {
		this.dbService = new ExpenseDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Expense> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
																					@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Expense> search(@QueryParam("value") String value, @QueryParam("page") int page,
																					@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
																					@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.EXPENSE_PATH)
	@Override
	public Expense getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Expense saveEntity(Expense entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public Expense process(@PathParam("uuid") String uuid) {
		return dbService.processEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public Expense saveAndProcess(Expense entity) {
		return dbService.asyncSaveAndProcessEntity(entity);
	}

	@DELETE
	@Path(IRestConfigs.UUID_PATH)
	public boolean saveAndProcess(@PathParam("uuid") String uuid) {
		return dbService.asyncDeleteEntity(uuid);
	}
}
