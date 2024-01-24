package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Vendor_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Vendor_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_Vendor_AcctInput extends X_C_BP_Vendor_Acct implements I_C_BP_Vendor_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mV_Liability_A;
	private ForeignEntityInput mV_Liability_Services_A;
	private ForeignEntityInput mV_Prepayment_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BP_Vendor_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_Vendor_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_BP_Vendor_Acct(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BP_Vendor_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_BP_Vendor_Acct_UU();
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
		if (get_ID() == 0 && C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
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
	 * Set Vendor Liability.
	 *
	 * @param V_Liability_A Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public void setV_Liability_AInput(ForeignEntityInput V_Liability_A) {
		this.mV_Liability_A = V_Liability_A;
		MAccount foreignEntity;
		if (V_Liability_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Liability_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setV_Liability_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Liability_A.getUUID());
			}
		} else {
			super.setV_Liability_Acct(0);
		}
	}

	/**
	 * Get Vendor Liability.
	 *
	 * @return Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public ForeignEntityInput V_Liability_A() {
		return mV_Liability_A;
	}

	/**
	 * Set Vendor Service Liability.
	 *
	 * @param V_Liability_Services_A Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public void setV_Liability_Services_AInput(ForeignEntityInput V_Liability_Services_A) {
		this.mV_Liability_Services_A = V_Liability_Services_A;
		MAccount foreignEntity;
		if (V_Liability_Services_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Liability_Services_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setV_Liability_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Liability_Services_A.getUUID());
			}
		} else {
			super.setV_Liability_Services_Acct(0);
		}
	}

	/**
	 * Get Vendor Service Liability.
	 *
	 * @return Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public ForeignEntityInput V_Liability_Services_A() {
		return mV_Liability_Services_A;
	}

	/**
	 * Set Vendor Prepayment.
	 *
	 * @param V_Prepayment_A Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public void setV_Prepayment_AInput(ForeignEntityInput V_Prepayment_A) {
		this.mV_Prepayment_A = V_Prepayment_A;
		MAccount foreignEntity;
		if (V_Prepayment_A != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(V_Prepayment_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setV_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + V_Prepayment_A.getUUID());
			}
		} else {
			super.setV_Prepayment_Acct(0);
		}
	}

	/**
	 * Get Vendor Prepayment.
	 *
	 * @return Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public ForeignEntityInput V_Prepayment_A() {
		return mV_Prepayment_A;
	}
}
