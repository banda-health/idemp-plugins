package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.model.ProcessInfoParameter;
import org.bandahealth.idempiere.rest.model.ReportType;
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
import org.bandahealth.idempiere.rest.utils.HttpHeaderUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MProcess;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

@Path(IRestConfigs.PROCESS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessRestService extends BaseEntityRestService<Process> implements IProcessRestService<Process> {

	@Autowired
	private ProcessDBService processDBService;

	@POST
	@Path("/run")
	@Override
	public BHProcessInfo runProcess(BHProcessInfo request) {
		return ProcessDBService.runProcess(request);
	}

	@GET
	@Override
	public BaseListResponse<Process> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return processDBService.getAll(filterJson, sortJson, getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.RUN_AND_EXPORT_PATH + "/{processUuid}/{reportType}")
	@Produces(IRestConfigs.APPLICATION_PDF)
	public Response runAndExport(@PathParam("processUuid") String processUuid,
			@PathParam("reportType") ReportType reportType, List<ProcessInfoParameter> processInfoParameters) {
		if (StringUtil.isNullOrEmpty(processUuid)) {
			log.severe("Report not specified");
			return null;
		}
		MProcess process = processDBService.getEntityByUuidFromDB(processUuid);

		File report = processDBService.runAndExport(process, reportType, processInfoParameters);

		if (report == null) {
			log.severe("Error Generating report " + process.getName());
			return null;
		}

		Response.ResponseBuilder response = Response.ok((Object) report);
		HttpHeaderUtil.setContentDisposition(response, process.getName() + "." + reportType.toString().toLowerCase());
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
	public BaseListResponse<Process> search(String value, int page, int size, String sortColumn, String sortOrder) {
		return null;
	}
}
