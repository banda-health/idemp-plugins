package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_HR_PayrollResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Contract;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_PayrollInput extends X_HR_Payroll implements I_HR_PayrollInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mHR_Contract;
	private ForeignEntityInput mPaymentRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_Payroll_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_PayrollInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormat.getUU());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
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
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + C_Charge.getUU());
			}
		} else {
			this.setC_Charge_ID(0);
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
		if (HR_Contract != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Contract foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Contract", "HR_Contract_UU=?", get_TrxName())
							.setParameters(HR_Contract.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setHR_Contract_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Contract with UU " + HR_Contract.getUU());
			}
		} else {
			this.setHR_Contract_ID(0);
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
	@JsonProperty("HR_Payroll_ID")
	public void setHR_Payroll_IDFromJson(int HR_Payroll_ID) {
		if (get_ID() == 0) {
			super.setHR_Payroll_ID(HR_Payroll_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_Payroll_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_Payroll_UU();
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(ForeignEntityInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		if (PaymentRule != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_HR_PayrollResolver.PAYMENTRULE_UUIDS_BY_VALUE.containsValue(PaymentRule.getUU())) {
				throw new AdempiereException("The reference list UU of " + PaymentRule.getUU() +
						" is not in the list defined for the PaymentRule column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PaymentRule.getUU());
			}
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
	public ForeignEntityInput PaymentRule() {
		return mPaymentRule;
	}
}
