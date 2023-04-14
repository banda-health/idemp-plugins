package org.bandahealth.idempiere.base.callout;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
			if (value != null) {
				BigDecimal approximateYears = (BigDecimal) value;
				Calendar birthday = Calendar.getInstance();
				if (approximateYears.compareTo(BigDecimal.ONE) < 0) {
					birthday.add(Calendar.MONTH, (approximateYears.multiply(new BigDecimal(12))).negate().intValue());
				} else {
					if (approximateYears.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
						birthday.add(Calendar.YEAR, approximateYears.negate().intValue());
					} else {
						BigDecimal years = approximateYears.setScale(0, RoundingMode.DOWN);
						BigDecimal months = approximateYears.remainder(years);

						birthday.add(Calendar.YEAR, years.negate().intValue());
						birthday.add(Calendar.MONTH, months.multiply(new BigDecimal(12)).negate().intValue());
					}
				}

				Timestamp birthdayTimestamp = new Timestamp(birthday.getTimeInMillis());

				mTab.setValue(MBPartner_BH.COLUMNNAME_BH_Birthday, birthdayTimestamp);
			}
		} else if (mField.getColumnName().equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_Birthday)) {
			mTab.setValue(MBPartner_BH.COLUMNNAME_BH_ApproximateYears, null);
		}

		return errorMessage;
	}
}
