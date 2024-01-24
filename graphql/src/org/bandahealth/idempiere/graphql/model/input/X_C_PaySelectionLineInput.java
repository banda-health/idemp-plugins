package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySelection;
import org.compiere.model.MPaySelectionCheck;
import org.compiere.model.MPaySelectionLine;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionLineInput extends MPaySelectionLine implements I_C_PaySelectionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_PaySelection;
	private ForeignEntityInput mC_PaySelectionCheck;
	private I_AD_Ref_ListInput mPaymentRule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PaySelectionLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPaySelectionLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			super.setC_Invoice_ID(0);
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
		MPaySelection foreignEntity;
		if (get_ID() == 0 && C_PaySelection != null &&
				(foreignEntity = new Query(getCtx(), "C_PaySelection", "C_PaySelection_UU=?", get_TrxName())
						.setParameters(C_PaySelection.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaySelection_ID(foreignEntity.get_ID());
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
		MPaySelectionCheck foreignEntity;
		if (C_PaySelectionCheck != null &&
				(foreignEntity = new Query(getCtx(), "C_PaySelectionCheck", "C_PaySelectionCheck_UU=?", get_TrxName())
						.setParameters(C_PaySelectionCheck.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaySelectionCheck_ID(foreignEntity.get_ID());
		} else {
			super.setC_PaySelectionCheck_ID(0);
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

	public void setC_PaySelectionLine_ID(int C_PaySelectionLine_ID) {
		if (get_ID() == 0) {
			super.setC_PaySelectionLine_ID(C_PaySelectionLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_PaySelectionLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_PaySelectionLine_UU();
	}
	/**
	 * Set Difference.
	 *
	 * @param DifferenceAmt Difference Amount
	 */

	public void setDifferenceAmt(BigDecimal DifferenceAmt) {
		if (get_ID() == 0) {
			super.setDifferenceAmt(DifferenceAmt);
		}
	}
	/**
	 * Set Discount Amount.
	 *
	 * @param DiscountAmt Calculated amount of discount
	 */

	public void setDiscountAmt(BigDecimal DiscountAmt) {
		if (get_ID() == 0) {
			super.setDiscountAmt(DiscountAmt);
		}
	}
	/**
	 * Set Open Amount.
	 *
	 * @param OpenAmt Open item amount
	 */

	public void setOpenAmt(BigDecimal OpenAmt) {
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
	/**
	 * Set Write-off Amount.
	 *
	 * @param WriteOffAmt Amount to write-off
	 */

	public void setWriteOffAmt(BigDecimal WriteOffAmt) {
		if (get_ID() == 0) {
			super.setWriteOffAmt(WriteOffAmt);
		}
	}
}
