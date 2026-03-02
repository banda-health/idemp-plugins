package org.bandahealth.idempiere.base.model;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MOrder;
import org.compiere.model.MPayment;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class MPayment_BH extends MPayment {

	/**
	 * Bill Waiver = B
	 */
	public static final String TENDERTYPE_BillWaiver = "B";
	/**
	 * Linda Mama = i
	 */
	public static final String TENDERTYPE_LindaMama = "i";
	/**
	 * MPesa = M
	 */
	public static final String TENDERTYPE_MPesa = "M";
	/**
	 * M-Tiba = L
	 */
	public static final String TENDERTYPE_MTiba = "L";
	/**
	 * NHIF = N
	 */
	public static final String TENDERTYPE_NHIF = "N";

	/** Load Meta Data */

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";
	public static final String COLUMNNAME_BH_TENDER_AMOUNT = "BH_tender_amount";
	/**
	 * Column name BH_Visit_ID
	 */
	public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";

	/**
	 * Column name Scheduled
	 */
	public static final String COLUMNNAME_Scheduled = "Scheduled";

	/**
	 * Column name BH_Original_C_Invoice_ID
	 */
	public static final String COLUMNNAME_BH_Original_C_Invoice_ID = "BH_Original_C_Invoice_ID";

	private static final long serialVersionUID = 1L;

	public MPayment_BH(Properties ctx, String C_Payment_UU, String trxName) {
		super(ctx, C_Payment_UU, trxName);
	}

	public MPayment_BH(Properties ctx, int C_Payment_ID, String trxName) {
		super(ctx, C_Payment_ID, trxName);
	}

	public MPayment_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	@Override
	public boolean allocateIt() {
		// If this is assigned to a visit, we'll allocate against the invoice
		MAllocationHdr allocationHeader = new MAllocationHdr(getCtx(), false, getDateTrx(), getC_Currency_ID(),
				Msg.translate(getCtx(), "C_Payment_ID") + ": " + getDocumentNo(), get_TrxName());
		allocationHeader.setAD_Org_ID(getAD_Org_ID());
		if (getBH_Visit_ID() > 0) {
			// Get the invoice amount
			List<MOrder_BH> orders = new Query(getCtx(), MOrder_BH.Table_Name,
					MOrder_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " +
							MOrder_BH.COLUMNNAME_C_BPartner_ID + "=?", get_TrxName()).setParameters(getBH_Visit_ID(), true,
					getC_BPartner_ID()).list();
			if (orders.stream().noneMatch(MOrder::isComplete)) {
				get_Logger().severe("No orders are complete - can't allocate against any of their invoices");
				return false;
			}
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
					orders.stream().filter(MOrder_BH::isComplete).map(MOrder_BH::get_ID).collect(Collectors.toSet()),
					parameters);
			List<MInvoice_BH> invoices =
					new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + " IN (" + whereClause + ")",
							get_TrxName()).setParameters(parameters).list();
			List<MInvoice_BH> unpaidInvoices = invoices.stream()
					.filter(invoice -> (DOCSTATUS_Completed.equals(invoice.getDocStatus()) ||
							DOCSTATUS_Closed.equals(invoice.getDocStatus()) && !invoice.isPaid()))
					.collect(Collectors.toList());
			if (unpaidInvoices.isEmpty()) {
				get_Logger().severe("Invoices aren't complete or are paid for all orders - can't allocate against them");
				return false;
			}
			allocationHeader.saveEx();
			// Sometimes (weirdly) the invoice date is ahead of the current date acct => update the date to use to match it
			Timestamp allocationDateToUse = getDateAcct();
			BigDecimal remainingPaymentAmount = getPayAmt();
			for (MInvoice_BH invoice : unpaidInvoices) {
				if (remainingPaymentAmount.compareTo(BigDecimal.ZERO) <= 0) {
					break;
				}
				if (invoice.getDateAcct().compareTo(allocationDateToUse) > 0) {
					allocationDateToUse = invoice.getDateAcct();
				}
				BigDecimal amountToPay = invoice.getGrandTotal();
				// If the invoiced amount is greater than the payment, only allocate what was paid
				if (amountToPay.compareTo(remainingPaymentAmount) > 0) {
					amountToPay = remainingPaymentAmount;
				}
				MAllocationLine allocationLine =
						new MAllocationLine(allocationHeader, amountToPay, Env.ZERO, Env.ZERO, Env.ZERO);
				allocationLine.setDocInfo(getC_BPartner_ID(), 0, getC_Invoice_ID());
				allocationLine.setC_Payment_ID(getC_Payment_ID());
				allocationLine.setC_Invoice_ID(invoice.get_ID());
				allocationLine.saveEx(get_TrxName());
				remainingPaymentAmount = remainingPaymentAmount.subtract(amountToPay);
			}
			allocationHeader.setDateAcct(allocationDateToUse);
			if (!allocationHeader.processIt(DocAction.ACTION_Complete)) {
				throw new AdempiereException(
						Msg.getMsg(getCtx(), "FailedProcessingDocument") + " - " + allocationHeader.getProcessMsg());
			}
			allocationHeader.saveEx();
			return true;
		}
		// If this is a receipt and the invoice is empty, start allocating against the oldest, unpaid invoice
		if (getC_Invoice_ID() == 0) {
			List<MInvoice_BH> unpaidInvoices = new Query(getCtx(), MInvoice_BH.Table_Name,
					MInvoice_BH.COLUMNNAME_C_BPartner_ID + "=? AND " + MInvoice_BH.COLUMNNAME_DocStatus + "=? AND " +
							MInvoice_BH.COLUMNNAME_IsPaid + "=? AND " + MInvoice_BH.COLUMNNAME_IsSOTrx + "=?",
					get_TrxName()).setParameters(getC_BPartner_ID(), MInvoice_BH.DOCSTATUS_Completed, "N", isReceipt())
					.setOrderBy(MInvoice_BH.COLUMNNAME_Created + " ASC").list();
			if (!unpaidInvoices.isEmpty()) {
				allocationHeader.saveEx();
				BigDecimal remainingPayment = getPayAmt();
				for (MInvoice_BH unpaidInvoice : unpaidInvoices) {
					if (remainingPayment.signum() <= 0) {
						remainingPayment = BigDecimal.ZERO;
						break;
					}
					// Since we're emulating what's done on the Payment Allocation, set the date acct as whatever is the latest
					allocationHeader.setDateAcct(
							unpaidInvoice.getDateAcct().compareTo(getDateAcct()) > 0 ? unpaidInvoice.getDateAcct() : getDateAcct());
					// Get the amount remaining to allocate on this invoice
					BigDecimal payAmount = unpaidInvoice.getGrandTotal()
							.subtract(unpaidInvoice.getAllocatedAmt() == null ? BigDecimal.ZERO : unpaidInvoice.getAllocatedAmt());
					// If this invoice is greater than what's remaining, just use the amount remaining for allocation
					if (payAmount.compareTo(remainingPayment) > 0) {
						payAmount = remainingPayment;
					}
					// Negate it if this is AP
					MAllocationLine allocationLine =
							new MAllocationLine(allocationHeader, isReceipt() ? payAmount : payAmount.negate(), Env.ZERO, Env.ZERO,
									Env.ZERO);
					allocationLine.setDocInfo(getC_BPartner_ID(), 0, getC_Invoice_ID());
					allocationLine.setC_Payment_ID(getC_Payment_ID());
					allocationLine.setC_Invoice_ID(unpaidInvoice.get_ID());
					allocationLine.saveEx(get_TrxName());
					remainingPayment = remainingPayment.subtract(payAmount);
				}
				if (!allocationHeader.processIt(DocAction.ACTION_Complete)) {
					throw new AdempiereException(
							Msg.getMsg(getCtx(), "FailedProcessingDocument") + " - " + allocationHeader.getProcessMsg());
				}
				allocationHeader.saveEx();
				// Since a payment could have been made for more than owed (i.e. as for insurances), update the total open
				// balance
				MBPartner_BH businessPartner = new MBPartner_BH(getCtx(), getC_BPartner_ID(), get_TrxName());
				BigDecimal newBalance = businessPartner.getTotalOpenBalance();
				if (newBalance == null) {
					newBalance = Env.ZERO;
				}
				newBalance = isReceipt() ? newBalance.subtract(remainingPayment) : newBalance.add(remainingPayment);

				businessPartner.setTotalOpenBalance(newBalance);
				businessPartner.setSOCreditStatus();
				businessPartner.saveEx();
				return true;
			}
		}
		// Otherwise, pass it up
		allocationHeader.delete(true);
		return super.allocateIt();
	}

	/**
	 * Copy the payment, typically meant to be done when a visit is reactivated and all old payments are reversed.
	 * Largely copied from {@link MPayment#createCounterDoc()}
	 *
	 * @return The new, unsaved payment
	 */
	public MPayment_BH copy() {
		MPayment_BH newPayment = new MPayment_BH(getCtx(), 0, get_TrxName());

		//	Document Type
		int C_DocTypeTarget_ID = getC_DocType_ID();

		//	Deep Copy
		newPayment.setAD_Org_ID(getAD_Org_ID());
		newPayment.setC_BPartner_ID(getC_BPartner_ID());
		newPayment.setIsReceipt(!isReceipt());
		newPayment.setC_DocType_ID(C_DocTypeTarget_ID);
		newPayment.setTrxType(getTrxType());
		newPayment.setTenderType(getTenderType());
		//
		newPayment.setPayAmt(getPayAmt());
		newPayment.setDiscountAmt(getDiscountAmt());
		newPayment.setTaxAmt(getTaxAmt());
		newPayment.setWriteOffAmt(getWriteOffAmt());
		newPayment.setIsOverUnderPayment(isOverUnderPayment());
		newPayment.setOverUnderAmt(getOverUnderAmt());
		newPayment.setC_Currency_ID(getC_Currency_ID());
		newPayment.setC_ConversionType_ID(getC_ConversionType_ID());
		//
		newPayment.setDateTrx(getDateTrx());
		newPayment.setDateAcct(getDateAcct());
		//
		newPayment.setC_BankAccount_ID(getC_BankAccount_ID());

		//	References
		newPayment.setC_Activity_ID(getC_Activity_ID());
		newPayment.setC_Campaign_ID(getC_Campaign_ID());
		newPayment.setC_Project_ID(getC_Project_ID());
		newPayment.setUser1_ID(getUser1_ID());
		newPayment.setUser2_ID(getUser2_ID());

		// Banda-specific fields
		newPayment.setBH_Visit_ID(getBH_Visit_ID());
		newPayment.setBH_tender_amount(getBH_tender_amount());

		newPayment.saveEx(get_TrxName());
		if (log.isLoggable(Level.FINE)) {
			log.fine(newPayment.toString());
		}

		// Document action typically set to complete, even though we may not be completing it yet
		newPayment.setDocAction(DOCACTION_None);

		return newPayment;
	}

	public BigDecimal getBH_tender_amount() {
		return (BigDecimal) get_Value(COLUMNNAME_BH_TENDER_AMOUNT);
	}

	public void setBH_tender_amount(BigDecimal amount) {
		set_Value(COLUMNNAME_BH_TENDER_AMOUNT, amount);
	}

	public I_BH_Visit getBH_Visit() throws RuntimeException {
		return (I_BH_Visit) MTable.get(getCtx(), I_BH_Visit.Table_Name)
				.getPO(getBH_Visit_ID(), get_TrxName());
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (BH_Visit_ID < 1)
			set_Value(COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value(COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
		return get_Value(COLUMNNAME_BH_NavButtons);
	}

	/**
	 * Set Scheduled.
	 *
	 * @param Scheduled Whether the entity was scheduled or not
	 */
	public void setScheduled(boolean Scheduled) {
		set_Value(COLUMNNAME_Scheduled, Boolean.valueOf(Scheduled));
	}

	/**
	 * Get Scheduled.
	 *
	 * @return Whether the entity was scheduled or not
	 */
	public boolean isScheduled() {
		Object oo = get_Value(COLUMNNAME_Scheduled);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	public org.compiere.model.I_C_Invoice getBH_Original_C_Invoice() throws RuntimeException {
		return (org.compiere.model.I_C_Invoice) MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_ID)
				.getPO(getBH_Original_C_Invoice_ID(), get_TrxName());
	}

	/**
	 * Set Original Invoice ID.
	 *
	 * @param BH_Original_C_Invoice_ID Original Invoice ID
	 */
	public void setBH_Original_C_Invoice_ID(int BH_Original_C_Invoice_ID) {
		if (BH_Original_C_Invoice_ID < 1)
			set_Value(COLUMNNAME_BH_Original_C_Invoice_ID, null);
		else
			set_Value(COLUMNNAME_BH_Original_C_Invoice_ID, Integer.valueOf(BH_Original_C_Invoice_ID));
	}

	/**
	 * Get Original Invoice ID.
	 *
	 * @return Original Invoice ID
	 */
	public int getBH_Original_C_Invoice_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Original_C_Invoice_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
