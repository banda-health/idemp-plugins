package org.bandahealth.idempiere.rest.service.impl;

import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.VisitDBService;
import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.util.Env;

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

	private final VisitDBService dbService;

	public VisitRestService() {
		dbService = new VisitDBService();
	}

	@GET
	@Path("/graphql")
	public List<MOrder_BH> get(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_IsSOTrx + "=?",
				null).setParameters("Y").setClient_ID().setPage(10, 0).list();
	}

	@GET
	@Override
	public BaseListResponse<Visit> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
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

	@GET
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
	
	@DELETE
	@Path(IRestConfigs.UUID_PATH)
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		return dbService.deleteEntity(uuid);
	}
	
	@GET
	@Path(IRestConfigs.VISIT_OPEN_DRAFTS)
	public BaseListResponse<Visit> getListOpenDrafts(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return dbService.getOpenVisitDrafts(getPagingInfo(page, size), sortColumn, sortOrder);
	}
	
	@GET
	@Path(IRestConfigs.VISIT_OPEN_DRAFTS_COUNT)
	public Integer getOpenDraftsCount() {
		return dbService.getOpenVisitDraftsCount();
	}
}
