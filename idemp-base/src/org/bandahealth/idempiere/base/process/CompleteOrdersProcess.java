package org.bandahealth.idempiere.base.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class CompleteOrdersProcess extends SvrProcess {

	@Override
	protected void prepare() {
	}


	/**
	 * This process tries to clean up the system when errors have occurred. We need to get orders, shipments, invoices,
	 * and payments that are in a weird state. Here are the scenarios:
	 * <br>
	 * <ul>
	 *   <li>Order is not completed, and it either has an invoice (or part of one) or has payments marked as BH
	 *   processing</li>
	 *   <li>Order is completed, but it doesn't have a completed invoice or it's payments aren't completed</li>
	 * </ul>
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	protected String doIt() throws Exception {
		long start = System.currentTimeMillis();
		log.log(Level.INFO, "START CompleteOrdersProcess");

		AtomicInteger count = new AtomicInteger();
		int usersAD_Client_ID = Env.getAD_Client_ID(Env.getCtx());
		int currentRoleId = Env.getAD_Role_ID(Env.getCtx());
		// PO.setCrossTenantSafe();
		try {
			// Get sales orders not completed (and are not processing) that have an invoice associated with them (invoices
			// should only be created when completing a sales order), or that have payments that were marked as processing
			// and failed
			//	SELECT *
			//	FROM
			//		c_order
			//	WHERE
			//			c_order_id IN (
			//			SELECT
			//				o.c_order_id
			//			FROM
			//				c_order o
			//					LEFT JOIN c_invoice i
			//						ON o.c_order_id = i.c_order_id AND i.docstatus != 'RE'
			//					LEFT JOIN c_allocationline al
			//						ON i.c_invoice_id = al.c_invoice_id
			//					LEFT JOIN c_payment p
			//						ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id) AND p.docstatus != 'RE'
			//			WHERE
			//						o.issotrx = 'Y' AND (
			//							o.docstatus IN ('CO', 'CL') AND (
			//								i.docstatus NOT IN ('CO', 'CL') OR
			//								(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL'))
			//						)
			//					)
			//				OR (o.docstatus NOT IN ('CO', 'VO', 'CL') AND (p.bh_processing = 'Y' OR p.docstatus = 'CO'))
			//		);
			String whereClause = "c_order_id IN (" +
					"		SELECT " +
					"			o.c_order_id " +
					"		FROM " +
					"			c_order o " +
					"				LEFT JOIN c_invoice i " +
					"					ON o.c_order_id = i.c_order_id AND i.docstatus != 'RE' " +
					"				LEFT JOIN c_allocationline al " +
					"					ON i.c_invoice_id = al.c_invoice_id " +
					"				LEFT JOIN c_payment p " +
					"					ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id) AND p.docstatus != 'RE' " +
					"		WHERE " +
					"					o.issotrx = 'Y' AND ( " +
					"						o.docstatus IN ('CO', 'CL') AND ( " +
					"							i.docstatus NOT IN ('CO', 'CL') OR " +
					"							(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL')) " +
					"					) " +
					"				) " +
					"			OR (o.docstatus NOT IN ('CO', 'VO', 'CL') AND (p.bh_processing = 'Y' OR p.docstatus = 'CO')) " +
					"	)";

			List<MOrder_BH> erroredOrders = new Query(Env.getCtx(), MOrder_BH.Table_Name, whereClause, get_TrxName()).list();
			Set<Integer> erroredOrderIds = erroredOrders.stream().map(MOrder_BH::get_ID).collect(Collectors.toSet());

			// Now get any invoices for these orders that aren't reversed
			List<Object> parameters = new ArrayList<>();
			whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(erroredOrderIds, parameters);
			whereClause =
					MInvoice_BH.COLUMNNAME_C_Order_ID + " IN (" + whereClause + ") AND " + MInvoice_BH.COLUMNNAME_DocStatus +
							"!=?";
			parameters.add(MInvoice_BH.DOCSTATUS_Reversed);
			List<MInvoice_BH> invoicesForErroredOrders =
					new Query(Env.getCtx(), MInvoice_BH.Table_Name, whereClause, get_TrxName()).setParameters(parameters).list();
			Map<Integer, List<MInvoice_BH>> invoicesByErroredOrderId = invoicesForErroredOrders.stream()
					.collect(Collectors.groupingBy(MInvoice_BH::getC_Order_ID));

			// Now get any payments for these orders that aren't reversed
			parameters = new ArrayList<>();
			whereClause = MPayment_BH.COLUMNNAME_DocStatus + "!=?";
			parameters.add(MInvoice_BH.DOCSTATUS_Reversed);
			whereClause += " AND (" + MPayment_BH.COLUMNNAME_BH_C_Order_ID + " IN (" +
					QueryUtil.getWhereClauseAndSetParametersForSet(erroredOrderIds, parameters) + ") OR " +
					MPayment_BH.COLUMNNAME_C_Payment_ID + " IN (SELECT " + MAllocationLine.COLUMNNAME_C_Payment_ID + " FROM " +
					MAllocationLine.Table_Name + " WHERE " + MAllocationLine.COLUMNNAME_C_Invoice_ID + " IN (" +
					QueryUtil.getWhereClauseAndSetParametersForSet(
							invoicesForErroredOrders.stream().map(MInvoice_BH::get_ID).collect(Collectors.toSet()), parameters) +
					")))";
			List<MPayment_BH> paymentsForErroredOrders =
					new Query(Env.getCtx(), MPayment_BH.Table_Name, whereClause, get_TrxName()).setParameters(parameters).list();
			Map<Integer, List<MPayment_BH>> paymentsByErroredOrderId =
					paymentsForErroredOrders.stream().collect(Collectors.groupingBy(MPayment_BH::getBH_C_Order_ID));

			log.log(Level.INFO, "ERRORED ORDERs::::: " + erroredOrders.size());
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, 0);

			for (MOrder_BH erroredOrder : erroredOrders) {
				count.getAndIncrement();

				// Several entities use the AD_Client value in the context to determine their own
				// This leads to bad results when processing orders because then the allocations have
				// the wrong AD_Client_IDs and can't fetch the appropriate Bank Accounts and Account Schemas
				Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, erroredOrder.getAD_Client_ID());

				// If this order isn't complete, we need to complete it
				// Otherwise, if the invoice isn't complete, we need to get it completed
				if (!erroredOrder.isComplete()) {
					// If this order has an invoice, we need to do some stuff first
					if (invoicesByErroredOrderId.containsKey(erroredOrder.get_ID())) {
						List<MInvoice_BH> invoices = invoicesByErroredOrderId.get(erroredOrder.get_ID());
						for (MInvoice_BH invoice : invoices) {
							// If the invoice is completed, reverse it
							if (invoice.isComplete()) {
								invoice.setDocAction(MInvoice_BH.DOCACTION_Reverse_Accrual);
								invoice.processIt(MInvoice_BH.DOCACTION_Reverse_Accrual);
								invoice.saveEx();

								// Re-open any payments associated with this invoice, if any?
								// Or maybe just reverse accrue the allocation lines?
							} else {
								// Delete any invoice lines
								Arrays.stream(invoice.getLines(true)).forEach(invoiceLine -> invoiceLine.deleteEx(true));
								// Delete the invoice
								invoice.deleteEx(true);
							}
						}
					}

					completeOrder(erroredOrder);
				} else if (invoicesByErroredOrderId.containsKey(erroredOrder.get_ID()) &&
						invoicesByErroredOrderId.get(erroredOrder.get_ID()).stream().anyMatch(MInvoice::isComplete)) {
					List<MInvoice_BH> incompleteInvoices =
							invoicesByErroredOrderId.get(erroredOrder.get_ID()).stream().filter(Predicate.not(MInvoice::isComplete))
									.collect(Collectors.toList());
					for (MInvoice_BH invoice : incompleteInvoices) {
						// If the invoice is voided, just re-open and re-complete the order
						// Otherwise, try to complete the invoice. If it fails, we'll try to delete it and let the order
						// re-create it
						if (invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.STATUS_Voided)) {
							reopenAndReCompleteOrder(erroredOrder);
						} else {
							invoice.setDocAction(MInvoice_BH.DOCACTION_Complete);
							if (!invoice.processIt(MInvoice_BH.DOCACTION_Complete)) {
								// Delete any invoice lines
								Arrays.stream(invoice.getLines(true)).forEach(invoiceLine -> invoiceLine.deleteEx(true));
								// Delete the invoice
								invoice.deleteEx(true);

								// With the invoice deleted, re-open the order
								reopenAndReCompleteOrder(erroredOrder);
							} else {
								invoice.saveEx();
							}
						}
					}
				} else if (!invoicesByErroredOrderId.containsKey(erroredOrder.get_ID())) {
					// This is a completed order that doesn't have an invoice, so reverse the order and try again
					reopenAndReCompleteOrder(erroredOrder);
				} else if (!paymentsByErroredOrderId.containsKey(erroredOrder.get_ID())) {
					// Something isn't wrong with the payments, so no idea what the issue was
					log.severe("Unsure of how to handle scenario for order ID " + erroredOrder.get_ID() + ", please " +
							"investigate");
					count.getAndDecrement();
				}
				if (paymentsByErroredOrderId.containsKey(erroredOrder.get_ID())) {
					paymentsByErroredOrderId.get(erroredOrder.get_ID()).stream().filter(Predicate.not(MPayment_BH::isComplete))
							.forEach(payment -> {
								payment.setDocAction(MPayment_BH.DOCACTION_Complete);
								payment.processIt(MPayment_BH.DOCACTION_Complete);
								payment.saveEx();
							});
				}
			}
		} finally {
			// Reset the AD_Client_ID to be correct
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, usersAD_Client_ID);
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, currentRoleId);
			//PO.clearCrossTenantSafe();
		}

		String msg = "STOP CompleteOrdersProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count.get() + " order(s).";
		log.log(Level.INFO, msg);

		return msg;
	}

	/**
	 * Complete an order while also updating its document type to be what we use today - on credit
	 *
	 * @param order The order to complete
	 */
	private void completeOrder(MOrder_BH order) {
		// Older orders weren't on-credit, so update it to be so
		MDocType_BH documentType = new Query(getCtx(), MDocType.Table_Name,
				MDocType_BH.COLUMNNAME_DocBaseType + "=? AND " + MDocType_BH.COLUMNNAME_DocSubTypeSO + "=?",
				get_TrxName()).setParameters(MDocType_BH.DOCBASETYPE_SalesOrder,
				MDocType_BH.DOCSUBTYPESO_OnCreditOrder).setClient_ID().first();
		order.setC_DocType_ID(documentType.get_ID());

		long orderStart = System.currentTimeMillis();
		order.setDocAction(MOrder_BH.DOCACTION_Complete);
		order.processIt(MOrder_BH.DOCACTION_Complete);
		order.saveEx();
		log.warning("Time spent processing SO (secs): " + (System.currentTimeMillis() - orderStart) / 1000);
	}

	/**
	 * Re-open an order, then re-complete it using {@link #completeOrder(MOrder_BH)}. This method is typically meant to
	 * be used when there was an error processing the invoice
	 *
	 * @param order The order to re-open & re-complete
	 */
	private void reopenAndReCompleteOrder(MOrder_BH order) {
		order.setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		order.processIt(MOrder_BH.DOCACTION_Re_Activate);
		order.saveEx();

		// Now try to re-complete the order
		completeOrder(order);
	}
}
