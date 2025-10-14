package org.bandahealth.idempiere.base.model.credit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionRateUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MDocType;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Util;

public class CreditManagerInvoice_BH implements ICreditManager {

	/** Logger */
	protected transient CLogger log = CLogger.getCLogger(CreditManagerInvoice_BH.class);

	private final MInvoice_BH mInvoice;

	/**
	 * Invoice Credit Manager Load Constructor
	 * 
	 * @param po MInvoice
	 */
	public CreditManagerInvoice_BH(MInvoice_BH po) {
		this.mInvoice = po;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		String errorMsg = null;

		MBPartner_BH bp = new MBPartner_BH(mInvoice.getCtx(), mInvoice.getC_BPartner_ID(), mInvoice.get_TrxName());
		// check if the invoice contains a visit
		if (mInvoice.getBH_Visit_ID() > 0) {
			if (!MBPartner_BH.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())) {
				// confirm that the invoice total is not greater than the payments
				List<MPayment_BH> payments = new Query(mInvoice.getCtx(), MPayment_BH.Table_Name,
						MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?", mInvoice.get_TrxName())
						.setParameters(mInvoice.getBH_Visit_ID()).list();

				BigDecimal totalPaymentAmount = payments.stream().map(MPayment_BH::getPayAmt).reduce(BigDecimal.ZERO,
						BigDecimal::add);

				// Check if total payments cover the order amount
				if (mInvoice.getGrandTotal().compareTo(totalPaymentAmount) > 0) {
					errorMsg = "@InvoiceTotalExceedsPayments@ - @GrandTotal@=" + mInvoice.getGrandTotal()
							+ ", @TotalPayments@=" + totalPaymentAmount;
				}
			}
		} else if (MInvoice_BH.DOCACTION_Prepare.equals(docAction) && mInvoice.isSOTrx()) {
			MDocType doc = (MDocType) mInvoice.getC_DocTypeTarget();
			// IDEMPIERE-365 - just check credit if is going to increase the debt
			if ((doc.getDocBaseType().equals(MDocType.DOCBASETYPE_ARCreditMemo)
					&& mInvoice.getGrandTotal().signum() < 0)
					|| (doc.getDocBaseType().equals(MDocType.DOCBASETYPE_ARInvoice)
							&& mInvoice.getGrandTotal().signum() > 0)) {
				if (MBPartner_BH.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
			}
		}

		if (MInvoice_BH.DOCACTION_Complete.equals(docAction)) {
			// POS supports multiple payments
			boolean fromPOS = false;
			if (mInvoice.getC_Order_ID() > 0) {
				fromPOS = mInvoice.getC_Order().getC_POS_ID() > 0;
			}
			// Update BP Statistics

			DB.getDatabase().forUpdate(bp, 0);
			// Update total revenue and balance / credit limit (reversed on
			// AllocationLine.processIt)
			BigDecimal invAmt = null;
			int baseCurrencyId = Env.getContextAsInt(mInvoice.getCtx(), Env.C_CURRENCY_ID);
			if (mInvoice.getC_Currency_ID() != baseCurrencyId && mInvoice.isOverrideCurrencyRate()) {
				invAmt = mInvoice.getGrandTotal(true).multiply(mInvoice.getCurrencyRate());
				int stdPrecision = MCurrency.getStdPrecision(mInvoice.getCtx(), baseCurrencyId);
				if (invAmt.scale() > stdPrecision)
					invAmt = invAmt.setScale(stdPrecision, RoundingMode.HALF_UP);
			} else {
				invAmt = MConversionRate.convertBase(mInvoice.getCtx(), mInvoice.getGrandTotal(true), // CM adjusted
						mInvoice.getC_Currency_ID(), mInvoice.getDateAcct(), mInvoice.getC_ConversionType_ID(),
						mInvoice.getAD_Client_ID(), mInvoice.getAD_Org_ID());
			}
			if (invAmt == null) {
				errorMsg = MConversionRateUtil.getErrorMessage(mInvoice.getCtx(),
						"ErrorConvertingCurrencyToBaseCurrency", mInvoice.getC_Currency_ID(),
						MClient.get(mInvoice.getCtx()).getC_Currency_ID(), mInvoice.getC_ConversionType_ID(),
						mInvoice.getDateAcct(), mInvoice.get_TrxName());
			}
			// Total Balance
			BigDecimal newBalance = bp.getTotalOpenBalance();
			if (newBalance == null)
				newBalance = Env.ZERO;
			if (mInvoice.isSOTrx()) {
				newBalance = newBalance.add(invAmt);
				//
				if (bp.getFirstSale() == null)
					bp.setFirstSale(mInvoice.getDateInvoiced());

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
					log.fine("GrandTotal=" + mInvoice.getGrandTotal(true) + "(" + invAmt + ") BP Life="
							+ bp.getActualLifeTimeValue() + "->" + newLifeAmt + ", Credit=" + bp.getSO_CreditUsed()
							+ "->" + newCreditAmt + ", Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
				bp.setActualLifeTimeValue(newLifeAmt);
				bp.setSO_CreditUsed(newCreditAmt);
			} // SO
			else {
				newBalance = newBalance.subtract(invAmt);
				if (log.isLoggable(Level.FINE))
					log.fine("GrandTotal=" + mInvoice.getGrandTotal(true) + "(" + invAmt + ") Balance="
							+ bp.getTotalOpenBalance() + " -> " + newBalance);
			}
			// the payment just created already updated the open balance
			if (!(MInvoice_BH.PAYMENTRULE_Cash.equals(mInvoice.getPaymentRule()) && !fromPOS)) {
				bp.setTotalOpenBalance(newBalance);
			}
			bp.setSOCreditStatus();
			if (!bp.save(mInvoice.get_TrxName())) {
				errorMsg = "Could not update Business Partner";
			}
		}
		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	} // creditCheck
}
