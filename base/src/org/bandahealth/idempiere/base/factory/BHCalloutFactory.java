package org.bandahealth.idempiere.base.factory;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.bandahealth.idempiere.base.callout.CalloutGeneratePatientId;
import org.bandahealth.idempiere.base.callout.InventoryQuantity;
import org.bandahealth.idempiere.base.callout.ProductTypeCheck;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.util.CLogger;

import java.util.ArrayList;
import java.util.List;

public class BHCalloutFactory implements IColumnCalloutFactory {

	CLogger log = CLogger.getCLogger(BHCalloutFactory.class);

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		List<IColumnCallout> callouts = new ArrayList<>();
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_PatientID)) {
				callouts.add(new CalloutGeneratePatientId());
			}
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MOrderLine_BH.COLUMNNAME_M_Product_ID)) {
				callouts.add(new InventoryQuantity());
				callouts.add(new ProductTypeCheck());
			}
			if (columnName.equalsIgnoreCase(MOrderLine_BH.COLUMNNAME_M_AttributeSetInstance_ID)) {
				callouts.add(new InventoryQuantity());
			}
		}

		return callouts.toArray(new IColumnCallout[0]);
	}
}
