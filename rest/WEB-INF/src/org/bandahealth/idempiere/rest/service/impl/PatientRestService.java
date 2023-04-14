package org.bandahealth.idempiere.rest.service.impl;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.service.BaseRestService;
import org.bandahealth.idempiere.rest.service.db.PatientDBService;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
public class PatientRestService extends BaseRestService<Patient, MBPartner_BH, PatientDBService> {

	@Autowired
	private PatientDBService dbService;

	@POST
	@Path(IRestConfigs.PATIENT_GENERATE_ID)
	public Patient generatePatientId() {
		Patient patient = new Patient();
		patient.setPatientNumber(QueryUtil.generateNextBHPatientId(null).toString());
		return patient;
	}

	@Override
	protected PatientDBService getDBService() {
		return dbService;
	}
}
