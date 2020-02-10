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
			MBPartner_BH lastCreatedPatient = new Query(ctx, MBPartner_BH.Table_Name, null, null)
					.setOnlyActiveRecords(true).setClient_ID().setOrderBy(MBPartner_BH.COLUMNNAME_Created + " DESC, "
							+ MBPartner_BH.COLUMNNAME_BH_PatientID + " DESC")
					.first();
			String lastCreatedPatientId = lastCreatedPatient.getBH_PatientID();
			// check if numeric
			if (isNumeric(lastCreatedPatientId)) {
				int numericCreatedPatientId = Integer.valueOf(lastCreatedPatientId);

				// check if there is an updated record greater than the last entered patient id.
				MBPartner_BH lastUpdatedPatient = new Query(ctx, MBPartner_BH.Table_Name, null, null)
						.setOnlyActiveRecords(true).setClient_ID().setOrderBy(MBPartner_BH.COLUMNNAME_Updated + " DESC")
						.first();
				String lastUpdatedPatientId = lastUpdatedPatient.getBH_PatientID();
				if (isNumeric(lastUpdatedPatientId)) {
					int numericUpdatedPatientId = Integer.valueOf(lastUpdatedPatientId);
					if (numericUpdatedPatientId > numericCreatedPatientId) {
						numericUpdatedPatientId++;
						mTab.setValue(MBPartner_BH.COLUMNNAME_BH_PatientID, numericUpdatedPatientId);
						return null;
					}
				}

				// increment patient id by 1
				numericCreatedPatientId++;
				mTab.setValue(MBPartner_BH.COLUMNNAME_BH_PatientID, numericCreatedPatientId);
			} else {
				// show the last patient id.
				mTab.setValue(MBPartner_BH.COLUMNNAME_BH_LastPatientID, lastCreatedPatientId);
			}
		}

		return null;
	}

	private boolean isNumeric(String patientId) {
		return patientId != null && patientId.chars().allMatch(Character::isDigit);
	}
}
