package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.ReferenceRepository;
import org.compiere.model.MReference;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.REFERENCES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReferenceRestService {

	private final ReferenceRepository referenceRepository;

	public ReferenceRestService() {
		referenceRepository = new ReferenceRepository();
	}

	@GET
	public Map<Integer, MReference> get(@QueryParam("ids") Set<Integer> ids) {
		return referenceRepository.getByIds(ids);
	}
}
