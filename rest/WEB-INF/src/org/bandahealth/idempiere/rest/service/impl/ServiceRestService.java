package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Service;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ServiceDBService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Expose Service REST functionality
 *
 * @author andrew
 */
@Path(IRestConfigs.SERVICES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServiceRestService extends BaseRestService<Service, MProduct_BH, ServiceDBService> {

	@Autowired
	private ServiceDBService dbService;

	@Override
	protected ServiceDBService getDBService() {
		return dbService;
	}
}
