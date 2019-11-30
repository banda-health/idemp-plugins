package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Patient;
import org.bandahealth.idempiere.rest.utils.DateUtil;

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

	@Override
	protected Patient createInstance(MBPartner_BH bpartner) {
		try {
			String address = "";
			if (bpartner.getBH_C_Location() != null) {
				address = bpartner.getBH_C_Location().getAddress1();
			}
			return new Patient(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getName(), bpartner.getDescription(), bpartner.getTotalOpenBalance(),
					bpartner.getBH_PatientID(), DateUtil.parse(bpartner.getBH_Birthday()), bpartner.getBH_Phone(),
					address, bpartner.get_ValueAsString("bh_gender"));
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

}
