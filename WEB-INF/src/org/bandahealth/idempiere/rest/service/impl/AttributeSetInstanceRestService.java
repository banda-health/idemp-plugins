package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.AttributeSetInstanceRepository;
import org.compiere.model.MAttributeSetInstance;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.ATTRIBUTE_SET_INSTANCES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetInstanceRestService {

	private final AttributeSetInstanceRepository attributeSetInstanceRepository;

	public AttributeSetInstanceRestService() {
		attributeSetInstanceRepository = new AttributeSetInstanceRepository();
	}

	@GET
	public Map<Integer, MAttributeSetInstance> get(@QueryParam("ids") Set<Integer> ids) {
		return attributeSetInstanceRepository.getByIds(ids);
	}
}
