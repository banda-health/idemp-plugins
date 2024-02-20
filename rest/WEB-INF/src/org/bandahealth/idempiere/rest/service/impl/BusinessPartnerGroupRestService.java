package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BusinessPartnerGroup;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.BusinessPartnerGroupDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/business-partner-groups")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BusinessPartnerGroupRestService
		extends BaseRestService<BusinessPartnerGroup, MBPGroup_BH, BusinessPartnerGroupDBService> {
	private final BusinessPartnerGroupDBService businessPartnerGroupDBService = new BusinessPartnerGroupDBService();

	@Override
	protected BusinessPartnerGroupDBService getDBService() {
		return businessPartnerGroupDBService;
	}
}
