package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MWithholding;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_WithholdingInput extends MWithholding implements I_C_WithholdingInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBenefici;
	private ForeignEntityInput mC_PaymentTerm;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_WithholdingInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MWithholding(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Beneficiary.
	 *
	 * @param Benefici Business Partner to whom payment is made
	 */
	@JsonProperty("Benefici")
	public void setBeneficiInput(ForeignEntityInput Benefici) {
		this.mBenefici = Benefici;
		MBPartner_BH foreignEntity;
		if (Benefici != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(Benefici.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBeneficiary(foreignEntity.get_ID());
		} else {
			super.setBeneficiary(0);
		}
	}

	/**
	 * Get Beneficiary.
	 *
	 * @return Business Partner to whom payment is made
	 */
	@JsonProperty("Benefici")
	public ForeignEntityInput Benefici() {
		return mBenefici;
	}

	/**
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			super.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public ForeignEntityInput C_PaymentTerm() {
		return mC_PaymentTerm;
	}
	/**
	 * Set Withholding.
	 *
	 * @param C_Withholding_ID Withholding type defined
	 */

	public void setC_Withholding_ID(int C_Withholding_ID) {
		if (get_ID() == 0) {
			super.setC_Withholding_ID(C_Withholding_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Withholding_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Withholding_UU();
	}
}
