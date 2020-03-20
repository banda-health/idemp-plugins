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
	@Path(IRestConfigs.VISIT_PROCESS_PATH)
	public Visit processVisit(@PathParam("uuid") String uuid) {
		return dbService.asyncProcessEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.VISIT_SAVE_AND_PROCESS_PATH)
	public Visit saveAndprocessVisit(Visit entity) {
		return dbService.asynSaveAndProcessEntity(entity);
	}
}
