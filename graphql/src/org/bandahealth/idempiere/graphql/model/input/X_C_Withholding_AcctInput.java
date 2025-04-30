package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MWithholding;
import org.compiere.model.Query;
import org.compiere.model.X_C_Withholding_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Withholding_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Withholding_AcctInput extends X_C_Withholding_Acct implements I_C_Withholding_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Withholding;
	private ForeignEntityInput mWithholding_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Withholding_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Withholding_AcctInput(@JsonProperty("UU") String UU) {
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (!is_new()) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Withholding_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Withholding_Acct_UU();
	}

	/**
	 * Set Withholding.
	 *
	 * @param C_Withholding Withholding type defined
	 */
	@JsonProperty("C_Withholding")
	public void setC_WithholdingInput(ForeignEntityInput C_Withholding) {
		this.mC_Withholding = C_Withholding;
		if (!is_new()) {
			return;
		}
		if (C_Withholding != null) {
			// Since an entity was passed, make sure it's in the DB
			MWithholding foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Withholding", "C_Withholding_UU=?", get_TrxName())
							.setParameters(C_Withholding.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Withholding_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Withholding with UU " + C_Withholding.getUU());
			}
		} else {
			this.setC_Withholding_ID(0);
		}
	}

	/**
	 * Get Withholding.
	 *
	 * @return Withholding type defined
	 */
	@JsonProperty("C_Withholding")
	public ForeignEntityInput C_Withholding() {
		return mC_Withholding;
	}

	/**
	 * Set Withholding.
	 *
	 * @param Withholding_A Account for Withholdings
	 */
	@JsonProperty("Withholding_A")
	public void setWithholding_AInput(ForeignEntityInput Withholding_A) {
		this.mWithholding_A = Withholding_A;
		if (Withholding_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(Withholding_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setWithholding_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + Withholding_A.getUU());
			}
		} else {
			this.setWithholding_Acct(0);
		}
	}

	/**
	 * Get Withholding.
	 *
	 * @return Account for Withholdings
	 */
	@JsonProperty("Withholding_A")
	public ForeignEntityInput Withholding_A() {
		return mWithholding_A;
	}
}
