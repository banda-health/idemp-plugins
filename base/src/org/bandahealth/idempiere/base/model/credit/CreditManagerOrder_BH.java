package org.bandahealth.idempiere.base.model.credit;

import org.adempiere.base.CreditStatus;
import org.adempiere.base.ICreditManager;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.MConversionRate;
import org.compiere.model.MDocType;
import org.compiere.model.MOrder;
import org.compiere.model.MSysConfig;
import org.compiere.util.Util;

import java.math.BigDecimal;
import java.util.Properties;

public class CreditManagerOrder_BH implements ICreditManager {

	private final MOrder order;

	/**
	 * Order Credit Manager Load Constructor
	 *
	 * @param order MOrder_BH
	 */
	public CreditManagerOrder_BH(MOrder order) {
		this.order = order;
	}

	@Override
	public CreditStatus checkCreditStatus(String docAction) {
		// If the order has a visit, exit out early
		if (order.get_ValueAsInt(MOrder_BH.COLUMNNAME_BH_Visit_ID) > 0) {
			return new CreditStatus(null, false);
		}
		return originalCreditManagerCheck(docAction);
	}

	/**
	 * This is copied from {@link CreditManagerOrder#checkCreditStatus} (ideally we could extend from that class and just
	 * do a super call, but currently adempiere base doesn't export the package)
	 *
	 * @param docAction
	 * @return
	 */
	private CreditStatus originalCreditManagerCheck(String docAction) {
		String errorMsg = null;
		if (MOrder.DOCACTION_Prepare.equals(docAction) && order.isSOTrx()) {
			Properties ctx = order.getCtx();
			MDocType dt = MDocType.get(ctx, order.getC_DocTypeTarget_ID());
			if (MDocType.DOCSUBTYPESO_POSOrder.equals(dt.getDocSubTypeSO())
					&& MOrder.PAYMENTRULE_Cash.equals(order.getPaymentRule())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_CASH_POS_ORDER, true, order.getAD_Client_ID(),
					order.getAD_Org_ID())) {
				// ignore -- don't validate for Cash POS Orders depending on sysconfig parameter
			} else if (MDocType.DOCSUBTYPESO_PrepayOrder.equals(dt.getDocSubTypeSO())
					&& !MSysConfig.getBooleanValue(MSysConfig.CHECK_CREDIT_ON_PREPAY_ORDER, true, order.getAD_Client_ID(),
					order.getAD_Org_ID())) {
				// ignore -- don't validate Prepay Orders depending on sysconfig parameter
			} else {
				// bill bp is guaranteed on beforeSave
				MBPartner bp = new MBPartner(ctx, order.getBill_BPartner_ID(), order.get_TrxName());
				// IDEMPIERE-365 - just check credit if is going to increase the debt
				if (order.getGrandTotal().signum() > 0) {
					if (MBPartner.SOCREDITSTATUS_CreditStop.equals(bp.getSOCreditStatus())) {
						errorMsg = "@BPartnerCreditStop@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus())) {
						errorMsg = "@BPartnerCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}

					BigDecimal grandTotal = MConversionRate.convertBase(ctx, order.getGrandTotal(), order.getC_Currency_ID(),
							order.getDateOrdered(), order.getC_ConversionType_ID(),
							order.getAD_Client_ID(), order.getAD_Org_ID());
					if (MBPartner.SOCREDITSTATUS_CreditHold.equals(bp.getSOCreditStatus(grandTotal))) {
						errorMsg = "@BPartnerOverOCreditHold@ - @TotalOpenBalance@=" + bp.getTotalOpenBalance()
								+ ", @GrandTotal@=" + grandTotal
								+ ", @SO_CreditLimit@=" + bp.getSO_CreditLimit();
					}
				}
			}
		}
		return new CreditStatus(errorMsg, !Util.isEmpty(errorMsg));
	}
}
