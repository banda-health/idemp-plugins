package org.bandahealth.idempiere.base.process.call;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.callback.ProcessCallback;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MDocType;
import org.compiere.model.MMessage;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.CLogger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class CompleteExpense {

	private CLogger log = CLogger.getCLogger(getClass());

	private Properties context;
	private String transactionName;
	private MInvoice_BH expense;
	private ProcessCallback<String> callback;

	public CompleteExpense(MInvoice_BH expense, Properties context, String transactionName,
												 ProcessCallback<String> callback) {
		this.expense = expense;
		this.context = context;
		this.transactionName = transactionName;
		this.callback = callback;
	}

	public void processIt() {
		long start = System.currentTimeMillis();

		// Make sure the current period is open if saving a past record
		MPeriod expensePeriod = new Query(
				context,
				MPeriod.Table_Name,
				MPeriod.COLUMNNAME_StartDate + "<= ? AND " + MPeriod.COLUMNNAME_EndDate + "> ?",
				transactionName
		)
				.setParameters(expense.getDateAcct(), expense.getDateAcct())
				.first();
		Date date = new Date();
		if (
				expensePeriod == null ||
						expensePeriod.getPeriodControl(MDocType.DOCBASETYPE_APPayment) == null ||
						!expensePeriod.getPeriodControl(MDocType.DOCBASETYPE_APPayment).isOpen()
		) {
			expense.setDateAcct(new Timestamp(date.getTime()));
			log.info("Setting accounting date to: " + expense.getDateAcct());
		}
		/* Packed out from BH_SysConfig */
		String noLineItemsEnteredErrorMsgUuid = "03cb65e5-104c-4dd6-bec0-4bfe244ae804";
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
					.setParameters(noLineItemsEnteredErrorMsgUuid).first();
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
