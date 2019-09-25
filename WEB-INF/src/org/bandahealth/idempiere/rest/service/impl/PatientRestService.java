package org.bandahealth.idempiere.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.BaseRestService;
import org.bandahealth.idempiere.rest.model.Patient;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Expose Patients REST functionality
 * 
 * TODO: Db logic should be abstracted. Error handling
 * 
 * @author andrew
 *
 */
@Path("/patientservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientRestService extends BaseRestService<Patient> {

	public PatientRestService() {
	}

	public PatientRestService(MessageContext jaxrsContext) {
		this.jaxrsContext = jaxrsContext;
	}

	@POST
	@Path("/patients")
	@Override
	public List<Patient> getAll() {
		List<Patient> results = new ArrayList<>();
		List<MBPartner_BH> patients = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?", null).setParameters(true).list();
		if (!patients.isEmpty()) {
			for (MBPartner_BH patient : patients) {
				results.add(new Patient(patient.getAD_Client_ID(), patient.getAD_Org_ID(), patient.getC_BPartner_UU(),
						patient.isActive(), patient.getCreated(), patient.getCreatedBy(), patient.getDescription(),
						patient.getName(), patient.getTotalOpenBalance()));
			}
		}

		return results;
	}

	@POST
	@Path("/patient/{uuid}")
	@Override
	public Patient getEntity(@PathParam("uuid") String uuid) {
		MBPartner_BH patient = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", null).setParameters(uuid).first();

		if (patient != null) {
			return new Patient(patient.getAD_Client_ID(), patient.getAD_Org_ID(), patient.getC_BPartner_UU(),
					patient.isActive(), patient.getCreated(), patient.getCreatedBy(), patient.getDescription(),
					patient.getName(), patient.getTotalOpenBalance());
		}

		return null;
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
