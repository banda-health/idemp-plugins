package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.VoidedReasonDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.VOIDED_REASONS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VoidedReasonRestService extends BaseRestService<VoidedReason, MBHVoidedReason, VoidedReasonDBService> {

	@Autowired
	private VoidedReasonDBService dbService;

	@Override
	protected VoidedReasonDBService getDBService() {
		return dbService;
	}
}
