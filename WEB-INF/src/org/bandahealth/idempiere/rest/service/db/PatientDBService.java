package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Patient;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class PatientDBService {

	public static List<Patient> getAll() {
		List<Patient> results = new ArrayList<>();

		List<MBPartner_BH> patients = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?", null).setClient_ID().setOnlyActiveRecords(true)
						.setParameters(true).list();
		if (!patients.isEmpty()) {
			for (MBPartner_BH patient : patients) {
				results.add(createPatientInstance(patient));
			}
		}

		return results;
	}

	public static Patient getPatient(String uuid) {
		MBPartner_BH patient = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", null).setOnlyActiveRecords(true).setParameters(uuid)
						.first();

		if (patient != null) {
			return createPatientInstance(patient);
		}

		return null;
	}

	private static Patient createPatientInstance(MBPartner_BH patient) {
		return new Patient(patient.getAD_Client_ID(), patient.getAD_Org_ID(), patient.getC_BPartner_UU(),
				patient.isActive(), patient.getCreated(), patient.getCreatedBy(), patient.getDescription(),
				patient.getName(), patient.getTotalOpenBalance());
	}
}
