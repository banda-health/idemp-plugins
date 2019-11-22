package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.service.db.TermsOfServiceService;

@Path(IRestConfigs.TERMSOFSERVICE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TermsOfServiceRestService {

	@POST
	@Path(IRestConfigs.ACCEPT_TERMSOFSERVICE_PATH)
	public boolean acceptTermsOfService() {
		return TermsOfServiceService.acceptTermsOfUse();
	}
}
