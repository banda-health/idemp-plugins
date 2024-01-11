package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.MWithholding;
import org.compiere.model.Query;
import org.compiere.model.X_C_Withholding_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_Withholding_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Withholding_AcctInput extends X_C_Withholding_Acct implements I_C_Withholding_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Withholding;
	private ForeignEntityInput mWithholding_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_Withholding_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_Withholding_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
		setC_Withholding_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MWithholding foreignEntity;
		if (get_ID() == 0 && C_Withholding != null &&
				(foreignEntity = new Query(getCtx(), "C_Withholding", "C_Withholding_UU=?", get_TrxName())
						.setParameters(C_Withholding.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Withholding_ID(foreignEntity.get_ID());
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
		MAccount foreignEntity;
		if (Withholding_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(Withholding_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWithholding_Acct(foreignEntity.get_ID());
		} else {
			super.setWithholding_Acct(0);
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
