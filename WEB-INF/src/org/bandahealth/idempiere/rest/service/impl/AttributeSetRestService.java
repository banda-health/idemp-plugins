package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.AttributeSetRepository;
import org.compiere.model.MAttributeSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.ATTRIBUTE_SETS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AttributeSetRestService {

	private final AttributeSetRepository attributeSetRepository;

	public AttributeSetRestService() {
		attributeSetRepository = new AttributeSetRepository();
	}

	@GET
	public Map<Integer, MAttributeSet> get(@QueryParam("ids") Set<Integer> ids) {
		return attributeSetRepository.getByIds(ids);
	}
}
