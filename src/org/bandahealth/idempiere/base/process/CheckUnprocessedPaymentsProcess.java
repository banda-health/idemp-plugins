package org.bandahealth.idempiere.base.process;

import java.util.List;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MClient;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;

public class CheckUnprocessedPaymentsProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START CheckFaultPaymentsProcess");

		// get drafted payments with complete orders
		String whereClause = MPayment_BH.COLUMNNAME_DocStatus
				+ " = ? AND " + MPayment_BH.COLUMNNAME_BH_C_Order_ID + " IN(SELECT " + MOrder_BH.COLUMNNAME_C_Order_ID
				+ " FROM " + MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_DocStatus + " = ?)";
		
		List<MPayment_BH> payments = new Query(getCtx(), MPayment_BH.Table_Name, whereClause, get_TrxName())
				.setParameters(MPayment_BH.DOCSTATUS_Drafted, MOrder_BH.DOCSTATUS_Completed)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.setOrderBy(MPayment_BH.COLUMNNAME_Created + " DESC")
				.list();
		
		log.log(Level.INFO, "FAULTY PAYMENTS::::: " + payments.size());
		int count = 0;
		for (MPayment_BH payment : payments) {
			logInformation(payment);
			payment.processIt(DocAction.ACTION_Complete);
			logInformation(payment);
			
			count++;
		}

		String msg = "STOP CheckUnprocessedPaymentsProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " order(s).";
		log.log(Level.INFO, msg);

		return msg;
	}
	
	private void logInformation(MPayment_BH payment) {
		MOrder_BH order = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + " =?", get_TrxName())
				.setParameters(payment.getBH_C_Order_ID())
				.first();
		if (order == null) {
			return;
		}
		
		MBPartner bpartner = new Query(getCtx(), MBPartner.Table_Name, MBPartner.COLUMNNAME_C_BPartner_ID + " =?", get_TrxName())
				.setParameters(order.getC_BPartner_ID())
				.first();
		if (bpartner == null) {
			return;
		}
		
		MClient client = new Query(getCtx(), MClient.Table_Name, MClient.COLUMNNAME_AD_Client_ID + " =?", get_TrxName())
				.setParameters(payment.getAD_Client_ID())
				.first();
		
		log.log(Level.INFO,
				"Date = " + payment.getCreated()
				+ " | Client = " + client.getName()
				+ " | Patient = " + bpartner.getName() 
				+ " | Total Open Balance = " + bpartner.getTotalOpenBalance()
				+ " | Order ID = " + payment.getBH_C_Order_ID()
				+ " | Payment ID = " + payment.get_ID()
				+ " | Payment Amount = " + payment.getPayAmt()
				+ " | DocStatus = " + payment.getDocStatus()
				+ " | Grand Total = " + order.getGrandTotal());
	}
}
