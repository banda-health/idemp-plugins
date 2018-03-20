package org.bandahealth.idempiere.base.factory;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.bandahealth.idempiere.base.callout.BusinessPartnerAge;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.util.CLogger;

public class BHCalloutFactory implements IColumnCalloutFactory {

	CLogger log = CLogger.getCLogger(BHCalloutFactory.class);

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {

		List<IColumnCallout> callouts = new ArrayList<>();


		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_ApproximateYears) ||
					columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_Birthday)) {
				callouts.add(new BusinessPartnerAge());
			}
		}

		return callouts.toArray(new IColumnCallout[0]);
	}
}
