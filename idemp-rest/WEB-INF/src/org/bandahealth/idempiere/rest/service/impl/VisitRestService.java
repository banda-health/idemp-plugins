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
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.VisitDBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose ALL Patient Visit functionality i.e create/update, view, processing
 *
 * @author andrew
 */
@Path(IRestConfigs.VISITS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VisitRestService extends BaseEntityRestService<Visit> {

	@Autowired
	private VisitDBService dbService;

	@GET
	@Override
	public BaseListResponse<Visit> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	@GET
	@Path(IRestConfigs.UUID_PATH)
	@Override
	public Visit getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Override
	public Visit saveEntity(Visit entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public Visit processVisit(@PathParam("uuid") String uuid, @PathParam("processType") String docAction)
			throws Exception {
		return dbService.processEntity(uuid, docAction);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public Visit saveAndProcessVisit(Visit entity, @PathParam("processType") String docAction) throws Exception {
		return dbService.saveAndProcessEntity(entity, docAction);
	}

	@GET
	@Path(IRestConfigs.VISIT_QUEUE_PATH)
	public BaseListResponse<Visit> getVisitQueue(@QueryParam("page") int page, @QueryParam("size") int size) {
		return dbService.getVisitQueue(getPagingInfo(page, size));
	}

	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Visit> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@DELETE
	@Path(IRestConfigs.UUID_PATH)
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		return dbService.deleteEntity(uuid);
	}

	@GET
	@Path(IRestConfigs.VISIT_OPEN_DRAFTS)
	public BaseListResponse<Visit> getListOpenDrafts(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortOrder") String sortJson) {
		return dbService.getOpenVisitDrafts(getPagingInfo(page, size), sortJson);
	}

	@GET
	@Path(IRestConfigs.VISIT_OPEN_DRAFTS_COUNT)
	public Integer getOpenDraftsCount() {
		return dbService.getOpenVisitDraftsCount();
	}
}
