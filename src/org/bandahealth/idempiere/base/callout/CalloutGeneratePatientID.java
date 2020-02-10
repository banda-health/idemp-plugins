package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;

/**
 * Generate Patient ID for clinics.
 * 
 * @author andrew
 *
 */
public class CalloutGeneratePatientID implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if (mField.getColumnName().equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_PatientID)) {
			if (value != null) {
				return null;
			}

			// retrieve last entered patient
			MBPartner_BH lastPatient = new Query(ctx, MBPartner_BH.Table_Name, null, null).setOnlyActiveRecords(true)
					.setClient_ID().setOrderBy(MBPartner_BH.COLUMNNAME_Created + " DESC").first();
			String patientId = lastPatient.getBH_PatientID();
			// check if numeric
			if (patientId != null && patientId.chars().allMatch(Character::isDigit)) {
				int numericPatientId = Integer.valueOf(patientId);
				// increment patient id by 1
				numericPatientId++;
				mTab.setValue(MBPartner_BH.COLUMNNAME_BH_PatientID, numericPatientId);
			} else {
				// show the last patient id.
				mTab.setValue(MBPartner_BH.COLUMNNAME_BH_LastPatientID, patientId);
			}
		}

		return null;
	}
}
