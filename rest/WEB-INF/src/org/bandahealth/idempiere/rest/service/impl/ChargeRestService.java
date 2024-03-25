package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.CHARGE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeRestService extends BaseRestService<Charge, MCharge_BH, ChargeDBService> {
	private final ChargeDBService chargeDBService = new ChargeDBService();

	@Override
	protected ChargeDBService getDBService() {
		return chargeDBService;
	}
}
