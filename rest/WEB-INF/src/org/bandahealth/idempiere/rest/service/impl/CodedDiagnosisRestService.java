package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.CodedDiagnosis;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.CodedDiagnosisDBService;
import org.springframework.beans.factory.annotation.Autowired;

@Path(IRestConfigs.CODED_DIAGNOSES_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CodedDiagnosisRestService extends BaseEntityRestService<CodedDiagnosis> {

	@Autowired
	private CodedDiagnosisDBService dbService;

	@GET
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<CodedDiagnosis> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	@GET
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<CodedDiagnosis> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@GET
	@Path(IRestConfigs.CODED_DIAGNOSIS_PATH)
	@Override
	public CodedDiagnosis getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public CodedDiagnosis saveEntity(CodedDiagnosis entity) {
		return dbService.saveEntity(entity);
	}

}
