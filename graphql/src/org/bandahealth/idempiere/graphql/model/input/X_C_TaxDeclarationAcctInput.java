package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxDeclaration;
import org.compiere.model.MTaxDeclarationAcct;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationAcctInput extends MTaxDeclarationAcct implements I_C_TaxDeclarationAcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Tax;
	private ForeignEntityInput mC_TaxDeclaration;
	private ForeignEntityInput mFact_Acct;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_TaxDeclarationAcct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxDeclarationAcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTaxDeclarationAcct(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	@JsonProperty("Account")
	public void setAccountInput(ForeignEntityInput Account) {
		this.mAccount = Account;
		MElementValue foreignEntity;
		if (get_ID() == 0 && Account != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + Account.getUUID());
			}
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	@JsonProperty("Account")
	public ForeignEntityInput Account() {
		return mAccount;
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
	 * Set Accounted Credit.
	 *
	 * @param AmtAcctCr Accounted Credit Amount
	 */

	public void setAmtAcctCr(BigDecimal AmtAcctCr) {
		if (get_ID() == 0) {
			super.setAmtAcctCr(AmtAcctCr);
		}
	}
	/**
	 * Set Accounted Debit.
	 *
	 * @param AmtAcctDr Accounted Debit Amount
	 */

	public void setAmtAcctDr(BigDecimal AmtAcctDr) {
		if (get_ID() == 0) {
			super.setAmtAcctDr(AmtAcctDr);
		}
	}
	/**
	 * Set Source Credit.
	 *
	 * @param AmtSourceCr Source Credit Amount
	 */

	public void setAmtSourceCr(BigDecimal AmtSourceCr) {
		if (get_ID() == 0) {
			super.setAmtSourceCr(AmtSourceCr);
		}
	}
	/**
	 * Set Source Debit.
	 *
	 * @param AmtSourceDr Source Debit Amount
	 */

	public void setAmtSourceDr(BigDecimal AmtSourceDr) {
		if (get_ID() == 0) {
			super.setAmtSourceDr(AmtSourceDr);
		}
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (get_ID() == 0 && C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
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
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		MTax foreignEntity;
		if (get_ID() == 0 && C_Tax != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UUID " + C_Tax.getUUID());
			}
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
		MTaxDeclaration foreignEntity;
		if (get_ID() == 0 && C_TaxDeclaration != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxDeclaration", "C_TaxDeclaration_UU=?", get_TrxName())
							.setParameters(C_TaxDeclaration.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_TaxDeclaration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxDeclaration with UUID " + C_TaxDeclaration.getUUID());
			}
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
	 * Set Tax Declaration Accounting.
	 *
	 * @param C_TaxDeclarationAcct_ID Tax Accounting Reconciliation 
	 */

	public void setC_TaxDeclarationAcct_ID(int C_TaxDeclarationAcct_ID) {
		if (get_ID() == 0) {
			super.setC_TaxDeclarationAcct_ID(C_TaxDeclarationAcct_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_TaxDeclarationAcct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_TaxDeclarationAcct_UU();
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
	 * Set Accounting Fact.
	 *
	 * @param Fact_Acct Accounting Fact
	 */
	@JsonProperty("Fact_Acct")
	public void setFact_AcctInput(ForeignEntityInput Fact_Acct) {
		this.mFact_Acct = Fact_Acct;
		MFactAcct foreignEntity;
		if (get_ID() == 0 && Fact_Acct != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
							.setParameters(Fact_Acct.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFact_Acct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table Fact_Acct with UUID " + Fact_Acct.getUUID());
			}
		}
	}

	/**
	 * Get Accounting Fact.
	 *
	 * @return Accounting Fact
	 */
	@JsonProperty("Fact_Acct")
	public ForeignEntityInput Fact_Acct() {
		return mFact_Acct;
	}
}
