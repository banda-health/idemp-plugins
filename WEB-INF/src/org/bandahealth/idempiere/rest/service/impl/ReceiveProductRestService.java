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
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ReceiveProductDBService;
import org.compiere.process.DocAction;

/**
 * Expense Receive Product REST functionality
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.RECEIVE_PRODUCTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiveProductRestService extends BaseEntityRestService<ReceiveProduct> {

	private ReceiveProductDBService dbService;

	public ReceiveProductRestService() {
		this.dbService = new ReceiveProductDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<ReceiveProduct> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<ReceiveProduct> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.RECEIVE_PRODUCT_PATH)
	@Override
	public ReceiveProduct getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public ReceiveProduct saveEntity(ReceiveProduct entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public ReceiveProduct processVisit(@PathParam("uuid") String uuid) {
		return dbService.processEntity(uuid, DocAction.ACTION_Complete);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH)
	public ReceiveProduct saveAndProcessVisit(ReceiveProduct entity) {
		return dbService.saveAndProcessEntity(entity, DocAction.ACTION_Complete);
	}
	
	@DELETE
	@Path(IRestConfigs.RECEIVE_PRODUCT_PATH)
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		return dbService.deleteEntity(uuid);
	}
}
