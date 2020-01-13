package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.PatientDBService;

/**
 * Expose Patient REST functionality
 * 
 * TODO: Error handling and logging.
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.PATIENTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientRestService extends BaseEntityRestService<Patient> {

	private PatientDBService dbService;

	public PatientRestService() {
		dbService = new PatientDBService();
	}

	@POST
	@Path(IRestConfigs.ROOT_PATH)
	@Override
	public BaseListResponse<Patient> getAll(@QueryParam("page") int page, @QueryParam("size") int size) {
		return dbService.getAll(getPagingInfo(page, size));
	}

	@POST
	@Path(IRestConfigs.PATIENT_PATH)
	@Override
	public Patient getEntity(@PathParam("uuid") String uuid) {
		return dbService.getBusinessPartner(uuid);
	}

	@POST
	@Path(IRestConfigs.UPDATE_PATH)
	@Override
	public Patient updateEntity(Patient entity) {
		return dbService.savePatient(entity);
	}

	@POST
	@Path(IRestConfigs.CREATE_PATH)
	@Override
	public Patient createEntity(Patient entity) {
		return dbService.savePatient(entity);
	}
}
