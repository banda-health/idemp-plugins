package org.bandahealth.idempiere.base.model.credit;

import java.math.BigDecimal;
import java.util.List;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.I_C_Order;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Util;

public class CreditManagerInOut_BH implements ICreditManager {
	private final MInOut mInOut;

	/**
	 * InOut Credit Manager Load Constructor
	 * 
	 * @param po MInOut
	 */
	public CreditManagerInOut_BH(MInOut po) {
		this.mInOut = po;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		String errorMsg = null;

		MInOut_BH inout = new Query(mInOut.getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_M_InOut_ID + "=?",
				mInOut.get_TrxName()).setParameters(mInOut.get_ID()).first();

		MBPartner_BH bp = new MBPartner_BH(mInOut.getCtx(), mInOut.getC_BPartner_ID(), mInOut.get_TrxName());

		// check if the invoice contains a visit
		if (MInOut_BH.DOCACTION_Prepare.equals(docAction) && inout.getBH_Visit_ID() > 0) {
			if (!MBPartner_BH.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())) {
				// confirm that the invoice total is not greater than the payments
				List<MPayment_BH> payments = new Query(inout.getCtx(), MPayment_BH.Table_Name,
						MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?", inout.get_TrxName())
						.setParameters(inout.getBH_Visit_ID()).list();

				BigDecimal totalPaymentAmount = payments.stream().map(MPayment_BH::getPayAmt).reduce(BigDecimal.ZERO,
						BigDecimal::add);

				// get the invoice grand total
				MInvoice_BH mInvoice = new Query(inout.getCtx(), MInvoice_BH.Table_Name,
						MInvoice_BH.COLUMNNAME_BH_Visit_ID + "=?", inout.get_TrxName())
						.setParameters(inout.getBH_Visit_ID()).first();

				// Check if total payments cover the order amount
				if (mInvoice != null && mInvoice.getGrandTotal().compareTo(totalPaymentAmount) > 0) {
					errorMsg = "@InvoiceTotalExceedsPayments@ - @GrandTotal@=" + mInvoice.getGrandTotal()
							+ ", @TotalPayments@=" + totalPaymentAmount;
				}
			}

			return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
		}

		// Can't extend CreditManagerInOut, so we've copied the logic over.
		if (MInOut_BH.DOCACTION_Prepare.equals(docAction) && mInOut.isSOTrx() && !mInOut.isReversal()
				&& !mInOut.isCustomerReturn()) {
			I_C_Order order = mInOut.getC_Order();
			if (order != null && MDocType.DOCSUBTYPESO_PrepayOrder.equals(order.getC_DocType().getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true,
							mInOut.getAD_Client_ID(), mInOut.getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				if (MBPartner_BH.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
				if (MBPartner_BH.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
				if (!MBPartner_BH.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())
						&& Env.ZERO.compareTo(bp.getSO_CreditLimit()) != 0) {
					BigDecimal notInvoicedAmt = MBPartner.getNotInvoicedAmt(mInOut.getC_BPartner_ID());
					if (MBPartner_BH.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(notInvoicedAmt))) {
						errorMsg = "@BPartnerOverSCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @NotInvoicedAmt@=" + notInvoicedAmt + ", @SO_CreditLimit@="
								+ bp.getSO_CreditLimit();
					}
				}
			}
		}

		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	} // creditCheck
}
