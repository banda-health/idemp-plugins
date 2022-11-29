package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.PO;
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
		registerTableEvent(IEventTopics.DOC_BEFORE_PREPARE, MInvoice_BH.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MInvoice_BH invoice = null;
		MInvoice invoiceFromCode = null;
		PO persistentObject = getPO(event);
		if (persistentObject instanceof MInvoice_BH) {
			invoice = (MInvoice_BH) persistentObject;
		} else if (persistentObject instanceof MInvoice) {
			invoiceFromCode = (MInvoice) persistentObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW) && invoice != null) {
			beforeSaveRequest(invoice);
		} else if (event.getTopic().equals(IEventTopics.DOC_BEFORE_PREPARE)) {
			addChargesFromSalesOrder(invoice == null ? invoiceFromCode : invoice);
		}
	}

	/**
	 * If a sales order exists for this invoice and the invoice was automatically created, we need to add the charges
	 * from the order to this invoice (since the invoice was most likely created from the order's shipment). See
	 * {@link MOrder#completeIt()}.
	 *
	 * @param invoice The invoice to modify
	 */
	private void addChargesFromSalesOrder(MInvoice invoice) {
		if (invoice.isReversal()) {
			return;
		}
		MOrder order = invoice.getOriginalOrder();
		// If this invoice didn't come from an order, nothing to do
		if (order == null) {
			return;
		}

		MDocType documentType = MDocType.get(invoice.getCtx(), order.getC_DocType_ID());
		String salesDocumentSubType = documentType.getDocSubTypeSO();
		// If this invoice was created automatically from its order, we need to ensure charges are on it
		if (MDocType.DOCSUBTYPESO_POSOrder.equals(salesDocumentSubType) ||
				MDocType.DOCSUBTYPESO_OnCreditOrder.equals(salesDocumentSubType) ||
				MDocType.DOCSUBTYPESO_PrepayOrder.equals(salesDocumentSubType)) {
			List<MOrderLine> orderLinesWithCharges =
					Arrays.stream(order.getLines()).filter(orderLine -> orderLine.getC_Charge_ID() > 0)
							.collect(Collectors.toList());
			// If this order had charges on it, those will (most likely) not be carried to the invoice and need to be added
			if (orderLinesWithCharges.size() > 0) {
				List<MInvoiceLine> currentInvoiceLines = Arrays.asList(invoice.getLines(true));
				List<MOrderLine> orderLineChargesNotOnInvoice = orderLinesWithCharges.stream().filter(
								orderLine -> currentInvoiceLines.stream().noneMatch(
										invoiceLine -> invoiceLine.getC_Charge_ID() == orderLine.getC_Charge_ID() &&
												invoiceLine.getLineNetAmt().compareTo(orderLine.getLineNetAmt()) == 0))
						.collect(Collectors.toList());
				// If the same charges and amounts do not exist on the invoice, add them
				for (MOrderLine orderLineToAddToInvoice : orderLineChargesNotOnInvoice) {
					MInvoiceLine invoiceLine = new MInvoiceLine(invoice);
					invoiceLine.setOrderLine(orderLineToAddToInvoice);
					orderLineToAddToInvoice.setQtyInvoiced(orderLineToAddToInvoice.getQtyOrdered());
					orderLineToAddToInvoice.saveEx();
					//	Qty = Invoiced
					invoiceLine.setQtyInvoiced(orderLineToAddToInvoice.getQtyInvoiced());
					invoiceLine.setQtyEntered(invoiceLine.getQtyInvoiced());
					if (!invoiceLine.save(invoice.get_TrxName())) {
						throw new AdempiereException("Could not create Invoice Line from Order Line");
					}
				}
				invoice.saveEx();
			}
		}
	}

	private void beforeSaveRequest(MInvoice_BH invoice) {
		if (invoice.getDateAcct() == null) {
			// Update account date to be same as invoice date
			invoice.setDateAcct(invoice.getDateInvoiced());
		}
	}
}
