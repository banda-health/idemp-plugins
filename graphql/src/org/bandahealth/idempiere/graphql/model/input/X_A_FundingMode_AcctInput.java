package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_FundingMode;
import org.compiere.model.X_A_FundingMode_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_FundingMode_AcctInput extends X_A_FundingMode_Acct implements I_A_FundingMode_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_FundingMode;
	private ForeignEntityInput mA_FundingMode_A;
	private ForeignEntityInput mC_AcctSchema;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_FundingMode_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_FundingMode_AcctInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_A_FundingMode_Acct(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Funding Mode Account.
	 *
	 * @param A_FundingMode_A Funding Mode Account
	 */
	@JsonProperty("A_FundingMode_A")
	public void setA_FundingMode_AInput(ForeignEntityInput A_FundingMode_A) {
		this.mA_FundingMode_A = A_FundingMode_A;
		if (A_FundingMode_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(A_FundingMode_A.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_FundingMode_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UUID " + A_FundingMode_A.getUUID());
			}
		} else {
			this.setA_FundingMode_Acct(0);
		}
	}

	/**
	 * Get Funding Mode Account.
	 *
	 * @return Funding Mode Account
	 */
	@JsonProperty("A_FundingMode_A")
	public ForeignEntityInput A_FundingMode_A() {
		return mA_FundingMode_A;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_FundingMode_Acct_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_FundingMode_Acct_UU();
	}

	/**
	 * Set Asset Funding Mode.
	 *
	 * @param A_FundingMode Asset Funding Mode
	 */
	@JsonProperty("A_FundingMode")
	public void setA_FundingModeInput(ForeignEntityInput A_FundingMode) {
		this.mA_FundingMode = A_FundingMode;
		if (get_ID() != 0) {
			return;
		}
		if (A_FundingMode != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_FundingMode foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_FundingMode", "A_FundingMode_UU=?", get_TrxName())
							.setParameters(A_FundingMode.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_FundingMode_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_FundingMode with UUID " + A_FundingMode.getUUID());
			}
		} else {
			this.setA_FundingMode_ID(0);
		}
	}

	/**
	 * Get Asset Funding Mode.
	 *
	 * @return Asset Funding Mode
	 */
	@JsonProperty("A_FundingMode")
	public ForeignEntityInput A_FundingMode() {
		return mA_FundingMode;
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
}
