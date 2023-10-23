package org.bandahealth.idempiere.report.test.utils;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateVO;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.compiere.model.Query;

public class EntityUtils {
	/**
	 * Donors are business partners, though they have a distantly associated charge as well. This gets both that match
	 * our standards and sets them on the value object.
	 */
	public static void getBandaHealthDonorAndAssociatedCharge(ChuBoePopulateVO valueObject) {
		// Get the appropriate BP group
		MBPGroup_BH donorBusinessPartnerGroup = new Query(valueObject.getContext(), MBPGroup_BH.Table_Name,
				MBPGroup_BH.COLUMNNAME_BH_SubType + "=? AND " + MBPGroup_BH.COLUMNNAME_Name + "=?",
				valueObject.getTransactionName()).setParameters(MBPGroup_BH.BH_SUBTYPE_Donation, MBPGroup_BH.NAME_Donors)
				.setClient_ID()
				.first();
		if (donorBusinessPartnerGroup == null) {
			donorBusinessPartnerGroup = new MBPGroup_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			donorBusinessPartnerGroup.setName(MBPGroup_BH.NAME_Donors);
			donorBusinessPartnerGroup.setBH_SubType(MBPGroup_BH.BH_SUBTYPE_Donation);
			donorBusinessPartnerGroup.saveEx();
		}

		// Make a random BP and assign it to the group
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBPGroup(donorBusinessPartnerGroup);
		valueObject.getBusinessPartner().saveEx();

		// Now create the charge that is used for donors
		MChargeType_BH nonPatientPaymentChargeType =
				new Query(valueObject.getContext(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters(MChargeType_BH.CHARGETYPENAME_NON_PATIENT_PAYMENT)
						.setClient_ID().first();
		if (nonPatientPaymentChargeType == null) {
			nonPatientPaymentChargeType = new MChargeType_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			nonPatientPaymentChargeType.setName(MChargeType_BH.CHARGETYPENAME_NON_PATIENT_PAYMENT);
			nonPatientPaymentChargeType.saveEx();
		}

		MCharge_BH donorCharge = new Query(valueObject.getContext(), MCharge_BH.Table_Name,
				MCharge_BH.COLUMNNAME_Name + "=? AND " + MCharge_BH.COLUMNNAME_C_ChargeType_ID + "=?",
				valueObject.getTransactionName()).setParameters(MCharge_BH.NAME_AccountsReceivable_Donations,
						nonPatientPaymentChargeType.getC_ChargeType_ID()).setClient_ID()
				.first();
		if (donorCharge == null) {
			donorCharge = new MCharge_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			donorCharge.setName(MCharge_BH.NAME_AccountsReceivable_Donations);
			donorCharge.setC_ChargeType_ID(nonPatientPaymentChargeType.getC_ChargeType_ID());
			donorCharge.setBH_SubType(MCharge_BH.BH_SUBTYPE_Donation);
			donorCharge.saveEx();
		}

		valueObject.setCharge(donorCharge);
	}
}
