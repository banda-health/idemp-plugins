package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BudgetStatus_RL;

	/**
	 * Standard constructor
	 */
	public X_GL_BudgetInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Budget Status.
	 *
	 * @param BudgetStatus_RL Indicates the current status of this budget
	 */
	public void setBudgetStatus_RL(I_AD_Ref_ListInput BudgetStatus_RL) {
		this.BudgetStatus_RL = BudgetStatus_RL;
		MRefList foreignEntity;
		if (BudgetStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BudgetStatus_RL.getID())
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
	public I_AD_Ref_ListInput getBudgetStatus_RL() {
		return BudgetStatus_RL;
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
