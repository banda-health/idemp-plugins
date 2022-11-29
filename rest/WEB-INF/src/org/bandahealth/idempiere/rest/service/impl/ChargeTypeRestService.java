package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ChargeType;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ChargeTypeDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.CHARGE_TYPES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChargeTypeRestService extends BaseRestService<ChargeType, MChargeType_BH, ChargeTypeDBService> {
	@Autowired
	private ChargeTypeDBService dbService;

	@Override
	protected ChargeTypeDBService getDBService() {
		return dbService;
	}
}
