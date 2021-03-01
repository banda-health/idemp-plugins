package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.model.ProcessInfo;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.IProcessRestService;
import org.bandahealth.idempiere.rest.service.db.ProcessDBService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.BaseListResponse;

import java.io.File;

@Path(IRestConfigs.PROCESS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessRestService extends BaseEntityRestService<Process> implements IProcessRestService<Process> {

	private final ProcessDBService processDBService;

	public ProcessRestService() {
		processDBService = new ProcessDBService();
	}

	@POST
	@Path("/run")
	@Override
	public BHProcessInfo runProcess(BHProcessInfo request) {
		return ProcessDBService.runProcess(request);
	}

	@GET
	@Override
	public BaseListResponse<Process> getAll(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sortColumn") String sortColumn, @QueryParam("sortOrder") String sortOrder,
			@QueryParam("filter") String filterJson) {
		return processDBService.getAll(filterJson, sortColumn, sortOrder, getPagingInfo(page, size));
	}

	@POST
	@Path("/generateReport")
	public Response generateReport(ProcessInfo processInfo) {
		File report = processDBService.generateReport(processInfo);

		if (report == null) {
			log.severe("Error Generating report " + processInfo.getName());
			return null;
		}

		Response.ResponseBuilder response = Response.ok((Object) report);
		response.header("Content-Disposition", "attachment; filename=\"" + processInfo.getName() + "\"." +
				processInfo.getReportOutputType().toString().toLowerCase() + "\"");
		return response.build();
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
	public BaseListResponse<Process> search(String value, int page, int size, String sortColumn,
			String sortOrder) {
		return null;
	}
}
