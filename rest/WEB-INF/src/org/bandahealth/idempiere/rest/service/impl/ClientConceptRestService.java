package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.ClientConcept;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ClientConceptDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.CLIENT_CONCEPTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientConceptRestService extends BaseRestService<ClientConcept, MBHClientConcept, ClientConceptDBService> {

	@Autowired
	private ClientConceptDBService dbService;

	@Override
	protected ClientConceptDBService getDBService() {
		return dbService;
	}
}
