package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.service.DocumentRestService;
import org.bandahealth.idempiere.rest.service.db.VisitDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Expose ALL Patient Visit functionality i.e create/update, view, processing
 *
 * @author andrew
 */
@Path(IRestConfigs.VISITS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VisitRestService extends DocumentRestService<Visit, MOrder_BH, VisitDBService> {

	@Autowired
	private VisitDBService dbService;

	@GET
	@Path(IRestConfigs.VISIT_QUEUE_PATH)
	public BaseListResponse<Visit> getVisitQueue(@QueryParam("page") int page, @QueryParam("size") int size) {
		return dbService.getVisitQueue(getPagingInfo(page, size));
	}

	@Override
	protected VisitDBService getDBService() {
		return dbService;
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
