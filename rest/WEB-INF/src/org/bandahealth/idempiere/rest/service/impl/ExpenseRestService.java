package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose TrackExpense REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.EXPENSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseRestService extends BaseEntityRestService<Expense> {

	@Autowired
	private ExpenseDBService dbService;

	@GET
	@Override
	public BaseListResponse<Expense> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Expense> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@GET
	@Path(IRestConfigs.UUID_PATH)
	@Override
	public Expense getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Override
	public Expense saveEntity(Expense entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public Expense process(@PathParam("uuid") String uuid, @PathParam("processType") String docAction)
			throws Exception {
		return dbService.processEntity(uuid, docAction);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public Expense saveAndProcess(Expense entity, @PathParam("processType") String docAction) throws Exception {
		return dbService.saveAndProcessEntity(entity, docAction);
	}

	@DELETE
	@Path(IRestConfigs.UUID_PATH)
	public boolean saveAndProcess(@PathParam("uuid") String uuid) {
		return dbService.asyncDeleteEntity(uuid);
	}
}
