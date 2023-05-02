package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Organization;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.OrganizationDBService;
import org.compiere.model.MOrg;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.ORGANIZATIONS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationRestService extends BaseRestService<Organization, MOrg, OrganizationDBService> {
	@Autowired
	private OrganizationDBService dbService;

	@Override
	protected OrganizationDBService getDBService() {
		return dbService;
	}
	
	@DELETE
	@Path("/{uuid}")
	@Override
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		throw new NotImplementedException();
	}
}
