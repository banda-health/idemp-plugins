package org.bandahealth.idempiere.base.process;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.process.call.ProcessSalesOrder;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class CompleteOrdersProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START CompleteOrdersProcess");

		// get payments which have failed to process and order docstatus is Drafted, In
		// Progress.
		String whereClause = MPayment_BH.COLUMNNAME_BH_PROCESSING + " = ? AND " + MPayment_BH.COLUMNNAME_DocStatus
				+ " != ? AND " + MPayment_BH.COLUMNNAME_BH_C_Order_ID + " IN(SELECT " + MOrder_BH.COLUMNNAME_C_Order_ID
				+ " FROM " + MOrder_BH.Table_Name + " WHERE " + MOrder_BH.COLUMNNAME_DocStatus + " IN('"
				+ MOrder_BH.DOCSTATUS_Drafted + "','" + MOrder_BH.DOCSTATUS_InProgress + "'))";
		List<MPayment_BH> payments = new Query(getCtx(), MPayment_BH.Table_Name, whereClause, get_TrxName())
				.setParameters("Y", MPayment_BH.DOCSTATUS_Invalid)// .setClient_ID()
				.setOnlyActiveRecords(true).list();
		log.log(Level.INFO, "ORDER PAYMENTS::::: " + payments.size());
		int count = 0;
		int usersAD_Client_ID = Env.getAD_Client_ID(Env.getCtx());
		for (MPayment_BH payment : payments) {
			// the DocStatus could be in Drafted, In Progress.
			MOrder_BH salesOrder = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_TrxName()).setParameters(payment.getBH_C_Order_ID()).first();
			if (salesOrder == null) {
				log.log(Level.SEVERE,
						"Sales Order ID (" + payment.getBH_C_Order_ID() + ") not found for Payment ID ("
								+ payment.get_ID() + "), PaymentAmount (" + payment.getPayAmt() + "), Client "
								+ payment.getAD_Client_ID());
				// invalidate such payments. need to investigate how they have an non-existent
				// order.
				payment.setDocStatus(MPayment_BH.DOCSTATUS_Invalid);
				payment.saveEx();
				continue;
			}

			if (salesOrder.getDocStatus().equalsIgnoreCase(MOrder_BH.DOCSTATUS_InProgress)) {
				salesOrder.setDocStatus(MOrder_BH.DOCSTATUS_Drafted);
				salesOrder.saveEx();
			}

			if (!payment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Drafted)) {
				payment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
				payment.saveEx();
			}

			// check if any order is being processed.
			if (isProcessing()) {
				continue;
			}

			// Several entities use the AD_Client value in the context to determine their own
			// This leads to bad results when processing orders because then the allocations have
			// the wrong AD_Client_IDs and can't fetch the appropriate Bank Accounts and Account Schemas
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, salesOrder.getAD_Client_ID());

			new ProcessSalesOrder(salesOrder, getCtx(), get_TrxName(), new ProcessCallback<String>() {

				@Override
				public void onSuccess(Properties context, String transactionName) {
					payment.setBH_Processing(false);
					payment.saveEx();

					log.log(Level.INFO, "SUCCESSFULLY processed order: " + payment.getBH_C_Order_ID());
				}

				@Override
				public void onError(String result, Properties context, String transactionName) {
					log.log(Level.SEVERE,
							"Error processing order " + payment.getBH_C_Order_ID() + " - **Detail** " + result);
				}
			}).processIt();
			count++;
		}

		// Reset the AD_Client_ID to be correct
		Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, usersAD_Client_ID);

		String msg = "STOP CompleteOrdersProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " order(s).";
		log.log(Level.INFO, msg);

		return msg;
	}

	private boolean isProcessing() {
		boolean isProcessing = new Query(getCtx(), MOrder_BH.Table_Name,
				MOrder_BH.COLUMNNAME_Processing + " =? AND " + MOrder_BH.COLUMNNAME_DocStatus + " != ?", get_TrxName())
						.setParameters("Y", MOrder_BH.DOCSTATUS_Invalid).match();
		log.log(Level.INFO, "Processing any orders? " + isProcessing);

		return isProcessing;
	}
}
