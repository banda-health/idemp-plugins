package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxDeclaration;
import org.compiere.model.MTaxDeclarationLine;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDeclarationLineInput extends MTaxDeclarationLine implements I_C_TaxDeclarationLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AllocationLine;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_Tax;
	private ForeignEntityInput mC_TaxDeclaration;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_TaxDeclarationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxDeclarationLineInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Allocation Line.
	 *
	 * @param C_AllocationLine Allocation Line
	 */
	@JsonProperty("C_AllocationLine")
	public void setC_AllocationLineInput(ForeignEntityInput C_AllocationLine) {
		this.mC_AllocationLine = C_AllocationLine;
		if (!is_new()) {
			return;
		}
		if (C_AllocationLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MAllocationLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AllocationLine", "C_AllocationLine_UU=?", get_TrxName())
							.setParameters(C_AllocationLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AllocationLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AllocationLine with UU " + C_AllocationLine.getUU());
			}
		} else {
			this.setC_AllocationLine_ID(0);
		}
	}

	/**
	 * Get Allocation Line.
	 *
	 * @return Allocation Line
	 */
	@JsonProperty("C_AllocationLine")
	public ForeignEntityInput C_AllocationLine() {
		return mC_AllocationLine;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (!is_new()) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (!is_new()) {
			return;
		}
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
			}
		} else {
			this.setC_Currency_ID(0);
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (!is_new()) {
			return;
		}
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
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		if (!is_new()) {
			return;
		}
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UU " + C_InvoiceLine.getUU());
			}
		} else {
			this.setC_InvoiceLine_ID(0);
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
	}

	/**
	 * Set Tax Declaration.
	 *
	 * @param C_TaxDeclaration Define the declaration to the tax authorities
	 */
	@JsonProperty("C_TaxDeclaration")
	public void setC_TaxDeclarationInput(ForeignEntityInput C_TaxDeclaration) {
		this.mC_TaxDeclaration = C_TaxDeclaration;
		if (!is_new()) {
			return;
		}
		if (C_TaxDeclaration != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxDeclaration foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxDeclaration", "C_TaxDeclaration_UU=?", get_TrxName())
							.setParameters(C_TaxDeclaration.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_TaxDeclaration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxDeclaration with UU " + C_TaxDeclaration.getUU());
			}
		} else {
			this.setC_TaxDeclaration_ID(0);
		}
	}

	/**
	 * Get Tax Declaration.
	 *
	 * @return Define the declaration to the tax authorities
	 */
	@JsonProperty("C_TaxDeclaration")
	public ForeignEntityInput C_TaxDeclaration() {
		return mC_TaxDeclaration;
	}
	/**
	 * Set Tax Declaration Line.
	 *
	 * @param C_TaxDeclarationLine_ID Tax Declaration Document Information
	 */
	@JsonProperty("C_TaxDeclarationLine_ID")
	public void setC_TaxDeclarationLine_IDFromJson(int C_TaxDeclarationLine_ID) {
		if (get_ID() == 0) {
			super.setC_TaxDeclarationLine_ID(C_TaxDeclarationLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_TaxDeclarationLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_TaxDeclarationLine_UU();
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		if (!is_new()) {
			return;
		}
		if (C_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UU " + C_Tax.getUU());
			}
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}
	/**
	 * Set Account Date.
	 *
	 * @param DateAcct Accounting Date
	 */
	@JsonProperty("DateAcct")
	public void setDateAcctFromJson(Timestamp DateAcct) {
		if (get_ID() == 0) {
			super.setDateAcct(DateAcct);
		}
	}
	/**
	 * Set Manual.
	 *
	 * @param IsManual This is a manual process
	 */
	@JsonProperty("IsManual")
	public void setIsManualFromJson(boolean IsManual) {
		if (get_ID() == 0) {
			super.setIsManual(IsManual);
		}
	}
	/**
	 * Set Tax Amount.
	 *
	 * @param TaxAmt Tax Amount for a document
	 */
	@JsonProperty("TaxAmt")
	public void setTaxAmtFromJson(BigDecimal TaxAmt) {
		if (get_ID() == 0) {
			super.setTaxAmt(TaxAmt);
		}
	}
	/**
	 * Set Tax base Amount.
	 *
	 * @param TaxBaseAmt Base for calculating the tax amount
	 */
	@JsonProperty("TaxBaseAmt")
	public void setTaxBaseAmtFromJson(BigDecimal TaxBaseAmt) {
		if (get_ID() == 0) {
			super.setTaxBaseAmt(TaxBaseAmt);
		}
	}
}
