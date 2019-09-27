package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.IProcessRestService;
import org.bandahealth.idempiere.rest.service.db.ProcessDBService;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;

@Path("/processservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessRestService extends BaseEntityRestService<Process> implements IProcessRestService<Process> {

	@POST
	@Path("/run")
	@Override
	public BHProcessInfo runProcess(BHProcessInfo request) {
		return ProcessDBService.runProcess(request);
	}

	@POST
	@Path("/processes")
	@Override
	public List<Process> getAll() {
		return ProcessDBService.getAll();
	}

	@POST
	@Path("/process/{uuid}")
	@Override
	public Process getEntity(@PathParam("uuid") String uuid) {
		return ProcessDBService.getProcess(uuid);
	}

	@POST
	@Path("/update")
	@Override
	public Process updateEntity(Process entity) {
		return null;
	}

	@POST
	@Path("/create")
	@Override
	public Process createEntity(Process entity) {
		return null;
	}

}
