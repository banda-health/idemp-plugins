package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PaySelectionLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySelection;
import org.compiere.model.MPaySelectionCheck;
import org.compiere.model.MPaySelectionLine;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaySelectionLineInput extends MPaySelectionLine implements I_C_PaySelectionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_PaySelection;
	private ForeignEntityInput mC_PaySelectionCheck;
	private ForeignEntityInput mPaymentRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_PaySelectionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaySelectionLineInput(@JsonProperty("UU") String UU) {
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UU " + C_Invoice.getUU());
			}
		} else {
			this.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Payment Selection.
	 *
	 * @param C_PaySelection Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public void setC_PaySelectionInput(ForeignEntityInput C_PaySelection) {
		this.mC_PaySelection = C_PaySelection;
		if (get_ID() != 0) {
			return;
		}
		if (C_PaySelection != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySelection foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySelection", "C_PaySelection_UU=?", get_TrxName())
							.setParameters(C_PaySelection.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_PaySelection_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySelection with UU " + C_PaySelection.getUU());
			}
		} else {
			this.setC_PaySelection_ID(0);
		}
	}

	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public ForeignEntityInput C_PaySelection() {
		return mC_PaySelection;
	}

	/**
	 * Set Pay Selection Check.
	 *
	 * @param C_PaySelectionCheck Payment Selection Check
	 */
	@JsonProperty("C_PaySelectionCheck")
	public void setC_PaySelectionCheckInput(ForeignEntityInput C_PaySelectionCheck) {
		this.mC_PaySelectionCheck = C_PaySelectionCheck;
		if (C_PaySelectionCheck != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySelectionCheck foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySelectionCheck", "C_PaySelectionCheck_UU=?", get_TrxName())
							.setParameters(C_PaySelectionCheck.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_PaySelectionCheck_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySelectionCheck with UU " + C_PaySelectionCheck.getUU());
			}
		} else {
			this.setC_PaySelectionCheck_ID(0);
		}
	}

	/**
	 * Get Pay Selection Check.
	 *
	 * @return Payment Selection Check
	 */
	@JsonProperty("C_PaySelectionCheck")
	public ForeignEntityInput C_PaySelectionCheck() {
		return mC_PaySelectionCheck;
	}
	/**
	 * Set Payment Selection Line.
	 *
	 * @param C_PaySelectionLine_ID Payment Selection Line
	 */
	@JsonProperty("C_PaySelectionLine_ID")
	public void setC_PaySelectionLine_IDFromJson(int C_PaySelectionLine_ID) {
		if (get_ID() == 0) {
			super.setC_PaySelectionLine_ID(C_PaySelectionLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_PaySelectionLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_PaySelectionLine_UU();
	}
	/**
	 * Set Difference.
	 *
	 * @param DifferenceAmt Difference Amount
	 */
	@JsonProperty("DifferenceAmt")
	public void setDifferenceAmtFromJson(BigDecimal DifferenceAmt) {
		if (get_ID() == 0) {
			super.setDifferenceAmt(DifferenceAmt);
		}
	}
	/**
	 * Set Discount Amount.
	 *
	 * @param DiscountAmt Calculated amount of discount
	 */
	@JsonProperty("DiscountAmt")
	public void setDiscountAmtFromJson(BigDecimal DiscountAmt) {
		if (get_ID() == 0) {
			super.setDiscountAmt(DiscountAmt);
		}
	}
	/**
	 * Set Open Amount.
	 *
	 * @param OpenAmt Open item amount
	 */
	@JsonProperty("OpenAmt")
	public void setOpenAmtFromJson(BigDecimal OpenAmt) {
		if (get_ID() == 0) {
			super.setOpenAmt(OpenAmt);
		}
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
			if (!X_C_PaySelectionLineResolver.PAYMENTRULE_UUIDS_BY_VALUE.containsValue(PaymentRule.getUU())) {
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
	/**
	 * Set Write-off Amount.
	 *
	 * @param WriteOffAmt Amount to write-off
	 */
	@JsonProperty("WriteOffAmt")
	public void setWriteOffAmtFromJson(BigDecimal WriteOffAmt) {
		if (get_ID() == 0) {
			super.setWriteOffAmt(WriteOffAmt);
		}
	}
}
