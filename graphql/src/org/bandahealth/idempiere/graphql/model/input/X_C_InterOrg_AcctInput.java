package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_InterOrg_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InterOrg_AcctInput extends X_C_InterOrg_Acct implements I_C_InterOrg_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mIntercompanyDueFrom_A;
	private ForeignEntityInput mIntercompanyDueTo_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_InterOrg_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_InterOrg_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_InterOrg_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_InterOrg_Acct_UU();
	}

	/**
	 * Set Intercompany Due From Acct.
	 *
	 * @param IntercompanyDueFrom_A Intercompany Due From / Receivables Account
	 */
	@JsonProperty("IntercompanyDueFrom_A")
	public void setIntercompanyDueFrom_AInput(ForeignEntityInput IntercompanyDueFrom_A) {
		this.mIntercompanyDueFrom_A = IntercompanyDueFrom_A;
		MAccount foreignEntity;
		if (IntercompanyDueFrom_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(IntercompanyDueFrom_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIntercompanyDueFrom_Acct(foreignEntity.get_ID());
		} else {
			super.setIntercompanyDueFrom_Acct(0);
		}
	}

	/**
	 * Get Intercompany Due From Acct.
	 *
	 * @return Intercompany Due From / Receivables Account
	 */
	@JsonProperty("IntercompanyDueFrom_A")
	public ForeignEntityInput IntercompanyDueFrom_A() {
		return mIntercompanyDueFrom_A;
	}

	/**
	 * Set Intercompany Due To Acct.
	 *
	 * @param IntercompanyDueTo_A Intercompany Due To / Payable Account
	 */
	@JsonProperty("IntercompanyDueTo_A")
	public void setIntercompanyDueTo_AInput(ForeignEntityInput IntercompanyDueTo_A) {
		this.mIntercompanyDueTo_A = IntercompanyDueTo_A;
		MAccount foreignEntity;
		if (IntercompanyDueTo_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(IntercompanyDueTo_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIntercompanyDueTo_Acct(foreignEntity.get_ID());
		} else {
			super.setIntercompanyDueTo_Acct(0);
		}
	}

	/**
	 * Get Intercompany Due To Acct.
	 *
	 * @return Intercompany Due To / Payable Account
	 */
	@JsonProperty("IntercompanyDueTo_A")
	public ForeignEntityInput IntercompanyDueTo_A() {
		return mIntercompanyDueTo_A;
	}
}
