package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.CHARGE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeRestService extends BaseEntityRestService<Charge> {
	private final ChargeDBService chargeDBService;

	public ChargeRestService() {
		chargeDBService = new ChargeDBService();
	}

	@GET
	@Path(IRestConfigs.NON_PATIENT_PAYMENTS_PATH)
	public BaseListResponse<Charge> getNonPatientPayments(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return chargeDBService.getNonPatientPayments(new Paging(page, size), sortColumn, sortOrder, filterJson);
	}

	@POST
	@Path(IRestConfigs.NON_PATIENT_PAYMENTS_PATH)
	public Charge saveNonPatientPayment(Charge entity) {
		return chargeDBService.saveNonPatientPayment(entity);
	}

	@Override
	@GET
	public BaseListResponse<Charge> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson, @QueryParam("sorted") String sortJson) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	public BaseListResponse<Charge> search(String value, int page, int size, String sortColumn, String sortOrder) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	@GET
	@Path(IRestConfigs.UUID_PATH)
	public Charge getEntity(@PathParam("uuid") String uuid) {
		return chargeDBService.getEntity(uuid);
	}

	@Override
	@POST
	public Charge saveEntity(Charge entity) {
		return chargeDBService.saveEntity(entity);
	}
}
