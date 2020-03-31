package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.IProcessRestService;
import org.bandahealth.idempiere.rest.service.db.ProcessDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.BaseListResponse;

@Path(IRestConfigs.PROCESS_PATH)
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
	public BaseListResponse<Process> getAll(@PathParam("page") int page, @PathParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder) {
		return ProcessDBService.getAll(getPagingInfo(page, size));
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
	public Process saveEntity(Process entity) {
		return null;
	}

	@Override
	public BaseListResponse<Process> search(String value, int page, int size) {
		return null;
	}
}
