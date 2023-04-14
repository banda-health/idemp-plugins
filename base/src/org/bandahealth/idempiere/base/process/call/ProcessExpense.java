package org.bandahealth.idempiere.base.process.call;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.exceptions.PeriodClosedException;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.utils.ErrorUtils;
import org.compiere.model.MMessage;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.CLogger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class ProcessExpense {

	private CLogger log = CLogger.getCLogger(getClass());

	private Properties context;
	private String transactionName;
	private MInvoice_BH expense;
	private ProcessCallback<String> callback;
	private String processAction;

	public ProcessExpense(
			MInvoice_BH expense, Properties context, String transactionName, String processAction,
			ProcessCallback<String> callback) {
		this.expense = expense;
		this.context = context;
		this.transactionName = transactionName;
		this.processAction = processAction;
		this.callback = callback;
	}

	public void processIt() {
		if (DocAction.ACTION_Reverse_Accrual.equalsIgnoreCase(processAction)) {
			reverseIt();
		} else {
			completeIt();
		}
	}

	private void reverseIt() {
		long start = System.currentTimeMillis();
		try {
			// The iDempiere process prefers the action is set, then calling the process command
			expense.setDocAction(DocAction.ACTION_Reverse_Accrual);
			expense.saveEx();
			boolean isExpenseReversed = expense.processIt(DocAction.ACTION_None);
			if (!isExpenseReversed) {
				callback.onError("Error trying to reverse expense " + expense.getC_Invoice_ID(), context,
						transactionName);
			} else {
				// We need to save this or otherwise the expense will never "updated" because of the reversal process in
				// iDempiere
				expense.saveEx();
				callback.onSuccess(context, transactionName);
			}
		} catch (AdempiereException ex) {
			callback.onError("Could not reverse expense " + expense.getC_Invoice_ID() + ". Error: " + ex.getMessage(),
					context, transactionName);
		} finally {
			log.warning("Time spent reversing expense (secs): " + (System.currentTimeMillis() - start) / 1000);
		}
	}

	private void completeIt() {
		long start = System.currentTimeMillis();

		try {
			MPeriod.testPeriodOpen(context, expense.getDateAcct(), expense.getC_DocType_ID(), expense.getAD_Org_ID());
		} catch (PeriodClosedException ex) {
			expense.setDateAcct(new Timestamp(new Date().getTime()));
			log.info("Setting accounting date to: " + expense.getDateAcct());
		}

		if (!expense.getDocStatus().equals(MInvoice_BH.DOCSTATUS_Drafted)) {
			callback.onError("DocStatus MUST be DRAFTED " + expense.get_ID(), context, transactionName);
			return;
		}

		// check if the expense has any invoice line items.
		int lineItemsCount = new Query(
				context, MInvoice_BH.Table_Name,MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?", transactionName)
				.setParameters(expense.getC_Invoice_ID())
				.count();

		if (lineItemsCount == 0) {
			MMessage message = new Query(
					context, MMessage.Table_Name, MMessage.COLUMNNAME_AD_Message_UU + "=?", null)
					.setParameters(ErrorUtils.NO_LINE_ITEMS_ENTERED_ERROR_MESSAGE_UUID).first();
			if (message != null) {
				callback.onError(message.getMsgText(), context, transactionName);
			} else {
				callback.onError("Expense MUST have at least one line item: expenseId = " + expense.get_ID(), context,
						transactionName);
			}

			expense.setDocStatus(MOrder_BH.DOCSTATUS_Invalid);
			expense.saveEx();
			return;
		}

		try {
			boolean isExpenseComplete = expense.processIt(DocAction.ACTION_Complete);
			if (!isExpenseComplete) {
				callback.onError("Error trying to complete expense " + expense.getC_Invoice_ID(), context,
						transactionName);
			} else {
				callback.onSuccess(context, transactionName);
			}
		} catch (AdempiereException ex) {
			callback.onError("Could not complete expense " + expense.getC_Invoice_ID() + ". Error: " + ex.getMessage(),
					context, transactionName);
		} finally {
			log.warning("Time spent processing expense (secs): " + (System.currentTimeMillis() - start) / 1000);
		}
	}
}
