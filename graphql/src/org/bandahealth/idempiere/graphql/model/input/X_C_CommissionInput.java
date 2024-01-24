package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCommission;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CommissionInput extends MCommission implements I_C_CommissionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mC_Currency;
	private I_AD_Ref_ListInput mDocBasisType;
	private I_AD_Ref_ListInput mFrequencyType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CommissionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCommission(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
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
	 * Set Commission.
	 *
	 * @param C_Commission_ID Commission
	 */

	public void setC_Commission_ID(int C_Commission_ID) {
		if (get_ID() == 0) {
			super.setC_Commission_ID(C_Commission_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Commission_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Commission_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}
	/**
	 * Set Date last run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */

	public void setDateLastRun(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}

	/**
	 * Set Calculation Basis.
	 *
	 * @param DocBasisType Basis for the calculation the commission
	 */
	@JsonProperty("DocBasisType")
	public void setDocBasisTypeInput(I_AD_Ref_ListInput DocBasisType) {
		this.mDocBasisType = DocBasisType;
		MRefList_BH foreignEntity;
		if (DocBasisType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocBasisType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocBasisType(foreignEntity.getValue());
		} else {
			this.setDocBasisType(null);
		}
	}

	/**
	 * Get Calculation Basis.
	 *
	 * @return Basis for the calculation the commission
	 */
	@JsonProperty("DocBasisType")
	public I_AD_Ref_ListInput DocBasisType() {
		return mDocBasisType;
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		MRefList_BH foreignEntity;
		if (FrequencyType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FrequencyType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFrequencyType(foreignEntity.getValue());
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public I_AD_Ref_ListInput FrequencyType() {
		return mFrequencyType;
	}
}
