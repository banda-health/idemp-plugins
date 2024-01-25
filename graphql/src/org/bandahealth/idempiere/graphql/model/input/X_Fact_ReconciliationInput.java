package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MFactReconciliation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_ReconciliationInput extends MFactReconciliation implements I_Fact_ReconciliationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mFact_Acct;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The Fact_Reconciliation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_Fact_ReconciliationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MFactReconciliation(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + Account.getUUID());
			}
		} else {
			this.setAccount_ID(0);
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
	 * Set Accounted Amount.
	 *
	 * @param AmtAcct Amount Balance in Currency of Accounting Schema
	 */

	public void setAmtAcct(BigDecimal AmtAcct) {
		if (get_ID() == 0) {
			super.setAmtAcct(AmtAcct);
		}
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
		if (get_ID() != 0) {
			return;
		}
		if (Fact_Acct != null) {
			// Since an entity was passed, make sure it's in the DB
			MFactAcct foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
							.setParameters(Fact_Acct.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	/**
	 * Set Accounting Fact Reconciliation.
	 *
	 * @param Fact_Reconciliation_ID Accounting Fact Reconciliation
	 */

	public void setFact_Reconciliation_ID(int Fact_Reconciliation_ID) {
		if (get_ID() == 0) {
			super.setFact_Reconciliation_ID(Fact_Reconciliation_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setFact_Reconciliation_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getFact_Reconciliation_UU();
	}
}
