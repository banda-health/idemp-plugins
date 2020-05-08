package org.bandahealth.idempiere.rest.service.impl;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.VisitDBService;

/**
 * Expose ALL Patient Visit functionality i.e create/update, view, processing
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.VISITS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VisitRestService extends BaseEntityRestService<Visit> {

	private VisitDBService dbService;

	public VisitRestService() {
		dbService = new VisitDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Visit> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.VISIT_PATH)
	@Override
	public Visit getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Visit saveEntity(Visit entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public String processVisit(@PathParam("uuid") String uuid) {
		return dbService.asyncProcessEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public String saveAndProcessVisit(Visit entity) {
		return dbService.asynSaveAndProcessEntity(entity);
	}

	@POST
	@Path(IRestConfigs.VISIT_QUEUE_PATH)
	public BaseListResponse<Visit> getVisitQueue(@QueryParam("page") int page, @QueryParam("size") int size) {
		return dbService.getVisitQueue(getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Visit> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size) {
		return dbService.search(value, getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.PRINT_RECEIPT_PATH)
	@Produces(IRestConfigs.APPLICATION_PDF)
	public Response generateReceipt(@PathParam("uuid") String uuid) {
		File receipt = dbService.generateThermalReceipt(uuid);
		if (receipt != null) {
			ResponseBuilder response = Response.ok((Object) receipt);
			response.header("Content-Disposition", "attachment; filename=\"receipt.pdf\"");
			return response.build();
		}

		return null;
	}
}
