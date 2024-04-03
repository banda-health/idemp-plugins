package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.annotation.AdministratorOnly;
import org.bandahealth.idempiere.rest.model.Client;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ClientDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.AUTHENTICATION_PATH + "/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@AdministratorOnly
public class ClientRestService extends BaseRestService<Client, MClient_BH, ClientDBService> {
	private final ClientDBService clientDBService = new ClientDBService();

	@Override
	protected ClientDBService getDBService() {
		return clientDBService;
	}
}
