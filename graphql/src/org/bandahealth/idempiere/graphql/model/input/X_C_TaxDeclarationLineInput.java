package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAllocationLine;
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
 * @version Release 8.2 - $Id$
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
	 * @param UUID The C_TaxDeclarationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxDeclarationLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTaxDeclarationLine(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Allocation Line.
	 *
	 * @param C_AllocationLine Allocation Line
	 */
	@JsonProperty("C_AllocationLine")
	public void setC_AllocationLineInput(ForeignEntityInput C_AllocationLine) {
		this.mC_AllocationLine = C_AllocationLine;
		if (get_ID() != 0) {
			return;
		}
		if (C_AllocationLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MAllocationLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AllocationLine", "C_AllocationLine_UU=?", get_TrxName())
							.setParameters(C_AllocationLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AllocationLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AllocationLine with UUID " + C_AllocationLine.getUUID());
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (get_ID() != 0) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (get_ID() != 0) {
			return;
		}
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
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
		if (get_ID() != 0) {
			return;
		}
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UUID " + C_InvoiceLine.getUUID());
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
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		if (get_ID() != 0) {
			return;
		}
		if (C_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UUID " + C_Tax.getUUID());
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
	 * Set Tax Declaration.
	 *
	 * @param C_TaxDeclaration Define the declaration to the tax authorities
	 */
	@JsonProperty("C_TaxDeclaration")
	public void setC_TaxDeclarationInput(ForeignEntityInput C_TaxDeclaration) {
		this.mC_TaxDeclaration = C_TaxDeclaration;
		if (get_ID() != 0) {
			return;
		}
		if (C_TaxDeclaration != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxDeclaration foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxDeclaration", "C_TaxDeclaration_UU=?", get_TrxName())
							.setParameters(C_TaxDeclaration.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_TaxDeclaration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxDeclaration with UUID " + C_TaxDeclaration.getUUID());
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

	public void setC_TaxDeclarationLine_ID(int C_TaxDeclarationLine_ID) {
		if (get_ID() == 0) {
			super.setC_TaxDeclarationLine_ID(C_TaxDeclarationLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_TaxDeclarationLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_TaxDeclarationLine_UU();
	}
	/**
	 * Set Account Date.
	 *
	 * @param DateAcct Accounting Date
	 */

	public void setDateAcct(Timestamp DateAcct) {
		if (get_ID() == 0) {
			super.setDateAcct(DateAcct);
		}
	}
	/**
	 * Set Manual.
	 *
	 * @param IsManual This is a manual process
	 */

	public void setIsManual(boolean IsManual) {
		if (get_ID() == 0) {
			super.setIsManual(IsManual);
		}
	}
	/**
	 * Set Tax Amount.
	 *
	 * @param TaxAmt Tax Amount for a document
	 */

	public void setTaxAmt(BigDecimal TaxAmt) {
		if (get_ID() == 0) {
			super.setTaxAmt(TaxAmt);
		}
	}
	/**
	 * Set Tax base Amount.
	 *
	 * @param TaxBaseAmt Base for calculating the tax amount
	 */

	public void setTaxBaseAmt(BigDecimal TaxBaseAmt) {
		if (get_ID() == 0) {
			super.setTaxBaseAmt(TaxBaseAmt);
		}
	}
}
