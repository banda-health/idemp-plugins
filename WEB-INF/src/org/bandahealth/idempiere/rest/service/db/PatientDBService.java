package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Patient;

public class PatientDBService extends BusinessPartnerDBService<Patient> {

	private String WHERE_CLAUSE = MBPartner_BH.COLUMNNAME_BH_IsPatient + "=?";
	private List<Object> parameters = new ArrayList<>();

	public PatientDBService() {
		parameters.add("Y");
		setQueryConditions(WHERE_CLAUSE, parameters);
	}

	@Override
	protected Patient getInstance() {
		return new Patient();
	}

}
