package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;

public class CalloutOrder implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		int bpartnerId = Env.getContextAsInt(ctx, WindowNo + "|C_BPartner_ID");

		if (value != null) {
			if (mField.getColumnName().equalsIgnoreCase(MOrder_BH.COLUMNNAME_C_BPartner_ID)) {
				bpartnerId = (int) value;
			}

			boolean newVisit = QueryUtil.checkBHNewVisit(bpartnerId);
			GridField checkbox = mTab.getField(MOrder_BH.COLUMNNAME_BH_NEWVISIT);
			if (checkbox == null) {
				return null;
			}
			
			if (newVisit) {
				checkbox.setDisplayed(true);
			} else {
				checkbox.setDisplayed(false);
				mTab.setValue(MOrder_BH.COLUMNNAME_BH_NEWVISIT, false);
			}
		}

		return null;
	}
}
