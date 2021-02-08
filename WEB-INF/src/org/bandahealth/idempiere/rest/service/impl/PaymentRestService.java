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
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.PaymentDBService;

@Path(IRestConfigs.PAYMENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentRestService extends BaseEntityRestService<Payment> {

	private PaymentDBService dbService;

	public PaymentRestService() {
		dbService = new PaymentDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Payment> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.PAYMENT_PATH)
	@Override
	public Payment getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Payment saveEntity(Payment entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.ENTITY_PROCESS_PATH)
	public Payment processPayment(@PathParam("uuid") String uuid, @PathParam("processType") String docAction)
			throws Exception {
		return dbService.processEntity(uuid, docAction);
	}

	@POST
	@Path(IRestConfigs.ENTITY_SAVE_AND_PROCESS_PATH_2)
	public Payment saveAndProcessVisit(Payment entity, @PathParam("processType") String docAction) throws Exception {
		return dbService.saveAndProcessEntity(entity, docAction);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Payment> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}
}
