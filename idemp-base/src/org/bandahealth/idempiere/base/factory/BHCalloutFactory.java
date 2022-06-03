package org.bandahealth.idempiere.base.factory;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.bandahealth.idempiere.base.callout.BusinessPartnerAge;
import org.bandahealth.idempiere.base.callout.CalloutGeneratePatientId;
import org.bandahealth.idempiere.base.callout.CalloutOrder;
import org.bandahealth.idempiere.base.callout.CalloutPayment;
import org.bandahealth.idempiere.base.callout.CalloutPaymentNHIF;
import org.bandahealth.idempiere.base.callout.HomeScreenButtonSingleNavigationEnforcer;
import org.bandahealth.idempiere.base.callout.InventoryLineExpirationDateRequired;
import org.bandahealth.idempiere.base.callout.InventoryQuantity;
import org.bandahealth.idempiere.base.callout.OrderLineExpirationDateRequired;
import org.bandahealth.idempiere.base.callout.ProductTypeCheck;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.util.CLogger;

public class BHCalloutFactory implements IColumnCalloutFactory {

	CLogger log = CLogger.getCLogger(BHCalloutFactory.class);

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		List<IColumnCallout> callouts = new ArrayList<>();
		if (tableName.equalsIgnoreCase(MBPartner_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_ApproximateYears)
					|| columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_Birthday)) {
				callouts.add(new BusinessPartnerAge());
			}
			if (columnName.equalsIgnoreCase(MBPartner_BH.COLUMNNAME_BH_PatientID)) {
				callouts.add(new CalloutGeneratePatientId());
			}
		} else if (tableName.equalsIgnoreCase(MOrder_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MOrder_BH.COLUMNNAME_C_BPartner_ID)) {
				callouts.add(new CalloutOrder());
			}
		} else if (tableName.equalsIgnoreCase(MOrderLine_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MOrderLine_BH.COLUMNNAME_M_Product_ID)) {
				callouts.add(new OrderLineExpirationDateRequired());
				callouts.add(new InventoryQuantity());
				callouts.add(new ProductTypeCheck());
			}
			if (columnName.equalsIgnoreCase(MOrderLine_BH.COLUMNNAME_M_AttributeSetInstance_ID)) {
				callouts.add(new InventoryQuantity());
			}
		} else if (tableName.equalsIgnoreCase(MInventoryLine_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MInventoryLine_BH.COLUMNNAME_M_Product_ID)) {
				callouts.add(new InventoryLineExpirationDateRequired());
			}
		} else if (tableName.equalsIgnoreCase(MPayment_BH.Table_Name)) {
			if (columnName.equalsIgnoreCase(MPayment_BH.COLUMNNAME_TenderType)) {
				callouts.add(new CalloutPaymentNHIF());
			}
			if (columnName.equalsIgnoreCase(MPayment_BH.COLUMNNAME_C_BPartner_ID)) {
				callouts.add(new CalloutPayment());
			}
		}

		return callouts.toArray(new IColumnCallout[0]);
	}
}
