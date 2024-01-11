package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.eevolution.model.X_HR_Contract;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_PayrollInput extends X_HR_Payroll implements I_HR_PayrollInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mHR_Contract;
	private I_AD_Ref_ListInput mPaymentRule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_PayrollInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Payroll(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			super.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Payroll Contract.
	 *
	 * @param HR_Contract Payroll Contract
	 */
	@JsonProperty("HR_Contract")
	public void setHR_ContractInput(ForeignEntityInput HR_Contract) {
		this.mHR_Contract = HR_Contract;
		X_HR_Contract foreignEntity;
		if (HR_Contract != null &&
				(foreignEntity = new Query(getCtx(), "HR_Contract", "HR_Contract_UU=?", get_TrxName())
						.setParameters(HR_Contract.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Contract_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Contract_ID(0);
		}
	}

	/**
	 * Get Payroll Contract.
	 *
	 * @return Payroll Contract
	 */
	@JsonProperty("HR_Contract")
	public ForeignEntityInput HR_Contract() {
		return mHR_Contract;
	}
	/**
	 * Set Payroll.
	 *
	 * @param HR_Payroll_ID Payroll
	 */

	public void setHR_Payroll_ID(int HR_Payroll_ID) {
		if (get_ID() == 0) {
			super.setHR_Payroll_ID(HR_Payroll_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Payroll_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Payroll_UU();
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		MRefList_BH foreignEntity;
		if (PaymentRule != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PaymentRule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPaymentRule(foreignEntity.getValue());
		} else {
			this.setPaymentRule(null);
		}
	}

	/**
	 * Get Payment Rule.
	 *
	 * @return How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public I_AD_Ref_ListInput PaymentRule() {
		return mPaymentRule;
	}
}
