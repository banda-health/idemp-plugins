package org.bandahealth.idempiere.base.callout;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.CLogger;

public class BusinessPartnerAge implements IColumnCallout {

	CLogger log = CLogger.getCLogger(BusinessPartnerAge.class);

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		String errorMessage = null;

		if (mField.getColumnName().equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_ApproximateYears)) {
			int approximateYears = (int) value;
			Calendar birthday = Calendar.getInstance();
			birthday.add(Calendar.YEAR, approximateYears * -1);
			Timestamp birthdayTimestamp = new Timestamp(birthday.getTimeInMillis());

			mTab.setValue(MBPartner_BH.COLUMNNAME_BH_Birthday, birthdayTimestamp);
		}

		return errorMessage;
	}
}
