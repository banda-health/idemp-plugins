package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MAllocationLine;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(InvoiceModelEvent.class);

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_REACTIVATE, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_REVERSEACCRUAL, MInvoice_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_REVERSECORRECT, MInvoice_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInvoice_BH invoice;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MInvoice_BH) {
			invoice = (MInvoice_BH) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			beforeSaveRequest(invoice);
		} else if (event.getTopic().equalsIgnoreCase(IEventTopics.DOC_AFTER_REACTIVATE) ||
				event.getTopic().equalsIgnoreCase(IEventTopics.DOC_AFTER_REVERSEACCRUAL) ||
				event.getTopic().equalsIgnoreCase(IEventTopics.DOC_AFTER_REVERSECORRECT)) {
			afterReOpen(invoice);
		}
	}

	private void afterReOpen(MInvoice_BH invoice) {
		// Get any payments directly associated with this invoice and reverse accrue them
		List<MPayment_BH> payments =
				new Query(invoice.getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Invoice_ID + "=?",
						invoice.get_TrxName()).setParameters(invoice.get_ID()).list();
		List<MPayment_BH> paymentsIndirectlyTiedToInvoices = new Query(invoice.getCtx(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_C_Payment_ID + " IN (SELECT " + MAllocationLine.COLUMNNAME_C_Payment_ID + " FROM " +
						MAllocationLine.Table_Name + " WHERE " + MAllocationLine.COLUMNNAME_C_Invoice_ID + "=?)",
				invoice.get_TrxName()).setParameters(invoice.get_ID()).list();
		payments.addAll(paymentsIndirectlyTiedToInvoices);

		// For each payment, try to void it, reverse accrue it, or just delete it
		payments.forEach(payment -> {
			String[] unusedDocumentActions = new String[50];
			String[] availableDocumentActions = new String[50];
			DocumentEngine.getValidActions(payment.getDocStatus(), payment.isProcessing(), null,
					payment.isReceipt() ? "Y" : "N",
					payment.get_Table_ID(), unusedDocumentActions, availableDocumentActions, false, payment);
			List<String> possibleDocumentActions = Arrays.stream(availableDocumentActions)
					.filter(documentAction -> documentAction != null && !documentAction.equalsIgnoreCase(""))
					.collect(Collectors.toList());

			boolean didErrorOccurWithPaymentProcessing = false;
			if (possibleDocumentActions.contains(MPayment_BH.DOCACTION_Void)) {
				didErrorOccurWithPaymentProcessing = payment.voidIt() && payment.save();
			} else if (possibleDocumentActions.contains(MPayment_BH.DOCACTION_Reverse_Accrual)) {
				didErrorOccurWithPaymentProcessing = payment.reverseAccrualIt() && payment.save();
			} else {
				didErrorOccurWithPaymentProcessing = payment.delete(true);
			}
			if (didErrorOccurWithPaymentProcessing) {
				log.severe("Could not reverse or delete payment with ID " + payment.get_ID() + ". With status '" +
						payment.getDocStatus() + "', the available actions were: " + String.join(",", possibleDocumentActions));
			}
		});
	}

	private void beforeSaveRequest(MInvoice_BH invoice) {
		if (invoice.getDateAcct() == null) {
			// Update account date to be same as invoice date
			invoice.setDateAcct(invoice.getDateInvoiced());
		}
	}
}
