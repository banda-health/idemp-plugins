package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ClientConceptExtra;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ClientConceptExtraDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.CLIENT_CONCEPT_EXTRAS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientConceptExtraRestService extends BaseRestService<ClientConceptExtra, MBHClientConceptExtra, ClientConceptExtraDBService> {

	@Autowired
	private ClientConceptExtraDBService dbService;

	@Override
	protected ClientConceptExtraDBService getDBService() {
		return dbService;
	}
}
