package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.Env;

public class CalloutPaymentNHIF implements IColumnCallout {

	private String errorMessage = null;

	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		String isSoTrx = Env.getContext(ctx, WindowNo, 0, "IsSOTrx");
		
		if (value != null) {
			String tenderType = (String) value;
			if (!tenderType.equalsIgnoreCase("N")) {
				return errorMessage;
			}
			
			// Make sure we are only dealing w/ the SO Payment line
			if (isSoTrx != null && isSoTrx.equalsIgnoreCase("Y")) {
				
				String cBpartnerID = Env.getContext(ctx, WindowNo + "|C_BPartner_ID"); 
				if (cBpartnerID != null) {
					MBPartner_BH bpartner = new MBPartner_BH(ctx, Integer.valueOf(cBpartnerID), null);
					
					mTab.setValue(MPayment_BH.COLUMNNAME_bh_nhif_relationship, bpartner.getbh_nhif_relationship());
					mTab.setValue(MPayment_BH.COLUMNNAME_BH_NHIF_MEMBER_NAME, bpartner.getbh_nhif_member_name());
					mTab.setValue(MPayment_BH.COLUMNNAME_NHIF_Number, bpartner.getNHIF_Number());
					mTab.setValue(MPayment_BH.COLUMNNAME_bh_nhif_member_id, bpartner.getNationalID());
					mTab.setValue(MPayment_BH.COLUMNNAME_BH_NHIF_Type, bpartner.getBH_NHIF_Type());
				}
			}
		}
		
		return errorMessage;
	}
}
