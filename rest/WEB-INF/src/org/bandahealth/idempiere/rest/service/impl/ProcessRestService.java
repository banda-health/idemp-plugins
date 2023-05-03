package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.ProcessInfoParameter;
import org.bandahealth.idempiere.rest.model.ReportType;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.ProcessDBService;
import org.bandahealth.idempiere.rest.utils.HttpHeaderUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MProcess;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Path(IRestConfigs.PROCESS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessRestService extends BaseRestService<Process, MProcess_BH, ProcessDBService> {

	@Autowired
	private ProcessDBService dbService;

	@POST
	@Path(IRestConfigs.RUN_AND_EXPORT_PATH + "/{processUuid}/{reportType}")
	@Produces(IRestConfigs.APPLICATION_PDF)
	public Response runAndExport(@PathParam("processUuid") String processUuid,
			@PathParam("reportType") ReportType reportType, List<ProcessInfoParameter> processInfoParameters) {
		if (StringUtil.isNullOrEmpty(processUuid)) {
			log.severe("Report not specified");
			return null;
		}
		if (processInfoParameters == null) {
			processInfoParameters = new ArrayList<>();
		}
		MProcess process = dbService.getEntityByUuidFromDB(processUuid);

		File report = dbService.runAndExport(process, reportType, processInfoParameters);

		if (report == null) {
			log.severe("Error Generating report " + process.getName());
			return null;
		}

		Response.ResponseBuilder response = Response.ok((Object) report);
		HttpHeaderUtil.setContentDisposition(response, process.getName() + "." + reportType.toString().toLowerCase());
		return response.build();
	}

	@POST
	@Path("run/{processUuid}")
	public Response runProcess(@PathParam("processUuid") String processUuid,
			List<ProcessInfoParameter> processInfoParameters) throws Exception {
		if (StringUtil.isNullOrEmpty(processUuid)) {
			log.severe("Process not specified");
			return null;
		}
		if (processInfoParameters == null) {
			processInfoParameters = new ArrayList<>();
		}
		MProcess process = dbService.getEntityByUuidFromDB(processUuid);
		String processResponse = dbService.run(process, processInfoParameters);
		Response.ResponseBuilder response = Response.ok(processResponse);
		return response.build();
	}

	@Override
	protected ProcessDBService getDBService() {
		return dbService;
	}
}
