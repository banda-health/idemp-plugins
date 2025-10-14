package org.bandahealth.idempiere.base.model.credit;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MConversionRate;
import org.compiere.model.MDocType;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Util;

public class CreditManagerOrder_BH implements ICreditManager {

	private final MOrder_BH order;
	
	/**
	 * Order Credit Manager Load Constructor
	 * 
	 * @param order MOrder_BH
	 */
	public CreditManagerOrder_BH(MOrder_BH order) {
		this.order = order;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		String errorMsg = null;

		MBPartner_BH bp = new MBPartner_BH(order.getCtx(), order.getBill_BPartner_ID(), order.get_TrxName());

		// check if visit is present
		if (order.getBH_Visit_ID() > 0) {
			if (!MBPartner_BH.SOCREDITSTATUS_NoCreditCheck.equals(bp.getSOCreditStatus())) {
				// confirm that the invoice total is not greater than the payments
				List<MPayment_BH> payments = new Query(order.getCtx(), MPayment_BH.Table_Name,
						MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?", order.get_TrxName())
						.setParameters(order.getBH_Visit_ID()).list();

				BigDecimal totalPaymentAmount = payments.stream().map(MPayment_BH::getPayAmt).reduce(BigDecimal.ZERO,
						BigDecimal::add);

				// Check if total payments cover the order amount
				if (order.getGrandTotal().compareTo(totalPaymentAmount) > 0) {
					errorMsg = "@OrderTotalExceedsPayments@ - @GrandTotal@=" + order.getGrandTotal()
							+ ", @TotalPayments@=" + totalPaymentAmount;
				}
			}

			return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
		}

		// can't extend CreditManagerOrder so copying this here.
		if (MOrder_BH.DOCACTION_Prepare.equals(docAction) && order.isSOTrx()) {
			Properties ctx = order.getCtx();
			MDocType dt = MDocType.get(ctx, order.getC_DocTypeTarget_ID());
			if (MDocType.DOCSUBTYPESO_POSOrder.equals(dt.getDocSubTypeSO())
					&& MOrder_BH.PAYMENTRULE_Cash.equals(order.getPaymentRule())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_CASH_POS_ORDER, true,
							order.getAD_Client_ID(), order.getAD_Org_ID())) {
				// ignore -- don't validate for Cash POS Orders depending on sysconfig parameter
			} else if (MDocType.DOCSUBTYPESO_PrepayOrder.equals(dt.getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true,
							order.getAD_Client_ID(), order.getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				// bill bp is guaranteed on beforeSave
				// IDEMPIERE-365 - just check credit if is going to increase the debt
				if (order.getGrandTotal().signum() > 0) {
					if (MBPartner_BH.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
						errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}
					if (MBPartner_BH.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus())) {
						errorMsg = "@BPartnerCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}

					BigDecimal grandTotal = MConversionRate.convertBase(ctx, order.getGrandTotal(),
							order.getC_Currency_ID(), order.getDateOrdered(), order.getC_ConversionType_ID(),
							order.getAD_Client_ID(), order.getAD_Org_ID());
					if (MBPartner_BH.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(grandTotal))) {
						errorMsg = "@BPartnerOverOCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @GrandTotal@=" + grandTotal + ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}
				}
			}
		}
		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	} // creditCheck

}
