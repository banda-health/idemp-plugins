package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;

public class CalloutPayment implements IColumnCallout {

	private String errorMessage = null;

	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		String cBpartnerID = Env.getContext(ctx, WindowNo + "|C_BPartner_ID");
		if (cBpartnerID != null && !cBpartnerID.equalsIgnoreCase("")) {
			MBPartner_BH bpartner = new MBPartner_BH(ctx, Integer.valueOf(cBpartnerID), null);

			mTab.setValue(MPayment_BH.COLUMNAME_TOTAL_OPEN_BALANCE, bpartner.getTotalOpenBalance());
		}

		return errorMessage;
	}
}
