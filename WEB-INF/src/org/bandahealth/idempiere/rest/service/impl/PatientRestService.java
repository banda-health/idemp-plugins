package org.bandahealth.idempiere.rest.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.service.BaseEntityRestService;
import org.bandahealth.idempiere.rest.service.db.PatientDBService;

/**
 * Expose Patients REST functionality
 * 
 * TODO: Error handling and logging.
 * 
 * @author andrew
 *
 */
@Path("/patientservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientRestService extends BaseEntityRestService<Patient> {

	public PatientRestService() {
	}

	@POST
	@Path("/patients")
	@Override
	public List<Patient> getAll() {
		return PatientDBService.getAll();
	}

	@POST
	@Path("/patient/{uuid}")
	@Override
	public Patient getEntity(@PathParam("uuid") String uuid) {
		return PatientDBService.getPatient(uuid);
	}

	@POST
	@Path("/update")
	@Override
	public Patient updateEntity(Patient entity) {
		return null;
	}

	@POST
	@Path("/create")
	@Override
	public Patient createEntity(Patient entity) {
		return null;
	}
}
