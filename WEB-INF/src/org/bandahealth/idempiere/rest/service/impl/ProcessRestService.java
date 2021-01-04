package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.repository.ProcessRepository;
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

import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BHProcessInfo;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.compiere.model.MProcess;
import org.compiere.process.ProcessInfoParameter;

import java.util.List;

@Path(IRestConfigs.PROCESS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessRestService extends BaseEntityRestService<Process> implements IProcessRestService<Process> {

	private final ProcessRepository processRepository;

	public ProcessRestService() {
		processRepository = new ProcessRepository();
	}

	@POST
	@Path("/run")
	@Override
	public BHProcessInfo runProcess(BHProcessInfo request) {
		return ProcessDBService.runProcess(request);
	}

	@POST
	@Path("/processes")
	@Override
	public BaseListResponse<Process> getAll(
			@QueryParam("page") int page, @QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder, @QueryParam("filter") String filterJson) {
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
	public BaseListResponse<Process> search(String value, int page, int size, String sortColumn,
			String sortOrder) {
		return null;
	}

	@GET
	public List<MProcess> get(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return processRepository.get(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/paginginfo")
	public Paging getPagingInfo(@QueryParam("page") int page, @QueryParam("size") int size,
			@QueryParam("sort") String sort, @QueryParam("filter") String filterJson) {
		return processRepository.getPagingInfo(filterJson, sort, new Paging(page, size));
	}

	@GET
	@Path("/{uuid}")
	public MProcess getByUuid(@PathParam("uuid") String uuid) {
		return processRepository.getByUuid(uuid);
	}

	@POST
	@Path("/generate/{uuid}/{reportOutputType}")
	public String generateReport(@PathParam("uuid") String processUuid,
			@PathParam("reportOutputType") String reportOutputType, List<ProcessInfoParameter> processInfoParameters) {
		return processRepository.generateReport(processUuid, reportOutputType, processInfoParameters);
	}
}
