package org.bandahealth.idempiere.base.process;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.process.call.SalesProcessAsyncCall;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.Adempiere;
import org.compiere.acct.Doc;
import org.compiere.model.*;
import org.compiere.model.MClient;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.model.X_C_DocType;
import org.compiere.model.X_M_InOut;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

public class OrderProcess extends SvrProcess {

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
			return doReceiveGoods(order);
		}

		return doCompletePatientBill();
	}

	private String doCompletePatientBill() {
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

	private String doReceiveGoods(MOrder_BH order) {
		order.processIt(MOrder_BH.DOCACTION_Complete);
		order.save();
		// Create Material Receipt header
		Timestamp movementDate = order.getDateOrdered() != null ? order.getDateOrdered()
				: new Timestamp(System.currentTimeMillis());
		int documentTypeId = new Query(
				Env.getCtx(),
				X_C_DocType.Table_Name,
				X_C_DocType.COLUMNNAME_DocBaseType + "=? AND " + X_C_DocType.COLUMNNAME_AD_Client_ID + "=?" +
						" AND " + X_C_DocType.COLUMNNAME_IsSOTrx + "=?",
				order.get_TrxName()
		)
				.setParameters(Doc.DOCTYPE_MatReceipt,Env.getAD_Client_ID(Env.getCtx()), "N")
				.firstId();
		MInOut mReceipt = new MInOut(order, documentTypeId, movementDate);

		mReceipt.setDateOrdered(mReceipt.getMovementDate());
//		mReceipt.setCreateFrom("N");
//		mReceipt.setGenerateTo("N");
		mReceipt.save();

		// add lines if any
		MOrderLine[] oLines = order.getLines(true, MOrderLine.COLUMNNAME_M_Product_ID);
		if (oLines.length > 0) {
			MWarehouse mWarehouse = new MWarehouse(Env.getCtx(), order.getM_Warehouse_ID(), order.get_TrxName());
			for (MOrderLine oLine : oLines) {
				MInOutLine line = new MInOutLine(mReceipt);
				line.setOrderLine(oLine, mWarehouse.getDefaultLocator().get_ID(), Env.ZERO);
				line.setQty(oLine.getQtyOrdered());
				line.saveEx(order.get_TrxName());
			}
		}

		// complete operation
		mReceipt.processIt(X_M_InOut.DOCACTION_Complete);
		mReceipt.save();

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
