package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.RoleDBService;
import org.compiere.model.MRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(IRestConfigs.ROLES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoleRestService extends BaseRestService<Role, MRole, RoleDBService> {
	@Autowired
	private RoleDBService dbService;

	@Override
	protected RoleDBService getDBService() {
		return dbService;
	}

	@DELETE
	@Path("/{uuid}")
	@Override
	public Boolean deleteEntity(@PathParam("uuid") String uuid) {
		throw new NotImplementedException();
	}

	@POST
	@Override
	public Role save(Role entity) {
		throw new NotImplementedException();
	}
}
