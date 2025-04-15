package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Concept_Category;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_Concept_CategoryInput extends X_HR_Concept_Category implements I_HR_Concept_CategoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Concept_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_Concept_Category_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_Concept_CategoryInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Payroll Concept Account.
	 *
	 * @param HR_Concept_A Payroll Concept Account
	 */
	@JsonProperty("HR_Concept_A")
	public void setHR_Concept_AInput(ForeignEntityInput HR_Concept_A) {
		this.mHR_Concept_A = HR_Concept_A;
		if (HR_Concept_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(HR_Concept_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setHR_Concept_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + HR_Concept_A.getUU());
			}
		} else {
			this.setHR_Concept_Acct(0);
		}
	}

	/**
	 * Get Payroll Concept Account.
	 *
	 * @return Payroll Concept Account
	 */
	@JsonProperty("HR_Concept_A")
	public ForeignEntityInput HR_Concept_A() {
		return mHR_Concept_A;
	}
	/**
	 * Set Payroll Concept Category.
	 *
	 * @param HR_Concept_Category_ID Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category_ID")
	public void setHR_Concept_Category_IDFromJson(int HR_Concept_Category_ID) {
		if (get_ID() == 0) {
			super.setHR_Concept_Category_ID(HR_Concept_Category_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_Concept_Category_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_Concept_Category_UU();
	}
}
