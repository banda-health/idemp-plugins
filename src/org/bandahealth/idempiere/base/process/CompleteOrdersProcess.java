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

public class CompleteOrdersProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}

	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START CompleteOrdersProcess");

		List<MPayment_BH> payments = new Query(getCtx(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_PROCESSING + " = ? AND " + MPayment_BH.COLUMNNAME_DocStatus + " = ?",
				get_TrxName()).setParameters("Y", MPayment_BH.DOCSTATUS_Drafted)
						.setOrderBy(MPayment_BH.COLUMNNAME_Created + " DESC").list();
		log.log(Level.INFO, "ORDERS::::: " + payments.size());
		int count = 0;
		for (MPayment_BH payment : payments) {
			MOrder_BH salesOrder = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_TrxName()).setParameters(payment.getBH_C_Order_ID()).first();
			if (salesOrder == null) {
				log.log(Level.SEVERE,
						"NO Matching SO (" + payment.getBH_C_Order_ID() + "), Payment (" + payment.get_ID()
								+ "), PaymentAmount (" + payment.getPayAmt() + "), Client "
								+ payment.getAD_Client_ID());
				continue;
			}

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

		log.log(Level.INFO, "STOP CompleteOrdersProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count + " order(s).");

		return null;
	}
}
