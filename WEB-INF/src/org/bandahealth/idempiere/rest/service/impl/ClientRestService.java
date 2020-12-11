package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.ClientRepository;
import org.compiere.model.MClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path(IRestConfigs.CLIENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService {

	private static ClientRepository clientRepository;

	public ClientRestService() {
		clientRepository = new ClientRepository();
	}

	@GET
	public List<MClient> get(@QueryParam("ids") Set<Integer> ids) {
		return new ArrayList<>(clientRepository.getByIds(ids).values());
	}
}
