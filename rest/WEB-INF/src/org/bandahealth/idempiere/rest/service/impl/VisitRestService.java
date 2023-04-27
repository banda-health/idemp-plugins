package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.VisitDBService;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
public class VisitRestService extends BaseRestService<Visit, MBHVisit, VisitDBService> {

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

	// TODO: Remove these endpoints when order processing is separate from a visit

	/**
	 * A process method to allow visits to handle everything
	 *
	 * @param uuid           The UUID of the visit to process
	 * @param documentAction The process action to be executed
	 * @return The visit after it's been processed
	 * @throws Exception An error that occurred in processing
	 */
	@POST
	@Path("/{uuid}/process/{processType}")
	public Visit process(@PathParam("uuid") String uuid, @PathParam("processType") String documentAction)
			throws Exception {
		return getDBService().processDependentEntities(uuid, documentAction);
	}

	/**
	 * A sugar method to first save the entity to process, then process the entity
	 *
	 * @param entity         The visit to save and process
	 * @param documentAction The process action to be executed
	 * @return The saved and processed visit
	 * @throws Exception An error that occurred in processing
	 */
	@POST
	@Path("/process/{processType}")
	public Visit saveAndProcess(Visit entity, @PathParam("processType") String documentAction) throws Exception {
		if (!documentAction.equals(MOrder_BH.DOCACTION_Void)) {
			entity.setVoidedReason(null);
		}
		getDBService().saveEntity(entity);
		return getDBService().processDependentEntities(entity.getUuid(), documentAction);
	}
}
