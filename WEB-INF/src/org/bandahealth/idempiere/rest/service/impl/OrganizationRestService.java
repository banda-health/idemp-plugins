package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.repository.OrganizationRepository;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path(IRestConfigs.ORGANIZATIONS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationRestService {

	private final OrganizationRepository organizationRepository;

	public OrganizationRestService() {
		organizationRepository = new OrganizationRepository();
	}

	@GET
	public Map<Integer, MOrg> get(@QueryParam("ids") Set<Integer> ids) {
		return organizationRepository.getByIds(ids);
	}

	@GET
	@Path("/clients")
	public Map<Integer, List<MOrg>> getByClientIds(@QueryParam("ids") Set<Integer> ids) {
		return organizationRepository.getGroupsByIds(MOrg::getAD_Client_ID, MOrg.COLUMNNAME_AD_Client_ID, ids);
	}
}
