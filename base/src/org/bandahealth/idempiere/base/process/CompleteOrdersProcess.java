package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.util.IProcessUI;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrderLine;
import org.compiere.model.MSysConfig;
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
		int usersAD_Client_ID = Env.getAD_Client_ID(getCtx());
		int currentRoleId = Env.getAD_Role_ID(getCtx());
		// PO.setCrossTenantSafe();
		IProcessUI processMonitor = Env.getProcessUI(getCtx());
		Set<Integer> notFixedOrderIds = new HashSet<>();
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
			//						ON o.c_order_id = i.c_order_id AND i.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
			//					LEFT JOIN c_allocationline al
			//						ON i.c_invoice_id = al.c_invoice_id
			//					LEFT JOIN c_allocationhdr ah
			//						ON al.c_allocationhdr_id = ah.c_allocationhdr_id
			//					LEFT JOIN c_payment p
			//						ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id)
			//					AND p.docstatus NOT IN ('RE', 'RA', 'RC', 'VO')
			//			WHERE
			//				o.issotrx = 'Y'
			//				AND (ah.docstatus IS NULL OR ah.docstatus NOT IN ('RA', 'RC'))
			//				AND (
			//					(
			//								o.docstatus IN ('CO', 'CL') AND (
			//									i.docstatus NOT IN ('CO', 'CL') OR
			//									(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL'))
			//							)
			//						)
			//					OR (o.docstatus NOT IN ('CO', 'VO', 'CL', 'IN') AND (p.bh_processing = 'Y' OR p.docstatus =
			//					                                                                              'CO'))
			//					OR (o.docstatus = 'CO' AND i.docstatus = 'CO' AND o.grandtotal != i.grandtotal)
			//					OR o.c_order_id IN (
			//					SELECT
			//						c_order_id
			//					FROM
			//						c_invoice
			//					WHERE
			//						docstatus = 'CO'
			//						AND isactive = 'Y'
			//					GROUP BY c_order_id
			//					HAVING
			//						COUNT(*) > 1
			//				) OR (p.bh_processing = 'Y' AND p.docstatus != 'IP' AND o.docstatus IN ('DR', 'IP'))
			//				)
			//		);
			String erroredOrderWhereClause = "c_order_id IN (" +
					"		SELECT " +
					"			o.c_order_id " +
					"		FROM " +
					"			c_order o " +
					"				LEFT JOIN c_invoice i " +
					"					ON o.c_order_id = i.c_order_id AND i.docstatus NOT IN ('RE', 'RA', 'RC', 'VO') " +
					"				LEFT JOIN c_allocationline al " +
					"					ON i.c_invoice_id = al.c_invoice_id " +
					"				LEFT JOIN c_allocationhdr ah " +
					"					ON al.c_allocationhdr_id = ah.c_allocationhdr_id " +
					"				LEFT JOIN c_payment p " +
					"					ON (p.bh_c_order_id = o.c_order_id OR p.c_payment_id = al.c_payment_id) " +
					"						AND p.docstatus NOT IN ('RE', 'RA', 'RC', 'VO') " +
					"		WHERE " +
					"			o.issotrx = 'Y' " +
					"			AND (ah.docstatus IS NULL OR ah.docstatus NOT IN ('RA', 'RC')) " +
					"			AND ( " +
					"				( " +
					"							o.docstatus IN ('CO', 'CL') AND ( " +
					"								i.docstatus NOT IN ('CO', 'CL') OR " +
					"								(p.docstatus IS NOT NULL AND p.docstatus NOT IN ('CO', 'CL')) " +
					"						) " +
					"					) " +
					"				OR (o.docstatus NOT IN ('CO', 'VO', 'CL', 'IN') AND (p.bh_processing = 'Y' OR p.docstatus = 'CO'))" +
					"				OR (o.docstatus = 'CO' AND i.docstatus = 'CO' AND o.grandtotal != i.grandtotal) " +
					"				OR o.c_order_id IN (" +
					"				SELECT" +
					"					c_order_id" +
					"				FROM" +
					"					c_invoice" +
					"				WHERE" +
					"					docstatus = 'CO'" +
					"					AND isactive = 'Y'" +
					"				GROUP BY c_order_id" +
					"				HAVING" +
					"					COUNT(*) > 1" +
					"			) OR (p.bh_processing = 'Y' AND p.docstatus != 'IP' AND o.docstatus IN ('DR', 'IP'))" +
					"			)" +
					"	)";

			// Since this process can take a while, we'll limit it to 50 orders we need to process at a time (this should
			// never happen, except in the case where we're doing a payment overhaul and have a lot to fix...)
			String shouldProcessMostRecentFirst =
					MSysConfig.getValue(MSysConfig_BH.AUTOCOMPLETE_MOST_RECENT_VISITS_FIRST, "N");
			List<MOrder_BH> erroredOrders =
					new Query(getCtx(), MOrder_BH.Table_Name, erroredOrderWhereClause, get_TrxName()).setPage(50, 0).setOrderBy(
							MOrder_BH.COLUMNNAME_Created + " " +
									(shouldProcessMostRecentFirst.equalsIgnoreCase("Y") ? "DESC" : "ASC")).list();
			Set<Integer> erroredOrderIds = erroredOrders.stream().map(MOrder_BH::get_ID).collect(Collectors.toSet());
			Set<Integer> erroredVisitIds = erroredOrders.stream().map(MOrder_BH::getBH_Visit_ID).collect(Collectors.toSet());

			if (!erroredOrderIds.isEmpty()) {
				// Now get any invoices for these orders that aren't reversed
				List<Object> parameters = new ArrayList<>();
				String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(erroredOrderIds, parameters);
				whereClause =
						MInvoice_BH.COLUMNNAME_C_Order_ID + " IN (" + whereClause + ") AND " + MInvoice_BH.COLUMNNAME_DocStatus +
								"!=?";
				parameters.add(MInvoice_BH.DOCSTATUS_Reversed);
				List<MInvoice_BH> invoicesForErroredOrders =
						new Query(getCtx(), MInvoice_BH.Table_Name, whereClause, get_TrxName()).setParameters(parameters)
								.list();
				Map<Integer, List<MInvoice_BH>> invoicesByErroredOrderId = invoicesForErroredOrders.stream()
						.collect(Collectors.groupingBy(MInvoice_BH::getC_Order_ID));

				// Now get any payments for these orders that aren't reversed
				List<Object> paymentParameters = new ArrayList<>();
				String paymentWhereClause = getPaymentWhereClause(erroredVisitIds, paymentParameters);
				List<MPayment_BH> paymentsForErroredOrders =
						new Query(getCtx(), MPayment_BH.Table_Name, paymentWhereClause, get_TrxName()).setParameters(
								paymentParameters).list();
				Map<Integer, List<MPayment_BH>> paymentsByErroredVisitId =
						paymentsForErroredOrders.stream().collect(Collectors.groupingBy(MPayment_BH::getBH_Visit_ID));

				log.log(Level.INFO, "ERRORED ORDERs::::: " + erroredOrders.size());
				Env.setContext(getCtx(), Env.AD_ROLE_ID, 0);
				Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, 0);
				int numberOfOrdersToProcess = erroredOrders.size();

				for (MOrder_BH erroredOrder : erroredOrders) {
					count.getAndIncrement();
					log.log(Level.INFO, "Processing order " + erroredOrder.get_ID());
					if (processMonitor != null) {
						processMonitor.statusUpdate(
								"Updating order " + erroredOrder.get_ID() + ", " + count.get() + " of " + numberOfOrdersToProcess);
					}

					// Several entities use the AD_Client value in the context to determine their own
					// This leads to bad results when processing orders because then the allocations have
					// the wrong AD_Client_IDs and can't fetch the appropriate Bank Accounts and Account Schemas
					Env.setContext(getCtx(), Env.AD_CLIENT_ID, erroredOrder.getAD_Client_ID());
					Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, erroredOrder.getAD_Client_ID());
					boolean doesOrderHaveInvoices = invoicesByErroredOrderId.containsKey(erroredOrder.get_ID());
					// If there are any invoices with a weird status, update those
					for (MInvoice_BH invoice : invoicesByErroredOrderId.getOrDefault(erroredOrder.get_ID(), new ArrayList<>())) {
						if (invoice.getDocAction().equals(MInvoice_BH.DOCACTION_Close) && invoice.isProcessed() &&
								!invoice.isComplete()) {
							invoice.setDocStatus(MInvoice_BH.DOCSTATUS_Completed);
							invoice.saveEx();
						}
					}
					// Now check the various ways invoices could be wrong
					List<MInvoice_BH> correctIncompleteInvoices =
							invoicesByErroredOrderId.getOrDefault(erroredOrder.get_ID(), new ArrayList<>()).stream().filter(
											invoice -> !invoice.isComplete() &&
													!invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Voided) &&
													invoice.getGrandTotal().compareTo(erroredOrder.getGrandTotal()) == 0)
									.collect(Collectors.toList());
					List<MInvoice_BH> incorrectIncompleteInvoices =
							invoicesByErroredOrderId.getOrDefault(erroredOrder.get_ID(), new ArrayList<>()).stream().filter(
											invoice -> !invoice.isComplete() &&
													!invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Voided) &&
													invoice.getGrandTotal().compareTo(erroredOrder.getGrandTotal()) != 0)
									.collect(Collectors.toList());
					List<MInvoice_BH> correctCompleteInvoices =
							invoicesByErroredOrderId.getOrDefault(erroredOrder.get_ID(), new ArrayList<>()).stream().filter(
											invoice -> invoice.isComplete() &&
													!invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Reversed) &&
													invoice.getGrandTotal().compareTo(erroredOrder.getGrandTotal()) == 0)
									.collect(Collectors.toList());
					List<MInvoice_BH> incorrectCompleteInvoices =
							invoicesByErroredOrderId.getOrDefault(erroredOrder.get_ID(), new ArrayList<>()).stream().filter(
											invoice -> invoice.isComplete() &&
													!invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Reversed) &&
													invoice.getGrandTotal().compareTo(erroredOrder.getGrandTotal()) != 0)
									.collect(Collectors.toList());

					// If this order isn't complete, we need to complete it
					// Otherwise, if the invoice isn't complete, we need to get it completed
					if (!erroredOrder.isComplete()) {
						// If this order has an invoice, we need to do some stuff first
						if (invoicesByErroredOrderId.containsKey(erroredOrder.get_ID())) {
							List<MInvoice_BH> invoices = invoicesByErroredOrderId.get(erroredOrder.get_ID());
							for (MInvoice_BH invoice : invoices) {
								// If the invoice is completed, reverse it
								if (invoice.isComplete()) {
									reverseInvoiceAndHandleAnyAutoCreatedPayments(invoice);
									invoice.saveEx();
								} else {
									// Delete any invoice lines
									Arrays.stream(invoice.getLines(true)).forEach(invoiceLine -> invoiceLine.deleteEx(true));
									// Delete the invoice
									invoice.deleteEx(true);
								}
							}
						}

						completeOrder(erroredOrder);
					} else if (!doesOrderHaveInvoices) {
						// This is a completed order that doesn't have an invoice, so reverse the order and try again
						tryToReopenAndReCompleteOrder(erroredOrder);
					} else if (!incorrectCompleteInvoices.isEmpty() || !incorrectIncompleteInvoices.isEmpty() ||
							!correctIncompleteInvoices.isEmpty() || correctCompleteInvoices.size() > 1) {
						// If we have any incomplete invoices, incorrect complete invoices, or too many complete invoices, do some
						// work
						boolean shouldNotReopenOrder =
								correctIncompleteInvoices.size() == 1 && correctCompleteInvoices.isEmpty() &&
										incorrectCompleteInvoices.isEmpty() && incorrectIncompleteInvoices.isEmpty();

						if (shouldNotReopenOrder) {
							MInvoice_BH invoice = correctIncompleteInvoices.get(0);
							if (invoice.getDocStatus().equals(MInvoice_BH.DOCSTATUS_Invalid)) {
								// If the document is invalid, we'll just void it
								invoice.setDocAction(MInvoice_BH.DOCACTION_Void);
								if (!invoice.processIt(MInvoice_BH.DOCACTION_Void)) {
									log.severe("Couldn't void invoice " + invoice.get_ID() + " to remove it. Please investigate.");
								}
							} else {
								// Update the payment type so that payments don't automatically get created...
								invoice.setPaymentRule(MInvoice_BH.PAYMENTRULE_OnCredit);
								invoice.setDocAction(MInvoice_BH.DOCACTION_Complete);
								if (!invoice.processIt(MInvoice_BH.DOCACTION_Complete)) {
									log.severe("Couldn't work with invoice " + invoice.get_ID() + ". Please investigate.");
								}
							}
							invoice.saveEx();
						} else {
							boolean shouldDoOrderWorkBecauseInvoiceWorkSucceeded = true;
							List<MInvoice_BH> completedInvoices =
									Stream.concat(correctCompleteInvoices.stream(), incorrectCompleteInvoices.stream())
											.collect(Collectors.toList());
							for (MInvoice_BH invoice : completedInvoices) {
								if (!reverseInvoiceAndHandleAnyAutoCreatedPayments(invoice)) {
									log.severe("Couldn't work with invoice " + invoice.get_ID() + ". Please investigate.");
									shouldDoOrderWorkBecauseInvoiceWorkSucceeded = false;
								}
								invoice.saveEx();
							}
							List<MInvoice_BH> incompleteInvoices =
									Stream.concat(correctIncompleteInvoices.stream(), incorrectIncompleteInvoices.stream())
											.collect(Collectors.toList());
							for (MInvoice_BH invoice : incompleteInvoices) {
								// If this invoice has any allocations, we can't delete it
								MAllocationHdr[] allocationHeaders =
										MAllocationHdr.getOfInvoice(getCtx(), invoice.get_ID(), get_TrxName());
								if (allocationHeaders.length == 0) {
									// Delete any invoice lines
									Arrays.stream(invoice.getLines(true)).forEach(invoiceLine -> invoiceLine.deleteEx(true));
									// Delete the invoice
									invoice.deleteEx(true);
								} else {
									// Some of these invoices are drafted (and somehow have allocations...), so first try to complete
									// the invoice so we can immediately reverse it
									if (!invoice.getDocStatus().equals(MInvoice_BH.DOCSTATUS_Completed)) {
										// Update the payment type so that payments don't automatically get created...
										invoice.setPaymentRule(MInvoice_BH.PAYMENTRULE_OnCredit);
										invoice.setDocAction(MInvoice_BH.DOCACTION_Complete);
										if (!invoice.processIt(MInvoice_BH.DOCACTION_Complete)) {
											log.severe("Couldn't work with invoice " + invoice.get_ID() + ". Please investigate.");
											shouldDoOrderWorkBecauseInvoiceWorkSucceeded = false;
										}
										invoice.saveEx();
									}
									// Just reverse the invoice
									invoice.setDocAction(MInvoice_BH.DOCACTION_Reverse_Accrual);
									if (!invoice.processIt(MInvoice_BH.DOCACTION_Reverse_Accrual)) {
										// There's still something wrong, so not sure what to do...
										log.severe("Couldn't work with invoice " + invoice.get_ID() + ". Please investigate.");
										shouldDoOrderWorkBecauseInvoiceWorkSucceeded = false;
									}
									invoice.saveEx();
								}
							}

							if (shouldDoOrderWorkBecauseInvoiceWorkSucceeded) {
								// With the invoice deleted, re-open the order
								tryToReopenAndReCompleteOrder(erroredOrder);
							}
						}
					} else if (!paymentsByErroredVisitId.containsKey(erroredOrder.getBH_Visit_ID())) {
						// Something isn't wrong with the payments, so no idea what the issue was
						log.severe("Unsure of how to handle scenario for order ID " + erroredOrder.get_ID() + ", please " +
								"investigate");
						count.getAndDecrement();
					}
					if (paymentsByErroredVisitId.containsKey(erroredOrder.getBH_Visit_ID())) {
						// Sometimes we have some weird payments - update those
						for (MPayment_BH payment : paymentsByErroredVisitId.get(erroredOrder.getBH_Visit_ID())) {
							if (payment.isAllocated() && payment.getDocStatus().equals(MPayment_BH.DOCSTATUS_Drafted)) {
								payment.setDocStatus(MPayment_BH.DOCSTATUS_Completed);
								payment.saveEx();
							}
						}
						// For any payments that are allocated by have an incomplete doc status, just update the doc status
						List<MPayment_BH> incorrectDocumentStatusPayments =
								paymentsByErroredVisitId.get(erroredOrder.getBH_Visit_ID()).stream().filter(MPayment_BH::isAllocated)
										.filter(Predicate.not(MPayment_BH::isComplete)).collect(Collectors.toList());
						for (MPayment_BH payment : incorrectDocumentStatusPayments) {
							payment.setDocStatus(MPayment_BH.DOCSTATUS_Completed);
							payment.saveEx();
						}
						// Complete any payments that haven't been completed yet
						List<MPayment_BH> incompletePayments = paymentsByErroredVisitId.get(erroredOrder.getBH_Visit_ID()).stream()
								.filter(Predicate.not(MPayment_BH::isAllocated)).collect(Collectors.toList());
						for (MPayment_BH payment : incompletePayments) {
							tryToCompleteAndAllocatePayment(payment);
						}
						// Fetch the payments again, now that they've been updated
						paymentParameters = new ArrayList<>();
						paymentWhereClause = getPaymentWhereClause(Collections.singleton(erroredOrder.get_ID()),
								paymentParameters);
						List<MPayment_BH> paymentsForErroredOrder =
								new Query(getCtx(), MPayment_BH.Table_Name, paymentWhereClause, get_TrxName()).setParameters(
										paymentParameters).list();
						// For all this order's unallocated payments, make sure they're allocated
						List<MPayment_BH> unallocatedPayments =
								paymentsForErroredOrder.stream().filter(Predicate.not(MPayment_BH::isAllocated))
										.collect(Collectors.toList());
						for (MPayment_BH payment : unallocatedPayments) {
							tryToCompleteAndAllocatePayment(payment);
						}
					}
				}

				parameters = new ArrayList<>();
				erroredOrderWhereClause +=
						" AND c_order_id IN (" + QueryUtil.getWhereClauseAndSetParametersForSet(erroredOrderIds, parameters) + ")";

				List<MOrder_BH> ordersNotFixed =
						new Query(getCtx(), MOrder_BH.Table_Name, erroredOrderWhereClause, get_TrxName()).setParameters(
								parameters).list();
				notFixedOrderIds = ordersNotFixed.stream().map(MOrder_BH::get_ID).collect(Collectors.toSet());
			}
		} finally {
			// Reset the AD_Client_ID to be correct
			Env.setContext(getCtx(), Env.AD_CLIENT_ID, usersAD_Client_ID);
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, usersAD_Client_ID);
			Env.setContext(getCtx(), Env.AD_ROLE_ID, currentRoleId);
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, currentRoleId);
			//PO.clearCrossTenantSafe();
		}

		String message = "STOP CompleteOrdersProcess. Took " + (System.currentTimeMillis() - start) / 1000 / 60
				+ " mins. Processed " + count.get() + " order(s).";
		if (!notFixedOrderIds.isEmpty()) {
			String ordersNotFixed = notFixedOrderIds.size() + " order(s) not fixed: " +
					notFixedOrderIds.stream().map(String::valueOf).collect(Collectors.joining(","));
			message += " " + ordersNotFixed;
			log.severe(ordersNotFixed);
		}
		log.log(Level.INFO, message);

		return message;
	}

	/**
	 * This method tries to complete and allocate a payment, if possible. If a payment throws an error when allocating
	 * due to the wrong allocation date, the method will just create a duplicate payment being made for the current date
	 *
	 * @param payment The payment to try and complete and/or allocate
	 */
	private void tryToCompleteAndAllocatePayment(MPayment_BH payment) {
		// Try to allocate the payment - if it fails, it's probably due to the allocation date, so we'll just
		// re-open and re-complete the payment in that case
		try {
			if (!payment.isComplete()) {
				payment.setDocAction(MPayment_BH.DOCACTION_Complete);
				if (!payment.processIt(MPayment_BH.DOCACTION_Complete)) {
					log.severe("Could not complete payment with ID " + payment.get_ID() + ", please investigate");
				}
			} else {
				payment.allocateIt();
			}
			payment.saveEx();
		} catch (AdempiereException exception) {
			if (!exception.getMessage().contains("Wrong allocation date")) {
				throw exception;
			}
			// There may be allocations to delete
			MAllocationHdr[] allocations = MAllocationHdr.getOfPayment(getCtx(), payment.get_ID(), get_TrxName());
			for (MAllocationHdr allocationHeader : allocations) {
				if (allocationHeader.getDocStatus().equals(MAllocationHdr.STATUS_Drafted)) {
					Arrays.stream(allocationHeader.getLines(true))
							.forEach(allocationLine -> allocationLine.deleteEx(false, get_TrxName()));
					allocationHeader.deleteEx(true, get_TrxName());
				}
			}
			MPayment_BH newPayment = payment.copy();
			newPayment.setDateAcct(new Timestamp(System.currentTimeMillis()));
			// If the payment isn't complete, we'll just void it
			if (!payment.isComplete()) {
				payment.setDocAction(MPayment_BH.DOCACTION_Void);
				if (!payment.processIt(MPayment_BH.DOCACTION_Void)) {
					log.severe("Could not void payment with ID " + payment.get_ID() + ", please investigate");
					return;
				}
			} else {
				payment.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
				if (!payment.processIt(MPayment_BH.DOCACTION_Reverse_Accrual)) {
					log.severe("Could not reverse payment with ID " + payment.get_ID() + ", please investigate");
					return;
				}
			}
			payment.saveEx();
			newPayment.saveEx();
			newPayment.setDocAction(MPayment_BH.DOCACTION_Complete);
			if (!newPayment.processIt(MPayment_BH.DOCACTION_Complete)) {
				log.severe("Could not complete new payment from reversed payment with ID " + payment.get_ID() +
						", please investigate");
				return;
			}
			newPayment.saveEx();
		}
	}

	/**
	 * Try to reverse the invoice and, if it's paid, the allocation
	 *
	 * @param invoice The invoice to work with
	 * @return Whether all operations were successful
	 */
	private boolean reverseInvoiceAndHandleAnyAutoCreatedPayments(MInvoice invoice) {
		// If we're reversing a cash invoice, it should try to auto-create a payment (which we don't want)
		boolean reverseAutoCreatedPayments = invoice.getPaymentRule().equals(MInvoice_BH.PAYMENTRULE_Cash);
		invoice.setDocAction(MInvoice_BH.DOCACTION_Reverse_Accrual);
		boolean wasInvoiceReversalSuccessful = invoice.processIt(MInvoice_BH.DOCACTION_Reverse_Accrual);

		if (reverseAutoCreatedPayments) {
			MInvoice reversalInvoice = (MInvoice) invoice.getReversal();
			List<MPayment_BH> autoCreatedPayments =
					new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Invoice_ID + "=?",
							get_TrxName()).setParameters(reversalInvoice.get_ID()).list();
			List<MPayment_BH> paymentsWithAmounts =
					autoCreatedPayments.stream().filter(payment -> payment.getPayAmt().signum() != 0)
							.collect(Collectors.toList());
			for (MPayment_BH payment : paymentsWithAmounts) {
				payment.setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
				if (!payment.processIt(MPayment_BH.DOCACTION_Reverse_Accrual)) {
					log.severe("Could not reverse auto-created payment with ID " + payment.get_ID() + ". Please investigate");
				}
			}
		}

		return wasInvoiceReversalSuccessful;
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
		order.setC_DocTypeTarget_ID(documentType.get_ID());

		long orderStart = System.currentTimeMillis();
		order.setDocAction(MOrder_BH.DOCACTION_Complete);
		order.processIt(MOrder_BH.DOCACTION_Complete);
		order.saveEx();
		log.warning("Time spent processing SO (secs): " + (System.currentTimeMillis() - orderStart) / 1000);
	}

	/**
	 * Re-open an order, then re-complete it using {@link #completeOrder(MOrder_BH)}. This method is typically meant to
	 * be used when there was an error processing the invoice. However, if the order has no lines, the order will either
	 * be deleted or voided.
	 *
	 * @param order The order to re-open & re-complete
	 */
	private void tryToReopenAndReCompleteOrder(MOrder_BH order) {
		// If the order doesn't have any lines, try to delete it
		if (order.getLines().length == 0) {
			try {
				order.deleteEx(true);
			} catch (Exception ex) {
				log.severe("Couldn't delete order " + order.get_ID() + " even though it has no lines. Voiding...");
				order.setDocAction(MOrder_BH.DOCACTION_Void);
				order.processIt(MOrder_BH.DOCACTION_Void);
				order.saveEx();
			}
			return;
		}

		order.setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		order.processIt(MOrder_BH.DOCACTION_Re_Activate);
		order.saveEx();

		// Make sure all order lines don't have any quantity delivered, or else shipment creation might fail
		// Also reset quantity invoices
		boolean didAlreadyFetchOrderLines = false;
		if (Arrays.stream(order.getLines(true, null))
				.anyMatch(orderLine -> orderLine.getQtyDelivered().compareTo(BigDecimal.ZERO) != 0)) {
			// We need to take care of some shipments (they should all either be reversed or voided)
			List<MInOut> shipmentsToFix = Arrays.stream(order.getShipments()).filter(
					shipment -> !shipment.getDocStatus().equals(MInOut.STATUS_Voided) &&
							!shipment.getDocStatus().equals(MInOut.STATUS_Reversed)).collect(Collectors.toList());

			// Remove the shipments
			for (MInOut shipmentToFix : shipmentsToFix) {
				if (shipmentToFix.getDocStatus().equals(MInOut.STATUS_Completed) ||
						shipmentToFix.getDocStatus().equals(MInOut.STATUS_Closed)) {
					shipmentToFix.setDocAction(MInOut.DOCACTION_Reverse_Accrual);
					if (shipmentToFix.processIt(MInOut.DOCACTION_Reverse_Accrual)) {
						continue;
					}
					log.warning("Could not reverse shipment, trying to void it...");
				}
				shipmentToFix.setDocAction(MInOut.DOCACTION_Void);
				if (!shipmentToFix.processIt(MInOut.DOCACTION_Void)) {
					log.severe("Could not void shipment. This may cause problems later. Please investigate");
				}
			}

			// Since the invoice gets generated from the shipment, and the shipment is only re-generated if nothing has yet
			// been delivered (which it shouldn't be, if we're re-opening the order and everything is "automatic"), then
			// we need to make sure to update the order lines to show nothing has been delivered
			MOrderLine[] orderLines = order.getLines(true, null);
			didAlreadyFetchOrderLines = true;
			for (MOrderLine orderLine : orderLines) {
				orderLine.setQtyDelivered(BigDecimal.ZERO);
				orderLine.saveEx();
			}
		}
		// Make sure nothing is invoiced
		MOrderLine[] orderLines = order.getLines(!didAlreadyFetchOrderLines, null);
		BigDecimal orderLineTotal = BigDecimal.ZERO;
		for (MOrderLine orderLine : orderLines) {
			orderLine.setQtyInvoiced(BigDecimal.ZERO);
			orderLine.saveEx();
			orderLineTotal = orderLineTotal.add(orderLine.getLineNetAmt());
		}
		// Make sure the order line total matches what's saved to the order
		if (orderLineTotal.compareTo(order.getGrandTotal()) != 0) {
			order.setGrandTotal(orderLineTotal);
			order.setTotalLines(orderLineTotal);
			order.saveEx();
		}

		// Now try to re-complete the order
		completeOrder(order);
	}

	/**
	 * This gets a where clause that will fetch all payments that could be associated with a visit from the payment
	 * directly or through an allocation line/invoice indirectly.
	 *
	 * @param visitIds   The visit IDs to filter by
	 * @param parameters A list of parameters to add values to
	 * @return A WHERE clause to pass to the DB
	 */
	private String getPaymentWhereClause(Set<Integer> visitIds, List<Object> parameters) {
		String paymentWhereClause = MPayment_BH.COLUMNNAME_DocStatus + " NOT IN (?,?)";
		parameters.add(MInvoice_BH.DOCSTATUS_Reversed);
		parameters.add(MInvoice_BH.DOCSTATUS_Voided);
		return paymentWhereClause + " AND (" + MPayment_BH.COLUMNNAME_BH_Visit_ID + " IN (" +
				QueryUtil.getWhereClauseAndSetParametersForSet(visitIds, parameters) + ") OR " +
				MPayment_BH.COLUMNNAME_C_Payment_ID + " IN (SELECT " + MAllocationLine.COLUMNNAME_C_Payment_ID + " FROM " +
				MAllocationLine.Table_Name + " WHERE " + MAllocationLine.COLUMNNAME_C_Invoice_ID + " IN (SELECT " +
				MInvoice_BH.COLUMNNAME_C_Invoice_ID + " FROM " + MInvoice_BH.Table_Name + " WHERE " +
				MInvoice_BH.COLUMNNAME_C_Order_ID + " IN (" +
				QueryUtil.getWhereClauseAndSetParametersForSet(visitIds, parameters) + "))))";
	}
}
