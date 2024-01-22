package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MFactReconciliation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_Fact_ReconciliationInput extends MFactReconciliation implements I_Fact_ReconciliationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mFact_Acct;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_Fact_ReconciliationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MFactReconciliation(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && Account != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAccount_ID(foreignEntity.get_ID());
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
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
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
		MFactAcct foreignEntity;
		if (get_ID() == 0 && Fact_Acct != null &&
				(foreignEntity = new Query(getCtx(), "Fact_Acct", "Fact_Acct_UU=?", get_TrxName())
						.setParameters(Fact_Acct.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setFact_Acct_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setFact_Reconciliation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getFact_Reconciliation_UU();
	}
}
