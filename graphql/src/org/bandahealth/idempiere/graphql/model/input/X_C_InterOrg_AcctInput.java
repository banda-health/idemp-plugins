package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_InterOrg_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InterOrg_AcctInput extends X_C_InterOrg_Acct implements I_C_InterOrg_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mIntercompanyDueFrom_A;
	private ForeignEntityInput mIntercompanyDueTo_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InterOrg_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_InterOrg_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_InterOrg_Acct(null, (ResultSet) null, null),
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
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_InterOrg_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (IntercompanyDueFrom_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(IntercompanyDueFrom_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIntercompanyDueFrom_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + IntercompanyDueFrom_A.getUUID());
			}
		} else {
			this.setIntercompanyDueFrom_Acct(0);
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
		if (IntercompanyDueTo_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(IntercompanyDueTo_A.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIntercompanyDueTo_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + IntercompanyDueTo_A.getUUID());
			}
		} else {
			this.setIntercompanyDueTo_Acct(0);
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
