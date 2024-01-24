package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_Concept_Category;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_Concept_CategoryInput extends X_HR_Concept_Category implements I_HR_Concept_CategoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Concept_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_Concept_CategoryInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Concept_Category(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Payroll Concept Account.
	 *
	 * @param HR_Concept_A Payroll Concept Account
	 */
	@JsonProperty("HR_Concept_A")
	public void setHR_Concept_AInput(ForeignEntityInput HR_Concept_A) {
		this.mHR_Concept_A = HR_Concept_A;
		MAccount foreignEntity;
		if (HR_Concept_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(HR_Concept_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Concept_Acct(foreignEntity.get_ID());
		} else {
			super.setHR_Concept_Acct(0);
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

	public void setHR_Concept_Category_ID(int HR_Concept_Category_ID) {
		if (get_ID() == 0) {
			super.setHR_Concept_Category_ID(HR_Concept_Category_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Concept_Category_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Concept_Category_UU();
	}
}
