package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MFactAcct;
import org.compiere.model.MOrg;
import org.compiere.model.MTaxDeclaration;
import org.compiere.model.MTaxDeclarationAcct;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDeclarationAcctInput extends MTaxDeclarationAcct implements I_C_TaxDeclarationAcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
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
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
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
							.setParameters(C_TaxDeclaration.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Accounting Fact.
	 *
	 * @param Fact_Acct Accounting Fact
	 */
	@JsonProperty("Fact_Acct")
	public void setFact_AcctInput(ForeignEntityInput Fact_Acct) {
		this.mFact_Acct = Fact_Acct;
		if (get_ID() != 0) {
			return;
		}
		if (Fact_Acct != null) {
			// Since an entity was passed, make sure it's in the DB
			MFactAcct foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
							.setParameters(Fact_Acct.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFact_Acct_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table Fact_Acct with UUID " + Fact_Acct.getUUID());
			}
		} else {
			this.setFact_Acct_ID(0);
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
