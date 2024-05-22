package org.bandahealth.idempiere.graphql.utils;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MJournal;
import org.eevolution.model.I_DD_Order;
import org.eevolution.model.I_HR_Payroll;

import java.util.Map;

public class MRefListUtil {
	public static final Map<String, Integer> tableIdsByDocumentBaseType() {
		return Map.ofEntries(Map.entry(MDocType_BH.DOCBASETYPE_SalesOrder, MOrder_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_PurchaseOrder, MOrder_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_MaterialDelivery, MInOut_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_MaterialReceipt, MInOut_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_APInvoice, MInvoice_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_ARInvoice, MInvoice_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_APPayment, MPayment_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_ARReceipt, MPayment_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_GLJournal, MJournal.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_PaymentAllocation, MAllocationHdr.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_MaterialMovement, MMovement_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_MaterialPhysicalInventory, MInventory_BH.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_DistributionOrder, I_DD_Order.Table_ID),
				Map.entry(MDocType_BH.DOCBASETYPE_Payroll, I_HR_Payroll.Table_ID));
	}
}
