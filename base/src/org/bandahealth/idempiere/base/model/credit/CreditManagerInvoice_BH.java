package org.bandahealth.idempiere.base.model.credit;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionRateUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;

public class CreditManagerInvoice_BH implements ICreditManager {

	/**
	 * Logger
	 */
	private final transient CLogger log = CLogger.getCLogger(CreditManagerInvoice_BH.class);

	private final MInvoice invoice;

	/**
	 * Invoice Credit Manager Load Constructor
	 *
	 * @param po MInvoice
	 */
	public CreditManagerInvoice_BH(MInvoice po) {
		this.invoice = po;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		// If the invoice has a visit, exit out early
		var visitId = invoice.get_ValueAsInt(MInvoice_BH.COLUMNNAME_BH_Visit_ID);
		if (visitId > 0) {
			String errorMsg = null;
			if (MInvoice.DOCACTION_Complete.equals(docAction)) {
				// Confirm this invoice is for the visit's patient
				var visit = new MBHVisit(invoice.getCtx(), visitId, invoice.get_TrxName());
				if (invoice.getC_BPartner_ID() == visit.getPatient_ID() &&
						MBPartner_BH.SOCREDITSTATUS_CreditStop.equalsIgnoreCase(invoice.getC_BPartner().getSOCreditStatus())) {
					// Now we need to confirm that all the payments entered pay for the whole invoice
					List<MPayment_BH> invoicesPayments =
							new Query(invoice.getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_Original_C_Invoice_ID +
									"=?", invoice.get_TrxName()).setParameters(invoice.getC_Invoice_ID()).list();
					var totalPaymentAmount =
							invoicesPayments.stream().map(MPayment_BH::getPayAmt).reduce(BigDecimal.ZERO, BigDecimal::add);
					if (invoice.getGrandTotal().compareTo(totalPaymentAmount) > 0) {
						return new CreditStatus("@InvoiceTotalExceedsPayments@ - @GrandTotal@=" + invoice.getGrandTotal()
								+ ", @TotalPayments@=" + totalPaymentAmount, true);
					}
				}
				//
				// Copied from iDempiere's code
				//
				// POS supports multiple payments
				boolean fromPOS = false;
				if (invoice.getC_Order_ID() > 0) {
					fromPOS = invoice.getC_Order().getC_POS_ID() > 0;
				}
				// Update BP Statistics
				MBPartner bp = new MBPartner(invoice.getCtx(), invoice.getC_BPartner_ID(), invoice.get_TrxName());
				DB.getDatabase().forUpdate(bp, 0);
				// Update total revenue and balance / credit limit (reversed on
				// AllocationLine.processIt)
				BigDecimal invAmt = null;
				int baseCurrencyId = Env.getContextAsInt(invoice.getCtx(), Env.C_CURRENCY_ID);
				if (invoice.getC_Currency_ID() != baseCurrencyId && invoice.isOverrideCurrencyRate()) {
					invAmt = invoice.getGrandTotal(true).multiply(invoice.getCurrencyRate());
					int stdPrecision = MCurrency.getStdPrecision(invoice.getCtx(), baseCurrencyId);
					if (invAmt.scale() > stdPrecision)
						invAmt = invAmt.setScale(stdPrecision, RoundingMode.HALF_UP);
				} else {
					invAmt = MConversionRate.convertBase(invoice.getCtx(),
							invoice.getGrandTotal(true), // CM adjusted
							invoice.getC_Currency_ID(),
							invoice.getDateAcct(),
							invoice.getC_ConversionType_ID(),
							invoice.getAD_Client_ID(),
							invoice.getAD_Org_ID());
				}
				if (invAmt == null) {
					errorMsg = MConversionRateUtil.getErrorMessage(invoice.getCtx(),
							"ErrorConvertingCurrencyToBaseCurrency",
							invoice.getC_Currency_ID(),
							MClient.get(invoice.getCtx()).getC_Currency_ID(),
							invoice.getC_ConversionType_ID(),
							invoice.getDateAcct(),
							invoice.get_TrxName());
				}
				// Total Balance
				BigDecimal newBalance = bp.getTotalOpenBalance();
				if (newBalance == null)
					newBalance = Env.ZERO;
				if (invoice.isSOTrx()) {
					newBalance = newBalance.add(invAmt);
					//
					if (bp.getFirstSale() == null)
						bp.setFirstSale(invoice.getDateInvoiced());

					BigDecimal newLifeAmt = bp.getActualLifeTimeValue();
					if (newLifeAmt == null)
						newLifeAmt = invAmt;
					else
						newLifeAmt = newLifeAmt.add(invAmt);

					BigDecimal newCreditAmt = bp.getSO_CreditUsed();
					if (newCreditAmt == null)
						newCreditAmt = invAmt;
					else
						newCreditAmt = newCreditAmt.add(invAmt);
					//
					if (log.isLoggable(Level.FINE))
						log.fine("GrandTotal=" + invoice.getGrandTotal(true) + "(" + invAmt
								+ ") BP Life=" + bp.getActualLifeTimeValue() + "->" + newLifeAmt
								+ ", Credit=" + bp.getSO_CreditUsed() + "->" + newCreditAmt
								+ ", Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
					bp.setActualLifeTimeValue(newLifeAmt);
					bp.setSO_CreditUsed(newCreditAmt);
				} // SO
				else {
					newBalance = newBalance.subtract(invAmt);
					if (log.isLoggable(Level.FINE))
						log.fine("GrandTotal=" + invoice.getGrandTotal(true) + "(" + invAmt
								+ ") Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
				}
				// the payment just created already updated the open balance
				if (!(MInvoice.PAYMENTRULE_Cash.equals(invoice.getPaymentRule()) && !fromPOS)) {
					bp.setTotalOpenBalance(newBalance);
				}
				bp.setSOCreditStatus();
				if (!bp.save(invoice.get_TrxName())) {
					errorMsg = "Could not update Business Partner";
				}
			}
			return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
		}
		return originalCreditManagerCheck(docAction);
	}

	/**
	 * This is copied from {@link CreditManagerInvoice#checkCreditStatus} (ideally we could extend from that class and
	 * just do a super call, but currently adempiere base doesn't export the package)
	 *
	 * @param docAction
	 * @return
	 */
	private CreditStatus originalCreditManagerCheck(String docAction) {
		String errorMsg = null;
		if (MInvoice.DOCACTION_Prepare.equals(docAction) && invoice.isSOTrx()) {
			MDocType doc = (MDocType) invoice.getC_DocTypeTarget();
			// IDEMPIERE-365 - just check credit if is going to increase the debt
			if ((doc.getDocBaseType().equals(MDocType.DOCBASETYPE_ARCreditMemo) && invoice.getGrandTotal().signum() < 0)
					|| (doc.getDocBaseType().equals(MDocType.DOCBASETYPE_ARInvoice) && invoice.getGrandTotal().signum() > 0)) {
				MBPartner bp = new MBPartner(invoice.getCtx(), invoice.getC_BPartner_ID(), invoice.get_TrxName());
				if (MBPartner.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
			}
		} else if (MInvoice.DOCACTION_Complete.equals(docAction)) {
			// POS supports multiple payments
			boolean fromPOS = false;
			if (invoice.getC_Order_ID() > 0) {
				fromPOS = invoice.getC_Order().getC_POS_ID() > 0;
			}
			// Update BP Statistics
			MBPartner bp = new MBPartner(invoice.getCtx(), invoice.getC_BPartner_ID(), invoice.get_TrxName());
			DB.getDatabase().forUpdate(bp, 0);
			// Update total revenue and balance / credit limit (reversed on
			// AllocationLine.processIt)
			BigDecimal invAmt = null;
			int baseCurrencyId = Env.getContextAsInt(invoice.getCtx(), Env.C_CURRENCY_ID);
			if (invoice.getC_Currency_ID() != baseCurrencyId && invoice.isOverrideCurrencyRate()) {
				invAmt = invoice.getGrandTotal(true).multiply(invoice.getCurrencyRate());
				int stdPrecision = MCurrency.getStdPrecision(invoice.getCtx(), baseCurrencyId);
				if (invAmt.scale() > stdPrecision)
					invAmt = invAmt.setScale(stdPrecision, RoundingMode.HALF_UP);
			} else {
				invAmt = MConversionRate.convertBase(invoice.getCtx(),
						invoice.getGrandTotal(true), // CM adjusted
						invoice.getC_Currency_ID(),
						invoice.getDateAcct(),
						invoice.getC_ConversionType_ID(),
						invoice.getAD_Client_ID(),
						invoice.getAD_Org_ID());
			}
			if (invAmt == null) {
				errorMsg = MConversionRateUtil.getErrorMessage(invoice.getCtx(),
						"ErrorConvertingCurrencyToBaseCurrency",
						invoice.getC_Currency_ID(),
						MClient.get(invoice.getCtx()).getC_Currency_ID(),
						invoice.getC_ConversionType_ID(),
						invoice.getDateAcct(),
						invoice.get_TrxName());
			}
			// Total Balance
			BigDecimal newBalance = bp.getTotalOpenBalance();
			if (newBalance == null)
				newBalance = Env.ZERO;
			if (invoice.isSOTrx()) {
				newBalance = newBalance.add(invAmt);
				//
				if (bp.getFirstSale() == null)
					bp.setFirstSale(invoice.getDateInvoiced());

				BigDecimal newLifeAmt = bp.getActualLifeTimeValue();
				if (newLifeAmt == null)
					newLifeAmt = invAmt;
				else
					newLifeAmt = newLifeAmt.add(invAmt);

				BigDecimal newCreditAmt = bp.getSO_CreditUsed();
				if (newCreditAmt == null)
					newCreditAmt = invAmt;
				else
					newCreditAmt = newCreditAmt.add(invAmt);
				//
				if (log.isLoggable(Level.FINE))
					log.fine("GrandTotal=" + invoice.getGrandTotal(true) + "(" + invAmt
							+ ") BP Life=" + bp.getActualLifeTimeValue() + "->" + newLifeAmt
							+ ", Credit=" + bp.getSO_CreditUsed() + "->" + newCreditAmt
							+ ", Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
				bp.setActualLifeTimeValue(newLifeAmt);
				bp.setSO_CreditUsed(newCreditAmt);
			} // SO
			else {
				newBalance = newBalance.subtract(invAmt);
				if (log.isLoggable(Level.FINE))
					log.fine("GrandTotal=" + invoice.getGrandTotal(true) + "(" + invAmt
							+ ") Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
			}
			// the payment just created already updated the open balance
			if (!(MInvoice.PAYMENTRULE_Cash.equals(invoice.getPaymentRule()) && !fromPOS)) {
				bp.setTotalOpenBalance(newBalance);
			}
			bp.setSOCreditStatus();
			if (!bp.save(invoice.get_TrxName())) {
				errorMsg = "Could not update Business Partner";
			}
		}
		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	}
}
