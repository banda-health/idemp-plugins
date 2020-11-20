package org.bandahealth.idempiere.base.process;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.process.call.SalesProcessAsyncCall;
import org.compiere.Adempiere;
import org.compiere.model.MClient;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class SalesProcess extends SvrProcess {

	private int orderId;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();

		for (ProcessInfoParameter parameter : parameters) {

			String parameterName = parameter.getParameterName();

			if (parameterName.equalsIgnoreCase("c_order_id")) {
				orderId = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		// check receive goods/expenses
		MOrder_BH order = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?", get_TrxName())
				.setParameters(orderId).first();
		if (!order.isSOTrx()) {
			order.setBH_Isexpense(true);
			order.processIt(DocAction.ACTION_Complete);
			return null;
		}
		
		setPaymentStatus(true, null, null);

		// async call.
		Adempiere.getThreadPoolExecutor()
				.schedule(new SalesProcessAsyncCall(getCtx(), orderId, new ProcessCallback<String>() {

					@Override
					public void onSuccess(Properties context, String transactionName) {
						setPaymentStatus(false, context, transactionName);
					}

					@Override
					public void onError(String error, Properties context, String transactionName) {
						// setPaymentStatus(false, context, transactionName);

						MClient client = MClient.get(getCtx(), getAD_Client_ID());
						client.sendEMail("implementer@bandahealth.org", "ERROR PROCESSING PATIENT BILL",
								createHTMLBody(error, client.getName()), null, true);
					}
				}), 0, TimeUnit.MILLISECONDS);

		return null;
	}

	private void setPaymentStatus(boolean processing, Properties context, String transactionName) {
		String where = MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?";
		List<MPayment_BH> orderPayments = new Query(context == null ? getCtx() : context, MPayment_BH.Table_Name, where,
				transactionName == null ? get_TrxName() : transactionName).setParameters(orderId).list();
		for (MPayment_BH orderPayment : orderPayments) {
			orderPayment.setBH_Processing(processing);
			orderPayment.saveEx();
		}
	}

	private String createHTMLBody(String error, String clientName) {
		StringBuilder output = new StringBuilder(
				"&nbsp;Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(new Date());
		output.append("<br/>");
		output.append("&nbsp;Client:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(clientName);
		output.append("<br/>");
		output.append("&nbsp;Error:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		output.append(error);
		output.append("<br /><br />");
		output.append("&nbsp;<b>Kindly check logs for a complete description of this error message.</b>");
		output.append("<br /><br />");
		output.append("&nbsp;Regards, <br />");
		output.append("&nbsp;Banda Health Team");

		return output.toString();
	}
}
