package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeDBService;
import org.springframework.beans.factory.annotation.Autowired;

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
public class ChargeRestService extends BaseRestService<Charge, MCharge_BH, ChargeDBService> {
	@Autowired
	private ChargeDBService chargeDBService;

	@Override
	protected ChargeDBService getDBService() {
		return chargeDBService;
	}

	@GET
	@Path(IRestConfigs.NON_PATIENT_PAYMENTS_PATH)
	public BaseListResponse<Charge> getNonPatientPayments(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return chargeDBService.getNonPatientPayments(new Paging(page, size), sortJson, filterJson);
	}

	@POST
	@Path(IRestConfigs.NON_PATIENT_PAYMENTS_PATH)
	public Charge saveNonPatientPayment(Charge entity) {
		return chargeDBService.saveNonPatientPayment(entity);
	}
}
