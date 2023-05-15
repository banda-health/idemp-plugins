package org.bandahealth.idempiere.base.process;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MClient;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class CheckUnprocessedPaymentsProcess extends SvrProcess {

	private final String PROCESS_NAME = this.getClass().getName();
	
	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START " + PROCESS_NAME);
		
		MClient client = new Query(getCtx(), MClient.Table_Name, MClient.COLUMNNAME_AD_Client_ID + " =?", get_TrxName())
				.setParameters(Env.getAD_Client_ID(getCtx()))
				.first();

		// get drafted payments with complete orders
		String whereClause = MPayment_BH.COLUMNNAME_DocStatus
				+ " = ? AND " + MPayment_BH.COLUMNNAME_BH_Visit_ID + " IN(SELECT " + MOrder_BH.COLUMNNAME_BH_Visit_ID
				+ " FROM " + MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_DocStatus + " = ?)";
		
		List<MPayment_BH> payments = new Query(getCtx(), MPayment_BH.Table_Name, whereClause, get_TrxName())
				.setParameters(MPayment_BH.DOCSTATUS_Drafted, MOrder_BH.DOCSTATUS_Completed)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.setOrderBy(MPayment_BH.COLUMNNAME_Created + " DESC")
				.list();
		
		log.log(Level.INFO, "FAULTY PAYMENTS::::: " + payments.size());
		
		if (payments.isEmpty()) {
			return null;
		}
		
		// get orders
		whereClause = MOrder_BH.COLUMNNAME_DocStatus + " = ? AND " + MOrder_BH.COLUMNNAME_C_Order_ID + " IN ("
				+ "SELECT " + MPayment_BH.COLUMNNAME_BH_Visit_ID + " FROM " + MPayment_BH.Table_Name + " WHERE "
				+ MPayment_BH.COLUMNNAME_DocStatus + " =? )";
		List<MOrder_BH> orders = new Query(getCtx(), MOrder_BH.Table_Name, whereClause, get_TrxName())
				.setParameters(MOrder_BH.DOCSTATUS_Completed, MPayment_BH.DOCSTATUS_Drafted)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.list();
		
		int count = 0;
		for (MPayment_BH payment : payments) {
			MBPartner bpartner = getBpartner(payment.getC_BPartner_ID());
			if (bpartner == null) {
				continue;
			}
			
			MOrder_BH order = orders.stream()
					.filter(o -> o.getBH_Visit_ID() == payment.getBH_Visit_ID())
					.findFirst()
					.orElse(null);
			if (order == null) {
				continue;
			}
			
			logInformation(payment, order, bpartner, client);
			payment.processIt(DocAction.ACTION_Complete);
			logInformation(payment, order, getBpartner(payment.getC_BPartner_ID()), client);
			count++;
		}

		String msg = "STOP " + PROCESS_NAME + ". Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " order(s).";
		log.log(Level.INFO, msg);

		return msg;
	}
	
	private void logInformation(MPayment_BH payment, MOrder_BH order , MBPartner bpartner, MClient client) {
		log.log(Level.INFO,
				"Date = " + payment.getCreated()
				+ " | Client = " + client.getName()
				+ " | Patient = " + bpartner.getName() 
				+ " | Total Open Balance = " + bpartner.getTotalOpenBalance()
				+ " | Order ID = " + order.get_ID()
				+ " | Payment ID = " + payment.get_ID()
				+ " | Payment Amount = " + payment.getPayAmt()
				+ " | DocStatus = " + payment.getDocStatus()
				+ " | Grand Total = " + order.getGrandTotal());
	}
	
	private MBPartner getBpartner(int bpartnerId) {
		MBPartner bpartner = new Query(getCtx(), MBPartner.Table_Name, MBPartner.COLUMNNAME_C_BPartner_ID + " =?", get_TrxName())
				.setParameters(bpartnerId)
				.first();
		 
		return bpartner;
	}
}
