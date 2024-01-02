package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.util.Env;

/**
 * Generated Model for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_BudgetInput extends X_GL_Budget implements I_GL_BudgetInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mBudgetStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_BudgetInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Budget Status.
	 *
	 * @param BudgetStatus Indicates the current status of this budget
	 */
	@JsonProperty("BudgetStatus")
	public void setBudgetStatusInput(I_AD_Ref_ListInput BudgetStatus) {
		this.mBudgetStatus = BudgetStatus;
		MRefList_BH foreignEntity;
		if (BudgetStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BudgetStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBudgetStatus(foreignEntity.getValue());
		} else {
			this.setBudgetStatus(null);
		}
	}

	/**
	 * Get Budget Status.
	 *
	 * @return Indicates the current status of this budget
	 */
	@JsonProperty("BudgetStatus")
	public I_AD_Ref_ListInput BudgetStatus() {
		return mBudgetStatus;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_Budget_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_Budget_UU();
	}
}
