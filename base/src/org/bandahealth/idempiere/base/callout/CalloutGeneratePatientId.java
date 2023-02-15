package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

/**
 * Generate Patient ID for clinics.
 * 
 * @author andrew
 *
 */
public class CalloutGeneratePatientId implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if (mField.getColumnName().equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_PatientID)) {
			if (value != null) {
				return null;
			}

			mTab.setValue(MBPartner_BH.COLUMNNAME_BH_PatientID, null);

		}

		return null;
	}
}
