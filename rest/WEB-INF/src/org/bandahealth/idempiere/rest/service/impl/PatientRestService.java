package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.PatientDBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Expose Patient REST functionality
 * <p>
 * TODO: Error handling and logging.
 *
 * @author andrew
 */
@Path(IRestConfigs.PATIENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientRestService extends BaseEntityRestService<Patient> {

	@Autowired
	private PatientDBService dbService;

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Patient> getAll(@QueryParam(IRestConfigs.QUERY_PARAMETER_PAGE) int page,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SIZE) int size,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_SORTING) String sortJson,
			@QueryParam(IRestConfigs.QUERY_PARAMETER_FILTER) String filterJson) {
		return dbService.getAll(getPagingInfo(page, size), sortJson, filterJson);
	}

	@POST
	@Path(IRestConfigs.PATIENT_PATH)
	@Override
	public Patient getEntity(@PathParam("uuid") String uuid) {
		return dbService.getEntity(uuid);
	}

	@POST
	@Path(IRestConfigs.SAVE_PATH)
	@Override
	public Patient saveEntity(Patient entity) {
		return dbService.saveEntity(entity);
	}

	@POST
	@Path(IRestConfigs.SEARCH_PATH)
	@Override
	public BaseListResponse<Patient> search(@QueryParam("value") String value, @QueryParam("page") int page,
			@QueryParam("size") int size, @QueryParam("sortColumn") String sortColumn,
			@QueryParam("sortOrder") String sortOrder) {
		return dbService.search(value, getPagingInfo(page, size), sortColumn, sortOrder);
	}

	@POST
	@Path(IRestConfigs.PATIENT_GENERATE_ID)
	public Patient generatePatientId() {
		Object generatedPatientId = QueryUtil.generateNextBHPatientId();
		Patient patient = new Patient();
		patient.setPatientNumber(generatedPatientId != null ? generatedPatientId.toString() : null);
		return patient;
	}
}
