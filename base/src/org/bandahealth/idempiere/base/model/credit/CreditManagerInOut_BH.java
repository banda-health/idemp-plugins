package org.bandahealth.idempiere.base.model.credit;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.compiere.model.I_C_Order;
import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.math.BigDecimal;

public class CreditManagerInOut_BH implements ICreditManager {
	private final MInOut inOut;

	/**
	 * InOut Credit Manager Load Constructor
	 *
	 * @param po MInOut
	 */
	public CreditManagerInOut_BH(MInOut po) {
		this.inOut = po;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		// If the inout has a visit, exit out early
		if (inOut.get_ValueAsInt(MInOut_BH.COLUMNNAME_BH_Visit_ID) > 0) {
			return new CreditStatus(null, false);
		}
		return originalCreditManagerCheck(docAction);
	}

	/**
	 * This is copied from {@link CreditManagerInOut#checkCreditStatus} (ideally we could extend from that class and
	 * just do a super call, but currently adempiere base doesn't export the package)
	 *
	 * @param docAction
	 * @return
	 */
	private CreditStatus originalCreditManagerCheck(String docAction) {
		String errorMsg = null;
		if (MInOut.DOCACTION_Prepare.equals(docAction) && inOut.isSOTrx() && !inOut.isReversal() &&
				!inOut.isCustomerReturn()) {
			I_C_Order order = inOut.getC_Order();
			if (order != null
					&& MDocType.DOCSUBTYPESO_PrepayOrder.equals(order.getC_DocType().getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true, inOut.getAD_Client_ID(),
					inOut.getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				MBPartner bp = new MBPartner(inOut.getCtx(), inOut.getC_BPartner_ID(), inOut.get_TrxName());
				if (MBPartner.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
				if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus())) {
					errorMsg = "@BPartnerCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
							+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
				}
				if (!MBPartner.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())
						&& Env.ZERO.compareTo(bp.getSO_CreditLimit()) != 0) {
					BigDecimal notInvoicedAmt = MBPartner.getNotInvoicedAmt(inOut.getC_BPartner_ID());
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(notInvoicedAmt))) {
						errorMsg = "@BPartnerOverSCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @NotInvoicedAmt@=" + notInvoicedAmt
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}
				}
			}
		}

		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	}
}
